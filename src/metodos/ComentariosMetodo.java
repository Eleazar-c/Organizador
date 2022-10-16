/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metodos;

import AdministrarTablero.Comentarios;
import AdministrarTablero.Tablero;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Eleazar
 */
public class ComentariosMetodo {

    Vector vPrincipal = new Vector();

    //Procedimeinto para guardar datos en un vector
    public void guardarComentario(Comentarios c) {
        vPrincipal.addElement(c);
    }

    //Procedimiento para guardar en un archivo txt
    public void guardarArchivoComentario(Comentarios c, String Archivo) {
        try {
            FileWriter fw = new FileWriter("src\\resource\\Comentarios\\" + Archivo + ".txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.print(c.getCodigoTarea());
            pw.print("|" + c.getCodigoComentario());
            pw.println("|" + c.getComentario());
            pw.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    //Funcion para mostrar los datos en un data table
    public DefaultTableModel ListarComentariosTarea(String Ruta) {

        Vector cabecera = new Vector();
        cabecera.addElement("CodigoTarea");
        cabecera.addElement("No");
        cabecera.addElement("CodigoComentario");
        cabecera.addElement("Comentario");
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
            FileReader fr = new FileReader("src\\resource\\" + Ruta + ".txt");
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

    public boolean CrearArchivoTxtComenatario(String Codigo) {
        try {
            File archivo = new File("./src/resource/Comentarios/" + Codigo + ".txt");
            if (archivo.createNewFile()) {
                return true;
            }
        } catch (IOException e) {
            System.out.println(e);
            return false;
        }
        return false;
    }

}
