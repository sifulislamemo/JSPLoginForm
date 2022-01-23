
package dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.User;
import util.Database;


public class UserDao {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    public boolean doRegister(User user){
    String sql = "insert into login_info (username, password) values (?, ?)";
     con = Database.getConnection();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            int status = ps.executeUpdate();
            if (status>0) {
                return true;
            }
        } catch (Exception e) {
        }
    return false;
    
    }
    public boolean doLogin(User user){
    String sql = "select * from login_info where username = ? ";
    con = Database.getConnection();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getUsername());
           rs = ps.executeQuery();
            if (rs.next()) {
                String password = rs.getString("password");
                if (user.getPassword().equals(password)) {
                   return true; 
                }
            }
        } catch (Exception e) {
        }
    return false;
    
    
    }
    public List<User> getAll(){
    List<User> users = new ArrayList<User>();
    String sql = "select * from login_info";
    con = Database.getConnection();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
            String username = rs.getString("username");
            String password = rs.getString("password");
            User u = new User();
            u.setUsername(username);
            u.setPassword(password);
            users.add(u);
            }
        } catch (Exception e) {
        }
    return users;
    
    }
}
