/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Principal;

import AdministrarTablero.Comentarios;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import metodos.ComentariosMetodo;
import metodos.Metodos;
import metodos.MetodosTareaDetalle;

/**
 *
 * @author Eleazar
 */
public class ListaComentarios extends javax.swing.JFrame {

    DefaultTableModel mdlTable;
    Comentarios comentarioLista = new Comentarios();
    ComentariosMetodo metodoComentario = new ComentariosMetodo();
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

    /**
     * Creates new form ListaComentarios
     */
    public ListaComentarios(String CodigoListaTarea, String CodigoTareaDetalle, String NombreTarea, String DescTarea, String FechaI, String FechaF, String CodigoTablero, String NombreTablero, String NombreListaTarea) {
        initComponents();
        if (!"".equals(CodigoTareaDetalle)) {

            this.CodigoListaTarea = CodigoListaTarea;
            this.CodigoTareaDetalle = CodigoTareaDetalle;
            this.NombreTarea = NombreTarea;
            this.DescTarea = DescTarea;
            this.FechaI = FechaI;
            this.FechaF = FechaF;
            this.CodigoTablero = CodigoTablero;
            this.NombreTablero = NombreTablero;
            this.NombreListadoTarea = NombreListaTarea;
            int valor = 1;
            File archivo = new File("C:/Organizador/Comentarios/" + CodigoTareaDetalle + ".txt");
            if (!metodoComentario.isFileExists(archivo)) {
                if (metodoComentario.CrearArchivoTxtComenatario(CodigoTareaDetalle)) {
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
                tblComentarioLista.setModel(metodoComentario.ListarComentariosTarea("Comentarios\\" + CodigoTareaDetalle));
                ocultarColumnasCodigo();
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
        tblComentarioLista = new javax.swing.JTable();
        txtComentario = new javax.swing.JTextField();
        btnAgragarComentario = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btbRegresar = new javax.swing.JButton();
        btnModificarComentario = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.MatteBorder(null), "Comentarios", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setFocusable(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblComentarioLista.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblComentarioLista);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 530, 280));
        jPanel1.add(txtComentario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 330, -1));

        btnAgragarComentario.setText("Agreagar Comentario");
        btnAgragarComentario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgragarComentarioActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgragarComentario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        jLabel1.setText("Comentario:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        btbRegresar.setText("Regresar");
        btbRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(btbRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 140, -1, -1));

        btnModificarComentario.setText("Editar comentario");
        btnModificarComentario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarComentarioActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificarComentario, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgragarComentarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgragarComentarioActionPerformed
        if (!"".equals(txtComentario.getText().trim())) {
            mdlTable = new DefaultTableModel();
            String nombre = txtComentario.getText();
            Metodos metodo = new Metodos();
            String codigo = metodo.GenerarCodigo();

            comentarioLista.setCodigoTarea(this.CodigoTareaDetalle);
            comentarioLista.setCodigoComentario(codigo);
            comentarioLista.setComentario(txtComentario.getText().trim());

            metodoComentario.guardarComentario(comentarioLista);
            metodoComentario.guardarArchivoComentario(comentarioLista, this.CodigoTareaDetalle);
            tblComentarioLista.setModel(metodoComentario.ListarComentariosTarea("Comentarios\\" + this.CodigoTareaDetalle));
            txtComentario.setText("");
            ocultarColumnasCodigo();

        } else {
            JOptionPane.showMessageDialog(null, "No puede ingresar un comentario con el campo 'Comentario' vacio. Por favor llenar el campo 'Comentario'");

        }
    }//GEN-LAST:event_btnAgragarComentarioActionPerformed

    private void btbRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbRegresarActionPerformed
        ModificarTareaDetalle tareadetalle = new ModificarTareaDetalle(CodigoListaTarea, CodigoTareaDetalle, NombreTarea, DescTarea, FechaI, FechaF, CodigoTablero, NombreTablero, NombreListadoTarea);
        tareadetalle.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btbRegresarActionPerformed

    private void btnModificarComentarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarComentarioActionPerformed
        int row = tblComentarioLista.getSelectedRow();
        if (row >= 0) {
            String CodigoComentario = tblComentarioLista.getModel().getValueAt(row, 2).toString();
            String Comentario = tblComentarioLista.getModel().getValueAt(row, 4).toString();

            ModificaComentarios ComentarioM = new ModificaComentarios(CodigoListaTarea, this.CodigoTareaDetalle, NombreTarea, DescTarea, FechaI, FechaF, CodigoTablero, NombreTablero, NombreListadoTarea, Comentario, CodigoComentario);
            ComentarioM.setVisible(true);
            this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "Para modificar debe de seleccionar una fila y despues precionar el boton de 'Editar Comentario'");
        }

    }//GEN-LAST:event_btnModificarComentarioActionPerformed

    private void ocultarColumnasCodigo() {
        tblComentarioLista.getColumnModel().getColumn(0).setMaxWidth(0);
        tblComentarioLista.getColumnModel().getColumn(0).setMinWidth(0);
        tblComentarioLista.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        tblComentarioLista.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
        tblComentarioLista.getColumnModel().getColumn(2).setMaxWidth(0);
        tblComentarioLista.getColumnModel().getColumn(2).setMinWidth(0);
        tblComentarioLista.getTableHeader().getColumnModel().getColumn(2).setMaxWidth(0);
        tblComentarioLista.getTableHeader().getColumnModel().getColumn(2).setMinWidth(0);
        tblComentarioLista.getColumnModel().getColumn(1).setMaxWidth(0);
        tblComentarioLista.getColumnModel().getColumn(1).setMinWidth(0);
        tblComentarioLista.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(0);
        tblComentarioLista.getTableHeader().getColumnModel().getColumn(1).setMinWidth(0);
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
            java.util.logging.Logger.getLogger(ListaComentarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaComentarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaComentarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaComentarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaComentarios("", "", "", "", "", "", "", "", "");
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btbRegresar;
    private javax.swing.JButton btnAgragarComentario;
    private javax.swing.JButton btnModificarComentario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblComentarioLista;
    private javax.swing.JTextField txtComentario;
    // End of variables declaration//GEN-END:variables
}
