/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Principal;

import AdministrarTablero.ActividadesLista;
import AdministrarTablero.Tablero;
import AdministrarTablero.Tarea;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import static metodos.ListaActividadesMetodo.DevolverArrayListaActividades;
import metodos.ListadoDeTareas;
import metodos.Metodos;

/**
 *
 * @author Eleazar
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // ListadoDeTareas listadoTarea = new ListadoDeTareas();
        //     //eliminamos el listado de tareas que contenga el tablero
        //    ArrayList<Tarea> ListadoTarea = listadoTarea.DevolverTablaArregloListadoTarea("gxrvs");
        //   for (Tarea t : ListadoTarea) {
        //    System.out.println(t.getCodigo());
        // }
        //archivo donde se tiene que eliminar el registro txt
        Metodos metodo = new Metodos();
        File Archivo = new File("./src/resource/ListaActividades/iukgp.txt");
        if (metodo.isFileExists(Archivo)) {
            ArrayList<ActividadesLista> ListaActividad = DevolverArrayListaActividades("iukgp");
            for (ActividadesLista t : ListaActividad) {
                Archivo = new File("./src/resource/Actividades/eerxu.txt");
                if (metodo.isFileExists(Archivo)) {
                    Archivo = new File("./src/resource/Actividades/eerxu.txt");
                    System.out.println(Archivo.delete());
                    File f = new File("./src/resource/ListaActividades/iukgp.txt");
                    System.out.println(f.delete());
                }
            }

        }

    }

}
