/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AdministrarTablero;

/**
 *
 * @author Eleazar
 */
public class TareaDetalle {

    private String ListaTarea;
    private String CodigoTarea;
    private String NombreTarea;
    private String DescTarea;
    private String FechaInicio;
    private String FechaFinal;

    public TareaDetalle() {
    }

    public String getListaTarea() {
        return ListaTarea;
    }

    public void setListaTarea(String ListaTarea) {
        this.ListaTarea = ListaTarea;
    }

    public String getCodigoTarea() {
        return CodigoTarea;
    }

    public void setCodigoTarea(String CodigoTarea) {
        this.CodigoTarea = CodigoTarea;
    }

    public String getNombreTarea() {
        return NombreTarea;
    }

    public void setNombreTarea(String NombreTablero) {
        this.NombreTarea = NombreTablero;
    }

    public String getDescTarea() {
        return DescTarea;
    }

    public void setDescTarea(String DescTarea) {
        this.DescTarea = DescTarea;
    }

    public String getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(String FechaInicio) {
        this.FechaInicio = FechaInicio;
    }

    public String getFechaFinal() {
        return FechaFinal;
    }

    public void setFechaFinal(String FechaFinal) {
        this.FechaFinal = FechaFinal;
    }

    public TareaDetalle(String CodigoListaTarea, String CodigoTarea, String NombreTarea, String DescTarea, String FechaInicio, String FechaFinal) {
        this.ListaTarea = CodigoListaTarea;
        this.CodigoTarea = CodigoTarea;
        this.NombreTarea = NombreTarea;
        this.DescTarea = DescTarea;
        this.FechaInicio = FechaInicio;
        this.FechaFinal = FechaFinal;

    }

}
