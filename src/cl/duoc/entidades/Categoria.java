
package cl.duoc.entidades;


public class Categoria {
  
   //variables    
    private int id;
    private String descripcion;
    
    //contructores

    public Categoria(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }
 
   //getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
