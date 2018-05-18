package eczanee_otomasyon;
public class eczanee_otomasyon {
    
     public static void main(String[] args) throws InterruptedException {
            eczane_açılış giris=new eczane_açılış();
            giris.setVisible(true);
            ilk_giris Start=new ilk_giris();
            try {
              for (int i = 0; i <=100; i++) {
                    Thread.sleep(50);
                    eczane_açılış.progressbar.setValue(i);    
                    
                    if (i==100){
                        giris.setVisible(false);
                        Start.setVisible(true);
                    }
              }       
         } catch (InterruptedException e) {
      }
     }
}


