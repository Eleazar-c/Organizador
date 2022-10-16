/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AdministrarTablero;

/**
 *
 * @author Eleazar
 */
public class ActividadesLista {

    public String getCodigoTarea() {
        return CodigoTarea;
    }

    public void setCodigoTarea(String CodigoTarea) {
        this.CodigoTarea = CodigoTarea;
    }

    public String getCodigoListaAc() {
        return CodigoListaAc;
    }

    public void setCodigoListaAc(String CodigoListaAc) {
        this.CodigoListaAc = CodigoListaAc;
    }

    public String getNombreListaA() {
        return NombreListaA;
    }

    public void setNombreListaA(String NombreListaA) {
        this.NombreListaA = NombreListaA;
    }

    public ActividadesLista(String CodigoTarea, String CodigoListaAc, String NombreListaA) {
        this.CodigoTarea = CodigoTarea;
        this.CodigoListaAc = CodigoListaAc;
        this.NombreListaA = NombreListaA;
    }
     String CodigoTarea;
    String CodigoListaAc;
    String NombreListaA;

    public ActividadesLista() {
    }
    
}
