package com.masai.service;

import java.util.Map;

import com.masai.entities.Criminal;
import com.masai.exception.CriminalException;
import com.masai.exception.DublicateException;

public class CriminalServiceImpl implements CriminalService{

	@Override
	public String addCrime(Criminal cr, Map<Integer, Criminal> criminal) throws DublicateException {
		if(!criminal.containsKey(cr.getId())) {
			criminal.put(cr.getId(), cr);
			return "Criminal added successfully";
		}else {
			throw new DublicateException("Criminal is already there");
		}
		
	}

	@Override
	public String updateCrime(int id, Criminal cr, Map<Integer, Criminal> criminal) throws CriminalException {
		if(criminal.containsKey(id)) {
			criminal.put(id, cr);
			return "Criminal updated successfully";
		}else {
			throw new CriminalException("Criminal not found");
		}
		
	}

	@Override
	public void viewAllCrime(Map<Integer, Criminal> criminal) throws CriminalException {
		if(criminal!=null && criminal.size()>0) {
			for(Map.Entry<Integer, Criminal> i: criminal.entrySet()) {
				System.out.println(i.getValue());
			}
		}else {
			throw new CriminalException("Criminal list is already empty");
		}
		
	}

	@Override
	public void deleteCrime(int id, Map<Integer, Criminal> criminal) throws CriminalException {
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

}
