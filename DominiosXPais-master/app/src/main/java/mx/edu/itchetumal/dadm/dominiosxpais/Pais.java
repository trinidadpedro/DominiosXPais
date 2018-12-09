package mx.edu.itchetumal.dadm.dominiosxpais;

public class Pais {
    private int bandera;
    private String nombre;
    private String dominio;

    public Pais(int bandera, String nombre, String dominio) {
        this.bandera = bandera;
        this.nombre = nombre;
        this.dominio = dominio;
    }

    public int getBandera() {
        return bandera;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDominio() {
        return dominio;
    }
}
