package com.masai.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedHashMap;
import java.util.Map;

import com.masai.entities.Crime;
import com.masai.entities.Criminal;

public class FileExist {
	public static Map<Integer, Crime>crimeFile(){
		Map<Integer,Crime> crimeFile=null;
		File f= new File("Crime.ser");
		boolean flag=false;
		try {
			if(!f.exists()) {
				f.createNewFile();
				flag=true;
			}
			if(flag) {
				crimeFile = new LinkedHashMap<>();
				ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream(f));
				oos.writeObject(crimeFile);
				return crimeFile;
			}else {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
				crimeFile =(Map<Integer,Crime>)ois.readObject();
				return crimeFile;
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return crimeFile;
	}
	public static Map<Integer,Criminal> criminalFile(){
		Map<Integer,Criminal> criminalFile=null;
		File f= new File("Criminal.ser");
		boolean flag=false;
		try {
			if(!f.exists()) {
				f.createNewFile();
				flag=true;
			}
			if(flag) {
				criminalFile = new LinkedHashMap<>();
				ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream(f));
				oos.writeObject(criminalFile);
				return criminalFile;
			}else {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
				criminalFile =(Map<Integer,Criminal>)ois.readObject();
				return criminalFile;
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return criminalFile;
	}
}
