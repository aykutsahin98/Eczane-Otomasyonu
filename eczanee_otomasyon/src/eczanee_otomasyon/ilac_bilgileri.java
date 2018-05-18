package eczanee_otomasyon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

public class ilac_bilgileri extends javax.swing.JFrame {
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
        String baslik[] = new String[]{"İlaç No","İlaç Adı","Firma","Fiyat","Adet","Kullanım Amacı"}; 
        Class.forName(surucu);
        baglanti = DriverManager.getConnection(url+veritabaniadi,kullaniciAdi,sifre);
             
        komut = baglanti.createStatement();                
        gelenveri = komut.executeQuery("select * from ilac_bilgisi");
        gelenveri.last();
           
        int kayitsayisi = gelenveri.getRow();
        gelenveri.beforeFirst();
  
        Object data[][] = new Object[kayitsayisi][];
        int i = 0;

        while (gelenveri.next()) {

        data[i] = new Object[]{  
            gelenveri.getString("id"),
            gelenveri.getString("ilac_adi"), 
            gelenveri.getString("uretici_firma"),
            gelenveri.getString("ilac_fiyati"),
            gelenveri.getString("adet"),
            gelenveri.getString("kullanim_amaci"),
        };
            i++;
        }        
    baglanti.close();
    tablo_bilgileri.setModel(new DefaultTableModel(data, baslik));
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Hata: " + ex.toString());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Veritabanına bağlantı sağlanamadı! " + ex.toString());
        }
    } 
public ilac_bilgileri() {
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        takvim();
        listele();
        saat();
        jLabel1.setText("İLAÇ EKLE-DÜZENLE SAYFASINA HOŞGELDİNİZ");
    }
public void listele(){
        String ad[]=new String []{"İlaç No","İlaç Adı","Firma","Fiyat","Adet","Kullanım Amacı"};
    try {
        Class.forName(surucu);
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eczanee","root","Aykutaylin1998")) //Mysql sunucusuna bağlandık
        {
        Statement st = (Statement) con.createStatement();
            try (ResultSet rs = st.executeQuery("Select * from ilac_bilgisi ")) { //Veritabanındaki tabloya bağlandık
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
        } 
        catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ilac_bilgileri.class.getName()).log(Level.SEVERE, null, ex);
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
                menu_saat.setText("Saat: "+sdf.format(new java.util.Date()));   
            }
        });
        t.start();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablo_bilgileri = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtf_firma = new javax.swing.JTextField();
        txtf_adet = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtf_fiyat = new javax.swing.JTextField();
        ilac_ekle = new javax.swing.JButton();
        button_ara = new javax.swing.JButton();
        ilac_sil = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        ilac_guncelle = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        bul = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtf_adi = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtf_kullanim = new javax.swing.JTextArea();
        ilk_kayit = new javax.swing.JButton();
        son_kayit = new javax.swing.JButton();
        temizle_button = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu = new javax.swing.JMenu();
        menuitem_yonlendir = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        menuitem_kapat = new javax.swing.JMenuItem();
        hakkinda_menı = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        takvim_menu = new javax.swing.JMenu();
        menu_saat = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        jMenu5.setText("File");
        jMenuBar3.add(jMenu5);

        jMenu6.setText("Edit");
        jMenuBar3.add(jMenu6);

        jMenuItem2.setText("jMenuItem2");

        jMenuItem3.setText("jMenuItem3");

        jMenu2.setText("jMenu2");

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        setModalExclusionType(java.awt.Dialog.ModalExclusionType.TOOLKIT_EXCLUDE);
        setPreferredSize(new java.awt.Dimension(922, 680));
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
        tablo_bilgileri.setSelectionBackground(new java.awt.Color(255, 102, 0));
        tablo_bilgileri.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablo_bilgileriMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablo_bilgileri);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 0, 910, 190);

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Kutu Adedi:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(70, 460, 100, 30);

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("İlaç Adı:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(70, 340, 70, 30);

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Üretici Firma:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(70, 400, 100, 30);
        getContentPane().add(txtf_firma);
        txtf_firma.setBounds(180, 400, 170, 30);
        getContentPane().add(txtf_adet);
        txtf_adet.setBounds(180, 460, 170, 30);

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("İlaç Fiyatı:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(410, 340, 95, 30);
        getContentPane().add(txtf_fiyat);
        txtf_fiyat.setBounds(540, 340, 170, 30);

        ilac_ekle.setBackground(new java.awt.Color(204, 204, 204));
        ilac_ekle.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ilac_ekle.setForeground(new java.awt.Color(51, 51, 51));
        ilac_ekle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Pill-32.png"))); // NOI18N
        ilac_ekle.setText("İLAÇ EKLE");
        ilac_ekle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ilac_ekleActionPerformed(evt);
            }
        });
        getContentPane().add(ilac_ekle);
        ilac_ekle.setBounds(140, 530, 130, 45);

        button_ara.setBackground(new java.awt.Color(255, 153, 51));
        button_ara.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        button_ara.setForeground(new java.awt.Color(51, 51, 51));
        button_ara.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/searchh.png"))); // NOI18N
        button_ara.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button_ara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_araActionPerformed(evt);
            }
        });
        getContentPane().add(button_ara);
        button_ara.setBounds(410, 280, 60, 40);

        ilac_sil.setBackground(new java.awt.Color(204, 204, 204));
        ilac_sil.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ilac_sil.setForeground(new java.awt.Color(51, 51, 51));
        ilac_sil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        ilac_sil.setText("İLAÇ SİL");
        ilac_sil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ilac_silActionPerformed(evt);
            }
        });
        getContentPane().add(ilac_sil);
        ilac_sil.setBounds(620, 530, 120, 45);

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Kullanım Amacı:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(410, 400, 130, 30);

        ilac_guncelle.setBackground(new java.awt.Color(204, 204, 204));
        ilac_guncelle.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ilac_guncelle.setForeground(new java.awt.Color(51, 51, 51));
        ilac_guncelle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/update.png"))); // NOI18N
        ilac_guncelle.setText("İLAÇLARI GÜNCELLE");
        ilac_guncelle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ilac_guncelleActionPerformed(evt);
            }
        });
        getContentPane().add(ilac_guncelle);
        ilac_guncelle.setBounds(350, 530, 190, 45);

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
        jButton1.setBounds(630, 280, 110, 40);

        bul.setBackground(new java.awt.Color(204, 204, 204));
        bul.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bul.setForeground(new java.awt.Color(204, 0, 0));
        getContentPane().add(bul);
        bul.setBounds(180, 280, 210, 30);

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 0));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(270, 210, 410, 50);

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Filtrele:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(70, 280, 60, 30);
        getContentPane().add(txtf_adi);
        txtf_adi.setBounds(180, 340, 170, 30);

        txtf_kullanim.setColumns(20);
        txtf_kullanim.setLineWrap(true);
        txtf_kullanim.setRows(5);
        txtf_kullanim.setWrapStyleWord(true);
        jScrollPane2.setViewportView(txtf_kullanim);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(540, 400, 170, 60);

        ilk_kayit.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ilk_kayit.setForeground(new java.awt.Color(51, 51, 51));
        ilk_kayit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/1493682916_Backward_Skip.png"))); // NOI18N
        ilk_kayit.setText("İLK");
        ilk_kayit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ilk_kayitActionPerformed(evt);
            }
        });
        getContentPane().add(ilk_kayit);
        ilk_kayit.setBounds(750, 280, 120, 40);

        son_kayit.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        son_kayit.setForeground(new java.awt.Color(51, 51, 51));
        son_kayit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/1493682902_Forward_Skip.png"))); // NOI18N
        son_kayit.setText("SON");
        son_kayit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                son_kayitActionPerformed(evt);
            }
        });
        getContentPane().add(son_kayit);
        son_kayit.setBounds(750, 330, 120, 40);

        temizle_button.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        temizle_button.setForeground(new java.awt.Color(51, 51, 51));
        temizle_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/001-broom.png"))); // NOI18N
        temizle_button.setText("Temizle");
        temizle_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                temizle_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(temizle_button);
        temizle_button.setBounds(490, 280, 120, 40);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/1493682936_Fast_Forward.png"))); // NOI18N
        jButton2.setText("İleri");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(750, 380, 120, 40);

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/1493682927_Rewind.png"))); // NOI18N
        jButton3.setText("Geri");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(750, 430, 120, 40);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jLabel10);
        jLabel10.setBounds(350, 340, 0, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/background-2132910_960_720.jpg"))); // NOI18N
        jLabel7.setPreferredSize(new java.awt.Dimension(730, 470));
        getContentPane().add(jLabel7);
        jLabel7.setBounds(0, 0, 910, 620);

        jLabel9.setText("jLabel9");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(330, 360, 110, 30);
        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 10, 10);

        menu.setForeground(new java.awt.Color(102, 0, 102));
        menu.setText("Menü");
        menu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        menuitem_yonlendir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_MASK));
        menuitem_yonlendir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        menuitem_yonlendir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/right-arrow.png"))); // NOI18N
        menuitem_yonlendir.setText("Yönetici Giriş Paneline Git");
        menuitem_yonlendir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuitem_yonlendirActionPerformed(evt);
            }
        });
        menu.add(menuitem_yonlendir);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/back (1).png"))); // NOI18N
        jMenuItem5.setText("Giriş Paneline Git");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        menu.add(jMenuItem5);

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

        hakkinda_menı.setForeground(new java.awt.Color(255, 102, 0));
        hakkinda_menı.setText("Hakkında");
        hakkinda_menı.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/1493484785_Information.png"))); // NOI18N
        jMenuItem4.setText("Hakkımızda");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        hakkinda_menı.add(jMenuItem4);

        jMenuBar1.add(hakkinda_menı);

        takvim_menu.setForeground(new java.awt.Color(0, 51, 51));
        takvim_menu.setText("Takvim");
        takvim_menu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuBar1.add(takvim_menu);

        menu_saat.setForeground(new java.awt.Color(153, 0, 0));
        menu_saat.setText("Saat");
        menu_saat.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuBar1.add(menu_saat);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
public void silinsinmi(){
    int karar=  JOptionPane.showConfirmDialog(null, "Kayıt Silinsin Mi? ?", "Sil",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
    if(karar==0){
        try{
            String ilac=txtf_adi.getText();
            Class.forName(surucu);
                baglanti = DriverManager.getConnection(url+veritabaniadi,kullaniciAdi,sifre);
                komut = baglanti.createStatement();
                String sql="DELETE FROM `ilac_bilgisi` WHERE ilac_adi='"+ilac+"'";
                komut.executeUpdate(sql);
                JOptionPane.showMessageDialog(null,"İlaç Bilgisi Silinmiştir");
                txtf_adi.setText("");
                txtf_firma.setText("");
                txtf_fiyat.setText("");
                txtf_adet.setText("");
                txtf_kullanim.setText("");
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
int updateId=0;
   public void tableadan_veri_goster (int r){
    String alinanid=String.valueOf(tablo_bilgileri.getModel().getValueAt(r, 0));
    String alinanilacadi=String.valueOf(tablo_bilgileri.getModel().getValueAt(r, 1));
    String alinanuretici_firma=String.valueOf(tablo_bilgileri.getModel().getValueAt(r, 2));
    String alinan_adet=String.valueOf(tablo_bilgileri.getModel().getValueAt(r, 3));
    String alinan_fiyat=String.valueOf(tablo_bilgileri.getModel().getValueAt(r, 4));
    String alinan_amac=String.valueOf(tablo_bilgileri.getModel().getValueAt(r, 5));
    txtf_adi.setText(alinanilacadi);
    txtf_firma.setText(alinanuretici_firma);
    txtf_fiyat.setText(alinan_adet);
    txtf_adet.setText(alinan_fiyat);
    txtf_kullanim.setText(alinan_amac);
    updateId = Integer.parseInt(String.valueOf(tablo_bilgileri.getModel().getValueAt(r, 0)));
}
int row=0;
    private void tablo_bilgileriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablo_bilgileriMouseClicked
    try{
        row=tablo_bilgileri.getSelectedRow();
        tableadan_veri_goster(row);
        
    } catch (Exception e){
        JOptionPane.showInputDialog(e);
        }
    }//GEN-LAST:event_tablo_bilgileriMouseClicked

    private void button_araActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_araActionPerformed
        String ara =bul.getText();
        String baslik[] = new String[]{"İlaç No","İlaç Adı","Firma","Fiyat","Adet","Kullanım Amacı"}; 

        try {
            
            Class.forName(surucu);
            
            baglanti = DriverManager.getConnection(url+veritabaniadi,kullaniciAdi,sifre);
            
            String sorgu ="select * from ilac_bilgisi where id like '%"+bul.getText()+"%' or"
                    +" ilac_adi like '%"+bul.getText()+"%' or"
                    +" uretici_firma like '%"+bul.getText()+"%' or"
                    +" kullanim_amaci like '%"+bul.getText()+"%' ";
            
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
                        gelenveri.getString("ilac_fiyati"),  
                        gelenveri.getString("adet"),
                        gelenveri.getString("kullanim_amaci"),
                       
                    };
                    i++;
                }
                tablo_bilgileri.setModel(new DefaultTableModel(data, baslik));
            }
            
        } catch (ClassNotFoundException ex) {
           JOptionPane.showMessageDialog(null,"Hata: " + ex.toString());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Veritabanına bağlantı sağlanamadı! " + ex.toString());
        }
    }//GEN-LAST:event_button_araActionPerformed

    private void ilk_kayitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ilk_kayitActionPerformed
          row=0;
          tableadan_veri_goster(row);
    }//GEN-LAST:event_ilk_kayitActionPerformed

    private void son_kayitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_son_kayitActionPerformed
       row=tablo_bilgileri.getRowCount();
        tableadan_veri_goster(row-1);
    }//GEN-LAST:event_son_kayitActionPerformed

    private void temizle_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_temizle_buttonActionPerformed
        txtf_adi.setText(" ");
        txtf_adet.setText(" ");
        txtf_firma.setText(" ");
        txtf_fiyat.setText(" ");
        txtf_kullanim.setText(" ");
        bul.setText("");
    }//GEN-LAST:event_temizle_buttonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       Guncelle();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ilac_silActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ilac_silActionPerformed
        silinsinmi();
    }//GEN-LAST:event_ilac_silActionPerformed
 
    private void ilac_guncelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ilac_guncelleActionPerformed
        if (updateId>0) {
            try {
             
            String ilac_adi=txtf_adi.getText();
            String firma=txtf_firma.getText();
            String adet=txtf_adet.getText();
            String fiyat=txtf_fiyat.getText();
            String amac=txtf_kullanim.getText();
            
            if (ilac_adi.equals("") || firma.equals("") || adet.equals("")|| fiyat.equals("") || amac.equals(""))
            {

                JOptionPane.showMessageDialog(this, "Lütfen Boş Alanları Doldurunuz!");

            } else {Class.forName(surucu);
                baglanti = DriverManager.getConnection(url+veritabaniadi,kullaniciAdi,sifre);
               komut =baglanti.createStatement();
                 String sql="UPDATE `ilac_bilgisi` SET ilac_adi='"+ilac_adi+"', uretici_firma='"+firma+"', "
                         + "adet='"+adet+"', ilac_fiyati='"+fiyat+"', kullanim_amaci='"+amac+"' WHERE id='"+updateId+"'";
                komut.executeUpdate(sql);
                JOptionPane.showMessageDialog(null," İlaç Bilgisi Güncellenmiştir.");
             
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Hata: " + ex.toString());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Veritabanına bağlantı sağlanamadı! " + ex.toString());
        }
        }
        Guncelle();
        listele();
    
    }//GEN-LAST:event_ilac_guncelleActionPerformed

    private void ilac_ekleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ilac_ekleActionPerformed
        try {
            String ilac_adi=txtf_adi.getText();
            String uretici_firma=txtf_firma.getText();
            String fiyat=txtf_fiyat.getText();
            String adet=txtf_adet.getText();
            String amac=txtf_kullanim.getText();
            if (ilac_adi.equals("") || uretici_firma.equals("") || fiyat.equals("")|| adet.equals("") || amac.equals(""))
            {

                JOptionPane.showMessageDialog(this, "Lütfen Boş Alanları Doldurunuz!");

            } else {Class.forName(surucu);
                
                baglanti = DriverManager.getConnection(url+veritabaniadi,kullaniciAdi,sifre);
                komut =baglanti.createStatement();
                String sql = "INSERT INTO ilac_bilgisi (ilac_adi,uretici_firma,ilac_fiyati,adet,kullanim_amaci)"
                + " VALUES ('"+ilac_adi+"','"+uretici_firma+"', '"+fiyat+"', '"+adet+"','"+amac+"')";
                komut.executeUpdate(sql);
                JOptionPane.showMessageDialog(null," İlaç Bilgisi Eklenmiştir.");
            }
        }catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Hata: " + ex.toString());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Veritabanına bağlantı sağlanamadı! " + ex.toString());
        }
        Guncelle();
    }//GEN-LAST:event_ilac_ekleActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        hakkimizda h=new hakkimizda();
        h.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        row++;
       if(row>=tablo_bilgileri.getRowCount())
           row=0;
           tableadan_veri_goster(row); 
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       row--;
        if (row<=0) 
            row=tablo_bilgileri.getRowCount()-1;
            tableadan_veri_goster(row);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void menuitem_kapatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuitem_kapatActionPerformed
        onay();
    }//GEN-LAST:event_menuitem_kapatActionPerformed

    private void menuitem_yonlendirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuitem_yonlendirActionPerformed
        yonetici_giris_paneli degisken_adi = new yonetici_giris_paneli();
        degisken_adi.setVisible(false);
        dispose();
    }//GEN-LAST:event_menuitem_yonlendirActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        ilk_giris yonlen=new ilk_giris();
        yonlen.setVisible(true);
        hide();
    }//GEN-LAST:event_jMenuItem5ActionPerformed
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
            java.util.logging.Logger.getLogger(ilac_bilgileri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ilac_bilgileri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ilac_bilgileri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ilac_bilgileri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ilac_bilgileri().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bul;
    private javax.swing.JButton button_ara;
    private javax.swing.JMenu hakkinda_menı;
    private javax.swing.JButton ilac_ekle;
    private javax.swing.JButton ilac_guncelle;
    private javax.swing.JButton ilac_sil;
    private javax.swing.JButton ilk_kayit;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenu menu;
    private javax.swing.JMenu menu_saat;
    private javax.swing.JMenuItem menuitem_kapat;
    private javax.swing.JMenuItem menuitem_yonlendir;
    private javax.swing.JButton son_kayit;
    private javax.swing.JTable tablo_bilgileri;
    private javax.swing.JMenu takvim_menu;
    private javax.swing.JButton temizle_button;
    private javax.swing.JTextField txtf_adet;
    private javax.swing.JTextField txtf_adi;
    private javax.swing.JTextField txtf_firma;
    private javax.swing.JTextField txtf_fiyat;
    private javax.swing.JTextArea txtf_kullanim;
    // End of variables declaration//GEN-END:variables
}
