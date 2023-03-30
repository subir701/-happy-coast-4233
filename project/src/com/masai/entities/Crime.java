package com.masai.entities;

import java.io.Serializable;
import java.util.Objects;

public class Crime implements Serializable{
	private int id;
	private String type;
	private String description;
	private String ps_area;
	private String date;
	private String name;
	public Crime(int id, String type, String description, String ps_area, String date, String name) {
		super();
		this.id = id;
		this.type = type;
		this.description = description;
		this.ps_area = ps_area;
		this.date = date;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPs_area() {
		return ps_area;
	}
	public void setPs_area(String ps_area) {
		this.ps_area = ps_area;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int hashCode() {
		return Objects.hash(date, description, id, name, ps_area, type);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Crime other = (Crime) obj;
		return Objects.equals(date, other.date) && Objects.equals(description, other.description) && id == other.id
				&& Objects.equals(name, other.name) && Objects.equals(ps_area, other.ps_area)
				&& Objects.equals(type, other.type);
	}
	@Override
	public String toString() {
		return "Crime [id=" + id + ", type=" + type + ", description=" + description + ", ps_area=" + ps_area
				+ ", date=" + date + ", name=" + name + "]";
	}
	
}
