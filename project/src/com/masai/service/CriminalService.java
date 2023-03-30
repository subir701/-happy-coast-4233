package com.masai.service;

import java.util.Map;


import com.masai.entities.Criminal;
import com.masai.exception.CriminalException;
import com.masai.exception.DublicateException;

public interface CriminalService {
	public String addCrime(Criminal cr, Map<Integer,Criminal> criminal)throws DublicateException;
	public String updateCrime(int id, Criminal cr,Map<Integer,Criminal> criminal)throws CriminalException;
	public void viewAllCrime(Map<Integer,Criminal> criminal) throws CriminalException;
	public void deleteCrime(int id,Map<Integer,Criminal> criminal)throws CriminalException;
}
