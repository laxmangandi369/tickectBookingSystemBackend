package com.mb.ticketingsystem.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import com.mb.ticketingsystem.exception.CustomException;
import com.mb.ticketingsystem.exception.ErrorCode;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;

import static com.mb.ticketingsystem.constants.JwtConstants.SIGNING_KEY;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class JwtTokenUtil {

	@SuppressWarnings("deprecation")
	public Claims getJwtClaims(String jwtToken)
	{
		Claims claims =null;
		
		try {
			claims = Jwts.parser().setSigningKey(SIGNING_KEY).parseClaimsJws(jwtToken).getBody();
		} catch (ExpiredJwtException e) {
			throw new CustomException("token expired", ErrorCode.EXPIRED_TOKEN);
		} catch(SignatureException | MalformedJwtException ex)
		{
			throw new CustomException("Invalid token", ErrorCode.INVALID_TOKEN);
		} catch(Exception ex)
		{
			throw new CustomException("internal server error", ErrorCode.INTERNAL_SERVER_ERROR);
		}
	
		return claims;
	}
	
	public String generateToken(Authentication authentication)
	{
		User user = (User)authentication.getPrincipal();
		
		final List<String> authorities = authentication.getAuthorities().stream().map(GrantedAuthority :: getAuthority).collect(Collectors.toList());
		
		return Jwts.builder().claim("userName", user.getUsername()).claim("aurhority", user.getAuthorities())
				.setSubject(user.getUsername()).setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(new Date(getTokenValidation()))
				.signWith(SignatureAlgorithm.HS512,SIGNING_KEY).compact();
	}
	
	public boolean validateToken(Claims claims)
	{
		return !claims.getExpiration().before(new Date());
	}
	
	private Long getTokenValidation() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, 1);
		
		return calendar.getTimeInMillis();
	}
	
}
