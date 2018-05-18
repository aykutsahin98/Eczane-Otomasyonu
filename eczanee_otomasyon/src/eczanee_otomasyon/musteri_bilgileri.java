package eczanee_otomasyon;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;


public class musteri_bilgileri extends javax.swing.JFrame {
String url="jdbc:mysql://localhost:3306/";
String veritabaniadi="eczanee";
String surucu="com.mysql.jdbc.Driver";
String kullaniciAdi="root";
String sifre="Aykutaylin1998";
java.sql.Connection baglanti=null;
java.sql.Statement komut=null;
ResultSet gelenveri=null; 
    
    private void Guncelle(){
        try {
            String baslik[] = new String[]{"Müşteri No","TC.No","Ad ve Soyad","Güvence","Telefon","Adres"};  
            Class.forName(surucu);
            baglanti = DriverManager.getConnection(url+veritabaniadi,kullaniciAdi,sifre);
            
            komut = baglanti.createStatement();                
            gelenveri = komut.executeQuery("select * from musteri_bilgisi");
            gelenveri.last();
           
            int kayitsayisi = gelenveri.getRow();
            gelenveri.beforeFirst();

            Object data[][] = new Object[kayitsayisi][];
            int i = 0;

            while (gelenveri.next()) {

                data[i] = new Object[]{  
                    gelenveri.getString("id_musteri"),
                    gelenveri.getString("tc_kimlik_no"), 
                    gelenveri.getString("adi_soyadi"),
                    gelenveri.getString("guvence"),
                    gelenveri.getString("telefon"),
                    gelenveri.getString("adres"),
                };
                i++;
            }
            komut.close();
            tablo_bilgileri.setModel(new DefaultTableModel(data, baslik));
            
        } catch (ClassNotFoundException ex) {
           JOptionPane.showMessageDialog(null,"Hata: " + ex.toString());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Veritabanına bağlantı sağlanamadı! " + ex.toString());
        }
    }
    public musteri_bilgileri() {
        initComponents();
        jComboBox2.addItem("SSK");
        jComboBox2.addItem("Bağkur");
        jComboBox2.addItem("Emekli");
        jComboBox2.addItem("Yok");
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        takvim();
        saat();
        veri_listele();
        jLabel6.setText("MÜŞTERİ-KAYIT EKRANINA HOŞGELDİNİZ");   
    }
    public void veri_listele(){
        String baslik[] = new String[]{"Müşteri No","TC.No","Ad ve Soyad","Güvence","Telefon","Adres"};  
            try {
                Class.forName(surucu);
            try (Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/eczanee", "root", "Aykutaylin1998")) //Mysql sunucusuna bağlandık
                 {Statement st = (Statement) con.createStatement();
            try (ResultSet rs = st.executeQuery("Select * from musteri_bilgisi")) { //Veritabanındaki tabloya bağlandık
                    int colcount = rs.getMetaData().getColumnCount(); //Veritabanındaki tabloda kaç tane sütun var?
                        DefaultTableModel tm = new DefaultTableModel(); //Model oluşturuyoruz
                    for(int i = 1;i<=colcount;i++)
                        tm.addColumn(rs.getMetaData().getColumnName(i)); //Tabloya sütun ekliyoruz veritabanımızdaki sütun ismiyle aynı olacak şekilde
                            while(rs.next())
                {
                    Object[] row = new Object[colcount];
                    for(int i=1;i<=colcount;i++)
                    row[i-1] = rs.getObject(i);
                    tm.addRow(row);
                }
                tablo_bilgileri.setModel(tm);
            }
            }
    }catch (ClassNotFoundException | SQLException hata) {
        Logger.getLogger(musteri_bilgileri.class.getName()).log(Level.SEVERE, null, hata);
    }Guncelle();
}
    public void takvim(){
        Calendar cal=new GregorianCalendar();
        int ay=cal.get(Calendar.MONTH);
        int yil=cal.get(Calendar.YEAR);
        int gün =cal.get(Calendar.DAY_OF_MONTH);
        takvim_menu.setText("Tarih: "+gün+"/"+(ay+1)+"/"+yil);
    }
    public void saat(){
         Timer t=new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
                jMenu1.setText("Saat: "+sdf.format(new java.util.Date()));   
            }
        });
        t.start();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablo_bilgileri = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtf_tckimlik = new javax.swing.JTextField();
        txtf_adi_soyadi = new javax.swing.JTextField();
        txtf_telefon = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_bul = new javax.swing.JTextField();
        bul = new javax.swing.JButton();
        ekle_button = new javax.swing.JButton();
        guncelle_button = new javax.swing.JButton();
        sil_button = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        area_adres = new javax.swing.JTextArea();
        temizle = new javax.swing.JButton();
        son_kayit = new javax.swing.JButton();
        ilk_kayit = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu = new javax.swing.JMenu();
        menuitem_yonetici = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        menuitem_kapat = new javax.swing.JMenuItem();
        menu_hakkinda = new javax.swing.JMenu();
        menuitem_hakkimizda = new javax.swing.JMenuItem();
        takvim_menu = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(905, 660));
        getContentPane().setLayout(null);

        tablo_bilgileri.setModel(new javax.swing.table.DefaultTableModel(
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
        tablo_bilgileri.setSelectionBackground(new java.awt.Color(255, 102, 51));
        tablo_bilgileri.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablo_bilgileriMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablo_bilgileri);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 0, 890, 140);

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("TC Kimlik No:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(60, 290, 120, 30);

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Adı Soyadı:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(60, 350, 110, 30);

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Telefon Numarası:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(400, 290, 138, 30);

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Adres Bilgisi:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(400, 350, 138, 30);
        getContentPane().add(txtf_tckimlik);
        txtf_tckimlik.setBounds(200, 290, 170, 30);
        getContentPane().add(txtf_adi_soyadi);
        txtf_adi_soyadi.setBounds(200, 350, 170, 31);
        getContentPane().add(txtf_telefon);
        txtf_telefon.setBounds(550, 290, 170, 31);

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Sosyal Güvence:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(60, 410, 130, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Müşteri Ara:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(60, 230, 88, 30);

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 255, 51));
        getContentPane().add(jLabel6);
        jLabel6.setBounds(240, 170, 440, 40);
        getContentPane().add(txt_bul);
        txt_bul.setBounds(200, 230, 220, 30);

        bul.setBackground(new java.awt.Color(255, 255, 255));
        bul.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bul.setForeground(new java.awt.Color(0, 0, 153));
        bul.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search.png"))); // NOI18N
        bul.setToolTipText("ARA");
        bul.setFocusable(false);
        bul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bulActionPerformed(evt);
            }
        });
        getContentPane().add(bul);
        bul.setBounds(430, 230, 50, 40);

        ekle_button.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ekle_button.setForeground(new java.awt.Color(153, 0, 0));
        ekle_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Submit Resume-32.png"))); // NOI18N
        ekle_button.setText("KAYDET");
        ekle_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ekle_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(ekle_button);
        ekle_button.setBounds(160, 500, 150, 40);

        guncelle_button.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        guncelle_button.setForeground(new java.awt.Color(153, 0, 0));
        guncelle_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/update.png"))); // NOI18N
        guncelle_button.setText("GÜNCELLE");
        guncelle_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guncelle_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(guncelle_button);
        guncelle_button.setBounds(370, 500, 150, 41);

        sil_button.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        sil_button.setForeground(new java.awt.Color(153, 0, 0));
        sil_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Delete-32.png"))); // NOI18N
        sil_button.setText("MÜŞTERİ SİL");
        sil_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sil_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(sil_button);
        sil_button.setBounds(580, 500, 150, 40);

        area_adres.setColumns(20);
        area_adres.setLineWrap(true);
        area_adres.setRows(5);
        area_adres.setWrapStyleWord(true);
        jScrollPane2.setViewportView(area_adres);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(550, 350, 170, 70);

        temizle.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        temizle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/001-broom.png"))); // NOI18N
        temizle.setText("Temizle");
        temizle.setBorder(null);
        temizle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                temizleActionPerformed(evt);
            }
        });
        getContentPane().add(temizle);
        temizle.setBounds(490, 230, 110, 40);

        son_kayit.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        son_kayit.setForeground(new java.awt.Color(153, 0, 0));
        son_kayit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/1493682902_Forward_Skip.png"))); // NOI18N
        son_kayit.setText("Son");
        son_kayit.setBorder(null);
        son_kayit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                son_kayitActionPerformed(evt);
            }
        });
        getContentPane().add(son_kayit);
        son_kayit.setBounds(730, 280, 100, 40);

        ilk_kayit.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ilk_kayit.setForeground(new java.awt.Color(153, 0, 0));
        ilk_kayit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/1493682916_Backward_Skip.png"))); // NOI18N
        ilk_kayit.setText("İlk");
        ilk_kayit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ilk_kayitActionPerformed(evt);
            }
        });
        getContentPane().add(ilk_kayit);
        ilk_kayit.setBounds(730, 230, 100, 40);

        getContentPane().add(jComboBox2);
        jComboBox2.setBounds(200, 410, 140, 30);

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/1493682936_Fast_Forward.png"))); // NOI18N
        jButton3.setText("İleri");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(730, 330, 100, 40);

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/1493682927_Rewind.png"))); // NOI18N
        jButton4.setText("Geri");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(730, 380, 100, 40);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/arrows.png"))); // NOI18N
        jButton1.setText("Yenile");
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(610, 230, 110, 40);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/background-personel.jpg"))); // NOI18N
        getContentPane().add(jLabel8);
        jLabel8.setBounds(0, -20, 890, 620);

        menu.setForeground(new java.awt.Color(153, 0, 0));
        menu.setText("Menü");
        menu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        menuitem_yonetici.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_MASK));
        menuitem_yonetici.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        menuitem_yonetici.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/right-arrow.png"))); // NOI18N
        menuitem_yonetici.setText("Yönetici Giriş Paneline Git");
        menuitem_yonetici.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuitem_yoneticiActionPerformed(evt);
            }
        });
        menu.add(menuitem_yonetici);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/back (1).png"))); // NOI18N
        jMenuItem1.setText("Giriş Paneline Git");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menu.add(jMenuItem1);

        menuitem_kapat.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        menuitem_kapat.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        menuitem_kapat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/power-button.png"))); // NOI18N
        menuitem_kapat.setText("Kapat");
        menuitem_kapat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuitem_kapatActionPerformed(evt);
            }
        });
        menu.add(menuitem_kapat);

        jMenuBar1.add(menu);

        menu_hakkinda.setForeground(new java.awt.Color(0, 0, 153));
        menu_hakkinda.setText("Hakkında");
        menu_hakkinda.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        menuitem_hakkimizda.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        menuitem_hakkimizda.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        menuitem_hakkimizda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/1493484785_Information.png"))); // NOI18N
        menuitem_hakkimizda.setText("Hakkımızda");
        menuitem_hakkimizda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuitem_hakkimizdaActionPerformed(evt);
            }
        });
        menu_hakkinda.add(menuitem_hakkimizda);

        jMenuBar1.add(menu_hakkinda);

        takvim_menu.setForeground(new java.awt.Color(0, 153, 51));
        takvim_menu.setText("Takvim");
        takvim_menu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuBar1.add(takvim_menu);

        jMenu1.setText("Saat");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
 public void silinsinmi(){
    int karar=  JOptionPane.showConfirmDialog(null,"Kayıt Silinsin Mi? ", "Müşteri Bilgileri",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
    if(karar==0){
        try{
           int row = tablo_bilgileri.getSelectedRow();
            String secim=(tablo_bilgileri.getValueAt(row, 0).toString());
        
             Class.forName(surucu);
             baglanti = DriverManager.getConnection("jdbc:mysql://localhost:3306/eczanee","root","Aykutaylin1998");
                komut =baglanti.createStatement();
                String sql="DELETE FROM `eczanee`.`musteri_bilgisi` WHERE id_musteri='"+secim+"'";
                komut.executeUpdate(sql);
                JOptionPane.showMessageDialog(null,"Müşteri Bilgisi Silinmiştir");
                txtf_tckimlik.setText("");
                txtf_adi_soyadi.setText("");
                txtf_telefon.setText("");
                area_adres.setText("");
                
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ilac_bilgileri.class.getName()).log(Level.SEVERE, null, ex);    
    } 
    Guncelle();
    }
}
 public void onay (){
    int onay=  JOptionPane.showConfirmDialog(null, "Çıkmak İstiyor Musunuz?", "Çıkış",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
    if(onay==0){
        JOptionPane.showConfirmDialog(null, "Oturum Kapatıldı.", "Çıkış", JOptionPane.CLOSED_OPTION);
        dispose();
    }
}
    public void tableadan_veri_goster (int r){
    
    String alinanid=String.valueOf(tablo_bilgileri.getModel().getValueAt(r, 0));
    String alinantc_no=String.valueOf(tablo_bilgileri.getModel().getValueAt(r, 1));
     String alinanad_soyad=String.valueOf(tablo_bilgileri.getModel().getValueAt(r, 2));
    String alinan_guvence=String.valueOf(tablo_bilgileri.getModel().getValueAt(r, 3));
    String alinan_telefon_no=String.valueOf(tablo_bilgileri.getModel().getValueAt(r, 4));
    String alinan_adres=String.valueOf(tablo_bilgileri.getModel().getValueAt(r, 5));
    
    txtf_tckimlik.setText(alinantc_no);
    txtf_adi_soyadi.setText(alinanad_soyad);
    jComboBox2.setSelectedItem(alinan_guvence);
    txtf_telefon.setText(alinan_telefon_no);
    area_adres.setText(alinan_adres);
}
int row=0; 
    private void tablo_bilgileriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablo_bilgileriMouseClicked
        try{
           row=tablo_bilgileri.getSelectedRow();
           tableadan_veri_goster(row);
       }
       catch (Exception e){
           JOptionPane.showInputDialog(e);
       }  
    }//GEN-LAST:event_tablo_bilgileriMouseClicked

    private void bulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bulActionPerformed
    String ara =bul.getText();
    String baslik[] = new String[]{"Müşteri No","TC.No","Ad ve Soyad","Güvence","Telefon","Adres"};  
        try {
        Class.forName(surucu);    
        baglanti = DriverManager.getConnection("jdbc:mysql://localhost:3306/eczanee", "root", "Aykutaylin1998");
            String sorgu ="select * from musteri_bilgisi where id_musteri like '%"+txt_bul.getText()+"%' or"
                +" adi_soyadi like '%"+txt_bul.getText()+"%' or"
                +" guvence like '%"+txt_bul.getText()+"%' or"
                +" adres like '%"+txt_bul.getText()+"%' ";
                    
            komut = baglanti.createStatement();
            gelenveri = komut.executeQuery(sorgu);
            gelenveri.last();   
            int say = gelenveri.getRow();
            gelenveri.beforeFirst();
 
        String sayi = null;                
        sayi = String.valueOf(gelenveri.getRow()); 
        
            if (say < 1) { JOptionPane.showMessageDialog(null, "Aradığınız Müşteri Bulunamadı!");}
            else { Object data[][] = new Object[say][]; int i = 0;
                while (gelenveri.next()) {
                    data[i] = new Object[]{ 
                        
                    gelenveri.getString("id_musteri"),  
                    gelenveri.getString("tc_kimlik_no"),
                    gelenveri.getString("adi_soyadi"),
                    gelenveri.getString("guvence"),  
                    gelenveri.getString("telefon"),
                    gelenveri.getString("adres"),  
                };
                i++;
            }tablo_bilgileri.setModel(new DefaultTableModel(data, baslik));}
        } catch (ClassNotFoundException ex) { 
            JOptionPane.showMessageDialog(null,"Hata: " + ex.toString());
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Veritabanına bağlantı sağlanamadı! " + ex.toString());
    }              
    }//GEN-LAST:event_bulActionPerformed

    private void sil_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sil_buttonActionPerformed
       silinsinmi();
    }//GEN-LAST:event_sil_buttonActionPerformed

    private void guncelle_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guncelle_buttonActionPerformed
       try {
            String kimlik=txtf_tckimlik.getText();
            String adi=txtf_adi_soyadi.getText();
            String sos=String.valueOf(jComboBox2.getSelectedItem());
            String telno1=txtf_telefon.getText();
            String adres=area_adres.getText();
        
       {Class.forName(surucu);
            baglanti = DriverManager.getConnection(url+veritabaniadi,kullaniciAdi,sifre);
            komut =baglanti.createStatement();
            
        String sql ="UPDATE `musteri_bilgisi` SET tc_kimlik_no='"+kimlik+"', adi_soyadi='"+adi+"', guvence='"
               +sos+"', telefon='"+telno1+"', adres='"+adres+"' WHERE tc_kimlik_no='"+kimlik+"'";

                komut.executeUpdate(sql); 
                JOptionPane.showMessageDialog(null," Müşteri Bilgisi Güncellenmiştir.");}
       
       } catch (ClassNotFoundException ex) {
           JOptionPane.showMessageDialog(null,"Hata: " + ex.toString());
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(this,"Veritabanına bağlantı sağlanamadı! " + ex.toString());
    }
    Guncelle();
    veri_listele();

    }//GEN-LAST:event_guncelle_buttonActionPerformed

    private void ekle_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ekle_buttonActionPerformed
        try {
            String tc_kimlik_no=txtf_tckimlik.getText();
            String adi_soyadi=txtf_adi_soyadi.getText();
            String guvencesi= String.valueOf(jComboBox2.getSelectedItem());
            String adresi=area_adres.getText();
            String telefon=txtf_telefon.getText();

            if (tc_kimlik_no.equals("") || adi_soyadi.equals("") || adresi.equals("")|| telefon.equals("")){

                JOptionPane.showMessageDialog(this, "Lütfen Boş Alanları Doldurunuz!");

            } else {
                Class.forName(surucu);
                baglanti = DriverManager.getConnection(url+veritabaniadi,kullaniciAdi,sifre);

                komut =baglanti.createStatement();

                String sql = "INSERT INTO musteri_bilgisi (tc_kimlik_no,adi_soyadi,guvence,telefon,adres)"
                + " VALUES ('"+tc_kimlik_no+"','"+adi_soyadi+"', '"+guvencesi+"', '"+telefon+"','"+adresi+"')";

                komut.executeUpdate(sql); //
                JOptionPane.showMessageDialog(null," Hasta Bilgisi Eklenmiştir.");
            }
        }
        catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Hata: " + ex.toString());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Veritabanına bağlantı sağlanamadı! " + ex.toString());
        }
       veri_listele();
    }//GEN-LAST:event_ekle_buttonActionPerformed

    private void temizleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_temizleActionPerformed
       txtf_tckimlik.setText(" ");
       txtf_adi_soyadi.setText(" ");
       txtf_telefon.setText(" ");
       area_adres.setText(" ");
       txt_bul.setText(" ");
    }//GEN-LAST:event_temizleActionPerformed

    private void ilk_kayitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ilk_kayitActionPerformed
        row=0;
        tableadan_veri_goster(row);    
    }//GEN-LAST:event_ilk_kayitActionPerformed

    private void son_kayitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_son_kayitActionPerformed
        row=tablo_bilgileri.getRowCount();
        tableadan_veri_goster(row-1);
    }//GEN-LAST:event_son_kayitActionPerformed

    private void menuitem_yoneticiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuitem_yoneticiActionPerformed
       yonetici_giris_paneli panel=new yonetici_giris_paneli();
       panel.setVisible(true);
    }//GEN-LAST:event_menuitem_yoneticiActionPerformed

    private void menuitem_kapatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuitem_kapatActionPerformed
       onay();
    }//GEN-LAST:event_menuitem_kapatActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Guncelle();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        row++;
        if(row>=tablo_bilgileri.getRowCount())
        row=0;
        tableadan_veri_goster(row);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        row--;
        if (row<=0)
        row=tablo_bilgileri.getRowCount()-1;
        tableadan_veri_goster(row);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void menuitem_hakkimizdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuitem_hakkimizdaActionPerformed
        hakkimizda git=new hakkimizda();
        git.setVisible(true);
    }//GEN-LAST:event_menuitem_hakkimizdaActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        ilk_giris yonlen=new ilk_giris();
        yonlen.setVisible(true);
        hide();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
            java.util.logging.Logger.getLogger(musteri_bilgileri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(musteri_bilgileri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(musteri_bilgileri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(musteri_bilgileri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new musteri_bilgileri().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea area_adres;
    private javax.swing.JButton bul;
    private javax.swing.JButton ekle_button;
    private javax.swing.JButton guncelle_button;
    private javax.swing.JButton ilk_kayit;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenu menu;
    private javax.swing.JMenu menu_hakkinda;
    private javax.swing.JMenuItem menuitem_hakkimizda;
    private javax.swing.JMenuItem menuitem_kapat;
    private javax.swing.JMenuItem menuitem_yonetici;
    private javax.swing.JButton sil_button;
    private javax.swing.JButton son_kayit;
    private javax.swing.JTable tablo_bilgileri;
    private javax.swing.JMenu takvim_menu;
    private javax.swing.JButton temizle;
    private javax.swing.JTextField txt_bul;
    private javax.swing.JTextField txtf_adi_soyadi;
    private javax.swing.JTextField txtf_tckimlik;
    private javax.swing.JTextField txtf_telefon;
    // End of variables declaration//GEN-END:variables
}
