/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Principal;

import AdministrarTablero.ActividadesLista;
import AdministrarTablero.Comentarios;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import metodos.ComentariosMetodo;
import metodos.ListaActividadesMetodo;
import metodos.Metodos;
import metodos.MetodosTareaDetalle;

/**
 *
 * @author Eleazar
 */
public class ListaActividades extends javax.swing.JFrame {

    DefaultTableModel mdlTable;
    ActividadesLista actividadesL = new ActividadesLista();

    ListaActividadesMetodo metodoActividades = new ListaActividadesMetodo();
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
    public ListaActividades(String CodigoListaTarea, String CodigoTareaDetalle, String NombreTarea, String DescTarea, String FechaI, String FechaF, String CodigoTablero, String NombreTablero, String NombreListaTarea) {
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
            File archivo = new File("./src/resource/ListaActividades/" + CodigoTareaDetalle + ".txt");
            if (!metodoActividades.isFileExists(archivo)) {
                if (metodoActividades.CrearArchivoTxtActividades(CodigoTareaDetalle)) {
                    valor = 1;
                } else {
                    valor = 0;
                }
            }
            if (valor == 1) {
                this.CodigoTareaDetalle = CodigoTareaDetalle;

                this.setLocationRelativeTo(null); //Que cuando aparezca la ventana sea en el centro de la pantalla principal
                this.setResizable(false); //Que no se pueda cambiar el tamaño

                mdlTable = new DefaultTableModel(vCabeceras, 0);
                tblActividadesLista.setModel(metodoActividades.ListarActividadesTarea("ListaActividades\\" + CodigoTareaDetalle));
                ocultarColumnasCodigo();
                tblActividadesLista.addMouseListener(new MouseAdapter() {

                    //Funcion al hacer doble clic sobre un registro traer el nombre del tablero
                    @Override
                    public void mousePressed(MouseEvent Mouse_evt) {
                        JTable table = (JTable) Mouse_evt.getSource();
                        Point point = Mouse_evt.getPoint();
                        int row = table.rowAtPoint(point);
                        if (Mouse_evt.getClickCount() == 2) {
                            String CodgioActividad = (String) tblActividadesLista.getValueAt(tblActividadesLista.getSelectedRow(), 2);
                            IrActividad(CodigoListaTarea, CodigoTareaDetalle, NombreTarea, DescTarea, FechaI, FechaF, CodigoTablero, NombreTablero, NombreListadoTarea, CodgioActividad);
                            
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
        tblActividadesLista = new javax.swing.JTable();
        txtNombreListaA = new javax.swing.JTextField();
        btrAgregarListaA = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btbRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.MatteBorder(null), "Listado de Actividades", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setFocusable(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblActividadesLista.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblActividadesLista);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 530, 280));
        jPanel1.add(txtNombreListaA, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 330, -1));

        btrAgregarListaA.setText("Agregar Lista de Actividades");
        btrAgregarListaA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btrAgregarListaAActionPerformed(evt);
            }
        });
        jPanel1.add(btrAgregarListaA, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jLabel1.setText("Nombre de Lista Actividades");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        btbRegresar.setText("Regresar");
        btbRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(btbRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 130, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void IrActividad(String CodigoListaTarea,String CodigoTareaDetalle, String NombreTarea, String DescTarea, String FechaI, String FechaF, String CodigoTablero, String NombreTablero, String NombreListadoTarea, String CodgioActividad) {
        Actividades actividades = new Actividades(CodigoListaTarea, CodigoTareaDetalle, NombreTarea, DescTarea, FechaI, FechaF, CodigoTablero, NombreTablero, NombreListadoTarea, CodgioActividad);
        this.setVisible(false);
        actividades.setVisible(true);
    }
    private void btrAgregarListaAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btrAgregarListaAActionPerformed
        if (!"".equals(txtNombreListaA.getText().trim())) {
            mdlTable = new DefaultTableModel();
            String nombre = txtNombreListaA.getText();
            Metodos metodo = new Metodos();
            String codigo = metodo.GenerarCodigo();

            actividadesL.setCodigoTarea(this.CodigoTareaDetalle);
            actividadesL.setCodigoListaAc(codigo);
            actividadesL.setNombreListaA(txtNombreListaA.getText().trim());

            metodoActividades.guardarListaActividades(actividadesL);
            metodoActividades.guardarArchivoActividades(actividadesL, this.CodigoTareaDetalle);
            tblActividadesLista.setModel(metodoActividades.ListarActividadesTarea("ListaActividades\\" + this.CodigoTareaDetalle));
            txtNombreListaA.setText("");
            ocultarColumnasCodigo();

        } else {
            JOptionPane.showMessageDialog(null, "No puede ingresar un comentario con el campo 'Comentario' vacio. Por favor llenar el campo 'Comentario'");

        }
    }//GEN-LAST:event_btrAgregarListaAActionPerformed

    private void btbRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbRegresarActionPerformed
        ModificarTareaDetalle tareadetalle = new ModificarTareaDetalle(CodigoListaTarea, CodigoTareaDetalle, NombreTarea, DescTarea, FechaI, FechaF, CodigoTablero, NombreTablero, NombreListadoTarea);
        tareadetalle.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btbRegresarActionPerformed

    private void ocultarColumnasCodigo() {
        tblActividadesLista.getColumnModel().getColumn(0).setMaxWidth(0);
        tblActividadesLista.getColumnModel().getColumn(0).setMinWidth(0);
        tblActividadesLista.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        tblActividadesLista.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
        tblActividadesLista.getColumnModel().getColumn(2).setMaxWidth(0);
        tblActividadesLista.getColumnModel().getColumn(2).setMinWidth(0);
        tblActividadesLista.getTableHeader().getColumnModel().getColumn(2).setMaxWidth(0);
        tblActividadesLista.getTableHeader().getColumnModel().getColumn(2).setMinWidth(0);
        tblActividadesLista.getColumnModel().getColumn(1).setMaxWidth(0);
        tblActividadesLista.getColumnModel().getColumn(1).setMinWidth(0);
        tblActividadesLista.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(0);
        tblActividadesLista.getTableHeader().getColumnModel().getColumn(1).setMinWidth(0);
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
            java.util.logging.Logger.getLogger(ListaActividades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaActividades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaActividades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaActividades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaActividades("", "", "", "", "", "", "", "", "");
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btbRegresar;
    private javax.swing.JButton btrAgregarListaA;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblActividadesLista;
    private javax.swing.JTextField txtNombreListaA;
    // End of variables declaration//GEN-END:variables
}
