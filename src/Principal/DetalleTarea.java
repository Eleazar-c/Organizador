/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Principal;

import AdministrarTablero.TareaDetalle;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import metodos.Metodos;
import metodos.MetodosTareaDetalle;

/**
 *
 * @author Eleazar
 */
public class DetalleTarea extends javax.swing.JFrame {

    Inicio inicio = new Inicio();
    DefaultTableModel mdlTable;
    TareaDetalle tareaDetalle = new TareaDetalle();
    MetodosTareaDetalle metodoTareas = new MetodosTareaDetalle();
    private String CodigoTablero;
    private String CodigoTarea;
    private String NombreTablero;
    private String NombreTarea;
    Vector vCabeceras = new Vector();

    /**
     * Creates new form DetalleTarea
     *
     * @param CodigoTablero
     * @param CodigoTarea
     * @param NombreTablero
     * @param NombreTarea
     */
    public DetalleTarea(String CodigoTablero, String CodigoTarea, String NombreTablero, String NombreTarea) {
        initComponents();

        if (!"".equals(CodigoTablero)) {
            this.NombreTablero = NombreTablero;
            this.CodigoTablero = CodigoTablero;
            this.CodigoTarea = CodigoTarea;
            this.NombreTarea = NombreTarea;

            lblTituloTarea.setText("Tarea: " + NombreTarea);
            lblRuta.setText("Ruta: " + NombreTablero + "/" + NombreTarea);

            vCabeceras.addElement("No.");
            vCabeceras.addElement("Nombre");
            vCabeceras.addElement("Fecha Inicio");
            vCabeceras.addElement("Fecha Final");

            mdlTable = new DefaultTableModel(vCabeceras, 0);
            tblTablaTareas.setModel(metodoTareas.ListaTareasDetalle("ListaTareas\\" + CodigoTarea));
            OcultarCoditoTareaDetalle();

            //Ahora agregamos la funcion para hacer clic encima de la tarea muestre el detalle
            tblTablaTareas.addMouseListener(new MouseAdapter() {

                //Funcion al hacer doble clic sobre un registro traer el nombre del tablero
                @Override
                public void mousePressed(MouseEvent Mouse_evt) {
                    JTable table = (JTable) Mouse_evt.getSource();
                    Point point = Mouse_evt.getPoint();
                    int row = table.rowAtPoint(point);
                    if (Mouse_evt.getClickCount() == 2) {
                        String CodigoListaTarea = (String) tblTablaTareas.getValueAt(tblTablaTareas.getSelectedRow(), 1);
                        String CodigoTarea = (String) tblTablaTareas.getValueAt(tblTablaTareas.getSelectedRow(), 2);

                        String NombreListaTarea = (String) tblTablaTareas.getValueAt(tblTablaTareas.getSelectedRow(), 3);
                        String DescTarea = (String) tblTablaTareas.getValueAt(tblTablaTareas.getSelectedRow(), 4);
                        String FechaI = (String) tblTablaTareas.getValueAt(tblTablaTareas.getSelectedRow(), 5);
                        String FechaF = (String) tblTablaTareas.getValueAt(tblTablaTareas.getSelectedRow(), 6);

                        IrDetalleTarea(CodigoListaTarea, CodigoTarea, NombreListaTarea, DescTarea,FechaI,FechaF);
                        //lblPrueba.setText((String) TblListadoTablero.getValueAt(TblListadoTablero.getSelectedRow(), 0));
                    }
                }
            });

        } else {
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
        tblTablaTareas = new javax.swing.JTable();
        lblTituloTarea = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtNombreTarea = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDescTarea = new javax.swing.JTextField();
        btnRegistrarTarea = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        lblRuta = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCalendarFinal = new com.toedter.calendar.JDateChooser();
        txtCalendarInicio = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnAdministrarTareas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Tareas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 24))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblTablaTareas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblTablaTareas);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 750, 350));

        lblTituloTarea.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTituloTarea.setText("Tarea:");
        jPanel1.add(lblTituloTarea, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jLabel1.setText("*Nombre tarea:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));
        jPanel1.add(txtNombreTarea, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 190, -1));

        jLabel2.setText("*Descripcion:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));
        jPanel1.add(txtDescTarea, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 190, -1));

        btnRegistrarTarea.setText("Registrar");
        btnRegistrarTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarTareaActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrarTarea, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, -1, -1));

        jButton2.setText("Regresar");
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 220, -1, -1));

        lblRuta.setText("Ruta");
        jPanel1.add(lblRuta, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 6, -1, 30));

        jLabel3.setText("Fecha de Vencimiento:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, -1, -1));
        jPanel1.add(txtCalendarFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 170, 180, -1));
        jPanel1.add(txtCalendarInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, 180, -1));

        jLabel4.setText("Fecha Inicio");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, -1, -1));

        jLabel5.setText("Fecha Final");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 140, -1, -1));

        btnAdministrarTareas.setText("Administrar Tareas");
        jPanel1.add(btnAdministrarTareas, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 220, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IrDetalleTarea(String CodigoListaTarea, String CodigoTareaDetalle, String NombreTarea, String DescTarea, String FechaI, String FechaF) {
        ModificarTareaDetalle DetalleTarea = new ModificarTareaDetalle(CodigoListaTarea, CodigoTareaDetalle, NombreTarea, DescTarea, FechaI, FechaF);
        DetalleTarea.setVisible(true);
        this.setVisible(false);
    }
    private void btnRegistrarTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarTareaActionPerformed

        try {

            mdlTable = new DefaultTableModel();
            Metodos metodo = new Metodos();
            MetodosTareaDetalle metodoTareaDetalle = new MetodosTareaDetalle();
            String nombreTarea = txtNombreTarea.getText();
            String DescTarea = txtDescTarea.getText();

            if (!nombreTarea.equals("") && !DescTarea.equals("")) {
                int valor = 0;
                SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
                Date FechaInicio = txtCalendarInicio.getDate();
                Date FechaFinal = txtCalendarFinal.getDate();
                //int Dia = txtCalendarFinal.getCalendar().get((Calendar.DAY_OF_MONTH));
                //int Mes = txtCalendarFinal.getCalendar().get((Calendar.MONTH));
                //Mes = Mes + 1;
                //int Anio = txtCalendarFinal.getCalendar().get((Calendar.YEAR));
                //FechaVencimientoTabla = Dia + "/" + Mes + "/" + Anio;

                String fechaInicioTexto = "";
                String fechaFinaTexto = "";

                if (FechaInicio != null && FechaFinal != null) {
                    fechaInicioTexto = fecha.format(txtCalendarInicio.getCalendar().getTime());
                    fechaFinaTexto = fecha.format(txtCalendarFinal.getCalendar().getTime());
                }

                if (!fechaInicioTexto.equals("") && !fechaFinaTexto.equals("") && !fechaInicioTexto.isBlank() && !fechaFinaTexto.isBlank() && !fechaInicioTexto.isEmpty() && !fechaFinaTexto.isEmpty()) {
                    Date dt_1 = fecha.parse(fechaInicioTexto);
                    Date dt_2 = fecha.parse(fechaFinaTexto);
                    if (dt_1.compareTo(dt_2) > 0) {
                        JOptionPane.showMessageDialog(null, "La fecha de inicio debe de ser menor a la fecha final");
                        valor = 1;
                    }

                }
                if (valor == 0) {
                    String codigo = metodo.GenerarCodigo();

                    tareaDetalle.setListaTarea(this.CodigoTarea);
                    tareaDetalle.setCodigoTarea(codigo);
                    tareaDetalle.setNombreTarea(nombreTarea);
                    tareaDetalle.setDescTarea(DescTarea);
                    tareaDetalle.setFechaInicio(fechaInicioTexto);
                    tareaDetalle.setFechaFinal(fechaFinaTexto);

                    metodoTareaDetalle.guardarTarea(tareaDetalle);
                    metodoTareaDetalle.guardarArchivoTareaDetalle(tareaDetalle, "ListaTareas\\" + this.CodigoTarea);
                    tblTablaTareas.setModel(metodoTareas.ListaTareasDetalle("ListaTareas\\" + this.CodigoTarea));
                    txtNombreTarea.setText("");
                    txtDescTarea.setText("");
                    OcultarCoditoTareaDetalle();
                }
            } else {
                JOptionPane.showMessageDialog(null, "El campo 'Nombre' y  'Descripcion' son obligatorios");
            }
        } catch (Exception e) {
        }

    }//GEN-LAST:event_btnRegistrarTareaActionPerformed

    //ocultamos la columna que tiene el codigo
    private void OcultarCoditoTareaDetalle() {
        tblTablaTareas.getColumnModel().getColumn(1).setMaxWidth(0);
        tblTablaTareas.getColumnModel().getColumn(1).setMinWidth(0);
        tblTablaTareas.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(0);
        tblTablaTareas.getTableHeader().getColumnModel().getColumn(1).setMinWidth(0);

        tblTablaTareas.getColumnModel().getColumn(2).setMaxWidth(0);
        tblTablaTareas.getColumnModel().getColumn(2).setMinWidth(0);
        tblTablaTareas.getTableHeader().getColumnModel().getColumn(2).setMaxWidth(0);
        tblTablaTareas.getTableHeader().getColumnModel().getColumn(2).setMinWidth(0);

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
            java.util.logging.Logger.getLogger(DetalleTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetalleTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetalleTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetalleTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DetalleTarea("", "", "", "");
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdministrarTareas;
    private javax.swing.JButton btnRegistrarTarea;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblRuta;
    private javax.swing.JLabel lblTituloTarea;
    private javax.swing.JTable tblTablaTareas;
    private com.toedter.calendar.JDateChooser txtCalendarFinal;
    private com.toedter.calendar.JDateChooser txtCalendarInicio;
    private javax.swing.JTextField txtDescTarea;
    private javax.swing.JTextField txtNombreTarea;
    // End of variables declaration//GEN-END:variables
}
