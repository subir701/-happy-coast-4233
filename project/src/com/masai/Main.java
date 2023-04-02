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
import com.masai.exception.NotFound;
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
				System.out.println("Press 9 assign a crime to a criminal");
				System.out.println("Press 10 remove a crime to a criminal");
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
					adminDeleteCrime(sc, crime, crimeservice);
					break;
				case 4:
					String update=adminUpdateCrime(sc, crime, crimeservice);
					System.out.println(update);
					
					break;
				case 5:
					String adde= adminAddCriminal(sc, criminal, criminalservice);
					System.out.println(adde);
					break;
				case 6:
					adminViewAllCriminal(criminal, criminalservice);
					break;
				case 7:
					adminDeleteCriminal(sc, criminal, criminalservice);
					break;
				case 8:
					adminUpdateCriminal(sc, criminal, criminalservice);
					break;
				case 9:
					adminassignCriminal(sc, criminal, crime, criminalservice);
					break;
				case 10:
					adminRemoveCrime(sc, criminal, criminalservice);
					break;
				case 0:
					System.out.println("Successfully LogOut");
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
		sc.nextLine();
		String desc= sc.next();
		System.out.println("Enter police station area where crime held : ");
		String ps=sc.next();
		System.out.println("Enter date of crime : ");
		String date=sc.next();
		System.out.println("Enter name of victims : ");
		sc.nextLine();
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
		sc.nextLine();
		String desc= sc.nextLine();
		System.out.println("Enter police station area where crime held : ");
		sc.nextLine();
		String ps=sc.nextLine();
		System.out.println("Enter date of crime : ");
		String date=sc.next();
		System.out.println("Enter name of victims : ");
		sc.nextLine();
		String name=sc.nextLine();
		Crime update = new Crime(id,type,desc,ps,date,name);
		result= crimeService.updateCrime(id, update, crime);
		return result;
	}
	
	public static String adminAddCriminal(Scanner sc,Map<Integer,Criminal> criminal,CriminalService criminalService)throws DublicateException{
		String str=null;
		System.out.println("Please enter criminal details");
		System.out.println("Enter criminal name : ");
		sc.nextLine();
		String name= sc.nextLine();
		
		System.out.println("Enter date of birth : ");
		String dob= sc.next();
		System.out.println("Enter gender of criminal : ");
		char gender=sc.next().charAt(0);
		System.out.println("Enter Identifying marks : ");
		sc.nextLine();
		String marks=sc.nextLine();
		System.out.println("Enter arrest date : ");
		String date=sc.next();
		System.out.println("Enter arrested police station : ");
		sc.nextLine();
		String ps=sc.nextLine();
		Criminal cm= new Criminal(IDGenration.generateId(),name,dob,gender,marks,date,ps);
		str=criminalService.addCriminal(cm, criminal);
		return str;
	}
	
	public static void adminViewAllCriminal(Map<Integer,Criminal> criminal,CriminalService criminalService) throws CriminalException{
		criminalService.viewAllCriminal(criminal);
	}
	
	public static void adminDeleteCriminal(Scanner sc, Map<Integer,Criminal> criminal,CriminalService criminalService)throws CriminalException{
		System.out.println("Please enter the id of criminal to be deleted : ");
		int id = sc.nextInt();
		criminalService.deleteCriminal(id, criminal);
	}

	public static String adminUpdateCriminal(Scanner sc,Map<Integer,Criminal> criminal, CriminalService criminalService)throws CriminalException{
		String update=null;
		System.out.println("Please enter the id of criminal : ");
		int id=sc.nextInt();
		System.out.println("Please enter the updated details");
		System.out.println("Enter criminal name : ");
		sc.nextLine();
		String name= sc.nextLine();
		System.out.println("Enter date of birth : ");
		String dob= sc.next();
		System.out.println("Enter gender of criminal : ");
		char gender=sc.next().charAt(0);
		System.out.println("Enter Identifying marks : ");
		sc.nextLine();
		String marks=sc.nextLine();
		System.out.println("Enter arrest date : ");
		String date=sc.next();
		System.out.println("Enter arrested police station : ");
		sc.nextLine();
		String ps=sc.nextLine();
		Criminal data= new Criminal(id, name, dob, gender, marks, date, ps);
		update= criminalService.updateCriminal(id, data, criminal);
		return update;
	}

	public static void adminassignCriminal(Scanner sc, Map<Integer,Criminal> criminal,Map<Integer,Crime> crime ,CriminalService criminalService)throws NotFound,CriminalException {
		System.out.println("Please enter criminal id : ");
		int id=sc.nextInt();
		Criminal cr=criminal.get(id);
		System.out.println("Please enter crime id to assign : ");
		int idc=sc.nextInt();
		Crime cm=crime.get(idc);
		
		criminalService.assignCriminal(id, cr, cm, criminal);
	}

	public static void adminRemoveCrime(Scanner sc,Map<Integer,Criminal> criminal,CriminalService criminalService)throws NotFound,CriminalException{
		System.out.println("Please enter criminal id : ");
		int id=sc.nextInt();
		Criminal cr= criminal.get(id);
		criminalService.removeCriminal(id, cr.getCrmie(), criminal);
	}
}
