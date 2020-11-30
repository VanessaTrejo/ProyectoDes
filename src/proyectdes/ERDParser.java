/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectdes;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import javax.swing.JOptionPane;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

/**
 *
 * @author rnavarro
 */
public class ERDParser {
    
  String ruta;
  private ArrayList<String> kd = new ArrayList<>();
    private ArrayList<String> ke= new ArrayList<>();
    
 
    
       public ArrayList<String> keysEntidades(){
        return ke;
    }
    public ArrayList<String> keyde(){
        return kd;
    }
    
    public ERDParser(String direccion){
        this.ruta = direccion;
    }
    
    public Hashtable<String,ArrayList> nuevoHash(){
        Hashtable<String,ArrayList> hash = new Hashtable<>();
        FileReader FR = null;
        try{
            FR = new FileReader(this.ruta);
        }catch(FileNotFoundException e){
        }
        JSONTokener t = new JSONTokener(FR);
        JSONObject JSONDoc = new JSONObject(t);
        JSONArray ja = JSONDoc.names();
        
        
        System.out.println(ja);

        JSONArray entidad = JSONDoc.getJSONArray("entidades");
        System.out.println(entidad);

        Iterator iterato = entidad.iterator();

        while (iterato.hasNext()) {
            ArrayList<Valores> entidadvalor = new ArrayList();
            
            JSONObject entidadd = (JSONObject) iterato.next();
            String entityName = entidadd.getString("nombre");
            System.out.println(entityName);
            this.ke.add(entityName);
            
            JSONArray valores = entidadd.getJSONArray("atributos");
            Iterator vi = valores.iterator();

            while (vi.hasNext()) {
                JSONObject valore = (JSONObject) vi.next();
                System.out.print(" ");
                System.out.print(valore.getString("nombre"));
                
                String v = valore.getString("nombre");
                
               Valores casos = null;
                
                switch (valore.getInt("tipo")) {
                    case 1:
                        System.out.println(" **");
                        casos = new Valores(v, null, null, null, false, true);
                        break;
                    case 2:
                        System.out.println(" *");
                        casos = new Valores(v, null, null, null, false, false);
                        break;
                    default:
                        System.out.println("");
                        casos= new Valores(v, null, null, null, false, false);
                        break;
                }
                entidadvalor.add(casos);
            
            
            hash.put(entityName, entidadvalor);

            }}
        JSONArray r = JSONDoc.getJSONArray("relaciones");
        System.out.println("relaciones             ");
        iterato = r.iterator();

        
        
        while (iterato.hasNext()) {
            JSONObject rr = (JSONObject) iterato.next();
            System.out.println(rr.getString("nombre"));
           

            JSONArray p = rr.getJSONArray("cardinalidades");

            int n = p.length();

            for (int i = 0; i < n; i++) {
                JSONObject e1 = p.getJSONObject(i);

                System.out.printf("\t%s (%s,%s)\n", e1.getString("entidad"), e1.getString("min"),  e1.getString("max"));
            }}
        return hash;
    }
        

     
    
    public Hashtable<String,ArrayList> nuevoHashdebil(){
        Hashtable<String,ArrayList> hash = new Hashtable<>();
        FileReader FR = null;
        try{
            FR = new FileReader(this.ruta);
        }catch(FileNotFoundException e){}
        JSONTokener t = new JSONTokener(FR);
        JSONObject JSONDoc = new JSONObject(t);

        JSONArray ja = JSONDoc.names();
        System.out.println(ja);

        JSONArray rd = JSONDoc.getJSONArray("debiles");
        for (Object debiles : rd) {
            System.out.println(debiles.toString());
        }
        

        Iterator iterato = rd.iterator();

        while (iterato.hasNext()) {
            System.out.println("Entidad debil");
            ArrayList<Valores> entidadvalor = new ArrayList();
            JSONObject ed = (JSONObject) iterato.next();

            String entityName = ed.getString("nombre");
            System.out.println(entityName);
            
            
            this.kd.add(entityName);
            
            JSONArray v = ed.getJSONArray("atributos");
            Iterator vi = v.iterator();

            while (vi.hasNext()) {
                JSONObject valore = (JSONObject) vi.next();
                System.out.print(" ");
                System.out.print(valore.getString("nombre"));
                String vt = valore.getString("nombre");
                
                Valores casos = null;
                
                switch (valore.getInt("tipo")) {
                    case 1:
                        System.out.println(" **");
                      casos = new Valores(vt, null, null, null, false, true);
                        break;
                    case 2:
                        System.out.println(" *");
                       casos = new Valores(vt, null, null, null, false, false);
                        break;
                    default:
                        System.out.println("");
                       casos = new Valores(vt, null, null, null, false, false);
                        break;
                }
                
                entidadvalor.add(casos);
            }
            hash.put(entityName, entidadvalor);

        }
        return hash;
    }
}
