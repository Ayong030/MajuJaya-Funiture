/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majujayafuniture;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class Pelunasan_CashTempo extends javax.swing.JFrame {

    Database db = new Database();
    private Statement stmt;
    private ResultSet res;
    
    
    /**
     * Creates new form Pelunasan_CashTempo
     */
    public Pelunasan_CashTempo() {
        initComponents();
    }
    
    private void loadData() {
        String[] judulkolom = {"No Pembelian","Total Harga","Kode Pemasok","Nama Pemasok","Tgl Jatuh Tempo","Status"};
        String kolom = "beli.NoNota,beli.TotalHarga,beli.KodePemasok,pemasok.NamaPemasok,beli.TglTempo,beli.status";
        tblPelunasan.setModel(db.tampilData("beli LEFT JOIN pemasok ON beli.KodePemasok=pemasok.KodePemasok WHERE beli.status = 'Belum Lunas'", kolom, judulkolom));
    }
          
    private void aktifkan(boolean x) {
        dtpPelunasan.setEditable(x);
        
        BtnUbah.setEnabled(!x);
        BtnSimpan.setEnabled(x);
        btnBatal.setEnabled(x);
                
        tblPelunasan.setEnabled(!x);
    }
    
    private void kosongkan() {
        txtKodePemasok.setText("");
        txtNamaPemasok.setText("");
        txtNoNota.setText("");
        txtTempo.setText("");
        txtTotalBayar.setText("0");
        dtpPelunasan.setLinkDate(System.currentTimeMillis(), "Today");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPelunasan = new javax.swing.JTable();
        BtnUbah = new javax.swing.JButton();
        BtnSimpan = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtNoNota = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtKodePemasok = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtNamaPemasok = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        dtpPelunasan = new org.jdesktop.swingx.JXDatePicker();
        jLabel7 = new javax.swing.JLabel();
        txtTempo = new javax.swing.JTextField();
        txtTotalBayar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(165, 164, 119));
        jLabel1.setFont(new java.awt.Font("Akaya Kanadaka", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PEMBAYARAN CAST TEMPO");
        jLabel1.setOpaque(true);

        tblPelunasan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tblPelunasan.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblPelunasan);

        BtnUbah.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        BtnUbah.setText("Ubah");
        BtnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnUbahActionPerformed(evt);
            }
        });

        BtnSimpan.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        BtnSimpan.setText("Simpan");
        BtnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSimpanActionPerformed(evt);
            }
        });

        btnBatal.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnBatal.setText("Batal");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Nota Pembelian");

        txtNoNota.setEditable(false);
        txtNoNota.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Tanggal Pelunasan");

        txtKodePemasok.setEditable(false);
        txtKodePemasok.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Kode Pemasok");

        txtNamaPemasok.setEditable(false);
        txtNamaPemasok.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Nama Pemasok");

        dtpPelunasan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        dtpPelunasan.setFormats(new SimpleDateFormat("dd/MM/yyyy"));
        dtpPelunasan.setLinkDate(System.currentTimeMillis(), "Today");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Tanggal Tempo");

        txtTempo.setEditable(false);
        txtTempo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtTotalBayar.setEditable(false);
        txtTotalBayar.setBackground(new java.awt.Color(10, 9, 87));
        txtTotalBayar.setFont(new java.awt.Font("Almendra SC", 0, 48)); // NOI18N
        txtTotalBayar.setForeground(java.awt.Color.white);
        txtTotalBayar.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTotalBayar.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(BtnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BtnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtTotalBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtTempo, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNamaPemasok, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtKodePemasok, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dtpPelunasan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                                    .addComponent(txtNoNota, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 882, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTotalBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNoNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dtpPelunasan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtKodePemasok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNamaPemasok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBatal)
                    .addComponent(BtnSimpan)
                    .addComponent(BtnUbah))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        loadData();
    }//GEN-LAST:event_formComponentShown

    private void BtnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnUbahActionPerformed
        // TODO add your handling code here:
        int baris = tblPelunasan.getSelectedRow();
        
        if(baris > -1) {
            aktifkan(true);            
            txtNoNota.setText(tblPelunasan.getValueAt(baris, 0).toString());
            txtTotalBayar.setText(tblPelunasan.getValueAt(baris, 1).toString());
            txtKodePemasok.setText(tblPelunasan.getValueAt(baris, 2).toString());
            txtNamaPemasok.setText(tblPelunasan.getValueAt(baris, 3).toString());
            txtTempo.setText(tblPelunasan.getValueAt(baris, 4).toString());
        }else{
            JOptionPane.showMessageDialog(this, "Pilih Data untuk edit");
        }
    }//GEN-LAST:event_BtnUbahActionPerformed

    private void BtnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSimpanActionPerformed
        // TODO add your handling code here:
        int hasil;
        
        String value = "TglPelunasan='" + new SimpleDateFormat("yy-MM-dd").format(dtpPelunasan.getDate())+ 
                            "',Status='" + "Sudah Lunas" + "'";
        hasil = db.editData("beli", value, "NoNota='" + txtNoNota.getText() + "'");
        
        if(hasil > 0) {
            JOptionPane.showMessageDialog(this, "Data berhasil ditambah/edit.");
            aktifkan(false);
            kosongkan();
            loadData();
        } else {
            JOptionPane.showMessageDialog(this, "Data gagal ditambah/edit.");
        }
    }//GEN-LAST:event_BtnSimpanActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:
        aktifkan(false);
        kosongkan();
        loadData();
    }//GEN-LAST:event_btnBatalActionPerformed

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
            java.util.logging.Logger.getLogger(Pelunasan_CashTempo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pelunasan_CashTempo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pelunasan_CashTempo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pelunasan_CashTempo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pelunasan_CashTempo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnSimpan;
    private javax.swing.JButton BtnUbah;
    private javax.swing.JButton btnBatal;
    private org.jdesktop.swingx.JXDatePicker dtpPelunasan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPelunasan;
    private javax.swing.JTextField txtKodePemasok;
    private javax.swing.JTextField txtNamaPemasok;
    private javax.swing.JTextField txtNoNota;
    private javax.swing.JTextField txtTempo;
    private javax.swing.JTextField txtTotalBayar;
    // End of variables declaration//GEN-END:variables
}
