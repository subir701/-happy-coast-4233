package com.masai;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.*;

import com.masai.entities.Crime;
import com.masai.entities.Criminal;
import com.masai.exception.CrimeException;
import com.masai.exception.CriminalException;
import com.masai.exception.DublicateException;
import com.masai.exception.InvalidDetailException;
import com.masai.service.CrimeService;
import com.masai.service.CrimeServiceImple;
import com.masai.service.CriminalService;
import com.masai.service.CriminalServiceImpl;
import com.masai.utility.Admin;
import com.masai.utility.FileExist;
import com.masai.utility.IDGenration;
public class Main {

	public static void main(String[] args) {
		Map<Integer, Crime> crime = FileExist.crimeFile();
		Map<Integer, Criminal> criminal= FileExist.criminalFile();
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Welcome to Log of CINS");
		
		try {
			int preference = 0;
			
			do {
				System.out.println("Please enter your preference, "+" '1' --> Admin login , '2' --> Show data , "
						+ " '0' for exit");
				preference =sc.nextInt();
				switch(preference) {
				case 1:
					adminFunctionality(sc,crime,criminal);
					break;
				case 0:
					System.out.println("successfully existed from the system");
					break;
				default:
					throw new IllegalArgumentException("Invalid Selection");
				}
			} while (preference != 0);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				ObjectOutputStream coos = new ObjectOutputStream(new FileOutputStream("Crime.ser"));
				coos.writeObject(crime);
				ObjectOutputStream cioos = new ObjectOutputStream(new FileOutputStream("Criminal.ser"));
				cioos.writeObject(criminal);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public static void adminFunctionality(Scanner sc, Map<Integer, Crime> crime, Map<Integer, Criminal> criminal)throws InvalidDetailException, CriminalException,CrimeException{
		adminLogin(sc);
		
		CrimeService crimeservice= new CrimeServiceImple();
		CriminalService criminalservice = new CriminalServiceImpl();
		
		int choice=0;
		try {
			do {
				System.out.println("Press 1 add the crime");
				System.out.println("Press 2 view all the crime");
				System.out.println("Press 3 delete the crime");
				System.out.println("Press 4 update the crime");
				System.out.println("Press 5 add the criminal");
				System.out.println("Press 6 view all the criminal");
				System.out.println("Press 7 delete the criminal");
				System.out.println("Press 8 update the criminal");
				System.out.println("Press 0 logout");
				choice= sc.nextInt();
				
				switch(choice) {
				case 1:
					String added= adminAddCrime(sc, crime,crimeservice);
					System.out.println(added);
					break;
				case 2:
					adminViewAllCrime(crime, crimeservice);
					break;
				case 3:
					String update=adminUpdateCrime(sc, crime, crimeservice);
					System.out.println(update);
					break;
				case 4:
					adminDeleteCrime(sc, crime, crimeservice);
					break;
				default:
					throw new IllegalArgumentException("Unexpected value: " + choice);
				}
			} while (choice!=0);
		}catch(Exception e) {
			
		}
	}
	public static void adminLogin(Scanner sc)throws InvalidDetailException{
		System.out.println("Enter the user name ");
		String username= sc.next();
		System.out.println("Enter the password ");
		String password= sc.next();
		if(username.equals(Admin.username) && password.equals(Admin.password)) {
			System.out.println("Successfully Login");
		}else {
			throw new InvalidDetailException("Invalid admin credential");
		}
	}
	public static String adminAddCrime(Scanner sc,Map<Integer,Crime> crime,CrimeService crimeService) throws DublicateException{
		String str=null;
		System.out.println("Please enter crime details");
		System.out.println("Enter type of crime : ");
		String type= sc.next();
		System.out.println("Enter description of crime : ");
		String desc= sc.next();
		System.out.println("Enter police station area where crime held : ");
		String ps=sc.next();
		System.out.println("Enter date of crime : ");
		String date=sc.next();
		System.out.println("Enter name of victims : ");
		String name=sc.next();
		Crime cr=new Crime(IDGenration.generateId(),type,desc,ps,date,name);
		str= crimeService.addCrime(cr, crime);
		return str;
	}
	
	public static void adminViewAllCrime(Map<Integer,Crime> crime,CrimeService crimeService) throws CrimeException{
		crimeService.viewAllCrime(crime);
	}
	
	public static void adminDeleteCrime(Scanner sc,Map<Integer,Crime> crime,CrimeService crimeService) throws CrimeException {
		System.out.println("Please enter the id of crime to be deleted : ");
		int id = sc.nextInt();
		crimeService.deleteCrime(id, crime);
	}
	
	public static String adminUpdateCrime(Scanner sc,Map<Integer,Crime> crime,CrimeService crimeService) throws CrimeException{
		String result=null;
		System.out.println("Please enter the id of crime : ");
		int id=sc.nextInt();
		System.out.println("Please enter the updated details");
		System.out.println("Enter the type of crime : ");
		String type=sc.next();
		System.out.println("Enter description of crime : ");
		String desc= sc.nextLine();
		System.out.println("Enter police station area where crime held : ");
		String ps=sc.nextLine();
		System.out.println("Enter date of crime : ");
		String date=sc.next();
		System.out.println("Enter name of victims : ");
		String name=sc.nextLine();
		Crime update = new Crime(id,type,desc,ps,date,name);
		result= crimeService.updateCrime(id, null, crime);
		return result;
	}
}
