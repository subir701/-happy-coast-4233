package com.masai.service;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import com.masai.entities.Crime;
import com.masai.exception.CrimeException;
import com.masai.exception.DublicateException;

public class CrimeServiceImple implements CrimeService{

	@Override
	public String addCrime(Crime cr, Map<Integer, Crime> crime) throws DublicateException{
		if(!crime.containsKey(cr.getId())) {
		crime.put(cr.getId(), cr);
		return "Crime added successfully";
		}else {
			throw new DublicateException("Crime is already inside the list");
		}
	}

	@Override
	public String updateCrime(int id, Crime cr, Map<Integer, Crime> crime) throws CrimeException {
		if(crime !=null && crime.size()>0) {
			if(crime.containsKey(id)) {
				crime.put(id, cr);
				return "Crime is successfully updated";
			}else {
				throw new CrimeException("Crime is not found");
			}
		}else {
			throw new CrimeException("Crime list is empty");
		}
		
	}

	@Override
	public void viewAllCrime(Map<Integer, Crime> crime) throws CrimeException {
		if(crime !=null && crime.size()>0) {
			for(Map.Entry<Integer, Crime> i: crime.entrySet()) {
				System.out.println(i.getValue());
			}
		}else {
			throw new CrimeException("Crime list is empty");
		}
		
	}

	@Override
	public void deleteCrime(int id, Map<Integer, Crime> crime) throws CrimeException {
		if(crime !=null && crime.size()>0) {
			if(crime.containsKey(id)) {
				crime.remove(id);
				System.out.println("Crime is successfully deleted");
			}else {
				throw new CrimeException("Crime is not found");
			}
		}else {
			throw new CrimeException("Crime list is empty");
		}
	}

	@Override
	public void totalCrime(Map<Integer, Crime> crime, String start, String end , String police) {
		int count=0;
		DateTimeFormatter date=DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate ld= LocalDate.parse(start, date);
		LocalDate ld1 = LocalDate.parse(end,date);
		for(Map.Entry<Integer, Crime> i: crime.entrySet()) {
			LocalDate temp= LocalDate.parse(i.getValue().getDate(),date);
			if((!temp.isBefore(ld)) && (temp.isBefore(ld1)) || (temp.isEqual(ld)) || (temp.isEqual(ld1))) {
				if(i.getValue().getPs_area().equals(police)) {
					System.out.println(" Type of crime = " + i.getValue().getType() + "|| Description = " + i.getValue().getDescription() + "|| Police Station Area = " +i.getValue().getPs_area()
							+ "|| Date = " + i.getValue().getDate() + "|| Name of victims = " + i.getValue().getName());
					count++;
				}
//				System.out.println(" Type of crime = " + i.getValue().getType() + "|| Description = " + i.getValue().getDescription() + "|| Police Station Area = " +i.getValue().getPs_area()
//						+ "|| Date = " + i.getValue().getDate() + "|| Name of victims = " + i.getValue().getName());
				
			}
		}
		System.out.println("Total Number of crime in this "+police+" = "+count);
		
	}

	@Override
	public void totalCrimeType(Map<Integer, Crime> crime, String start, String end, String type) {
		int count=0;
		DateTimeFormatter date=DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate ld= LocalDate.parse(start, date);
		LocalDate ld1 = LocalDate.parse(end,date);
		for(Map.Entry<Integer, Crime> i: crime.entrySet()) {
			LocalDate temp= LocalDate.parse(i.getValue().getDate(),date);
			if((!temp.isBefore(ld)) && (temp.isBefore(ld1)) || (temp.isEqual(ld)) || (temp.isEqual(ld1))) {
				if(i.getValue().getType().equals(type)) {
					System.out.println(" Type of crime = " + i.getValue().getType() + "|| Description = " + i.getValue().getDescription() + "|| Police Station Area = " +i.getValue().getPs_area()
							+ "|| Date = " + i.getValue().getDate() + "|| Name of victims = " + i.getValue().getName());
					count++;
				}
//				System.out.println(" Type of crime = " + i.getValue().getType() + "|| Description = " + i.getValue().getDescription() + "|| Police Station Area = " +i.getValue().getPs_area()
//						+ "|| Date = " + i.getValue().getDate() + "|| Name of victims = " + i.getValue().getName());
				
			}
		}
		System.out.println("Total Number of crime in this "+type+" = "+count);
		
	}

	@Override
	public void descriptionCrime(Map<Integer, Crime> crime, String desc) {
		for(Map.Entry<Integer, Crime> i: crime.entrySet()) {
			
			
				if(i.getValue().getDescription().equals(desc)) {
					System.out.println(" Type of crime = " + i.getValue().getType() + "|| Description = " + i.getValue().getDescription() + "|| Police Station Area = " +i.getValue().getPs_area()
							+ "|| Date = " + i.getValue().getDate() + "|| Name of victims = " + i.getValue().getName());
					
				}
//				System.out.println(" Type of crime = " + i.getValue().getType() + "|| Description = " + i.getValue().getDescription() + "|| Police Station Area = " +i.getValue().getPs_area()
//						+ "|| Date = " + i.getValue().getDate() + "|| Name of victims = " + i.getValue().getName());
				
			
		}
		
	}

}
