/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conexion.Conexion;
import Entity.Administrador;
import Entity.LoginAdmin;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;

public class LoginDao {
     private Connection conn;
    private PreparedStatement ps;

    public LoginDao() {
        conn = Conexion.openConnection();
    }
    
   //MD5 METODO PARA DESE
   public String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] encBytes = md.digest(input.getBytes());
            BigInteger numero = new BigInteger(1, encBytes);
            String encString = numero.toString(16);
            while (encString.length() < 32) {
                encString = "0" + encString;
            }
            return encString;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
     }
    
    public Optional<LoginAdmin> findByUsername(String username) {
        Optional<LoginAdmin> optional = Optional.empty();
        try {
            String sql = "SELECT * FROM usuario_ad WHERE user_name= ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if( rs.next() ) {
                
                LoginAdmin login = new LoginAdmin( 
                        rs.getInt("id_user"),
                        rs.getString("user_name"),
                         rs.getString("contrasenia"));
               
                optional = Optional.of(login
                );
            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            System.err.println(e.getMessage()+"ERRRRRRRRRRRRRRROR");
        }
        return optional;
    }

    public Optional<Administrador> findIdAd(Integer idUserA) {
        Optional<Administrador> optional = Optional.empty();
        try {
            String sql = "SELECT*FROM administrador WHERE id_user=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idUserA);
            ResultSet rs = ps.executeQuery();
            if( rs.next() ) {
                Administrador administrador = new Administrador(
                        rs.getInt("id_administrador"),
                        rs.getString("nombres"),
                        rs.getString("apellidos"),
                        rs.getString("dni"),
                        rs.getString("telefono"));
                optional = Optional.of(administrador );
            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            System.err.println(e.getMessage()+"tttttt");
        }
        return optional;
    }


    
}
