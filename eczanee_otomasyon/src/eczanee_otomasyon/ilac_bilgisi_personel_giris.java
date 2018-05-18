package eczanee_otomasyon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ilac_bilgisi_personel_giris extends javax.swing.JFrame {
    String url="jdbc:mysql://localhost:3306/";
String veritabaniadi="eczanee";
String surucu="com.mysql.jdbc.Driver";
String kullaniciAdi="root";
String sifre="Aykutaylin1998";
java.sql.Connection baglanti=null;
java.sql.Statement komut=null;
ResultSet gelenveri=null; 

    public ilac_bilgisi_personel_giris() {
        initComponents();
        currentdate();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        try {
        Class.forName(surucu);
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/eczanee","root","Aykutaylin1998") //Mysql sunucusuna bağlandık
                ) {             Statement st = (Statement) con.createStatement();
                try (ResultSet rs = st.executeQuery("Select * from ilac_bilgisi")) { //Veritabanındaki tabloya bağlandık
                    int count = rs.getMetaData().getColumnCount(); //Veritabanındaki tabloda kaç tane sütun var?
                    DefaultTableModel tm = new DefaultTableModel(); //Model oluşturuyoruz
                    for(int i = 1;i<=count;i++)
                        tm.addColumn(rs.getMetaData().getColumnName(i)); //Tabloya sütun ekliyoruz veritabanımızdaki sütun ismiyle aynı olacak şekilde
                    while(rs.next())
                    {
                        Object[] row = new Object[count];
                        for(int i=1;i<=count;i++)
                            row[i-1] = rs.getObject(i);
                        tm.addRow(row);
                    }
                    tablo_bilgisi.setModel(tm);
                }
        }
        } catch (SQLException ex) {
            Logger.getLogger(ilac_bilgileri.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ilac_bilgileri.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void currentdate(){
        Calendar cal=new GregorianCalendar();
        int ay=cal.get(Calendar.MONTH);
        int yil=cal.get(Calendar.YEAR);
        int gün =cal.get(Calendar.DAY_OF_MONTH);
        jLabel3.setText("Tarih: "+gün+"/"+(ay+1)+"/"+yil);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablo_bilgisi = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(555, 420));
        getContentPane().setLayout(null);

        tablo_bilgisi.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablo_bilgisi);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 0, 540, 120);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("İLAÇ ARA:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(50, 140, 110, 40);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(180, 140, 170, 40);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 153));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search.png"))); // NOI18N
        jButton1.setText("BUL");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(240, 200, 110, 40);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setForeground(new java.awt.Color(153, 0, 0));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ilac.png"))); // NOI18N
        jButton2.setText("iLAÇ-EKLE  SAYFASINA YÖNLENDİR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(220, 280, 290, 40);

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 204, 0));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Person Male-32.png"))); // NOI18N
        jButton3.setText("PERSONEL PANELİ'NE YÖNLENDİR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(220, 330, 290, 40);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(430, 120, 110, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/background1.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 90, 540, 300);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String ara =jTextField1.getText();
        Object baslik[] = new Object[]{"İD","ilac_adi","uretici_firma","kullanim_amaci" };

        try {

            Class.forName(surucu);
            baglanti = DriverManager.getConnection(url+veritabaniadi,kullaniciAdi,sifre);

            String sorgu = "select * from ilac_bilgisi where id like '%"+ara+"%' or ilac_adi like '%"+ara+"%' or uretici_firma like '%"+ara+"%' or kullanim_amaci like '%"+ara+"%'";
            

            komut = baglanti.createStatement();
            gelenveri = komut.executeQuery(sorgu);

            gelenveri.last();

            int say = gelenveri.getRow();
            gelenveri.beforeFirst();

            String sayi = null;
            sayi = String.valueOf(gelenveri.getRow());

            if(say < 1){
                JOptionPane.showMessageDialog(null, "Aradığınız İlaç Bulunamadı!");
            }
            else{

                Object data[][] = new Object[say][];
                int i = 0;

                while (gelenveri.next()) {

                    data[i] = new Object[]{
                        gelenveri.getString("id"),
                        gelenveri.getString("ilac_adi"),
                        gelenveri.getString("uretici_firma"),
                        gelenveri.getString("kullanim_amaci"),
                       
                       };
                    i++;
                }
                tablo_bilgisi.setModel(new DefaultTableModel(data, baslik));
            }

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Hata: " + ex.toString());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Veritabanına bağlantı sağlanamadı! " + ex.toString());
        }          
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JOptionPane.showMessageDialog(this, "Lütfen Yönetici Olarak Giriş Yapın!");
        giris_ekrani yonlendir=new giris_ekrani();
        yonlendir.setVisible(true);
        hide();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       JOptionPane.showMessageDialog(this, "Lütfen Personel Olarak Giriş Yapın!");
       personel_giris_ekran yonlendir1=new personel_giris_ekran();
       yonlendir1.setVisible(true);
       hide();
    }//GEN-LAST:event_jButton3ActionPerformed

   
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
            java.util.logging.Logger.getLogger(ilac_bilgisi_personel_giris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ilac_bilgisi_personel_giris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ilac_bilgisi_personel_giris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ilac_bilgisi_personel_giris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ilac_bilgisi_personel_giris().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tablo_bilgisi;
    // End of variables declaration//GEN-END:variables
}
