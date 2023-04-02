package com.masai.service;

import java.util.List;
import java.util.Map;

import com.masai.entities.Crime;
import com.masai.entities.Criminal;
import com.masai.exception.CriminalException;
import com.masai.exception.DublicateException;
import com.masai.exception.NotFoundd;

public interface CriminalService {
	public String addCriminal(Criminal cr, Map<Integer,Criminal> criminal)throws DublicateException;
	public String updateCriminal(int id, Criminal cr,Map<Integer,Criminal> criminal)throws CriminalException;
	public void viewAllCriminal(Map<Integer,Criminal> criminal) throws CriminalException;
	public void deleteCriminal(int id,Map<Integer,Criminal> criminal)throws CriminalException;
	public void assignCriminal(int id,Criminal cr,Crime cm,Map<Integer,Criminal> criminal)throws NotFoundd,CriminalException;
	public void removeCriminal(int id,List<Crime> crime, Map<Integer, Criminal> criminal)throws NotFoundd,CriminalException;
	public void findCriminal(Map<Integer, Criminal> criminal,String name);
	
}
