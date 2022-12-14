/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Principal;

import AdministrarTablero.ActividadesLista;
import AdministrarTablero.Tablero;
import AdministrarTablero.Tarea;
import AdministrarTablero.TareaDetalle;
import java.io.File;
import java.util.ArrayList;
import static metodos.ListaActividadesMetodo.DevolverArrayListaActividades;
import metodos.ListadoDeTareas;
import static metodos.ListadoDeTareas.DevolverTablaArregloListadoTarea;
import static metodos.ListadoDeTareas.ModificarArchivoTxtLista;
import metodos.Metodos;
import static metodos.Metodos.DevolverTablaArreglo;
import static metodos.Metodos.ModificarArchivoTxt;
import static metodos.MetodosTareaDetalle.DevolverTareaDetalleArreglo;

/**
 *
 * @author Eleazar
 */
public class ModificarListaTareas extends javax.swing.JFrame {

    String CodigoTablero;
    String CodigoListado;
    String NombreTablero;

    /**
     * Creates new form ModificarListaTareas
     */
    public ModificarListaTareas(String CodigoTablero, String NombreListaT, String CodigoListado, String NombreTablero) {
        initComponents();

        if (CodigoTablero != "") {
            lblMensaje.setVisible(false);
            this.CodigoTablero = CodigoTablero;
            this.CodigoListado = CodigoListado;
            this.NombreTablero = NombreTablero;

            txtNombreListaTarea.setText(NombreListaT);
            this.setLocationRelativeTo(null); //Que cuando aparezca la ventana sea en el centro de la pantalla principal
            this.setResizable(false); //Que no se pueda cambiar el tamaño
        } else {
            Inicio inicio = new Inicio();
            inicio.setVisible(true);
            this.setVisible(false);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombreListaTarea = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnModificarListaT = new javax.swing.JButton();
        btnEliminarListaTarea = new javax.swing.JButton();
        btnRegresarListaT = new javax.swing.JButton();
        lblMensaje = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Modificar Lista de tareas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Nombre Listado de tareas");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));
        jPanel1.add(txtNombreListaTarea, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 240, -1));

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Para modificar el nombre de tarea debe de introducir el nuevo nombre");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("en el campo en blanco.");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        btnModificarListaT.setText("Guardar");
        btnModificarListaT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarListaTActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificarListaT, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 180, 110, -1));

        btnEliminarListaTarea.setText("Eliminar");
        btnEliminarListaTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarListaTareaActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminarListaTarea, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        btnRegresarListaT.setText("Regresar");
        btnRegresarListaT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarListaTActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegresarListaT, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 220, -1, -1));

        lblMensaje.setForeground(new java.awt.Color(51, 153, 0));
        lblMensaje.setText("Error");
        jPanel1.add(lblMensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnModificarListaTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarListaTActionPerformed
        String NombreListados = txtNombreListaTarea.getText();
        if (!"".equals(NombreListados)) {
            ArrayList<Tarea> ListaT = DevolverTablaArregloListadoTarea(this.CodigoTablero);
            Tarea TareaListaModicar = ListaT.stream().filter(t -> t.getCodigo().equals(this.CodigoListado)).findFirst().get();
            TareaListaModicar.setNombre(txtNombreListaTarea.getText().trim());
            ModificarArchivoTxtLista(ListaT, this.CodigoTablero);
            lblMensaje.setText("Nombre de la lista de tareas modificado con exito.");
            lblMensaje.setVisible(true);

        }
    }//GEN-LAST:event_btnModificarListaTActionPerformed

    private void btnRegresarListaTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarListaTActionPerformed
        ListadoTareasAModificar ListadoTareasM = new ListadoTareasAModificar(this.CodigoTablero, this.NombreTablero);
        this.setVisible(false);
        ListadoTareasM.setVisible(true);

    }//GEN-LAST:event_btnRegresarListaTActionPerformed

    private void btnEliminarListaTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarListaTareaActionPerformed
        File Archivo;
        ListadoDeTareas listadoTarea = new ListadoDeTareas();
        //eliminamos el listado de tareas que contenga el tablero
        Archivo = new File("C:/Organizado/Tablero/" + this.CodigoTablero + ".txt");
        if (Archivo.isFile()) {
            ArrayList<Tarea> ListadoTarea = listadoTarea.DevolverTablaArregloListadoTarea(this.CodigoTablero);
            //System.out.println(Archivo.delete());
            for (Tarea t : ListadoTarea) {
                if (t.codigo.equals(this.CodigoListado)) {
                    Archivo = new File("C:/Organizador/ListaTareas/" + t.getCodigo() + ".txt");
                    if (Archivo.isFile()) {
                        ArrayList<TareaDetalle> tareaDetalle = DevolverTareaDetalleArreglo(t.getCodigo());
                        System.out.println(Archivo.delete());
                        for (TareaDetalle l : tareaDetalle) {
                            Archivo = new File("C:/Organizador/ListaActividades/" + l.getCodigoTarea() + ".txt");
                            if (Archivo.isFile()) {
                                ArrayList<ActividadesLista> ListaActividad = DevolverArrayListaActividades(l.getCodigoTarea());
                                System.out.println(Archivo.delete());
                                for (ActividadesLista r : ListaActividad) {
                                    Archivo = new File("C:/Organizador/Actividades/" + r.getCodigoListaAc() + ".txt");
                                    if (Archivo.isFile()) {
                                        System.out.println(Archivo.delete());
                                    }
                                }
                            }
                            //busca si hay comentario y los elimina
                            Archivo = new File("C:/Organizador/Comentarios/" + l.getCodigoTarea() + ".txt");
                            if (Archivo.isFile()) {
                                System.out.println(Archivo.delete());
                            }
                        }

                    }
                }
            }
        }

        ArrayList<Tarea> ListaT = DevolverTablaArregloListadoTarea(this.CodigoTablero);
        ListaT.removeIf(t -> t.getCodigo().equals(this.CodigoListado));

        ModificarArchivoTxtLista(ListaT, CodigoTablero);
        lblMensaje.setText("Lista Tareas Eliminada con exito");
        lblMensaje.setVisible(true);
        btnEliminarListaTarea.setEnabled(false);
        btnModificarListaT.setEnabled(false);
        txtNombreListaTarea.setEnabled(false);

    }//GEN-LAST:event_btnEliminarListaTareaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ModificarListaTareas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarListaTareas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarListaTareas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarListaTareas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificarListaTareas("", "", "", "");
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminarListaTarea;
    private javax.swing.JButton btnModificarListaT;
    private javax.swing.JButton btnRegresarListaT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JTextField txtNombreListaTarea;
    // End of variables declaration//GEN-END:variables
}
