/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpus;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Frans Bima
 */
public class DataBuku extends javax.swing.JFrame {
    koneksi koneksi = new koneksi();
    
    private DefaultTableModel model;

//public void autonumber() {
//    try {
//        Connection c = koneksi.getKoneksi();
//        Statement s = c.createStatement();
//        String sql = "SELECT id_buku FROM jualbuku ORDER BY id_buku DESC LIMIT 1";
//        ResultSet r = s.executeQuery(sql);
//
//        if (r.next()) {
//            String NoTransaksi = r.getString("NoTransaksi").substring(4); // Adjusted substring to match "LDRY" prefix
//            int number = Integer.parseInt(NoTransaksi) + 1;
//            String formattedNumber = String.format("%04d", number);
//            IDBuku.setText("B" + formattedNumber);
//        } else {
//            IDBuku.setText("");
//        }
//
//        r.close();
//        s.close();
//    } catch (SQLException e) {
//        System.out.println("autonumber SQL error: " + e.getMessage());
//    } catch (NumberFormatException e) {
//        System.out.println("autonumber format error: " + e.getMessage());
//    } catch (Exception e) {
//        System.out.println("autonumber error: " + e.getMessage());
//    }
//}

    
    public void clear(){
        Judulbuku.setText("");
        HargaBeli.setText("");
        Pengarang.setText("");
        HargaJual.setText("");
        Jumlah.setText("");
    }
    
    public void loadData() {
    // Menghapus semua elemen dari model tabel
    model.getDataVector().removeAllElements();
    model.fireTableDataChanged();

    try {
        // Membuat koneksi ke database
        Connection c = koneksi.getKoneksi();
        Statement s = c.createStatement();

        // Query SQL untuk mengambil semua data dari tabel jualbuku
        String sql = "SELECT * FROM jualbuku";
        ResultSet r = s.executeQuery(sql);

        // Iterasi melalui hasil query
        while (r.next()) {
            Object[] o = new Object[7];
            o[0] = r.getString("id_buku"); // Asumsikan kolom ID ada di tabel
            o[1] = r.getString("judul_buku");
            o[2] = r.getString("pengarang");
            o[3] = r.getString("jenisbuku");
            o[4] = r.getString("harga_beli");
            o[5] = r.getString("harga_jual");
            o[6] = r.getString("jumlah");

            // Menambahkan baris baru ke model tabel
            model.addRow(o);
        }

        // Menutup result set dan statement
        r.close();
        s.close();
    } catch (Exception e) {
        // Menangani kesalahan
        System.out.println("loadData terjadi kesalahan: " + e.getMessage());
        e.printStackTrace();
    }
}

    
    public void cariData(){
        DefaultTableModel tabel = new DefaultTableModel();
        
        tabel.addColumn("id_buku");
        tabel.addColumn("judulbuku");
        tabel.addColumn("pengarang");
        tabel.addColumn("jenis");
        tabel.addColumn("hargabeli");
        tabel.addColumn("hargajual");
        tabel.addColumn("stok");
        
        try {
            Connection c = koneksi.getKoneksi();
            String sql = "Select * from jualbuku where id_buku like '%" + jTextField1.getText() + "%'" +
                    "or judulbuku like '%" + jTextField1.getText() + "%'";
            Statement stat = c.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {                
                tabel.addRow(new Object[]{
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                });
            }
            jTable1.setModel(tabel);
            loadData();
        } catch (Exception e) {
            System.out.println("Cari Data Error");
        }finally{
        }
    }
    
    /**
     * Creates new form DataBarang
     */
    public DataBuku() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        model = new DefaultTableModel();
        
        jTable1.setModel(model);
        
        model.addColumn("ID Buku");
        model.addColumn("Judul buku");
        model.addColumn("Pengarang");
        model.addColumn("Jenis");
        model.addColumn("Harga Beli");
        model.addColumn("Harga Jual");
        model.addColumn("Stok");
        
        loadData();
//        autonumber();
        btnEdit.setEnabled(false);
        btnHapus.setEnabled(false);
        btnBatal.setEnabled(false);
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
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        IDBuku = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Judulbuku = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        HargaBeli = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        HargaJual = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        Jumlah = new javax.swing.JTextField();
        Jenisbuku = new javax.swing.JComboBox();
        Pengaranglabel = new javax.swing.JLabel();
        Pengarang = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnSimpan = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setText("DATA BUKU");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(293, 293, 293)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("ID Buku");

        jLabel4.setText("Judul Buku");

        Judulbuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JudulbukuActionPerformed(evt);
            }
        });

        jLabel5.setText("Jenis Buku");

        jLabel6.setText("Harga Beli");

        jLabel7.setText("Harga Jual");

        jLabel8.setText("Stok");

        Jenisbuku.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Fiksi", "Non-Fiksi", "Sastra", "Pendidikan", "Kesehatan", "Agama", "Hobi" }));
        Jenisbuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JenisbukuActionPerformed(evt);
            }
        });

        Pengaranglabel.setText("Pengarang");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(44, 44, 44)
                                .addComponent(IDBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Judulbuku, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                    .addComponent(Jenisbuku, 0, 160, Short.MAX_VALUE)
                                    .addComponent(Pengarang))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 171, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(HargaBeli)
                            .addComponent(HargaJual)
                            .addComponent(Jumlah, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Pengaranglabel)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(IDBuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(HargaBeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(Judulbuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(HargaJual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8)
                    .addComponent(Jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Jenisbuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Pengaranglabel)
                    .addComponent(Pengarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jLabel2.setText("Cari Data");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        jTable1.setBackground(new java.awt.Color(204, 204, 204));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        btnSimpan.setBackground(new java.awt.Color(102, 102, 0));
        btnSimpan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSimpan.setForeground(new java.awt.Color(255, 255, 255));
        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnEdit.setBackground(new java.awt.Color(153, 153, 255));
        btnEdit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit.setText("Update");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnHapus.setBackground(new java.awt.Color(255, 51, 51));
        btnHapus.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnHapus.setForeground(new java.awt.Color(255, 255, 255));
        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnBatal.setBackground(new java.awt.Color(102, 102, 0));
        btnBatal.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBatal.setForeground(new java.awt.Color(255, 255, 255));
        btnBatal.setText("Batal");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(31, 31, 31)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan)
                    .addComponent(btnEdit)
                    .addComponent(btnHapus)
                    .addComponent(btnBatal))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    //EDIT DATA ATAU UPDATE START
    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        int i = jTable1.getSelectedRow();
        if (i == -1) {
            return;
        }
        String id = (String) model.getValueAt(i, 0);
        String judul = Judulbuku.getText();
        String pengarang = Pengarang.getText();
        String jenis = (String)Jenisbuku.getSelectedItem();
        String hargaBeli = HargaBeli.getText();
        String hargaJual = HargaJual.getText();
        String stok = Jumlah.getText();
        int rowsUpdated = 0;
        
        if (judul.isEmpty() || pengarang.isEmpty() || jenis.isEmpty() || hargaBeli.isEmpty() || hargaJual.isEmpty() || stok.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Semua field harus diisi!");
        return;
        }
        
        try {
            Connection c = koneksi.getKoneksi();
            if (c == null) {
            JOptionPane.showMessageDialog(null, "Koneksi ke database gagal!");
            return;
            }
            
            String sql = "UPDATE jualbuku SET judul_buku = ?, pengarang = ?, jenisbuku = ?, harga_beli = ?, harga_jual = ?, jumlah = ? WHERE id_buku = ?";
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, judul);
            p.setString(2, pengarang);
            p.setString(3, jenis);
            p.setString(4, hargaBeli);
            p.setString(5, hargaJual);
            p.setString(6, stok);
            p.setString(7, id);
            
            p.executeUpdate();
            p.close();
            
            System.out.println("Rows update" + rowsUpdated);
            
            JOptionPane.showMessageDialog(null, "Data Berhasil diubah!.");
            
            btnSimpan.setEnabled(true);
            btnEdit.setEnabled(false);
            btnHapus.setEnabled(false);
            btnBatal.setEnabled(false);
            clear();
        } catch (Exception e) {
            e.printStackTrace(); // Untuk melihat stack trace kesalahan
            System.out.println("update error" + e.getMessage());
        }finally{
            loadData();
//            autonumber();
        }
    }//GEN-LAST:event_btnEditActionPerformed
    //EDIT DATA ATAU UPDATE END
    // HAPUS DATA ATAU DELETE START
    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        int i = jTable1.getSelectedRow();
        if (i == -1) {
            return;
        }
        
        String id = (String) model.getValueAt(i, 0);
        
        int pernyataan = JOptionPane.showConfirmDialog(null, "Yakin Data Akan Dihapus","Konfirmasi", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (pernyataan== JOptionPane.OK_OPTION) {
            try {
            Connection c = koneksi.getKoneksi();
            String sql = "DELETE FROM jualbuku WHERE id_buku = ?";
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, id);
            p.executeUpdate();
            p.close();
            JOptionPane.showMessageDialog(null, "Data Terhapus");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Hapus Terjadi Kesalahan: " + e.getMessage());
        } finally {
            btnSimpan.setEnabled(true);
            btnEdit.setEnabled(false);
            btnHapus.setEnabled(false);
            btnBatal.setEnabled(false);
            loadData();
            // autonumber();
            clear();
}

        }
        if (pernyataan== JOptionPane.CANCEL_OPTION) {
            
        }
    }//GEN-LAST:event_btnHapusActionPerformed
    // HAPUS DATA ATAU DELETE END
    
    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
// Mendapatkan nilai dari input field dan combo box
    String judul = Judulbuku.getText();
    String pengarang = Pengarang.getText();
    String hargaBeli = HargaBeli.getText();
    String hargaJual = HargaJual.getText();
    String stok = Jumlah.getText();
    String jenisbuku = (String) Jenisbuku.getSelectedItem(); // Mengambil nilai dari combo box

    // Validasi input
    if (judul.isEmpty() || pengarang.isEmpty() || hargaBeli.isEmpty() || hargaJual.isEmpty() || stok.isEmpty() || jenisbuku.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Semua field harus diisi!");
        return;
    }

    try {
        // Membuat koneksi ke database
        Connection c = koneksi.getKoneksi();
        if (c == null) {
            JOptionPane.showMessageDialog(null, "Koneksi ke database gagal!");
            return;
        }
        
        // Query SQL untuk memasukkan data
        String sql = "INSERT INTO jualbuku (judul_buku, pengarang, harga_beli, harga_jual, jumlah, jenisbuku) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement p = c.prepareStatement(sql);
        
        // Mengatur nilai parameter query
        p.setString(1, judul);
        p.setString(2, pengarang);
        p.setString(3, hargaBeli);
        p.setString(4, hargaJual);
        p.setString(5, stok);
        p.setString(6, jenisbuku); // Menambahkan jenis buku
        
        // Menjalankan query
        p.executeUpdate();
        
        // Menutup statement
        p.close();
        
        // Menampilkan pesan sukses
        JOptionPane.showMessageDialog(null, "Data Tersimpan");
        
        // Memuat ulang data
        loadData();
    } catch (SQLException e) {
        // Menampilkan pesan kesalahan
        JOptionPane.showMessageDialog(null, "Simpan Terjadi Kesalahan: " + e.getMessage());
        e.printStackTrace();
    } finally {
        // Mengosongkan input field
        clear();
    }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        btnSimpan.setEnabled(false);
        btnEdit.setEnabled(true);
        btnHapus.setEnabled(true);
        btnBatal.setEnabled(true);
        
        int i = jTable1.getSelectedRow();
        if (i == -1) {
            return;
        }
        
        String id = (String) model.getValueAt(i, 0);
        String judul = (String) model.getValueAt(i, 1);
        String jenis = (String) model.getValueAt(i, 2);
        String pengarang = (String) model.getValueAt(i, 3);
        String hargaBeli = (String) model.getValueAt(i, 4);
        String hargaJual = (String) model.getValueAt(i, 5);
        String stok = (String) model.getValueAt(i, 6);
        
        IDBuku.setText(id);
        Judulbuku.setText(judul);
        Pengarang.setText(pengarang);
        Jenisbuku.setSelectedItem(jenis);
        HargaBeli.setText(hargaBeli);
        HargaJual.setText(hargaJual);
        Jumlah.setText(stok);
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:
        clear();
        loadData();
        btnSimpan.setEnabled(true);
        btnEdit.setEnabled(false);
        btnHapus.setEnabled(false);
        btnBatal.setEnabled(false);
//        autonumber();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void JenisbukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JenisbukuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JenisbukuActionPerformed

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        // TODO add your handling code here:
        cariData();
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
        cariData();
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void JudulbukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JudulbukuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JudulbukuActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
               Fawal home = new Fawal();
       home.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    
    
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
            java.util.logging.Logger.getLogger(DataBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataBuku().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField HargaBeli;
    private javax.swing.JTextField HargaJual;
    private javax.swing.JTextField IDBuku;
    private javax.swing.JComboBox Jenisbuku;
    private javax.swing.JTextField Judulbuku;
    private javax.swing.JTextField Jumlah;
    private javax.swing.JTextField Pengarang;
    private javax.swing.JLabel Pengaranglabel;
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
