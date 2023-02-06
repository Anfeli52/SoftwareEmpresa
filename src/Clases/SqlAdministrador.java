/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;




/**
 *
 * @author Administrador
 */
public class SqlAdministrador {
    
    static conectarBD conexion = new conectarBD();
    static Connection conn = (Connection) conexion.getConexion();
    static ResultSet resultado;
    static PreparedStatement ps;
    
    public static String buscarUsuarioRegistrado(String Correo, String  Contrasena) {
        String busqueda_Usuario = null;
        try {
            String sentencia_buscar_usuario= ("SELECT correo, password FROM usuario WHERE correo = '" +Correo+ "' && password ='"+Contrasena+"'");
            ps= conn.prepareStatement(sentencia_buscar_usuario);
            resultado = ps.executeQuery();
           
            if (resultado.next()){
                busqueda_Usuario ="Usuario encontrado";
               
            }else{
                busqueda_Usuario ="Usuario no encontrado";
            }

        } catch (Exception e) {
            System.err.println(e);
        }
        return busqueda_Usuario; 

    }
      
      public static String buscarNombreUsuario(String correo) {
          
        String busqueda_nombre = null;
        try {
            String sentencia_buscar = ("SELECT username FROM usuario WHERE correo = '" + correo + "'");
            ps = conn.prepareStatement(sentencia_buscar);
            resultado = ps.executeQuery();
            if (resultado.next()) {
                String nombre = resultado.getString("username");
                busqueda_nombre = (nombre);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return busqueda_nombre;
    }
}
 