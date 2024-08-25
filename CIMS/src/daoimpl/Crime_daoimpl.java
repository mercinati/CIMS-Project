package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Dao.Crimedao;
import Exception.CrimeException;
import model.Crime;
import utility.Dao;

public class Crime_daoimpl implements Crimedao {

    public Crime crime_data(Crime crime) throws CrimeException {
    	try(Connection con = Dao.getConnection()){
    		PreparedStatement   ps = con.prepareStatement("INSERT INTO crime_record (crime_id, month, date, place, crime_name, victim, detail_desc, suspect, \r\n"
    				+ " area, status )VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
    		
    			
    		ps.setInt(1, crime.getCrime_id());
    		ps.setInt(2, crime.getMonth());
    		ps.setInt(3, crime.getDate());
    		ps.setString(4, crime.getPlace());
    		ps.setString(5, crime.getCrime_name());
    		ps.setString(6, crime.getVictim());
    		ps.setString(7, crime.getDetail_desc());
    		ps.setString(8, crime.getSuspect());
//    		ps.setString(8, crime.getCriminal_name());
//    		ps.setInt(9, crime.getCriminal_id());
    		ps.setString(9, crime.getArea());
    		ps.setString(10, crime.getStatus());
    		
    		int i = ps.executeUpdate();
    		if(i>0) {
    			
    			System.out.println("Data inserted Successfully");
    		}
    		
    		}catch(SQLException e) {
    			e.printStackTrace();
    		}
    		
        return null;
    }

    
    
    
    public void update_crime_status(int crime_id, String status) throws CrimeException {
        try (Connection con = Dao.getConnection()) {
            PreparedStatement ps = con.prepareStatement("UPDATE crime_record SET status = ? WHERE crime_id = ?");
            ps.setString(1, status);
            ps.setInt(2, crime_id);

            int i = ps.executeUpdate();
            if (i > 0) {
                System.out.println("Crime status updated successfully.");
            } else {
                throw new CrimeException("Crime ID not found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new CrimeException("Error updating crime status.");
        }
    }

    
    
    
    public void search_crime_report(int crime_id) throws CrimeException {
        try (Connection con = Dao.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM crime_record WHERE crime_id = ?");
            ps.setInt(1, crime_id);
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("Crime Report:");
                System.out.println("ID: " + rs.getInt(1));
                System.out.println("Month: " + rs.getInt(2));
                System.out.println("Date: " + rs.getInt(3));
                System.out.println("Place: " + rs.getString(4));
                System.out.println("Crime: " + rs.getString(5));
                System.out.println("Victim: " + rs.getString(6));
                System.out.println("Description: " + rs.getString(7));
                System.out.println("Suspect: " + rs.getString(8));
                System.out.println("Area: " + rs.getString(9));
                System.out.println("Status: " + rs.getString(10));
            } else {
                throw new CrimeException("Crime report not found.");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            throw new CrimeException("Error retrieving crime report.");
        }
    }

    
    
    
    
    public void generate_monthly_report(int month) throws CrimeException {
        try (Connection con = Dao.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM crime_record WHERE month = ?");
            ps.setInt(1, month);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
            	System.out.println("Monthly Crime Report:");
            	
            	System.out.println("| ID: " + rs.getInt("crime_id") + " | Crime: " + rs.getString("crime_name") +
                              " | Place: " + rs.getString("place") + " | Date: " + rs.getInt("date") + " | Month: "+ rs.getInt("month")+" |");
            }else {
            	System.out.println("Entered month dont have any cases");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            throw new CrimeException("Error generating monthly report.");
        }
    }
}
