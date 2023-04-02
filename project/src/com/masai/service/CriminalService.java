package com.masai.service;

import java.util.Map;


import com.masai.entities.Criminal;
import com.masai.exception.CriminalException;
import com.masai.exception.DublicateException;

public interface CriminalService {
	public String addCriminal(Criminal cr, Map<Integer,Criminal> criminal)throws DublicateException;
	public String updateCriminal(int id, Criminal cr,Map<Integer,Criminal> criminal)throws CriminalException;
	public void viewAllCriminal(Map<Integer,Criminal> criminal) throws CriminalException;
	public void deleteCriminal(int id,Map<Integer,Criminal> criminal)throws CriminalException;
}
