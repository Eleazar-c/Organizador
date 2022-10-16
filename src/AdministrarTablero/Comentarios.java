/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AdministrarTablero;

/**
 *
 * @author Eleazar
 */
public class Comentarios {
    
    String CodigoTarea;
    String CodigoComentario;
    String Comentario;

    public Comentarios() {
    }

    public String getCodigoTarea() {
        return CodigoTarea;
    }

    public void setCodigoTarea(String CodigoTarea) {
        this.CodigoTarea = CodigoTarea;
    }

    public String getCodigoComentario() {
        return CodigoComentario;
    }

    public void setCodigoComentario(String CodigoComentario) {
        this.CodigoComentario = CodigoComentario;
    }

    public String getComentario() {
        return Comentario;
    }

    public void setComentario(String Comentario) {
        this.Comentario = Comentario;
    }

    
    public Comentarios(String CodigoTarea, String CodigoComentario, String Comentario) {
        this.CodigoTarea = CodigoTarea;
        this.CodigoComentario = CodigoComentario;
        this.Comentario = Comentario;
    }
            
    
}
