package model.dao;

import connection.ConnectionFactory;
import java.sql.*;
import javax.swing.JOptionPane;
import model.entities.User;

public class UserDAO {
    
    public User findById(int id) throws SQLException {
        
        String sql = "SELECT * FROM users WHERE id = ?";
        
        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                
                if (rs.next()) {
                    
                    String role = rs.getString("role");
                    if ("regular".equals(role)) {
                        
                        return new User(
                                rs.getString("name"),
                                rs.getString("email"),
                                rs.getString("password"),
                                rs.getString("cpf")
                        );
                        
                    } else if ("restaurant".equals(role)) {
                        
                        return new Restaurant(
                                rs.getString("name"),
                                rs.getString("email"),
                                rs.getString("password"),
                                rs.getString("cpf"),
                                rs.getString("additional_info")
                        );
                    }
                }
            }
        }
        return null;
    }
    
    public String checkLogin(String email, String password) throws SQLException{
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String role = null;
        
        try{
            stmt = con.prepareStatement("SELECT * FROM users WHERE email=? AND password=?");
            stmt.setString(1, email);
            stmt.setString(2, password);
            
            rs = stmt.executeQuery();
            
            if(rs.next()){
                
                role = rs.getString("role");
            }
        }
        catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Unsuccessful connection", "Error", JOptionPane.ERROR_MESSAGE);
        }
        finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return role;
    }
    
    public void create(User u) throws SQLException{
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO users(name, email, password, role, additional_info) VALUES(?,?,?,?,?)");
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getEmail());
            stmt.setString(3, u.getPassword());
            stmt.setString(4, u.getRole());
            
            if(u instanceof Restaurant){
                stmt.setString(5, ((Restaurant) u).getAddress());
            }
            else{
                stmt.setNull(5, Types.VARCHAR);
            }
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Saved successfully");
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Save error: " + ex);
        }
        finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void delete(User u) throws SQLException{
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM products WHERE id = ?");
            stmt.setInt(1, u.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Account deleted successfully");
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Delete error: " + ex);
        }
        finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
}
