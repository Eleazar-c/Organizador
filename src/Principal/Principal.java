/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Principal;

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
import metodos.ListadoDeTareas;

/**
 *
 * @author Eleazar
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

       ListadoDeTareas listadoTarea = new ListadoDeTareas();
            //eliminamos el listado de tareas que contenga el tablero
            ArrayList<Tarea> ListadoTarea = listadoTarea.DevolverTablaArregloListadoTarea("gxrvs");
            for (Tarea t : ListadoTarea) {
                System.out.println(t.getCodigo());
            }

    }

}
