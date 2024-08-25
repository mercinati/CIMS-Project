package mainClasses;

import java.util.Scanner;
import Dao.Criminaldao;
import daoimpl.Criminal_daoimpl;
import Exception.CriminalException;
import model.Criminal;

public class Criminal_main {

    public static Criminaldao crdl = new Criminal_daoimpl();
    public static Scanner sc = new Scanner(System.in);
    
    public void criminal_details() throws CriminalException {
        System.out.println("Enter 1 to search for a criminal");
        System.out.println("Enter 2 to enter details of a criminal");
        System.out.println("Enter 3 to delete a criminal's detail");
        System.out.println("Enter 4 to Exit ");
        
        int choice = sc.nextInt();
        sc.nextLine(); // Consume newline
        
        switch (choice) {
            case 1:
                search_criminal();
                break;
            case 2:
                enter_criminal_details();
                break;
            case 3:
                delete_criminal();
                break;
            case 4:
                System.out.println("Exited...");
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
    
    public void search_criminal() throws CriminalException {
        System.out.print("Enter Criminal ID: ");
        int criminal_id = sc.nextInt();
        
        try {
          Criminal result = crdl.search_data(criminal_id);
          System.out.println(result);
        } catch (CriminalException e) {
            e.printStackTrace();
        }
    }
    
    public void enter_criminal_details() throws CriminalException {
    	System.out.println("Fill in the following details:");
        System.out.print("Criminal ID: ");
        int criminal_id = sc.nextInt();
        sc.nextLine();
        
        System.out.print("Criminal Name: ");
        String name = sc.nextLine();
        
        System.out.print("Age: ");
        int age = sc.nextInt();
        sc.nextLine();
        
        System.out.print("Gender: ");
        String gender = sc.nextLine();
        
        System.out.print("Crime that he has done: ");
        String crime_name = sc.nextLine();
        
        System.out.print("Address: ");
        String address = sc.nextLine();
        
        System.out.print("Arrest Date (MMDD): ");
        String arrest_date = sc.nextLine();
        
        Criminal criminal = new Criminal(criminal_id, name, age, gender, crime_name, address, arrest_date);
        
        try {
        	crdl.criminal_data(criminal);
        }catch (CriminalException e) {
        	e.printStackTrace();
        }
    }

    public void delete_criminal() throws CriminalException {
        System.out.print("Enter the Criminal ID to delete: ");
        int criminal_id = sc.nextInt();
        
        try {
            crdl.delete_criminal_data(criminal_id);
            System.out.println("Criminal data deleted successfully.");
        } catch (CriminalException e) {
            e.printStackTrace();
        }
    }
}
