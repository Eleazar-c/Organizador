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
    private String FechaVencimiento;

   
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

     public String getFechaVencimiento() {
        return FechaVencimiento;
    }

    public void setFechaVencimiento(String FechaVencimiento) {
        this.FechaVencimiento = FechaVencimiento;
    }

    public TareaDetalle(String CodigoListaTarea, String CodigoTarea, String NombreTarea, String DescTarea, String FechaVencimiento) {
        this.ListaTarea = CodigoListaTarea;
        this.CodigoTarea = CodigoTarea;
        this.NombreTarea = NombreTarea;
        this.DescTarea = DescTarea;
        this.FechaVencimiento=FechaVencimiento;
    }

}
