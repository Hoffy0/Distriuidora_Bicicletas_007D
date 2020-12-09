
package cl.duoc.controladores;
import java.util.ArrayList;

public interface iConexion<T> {

    public boolean create(T t);
    public boolean update(T t);
    public boolean delete(Object key);
    
    public T read(Object key);
    public ArrayList<T> readAll();
     
}
