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
import java.io.IOException;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Client.Client;
import Client.DTO;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
public class Final extends JFrame{
      private JPanel contentPane;
      DTO dto = new DTO();
      String[] wd= new String[10];
      String[] mean= new String[10];

//      public static void main(String[] args) {
//         EventQueue.invokeLater(new Runnable() {
//            public void run() {
//               try {
//                  Final frame = new Final();
//                  frame.setVisible(true);
//               } catch (Exception e) {
//                  e.printStackTrace();
//               }
//            }
//         });
//      }

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
         try {
             String str = Client.getword(wword.catego);
             String[] wo = str.split(" ");
             wd=wo;
             String str2 = Client.getmean(Wordmean.cate);
             String[] wo2 = str2.split(" ");
             mean = wo2;
          } catch (IOException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
          }
         JButton submit= new JButton("제출하기");
         submit.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent arg0) {
        
                   dispose();
        
             }
          });
         submit.setBounds(950, 800, 100, 50);
         panel.add(submit);
         
         JPanel main = new JPanel();
         main.setBounds(100, 130, 800, 700);
         main.setLayout(null);
         main.setOpaque(false);
         panel.add(main);
         
         exam exam1 = new exam(20,0,wd,mean,0);
         main.add(exam1);
         exam exam2 = new exam(20,70,wd,mean,1);
         main.add(exam2);
         exam exam3 = new exam(20,140,wd,mean,2);
         main.add(exam3);
         exam exam4 = new exam(20,210,wd,mean,3);
         main.add(exam4);
         exam exam5 = new exam(20,280,wd,mean,4);
         main.add(exam5);
         exam exam6 = new exam(20,350,wd,mean,5);
         main.add(exam6);
         exam exam7 = new exam(20,420,wd,mean,6);
         main.add(exam7);
         exam exam8 = new exam(20,490,wd,mean,7);
         main.add(exam8);
         exam exam9 = new exam(20,560,wd,mean,8);
         main.add(exam9);
         exam exam10 = new exam(20,630,wd,mean,9);
         main.add(exam10);
   }
}
class exam extends JPanel{
   int k=0;
   int n;
   exam(int x, int y,String[] word,String[] mean, int num){
      n=num;
      setLayout(null);
      setOpaque(false);
      setBounds(x,y,800,60);
      JLabel number = new JLabel((num+1)+".  "+mean[num]);
      number.setBounds(20,0,100,20);
      this.add(number);
      int k=0,i=0,r,j;
      Random rand1 = new Random();
      int[] temp = new int[4];
      int[] temp2 = new int[4];
      while(k<4){
         if(num+k>9)
            num=0;
        temp[k]=num+k;

        k++; 
      }
      while (i < 4) {
         r = rand1.nextInt(4);
         j = 0;
           
         while (j < i) {
            if (temp2[j] == r) {
               r = rand1.nextInt(4);
               j = 0;
            } else
               j++;
         }
         temp2[i] = r;
         i++;
      }
      
      JCheckBox checkBox1 = new JCheckBox(word[temp[temp2[0]]]);
      checkBox1.setBounds(20, 20, 100, 40);
      checkBox1.setOpaque(false);
      
      this.add(checkBox1);
      JCheckBox checkBox2 = new JCheckBox(word[temp[temp2[1]]]);
      checkBox2.setBounds(200, 20, 100, 40);
      checkBox2.setOpaque(false);
      this.add(checkBox2);
      
      JCheckBox checkBox3 = new JCheckBox(word[temp[temp2[2]]]);
      checkBox3.setBounds(400, 20, 100, 40);
      checkBox3.setOpaque(false);
      this.add(checkBox3);
      JCheckBox checkBox4 = new JCheckBox(word[temp[temp2[3]]]);
      checkBox4.setBounds(600, 20, 100, 40);
      checkBox4.setOpaque(false);
      this.add(checkBox4);
       checkBox1.addItemListener(new ItemListener() {
          int count =0;
            public void itemStateChanged(ItemEvent arg0) {
               count++;
               if(count%2==1){
                  if(n==temp[temp2[0]]){
                     if(wword.catego==0&&wword.wlevel==1)
                        Category.f1.change(10);
                     else if(wword.catego==0&&wword.wlevel==2)
                        Category.f2.change(10);
                     else if(wword.catego==0&&wword.wlevel==3)
                        Category.f3.change(10);
                     else if(wword.catego==1&&wword.wlevel==1)
                        Category.f4.change(10);
                     else if(wword.catego==1&&wword.wlevel==2)
                        Category.f5.change(10);
                     else if(wword.catego==1&&wword.wlevel==3)
                        Category.f6.change(10);
                     else if(wword.catego==2&&wword.wlevel==1)
                        Category.f7.change(10);
                     else if(wword.catego==2&&wword.wlevel==2)
                        Category.f8.change(10);
                     else if(wword.catego==2&&wword.wlevel==3)
                        Category.f9.change(10);
                     else if(wword.catego==3&&wword.wlevel==1)
                        Category.f10.change(10);
                     else if(wword.catego==3&&wword.wlevel==2)
                        Category.f11.change(10);
                     else if(wword.catego==3&&wword.wlevel==3)
                        Category.f12.change(10);
                     else if(wword.catego==4&&wword.wlevel==1)
                        Category.f13.change(10);
                     else if(wword.catego==4&&wword.wlevel==2)
                        Category.f14.change(10);
                     else if(wword.catego==4&&wword.wlevel==3)
                        Category.f15.change(10);
                     else if(wword.catego==5&&wword.wlevel==1)
                        Category.f16.change(10);
                     else if(wword.catego==5&&wword.wlevel==2)
                        Category.f17.change(10);
                     else if(wword.catego==5&&wword.wlevel==3)
                        Category.f18.change(10);
                  }
               checkBox2.setEnabled(false);   
               checkBox3.setEnabled(false);   
               checkBox4.setEnabled(false);   
               }
               else{
                  if(n==temp[temp2[0]]){
                     if(wword.catego==0&&wword.wlevel==1)
                        Category.f1.change(-10);
                     else if(wword.catego==0&&wword.wlevel==2)
                        Category.f2.change(-10);
                     else if(wword.catego==0&&wword.wlevel==3)
                        Category.f3.change(-10);
                     else if(wword.catego==1&&wword.wlevel==1)
                        Category.f4.change(-10);
                     else if(wword.catego==1&&wword.wlevel==2)
                        Category.f5.change(-10);
                     else if(wword.catego==1&&wword.wlevel==3)
                        Category.f6.change(-10);
                     else if(wword.catego==2&&wword.wlevel==1)
                        Category.f7.change(-10);
                     else if(wword.catego==2&&wword.wlevel==2)
                        Category.f8.change(-10);
                     else if(wword.catego==2&&wword.wlevel==3)
                        Category.f9.change(-10);
                     else if(wword.catego==3&&wword.wlevel==1)
                        Category.f10.change(-10);
                     else if(wword.catego==3&&wword.wlevel==2)
                        Category.f11.change(-10);
                     else if(wword.catego==3&&wword.wlevel==3)
                        Category.f12.change(-10);
                     else if(wword.catego==4&&wword.wlevel==1)
                        Category.f13.change(-10);
                     else if(wword.catego==4&&wword.wlevel==2)
                        Category.f14.change(-10);
                     else if(wword.catego==4&&wword.wlevel==3)
                        Category.f15.change(-10);
                     else if(wword.catego==5&&wword.wlevel==1)
                        Category.f16.change(-10);
                     else if(wword.catego==5&&wword.wlevel==2)
                        Category.f17.change(-10);
                     else if(wword.catego==5&&wword.wlevel==3)
                        Category.f18.change(-10);
                  }
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
                  if(n==temp[temp2[1]]){
                     if(wword.catego==0&&wword.wlevel==1)
                        Category.f1.change(10);
                     else if(wword.catego==0&&wword.wlevel==2)
                        Category.f2.change(10);
                     else if(wword.catego==0&&wword.wlevel==3)
                        Category.f3.change(10);
                     else if(wword.catego==1&&wword.wlevel==1)
                        Category.f4.change(10);
                     else if(wword.catego==1&&wword.wlevel==2)
                        Category.f5.change(10);
                     else if(wword.catego==1&&wword.wlevel==3)
                        Category.f6.change(10);
                     else if(wword.catego==2&&wword.wlevel==1)
                        Category.f7.change(10);
                     else if(wword.catego==2&&wword.wlevel==2)
                        Category.f8.change(10);
                     else if(wword.catego==2&&wword.wlevel==3)
                        Category.f9.change(10);
                     else if(wword.catego==3&&wword.wlevel==1)
                        Category.f10.change(10);
                     else if(wword.catego==3&&wword.wlevel==2)
                        Category.f11.change(10);
                     else if(wword.catego==3&&wword.wlevel==3)
                        Category.f12.change(10);
                     else if(wword.catego==4&&wword.wlevel==1)
                        Category.f13.change(10);
                     else if(wword.catego==4&&wword.wlevel==2)
                        Category.f14.change(10);
                     else if(wword.catego==4&&wword.wlevel==3)
                        Category.f15.change(10);
                     else if(wword.catego==5&&wword.wlevel==1)
                        Category.f16.change(10);
                     else if(wword.catego==5&&wword.wlevel==2)
                        Category.f17.change(10);
                     else if(wword.catego==5&&wword.wlevel==3)
                        Category.f18.change(10);
                  }
               checkBox1.setEnabled(false);   
               checkBox3.setEnabled(false);   
               checkBox4.setEnabled(false);   
               }
               else{
                  if(n==temp[temp2[1]]){
                     if(wword.catego==0&&wword.wlevel==1)
                        Category.f1.change(-10);
                     else if(wword.catego==0&&wword.wlevel==2)
                        Category.f2.change(-10);
                     else if(wword.catego==0&&wword.wlevel==3)
                        Category.f3.change(-10);
                     else if(wword.catego==1&&wword.wlevel==1)
                        Category.f4.change(-10);
                     else if(wword.catego==1&&wword.wlevel==2)
                        Category.f5.change(-10);
                     else if(wword.catego==1&&wword.wlevel==3)
                        Category.f6.change(-10);
                     else if(wword.catego==2&&wword.wlevel==1)
                        Category.f7.change(-10);
                     else if(wword.catego==2&&wword.wlevel==2)
                        Category.f8.change(-10);
                     else if(wword.catego==2&&wword.wlevel==3)
                        Category.f9.change(-10);
                     else if(wword.catego==3&&wword.wlevel==1)
                        Category.f10.change(-10);
                     else if(wword.catego==3&&wword.wlevel==2)
                        Category.f11.change(-10);
                     else if(wword.catego==3&&wword.wlevel==3)
                        Category.f12.change(-10);
                     else if(wword.catego==4&&wword.wlevel==1)
                        Category.f13.change(-10);
                     else if(wword.catego==4&&wword.wlevel==2)
                        Category.f14.change(-10);
                     else if(wword.catego==4&&wword.wlevel==3)
                        Category.f15.change(-10);
                     else if(wword.catego==5&&wword.wlevel==1)
                        Category.f16.change(-10);
                     else if(wword.catego==5&&wword.wlevel==2)
                        Category.f17.change(-10);
                     else if(wword.catego==5&&wword.wlevel==3)
                        Category.f18.change(-10);
                  }
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
                  if(n==temp[temp2[2]]){
                     if(wword.catego==0&&wword.wlevel==1)
                        Category.f1.change(10);
                     else if(wword.catego==0&&wword.wlevel==2)
                        Category.f2.change(10);
                     else if(wword.catego==0&&wword.wlevel==3)
                        Category.f3.change(10);
                     else if(wword.catego==1&&wword.wlevel==1)
                        Category.f4.change(10);
                     else if(wword.catego==1&&wword.wlevel==2)
                        Category.f5.change(10);
                     else if(wword.catego==1&&wword.wlevel==3)
                        Category.f6.change(10);
                     else if(wword.catego==2&&wword.wlevel==1)
                        Category.f7.change(10);
                     else if(wword.catego==2&&wword.wlevel==2)
                        Category.f8.change(10);
                     else if(wword.catego==2&&wword.wlevel==3)
                        Category.f9.change(10);
                     else if(wword.catego==3&&wword.wlevel==1)
                        Category.f10.change(10);
                     else if(wword.catego==3&&wword.wlevel==2)
                        Category.f11.change(10);
                     else if(wword.catego==3&&wword.wlevel==3)
                        Category.f12.change(10);
                     else if(wword.catego==4&&wword.wlevel==1)
                        Category.f13.change(10);
                     else if(wword.catego==4&&wword.wlevel==2)
                        Category.f14.change(10);
                     else if(wword.catego==4&&wword.wlevel==3)
                        Category.f15.change(10);
                     else if(wword.catego==5&&wword.wlevel==1)
                        Category.f16.change(10);
                     else if(wword.catego==5&&wword.wlevel==2)
                        Category.f17.change(10);
                     else if(wword.catego==5&&wword.wlevel==3)
                        Category.f18.change(10);
                  }
               checkBox2.setEnabled(false);   
               checkBox1.setEnabled(false);   
               checkBox4.setEnabled(false);   
               }
               else{
                  if(n==temp[temp2[2]]){
                     if(wword.catego==0&&wword.wlevel==1)
                        Category.f1.change(-10);
                     else if(wword.catego==0&&wword.wlevel==2)
                        Category.f2.change(-10);
                     else if(wword.catego==0&&wword.wlevel==3)
                        Category.f3.change(-10);
                     else if(wword.catego==1&&wword.wlevel==1)
                        Category.f4.change(-10);
                     else if(wword.catego==1&&wword.wlevel==2)
                        Category.f5.change(-10);
                     else if(wword.catego==1&&wword.wlevel==3)
                        Category.f6.change(-10);
                     else if(wword.catego==2&&wword.wlevel==1)
                        Category.f7.change(-10);
                     else if(wword.catego==2&&wword.wlevel==2)
                        Category.f8.change(-10);
                     else if(wword.catego==2&&wword.wlevel==3)
                        Category.f9.change(-10);
                     else if(wword.catego==3&&wword.wlevel==1)
                        Category.f10.change(-10);
                     else if(wword.catego==3&&wword.wlevel==2)
                        Category.f11.change(-10);
                     else if(wword.catego==3&&wword.wlevel==3)
                        Category.f12.change(-10);
                     else if(wword.catego==4&&wword.wlevel==1)
                        Category.f13.change(-10);
                     else if(wword.catego==4&&wword.wlevel==2)
                        Category.f14.change(-10);
                     else if(wword.catego==4&&wword.wlevel==3)
                        Category.f15.change(-10);
                     else if(wword.catego==5&&wword.wlevel==1)
                        Category.f16.change(-10);
                     else if(wword.catego==5&&wword.wlevel==2)
                        Category.f17.change(-10);
                     else if(wword.catego==5&&wword.wlevel==3)
                        Category.f18.change(-10);
                  }
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
                  if(n==temp[temp2[3]]){
                     if(wword.catego==0&&wword.wlevel==1)
                        Category.f1.change(10);
                     else if(wword.catego==0&&wword.wlevel==2)
                        Category.f2.change(10);
                     else if(wword.catego==0&&wword.wlevel==3)
                        Category.f3.change(10);
                     else if(wword.catego==1&&wword.wlevel==1)
                        Category.f4.change(10);
                     else if(wword.catego==1&&wword.wlevel==2)
                        Category.f5.change(10);
                     else if(wword.catego==1&&wword.wlevel==3)
                        Category.f6.change(10);
                     else if(wword.catego==2&&wword.wlevel==1)
                        Category.f7.change(10);
                     else if(wword.catego==2&&wword.wlevel==2)
                        Category.f8.change(10);
                     else if(wword.catego==2&&wword.wlevel==3)
                        Category.f9.change(10);
                     else if(wword.catego==3&&wword.wlevel==1)
                        Category.f10.change(10);
                     else if(wword.catego==3&&wword.wlevel==2)
                        Category.f11.change(10);
                     else if(wword.catego==3&&wword.wlevel==3)
                        Category.f12.change(10);
                     else if(wword.catego==4&&wword.wlevel==1)
                        Category.f13.change(10);
                     else if(wword.catego==4&&wword.wlevel==2)
                        Category.f14.change(10);
                     else if(wword.catego==4&&wword.wlevel==3)
                        Category.f15.change(10);
                     else if(wword.catego==5&&wword.wlevel==1)
                        Category.f16.change(10);
                     else if(wword.catego==5&&wword.wlevel==2)
                        Category.f17.change(10);
                     else if(wword.catego==5&&wword.wlevel==3)
                        Category.f18.change(10);
                  }
               checkBox2.setEnabled(false);   
               checkBox3.setEnabled(false);   
               checkBox1.setEnabled(false);   
               }
               else{
                  if(n==temp[temp2[3]]){
                     if(wword.catego==0&&wword.wlevel==1)
                        Category.f1.change(-10);
                     else if(wword.catego==0&&wword.wlevel==2)
                        Category.f2.change(-10);
                     else if(wword.catego==0&&wword.wlevel==3)
                        Category.f3.change(-10);
                     else if(wword.catego==1&&wword.wlevel==1)
                        Category.f4.change(-10);
                     else if(wword.catego==1&&wword.wlevel==2)
                        Category.f5.change(-10);
                     else if(wword.catego==1&&wword.wlevel==3)
                        Category.f6.change(-10);
                     else if(wword.catego==2&&wword.wlevel==1)
                        Category.f7.change(-10);
                     else if(wword.catego==2&&wword.wlevel==2)
                        Category.f8.change(-10);
                     else if(wword.catego==2&&wword.wlevel==3)
                        Category.f9.change(-10);
                     else if(wword.catego==3&&wword.wlevel==1)
                        Category.f10.change(-10);
                     else if(wword.catego==3&&wword.wlevel==2)
                        Category.f11.change(-10);
                     else if(wword.catego==3&&wword.wlevel==3)
                        Category.f12.change(-10);
                     else if(wword.catego==4&&wword.wlevel==1)
                        Category.f13.change(-10);
                     else if(wword.catego==4&&wword.wlevel==2)
                        Category.f14.change(-10);
                     else if(wword.catego==4&&wword.wlevel==3)
                        Category.f15.change(-10);
                     else if(wword.catego==5&&wword.wlevel==1)
                        Category.f16.change(-10);
                     else if(wword.catego==5&&wword.wlevel==2)
                        Category.f17.change(-10);
                     else if(wword.catego==5&&wword.wlevel==3)
                        Category.f18.change(-10);
                  }
                  checkBox2.setEnabled(true);   
                  checkBox3.setEnabled(true);   
                  checkBox1.setEnabled(true);   

               }
            }
           });
   }
}