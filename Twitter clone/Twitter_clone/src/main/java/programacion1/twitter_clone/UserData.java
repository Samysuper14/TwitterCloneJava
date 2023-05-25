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
    public String Username = "";
    public String Password = "";
    
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
}
