package Main;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Client.DTO;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
public class Final extends JFrame{
      private JPanel contentPane;
      DTO dto = new DTO();

      public static void main(String[] args) {
         EventQueue.invokeLater(new Runnable() {
            public void run() {
               try {
                  Final frame = new Final();
                  frame.setVisible(true);
               } catch (Exception e) {
                  e.printStackTrace();
               }
            }
         });
      }

      public Final() {
         setTitle("VOCA POP");
         setSize(1100, 900);
         setResizable(false);
         setLocation(0, 0);
         ImageIcon icon = new ImageIcon("background4.png");
 		Image originImg = icon.getImage();
 		Image changedImg = originImg.getScaledInstance(1100, 870, Image.SCALE_SMOOTH);
 		ImageIcon Icon = new ImageIcon(changedImg);
         JPanel panel = new JPanel() {
            public void paintComponent(Graphics g) {
               g.drawImage(Icon.getImage(), 0, 0, null);
               setOpaque(false);// 배경 띄워주기
               super.paintComponent(g);
            }
         };
         placeLoginPanel(panel);
         getContentPane().add(panel);
         
         setVisible(true);
      }

      private void placeLoginPanel(JPanel panel) {
         panel.setLayout(null); 
         
         JButton submit= new JButton("제출하기");
         submit.setBounds(950, 800, 100, 50);
         panel.add(submit);
         
         JPanel main = new JPanel();
         main.setBounds(0, 100, 550, 700);
         main.setLayout(null);
         main.setOpaque(false);
         panel.add(main);
         
         exam exam1 = new exam(0,0);
         main.add(exam1);
         exam exam2 = new exam(0,70);
         main.add(exam2);
         exam exam3 = new exam(0,140);
         main.add(exam3);
         exam exam4 = new exam(0,210);
         main.add(exam4);
         exam exam5 = new exam(0,280);
         main.add(exam5);
         exam exam6 = new exam(0,350);
         main.add(exam6);
         exam exam7 = new exam(0,420);
         main.add(exam7);
         exam exam8 = new exam(0,490);
         main.add(exam8);
         exam exam9 = new exam(0,560);
         main.add(exam9);
         exam exam10 = new exam(0,630);
         main.add(exam10);
         
         JPanel main2 = new JPanel();
         main2.setBounds(550, 100, 550, 700);
         panel.add(main2);
         main2.setLayout(null);
         main2.setOpaque(false);
         
         exam exam11 = new exam(0,0);
         main2.add(exam11);
         exam exam12 = new exam(0,70);
         main2.add(exam12);
         exam exam13 = new exam(0,140);
         main2.add(exam13);
         exam exam14 = new exam(0,210);
         main2.add(exam14);
         exam exam15 = new exam(0,280);
         main2.add(exam15);
         exam exam16 = new exam(0,350);
         main2.add(exam16);
         exam exam17 = new exam(0,420);
         main2.add(exam17);
         exam exam18 = new exam(0,490);
         main2.add(exam18);
         exam exam19 = new exam(0,560);
         main2.add(exam19);
         exam exam20 = new exam(0,630);
         main2.add(exam20);
   }
}
class exam extends JPanel{
   exam(int x, int y){
      setLayout(null);
      setOpaque(false);
      setBounds(x,y,550,60);
      JLabel number = new JLabel("1. "+"  ");
      number.setBounds(20,0,100,20);
      this.add(number);
      
      JCheckBox checkBox1 = new JCheckBox("hi");
      checkBox1.setBounds(20, 20, 80, 40);
      checkBox1.setOpaque(false);
      
      this.add(checkBox1);
      JCheckBox checkBox2 = new JCheckBox("hello");
      checkBox2.setBounds(140, 20, 80, 40);
      checkBox2.setOpaque(false);
      this.add(checkBox2);
      
      JCheckBox checkBox3 = new JCheckBox("count");
      checkBox3.setBounds(290, 20, 80, 40);
      checkBox3.setOpaque(false);
      this.add(checkBox3);
      JCheckBox checkBox4 = new JCheckBox("play");
      checkBox4.setBounds(430, 20, 80, 40);
      checkBox4.setOpaque(false);
      this.add(checkBox4);
       checkBox1.addItemListener(new ItemListener() {
          int count =0;
            public void itemStateChanged(ItemEvent arg0) {
               count++;
               if(count%2==1){
               checkBox2.setEnabled(false);   
               checkBox3.setEnabled(false);   
               checkBox4.setEnabled(false);   
               }
               else{
                  checkBox2.setEnabled(true);   
                  checkBox3.setEnabled(true);   
                  checkBox4.setEnabled(true);   

               }
            }
           });
       checkBox2.addItemListener(new ItemListener() {
          int count =0;
            public void itemStateChanged(ItemEvent arg0) {
               count++;
               if(count%2==1){
               checkBox1.setEnabled(false);   
               checkBox3.setEnabled(false);   
               checkBox4.setEnabled(false);   
               }
               else{
                  checkBox1.setEnabled(true);   
                  checkBox3.setEnabled(true);   
                  checkBox4.setEnabled(true);   

               }
            }
           });
       checkBox3.addItemListener(new ItemListener() {
          int count =0;
            public void itemStateChanged(ItemEvent arg0) {
               count++;
               if(count%2==1){
               checkBox2.setEnabled(false);   
               checkBox1.setEnabled(false);   
               checkBox4.setEnabled(false);   
               }
               else{
                  checkBox2.setEnabled(true);   
                  checkBox1.setEnabled(true);   
                  checkBox4.setEnabled(true);   

               }
            }
           });
       checkBox4.addItemListener(new ItemListener() {
          int count =0;
            public void itemStateChanged(ItemEvent arg0) {
               count++;
               if(count%2==1){
               checkBox2.setEnabled(false);   
               checkBox3.setEnabled(false);   
               checkBox1.setEnabled(false);   
               }
               else{
                  checkBox2.setEnabled(true);   
                  checkBox3.setEnabled(true);   
                  checkBox1.setEnabled(true);   

               }
            }
           });
   }
}