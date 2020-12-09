package cl.duoc.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    
    public static Conexion instance; 
    
    private Connection conexion;
    
    private final String USER = "root";
    private final String PASSWORD = "";
    private final String SERVER = "localhost:3306";
    private final String BBDD = "distribuidora_bicicleta_007d";
    
    
    private Conexion(){
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://" + SERVER + "/" + BBDD;
            conexion = DriverManager.getConnection(url,USER,PASSWORD);
            System.out.println("Conexion exitosa y corriendo en: " + SERVER);
        }
        catch(ClassNotFoundException | SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Problemas con la conexión a la base de datos"
                    + "\nContacte al administrador:\n" + ex.getMessage(),"Mensajes",JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al conectar...");
        }
    }
    
    public synchronized static Conexion obtenerConexion(){
        if(instance == null)
        {
            instance = new Conexion();
        }
        return instance;
    }
    
    public Connection getConexion(){
        return conexion;
    }
    
    public void cerrarConexion(){
        instance = null;
    }
    
}