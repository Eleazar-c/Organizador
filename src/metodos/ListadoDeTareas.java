/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metodos;

import AdministrarTablero.Tablero;
import AdministrarTablero.Tarea;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Eleazar
 */
public class ListadoDeTareas {

    public static ArrayList<Tarea> DevolverTablaArregloListadoTarea(String Ruta) {
        // crea el flujo para leer desde el archivo
        File file;
        file = new File("C:/Organizador/Tablero/" + Ruta + ".txt");
        ArrayList<Tarea> listaTareas = new ArrayList();
        Scanner scanner;
        try {
            //se pasa el flujo al objeto scanner
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                // el objeto scanner lee linea a linea desde el archivo
                String linea = scanner.nextLine();
                Scanner delimitar = new Scanner(linea);
                //se usa una expresión regular
                //que valida que antes o despues de un pipe (|) exista cualquier cosa
                //parte la cadena recibida cada vez que encuentre un pipe

                delimitar.useDelimiter("\\s*\\|\\s*");
                Tarea e = new Tarea();

                e.setCodigoTablero(delimitar.next());
                e.setCodigo(delimitar.next());
                e.setNombre(delimitar.next());

                listaTareas.add(e);
            }

            //se cierra el ojeto scanner
            scanner.close();

            System.out.println("Lista actividades leidas satisfactoriamente.XD.");
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        return listaTareas;
    }

    //Guardar archivo ya modificado
    public static void ModificarArchivoTxtLista(ArrayList<Tarea> TareaLista, String NombreArchivo) {
        try {
            FileWriter fw = new FileWriter("C:\\Organizador\\Tablero\\" + NombreArchivo + ".txt");
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            for (Tarea t : TareaLista) {
                pw.print(t.getCodigoTablero());
                pw.print("|" +t.getCodigo());
                pw.println("|" + t.getNombre());
            }
            pw.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

}
