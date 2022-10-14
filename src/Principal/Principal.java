/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Principal;

import AdministrarTablero.Tablero;
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

/**
 *
 * @author Eleazar
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // crea el flujo para leer desde el archivo
        File file;
        file = new File("./src/resource/ListaTableros/Tableros.txt");
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
        for (Tablero t : listaTareas) {
            System.out.println(t.getNombre());

        }

    }

}
