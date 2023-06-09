package com.masai.service;

import java.util.Map;

import com.masai.entities.Crime;
import com.masai.entities.Criminal;
import com.masai.exception.CrimeException;
import com.masai.exception.DublicateException;

public interface CrimeService {
	public String addCrime(Crime cr, Map<Integer,Crime> crime)throws DublicateException;
	public String updateCrime(int id, Crime cr,Map<Integer,Crime> crime)throws CrimeException;
	public void viewAllCrime(Map<Integer,Crime> crime) throws CrimeException;
	public void deleteCrime(int id,Map<Integer,Crime> crime)throws CrimeException;
	public void totalCrime(Map<Integer,Crime> crime,String start,String end,String police);
	public void totalCrimeType(Map<Integer,Crime> crime,String start,String end,String type);
	public void descriptionCrime(Map<Integer, Crime> crime,String desc);
}
