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
@Table(name="theaters")
public class Theater {
	@Id
	@Column(name = "theaterid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long theaterid;
	
	@Column
	private String name;
	
	@Column
	private Integer totalScreens;
	
	@ManyToOne
	@JoinColumn(name="pincode", referencedColumnName = "pinCode")
	private City city;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getTotalScreens() {
		return totalScreens;
	}

	public void setTotalScreens(Integer totalScreens) {
		this.totalScreens = totalScreens;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Long getId() {
		return theaterid;
	}
	
	
	
}
