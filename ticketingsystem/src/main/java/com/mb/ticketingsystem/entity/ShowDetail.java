package com.mb.ticketingsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="showDetails")
public class ShowDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "showid")
	private Long showid;
	
	@Column
	private String startTime;
	
	@Column
	private Double price;
	
	@OneToOne
	@JoinColumn(name="screenId", referencedColumnName = "screenid")
	private Screen screen;
	
	@ManyToOne
	@JoinColumn(name="movieId",referencedColumnName = "movieid")
	private Movie movie;

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Screen getScreen() {
		return screen;
	}

	public void setScreen(Screen screen) {
		this.screen = screen;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Long getShowId() {
		return showid;
	}
	
	
}
