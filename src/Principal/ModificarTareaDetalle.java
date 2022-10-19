/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Principal;

import AdministrarTablero.ActividadesLista;
import AdministrarTablero.Tablero;
import AdministrarTablero.Tarea;
import AdministrarTablero.TareaDetalle;
import java.awt.Color;
import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static metodos.ListaActividadesMetodo.DevolverArrayListaActividades;
import metodos.Metodos;
import static metodos.Metodos.DevolverTablaArreglo;
import static metodos.Metodos.ModificarArchivoTxt;
import static metodos.MetodosTareaDetalle.DevolverTareaDetalleArreglo;
import static metodos.MetodosTareaDetalle.ModificarArchivoTxtDetalleTarea;

/**
 *
 * @author Eleazar
 */
public class ModificarTareaDetalle extends javax.swing.JFrame {

    String CodigoListaTarea;
    String CodigoTareaDetalle;
    String NombreTarea;
    String DescTarea;
    String FechaI;
    String FechaF;
    String CodigoTablero;
    String NombreTablero;
    String NombreListadoTarea;

    /**
     *
     * @param CodigoListaTarea
     * @param CodigoTareaDetalle
     * @param NombreTarea
     * @param DescTarea
     * @param FechaI
     * @param FechaF
     * @param CodigoTablero
     * @param NombreTablero
     * @param NombreTarea
     */
    public ModificarTareaDetalle(String CodigoListaTarea, String CodigoTareaDetalle, String NombreTarea, String DescTarea, String FechaI, String FechaF, String CodigoTablero, String NombreTablero, String NombreListaTarea) {
        initComponents();

        try {
            if (!"".equals(CodigoListaTarea)) {
                this.setLocationRelativeTo(null); //Que cuando aparezca la ventana sea en el centro de la pantalla principal
                this.setResizable(false); //Que no se pueda cambiar el tamaño
                lblMensaje.setVisible(false);
                this.CodigoListaTarea = CodigoListaTarea;
                this.CodigoTareaDetalle = CodigoTareaDetalle;
                this.NombreTarea = NombreTarea;
                this.DescTarea = DescTarea;
                this.FechaI = FechaI;
                this.FechaF = FechaF;
                this.CodigoTablero = CodigoTablero;
                this.NombreTablero = NombreTablero;
                this.NombreListadoTarea = NombreListaTarea;

                SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");

                txtNombreTareaDetalle.setText(NombreTarea);
                txtDescripcionTareaDetalle.setText(DescTarea);

                Date FechaInicioParceada = fecha.parse(FechaI);
                txtFechaInicio.setDate(FechaInicioParceada);
                Date FechaFinalParceada = fecha.parse(FechaF);
                txtFechaFinal.setDate(FechaFinalParceada);

                Date datetime = new Date();

                String FechaActual = fecha.format(datetime);
                Date FechaActualparceada = fecha.parse(FechaActual);

                if (FechaActualparceada.compareTo(FechaFinalParceada) > 0) {
                    lblEstado.setText("Vencida");
                    lblEstado.setForeground(Color.red);
                } else if (FechaActualparceada.compareTo(FechaFinalParceada) == 0) {
                    lblEstado.setText("Por Vencer");
                    lblEstado.setForeground(Color.yellow);
                } else {
                    lblEstado.setText("En Tiempo");
                    lblEstado.setForeground(Color.green);
                }

            } else {
                Inicio inicio = new Inicio();
                inicio.setVisible(true);
                this.setVisible(false);
            }
        } catch (Exception e) {
            e.getMessage();
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
        txtNombreTareaDetalle = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtFechaInicio = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        txtFechaFinal = new com.toedter.calendar.JDateChooser();
        lblEstado = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        btnRegresarTareas = new javax.swing.JButton();
        lblMensaje = new javax.swing.JLabel();
        btnComenatarios = new javax.swing.JButton();
        btbListaActividades = new javax.swing.JButton();
        btnEliminarTarea = new javax.swing.JButton();
        txtDescripcionTareaDetalle = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.MatteBorder(null), "Detallle Tarea", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("*Nombre Tarea:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));
        jPanel1.add(txtNombreTareaDetalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 240, -1));

        jLabel2.setText("*Descripcion de la tarea:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLabel3.setText("Fecha Inicio");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));
        jPanel1.add(txtFechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 130, -1));

        jLabel4.setText("Fecha Final:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));
        jPanel1.add(txtFechaFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 130, -1));

        lblEstado.setBackground(new java.awt.Color(51, 102, 0));
        lblEstado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEstado.setForeground(new java.awt.Color(0, 0, 0));
        lblEstado.setText("Estado");
        jPanel1.add(lblEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 50, -1, -1));

        jLabel5.setText("Estado de la tarea.");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 30, -1, -1));

        btnModificar.setBackground(new java.awt.Color(51, 204, 0));
        btnModificar.setForeground(new java.awt.Color(255, 255, 255));
        btnModificar.setText("Guardar Cambios");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 330, -1, -1));

        btnRegresarTareas.setText("Regresar");
        btnRegresarTareas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarTareasActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegresarTareas, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 330, -1, -1));

        lblMensaje.setText("lblMensaje");
        jPanel1.add(lblMensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        btnComenatarios.setText("Ver Comentarios");
        btnComenatarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComenatariosActionPerformed(evt);
            }
        });
        jPanel1.add(btnComenatarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(388, 240, 120, -1));

        btbListaActividades.setText("Lista Actividades");
        btbListaActividades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbListaActividadesActionPerformed(evt);
            }
        });
        jPanel1.add(btbListaActividades, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 200, 130, -1));

        btnEliminarTarea.setBackground(new java.awt.Color(255, 51, 51));
        btnEliminarTarea.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarTarea.setText("Eliminar tarea");
        btnEliminarTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarTareaActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminarTarea, new org.netbeans.lib.awtextra.AbsoluteConstraints(382, 280, 130, -1));
        jPanel1.add(txtDescripcionTareaDetalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 490, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarTareasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarTareasActionPerformed
        //String CodigoTablero, String CodigoTarea, String NombreTablero, String NombreTarea
        DetalleTarea detalleTarea = new DetalleTarea(this.CodigoTablero, this.CodigoListaTarea, this.NombreTablero, this.NombreListadoTarea);
        detalleTarea.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegresarTareasActionPerformed

    private void btnComenatariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComenatariosActionPerformed
        ListaComentarios ventanaComentarios = new ListaComentarios(this.CodigoListaTarea, this.CodigoTareaDetalle, this.NombreTarea, this.DescTarea, this.FechaI, this.FechaF, this.CodigoTablero, this.NombreTablero, this.NombreListadoTarea);

        ventanaComentarios.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnComenatariosActionPerformed

    private void btbListaActividadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbListaActividadesActionPerformed
        ListaActividades ventanaComentarios = new ListaActividades(this.CodigoListaTarea, this.CodigoTareaDetalle, this.NombreTarea, this.DescTarea, this.FechaI, this.FechaF, this.CodigoTablero, this.NombreTablero, this.NombreListadoTarea);

        ventanaComentarios.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btbListaActividadesActionPerformed

    private void btnEliminarTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarTareaActionPerformed
        //codigo tarea que esta adentro del archivo txt y eliminar el archivo ListaActividades
        //lblMensaje.setText(this.CodigoTareaDetalle);
        int valor = 1;
        //archivo donde se tiene que eliminar el registro txt
        Metodos metodo = new Metodos();
        File Archivo = new File("./src/resource/ListaActividades/" + this.CodigoTareaDetalle + ".txt");
        if (Archivo.isFile()) {
            ArrayList<ActividadesLista> ListaActividad = DevolverArrayListaActividades(this.CodigoTareaDetalle);
            if (Archivo.delete()) {
                for (ActividadesLista r : ListaActividad) {
                    Archivo = new File("./src/resource/Actividades/" + r.getCodigoListaAc() + ".txt");
                    if (Archivo.isFile()) {
                        System.out.println(Archivo.delete());
                    }
                }
            } else {
                valor = 0;
            }
        }

        if (valor == 1) {
            ArrayList<TareaDetalle> ListaTareaDetalle = DevolverTareaDetalleArreglo(CodigoListaTarea);
            ListaTareaDetalle.removeIf(t -> t.getCodigoTarea().equals(this.CodigoTareaDetalle));

            ModificarArchivoTxtDetalleTarea(ListaTareaDetalle, this.CodigoListaTarea);
//            lblMensaje.setForeground(Color.green);
            lblMensaje.setVisible(true);
            lblMensaje.setText("Tarea Eliminada.");

            btnComenatarios.setEnabled(false);
            btnEliminarTarea.setEnabled(false);
            btnModificar.setEnabled(false);
            btbListaActividades.setEnabled(false);
        } else {
            lblMensaje.setForeground(Color.red);
            lblMensaje.setVisible(true);
            lblMensaje.setText("No se puedo eliminar los listados por favor cierre todos los arcivos txt que esten abiertos.");
        }

    }//GEN-LAST:event_btnEliminarTareaActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        String NombreTarea = txtNombreTareaDetalle.getText();
        String DescripcionTarea = txtDescripcionTareaDetalle.getText();
        SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
        Date FechaInicio = txtFechaInicio.getDate();
        Date FechaFinal = txtFechaFinal.getDate();

        //  fechaInicioTexto = fecha.format(txtFechaInicio.getCalendar().getTime());
        // fechaFinaTexto = fecha.format(txtFechaFinal.getCalendar().getTime());
        try {

            if (!NombreTarea.equals("") && !DescripcionTarea.equals("")) {
                String fechaInicioTexto = "";
                String fechaFinaTexto = "";
                int valor = 0;

                if (FechaInicio != null && FechaFinal != null) {
                    fechaInicioTexto = fecha.format(txtFechaInicio.getCalendar().getTime());
                    fechaFinaTexto = fecha.format(txtFechaFinal.getCalendar().getTime());
                }

                if (!fechaInicioTexto.equals("") && !fechaFinaTexto.equals("") && !fechaInicioTexto.isBlank() && !fechaFinaTexto.isBlank() && !fechaInicioTexto.isEmpty() && !fechaFinaTexto.isEmpty()) {
                    Date dt_1 = fecha.parse(fechaInicioTexto);
                    Date dt_2 = fecha.parse(fechaFinaTexto);
                    if (dt_1.compareTo(dt_2) > 0) {
                        JOptionPane.showMessageDialog(null, "La fecha de inicio debe de ser menor a la fecha final");
                        valor = 1;
                    } else {
                        Date datetime = new Date();

                        String FechaActual = fecha.format(datetime);
                        Date FechaActualparceada = fecha.parse(FechaActual);

                        if (FechaActualparceada.compareTo(dt_2) > 0) {
                            lblEstado.setText("Vencida");
                            lblEstado.setForeground(Color.red);
                        } else if (FechaActualparceada.compareTo(dt_2) == 0) {
                            lblEstado.setText("Por Vencer");
                            lblEstado.setForeground(Color.yellow);
                        } else {
                            lblEstado.setText("En Tiempo");
                            lblEstado.setForeground(Color.green);
                        }
                    }
                }

                if (valor == 0) {
                    ArrayList<TareaDetalle> tareaDetalle = DevolverTareaDetalleArreglo(this.CodigoListaTarea);
                    TareaDetalle TareaModicar = tareaDetalle.stream().filter(t -> t.getCodigoTarea().equals(this.CodigoTareaDetalle)).findFirst().get();
                    TareaModicar.setNombreTarea(NombreTarea.trim());
                    TareaModicar.setDescTarea(DescripcionTarea.trim());
                    TareaModicar.setFechaInicio(fechaInicioTexto.trim());
                    TareaModicar.setFechaFinal(fechaFinaTexto.trim());

                    ModificarArchivoTxtDetalleTarea(tareaDetalle, this.CodigoListaTarea);
                    lblMensaje.setText("Tarea modificado con exito.");
                    lblMensaje.setVisible(true);
                    lblMensaje.setForeground(Color.green);

                }
            } else {
                JOptionPane.showMessageDialog(null, "El campo 'Nombre tarea' y 'Descripcion de la tarea' son obligatorios.");

            }

        } catch (Exception e) {
            e.getMessage();

        }

    }//GEN-LAST:event_btnModificarActionPerformed

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
            java.util.logging.Logger.getLogger(ModificarTareaDetalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarTareaDetalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarTareaDetalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarTareaDetalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificarTareaDetalle("", "", "", "", "", "", "", "", "");
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btbListaActividades;
    private javax.swing.JButton btnComenatarios;
    private javax.swing.JButton btnEliminarTarea;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegresarTareas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JTextField txtDescripcionTareaDetalle;
    private com.toedter.calendar.JDateChooser txtFechaFinal;
    private com.toedter.calendar.JDateChooser txtFechaInicio;
    private javax.swing.JTextField txtNombreTareaDetalle;
    // End of variables declaration//GEN-END:variables
}
