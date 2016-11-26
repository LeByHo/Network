package Main;


import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.util.Random;

import javax.swing.JLabel;

import Client.Client;

class Wordmean extends JLabel implements Runnable {
   String[] mean = new String[10];


   Wordmean() {
	   try {
		String str = Client.getmean();
		String[] wo = str.split(" ");
		mean = wo;
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      Font f2 = new Font("±Ã¼­", Font.BOLD, 20);
      setHorizontalAlignment(CENTER);
      setFont(f2);
      setBounds(421, 469, 334, 70);
      setBackground(new Color(255,255,255,100));
      setOpaque(true);
   }

   public void run() {
	 int k=0;
      while (k < 10) {
//    	  setBackground(new Color(255,255,255,100));
    	  setText(mean[k]);
         try {
            Thread.sleep(11000);
         } catch (Exception ex) {
         }
         k++;
      }
   }

}