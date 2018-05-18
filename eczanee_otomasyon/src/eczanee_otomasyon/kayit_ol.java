package eczanee_otomasyon;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

public class kayit_ol extends javax.swing.JFrame {
String url="jdbc:mysql://localhost:3306/";
String veritabaniadi="eczanee";
String surucu="com.mysql.jdbc.Driver";
String kullaniciAdi="root";
String kullanici_sifre="Aykutaylin1998";
java.sql.Connection baglanti=null;
java.sql.Statement komut=null;
ResultSet gelenveri=null; 

    public kayit_ol() {
        initComponents();
        jComboBox3.addItem("Personel");
        jComboBox3.addItem("Yönetici");
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        
        jLabel13.setText("ÜYELİK SAYFASINA HOŞGELDİNİZ");
        currentdate();    
    }
public void currentdate(){
        Calendar cal=new GregorianCalendar();
        int ay=cal.get(Calendar.MONTH);
        int yil=cal.get(Calendar.YEAR);
        int gün =cal.get(Calendar.DAY_OF_MONTH);
        kayit_takvim.setText("Tarih: "+gün+"/"+(ay+1)+"/"+yil);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        txt_yeni_kullanici = new javax.swing.JTextField();
        password_yeni = new javax.swing.JPasswordField();
        yeni_email = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        uye_ol = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        kayit_takvim = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(520, 565));
        getContentPane().setLayout(null);

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Kayıt Türü:");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(40, 230, 120, 26);

        jLabel10.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Kullanıcı Adı:");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(40, 290, 120, 28);

        jLabel11.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Şifre:");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(40, 350, 100, 24);

        jLabel12.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("E-Posta Adresi:");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(40, 410, 120, 28);

        jComboBox3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        getContentPane().add(jComboBox3);
        jComboBox3.setBounds(180, 230, 148, 30);
        getContentPane().add(txt_yeni_kullanici);
        txt_yeni_kullanici.setBounds(180, 290, 148, 30);
        getContentPane().add(password_yeni);
        password_yeni.setBounds(180, 350, 148, 31);
        getContentPane().add(yeni_email);
        yeni_email.setBounds(180, 410, 232, 32);

        jLabel13.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 255, 102));
        getContentPane().add(jLabel13);
        jLabel13.setBounds(140, 160, 330, 43);

        uye_ol.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        uye_ol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Submit Resume-32.png"))); // NOI18N
        uye_ol.setText("Kayıt Ol");
        uye_ol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uye_olActionPerformed(evt);
            }
        });
        getContentPane().add(uye_ol);
        uye_ol.setBounds(280, 460, 130, 40);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/house.png"))); // NOI18N
        jButton1.setText("Anasayfa'ya Yönlendir...");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(40, 460, 210, 40);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/001-broom.png"))); // NOI18N
        jButton2.setText("Temizle");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(340, 230, 120, 40);

        kayit_takvim.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        kayit_takvim.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(kayit_takvim);
        kayit_takvim.setBounds(20, 20, 120, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/multiple-users-silhouette.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(190, 10, 140, 140);

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kayit_ekrani.jpg"))); // NOI18N
        getContentPane().add(jLabel14);
        jLabel14.setBounds(-2180, -710, 2690, 1250);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void uye_olActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uye_olActionPerformed
       try{
        String kadi=txt_yeni_kullanici.getText();
        String sifre=password_yeni.getText();
        String email=yeni_email.getText();
        String turu=String.valueOf(jComboBox3.getSelectedItem());
        
            if (kadi.equals("")   ||   sifre.equals("")   ||   email.equals(""))
            
        {
            JOptionPane.showConfirmDialog(null,"Lütfen Boş Alanları Doldurun!","Error",JOptionPane.DEFAULT_OPTION);
            
        }else{Class.forName(surucu);
            baglanti= DriverManager.getConnection(url+veritabaniadi,kullaniciAdi,kullanici_sifre);
            komut=baglanti.createStatement();
            String sql="INSERT INTO uyelikler (uyelik_turu,kullanici_adi,password,Email)" 
                    + " VALUES ('"+turu+"','"+kadi+"','"+sifre+"','"+email+"')";
            
            komut.executeUpdate(sql);
            
            JOptionPane.showMessageDialog(null,kadi + " İsimli kullanıcı eklenmiştir.");}
            
    }catch (ClassNotFoundException ex) {JOptionPane.showMessageDialog(null,"Hata: " + ex.toString());
            
    }catch (SQLException ex){JOptionPane.showMessageDialog(this,"Veri Tabanına Bağlanılamadı !" + ex.toString());}
    }//GEN-LAST:event_uye_olActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      ilk_giris ekran=new ilk_giris();
       ekran.setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      txt_yeni_kullanici.setText("");
      password_yeni.setText("");
      yeni_email.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

   
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
            java.util.logging.Logger.getLogger(kayit_ol.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(kayit_ol.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(kayit_ol.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(kayit_ol.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new kayit_ol().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel kayit_takvim;
    private javax.swing.JPasswordField password_yeni;
    private javax.swing.JTextField txt_yeni_kullanici;
    private javax.swing.JButton uye_ol;
    private javax.swing.JTextField yeni_email;
    // End of variables declaration//GEN-END:variables
}
