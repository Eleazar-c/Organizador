/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metodos;

import AdministrarTablero.Tablero;
import AdministrarTablero.Tarea;
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
public class Metodos {

    Vector vPrincipal = new Vector();
    File archivo;

    //Procedimeinto para guardar datos en un vector
    public void guardar(Tablero t) {
        vPrincipal.addElement(t);
    }

    //Procedimiento para guardar datos en un vector para tareas
    public void guardarTarea(Tarea t) {
        vPrincipal.addElement(t);
    }

    //Procedimiento para guardar en un archivo txt
    public void guardarArchivo(Tablero t) {
        try {
            FileWriter fw = new FileWriter("src\\resource\\Tablero\\Tableros.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.print(t.getCodigo());
            pw.println("|" + t.getNombre());
            pw.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    //Procedimiento para guardar la tarea en un archivo txt
    public void guardarArchivoTarea(Tarea t, String CodigoTarea) {
        try {
            FileWriter fw = new FileWriter("src\\resource\\Tablero\\" + CodigoTarea + ".txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.print(t.getCodigoTablero());
            pw.print("|" + t.getCodigo());
            pw.println("|" + t.getNombre());
            pw.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    //Guardar archivo ya modificado
    public static void ModificarArchivoTxt(ArrayList<Tablero> TableroLista, String NombreArchivo) {
        try {
            FileWriter fw = new FileWriter("src\\resource\\Tablero\\" + NombreArchivo + ".txt");
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            for (Tablero t : TableroLista) {
                pw.print(t.getCodigo());
                pw.println("|" + t.getNombre());
            }
            pw.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    //Funcion para mostrar los datos en un data table
    public DefaultTableModel ListaTablerosTareas(String Ruta) {
        Vector cabecera = new Vector();
        cabecera.addElement("Codigo");
        cabecera.addElement("No");
        cabecera.addElement("Nombre");
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
            FileReader fr = new FileReader("src\\resource\\" + Ruta);
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
    
    public boolean EliminarArchivo(String Ruta){
         File fichero = new File("./src/resource/"+ Ruta + ".txt");

        return fichero.delete();
            
    }

    public boolean  EliminarArchivoMetodo(File Ruta){
         //File fichero = new File("./src/resource/"+ Ruta + ".txt");

        return Ruta.delete();
            
    }
   
    //Metodo para devolver la tabla en forma de arreglo
    public static ArrayList<Tablero> DevolverTablaArreglo(String Ruta) {
        // crea el flujo para leer desde el archivo
        File file;
        file = new File("./src/resource/Tablero/Tableros.txt");
        ArrayList<Tablero> listaTareas = new ArrayList();
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
                Tablero e = new Tablero();

                e.setCodigo(delimitar.next());
                e.setNombre(delimitar.next());

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

    //Creamos el archivo que va contener las tareas.
    public boolean CrearArchivoTxt(String Codigo) {
        try {
            archivo = new File("src\\resource\\" + Codigo + ".txt");
            if (archivo.createNewFile()) {
                return true;
            }
        } catch (IOException e) {
            System.out.println(e);
            return false;
        }
        return false;
    }

    //Metodo para listar el listado de tareas que tiene un tablero
    public DefaultTableModel ListaTareas(String Ruta) {
        Vector cabecera = new Vector();
        cabecera.addElement("No");
        cabecera.addElement("CodigoTablero");
        cabecera.addElement("Codigo");
        cabecera.addElement("Nombre");
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
            FileReader fr = new FileReader("src\\resource\\" + Ruta);
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

    public String GenerarCodigo() {
        String res = "";
        for (int cont = 1; cont <= 5; cont++) {
            int num = (int) ((Math.random() * (('z' - 'a') + 1)) + 'a');
            char letra = (char) num;
            res = res + letra;
        }
        return res;
    }
    
     public static boolean isFileExists(File file) {
        return file.isFile();
    }
     
       //Modifica el archivo de tablero.txt
    public static void ModificarArchivoTxtTableros(ArrayList<Tablero> TableroLista) {
        try {
            FileWriter fw = new FileWriter("src\\resource\\Tablero\\Tableros.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            for (Tablero t : TableroLista) {
                pw.print(t.getCodigo());
                pw.println("|" + t.getNombre());
            }
            pw.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
