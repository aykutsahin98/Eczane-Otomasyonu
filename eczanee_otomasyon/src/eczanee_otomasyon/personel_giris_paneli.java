package eczanee_otomasyon;
public class personel_giris_paneli extends javax.swing.JFrame {
    
    public personel_giris_paneli() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        personel_button = new javax.swing.JButton();
        pharmacy_button = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(400, 359));
        getContentPane().setLayout(null);

        personel_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Person Male-32.png"))); // NOI18N
        personel_button.setText("MÜŞTERİ BİLGİLERİ");
        personel_button.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        personel_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                personel_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(personel_button);
        personel_button.setBounds(80, 70, 230, 50);

        pharmacy_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ilac.png"))); // NOI18N
        pharmacy_button.setText("İLAÇ BİLGİLERİ");
        pharmacy_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pharmacy_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(pharmacy_button);
        pharmacy_button.setBounds(80, 180, 230, 50);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/personback.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 400, 320);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void personel_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_personel_buttonActionPerformed
       musteri_bilgisi_personel_giris personel=new musteri_bilgisi_personel_giris();
       personel.setVisible(true);
       this.hide();
    }//GEN-LAST:event_personel_buttonActionPerformed

    private void pharmacy_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pharmacy_buttonActionPerformed
        ilac_bilgisi_personel_giris pharmac=new ilac_bilgisi_personel_giris();
        pharmac.setVisible(true);
        this.hide();
    }//GEN-LAST:event_pharmacy_buttonActionPerformed

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
            java.util.logging.Logger.getLogger(personel_giris_paneli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(personel_giris_paneli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(personel_giris_paneli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(personel_giris_paneli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new personel_giris_paneli().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton personel_button;
    private javax.swing.JButton pharmacy_button;
    // End of variables declaration//GEN-END:variables
}
