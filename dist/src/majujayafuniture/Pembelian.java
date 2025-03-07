/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majujayafuniture;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class Pembelian extends javax.swing.JFrame {
    
    Database db = new Database();
    /**
     * Creates new form Pembelian
     */
    
    
    public Pembelian() {
        initComponents();
    }
    
    private void transaksiBaru() {
        txtNoTrans.setText(db.generateNomor("NoNota","beli","TglBeli"));
        txtTglTrans.setText(new SimpleDateFormat("dd-MMMM-yyyy").format(Calendar.getInstance().getTime()));
        String TglBeli = new SimpleDateFormat("yy-MM-dd").format(Calendar.getInstance().getTime());
        loadData();
        
        int hasil;
        String value = "'" + txtNoTrans.getText() + "','" + TglBeli + "','Belum Lunas'";
                    hasil = db.tambahData("beli(NoNota,TglBeli,status)", value);
        if(hasil > 0) {
            JOptionPane.showMessageDialog(this, "Data berhasil ditambah.");
        } else {
            JOptionPane.showMessageDialog(this, "Data gagal ditambah.");
        }
    }
    
    private void loadData() {
        String[] judulkolom = {"Kode","Nama","Harga Beli","Jumlah","Sub Total"};
        String kolom = "produk.KodeBrg,produk.NamaBrg,produk.HargaBeli,beli_detail.Qty,(produk.HargaBeli*beli_detail.Qty) as subtotal";
        tblDaftarPrd.setModel(db.tampilData("beli_detail LEFT JOIN produk ON beli_detail.KodeBrg=produk.KodeBrg WHERE beli_detail.NoNota='" + 
                txtNoTrans.getText() + "'", kolom, judulkolom));
        
        int total = 0;
        for(int i=0; i<tblDaftarPrd.getRowCount(); i++) {
            total += Integer.valueOf(tblDaftarPrd.getValueAt(i, 5).toString());
        }
        txtTotal.setText(Integer.toString(total));
    }
    
    private void kosongkan(){
        txtTglTrans.setText("");
        txtNoTrans.setText("");
        txtNoPemasok.setText("");
        txtNmPemasok.setText("");
        txtTotal.setText("0");
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDaftarPrd = new javax.swing.JTable();
        txtNoTrans = new javax.swing.JTextField();
        txtTglTrans = new javax.swing.JTextField();
        txtKdProduk = new javax.swing.JTextField();
        txtNamaPrd = new javax.swing.JTextField();
        txtHgBeli = new javax.swing.JTextField();
        txtSubtotal = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        spnQTY = new javax.swing.JSpinner();
        btnBatal = new javax.swing.JButton();
        btnCari = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        txtTotal = new javax.swing.JTextField();
        btnOK = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        dtpJtTempo = new org.jdesktop.swingx.JXDatePicker();
        jLabel9 = new javax.swing.JLabel();
        txtNoPemasok = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        txtNmPemasok = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        btnHapus = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("FORM PEMBELIAN");
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Nomor Transaksi");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Tanggal Transaksi");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Kode Produk");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Nama Produk");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Harga Beli");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Jumlah");

        tblDaftarPrd.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tblDaftarPrd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode Barang", "Nama Barang", "Harga Beli", "Jumlah", "Subtotal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblDaftarPrd);

        txtNoTrans.setEditable(false);
        txtNoTrans.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtNoTrans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNoTransActionPerformed(evt);
            }
        });

        txtTglTrans.setEditable(false);
        txtTglTrans.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtTglTrans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTglTransActionPerformed(evt);
            }
        });

        txtKdProduk.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtNamaPrd.setEditable(false);
        txtNamaPrd.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtHgBeli.setEditable(false);
        txtHgBeli.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtHgBeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHgBeliActionPerformed(evt);
            }
        });

        txtSubtotal.setEditable(false);
        txtSubtotal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtSubtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSubtotalActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Sub Total");

        spnQTY.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        spnQTY.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnQTYStateChanged(evt);
            }
        });

        btnBatal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnBatal.setText("Batal");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        btnCari.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        btnSimpan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        txtTotal.setEditable(false);
        txtTotal.setFont(new java.awt.Font("MS Mincho", 1, 48)); // NOI18N
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTotal.setText("0");
        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });

        btnOK.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(62, 146, 204));
        jLabel8.setFont(new java.awt.Font("Akaya Kanadaka", 0, 48)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(30, 27, 24));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("FORM PEMBELIAN");
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel8.setOpaque(true);

        jLabel10.setFont(new java.awt.Font("Almendra SC", 0, 48)); // NOI18N
        jLabel10.setText("Total");

        dtpJtTempo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        dtpJtTempo.setFormats(new SimpleDateFormat("dd/MM/yyyy"));
        dtpJtTempo.setLinkDate(System.currentTimeMillis(), "Today");
        dtpJtTempo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dtpJtTempoActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("No Pemasok");

        txtNoPemasok.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtNoPemasok.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNoPemasokFocusLost(evt);
            }
        });
        txtNoPemasok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNoPemasokActionPerformed(evt);
            }
        });

        txtNmPemasok.setEditable(false);
        txtNmPemasok.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Tanggal Jatuh Tempo");

        btnHapus.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel4)
                                    .addComponent(txtNamaPrd, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)
                                    .addComponent(spnQTY, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addComponent(txtHgBeli, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(txtKdProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(btnCari)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnOK)
                                .addGap(21, 21, 21)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(44, 44, 44)
                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1486, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNoTrans, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                            .addComponent(txtTglTrans))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNoPemasok, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                            .addComponent(dtpJtTempo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(txtNmPemasok, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnBatal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSimpan, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))
                        .addGap(23, 23, 23)
                        .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtNoTrans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtTglTrans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtNoPemasok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNmPemasok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dtpJtTempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtKdProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCari))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNamaPrd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHgBeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(spnQTY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnOK)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        // TODO add your handling code here:
        if(! txtKdProduk.getText().isEmpty()) {
            try{
                ResultSet res = db.getData("SELECT * FROM produk WHERE KodeBrg = '" + txtKdProduk.getText() + "'");
                if(res.next()) {
                    txtNamaPrd.setText(res.getString("NamaBrg"));
                    txtHgBeli.setText(res.getString("HargaBeli"));
                    spnQTY.requestFocus();
                } else {
                    JOptionPane.showMessageDialog(this, "Produk tidak ditemukan.");
                    txtKdProduk.setText("");
                    txtKdProduk.requestFocus();
                }
            } catch(SQLException ex) {
                System.err.println(ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Kode Produk wajib diisi.");
            txtKdProduk.requestFocus();
        }                                       
    }//GEN-LAST:event_btnCariActionPerformed

    private void txtSubtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSubtotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSubtotalActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:
        if(db.hapusData("beli", "NoNota='" + txtNoTrans.getText() + "'") > 0) {
            loadData();
            kosongkan();
            JOptionPane.showMessageDialog(this, "Transaksi Telah Dibatalkan.");
        }else JOptionPane.showMessageDialog(this, "Transaksi Gagal Dibatalkan.");
        
    }//GEN-LAST:event_btnBatalActionPerformed

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    private void txtNoTransActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNoTransActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNoTransActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        transaksiBaru();
    }//GEN-LAST:event_formComponentShown

    private void spnQTYStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnQTYStateChanged
        // TODO add your handling code here:
        int jumlah = Integer.valueOf(spnQTY.getValue().toString());
        int HargaJual = Integer.valueOf(txtHgBeli.getText());
        int subtotal;
        subtotal = HargaJual * jumlah;
        txtSubtotal.setText(Integer.toString(subtotal));
    }//GEN-LAST:event_spnQTYStateChanged

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        // TODO add your handling code here:
        if(txtKdProduk.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Kode Produk wajib diisi.");
            txtKdProduk.requestFocus();
        } else if (Integer.valueOf(spnQTY.getValue().toString()) <= 0) {
            JOptionPane.showMessageDialog(this, "Jumlah Minimal 1.");
            spnQTY.requestFocus();
        } else {
            try{
                ResultSet res = db.getData("SELECT * FROM beli_detail WHERE KodeBrg = '" + 
                        txtKdProduk.getText() + "' AND NoNota = '" + 
                        txtNoTrans.getText() + "'");
                int hasil;
                if(res.next()) {
                    
                    String qtyBaru = "Qty=Qty+" + spnQTY.getValue().toString();
                    String subBaru = ",Subtotal=Subtotal+" + txtSubtotal.getText();
                    hasil = db.editData("beli_detail", qtyBaru + subBaru, "KodeBrg = '" + 
                        txtKdProduk.getText() + "' AND NoNota = '" + 
                        txtNoTrans.getText() + "'");
                } else {
                    String value = "'" + txtNoTrans.getText() + 
                                   "','" + txtKdProduk.getText() + 
                                   "','" + txtHgBeli.getText() +
                                   "','" + spnQTY.getValue().toString() +
                                   "','" + txtSubtotal.getText() +"'";
                    hasil = db.tambahData("beli_detail(NoNota,KodeBrg,HargaBeli,Qty,Subtotal)", value);
                                        
                }
                
                if(hasil > 0) {
                    int total = Integer.parseInt(txtTotal.getText());
                    total = total + Integer.parseInt(txtSubtotal.getText());
                    txtTotal.setText(String.valueOf(total));
                    
                    txtKdProduk.setText("");
                    txtNamaPrd.setText("");
                    spnQTY.setValue(0);
                    txtHgBeli.setText("");
                    txtSubtotal.setText("");
                    loadData();
                } else {
                    JOptionPane.showMessageDialog(this, "Produk gagal ditambah/edit.");
                }
            } catch(SQLException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnOKActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        if (tblDaftarPrd.getRowCount() <= 0) {
            JOptionPane.showMessageDialog(this, "Transaksi masih kosong.");
        } else if (txtNmPemasok.getText().isEmpty()){ 
            JOptionPane.showMessageDialog(this, "No Pemasok masih kosong.");
        }else {
            String value = "KodePemasok ='" + txtNoPemasok.getText() + 
                            "',TglTempo ='" + new SimpleDateFormat("yy-MM-dd").format(dtpJtTempo.getDate()) + 
                            "',TotalHarga ="+txtTotal.getText();
            
            if(db.editData("beli", value, "NoNota = '"+txtNoTrans.getText()+"'")>0) {
                int jumlah = tblDaftarPrd.getRowCount();
                int hasil = 0;
                for(int i=0; i<jumlah; i++) {
                    String stok = "stok=stok+" + tblDaftarPrd.getValueAt(i, 3).toString();
                    String kode = tblDaftarPrd.getValueAt(i, 0).toString();
                    hasil += db.editData("produk", stok, "KodeBrg='" + kode + "'");
                }
                
                if(hasil == jumlah) {
                    JOptionPane.showMessageDialog(this, "Transaksi berhasil disimpan.");
                    kosongkan();
                    transaksiBaru();
                }
            }
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void dtpJtTempoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dtpJtTempoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dtpJtTempoActionPerformed

    private void txtTglTransActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTglTransActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTglTransActionPerformed

    private void txtHgBeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHgBeliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHgBeliActionPerformed

    private void txtNoPemasokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNoPemasokActionPerformed
        // TODO add your handling code here:
        
                        
    }//GEN-LAST:event_txtNoPemasokActionPerformed

    private void txtNoPemasokFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNoPemasokFocusLost
        // TODO add your handling code here:
        ResultSet res = db.getData("SELECT * FROM Pemasok WHERE KodePemasok = '" + txtNoPemasok.getText() + "'");
        try {
            if(res.next()) {
                txtNmPemasok.setText(res.getString("NamaPemasok"));
            } else {
                JOptionPane.showMessageDialog(this, "Kode Pemasok Salah.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Pembelian.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtNoPemasokFocusLost

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:int baris = tblProduk.getSelectedRow();
        int baris = tblDaftarPrd.getSelectedRow();
        
        if(baris > -1) {
            String kdBrg, subTotal;  
            kdBrg =tblDaftarPrd.getValueAt(baris, 0).toString();
            subTotal =tblDaftarPrd.getValueAt(baris, 4).toString();
            int tanya = JOptionPane.showConfirmDialog(this, "Yakin Hapus ?", 
                    "Hapus Data", JOptionPane.YES_NO_OPTION, 
                    JOptionPane.QUESTION_MESSAGE);
            
            if(tanya == JOptionPane.YES_OPTION) {
                int hasil = db.hapusData("beli_detail", "KodeBrg = '" + kdBrg + "' AND NoNota= '"
                        + txtNoTrans.getText() + "'");
                int totalBaru = Integer.parseInt(txtTotal.getText())- Integer.valueOf(subTotal);
                txtTotal.setText(String.valueOf(totalBaru));
                if(hasil > 0) {
                    JOptionPane.showMessageDialog(this, "Data berhasil dihapus.");
                    loadData();
                } else {
                    JOptionPane.showMessageDialog(this, "Data gagal dihapus.");
                }
            }
            
        }else{
            JOptionPane.showMessageDialog(this, "Pilih Data untuk edit");
        }
    }//GEN-LAST:event_btnHapusActionPerformed

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
            java.util.logging.Logger.getLogger(Pembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Pembelian().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnOK;
    private javax.swing.JButton btnSimpan;
    private org.jdesktop.swingx.JXDatePicker dtpJtTempo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSpinner spnQTY;
    private javax.swing.JTable tblDaftarPrd;
    private javax.swing.JTextField txtHgBeli;
    private javax.swing.JTextField txtKdProduk;
    private javax.swing.JTextField txtNamaPrd;
    private javax.swing.JTextField txtNmPemasok;
    private javax.swing.JTextField txtNoPemasok;
    private javax.swing.JTextField txtNoTrans;
    private javax.swing.JTextField txtSubtotal;
    private javax.swing.JTextField txtTglTrans;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
