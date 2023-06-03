/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programacion1.twitter_clone;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Samuuel Kono Peralta
 */
public class UserData implements ICRUD {
    public int UID = 0;
    public int LogUID = 0;
    public String Username = "";
    public String LogUsername = "";
    public String Password = "";
    public boolean Connection = false;
    
    @Override
    public void register(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Users", "root", "root");//connection string
            System.out.println("Conectado...");
            PreparedStatement comando = con.prepareStatement("INSERT INTO users (Username, P_word) VALUES(?,?);");
            
            comando.setString(1, this.Username);
            comando.setString(2, this.Password);
            comando.executeUpdate();
            
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
    }
    
    @Override
    public boolean verify(){
         try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Users", "root", "root");//connection string
            System.out.println("Conectado...");
            PreparedStatement comando = con.prepareStatement("SELECT * FROM users WHERE Username=? and P_word=?;");
            
            comando.setString(1, this.Username);
            comando.setString(2, this.Password);
            ResultSet resultSet = comando.executeQuery();
            boolean result = resultSet.next();
            return result;
            
        }catch(Exception ex){
            System.out.println(ex.toString());
            return false;
        }
    }
    
    @Override
    public boolean verify_user(){
         try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Users", "root", "root");//connection string
            System.out.println("Conectado...");
            PreparedStatement comando = con.prepareStatement("SELECT * FROM users WHERE Username=?;");
            
            comando.setString(1, this.Username);
            ResultSet resultSet = comando.executeQuery();
            boolean result = resultSet.next();
            return result;
            
        }catch(Exception ex){
            System.out.println(ex.toString());
            return false;
        }
    }
    
    @Override
    public void connect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "root");
            PreparedStatement comando = con.prepareStatement("INSERT INTO userlog (UID, Username, Connection) VALUES (?, ?, 1);");
            
            Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "root");
            PreparedStatement coman2 = con2.prepareStatement("SELECT UserID FROM users WHERE Username = ?;");
            
            coman2.setString(1, this.Username);
            ResultSet rs1 = coman2.executeQuery();
            
            System.out.println(rs1);
            if(rs1.next()){
                this.UID = ((Number) rs1.getObject(1)).intValue();
            }
            
            comando.setInt(1, this.UID);
            comando.setString(2, this.Username);
            comando.executeUpdate();
            
            
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
    }
    
    @Override
    public void disconnect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "root");
            PreparedStatement comando = con.prepareStatement("INSERT INTO userlog (UID, Username, Connection) VALUES (?, ?, 0);");
            
            Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "root");
            PreparedStatement coman2 = con2.prepareStatement("SELECT UserID FROM users WHERE Username = ?;");
            
            coman2.setString(1, this.Username);
            ResultSet rs1 = coman2.executeQuery();
            
            System.out.println(rs1);
            if(rs1.next()){
                this.UID = ((Number) rs1.getObject(1)).intValue();
            }
            
            comando.setInt(1, this.UID);
            comando.setString(2, this.Username);
            comando.executeUpdate();
            
            
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
    }
    
    @Override
    public void disconnect_log(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "root");
            PreparedStatement comando = con.prepareStatement("INSERT INTO userlog (UID, Username, Connection) VALUES (?, ?, 0);");
            
            Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "root");
            PreparedStatement coman2 = con2.prepareStatement("SELECT UserID FROM users WHERE Username = ?;");
            
            coman2.setString(1, this.LogUsername);
            ResultSet rs1 = coman2.executeQuery();
            
            System.out.println(rs1);
            if(rs1.next()){
                this.LogUID = ((Number) rs1.getObject(1)).intValue();
            }
            
            comando.setInt(1, this.LogUID);
            comando.setString(2, this.LogUsername);
            comando.executeUpdate();
            
            
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
    }
    
    @Override
    public void getData(String Username){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        
            Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "root");
            PreparedStatement coman2 = con2.prepareStatement("select * from userlog where Username = ? order by Username desc limit 1;");
            coman2.setString(1, Username);
            ResultSet rs = coman2.executeQuery();
            
            if(rs.next()){
                this.LogUID = Integer.parseInt(rs.getString("UID"));
                this.LogUsername = rs.getString("Username");
                this.Connection = "1".equals(rs.getString("Connection"));
                System.out.println(this.LogUID);
                System.out.println(this.LogUsername);
                System.out.println(this.Connection);
            }
                    
        }catch(Exception ex){
            System.out.println(ex.toString());
        }   
    }
    
    @Override
    public void getLogData(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        
            Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "root");
            PreparedStatement coman2 = con2.prepareStatement("select * from userlog order by Username desc limit 1;");
            
            ResultSet rs = coman2.executeQuery();
            
            if(rs.next()){
                this.UID = Integer.parseInt(rs.getString("UID"));
                this.Username = rs.getString("Username");
                this.Connection = "1".equals(rs.getString("Connection"));
                System.out.println(this.UID);
                System.out.println(this.Username);
                System.out.println(this.Connection);
            }
                    
        }catch(Exception ex){
            System.out.println(ex.toString());
        }   
    }
    
    @Override
    public boolean active(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "root");
            PreparedStatement comando = con.prepareStatement("select * from userlog where Username = ? order by LogNo desc limit 1;");
            comando.setString(1, this.Username);
            ResultSet rs = comando.executeQuery();
            if(rs.next()){
                this.Connection = "1".equals(rs.getString("Connection"));
                System.out.println(this.Connection);
                return this.Connection;
            } else {
                return false;
            }
                    
        }catch(Exception ex){
            System.out.println(ex.toString());
            return true;
        }
    }
    
}
