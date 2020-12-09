
package cl.duoc.controladores;

import cl.duoc.conexion.Conexion;
import cl.duoc.entidades.Bicicletas;
import cl.duoc.entidades.CustomException;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;



public class controladorBicilcetas implements iConexion<Bicicletas> {
    
    //Sentencias SQL (C.R.U.D)
    private static final String SQL_INSERT = "INSERT INTO CATEGORIA (ID, MODELO, FABRICANTE, CATEGORIA, TALLA, SUSPENSION, TRANSMISION, FRENOS, STOCK, VALOR) VALUES (?,?,?,?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE CATEGORIA SET MODELO = ?, FABRICANTE = ?, CATEGORIA = ?, TALLA = ?, SUSPENSION = ?, TRANSMISION = ? , FRENOS = ? , STOCK = ? , VALOR = ? WHERE ID = ?";
    private static final String SQL_DELETE = "DELETE FROM CATEGORIA WHERE ID = ?";
    private static final String SQL_READ = "SELECT * FROM CATEGORIA WHERE ID = ?";
    private static final String SQL_READALL = "SELECT * FROM CATEGORIA ORDER BY ID ASC"; 

    //Definir un objeto Conexion para poder enlazar la clase con la DB
    private static final Conexion CONEXION = Conexion.obtenerConexion();
    
    //Definir un objeto que nos permita preprar y ejecutar las QUERY
    private PreparedStatement ps;
    
    //Definir un objeto que nos permita almacenar el resultado de la QUERY (SELECT)
    private ResultSet rs;

//##################################### CREATE ######################################################
    @Override
    public boolean create(Bicicletas t) {
        try
        {
            ps = CONEXION.getConexion().prepareCall(SQL_INSERT);
            ps.setInt(1, t.getId());
            ps.setString(2, t.getModelo());
            ps.setInt(3, t.getFabricante());
            ps.setInt(4, t.getCategoria());
            ps.setString(5, t.getTalla());
            ps.setString(6, t.getSuspension());
            ps.setString(7, t.getTransmicion());
            ps.setString(8, t.getFrenos());
            ps.setInt(9, t.getStock());
            ps.setInt(10, t.getValor());
            if(ps.executeUpdate() > 0){
                return true;
            }            
        }
    /////////////////////////////////////////////////    
            catch(SQLException ex){

                return false;
            }
    ////////////////////////////////////////////////    
                finally
                {
                    CONEXION.cerrarConexion();
                }
        
        return false;
    }
//###################################### UPDATE ###############################################
    @Override
    public boolean update(Bicicletas t) {
        try
        {
            ps = CONEXION.getConexion().prepareCall(SQL_UPDATE);
            ps.setInt(10, t.getId());
            ps.setString(1, t.getModelo());
            ps.setInt(2, t.getFabricante());
            ps.setInt(3, t.getCategoria());
            ps.setString(4, t.getTalla());
            ps.setString(5, t.getSuspension());
            ps.setString(6, t.getTransmicion());
            ps.setString(7, t.getFrenos());
            ps.setInt(8, t.getStock());
            ps.setInt(9, t.getValor());

            if(ps.executeUpdate() > 0){
                return true;
            }            
        }
    /////////////////////////////////////////////////    
            catch(SQLException ex){

                return false;
            }
    ////////////////////////////////////////////////    
                finally
                {
                    CONEXION.cerrarConexion();
                }
        
        return false;
    }

//##################################### DELETE ##############################################

    @Override
    public boolean delete(Object key) {
        try
        {
            ps = CONEXION.getConexion().prepareCall(SQL_DELETE);
            ps.setInt(1, (int)key);
            if(ps.executeUpdate() > 0){
                return true;
            }            
        }
    /////////////////////////////////////////////////    
            catch(SQLException ex){

                return false;
            }
    ////////////////////////////////////////////////    
                finally
                {
                    CONEXION.cerrarConexion();
                }
        
        return false;
    }

//####################################### READ ##############################################

    @Override
    public Bicicletas read(Object key) {
        Bicicletas bici = null;
        try
        {
            ps = CONEXION.getConexion().prepareCall(SQL_READ);
            ps.setInt(1, (int)key);
            rs = ps.executeQuery();
            if(rs.next()){
                bici = new Bicicletas(
                    rs.getInt(1), 
                    rs.getString(2), 
                    rs.getInt(3), 
                    rs.getInt(5), 
                    rs.getString(5), 
                    rs.getString(6), 
                    rs.getString(7), 
                    rs.getString(8), 
                    rs.getInt(9), 
                    rs.getInt(10));
            }
        }
    /////////////////////////////////////////////////    
            catch(SQLException ex){
                return null;
                
            }
            
    ////////////////////////////////////////////////    
                finally
                {
                    CONEXION.cerrarConexion();
                }
        
        return bici;
    }

//##################################### READ ALL #############################################

    @Override
    public ArrayList<Bicicletas> readAll() {
        ArrayList<Bicicletas> bicis = new ArrayList();
        try
        {
            ps = CONEXION.getConexion().prepareCall(SQL_READALL);
            rs = ps.executeQuery();
            while(rs.next()){
                bicis.add(new Bicicletas(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(5), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getInt(10)));
            }
        }
    /////////////////////////////////////////////////    
            catch(SQLException ex){
                return null;
                
            }
    //////////////////////////////////////////////////    
                finally
                {
                    CONEXION.cerrarConexion();
                }
        
        return bicis;
    
    }

    
    
}
