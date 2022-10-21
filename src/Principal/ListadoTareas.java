/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Principal;

import AdministrarTablero.Tarea;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import metodos.Metodos;

/**
 *
 * @author Eleazar
 */
public class ListadoTareas extends javax.swing.JFrame {

    Metodos metodo = new Metodos();
    String CodigoTableroTarea;
    String NombreTablero;

    Tarea tarea = new Tarea();
    DefaultTableModel mdlTable;
    Vector vCabeceras = new Vector();
    Inicio inicio = new Inicio();

    /**
     * Creates new form ListadoTareas
     *
     * @param CodigoTablero
     * @param NombreTablero
     */
    public ListadoTareas(String CodigoTablero, String NombreTablero) {
        initComponents();
        if (!"".equals(CodigoTablero)) {
            lblRuta.setText("Ruta: "+NombreTablero+" / Lista tareas");
            this.setLocationRelativeTo(null); //Que cuando aparezca la ventana sea en el centro de la pantalla principal
            this.setResizable(false); //Que no se pueda cambiar el tamaño
            lblTituloTablero.setText("Tablero: " + NombreTablero);

            vCabeceras.addElement("No.");
            vCabeceras.addElement("Nombre");
            this.CodigoTableroTarea = CodigoTablero;
            this.NombreTablero = NombreTablero;

            mdlTable = new DefaultTableModel(vCabeceras, 0);
            tblListadoTareas.setModel(metodo.ListaTareas("Tablero\\" + CodigoTablero + ".txt"));
            OcultarCodigosTarea();
            //tamaño de la columna numerica
            tblListadoTareas.getColumnModel().getColumn(1).setPreferredWidth(10);

            tblListadoTareas.addMouseListener(new MouseAdapter() {

                //Funcion al hacer doble clic sobre un registro traer el nombre del tablero
                @Override
                public void mousePressed(MouseEvent Mouse_evt) {
                    JTable table = (JTable) Mouse_evt.getSource();
                    Point point = Mouse_evt.getPoint();
                    int row = table.rowAtPoint(point);
                    String IDTABLERO = (String) tblListadoTareas.getValueAt(tblListadoTareas.getSelectedRow(), 1);
                    String CODIGOLISTATAREA = (String) tblListadoTareas.getValueAt(tblListadoTareas.getSelectedRow(), 2);
                    String NOMBRELISTATAREA = (String) tblListadoTareas.getValueAt(tblListadoTareas.getSelectedRow(), 3);

                    if (Mouse_evt.getClickCount() == 2) {
                        IrListadoTareaDetalle(IDTABLERO, CODIGOLISTATAREA, NombreTablero, NOMBRELISTATAREA);
                        //lblPrueba.setText((String) TblListadoTablero.getValueAt(TblListadoTablero.getSelectedRow(), 0));
                    }
                }
            });
        } else {
            this.setVisible(false);
            inicio.setVisible(true);
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
        lblTituloTablero = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombreTarea = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListadoTareas = new javax.swing.JTable();
        btnGuardarTarea = new javax.swing.JButton();
        btnRegresarTablero = new javax.swing.JButton();
        btnListadoTModificar = new javax.swing.JButton();
        lblRuta = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Listado tareas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 24))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTituloTablero.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTituloTablero.setText("Tablero");
        jPanel1.add(lblTituloTablero, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 500, 30));

        jLabel2.setText("Nombre de la tarea:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));
        jPanel1.add(txtNombreTarea, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 260, -1));

        tblListadoTareas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblListadoTareas);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, 320, 220));

        btnGuardarTarea.setText("Agregar lista tareas");
        btnGuardarTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarTareaActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardarTarea, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 140, -1));

        btnRegresarTablero.setText("Regresar");
        btnRegresarTablero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarTableroActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegresarTablero, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 40, -1, -1));

        btnListadoTModificar.setText("Modificar Listado");
        btnListadoTModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListadoTModificarActionPerformed(evt);
            }
        });
        jPanel1.add(btnListadoTModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, 130, -1));

        lblRuta.setText("jLabel1");
        jPanel1.add(lblRuta, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 643, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarTareaActionPerformed

        String nombreTarea = txtNombreTarea.getText();
        if (!"".equals(nombreTarea)) {
            mdlTable = new DefaultTableModel();
            String codigo = metodo.GenerarCodigo();

            //Mandamos los datos al constructor
            tarea.setCodigoTablero(this.CodigoTableroTarea);
            tarea.setCodigo(codigo);
            tarea.setNombre(nombreTarea);

            //Creamo el documento txt que contendra todas las tareas
            if (metodo.CrearArchivoTxt("ListaTareas\\" + codigo)) {
                //Registamos la tarea en el archivo txt
                metodo.guardarTarea(tarea);
                metodo.guardarArchivoTarea(tarea, this.CodigoTableroTarea);
                tblListadoTareas.setModel(metodo.ListaTareas("Tablero\\" + this.CodigoTableroTarea + ".txt"));
                txtNombreTarea.setText("");
                OcultarCodigosTarea();
            } else {
                JOptionPane.showMessageDialog(null, "Lo sentimos su lista de tareas no se creo, por favor intente nuevamente");
            }

        } else {
            JOptionPane.showMessageDialog(null, "No se puede crear una lista de tarea si el campo 'Nombre Tarea' esta vacio.");
        }

    }//GEN-LAST:event_btnGuardarTareaActionPerformed

    private void btnRegresarTableroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarTableroActionPerformed
        this.setVisible(false);
        inicio.setVisible(true);
    }//GEN-LAST:event_btnRegresarTableroActionPerformed

    private void btnListadoTModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListadoTModificarActionPerformed
        ListadoTareasAModificar ModificarLt = new ListadoTareasAModificar(CodigoTableroTarea, this.NombreTablero);
        this.setVisible(false);
        ModificarLt.setVisible(true);
    }//GEN-LAST:event_btnListadoTModificarActionPerformed

    private void IrListadoTareaDetalle(String IDTABLERO, String CODIGOLISTATAREA, String NOMBRETABLERO, String NOMBRELISTATAREA) {
        DetalleTarea detalleTarea = new DetalleTarea(IDTABLERO, CODIGOLISTATAREA, NOMBRETABLERO, NOMBRELISTATAREA);
        detalleTarea.setVisible(true);
        this.setVisible(false);
    }

    private void OcultarCodigosTarea() {
        tblListadoTareas.getColumnModel().getColumn(1).setMaxWidth(0);
        tblListadoTareas.getColumnModel().getColumn(1).setMinWidth(0);
        tblListadoTareas.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(0);
        tblListadoTareas.getTableHeader().getColumnModel().getColumn(1).setMinWidth(0);

        tblListadoTareas.getColumnModel().getColumn(2).setMaxWidth(0);
        tblListadoTareas.getColumnModel().getColumn(2).setMinWidth(0);
        tblListadoTareas.getTableHeader().getColumnModel().getColumn(2).setMaxWidth(0);
        tblListadoTareas.getTableHeader().getColumnModel().getColumn(2).setMinWidth(0);

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
            java.util.logging.Logger.getLogger(ListadoTareas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListadoTareas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListadoTareas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListadoTareas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListadoTareas("", "");
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardarTarea;
    private javax.swing.JButton btnListadoTModificar;
    private javax.swing.JButton btnRegresarTablero;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblRuta;
    private javax.swing.JLabel lblTituloTablero;
    private javax.swing.JTable tblListadoTareas;
    private javax.swing.JTextField txtNombreTarea;
    // End of variables declaration//GEN-END:variables
}
