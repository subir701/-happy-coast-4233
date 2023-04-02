package com.masai.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.masai.entities.Crime;
import com.masai.entities.Criminal;
import com.masai.exception.CriminalException;
import com.masai.exception.DublicateException;
import com.masai.exception.NotFoundd;

public class CriminalServiceImpl implements CriminalService{

	@Override
	public String addCriminal(Criminal cr, Map<Integer, Criminal> criminal) throws DublicateException {
		if(!criminal.containsKey(cr.getId())) {
			criminal.put(cr.getId(), cr);
			return "Criminal added successfully";
		}else {
			throw new DublicateException("Criminal is already there");
		}
		
	}

	@Override
	public String updateCriminal(int id, Criminal cr, Map<Integer, Criminal> criminal) throws CriminalException {
		if(criminal.containsKey(id)) {
			criminal.put(id, cr);
			return "Criminal updated successfully";
		}else {
			throw new CriminalException("Criminal not found");
		}
		
	}

	@Override
	public void viewAllCriminal(Map<Integer, Criminal> criminal) throws CriminalException {
		if(criminal!=null && criminal.size()>0) {
			for(Map.Entry<Integer, Criminal> i: criminal.entrySet()) {
				System.out.println(i.getValue());
			}
		}else {
			throw new CriminalException("Criminal list is already empty");
		}
		
	}

	@Override
	public void deleteCriminal(int id, Map<Integer, Criminal> criminal) throws CriminalException {
		if(criminal !=null && criminal.size()>0) {
			if(criminal.containsKey(id)) {
				criminal.remove(id);
				System.out.println("Criminal data is deleted");
			}else {
				throw new CriminalException("Criminal is not found");
			}
		}else {
			throw new CriminalException("Criminal list is empty");
		}
		
	}

	@Override
	public void assignCriminal(int id, Criminal cr, Crime cm, Map<Integer, Criminal> criminal) throws NotFoundd,CriminalException {
		// TODO Auto-generated method stub
		if(criminal !=null && criminal.size()>0) {
			
			if(criminal.containsKey(id)) {
				
				cr.setCrmie(cm);
				criminal.put(id, cr);
				System.out.println("Crime Assigned to the criminal");
			}else {
				throw new NotFoundd("Criminal is not found");
			}
		}else {
			throw new CriminalException("Criminal list is empty");
		}
	}

	@Override
	public void removeCriminal(int id, List<Crime> crime ,  Map<Integer, Criminal> criminal) throws NotFoundd,CriminalException{
		// TODO Auto-generated method stub
		if(criminal !=null && criminal.size()>0) {
			if(criminal.containsKey(id)) {
				
				Criminal cm=criminal.get(id);
				cm.getCrmie().remove(0);
				criminal.put(id, cm);
				System.out.println("Crime is removed from the criminal");
			}else {
				throw new NotFoundd("Criminal is not found");
			}
		}else {
			throw new CriminalException("Criminal list is empty");
		}
	}

	@Override
	public void findCriminal(Map<Integer, Criminal> criminal, String name) {
		for(Map.Entry<Integer, Criminal> i : criminal.entrySet()) {
			if(i.getValue().getName().equals(name)) {
				System.out.println("Name = " + name + "|| Date of birth = " + i.getValue().getDob() + "|| Gender = " + i.getValue().getGender() + "|| Identifying Mark = "
				+ i.getValue().getIdentifying_mark() + "|| First Arrest Date = " + i.getValue().getFirst_arrest_date() + "|| Arrested from police station Area = "
				+ i.getValue().getArrested_from_ps_area() +"|| Type of crimes = "+i.getValue().getCrmie().toString());
			}
		}
		
	}

	
		
	

}
