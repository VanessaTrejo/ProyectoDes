/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectdes;

import java.util.ArrayList;
import java.util.Hashtable;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import proyectdes.Valores;

/**
 *
 * @author Vanessa Trejo
 */
 
public class TablasD extends javax.swing.JInternalFrame {

    
    private DefaultTableModel tm = new DefaultTableModel();
   
    
    ERDParser tabla;
    public void setParser(ERDParser parser){
        this.tabla = parser;
        
    }
    
    private Hashtable<String, ArrayList> EntidadesNormal;
    public void hashent(Hashtable<String, ArrayList> EntidadesNormal){
        this.EntidadesNormal = EntidadesNormal;
    }
    private Hashtable<String, ArrayList> EntidadesDebil;
    public void hashentd(Hashtable<String, ArrayList> EntidadesDebil){
        this.EntidadesDebil = EntidadesDebil;
    }
    
    private String key;
    
    private Valores[] valores;
    
    public TablasD(String keysd,ArrayList<Valores> valores,String tipoEntidad) {
        
        //definir el tamaño del arreglo
        this.valores = new Valores[valores.size()];
       
        this.key = keysd;
        initComponents();
        columnas(); 
        addComboBox(1, jTable1);

        addRows(valores);
        addCheckBox(4,this.jTable1);
        addCheckBox(5,this.jTable1);
      
        modificarEntidad(keysd,tipoEntidad);
        agregarvalores(valores);
      
    }
    
    private void agregarvalores(ArrayList<Valores> valores){
        int i = 0;
        for (Valores valore : valores) {
           this.valores[i] = valore; 
           i++;
        }
          
        
        
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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Nombre = new javax.swing.JLabel();
        Guardar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        area = new javax.swing.JTextArea();

        jTextField1.setText("jTextField1");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(tm);
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 59, 560, 140));

        Nombre.setText("Entidad");
        jPanel1.add(Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 230, 20));

        Guardar.setText("Guardar");
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });
        jPanel1.add(Guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, -1, -1));

        area.setColumns(20);
        area.setRows(5);
        jScrollPane2.setViewportView(area);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
        
        
        
        String sql = "CREATE TABLE \n";
        
        for(int i = 0; i<tm.getRowCount(); i++){
             String name = (String) tm.getValueAt(i, 0); 
             String data_type = (String) tm.getValueAt(i, 1);
             String length = (String) tm.getValueAt(i, 2);
             String precision = (String) tm.getValueAt(i, 3);
             boolean not_null = (boolean) tm.getValueAt(i, 4);
             boolean primary_key = (boolean) tm.getValueAt(i, 5);  
             
            this.valores[i].setData_type(data_type);
            this.valores[i].setLength(length);
            this.valores[i].setPrecision(precision);
            this.valores[i].setNot_null(not_null);
            this.valores[i].setPrimary_key(primary_key);
             
    
        }
        
        ArrayList<String> llaveprimaria = new ArrayList<String>();
        ArrayList<Valores> llaveforania = new ArrayList<Valores>();
      
        for(int i=0; i<this.valores.length; i++){
           
            sql+=this.valores[i].getName()+ " ";
            if(this.valores[i].getData_type().equals("CHARACTER")){ 
                sql+="CHAR("+ this.valores[i].getLength() +") ";
            }
            else if(this.valores[i].getData_type().equals("VARCHAR")){ 
                sql+="CHAR("+ this.valores[i].getLength() +") ";
            }
            else if(this.valores[i].getData_type().equals("DECIMAL")){   
                sql+="DECIMAL("+ this.valores[i].getLength() +"," + this.valores[i].getPrecision()+ ") ";
            }
            else if(this.valores[i].getData_type().equals("INTEGER")){ 
                sql+="INT ";
            }
            else if(this.valores[i].getData_type().equals("DATE")){ 
                sql+="DATE ";
            }
            else if(this.valores[i].getData_type().equals("TIMESTAMP")){   
                sql+="TIMESTAMP ";
            }
            
           if(this.valores[i].isNot_null()== true){
               sql+="NOT NULL ";
           }
           
           if(this.valores[i].isPrimary_key() == true){
               llaveprimaria.add(this.valores[i].getName());
           }
           if(this.valores[i].llave_forania() == true){
               llaveforania.add(this.valores[i]);
           }
           
           sql+=",\n";
        }
        for (String string : llaveprimaria) {
          sql+="CONSTRAINT "+ string+" KEY PRIMARY KEY"
                       + " ("+ string+") \n";  
        }
        
        ArrayList<String> relaciones = tabla.getrelaciones();
        ArrayList<String> relacionesEncontradas = new ArrayList<>();
        sql+= "MODELO RELACIONAL------------\n";
        for (String relacione : relaciones) {
            System.out.println(relacione);
            
            if (relacione.contains(key)) {
                relacionesEncontradas.add(relacione);
            }
        }
        for (String relacion : relacionesEncontradas) {
            String[] r = relacion.split(" ");
            String nombre = "";
            if (r[0].contains(key) && r[1].equals("n")) {
              
                nombre = r[2];
            } else if (r[2].contains(key) && r[3].equals("n")) {
                nombre = r[2];
            }
          
           
            
            ArrayList<Valores> valores = EntidadesNormal.get(nombre);
            for (Valores valor : valores) {
                for (Valores llavesForania : llaveforania) {
                    if (valor.getName().contains(llavesForania.getName())) {
                        llavesForania.settablarelacionada(nombre);
                    }
                }
            }
            sql+= relacion;
        }
        
        for (Valores valores1 : llaveforania) {
            sql+="CONSTRAINT "+ valores1.getName() + "FK FOREIGN KEY ("
                    + valores1.getName() + ") \n";
            
            sql += "\n\tREFERENCES "+valores1.tablarelacionada()+" ("+valores1.getName()+") "
                    + "MATCH SIMPLE";
            
            sql += "\n\tON UPDATE CASCADE\n" + "\tON DELETE CASCADE";
        }
        
        area.setText(sql);
        

    }                                       


    // Variables declaration - do not modify                     
    private javax.swing.JButton Guardar;
    private javax.swing.JLabel Nombre;
    private javax.swing.JTextArea area;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration                   

}
