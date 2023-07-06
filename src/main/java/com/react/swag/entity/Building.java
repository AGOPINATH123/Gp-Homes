package com.react.swag.entity;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "buildingnew")
@Component
public class Building {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bid;
	@NotNull(message = "Building Name should Not be Empty")
	private String buildingName;
	@NotNull(message = "Building age should Not be Empty")
	private int ageOfBuilding;
	@NotNull(message = "Building location should Not be Empty")
	private String location;
	@NotNull(message = "Building area should Not be Empty")
	private String area;
	@NotNull(message = "Mention Yes or No")
	private String community;

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public int getAgeOfBuilding() {
		return ageOfBuilding;
	}

	public void setAgeOfBuilding(int ageOfBuilding) {
		this.ageOfBuilding = ageOfBuilding;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String isGatedCommunityOrNot() {
		return community;
	}

	public void setGatedCommunityOrNot(String community) {
		this.community = community;
	}

}
