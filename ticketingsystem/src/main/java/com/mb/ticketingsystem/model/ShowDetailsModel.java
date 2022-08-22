package com.mb.ticketingsystem.model;

public class ShowDetailsModel {
	
	
	String screenName;
	
	Long screenid;
	
	String startTime;
	
	String theatreName;
	
	Double price;
	
	Long movieId;
	
	

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public Long getScreenid() {
		return screenid;
	}

	public void setScreenid(Long screenid) {
		this.screenid = screenid;
	}

	public String getTheatreName() {
		return theatreName;
	}

	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}
	
	
}
