/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import rojerusan.RSNotifyShadowAnimated;

/**
 *
 * @author Administrador
 */
public class conectarBD {
     private final String base = "yaxja";
    private final String user = "root";
    private final String password = "";
    private final String url = "jdbc:mysql://localhost:3306/" + base;
    private Connection conn = null;
    
    public Connection getConexion()
    {
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection(url, user, password);
            //mensaje de conexión
            new rojerusan.RSNotifyShadowAnimated("¡Hecho!",
                                    "!Conexión éxitosa!", 
                                    3, 
                                    RSNotifyShadowAnimated.PositionNotify.TopRight, 
                                    RSNotifyShadowAnimated.AnimationNotify.UpBottom, 
                                    RSNotifyShadowAnimated.TypeNotify.SUCCESS).setVisible(true);
            // JOptionPane.showMessageDialog(null, "Conexión éxitosa");
         } 
        catch (ClassNotFoundException | SQLException e) {
             new rojerusan.RSNotifyShadowAnimated("!Mensaje¡",
                                    "!Problemas en la conexión!", 
                                    3, 
                                    RSNotifyShadowAnimated.PositionNotify.BottomRight, 
                                    RSNotifyShadowAnimated.AnimationNotify.RightLeft, 
                                    RSNotifyShadowAnimated.TypeNotify.ERROR).setVisible(true);
           // JOptionPane.showMessageDialog(null, "Problemas en la conexión" + e);
        }
      return conn;  
    }
}
