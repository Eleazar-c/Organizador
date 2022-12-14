/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Principal;

import AdministrarTablero.ActividadeDetalle;
import AdministrarTablero.ActividadesLista;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import metodos.ActividadMetodo;
import metodos.ListaActividadesMetodo;
import metodos.Metodos;

/**
 *
 * @author Eleazar
 */
public class Actividades extends javax.swing.JFrame {

    DefaultTableModel mdlTable;
    ActividadeDetalle actividades = new ActividadeDetalle();

    ActividadMetodo metodoActividades = new ActividadMetodo();
    String CodigoTareaDetalle;
    Vector vCabeceras = new Vector();
    String CodigoListaTarea;
    String NombreTarea;
    String DescTarea;
    String FechaI;
    String FechaF;
    String CodigoTablero;
    String NombreTablero;
    String NombreListadoTarea;
    String CodigoActividad;

    /**
     * Creates new form ListaComentarios
     */
    public Actividades(String CodigoListaTarea, String CodigoTareaDetalle, String NombreTarea, String DescTarea, String FechaI, String FechaF, String CodigoTablero, String NombreTablero, String NombreListaTarea, String CodigoActividad) {
        initComponents();
        if (!"".equals(CodigoTareaDetalle)) {
            lblTareas.setVisible(false);
            this.CodigoListaTarea = CodigoListaTarea;
            this.CodigoTareaDetalle = CodigoTareaDetalle;
            this.NombreTarea = NombreTarea;
            this.DescTarea = DescTarea;
            this.FechaI = FechaI;
            this.FechaF = FechaF;
            this.CodigoTablero = CodigoTablero;
            this.NombreTablero = NombreTablero;
            this.NombreListadoTarea = NombreListaTarea;
            this.CodigoActividad = CodigoActividad;
            int valor = 1;
            File archivo = new File("C:/Organizador/Actividades/" + CodigoActividad + ".txt");
            if (!metodoActividades.isFileExists(archivo)) {
                if (metodoActividades.CrearArchivoTxtActividades(CodigoActividad)) {
                    valor = 1;
                } else {
                    valor = 0;
                }
            }
            if (valor == 1) {
                this.CodigoTareaDetalle = CodigoTareaDetalle;

                this.setLocationRelativeTo(null); //Que cuando aparezca la ventana sea en el centro de la pantalla principal
                this.setResizable(false); //Que no se pueda cambiar el tama??o

                mdlTable = new DefaultTableModel(vCabeceras, 0);
                tblActividades.setModel(metodoActividades.ListarActividadesTarea("Actividades\\" + CodigoActividad));
                ocultarColumnasCodigo();
                tblActividades.addMouseListener(new MouseAdapter() {

                    //Funcion al hacer doble clic sobre un registro traer el nombre del tablero
                    @Override
                    public void mousePressed(MouseEvent Mouse_evt) {
                        JTable table = (JTable) Mouse_evt.getSource();
                        Point point = Mouse_evt.getPoint();
                        int row = table.rowAtPoint(point);
                        if (Mouse_evt.getClickCount() == 2) {
                            String CodigoListadoActividad = (String) tblActividades.getValueAt(tblActividades.getSelectedRow(), 1);
                            String CodigoACtividadDetalle = (String) tblActividades.getValueAt(tblActividades.getSelectedRow(), 2);

                            String NombreActividad = (String) tblActividades.getValueAt(tblActividades.getSelectedRow(), 3);
                            String Estado = (String) tblActividades.getValueAt(tblActividades.getSelectedRow(), 4);

                            irDetalleActividad(CodigoListaTarea, CodigoTareaDetalle, NombreTarea, DescTarea, FechaI, FechaF, CodigoTablero, NombreTablero, NombreListadoTarea, CodigoListadoActividad, NombreActividad, Estado, CodigoACtividadDetalle);
                        }
                    }
                });

            }

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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblActividades = new javax.swing.JTable();
        txtNombreActividad = new javax.swing.JTextField();
        btrAgregarListaA = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btbRegresar = new javax.swing.JButton();
        lblTareas = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.MatteBorder(null), "Actividades", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setFocusable(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblActividades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblActividades);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 530, 280));
        jPanel1.add(txtNombreActividad, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 330, -1));

        btrAgregarListaA.setText("Agregar Actividad");
        btrAgregarListaA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btrAgregarListaAActionPerformed(evt);
            }
        });
        jPanel1.add(btrAgregarListaA, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jLabel1.setText("Nombre Actividad");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        btbRegresar.setText("Regresar");
        btbRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(btbRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 130, -1, -1));

        lblTareas.setText("jLabel2");
        jPanel1.add(lblTareas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void irDetalleActividad(String CodigoListaTarea, String CodigoTareaDetalle, String NombreTarea, String DescTarea, String FechaI, String FechaF, String CodigoTablero, String NombreTablero, String NombreListadoTarea, String CodgioActividad, String NombreActividad, String Estado, String CodigoACtividadDetalle) {
        ActividadesDetalle detalleA = new ActividadesDetalle(CodigoListaTarea, CodigoTareaDetalle, NombreTarea, DescTarea, FechaI, FechaF, CodigoTablero, NombreTablero, NombreListadoTarea, CodgioActividad, NombreActividad, Estado, CodigoACtividadDetalle);
        this.setVisible(false);
        detalleA.setVisible(true);
    }
    private void btrAgregarListaAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btrAgregarListaAActionPerformed
        if (!"".equals(txtNombreActividad.getText().trim())) {
            mdlTable = new DefaultTableModel();
            String nombre = txtNombreActividad.getText();
            Metodos metodo = new Metodos();
            String codigo = metodo.GenerarCodigo();

            actividades.setCodigoListaActividad(this.CodigoActividad);
            actividades.setCodigoActividad(codigo);
            actividades.setNombreActividad(txtNombreActividad.getText().trim());
            actividades.setEstado("Sin Completar");

            metodoActividades.guardarActividades(actividades);
            metodoActividades.guardarArchivoActividades(actividades, this.CodigoActividad);
            tblActividades.setModel(metodoActividades.ListarActividadesTarea("Actividades\\" + CodigoActividad));
            txtNombreActividad.setText("");
            ocultarColumnasCodigo();

        } else {
            JOptionPane.showMessageDialog(null, "No puede ingresar un actividad con el campo 'Nombre de Actividad' vacio. Por favor llenar el campo 'Nombrea de actividad'");

        }
    }//GEN-LAST:event_btrAgregarListaAActionPerformed

    private void btbRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbRegresarActionPerformed
        ListaActividades tareadetalle = new ListaActividades(CodigoListaTarea, CodigoTareaDetalle, NombreTarea, DescTarea, FechaI, FechaF, CodigoTablero, NombreTablero, NombreListadoTarea);
        tareadetalle.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btbRegresarActionPerformed

    private void ocultarColumnasCodigo() {
        tblActividades.getColumnModel().getColumn(2).setMaxWidth(0);
        tblActividades.getColumnModel().getColumn(2).setMinWidth(0);
        tblActividades.getTableHeader().getColumnModel().getColumn(2).setMaxWidth(0);
        tblActividades.getTableHeader().getColumnModel().getColumn(2).setMinWidth(0);
        tblActividades.getColumnModel().getColumn(1).setMaxWidth(0);
        tblActividades.getColumnModel().getColumn(1).setMinWidth(0);
        tblActividades.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(0);
        tblActividades.getTableHeader().getColumnModel().getColumn(1).setMinWidth(0);

    }

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
            java.util.logging.Logger.getLogger(Actividades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Actividades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Actividades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Actividades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Actividades("", "", "", "", "", "", "", "", "", "");
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btbRegresar;
    private javax.swing.JButton btrAgregarListaA;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTareas;
    private javax.swing.JTable tblActividades;
    private javax.swing.JTextField txtNombreActividad;
    // End of variables declaration//GEN-END:variables
}
