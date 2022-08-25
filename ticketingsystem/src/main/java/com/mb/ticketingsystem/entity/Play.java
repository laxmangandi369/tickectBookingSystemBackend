package com.mb.ticketingsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "plays")
public class Play {

	@Id
	@Column(name = "playid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long playId;

	@Column
	private String name;

	@Column
	private String description;

	@Column
	private Long ratings;

	@Column
	private String image_url;

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	@Column
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

	public Long getId() {
		return playId;
	}

}
