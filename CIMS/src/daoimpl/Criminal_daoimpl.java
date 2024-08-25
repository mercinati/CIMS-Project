package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Dao.Criminaldao;
import Exception.CriminalException;
import model.Criminal;
import utility.Dao;

public class Criminal_daoimpl implements Criminaldao {

    public Criminal criminal_data(Criminal criminal) throws CriminalException {
    	 String query = "INSERT INTO criminals (criminal_id, name, age, gender, crime_name, address, arrest_date) VALUES (?, ?, ?, ?, ?, ?, ?)";

         try (Connection con = Dao.getConnection(); 
        	PreparedStatement ps = con.prepareStatement(query)) {
             ps.setInt(1, criminal.getCriminal_id());
             ps.setString(2, criminal.getName());
             ps.setInt(3, criminal.getAge());
             ps.setString(4, criminal.getGender());
             ps.setString(5, criminal.getCrime_name());
             ps.setString(6, criminal.getAddress());
             ps.setString(7, criminal.getArrest_date());

             int x = ps.executeUpdate();
             if ( x > 0) {
                 System.out.println("Criminal data Inserted successfully.");
             }
         } catch (SQLException e) {
             e.printStackTrace();
         }
        return null;
    }

    public Criminal search_data(int criminal_id) throws CriminalException {
    	 String query = "SELECT * FROM criminals WHERE criminal_id = ?";
         Criminal criminal = null;

         try (Connection con = Dao.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
             ps.setInt(1, criminal_id);
             ResultSet rs = ps.executeQuery();

             if (rs.next()) {
                 criminal = new Criminal();
                 criminal.setCriminal_id(rs.getInt("criminal_id"));
                 criminal.setName(rs.getString("name"));
                 criminal.setAge(rs.getInt("age"));
                 criminal.setGender(rs.getString("gender"));
                 criminal.setCrime_name(rs.getString("crime_name"));
                 criminal.setAddress(rs.getString("address"));
                 criminal.setArrest_date(rs.getString("arrest_date"));
             }
         } catch (SQLException e) {
             e.printStackTrace();
         }

         return criminal;
        //return null;
    }

    public void delete_criminal_data(int criminal_id) throws CriminalException {
        try (Connection con = Dao.getConnection()) {
            PreparedStatement ps = con.prepareStatement("DELETE FROM criminals WHERE criminal_id = ?");
            ps.setInt(1, criminal_id);

            int i = ps.executeUpdate();
            if (i > 0) {
                System.out.println("Criminal data deleted successfully.");
            } else {
                throw new CriminalException("Criminal ID not found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new CriminalException("Error deleting criminal data.");
        }
    }
}
