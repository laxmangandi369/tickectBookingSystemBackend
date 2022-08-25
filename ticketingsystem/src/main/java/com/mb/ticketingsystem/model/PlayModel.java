package com.mb.ticketingsystem.model;

import org.springframework.lang.NonNull;

public class PlayModel {
	@NonNull
	private String name;

	private String description;

	private Long ratings;
	@NonNull
	private String image_url;

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	private String duration;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getRatings() {
		return ratings;
	}

	public void setRatings(Long ratings) {
		this.ratings = ratings;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

}
