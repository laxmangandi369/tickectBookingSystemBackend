package com.mb.ticketingsystem.model;

import org.springframework.lang.NonNull;

public class MovieModel {
	@NonNull
	private String name;

	private String description;
	@NonNull
	private String image_url;

	private Long ratingRottenTomatoes;

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

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public Long getRatingRottenTomatoes() {
		return ratingRottenTomatoes;
	}

	public void setRatingRottenTomatoes(Long ratingRottenTomatoes) {
		this.ratingRottenTomatoes = ratingRottenTomatoes;
	}

}
