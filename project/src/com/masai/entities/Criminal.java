package com.masai.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Criminal implements Serializable{
	private int id;
	private String name;
	private String dob;
	private char gender;
	private String identifying_mark;
	private String first_arrest_date;
	private String arrested_from_ps_area;
	private List<Crime> crime;
	public List<Crime> getCrmie() {
		return crime;
	}
	public void setCrmie(Crime crime) {
		this.crime.add(crime);
	}
	public Criminal(int id, String name, String dob, char gender, String identifying_mark, String first_arrest_date,
			String arrested_from_ps_area) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.gender = gender;
		this.identifying_mark = identifying_mark;
		this.first_arrest_date = first_arrest_date;
		this.arrested_from_ps_area = arrested_from_ps_area;
		this.crime= new ArrayList<>();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getIdentifying_mark() {
		return identifying_mark;
	}
	public void setIdentifying_mark(String identifying_mark) {
		this.identifying_mark = identifying_mark;
	}
	public String getFirst_arrest_date() {
		return first_arrest_date;
	}
	public void setFirst_arrest_date(String first_arrest_date) {
		this.first_arrest_date = first_arrest_date;
	}
	public String getArrested_from_ps_area() {
		return arrested_from_ps_area;
	}
	public void setArrested_from_ps_area(String arrested_from_ps_area) {
		this.arrested_from_ps_area = arrested_from_ps_area;
	}
	@Override
	public int hashCode() {
		return Objects.hash(arrested_from_ps_area, dob, first_arrest_date, gender, id, identifying_mark, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Criminal other = (Criminal) obj;
		return Objects.equals(arrested_from_ps_area, other.arrested_from_ps_area) && Objects.equals(dob, other.dob)
				&& Objects.equals(first_arrest_date, other.first_arrest_date) && gender == other.gender
				&& id == other.id && Objects.equals(identifying_mark, other.identifying_mark)
				&& Objects.equals(name, other.name);
	}
	@Override
	public String toString() {
		return "Id = " + id + "|| Name = " + name + "|| Date of birth = " + dob + "|| Gender = " + gender + "|| Identifying Mark = "
				+ identifying_mark + "|| First Arrest Date = " + first_arrest_date + "|| Arrested from police station Area = "
				+ arrested_from_ps_area +"|| Type of crimes = "+getCrmie();
	}
	
}
