package MainPackage;

import java.util.Scanner;

import mainClasses.crime_main;
import mainClasses.Criminal_main;

public class Main {
    
    public static crime_main cm = new crime_main();
    public static Criminal_main crm = new Criminal_main();
    
    public static void starting_point() {
        
        while(true) {
            System.out.println("WELCOME TO CRIME INFORMATION MANAGEMENT SYSTEM 2024 [CIMS]");
            System.out.println("-----------------------------------------------------");
            System.out.println("Press 1 to Insert the crime data");
            System.out.println("Press 2 to Search or Enter Criminal's details");
            System.out.println("Press 3 to Search for a crime(Case) report");
            System.out.println("Press 4 to View monthly report of crimes");
            System.out.println("Press 5 to Exit");
            
            try {
                
                Scanner sc = new Scanner(System.in);
                
                int choice = sc.nextInt();
      
                if(choice == 5) {
                    
                    System.out.println("Exited..!!");
                    break;
                }
                
                switch(choice) {
                    case 1:
                        cm.record_crime();
                        break;
                    case 2:
                        crm.criminal_details();
                        break;
                    case 3:
                        cm.search_crime_report();
                        break;
                    case 4:
                        cm.view_monthly_report();
                        break;
                    default:
                        System.out.println("Making Invalid Choice");
                        break;
                }
            
            } catch(Exception e) {
                e.printStackTrace();
            }
            System.out.println();
        } //while loop ended
    }
    
    public static void main(String[] args) {
        starting_point();
    }
}
