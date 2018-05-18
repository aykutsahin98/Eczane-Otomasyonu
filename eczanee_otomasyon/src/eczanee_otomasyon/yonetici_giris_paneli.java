package eczanee_otomasyon;

public class yonetici_giris_paneli extends javax.swing.JFrame {

    public yonetici_giris_paneli() {
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ilac_duzenle = new javax.swing.JButton();
        musteri_duzenle = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(400, 350));
        getContentPane().setLayout(null);

        ilac_duzenle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Pill-32.png"))); // NOI18N
        ilac_duzenle.setText("İLAÇ BİLGİLERİNİ DÜZENLE");
        ilac_duzenle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ilac_duzenleActionPerformed(evt);
            }
        });
        getContentPane().add(ilac_duzenle);
        ilac_duzenle.setBounds(70, 100, 260, 50);

        musteri_duzenle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/musteri.png"))); // NOI18N
        musteri_duzenle.setText("MÜŞTERİ BİLGİLERİNİ DÜZENLE");
        musteri_duzenle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                musteri_duzenleActionPerformed(evt);
            }
        });
        getContentPane().add(musteri_duzenle);
        musteri_duzenle.setBounds(70, 190, 260, 53);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/yönetici.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-70, -40, 480, 370);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ilac_duzenleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ilac_duzenleActionPerformed
        ilac_bilgileri pharmacy=new ilac_bilgileri();
        pharmacy.setVisible(true);
        this.hide();
    }//GEN-LAST:event_ilac_duzenleActionPerformed

    private void musteri_duzenleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_musteri_duzenleActionPerformed
        musteri_bilgileri person=new musteri_bilgileri();
        person.setVisible(true);
        this.hide();
    }//GEN-LAST:event_musteri_duzenleActionPerformed

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
            java.util.logging.Logger.getLogger(yonetici_giris_paneli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(yonetici_giris_paneli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(yonetici_giris_paneli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(yonetici_giris_paneli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new yonetici_giris_paneli().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ilac_duzenle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton musteri_duzenle;
    // End of variables declaration//GEN-END:variables
}
