package com.mb.ticketingsystem.security;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;


public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private UserDetailsServiceImpl detailsServiceImpl;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
			String header = request.getHeader("Authorization");
			
			if(StringUtils.isNotBlank(header) && header.startsWith("Bearer"))
			{
				String authToken = header.replace("Bearer", "");
				Claims claims = jwtTokenUtil.getJwtClaims(authToken);
				
				String userName = claims.getSubject(); 
			
				if(jwtTokenUtil.validateToken(claims))
				{
					UserDetails userDetails = detailsServiceImpl.loadUserByUsername(userName);
					UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
																								userDetails, "", getAuthoritiesFromClaims(claims));
					
					usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					
					SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
				}
			}
			
		filterChain.doFilter(request, response);
	}
	
	private Collection<? extends GrantedAuthority> getAuthoritiesFromClaims(Claims claims)
	{
		return Arrays.stream(claims.get("role").toString().split(","))
				.map(SimpleGrantedAuthority::new).collect(Collectors.toList());
	}

}
