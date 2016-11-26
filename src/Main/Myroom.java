package Main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Client.DTO;

public class Myroom extends JFrame {
   private JPanel contentPane;
   DTO dto = new DTO();

   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               Myroom frame = new Myroom();
               frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   public Myroom() {
      setTitle("VOCA POP");
      setSize(1100, 900);
      setResizable(false);
      setLocation(0, 0);
  	ImageIcon icon = new ImageIcon("background5.png");
  	ImageIcon icon2 = new ImageIcon("word1.png");
    ImageIcon icon3 = new ImageIcon("word2.png");
    ImageIcon icon4 = new ImageIcon("word3.png");
    ImageIcon icon5 = new ImageIcon("word4.png");
    ImageIcon icon6 = new ImageIcon("word5.png");
    Image originImg2 = icon2.getImage();
    Image changedImg2 = originImg2.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
    ImageIcon Icon2 = new ImageIcon(changedImg2);
	Image originImg = icon.getImage();
	Image changedImg = originImg.getScaledInstance(1100, 870, Image.SCALE_SMOOTH);
	ImageIcon Icon = new ImageIcon(changedImg);
	Image originImg3 = icon3.getImage();
	Image changedImg3 = originImg3.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	ImageIcon Icon3 = new ImageIcon(changedImg3);
	Image originImg4 = icon4.getImage();
	Image changedImg4 = originImg4.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	ImageIcon Icon4 = new ImageIcon(changedImg4);
	Image originImg5 = icon5.getImage();
	Image changedImg5 = originImg5.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	ImageIcon Icon5 = new ImageIcon(changedImg5);
	Image originImg6 = icon6.getImage();
	Image changedImg6 = originImg6.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	ImageIcon Icon6 = new ImageIcon(changedImg6);
      JPanel panel = new JPanel() {
         public void paintComponent(Graphics g) {
            g.drawImage(Icon.getImage(), 0, 0, null);
            setOpaque(false);// 배경 띄워주기
            super.paintComponent(g);
         }
      };
    
      Subject v1 = new Subject(149, 200, Icon2);
      getContentPane().add(v1);
      new Thread(v1).start();
      setVisible(true);

      Subject v2 = new Subject(250, 200, Icon3);
      getContentPane().add(v2);
      new Thread(v2).start();
      setVisible(true);

      Subject v3 = new Subject(351, 200, Icon4);
      getContentPane().add(v3);
      new Thread(v3).start();
      setVisible(true);

      Subject v4 = new Subject(450, 200, Icon5);
      getContentPane().add(v4);
      new Thread(v4).start();
      setVisible(true);

      Subject v5 = new Subject(649, 200, Icon6);
      getContentPane().add(v5);
      new Thread(v5).start();
      setVisible(true);

      Subject v6 = new Subject(750, 200, Icon3);
      getContentPane().add(v6);
      new Thread(v6).start();
      setVisible(true);

      Subject v7 = new Subject(851, 200, Icon6);
      getContentPane().add(v7);
      new Thread(v7).start();
      setVisible(true);

      placeLoginPanel(panel);
      getContentPane().add(panel);
      setVisible(true);
   }

   private void placeLoginPanel(JPanel panel) {
      panel.setLayout(null);
      ImageIcon start = new ImageIcon("start.png");
      Image originImg = start.getImage();
  	Image changedImg = originImg.getScaledInstance(300, 100, Image.SCALE_SMOOTH);
  	ImageIcon Icon = new ImageIcon(changedImg);
      JButton btnInit = new JButton(Icon);
      btnInit.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            Object obj = arg0.getSource();
            if((JButton)obj == btnInit){
               new Category();
               dispose();
               }
            }
         });
      btnInit.setBounds(750, 705, 300, 100);
      btnInit.setBorderPainted(false);
      panel.add(btnInit);
   }
}

class Subject extends JPanel implements Runnable {
   int x;
   int y;
   ImageIcon icon;

   public Subject(int x, int y, ImageIcon a) {
      setOpaque(false);
      this.x = x;
      this.y = y;
      icon = a;
   }

   public void run() {
      if (x % 2 == 1) {
         while (true) {
            for (int i = 0; i < 100; i++) {
               if (i < 50)
                  y--;
               else
                  y++;
               repaint();

               try {
                  Thread.sleep(30);
               } catch (Exception ex) {
               }
            }

         }
      }
      else{
         while (true) {
            for (int i = 0; i < 100; i++) {
               if (i < 50)
                  y++;
               else
                  y--;
               repaint();

               try {
                  Thread.sleep(30);
               } catch (Exception ex) {
               }
            }

         }

      }
      }

   public void paintComponent(Graphics g) {
      g.drawImage(icon.getImage(), x, y, null);
      // g.fillRect(0,0,this.getWidth(),this.getHeight());//see next line
      super.paintComponent(g);
      // g.setColor(Color.orange);
      // g.fillOval(x,y,100,50);
   }
}