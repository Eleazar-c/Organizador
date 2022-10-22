/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metodos;

import AdministrarTablero.ActividadeDetalle;
import AdministrarTablero.Tablero;
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
public class ActividadMetodo {

    Vector vPrincipal = new Vector();

    //Procedimeinto para guardar datos en un vector
    public void guardarActividades(ActividadeDetalle c) {
        vPrincipal.addElement(c);
    }

    //Procedimiento para guardar en un archivo txt
    public void guardarArchivoActividades(ActividadeDetalle c, String Archivo) {
        try {
            FileWriter fw = new FileWriter("C:\\Organizador\\Actividades\\" + Archivo + ".txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.print(c.getCodigoListaActividad());
            pw.print("|" + c.getCodigoActividad());
            pw.print("|" + c.getNombreActividad());
            pw.println("|" + c.getEstado());
            pw.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    //Funcion para mostrar los datos en un data table
    public DefaultTableModel ListarActividadesTarea(String Ruta) {

        Vector cabecera = new Vector();
        cabecera.addElement("No");
        cabecera.addElement("CodigoTarea");
        cabecera.addElement("codigoListaA");
        cabecera.addElement("Comentario");
        cabecera.addElement("Estado");

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
            FileReader fr = new FileReader("C:\\Organizador\\" + Ruta + ".txt");
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

    public static boolean isFileExists(File file) {
        return file.isFile();
    }

    public boolean CrearArchivoTxtActividades(String Codigo) {
        try {
            File archivo = new File("C:/Organizador/Actividades/" + Codigo + ".txt");
            if (archivo.createNewFile()) {
                return true;
            }
        } catch (IOException e) {
            System.out.println(e);
            return false;
        }
        return false;
    }

    //Metodo para devolver la tabla en forma de arreglo
    public static ArrayList<ActividadeDetalle> DevolverActividadDetalleArray(String Ruta) {
        // crea el flujo para leer desde el archivo
        File file;
        file = new File("C:/Organizador/Actividades/" + Ruta + ".txt");
        ArrayList<ActividadeDetalle> listaTareas = new ArrayList();
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
                ActividadeDetalle e = new ActividadeDetalle();

                e.setCodigoListaActividad(delimitar.next());
                e.setCodigoActividad(delimitar.next());
                e.setNombreActividad(delimitar.next());
                e.setEstado(delimitar.next());

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
    public static void ModificarArchivoTxtActividadDetalle(ArrayList<ActividadeDetalle> Actividades, String NombreArchivo) {
        try {
            FileWriter fw = new FileWriter("C:\\Organizador\\Actividades\\" + NombreArchivo + ".txt");
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            for (ActividadeDetalle t : Actividades) {
                pw.print("|" +t.getCodigoListaActividad());
                pw.print("|" +t.getCodigoActividad());
                pw.print("|" +t.getNombreActividad());
                pw.println("|" + t.getEstado());
            }
            pw.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
