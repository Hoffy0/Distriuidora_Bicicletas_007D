/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.controladores;

import cl.duoc.conexion.Conexion;
import cl.duoc.entidades.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author max_m
 */
public class controladorUsuario implements iConexion<Usuario>{
    
    //Sentencias SQL (C.R.U.D)
    private static final String SQL_INSERT = "";
    private static final String SQL_UPDATE = "";
    private static final String SQL_DELETE = "";
    private static final String SQL_READ = "SELECT * FROM USUARIO WHERE USERNAME = ?";
    private static final String SQL_READALL = "SELECT * FROM USUARIO ORDER BY ID ASC"; 

    //Definir un objeto Conexion para poder enlazar la clase con la DB
    private static final Conexion CONEXION = Conexion.obtenerConexion();
    
    //Definir un objeto que nos permita preprar y ejecutar las QUERY
    private PreparedStatement ps;
    
    //Definir un objeto que nos permita almacenar el resultado de la QUERY (SELECT)
    private ResultSet rs;
    
    //####################################################################################

    @Override
    public boolean create(Usuario t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Usuario t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario read(Object key) {
        Usuario u = null;

        try{
            ps = CONEXION.getConexion().prepareStatement(SQL_READ);
            ps.setString(1, String.valueOf(key));
            rs = ps.executeQuery();
            if(rs.next()){
                u = new Usuario(rs.getString(1), rs.getString(2), rs.getInt(3));
            }
        }
    ////////////////////////////////////////////////
            catch(SQLException ex){
                return null;
            }
    ///////////////////////////////////////////////    
                finally{
                    CONEXION.cerrarConexion();
                }
        return u;
    }

    @Override
    public ArrayList<Usuario> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
