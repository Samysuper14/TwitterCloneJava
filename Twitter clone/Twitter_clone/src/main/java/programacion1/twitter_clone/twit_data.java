/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programacion1.twitter_clone;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Samuuel Kono Peralta
 */
public class twit_data {
    private int TwitID = 0;
    private int UserID = 0;
    private int likes = 0;
    private int dislikes = 0;
    private String Username = "";
    private String TwitBody = "";
    
    public ResultSet consultar(){
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "root");
            PreparedStatement comando = conn.prepareStatement("SELECT TwitID, Username, UserID, TwitBody, Likes, Dislikes FROM twits;");                        
            rs = comando.executeQuery();
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.toString()); //Logger.getLogger(Alumno.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            System.out.println(ex.toString());//Logger.getLogger(Alumno.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rs;
        
    }
    
    public void insertar() {
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/twits", "root", "root");
            PreparedStatement st = con1.prepareStatement("INSERT INTO twits (Username, UserID, TwitBody, Likes, Dislikes) VALUES (?, ?, ?, ?, ?)");
            
            st.setString(1, this.Username);
            st.setInt(2, this.UserID);
            st.setString(3, this.TwitBody);
            st.setInt(4, this.likes);
            st.setInt(5, this.dislikes);
            st.executeUpdate();
            System.out.println("Agregado exitosamente!");
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
 
    /**
     * @return the TwitID
     */
    public int getTwitID() {
        return TwitID;
    }

    /**
     * @return the TwitBody
     */
    public String getTwitBody() {
        return TwitBody;
    }

    /**
     * @param Twitbody the Twitbody to set
     */
    public void setTwitBody(String Twitbody){
        this.TwitBody = TwitBody;
    }

    /**
     * @return the UserID
     */
    public int getUserID() {
        return UserID;
    }

    /**
     * @param UserID the UserID to set
     */
    public void setUserID(int UserID) {
        this.UserID = UserID;
    }
    
    /**
     * @return the Username
     */
    public String getUsername(){
        return Username;
    }
    
    /**
     * @param Username the Username to set
     */
    public void setUsername(String Username){
        this.Username = Username;
    }
    
    /**
     * @return the Likes
     */
    public int getLikes() {
        return likes;
    }

    /**
     * @param likes the likes to set
     */
    public void setlikes(int likes) {
        this.likes = likes;
    }
    
    /**
     * @return the Dislikes
     */
    public int getDislikes() {
        return dislikes;
    }

    /**
     * @param dislikes the dislikes to set
     */
    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }
    
}
