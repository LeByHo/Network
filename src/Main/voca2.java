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

public class voca2 extends JFrame {
   private JPanel contentPane;
   DTO dto = new DTO();
   int x = 70;
   int Score=0;
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               voca2 frame = new voca2(0);
               frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   public voca2(int number){
	   String[] cate={"경  제","교  통","비지니스","쇼  핑","여행,항공,호텔","인  사"};
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

      JLabel category = new JLabel(cate[number],JLabel.CENTER);
      category.setFont(f2);
      category.setForeground(Color.WHITE);
      category.setBounds(0, 0, 550, 70);
      panel.add(category);

      JLabel level = new JLabel("level :2",JLabel.CENTER);
      level.setForeground(Color.WHITE);
      level.setFont(f2);
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
      
      Wordmean mean = new Wordmean();
  	String[] m = mean.getmean(); 
      new Thread(mean).start();
      panel.add(mean);
      
      char[][] word2=word.getword();
      char[][] rest = word.getanotehr();
      
      Button2 button = new Button2(word2,word,panel,rest,m);
      new Thread(button).start();
      panel.add(button);
      
      JLabel score = new JLabel("Score",JLabel.CENTER);
      score.setFont(f2);
      score.setForeground(Color.WHITE);
      score.setBounds(50, 236, 213, 70);
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
class Sco extends JLabel{
   Sco(int x, int y, Font f2, int Score){
      setBounds(x,y,700, 70);
      setHorizontalAlignment(SwingConstants.CENTER);
      setFont(f2);
      setText(Score+"/10");
      setForeground(Color.WHITE);
   }
   public void retext(int Score){
      setText(Score+"/10");
   }
}
class Rect extends JSplitPane implements Runnable {
      int x;
      int i=1;
      int q=0;
      public Rect(int x) {
         this.x = x;
         setBounds(280, 120, 700, 70);
      }

      public void run(){
         while(q<10){
            i=0;
         while(i<11){
         setDividerLocation(x*i);
         i++;
         try {   
            Thread.sleep(1000);
         } catch (Exception ex){
         }
         }
         q++;
         }
      }
}

class Lab extends JLabel implements Runnable {
   int x;
   int i=1;
   int k=0;

   public Lab(int x) {
      Font f2 = new Font("궁서", Font.BOLD, 20);
      setFont(f2);
      setForeground(Color.WHITE);
      this.x = x;
      setHorizontalAlignment(SwingConstants.CENTER);
      setBounds(50, 115, 213, 70);
   }

   public void run(){
      while(k<10){
         i=0;
      while(i<11){
         if(i==0){
            setText(x-i+": 00");
         }
         else{
            setText("0"+(x-i)+": 00");
         }
      i++;
      try {   
         Thread.sleep(1000);
      } catch (Exception ex){
      }
      }
   k++;}
   }
}
class bt extends JButton implements Runnable {
   char a;
   String s;
   int Score=0;;
   bt(int x, int y, int w, int h, char a){
      Font f2 = new Font("궁서", Font.BOLD, 20);
      setFont(f2);
      this.a=a;
      setBounds(x, y, w, h);
      s=a+"";
      setText(s);
      setBorderPainted(false);
      setFocusable(false);
   }
   public int getScore(){
      return Score;
   }
   public void change(char[][] answer, char[] temp, int an, int i,int[] Check){
      int j=0;
      int ck=0;
      while(j<an){
         if(temp[j]==answer[i][j])
            ck++;
         else
            break;
         j++;
      }
      if(ck==4){
         setVisible(false);
         Score++;   
         Check[i]=1;
      }
      else{
    	  setBackground(null);
      }
   }
   public void set(char a){
      this.a=a;
      s=a+"";
      setText(s);
      setVisible(true); 
   }
   public void set(){
      setVisible(true);
   }

   public void run(){
      for(int i=0; i<10;i++){
         setVisible(true);
      try{
         Thread.sleep(1000);
      }catch (Exception ex){
      }
   }
   }
}
class Button2 extends JPanel implements Runnable{
	int[] Check = {0,0,0,0,0,0,0,0,0,0};
   int an=0;//어떻게 할것인가
   int bt1=0;
   int bt2=0;
   int bt3=0;
   int bt4=0;
   int bt5=0;
   int bt6=0;
   int bt7=0;
   int bt8=0;
   int Score=0;
   wword word;
   String[] mean;
   char[][] word2;
   char[][] rest;
   bt btn1;
   bt btn2;
   bt btn3;
   bt btn4;
   bt btn5;
   bt btn6;
   bt btn7;
   bt btn8;
   int[] Check1; 
   int h;
   Font f2 = new Font("궁서", Font.BOLD, 20);
   Sco score2 = new Sco(280,250,f2,Score);

   Button2(char[][] word2,wword word,JPanel panel,char[][] rest,String[] m){
      setBounds(100,617,880,300);
      setLayout(null);
      setOpaque(false);
      mean=m;
      this.word2=word2;
      this.word=word;
      this.rest=rest;
      Check1=word.check();
      btn1 =new bt(0,0,100,40,word2[0][0]);
      btn2 = new bt(110,0,100,40,rest[0][1]);
      btn3 = new bt(220,0,100,40,word2[0][2]);
      btn4 = new bt(330,0,100,40,word2[0][3]);
      btn5 = new bt(440,0,100,40,word2[0][1]);
      btn6 = new bt(550,0,100,40,rest[0][2]);
      btn7 = new bt(660,0,100,40,rest[0][0]);
      btn8 = new bt(770,0,100,40,rest[0][3]);
      panel.add(score2);      
   }
   public synchronized void init(int a, int b, int c, int d,int e, int f , int g, int i, int an){
      bt1=a;
      bt2=b;
      bt3=c;
      bt4=d;
      bt5=e;
      bt6=f;
      bt7=g;
      bt8=i;
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
                  btn1.setBackground(Color.CYAN);
                  char a=btn1.getText().charAt(0);
                  word.setanswer(h, an, a);
                  an++;
                  if(an==4){
                     btn1.change(word.getan(),word.gettemp(),an,h,Check1);
                     btn2.change(word.getan(),word.gettemp(),an,h,Check1);
                     btn3.change(word.getan(),word.gettemp(),an,h,Check1);
                     btn4.change(word.getan(),word.gettemp(),an,h,Check1);
                     btn5.change(word.getan(),word.gettemp(),an,h,Check1);
                     btn6.change(word.getan(),word.gettemp(),an,h,Check1);
                     btn7.change(word.getan(),word.gettemp(),an,h,Check1);
                     btn8.change(word.getan(),word.gettemp(),an,h,Check1);
                     an=0;
                     bt1=0;
                     bt2=0;
                     bt3=0;
                     bt4=0;
                     bt5=0;
                     bt6=0;
                     bt7=0;
                     bt8=0;
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
                  btn2.setBackground(Color.CYAN);
                  char a=btn2.getText().charAt(0);
                  word.setanswer(h, an, a);
                  an++;
                  if(an==4){
                      btn1.change(word.getan(),word.gettemp(),an,h,Check1);
                      btn2.change(word.getan(),word.gettemp(),an,h,Check1);
                      btn3.change(word.getan(),word.gettemp(),an,h,Check1);
                      btn4.change(word.getan(),word.gettemp(),an,h,Check1);
                      btn5.change(word.getan(),word.gettemp(),an,h,Check1);
                      btn6.change(word.getan(),word.gettemp(),an,h,Check1);
                      btn7.change(word.getan(),word.gettemp(),an,h,Check1);
                      btn8.change(word.getan(),word.gettemp(),an,h,Check1);
                     an=0;
                     bt1=0;
                     bt2=0;
                     bt3=0;
                     bt4=0;
                     bt5=0;
                     bt6=0;
                     bt7=0;
                     bt8=0;
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
                  btn3.setBackground(Color.CYAN);
                  char a=btn3.getText().charAt(0);
                  word.setanswer(h,an, a);
                  an++;
                  if(an==4){
                      btn1.change(word.getan(),word.gettemp(),an,h,Check1);
                      btn2.change(word.getan(),word.gettemp(),an,h,Check1);
                      btn3.change(word.getan(),word.gettemp(),an,h,Check1);
                      btn4.change(word.getan(),word.gettemp(),an,h,Check1);
                      btn5.change(word.getan(),word.gettemp(),an,h,Check1);
                      btn6.change(word.getan(),word.gettemp(),an,h,Check1);
                      btn7.change(word.getan(),word.gettemp(),an,h,Check1);
                      btn8.change(word.getan(),word.gettemp(),an,h,Check1);
                     an=0;
                     bt1=0;
                     bt2=0;
                     bt3=0;
                     bt4=0;
                     bt5=0;
                     bt6=0;
                     bt7=0;
                     bt8=0;
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
      btn4.addActionListener(new ActionListener(){ 
         public void actionPerformed(ActionEvent arg0) {
            Object obj = arg0.getSource();
            if((JButton)obj == btn4){
               bt4++;
               if(bt4%2==1){
                  btn4.setBackground(Color.CYAN);
                  char a=btn4.getText().charAt(0);
                  word.setanswer(h,an, a);
                  an++;
                  if(an==4){
                      btn1.change(word.getan(),word.gettemp(),an,h,Check1);
                      btn2.change(word.getan(),word.gettemp(),an,h,Check1);
                      btn3.change(word.getan(),word.gettemp(),an,h,Check1);
                      btn4.change(word.getan(),word.gettemp(),an,h,Check1);
                      btn5.change(word.getan(),word.gettemp(),an,h,Check1);
                      btn6.change(word.getan(),word.gettemp(),an,h,Check1);
                      btn7.change(word.getan(),word.gettemp(),an,h,Check1);
                      btn8.change(word.getan(),word.gettemp(),an,h,Check1);
                     an=0;
                     bt1=0;
                     bt2=0;
                     bt3=0;
                     bt4=0;
                     bt5=0;
                     bt6=0;
                     bt7=0;
                     bt8=0;
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
      
      btn5.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            Object obj = arg0.getSource();
            if((JButton)obj == btn5){
               bt5++;
               if(bt5%2==1){
                  btn5.setBackground(Color.CYAN);
                  char a=btn5.getText().charAt(0);
                  word.setanswer(h,an, a);
                  an++;
                  if(an==4){
                      btn1.change(word.getan(),word.gettemp(),an,h,Check1);
                      btn2.change(word.getan(),word.gettemp(),an,h,Check1);
                      btn3.change(word.getan(),word.gettemp(),an,h,Check1);
                      btn4.change(word.getan(),word.gettemp(),an,h,Check1);
                      btn5.change(word.getan(),word.gettemp(),an,h,Check1);
                      btn6.change(word.getan(),word.gettemp(),an,h,Check1);
                      btn7.change(word.getan(),word.gettemp(),an,h,Check1);
                      btn8.change(word.getan(),word.gettemp(),an,h,Check1);
                     an=0;
                     bt1=0;
                     bt2=0;
                     bt3=0;
                     bt4=0;
                     bt5=0;
                     bt6=0;
                     bt7=0;
                     bt8=0;
                     Score=btn5.getScore();
                     score2.retext(Score);
                  }
               }
               else{
                  char[][] answer= word.getan();
                  btn5.setBackground(null);
                  char a = btn5.getText().charAt(0);
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
      btn6.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            Object obj = arg0.getSource();
            if((JButton)obj == btn6){
               bt6++;
               if(bt6%2==1){
                  btn6.setBackground(Color.CYAN);
                  char a=btn6.getText().charAt(0);
                  word.setanswer(h,an, a);
                  an++;
                  if(an==4){
                      btn1.change(word.getan(),word.gettemp(),an,h,Check1);
                      btn2.change(word.getan(),word.gettemp(),an,h,Check1);
                      btn3.change(word.getan(),word.gettemp(),an,h,Check1);
                      btn4.change(word.getan(),word.gettemp(),an,h,Check1);
                      btn5.change(word.getan(),word.gettemp(),an,h,Check1);
                      btn6.change(word.getan(),word.gettemp(),an,h,Check1);
                      btn7.change(word.getan(),word.gettemp(),an,h,Check1);
                      btn8.change(word.getan(),word.gettemp(),an,h,Check1);
                     an=0;
                     bt1=0;
                     bt2=0;
                     bt3=0;
                     bt4=0;
                     bt5=0;
                     bt6=0;
                     bt7=0;
                     bt8=0;
                     Score=btn6.getScore();
                     score2.retext(Score);
                  }
               }
               else{
                  char[][] answer= word.getan();
                  btn6.setBackground(null);
                  char a = btn6.getText().charAt(0);
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
      btn7.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            Object obj = arg0.getSource();
            if((JButton)obj == btn7){
               bt7++;
               if(bt7%2==1){
                  btn7.setBackground(Color.CYAN);
                  char a=btn7.getText().charAt(0);
                  word.setanswer(h,an, a);
                  an++;
                  if(an==4){
                      btn1.change(word.getan(),word.gettemp(),an,h,Check1);
                      btn2.change(word.getan(),word.gettemp(),an,h,Check1);
                      btn3.change(word.getan(),word.gettemp(),an,h,Check1);
                      btn4.change(word.getan(),word.gettemp(),an,h,Check1);
                      btn5.change(word.getan(),word.gettemp(),an,h,Check1);
                      btn6.change(word.getan(),word.gettemp(),an,h,Check1);
                      btn7.change(word.getan(),word.gettemp(),an,h,Check1);
                      btn8.change(word.getan(),word.gettemp(),an,h,Check1);
                     an=0;
                     bt1=0;
                     bt2=0;
                     bt3=0;
                     bt4=0;
                     bt5=0;
                     bt6=0;
                     bt7=0;
                     bt8=0;
                     Score=btn7.getScore();
                     score2.retext(Score);
                  }
               }
               else{
                  char[][] answer= word.getan();
                  btn7.setBackground(null);
                  char a = btn7.getText().charAt(0);
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
      btn8.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            Object obj = arg0.getSource();
            if((JButton)obj == btn8){
               bt8++;
               if(bt8%2==1){
                  btn8.setBackground(Color.CYAN);
                  char a=btn8.getText().charAt(0);
                  word.setanswer(h,an, a);
                  an++;
                  if(an==4){
                      btn1.change(word.getan(),word.gettemp(),an,h,Check1);
                      btn2.change(word.getan(),word.gettemp(),an,h,Check1);
                      btn3.change(word.getan(),word.gettemp(),an,h,Check1);
                      btn4.change(word.getan(),word.gettemp(),an,h,Check1);
                      btn5.change(word.getan(),word.gettemp(),an,h,Check1);
                      btn6.change(word.getan(),word.gettemp(),an,h,Check1);
                      btn7.change(word.getan(),word.gettemp(),an,h,Check1);
                      btn8.change(word.getan(),word.gettemp(),an,h,Check1);
                     an=0;
                     bt1=0;
                     bt2=0;
                     bt3=0;
                     bt4=0;
                     bt5=0;
                     bt6=0;
                     bt7=0;
                     bt8=0;
                     Score=btn8.getScore();
                     score2.retext(Score);
                  }
               }
               else{
                  char[][] answer= word.getan();
                  btn8.setBackground(null);
                  char a = btn8.getText().charAt(0);
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
         this.init(0,0,0,0,0,0,0,0,0);
         btn1.setBackground(null);
         btn2.setBackground(null);
         btn3.setBackground(null);
         btn4.setBackground(null);
         btn5.setBackground(null);
         btn6.setBackground(null);
         btn7.setBackground(null);
         btn8.setBackground(null);
         word2=word.getword();        
         btn1.set(word2[h][0]);
         btn2.set(rest[h][1]);
         btn3.set(word2[h][2]);
         btn4.set(word2[h][3]);
         btn5.set(word2[h][1]);
         btn6.set(rest[h][2]);
         btn7.set(rest[h][0]);
         btn8.set(rest[h][3]);
         this.add(btn4);
         this.add(btn3);
         this.add(btn2);
         this.add(btn1);
         this.add(btn5);
         this.add(btn6);
         this.add(btn7);
         this.add(btn8);
      try {
         Thread.sleep(11000);
      } catch (Exception ex) {
      }
    }
  	new Last(word,mean);	
   }
}