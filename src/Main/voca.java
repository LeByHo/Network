package Main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.charset.Charset;
import java.util.Random;
import java.util.Timer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Client.DTO;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;

public class voca extends JFrame {
   private JPanel contentPane;
   DTO dto = new DTO();
   int x = 70;
   int Score=0;
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               voca frame = new voca();
               frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   public voca() {
      setTitle("VOCA POP");
      setSize(1100, 900);
      setResizable(false);
      setLocation(0, 0);
      Font f2 = new Font("궁서", Font.BOLD, 20);
  	ImageIcon icon = new ImageIcon("background2.png");
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
      getContentPane().add(panel);
      panel.setLayout(null);

      JLabel category = new JLabel("category",JLabel.CENTER);
      category.setBackground(Color.ORANGE);
      category.setBounds(0, 0, 550, 70);
      panel.add(category);

      JLabel level = new JLabel("level",JLabel.CENTER);
      level.setBackground(Color.RED);
      level.setBounds(550, 0, 544, 70);
      panel.add(level);

      Lab lb= new Lab(10);
      new Thread(lb).start();
      setVisible(true);
      panel.add(lb);

      wword word= new wword();
      word.setHorizontalAlignment(SwingConstants.CENTER);
      new Thread(word).start();
      panel.add(word);
      
      JLabel mean = new JLabel("New label", JLabel.CENTER);
      mean.setBounds(421, 469, 334, 70);
      panel.add(mean);
      
      char[][] word2=word.getword();
      
      Button button = new Button(word2,word,panel);
      new Thread(button).start();
      panel.add(button);
      
      JLabel score = new JLabel("score",JLabel.CENTER);
      score.setFont(f2);
      score.setBounds(116, 236, 213, 70);
      panel.add(score);

      Rect splitPane = new Rect(70);
      new Thread(splitPane).start();
      panel.add(splitPane);
      setVisible(true);
      
      JPanel n1= new JPanel();
      n1.setBackground(Color.RED);
      splitPane.setLeftComponent(n1);
      
      JPanel n2 = new JPanel();
      n2.setBackground(Color.ORANGE);
      splitPane.setRightComponent(n2);
   }
}
class Button extends JPanel implements Runnable{
   int an=0;//어떻게 할것인가
   int bt1=0;
   int bt2=0;
   int bt3=0;
   int bt4=0;
   int Score=0;
   wword word;
   char[][] word2;
   bt btn1;
   bt btn2;
   bt btn3;
   bt btn4;
   int h;
   Font f2 = new Font("궁서", Font.BOLD, 20);
   Sco score2 = new Sco(350,250,f2,Score);

   Button(char[][] word2,wword word,JPanel panel){
      setBounds(200,617,800,40);
      setLayout(null);
      setOpaque(false);
      this.word2=word2;
      this.word=word;
      btn1 =new bt(0,0,125,19,word2[0][0]);
      btn2 = new bt(130,0,125,19,word2[0][1]);
      btn3 = new bt(260,0,125,19,word2[0][2]);
      btn4 = new bt(390,0,125,19,word2[0][3]);
      panel.add(score2);
      
      
   }
   public synchronized void init(int a, int b, int c, int d, int an){
      bt1=a;
      bt2=b;
      bt3=c;
      bt4=d;
      this.an=an;
   }
   public int getscore(){
      return Score;
   }

   public void run() {   
      btn1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            Object obj = arg0.getSource();
            if((JButton)obj == btn1){
               bt1++;
               if(bt1%2==1){
                  btn1.setBackground(Color.GREEN);
                  char a=btn1.getText().charAt(0);
                  word.setanswer(h, an, a);
                  an++;
                  if(an==4){
                     btn1.change(word.getan(),word.gettemp(),an,h);
                     btn2.change(word.getan(),word.gettemp(),an,h);
                     btn3.change(word.getan(),word.gettemp(),an,h);
                     btn4.change(word.getan(),word.gettemp(),an,h);
                     an=0;
                     bt1=0;
                     bt2=0;
                     bt3=0;
                     bt4=0;
                     Score=btn1.getScore();
                     score2.retext(Score);
                  }
               }
               else{
                  char[][] answer= word.getan();
                  btn1.setBackground(null);
                  char a = btn1.getText().charAt(0);
                  int k=0;
                  for(int j=0;j<an;j++){
                     if(a==answer[h][j]){
                        k=j;
                        break;
                     }
                  }
                  for(int z=k;z<an-1;z++){
                     answer[h][z]=answer[h][z+1];
                  }
                  an--;
               }
         }}});
      
      btn2.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent arg0) {
            Object obj = arg0.getSource();
            if((JButton)obj == btn2){
               bt2++;
               if(bt2%2==1){
                  btn2.setBackground(Color.GREEN);
                  char a=btn2.getText().charAt(0);
                  word.setanswer(h,an, a);
                  an++;
                  if(an==4){
                     btn1.change(word.getan(),word.gettemp(),an,h);
                     btn2.change(word.getan(),word.gettemp(),an,h);
                     btn3.change(word.getan(),word.gettemp(),an,h);
                     btn4.change(word.getan(),word.gettemp(),an,h);
                     an=0;
                     bt1=0;
                     bt2=0;
                     bt3=0;
                     bt4=0;
                     Score=btn2.getScore();
                     score2.retext(Score);
                  }
               }
               else{
                  char[][] answer= word.getan();
                  btn2.setBackground(null);
                  char a = btn2.getText().charAt(0);
                  int k=0;
                  for(int j=0;j<an;j++){
                     if(a==answer[h][j]){
                        k=j;
                        break;
                     }
                  }
                  for(int z=k;z<an-1;z++){
                     answer[h][z]=answer[h][z+1];
                  }
                  an--;
               }
         }}});
      
      btn3.addActionListener(new ActionListener(){ 
         public void actionPerformed(ActionEvent arg0) {
            Object obj = arg0.getSource();
            if((JButton)obj == btn3){
               bt3++;
               if(bt3%2==1){
                  btn3.setBackground(Color.GREEN);
                  char a=btn3.getText().charAt(0);
                  word.setanswer(h,an, a);
                  an++;
                  if(an==4){
                     btn1.change(word.getan(),word.gettemp(),an,h);
                     btn2.change(word.getan(),word.gettemp(),an,h);
                     btn3.change(word.getan(),word.gettemp(),an,h);
                     btn4.change(word.getan(),word.gettemp(),an,h);
                     an=0;
                     bt1=0;
                     bt2=0;
                     bt3=0;
                     bt4=0;
                     Score=btn3.getScore();
                     score2.retext(Score);
                  }
               }
               else{
                  char[][] answer= word.getan();
                  btn3.setBackground(null);
                  char a = btn3.getText().charAt(0);
                  int k=0;
                  for(int j=0;j<an;j++){
                     if(a==answer[h][j]){
                        k=j;
                        break;
                     }
                  }
                  for(int z=k;z<an-1;z++){
                     answer[h][z]=answer[h][z+1];
                  }
                  an--;
               }
         }}});
      
      btn4.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            Object obj = arg0.getSource();
            if((JButton)obj == btn4){
               bt4++;
               if(bt4%2==1){
                  btn4.setBackground(Color.GREEN);
                  char a=btn4.getText().charAt(0);
                  word.setanswer(h,an, a);
                  an++;
                  if(an==4){
                     btn1.change(word.getan(),word.gettemp(),an,h);
                     btn2.change(word.getan(),word.gettemp(),an,h);
                     btn3.change(word.getan(),word.gettemp(),an,h);
                     btn4.change(word.getan(),word.gettemp(),an,h);
                     an=0;
                     bt1=0;
                     bt2=0;
                     bt3=0;
                     bt4=0;
                     Score=btn4.getScore();
                     score2.retext(Score);
                  }
               }
               else{
                  char[][] answer= word.getan();
                  btn4.setBackground(null);
                  char a = btn4.getText().charAt(0);
                  int k=0;
                  for(int j=0;j<an;j++){
                     if(a==answer[h][j]){
                        k=j;
                        break;
                     }
                  }
                  for(int z=k;z<an-1;z++){
                     answer[h][z]=answer[h][z+1];
                  }
                  an--;
               }
         }}});
      for(h=0;h<10;h++){
         this.init(0,0,0,0,0);
         btn1.setBackground(null);
         btn2.setBackground(null);
         btn3.setBackground(null);
         btn4.setBackground(null);
         word2=word.getword();         
         btn1.set(word2[h][0]);
         btn2.set(word2[h][1]);
         btn3.set(word2[h][2]);
         btn4.set(word2[h][3]);
         this.add(btn4);
         this.add(btn3);
         this.add(btn2);
         this.add(btn1);
      try {
         Thread.sleep(11000);
      } catch (Exception ex) {
      }
         
   }
   }
}