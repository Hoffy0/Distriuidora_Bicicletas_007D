
package cl.duoc.entidades;


public class Bicicletas {

  //variables
    private int id;
    private String modelo;
    private int fabricante;
    private int categoria;
    private String talla;       
    private String suspension;
    private String transmicion;
    private String frenos;
    private int stock;
    private int valor;
    
    
    //contructores

    public Bicicletas(int id, String modelo, int fabricante, int categoria, String talla, String suspension, String transmicion, String frenos, int stock, int valor) {
        this.id = id;
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.categoria = categoria;
        this.talla = talla;
        this.suspension = suspension;
        this.transmicion = transmicion;
        this.frenos = frenos;
        this.stock = stock;
        this.valor = valor;
    }
    
    //getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getFabricante() {
        return fabricante;
    }

    public void setFabricante(int fabricante) {
        this.fabricante = fabricante;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getSuspension() {
        return suspension;
    }

    public void setSuspension(String suspension) {
        this.suspension = suspension;
    }

    public String getTransmicion() {
        return transmicion;
    }

    public void setTransmicion(String transmicion) {
        this.transmicion = transmicion;
    }

    public String getFrenos() {
        return frenos;
    }

    public void setFrenos(String frenos) {
        this.frenos = frenos;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
    
}

