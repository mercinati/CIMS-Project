package mainClasses;

import java.util.Scanner;
import Dao.Crimedao;
import daoimpl.Crime_daoimpl;
import model.Crime;
import Exception.CrimeException;

public class crime_main {

    public static Crimedao crdl = new Crime_daoimpl();
    public static Scanner sc = new Scanner(System.in);

    public static void record_crime() throws CrimeException {
    	System.out.println("Press 1 to Enter ");
		System.out.println("Press 2 to Exit");
		
		int n = sc.nextInt();
		if(n==1) {
			
			System.out.println("Enter the following details:-");
			System.out.print("Case ID: ");
			int crime_id = sc.nextInt();
			sc.nextLine();
			
			System.out.print("Month of Crime(MM): ");
			int month = sc.nextInt();
			sc.nextLine();
			
			System.out.print("Date of Crime(DD): ");
			int date = sc.nextInt();
			sc.nextLine();
			
			System.out.print("Place of Crime: ");
			String place = sc.nextLine();
			
			System.out.print("What Crime was happened: ");
			String crime_name = sc.nextLine();
			
			System.out.print("Victim's name: ");
			String victim = sc.nextLine();
			
			System.out.print("Detail description of case: ");
			String detail_desc = sc.nextLine();
			
			System.out.print("If any suspect: ");
			String suspect = sc.nextLine();
			
//			System.out.print("Criminal name: ");
//			String criminal_name = sc.nextLine();
//			
//			System.out.print("Criminal ID: ");
//			int criminal_id =sc.nextInt();
			
			System.out.print("Area name: ");
			String area = sc.nextLine();
			
			System.out.print("Case status: ");
			String status = sc.nextLine();
			
			Crime crime = new Crime(crime_id,month,date,place,crime_name,victim,detail_desc,suspect,area,status);
//			crime.setCrime_id(crime_id);
//			crime.setDate(date);
//			crime.setPlace(place);
//			crime.setCrime_name(crime_name);
//			crime.setVictim(victim);
//			crime.setDetail_desc(detail_desc);
//			crime.setSuspect(suspect);
////			crime.setcriminal_name(criminal_name);
////			crime.setcriminal_id(criminal_id);
//			crime.setArea(area);
//			crime.setStatus(status);
			
			
			try {
				 crdl.crime_data(crime);
				
			}catch(CrimeException e) {
				e.printStackTrace();
			}
			
		}else {
			System.out.println("Exited...");
		}
			
    }
    
    public static void update_crime_status() throws CrimeException {
        System.out.print("Enter the Case ID to update: ");
        int crime_id = sc.nextInt();
       
        
        System.out.print("Enter the new status (solved/unsolved): ");
        String new_status = sc.nextLine();
        
        try {
            crdl.update_crime_status(crime_id, new_status);
            System.out.println("Crime status updated successfully.");
        } catch (CrimeException e) {
            e.printStackTrace();
        }
    }
    
    public static void search_crime_report() throws CrimeException {
        System.out.print("Enter the Case ID to search: ");
        int crime_id = sc.nextInt();
        
        try {
            crdl.search_crime_report(crime_id);
        } catch (CrimeException e) {
            e.printStackTrace();
        }
    }

    public static void view_monthly_report() throws CrimeException {
        System.out.print("Enter the month (MM) to view report: ");
        int month = sc.nextInt();
        
        try {
            crdl.generate_monthly_report(month);
        } catch (CrimeException e) {
            e.printStackTrace();
        }
    }
}
