/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metodos;

import AdministrarTablero.ActividadeDetalle;
import AdministrarTablero.ActividadesLista;
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
public class ListaActividadesMetodo {

    Vector vPrincipal = new Vector();

    //Procedimeinto para guardar datos en un vector
    public void guardarListaActividades(ActividadesLista c) {
        vPrincipal.addElement(c);
    }

    //Procedimiento para guardar en un archivo txt
    public void guardarArchivoActividades(ActividadesLista c, String Archivo) {
        try {
            FileWriter fw = new FileWriter("C:\\Organizador\\ListaActividades\\" + Archivo + ".txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.print(c.getCodigoTarea());
            pw.print("|" + c.getCodigoListaAc());
            pw.println("|" + c.getNombreListaA());
            pw.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    //Funcion para mostrar los datos en un data table
    public DefaultTableModel ListarActividadesTarea(String Ruta) {

        Vector cabecera = new Vector();
        cabecera.addElement("CodigoTarea");
        cabecera.addElement("No");
        cabecera.addElement("codigoListaA");
        cabecera.addElement("No");
        cabecera.addElement("Comentario");

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
                while (datos.hasMoreTokens()) {
                    x.addElement(datos.nextToken());
                    x.addElement(contador);
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
            File archivo = new File("C:/Organizador/ListaActividades/" + Codigo + ".txt");
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
    public static ArrayList<ActividadesLista> DevolverArrayListaActividades(String Ruta) {
        // crea el flujo para leer desde el archivo
        File file;
        file = new File("C:/Organizador/ListaActividades/" + Ruta + ".txt");
        ArrayList<ActividadesLista> listaTareas = new ArrayList();
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
                ActividadesLista e = new ActividadesLista();

                e.setCodigoTarea(delimitar.next());
                e.setCodigoListaAc(delimitar.next());
                e.setNombreListaA(delimitar.next());

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
    public static void ModificarArchivoTxtListaA(ArrayList<ActividadesLista> TableroListaActividades, String NombreArchivo) {
        try {
            FileWriter fw = new FileWriter("C:\\Organizador\\ListaActividades\\" + NombreArchivo + ".txt");
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            for (ActividadesLista t : TableroListaActividades) {
                pw.print(t.getCodigoTarea());
                pw.print("|" + t.getCodigoListaAc());
                pw.println("|" +t.getNombreListaA());
            }
            pw.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
