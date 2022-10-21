/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metodos;

import AdministrarTablero.Tablero;
import AdministrarTablero.Tarea;
import AdministrarTablero.TareaDetalle;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Eleazar
 */
public class MetodosTareaDetalle {

    Vector vPrincipal = new Vector();

    //Procedimiento para guardar datos en un vector para tareas
    public void guardarTarea(TareaDetalle t) {
        vPrincipal.addElement(t);
    }

    //Procedimiento para guardar la tarea en un archivo txt
    public void guardarArchivoTareaDetalle(TareaDetalle t, String CodigoTarea) {
        try {
            FileWriter fw = new FileWriter("src\\resource\\" + CodigoTarea + ".txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.print(t.getListaTarea());
            pw.print("|" + t.getCodigoTarea());
            pw.print("|" + t.getNombreTarea());
            pw.print("|" + t.getDescTarea());
            pw.print("|" + t.getFechaInicio());
            pw.println("|" + t.getFechaFinal());

            pw.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public DefaultTableModel ListaTareasDetalle(String Ruta) {
        Vector cabecera = new Vector();
        cabecera.addElement("No");
        cabecera.addElement("CodigoListaTarea");
        cabecera.addElement("Codigo Tarea");
        cabecera.addElement("NombreTarea");
        cabecera.addElement("Descripcion");
        cabecera.addElement("Fecha Inicio");
        cabecera.addElement("Fecha Final");

        int contador = 1;
        //Creamos un vector que contenga la cabecera de la tabla
        //Creamos un modelo de tabla para agregar el vector , en la ubicacion 0
        DefaultTableModel mdlTable = new DefaultTableModel(cabecera, 0) {
            @Override
            public boolean isCellEditable(int filas, int columnas) {
                return false;
            }
        };
        try {
            FileReader fr = new FileReader("src\\resource\\" + Ruta + ".txt");
            BufferedReader br = new BufferedReader(fr);
            String d;
            while ((d = br.readLine()) != null) {
                StringTokenizer datos = new StringTokenizer(d, "|");
                Vector x = new Vector();
                x.addElement(contador);
                while (datos.hasMoreTokens()) {

                    x.addElement(datos.nextToken());

                }
                mdlTable.addRow(x);
                contador++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return mdlTable;
    }

    //Metodo para devolver la tabla en forma de arreglo
    public static ArrayList<TareaDetalle> DevolverTareaDetalleArreglo(String Ruta) {
        // crea el flujo para leer desde el archivo
        File file;
        file = new File("./src/resource/ListaTareas/" + Ruta + ".txt");
        ArrayList<TareaDetalle> listaTareas = new ArrayList();
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
                TareaDetalle e = new TareaDetalle();

                e.setListaTarea(delimitar.next());
                e.setCodigoTarea(delimitar.next());
                e.setNombreTarea(delimitar.next());
                e.setDescTarea(delimitar.next());
                e.setFechaInicio(delimitar.next());
                e.setFechaFinal(delimitar.next());

                listaTareas.add(e);
            }

            //se cierra el ojeto scanner
            scanner.close();

            System.out.println("Lista actividades leidas satisfactoriamente..");
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        return listaTareas;
    }

    //Guardar archivo ya modificado
    public static void ModificarArchivoTxtDetalleTarea(ArrayList<TareaDetalle> TareaDetalles, String NombreArchivo) {
        try {
            FileWriter fw = new FileWriter("src\\resource\\ListaTareas\\" + NombreArchivo + ".txt");
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            for (TareaDetalle t : TareaDetalles) {
                pw.print(t.getListaTarea());
                pw.print("|" +t.getCodigoTarea());
                pw.print("|" +t.getNombreTarea());
                pw.print("|" +t.getDescTarea());
                pw.print("|" +t.getFechaInicio());
                pw.println("|" +t.getFechaFinal());
            }
            pw.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
