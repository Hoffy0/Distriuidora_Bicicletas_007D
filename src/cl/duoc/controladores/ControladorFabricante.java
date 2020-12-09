
package cl.duoc.controladores;

import cl.duoc.conexion.Conexion;
import cl.duoc.entidades.Fabricante;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ControladorFabricante implements iConexion<Fabricante>{

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


//##################################### CREATE #################################################
    @Override
    public boolean create(Fabricante t) {
        try
        {
            ps = CONEXION.getConexion().prepareCall(SQL_INSERT);
            ps.setInt(1, t.getId());
            ps.setString(2, t.getNombre());
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
    public boolean update(Fabricante t) {
        try
        {
            ps = CONEXION.getConexion().prepareCall(SQL_UPDATE);
            ps.setInt(1, t.getId());
            ps.setString(2, t.getNombre());
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
    public Fabricante read(Object key) {
        Fabricante fabricantes = null;
        try
        {
            ps = CONEXION.getConexion().prepareCall(SQL_READ);
            ps.setInt(1, (int)key);
            rs = ps.executeQuery();
            if(rs.next()){
                fabricantes = new Fabricante(rs.getInt(1), rs.getString(2));
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
        
        return fabricantes;
    }

//##################################### READ ALL #############################################

    @Override
    public ArrayList<Fabricante> readAll() {
        ArrayList<Fabricante> fabricantes = new ArrayList();
        try
        {
            ps = CONEXION.getConexion().prepareCall(SQL_READALL);
            rs = ps.executeQuery();
            while(rs.next()){
                fabricantes.add(new Fabricante(rs.getInt(1), rs.getString(2)));
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
        
        return fabricantes;
    }
    
}
