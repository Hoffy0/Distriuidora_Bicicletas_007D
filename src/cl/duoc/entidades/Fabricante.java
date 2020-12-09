
package cl.duoc.entidades;


public class Fabricante {
    
    //variables
    
    private int id;
    private String nombre;
    
    //constructores

    public Fabricante(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
    //getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
    
    
}
