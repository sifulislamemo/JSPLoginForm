
package util;
import java.sql.*;

public class Database {
    static Connection con;
    public static Connection getConnection(){
    
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp_login_form", "root", "root");
        } catch (Exception e) {
        }
        return con;
    }
    
}
