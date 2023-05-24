/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Interfaces.registroRio;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

/**
 *
 * @author Administrador
 */
public class SqlRio {

    
    //datos de conexión
    static conectarBD conexion = new conectarBD();
    static Connection conn = (Connection) conexion.getConexion();
    static PreparedStatement ps;                                                                                          

    public static int guardar(String correo) {
        int rsu = 0;

        String sql = "INSERT INTO contaminacion(codigoAgua, nivelContaminante, nivelTurbidad, nombreAgua, cuerpoAgua, fotoAgua, fechaMuestra, imagen, correoContaminacion) VALUES(?,?,?,?,?,?,?,?,?)";

        try {
            //la clase Date y SimpleDateFormat nos permiten manejar la fecha de ingreso
            
            Date fechaRegistro = Date.from(Instant.now());
            SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");
            
            FileInputStream archivoFoto;
            
            ps = (PreparedStatement) conn.prepareStatement(sql);
            ps.setString(1, registroRio.lbCodigo.getText());
            ps.setString(2, registroRio.ctNivelPH.getText());
            ps.setString(3, registroRio.ctTubidad.getText());
            ps.setString(4, registroRio.ctNombreRio.getText());
            ps.setString(5, registroRio.cuerpoRio);
            ps.setString(6, registroRio.cTNombreImagen.getText());
            //ps.setBlob(6, registroRio.imagen);
            ps.setString(7, formatofecha.format(fechaRegistro));
            //ps.setBlob(7, registroRio.imagen);
            
            archivoFoto = new FileInputStream(registroRio.cTNombreImagen.getText());
            
            ps.setBinaryStream(8, archivoFoto);
            
            ps.setString(9, correo);
            rsu = ps.executeUpdate();

        } catch (Exception e) {
            System.err.println(e);
        }
        return rsu;
    }

}
