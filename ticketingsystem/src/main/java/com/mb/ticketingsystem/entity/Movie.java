package com.mb.ticketingsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movies")
public class Movie {

	@Id
	@Column(name = "movieid", nullable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long movieid;

	@Column
	private String name;

	@Column
	private String description;

	@Column
	private String image_url;

	@Column(name = "rottten_tomatos_rating")
	private Long ratingRottenTomatoes;

	@Column
	private String duration;

	@Column
	private Integer price;

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}


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

	public Long getId() {
		return movieid;
	}

}
