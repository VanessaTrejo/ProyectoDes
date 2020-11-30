/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectdes;

import java.awt.Dimension;
import java.io.File;
import java.util.ArrayList;
import java.util.Hashtable;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import proyectdes.Valores;
import proyectdes.ERDParser;


public class TablasJ extends javax.swing.JFrame {
   
    Hashtable<String,ArrayList> EntidadesDebiles;
  
     Hashtable<String,ArrayList> EntidadesNormal;
     
       String Archivo;
     
    public TablasJ() {
        initComponents();
       
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        panel = new javax.swing.JDesktopPane();
        jMenuBar = new javax.swing.JMenuBar();
        jMenu = new javax.swing.JMenu();
        Abrir = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));

        panel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        jMenu.setText("Archivo");

        Abrir.setText("Abrir");
        Abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbrirActionPerformed(evt);
            }
        });
        jMenu.add(Abrir);
        jMenu.add(jSeparator1);

        jMenuBar.add(jMenu);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AbrirActionPerformed
 JFileChooser jfile = new JFileChooser();
        jfile.showOpenDialog(this);
         File archivo = jfile.getSelectedFile();
        if (archivo!= null) {
            Archivo = archivo.getAbsolutePath(); }
        
       
        if (Archivo.endsWith(".json")) {
             String tipo;
            ERDParser tabla = new ERDParser(Archivo);
            EntidadesNormal = tabla.nuevoHash();
           
                
                EntidadesDebiles = tabla.nuevoHashdebil();
                
                  ArrayList<String> keyy = tabla.keysEntidades();
                ArrayList<Valores> valores;
               
        
                if (EntidadesDebiles!= null) {
                    ArrayList<String> keyyd = tabla.keyde();
                   
                    for (String keysd : keyyd) {
                        tipo= "entidadDebil";
                        valores = EntidadesDebiles.get(keysd);
                        System.out.println(keysd);
                        TablasD td = new TablasD(keysd, valores, tipo);
                        panel.add(td);
                        td.show();
                    }
                     if (EntidadesNormal!= null) {
                
              
                for (String keysd : keyy) {
                    tipo = "entidad";
                    valores = EntidadesNormal.get(keysd);
                    System.out.println(keysd);

                    TablasD td = new TablasD(keysd, valores, tipo);
                    panel.add(td);
                    td.show();

                }}}} else {
        }
        
        
        
    }//GEN-LAST:event_AbrirActionPerformed

    /**
     * /*    llenarJTable();
    }
    public void llenarJTable(){
        ERDParser cliente= new ERDParser(new OnHttpRequestComplete() {
            @Override
            public void onComplete(Response status) {
                JSONObject Edificios= new JSONObject(status.getResult());
                DefaultTableModel modelo= new DefaultTableModel();
                modelo.addColumn("ID");
                modelo.addColumn("Nombres");
                modelo.addColumn("Sotano");
                Tabla.setModel(modelo);
                for (int i = 0;; i++) {
                    
                    Object[]obj = new Object[3];
                    obj[0]=Edificios.getJSONObject(""+1+"").get("ID_EDF").toString();
                    obj[1]=Edificios.getJSONObject(""+1+"").get("Nombre").toString();
                    obj[2]=Edificios.getJSONObject(""+1+"").get("Niveles").toString();
                    modelo.addRow(obj);
                    
                }
                
                  }
        });
      
        
     * @param args the command line arguments
     */
    public static void main(String args[]) {
      
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
             
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TablasJ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TablasJ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TablasJ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TablasJ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TablasJ().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Abrir;
    private javax.swing.JMenu jMenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JDesktopPane panel;
    // End of variables declaration//GEN-END:variables
}
