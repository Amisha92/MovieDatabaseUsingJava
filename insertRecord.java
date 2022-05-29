package sqljava;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.SQLException;

public class insertRecord {
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
  
   
  
    public void insert(String name, String actor, String actress, String director, double yearORelease) {  
      
        String sql = "INSERT INTO movie(name, actor, actress, director, yearORelease) VALUES(?,?,?,?,?)";  
   
        try{  
            Connection conn = this.connect();  
            PreparedStatement pstmt = conn.prepareStatement(sql);  
            pstmt.setString(1, name); 
            pstmt.setString(2, actor);
            pstmt.setString(3, actress);
            pstmt.setString(4, director);
            pstmt.setDouble(5, yearORelease);  
            pstmt.executeUpdate();  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
    }  
   
    public static void main(String[] args) {  
   
        insertRecord app = new insertRecord();  
        // insert three new rows  
        app.insert("Ghajini", "Amir", "Asin" , "A R Murugadoss" , 2008);  
        app.insert("Five feet apart", "Cole", "Haley" , "Justin" , 2019);  
        app.insert("Twilight", "robert", "Kristen" , "Catherine" , 2008);  
    } 
}