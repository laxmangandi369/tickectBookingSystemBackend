package com.mb.ticketingsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.swagger.v3.oas.models.security.SecurityScheme.In;


@Entity
@Table(name = "seats")
public class Seat {
	@Id
	@Column(name="seatid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long seatid;
	
	@Column
	private Integer seatNo;
	
	@Column
	private Boolean isBooked;
	
	@ManyToOne
	@JoinColumn(name="screenId", referencedColumnName = "screenid")
	private Screen screen;
	
	@ManyToOne
	@JoinColumn(name = "showId",referencedColumnName = "showid")
	private ShowDetail showDetail;

	public Integer getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(Integer seatNo) {
		this.seatNo = seatNo;
	}

	public Boolean getIsBooked() {
		return isBooked;
	}

	public void setIsBooked(Boolean isBooked) {
		this.isBooked = isBooked;
	}

	public Screen getScreen() {
		return screen;
	}

	public void setScreen(Screen screen) {
		this.screen = screen;
	}

	public ShowDetail getShowDetail() {
		return showDetail;
	}

	public void setShowDetail(ShowDetail showDetail) {
		this.showDetail = showDetail;
	}

	public Long getSeatId() {
		return seatid;
	}
	
	
}
