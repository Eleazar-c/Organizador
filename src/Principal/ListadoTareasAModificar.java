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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import metodos.Metodos;

/**
 *
 * @author Eleazar
 */
public class ListadoTareasAModificar extends javax.swing.JFrame {

    Metodos metodo = new Metodos();
    String CodigoTableroTarea;
    String NombreTablero;

    Tarea tarea = new Tarea();
    DefaultTableModel mdlTable;
    Vector vCabeceras = new Vector();
    Inicio inicio = new Inicio();

    /**
     * Creates new form ListadoTareasAModificar
     */
    public ListadoTareasAModificar(String CodigoTablero, String NombreTablero) {
        initComponents();
        if (!"".equals(CodigoTablero)) {
            vCabeceras.addElement("No.");
            vCabeceras.addElement("Nombre");
            this.CodigoTableroTarea = CodigoTablero;
            this.NombreTablero = NombreTablero;

            mdlTable = new DefaultTableModel(vCabeceras, 0);
            tblListadoTareaM.setModel(metodo.ListaTareas("Tablero\\" + CodigoTablero + ".txt"));
            OcultarCodigosTarea();
            //tamaño de la columna numerica
            tblListadoTareaM.getColumnModel().getColumn(1).setPreferredWidth(10);

            tblListadoTareaM.addMouseListener(new MouseAdapter() {

                //Funcion al hacer doble clic sobre un registro traer el nombre del tablero
                @Override
                public void mousePressed(MouseEvent Mouse_evt) {
                    JTable table = (JTable) Mouse_evt.getSource();
                    Point point = Mouse_evt.getPoint();
                    int row = table.rowAtPoint(point);
                    String IDTABLERO = (String) tblListadoTareaM.getValueAt(tblListadoTareaM.getSelectedRow(), 1);
                    String CODIGOLISTATAREA = (String) tblListadoTareaM.getValueAt(tblListadoTareaM.getSelectedRow(), 2);
                    String NOMBRELISTATAREA = (String) tblListadoTareaM.getValueAt(tblListadoTareaM.getSelectedRow(), 3);

                    if (Mouse_evt.getClickCount() == 2) {
                        IrListadoTareaDetalle(IDTABLERO, NOMBRELISTATAREA, CODIGOLISTATAREA, NombreTablero);
                        //lblPrueba.setText((String) TblListadoTablero.getValueAt(TblListadoTablero.getSelectedRow(), 0));
                    }
                }
            });
            this.setLocationRelativeTo(null); //Que cuando aparezca la ventana sea en el centro de la pantalla principal
            this.setResizable(false); //Que no se pueda cambiar el tamaño
        } else {
            this.setVisible(false);
            inicio.setVisible(true);
        }
    }

    public void IrListadoTareaDetalle(String CodigoTablero, String Nombrelista, String CodigoListado, String NombreTablero) {
        ModificarListaTareas modificaLT = new ModificarListaTareas(CodigoTablero, Nombrelista, CodigoListado, NombreTablero);
        this.setVisible(false);
        modificaLT.setVisible(true);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListadoTareaM = new javax.swing.JTable();
        btnRegresarListadoT = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.MatteBorder(null), "Administrar lista de tareas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Preciono dos veces encima de la tarea que desea modificar.");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        tblListadoTareaM.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblListadoTareaM);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 370, 210));

        btnRegresarListadoT.setText("Regresar");
        btnRegresarListadoT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarListadoTActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegresarListadoT, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 330, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarListadoTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarListadoTActionPerformed
        ListadoTareas listadoT = new ListadoTareas(this.CodigoTableroTarea, this.NombreTablero);
        listadoT.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegresarListadoTActionPerformed

    private void OcultarCodigosTarea() {
        tblListadoTareaM.getColumnModel().getColumn(1).setMaxWidth(0);
        tblListadoTareaM.getColumnModel().getColumn(1).setMinWidth(0);
        tblListadoTareaM.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(0);
        tblListadoTareaM.getTableHeader().getColumnModel().getColumn(1).setMinWidth(0);

        tblListadoTareaM.getColumnModel().getColumn(2).setMaxWidth(0);
        tblListadoTareaM.getColumnModel().getColumn(2).setMinWidth(0);
        tblListadoTareaM.getTableHeader().getColumnModel().getColumn(2).setMaxWidth(0);
        tblListadoTareaM.getTableHeader().getColumnModel().getColumn(2).setMinWidth(0);

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
            java.util.logging.Logger.getLogger(ListadoTareasAModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListadoTareasAModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListadoTareasAModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListadoTareasAModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListadoTareasAModificar("", "");
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegresarListadoT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblListadoTareaM;
    // End of variables declaration//GEN-END:variables
}