/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metodos;

import AdministrarTablero.Tarea;
import AdministrarTablero.TareaDetalle;
import java.io.BufferedReader;
import java.io.BufferedWriter;
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
            pw.println("|" + t.getFechaVencimiento());

            pw.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public DefaultTableModel ListaTareasDetalle(String Ruta) {
        Vector cabecera = new Vector();
        cabecera.addElement("No");
        cabecera.addElement("CodigoListaTarea");
        cabecera.addElement("CodigoTarea");
        cabecera.addElement("NombreTarea");
        cabecera.addElement("NombreDesc");
        cabecera.addElement("FechaVencimiento");

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

}
