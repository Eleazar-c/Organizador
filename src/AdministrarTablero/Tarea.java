/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AdministrarTablero;

/**
 *
 * @author Eleazar
 */
public class Tarea {

    private String CodigoTablero;
    private String NombreTablero;
    private String codigo;
    private String nombre;

    public String getCodigoTablero() {
        return CodigoTablero;
    }

    public void setCodigoTablero(String CodigoTablero) {
        this.CodigoTablero = CodigoTablero;
    }

    public String getNombreTablero() {
        return NombreTablero;
    }

    public void setNombreTablero(String NombreTablero) {
        this.NombreTablero = NombreTablero;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Tarea(String CodigoTablero,String NombreTablero, String codigo, String nombre) {
        this.CodigoTablero = CodigoTablero;
        this.NombreTablero = CodigoTablero;
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Tarea() {
    }
}
