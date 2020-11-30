/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectdes;

import java.util.ArrayList;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import proyectdes.Valores;


 
public class TablasD extends javax.swing.JInternalFrame {

    private DefaultTableModel tm = new DefaultTableModel();
    ArrayList<String> valores;
    
    public TablasD(String keysd,ArrayList<Valores> valores,String tipoEntidad) {
        
          initComponents();
         columnas(); 
        addComboBox(1, jTable1);
        
        
        addRows(valores);
          addCheckBox(4,this.jTable1);
        addCheckBox(5,this.jTable1);
      
        modificarEntidad(keysd,tipoEntidad);
        
      
    }
    
    private void columnas(){
        tm.addColumn("Name");
        tm.addColumn("DataType");
        tm.addColumn("Length");
        tm.addColumn("Precision");
        tm.addColumn("NotNULL?");
        tm.addColumn("Primary Key");
    }
     private void modificarEntidad(String key,String tipoEntidad){
        
        
        if (tipoEntidad.equals("entidad")) {
            Nombre.setText("Entidad: "+key);
        } else{
            Nombre.setText("Entidad debil: "+key);
        }
        
    }
    
   
    
    
      private void addRows(ArrayList<Valores> valores){
        
        for (Valores v : valores) {
            Object[] array = {v.getName(),v.getData_type(),v.getLength(),v.getPrecision(),v.isNot_null(),v.isPrimary_key()};
            tm.addRow(array);
        }}
         private void addCheckBox(int column,JTable table){
        TableColumn tc = table.getColumnModel().getColumn(column);
        tc.setCellRenderer(table.getDefaultRenderer(Boolean.class));
        tc.setCellEditor(table.getDefaultEditor(Boolean.class));
    
    }
      public boolean IsSelected(int row,int column,JTable table){
        return table.getValueAt(row, column)!=null;
    }

    private void addComboBox(int column, JTable table){
        TableColumn tc= table.getColumnModel().getColumn(column);
        JComboBox comboBox = new JComboBox();
        comboBox.addItem("CHARACTER");
        comboBox.addItem("VARCHAR");
        comboBox.addItem("DECIMAL");
         comboBox.addItem("INTEGER");
        comboBox.addItem("DATE");
        comboBox.addItem("TIMESTAMP");
        tc.setCellEditor(new DefaultCellEditor(comboBox));
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Nombre = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(tm);
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 59, 560, 140));

        Nombre.setText("Entidad");
        jPanel1.add(Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 240, 20));

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         for (int i = 0; i < jTable1.getRowCount(); i++) {
            if (IsSelected(i, 5, jTable1)) {
            }
        }
        
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            if (IsSelected(i, 4, jTable1)) {
                
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Nombre;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
