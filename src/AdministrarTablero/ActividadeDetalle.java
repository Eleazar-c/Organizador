/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AdministrarTablero;

/**
 *
 * @author Eleazar
 */
public class ActividadeDetalle {
    
    String CodigoListaActividad;
    String CodigoActividad;
    String NombreActividad;
    String Estado;

    public ActividadeDetalle() {
    }

    public ActividadeDetalle(String CodigoListaActividad, String CodigoActividad, String NombreActividad, String Estado) {
        this.CodigoListaActividad = CodigoListaActividad;
        this.CodigoActividad = CodigoActividad;
        this.NombreActividad = NombreActividad;
        this.Estado = Estado;
    }

    public String getCodigoListaActividad() {
        return CodigoListaActividad;
    }

    public void setCodigoListaActividad(String CodigoListaActividad) {
        this.CodigoListaActividad = CodigoListaActividad;
    }

    public String getCodigoActividad() {
        return CodigoActividad;
    }

    public void setCodigoActividad(String CodigoActividad) {
        this.CodigoActividad = CodigoActividad;
    }

    public String getNombreActividad() {
        return NombreActividad;
    }

    public void setNombreActividad(String NombreActividad) {
        this.NombreActividad = NombreActividad;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    
    
    
}
