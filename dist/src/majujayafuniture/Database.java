/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majujayafuniture;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class Database {
   
    private Connection conn;
    private Statement stmt;
    private ResultSet res;
        
    public Database() {
        String url = "jdbc:mysql://localhost:3306/db_MajuJaya";
        String user = "root";
        String pass = "";
        
        
        try {
            conn = DriverManager.getConnection(url, user, pass);
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public DefaultListModel isiList(String tabel, String kolom){
        DefaultListModel list = new DefaultListModel();
        try {
            res = stmt.executeQuery("SELECT "+kolom+" FROM " + tabel);
            res.beforeFirst();
            res.last();
            int baris = res.getRow();

            String data;
            res.beforeFirst();
            int p = 0;
            while(res.next()) {
                for(int i=0; i<1; i++) {
                    data = res.getString(kolom);
                    list.addElement(data);
                }
                p++;
            }
            

        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public DefaultTableModel tampilData(String tabel, String[] judulKolom) {
        DefaultTableModel model = null;
        
        try {
            res = stmt.executeQuery("SELECT * FROM " + tabel);
            res.beforeFirst();
            res.last();
            int baris = res.getRow();
            
            Object[][] data = new Object[baris][judulKolom.length];
            res.beforeFirst();
            int p = 0;
            while(res.next()) {
                for(int i=0; i<judulKolom.length; i++) {
                    data[p][i] = res.getString(i+1);
                }
                p++;
            }
            
            model = new DefaultTableModel(data, judulKolom);
            
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return model;
    }
    
    public DefaultTableModel tampilData(String tabel, String kolom, String[] judulKolom) {
        DefaultTableModel model = null;
        
        try {
            res = stmt.executeQuery("SELECT " + kolom + " FROM " + tabel);
            res.beforeFirst();
            res.last();
            int baris = res.getRow();
            
            Object[][] data = new Object[baris][judulKolom.length];
            res.beforeFirst();
            int p = 0;
            while(res.next()) {
                for(int i=0; i<judulKolom.length; i++) {
                    data[p][i] = res.getString(i+1);
//                    System.out.println(data[p][i]);
                }
                p++;
            }
            
            model = new DefaultTableModel(data, judulKolom);
            
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return model;
    }
    
    public DefaultTableModel tampilData02(String tabel, String kolom, String[] judulKolom) {
        DefaultTableModel model = null;
        
        try {
            res = stmt.executeQuery("SELECT " + kolom + " FROM " + tabel);
            res.beforeFirst();
            res.last();
            int baris = res.getRow();
            
            Object[][] data = new Object[baris][judulKolom.length];
            res.beforeFirst();
            int p = 0;
            while(res.next()) {
                for(int i=0; i<judulKolom.length; i++) {
                    if(i==4){
                        data[p][i] = new SimpleDateFormat("dd/MM/yyyy").format(res.getDate(5));
                    }else {
                        data[p][i] = res.getString(i+1);
                    }
                    
                    
                }
                p++;
            }
            
            model = new DefaultTableModel(data, judulKolom);
            
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return model;
    }
    
    public ResultSet getData(String sql) {
        ResultSet hasil = null;
        
        try {
            hasil = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return hasil;
    }
    
    public int eksekusiSQL(String sql) {
        int hasil = 0;
        
        try {
            hasil = stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return hasil;
    }
    
    public int tambahData(String tabel, String value) {
        String sql = "INSERT INTO " + tabel + " VALUES(" + value + ")";
        return eksekusiSQL(sql);
    }
    
    public int editData(String tabel, String value, String kondisi) {
        String sql = "UPDATE " + tabel + " SET " + value + " WHERE " + kondisi;
        return eksekusiSQL(sql);
    }
    
    public int hapusData(String tabel, String kondisi) {
        String sql = "DELETE FROM " + tabel + " WHERE " + kondisi;
        return eksekusiSQL(sql);
    }
    
    public String generateNomor(String no_id, String table, String tanggal) {
        //SELECT RIGHT(max(nomorjual),3)+1 as nomor FROM `jual` WHERE tanggal = CURRENT_DATE()
        String hasil = "";
        
        try {
            res = stmt.executeQuery("SELECT RIGHT(max("+no_id+"),3)+1 as nomor " +
                    "FROM "+table+" WHERE "+tanggal+" = CURRENT_DATE()");
            if(res.next()) {
                Calendar cal = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
                String nomor = res.getString("nomor");
                if(nomor == null){
                    hasil = sdf.format(cal.getTime()) + "-001";
                }else{
                    hasil = sdf.format(cal.getTime()) + "-" +
                            "000".substring(0, 3 - nomor.length()) + 
                            nomor;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return hasil;
    }
}
