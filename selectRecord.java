package sqljava;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.sql.Statement; 
import java.util.*;

public class selectRecord {
	private Connection connect() {  
        // SQLite connection string  
        String url = "jdbc:sqlite:C://sqlite/SSSIT.db";  
        Connection conn = null;  
        try {  
            conn = DriverManager.getConnection(url);  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
        return conn;  
    }  
   
  
    public void selectAll(String a){  
        String sql = "SELECT id,name,actor,actress,director,yearORelease FROM movie WHERE actor= ?";  
          
        try {  
            Connection conn = this.connect();  
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, a);
            ResultSet rs = pstmt.executeQuery();
              
            // loop through the result set  
            while (rs.next()) {  
                System.out.println(rs.getInt("id") +  "\t" +   
                                   rs.getString("name") + "\t" +  
                                   rs.getString("actor") + "\t" +
                                   rs.getString("actress") + "\t" +
                                   rs.getString("director") + "\t" +
                                   rs.getDouble("yearORelease"));  
            }  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
    }  
      
     
    /** 
     * @param args the command line arguments 
     */  
    public static void main(String[] args) {  
    	Scanner sc=new Scanner(System.in);
    	System.out.println("Enter the actor name");
    	String a=sc.nextLine();
        selectRecord app = new selectRecord();  
        app.selectAll(a); 
        
    }  

}
