package com.masai.service;

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

}
