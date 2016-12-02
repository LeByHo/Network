package Main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Client.Client;
import Client.DTO;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.UIManager;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Mybook extends JFrame {
   private JPanel contentPane;
   DTO dto = new DTO();
   
//   public static void main(String[] args) {
//      EventQueue.invokeLater(new Runnable() {
//         public void run() {
//            try {
//               Mybook frame = new Mybook();
//               frame.setVisible(true);
//            } catch (Exception e) {
//               e.printStackTrace();
//            }
//         }
//      });
//   }

   public Mybook() {
      setTitle("VOCA POP");
      setSize(1100, 900);
      setResizable(false);
      setLocation(0, 0);
      ImageIcon icon = new ImageIcon("book0.jpg");
      
      ani panel = new ani(){
         public void paintComponent(Graphics g) {
            g.drawImage(icon.getImage(), 0, 0, null);
            setOpaque(false);// 배경 띄워주기
            super.paintComponent(g);
         }
      };
      placeLoginPanel(panel);
      getContentPane().add(panel);
      setVisible(true);
      
   }

   private void placeLoginPanel(ani panel) {
      int i=0;
      panel.setLayout(null);
      Color color = new Color(255, 0, 0);
         JButton right = new JButton(new ImageIcon("d.jpg"));
      right.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            Object obj = arg0.getSource();
            if ((JButton) obj == right) {
               panel.page=panel.page+20;
               panel.view(1);
               Thread a = new Thread(panel);
                a.start();    
            }
         }
      });
      right.setBounds(820, 700, 50, 50);
      panel.add(right);
      JButton left = new JButton(new ImageIcon("e.jpg"));
      left.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            Object obj = arg0.getSource();
            if ((JButton) obj == left) {
               panel.page=panel.page-20;
               panel.view(1);
               panel.change(1);
               Thread a = new Thread(panel);
                a.start();    
            }
         }
      });
      left.setBounds(240, 700, 50, 50);
      panel.add(left);
   }
}

class ani extends JPanel implements Runnable {
   static String[] Book= new String[100]; 
   static int real=0;
   static int page=0;
   ImageIcon e1 = new ImageIcon("book0.jpg");
   ImageIcon e2 = new ImageIcon("book1.jpg");
   ImageIcon e3 = new ImageIcon("book2.jpg");
   ImageIcon e4 = new ImageIcon("book3.jpg");
   ImageIcon e5 = new ImageIcon("book0.jpg");
   static vo voc1;
   static vo voc2;
   Image[] originImg = new Image[5];
   Image[] changedImg= new Image[5];
   Graphics g = null;
   int i=0;
   int z=0;
   ani() {
      setOpaque(true);
      originImg[0] = e1.getImage();
      originImg[1] = e2.getImage();
      originImg[2] = e3.getImage();
      originImg[3] = e4.getImage();
      originImg[4] = e5.getImage();
      for(int i =0; i<5;i++){
         changedImg[i]=originImg[i].getScaledInstance(1100, 900, Image.SCALE_SMOOTH );
      }
      
      
      int i;
      for(i=real;i<Last.numbook+real;i++){
         Book[i]=(Last.mybook[i-real]);
      }
      real=i;
      view(0);
      Thread a = new Thread(this);
       a.start();    
   }
   public void change(int z){
      this.z=z;
   }
   public void view(int i){
      if(i==1){
         voc1.setVisible(false);
         voc2.setVisible(false);
      }
      //System.out.println(page);
      vo voca1 = new vo(63,63);
      this.add(voca1);
      vo voca2 = new vo(638,63);
      voc1=voca1;
      voc2=voca2;
      this.add(voca2);
      int k=real-page;
      if(((k/10)%2)==0)
         k=k/2;
      if(i==0){
         if(real>20){
         while(i<20){
            if(i<10){
               wor word = new wor(Book[i]);
               voca1.add(word);
            }
            else{
               wor word = new wor(Book[i]);
               voca2.add(word);
            }
            i++;
         }
         }
         else{
            while(i<20){
            if(i<k){
               wor word = new wor(Book[i]);
               voca1.add(word);
            }
            else{
               
               wor word = new wor(Book[i]);
               voca2.add(word);
            }
            i++;
            page++;
         }
            
         }
      }
      else{
         System.out.println(page);
         System.out.println(real);
      while(page<real){
         System.out.println("확인");
         if(page<k+page){
            wor word = new wor(Book[page]);
            voca1.add(word);
         }
         else{
            wor word = new wor(Book[page]);
            voca2.add(word);
         }
         page++;
      }
      }
      page=0;
   }

   public void run(){
      if(z==0){
      for(i=0;i<5;i++){
         
//         voca1.setVisible(false);
//         voca2.setVisible(false);
            repaint();
      try{
         Thread.sleep(100);
         }
         catch(Exception e){      
         }
      }
      }
      else{
         for(i=4;i>=0;i--){
         repaint();
//         voca1.setVisible(false);
//         voca2.setVisible(false);
      try{
         
         Thread.sleep(100);
         }
         catch(Exception e){      
         }
      }
      }
      i=0;
      z=0;
//      voca1.setVisible(true);
//      voca2.setVisible(true);
   }
   public void paintComponent(Graphics g){
      g.drawImage(changedImg[i],0,0,null);
   }
}
class wor extends JLabel{
   wor(String s){
      setText(s);
   }
}

class vo extends JPanel {
   GridLayout layout = new GridLayout(10, 1);
   vo(int x, int y) {
      setBounds(x, y, 410, 600);
      setOpaque(true);
      setLayout(layout);
   }
}
