package com.mb.ticketingsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="screens")
public class Screen {
	
	@Id
	@Column(name="screenid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long screenid;
	
	@Column
	private String screenName;
	
	@Column
	private Integer totalSeats;
	
	@ManyToOne
	@JoinColumn(name="theater_id", referencedColumnName = "theaterid")
	private Theater theater;

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public Integer getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(Integer totalSeats) {
		this.totalSeats = totalSeats;
	}

	public Theater getTheater() {
		return theater;
	}

	public void setTheater(Theater theater) {
		this.theater = theater;
	}

	public Long getId() {
		return screenid;
	}
	
	
}
