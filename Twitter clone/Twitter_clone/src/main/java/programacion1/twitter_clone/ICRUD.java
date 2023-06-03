/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package programacion1.twitter_clone;

/**
 *
 * @author Samuuel Kono Peralta
 */
public interface ICRUD {
    public void register();
    public boolean verify();
    public boolean verify_user();
    public void connect();
    public void disconnect();
    public void disconnect_log();
    public void getData(String Username);
    public void getLogData();
    public boolean active();
}
