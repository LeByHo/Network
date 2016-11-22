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

public class voca3 extends JFrame {
	private JPanel contentPane;
	DTO dto = new DTO();
	int x = 70;
	int Score=0;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					voca3 frame = new voca3();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public voca3() {
		setTitle("VOCA POP");
		setSize(1100, 900);
		setResizable(false);
		setLocation(0, 0);
		Font f2 = new Font("±Ã¼­", Font.BOLD, 20);
		ImageIcon icon = new ImageIcon("background2.png");
		Image originImg = icon.getImage();
		Image changedImg = originImg.getScaledInstance(1100, 870, Image.SCALE_SMOOTH);
		ImageIcon Icon = new ImageIcon(changedImg);
		JPanel panel = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(Icon.getImage(), 0, 0, null);
				setOpaque(false);// ¹è°æ ¶ç¿öÁÖ±â
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
		
		
		Button3 button = new Button3(word2,word,panel);
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
class Button3 extends JPanel implements Runnable{
	int an=0;
	int[] bt = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	int Score=0;
	wword word;
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
	bt btn9;
	bt btn10;
	bt btn11;
	bt btn12;
	bt btn13;
	bt btn14;
	bt btn15;
	bt btn16;
	bt btn17;
	bt btn18;
	bt btn19;
	bt btn20;
	bt btn21;
	bt btn22;
	bt btn23;
	bt btn24;
	bt btn25;
	bt btn26;
	
	int h;
	Font f2 = new Font("±Ã¼­", Font.BOLD, 20);
	Sco score2 = new Sco(350,250,f2,Score);

	Button3(char[][] word2,wword word,JPanel panel){
		setBounds(200,617,800,40);
		setLayout(null);
		setOpaque(false);
		this.word2=word2;
		this.word=word;
		btn1 =new bt(0,0,50,19,'a');
		btn2 = new bt(60,0,50,19,'b');
		btn3 = new bt(110,0,50,19,'c');
		btn4 = new bt(160,0,50,19,'d');
		btn5 = new bt(210,0,50,19,'e');
		btn6 = new bt(260,0,50,19,'f');
		btn7 = new bt(310,0,50,19,'g');
		btn8 = new bt(360,0,50,19,'h');
		btn9 = new bt(410,0,50,19,'i');
		btn10 = new bt(460,0,50,19,'j');
		btn11 = new bt(510,0,50,19,'k');
		btn12 = new bt(560,0,50,19,'l');
		btn13 = new bt(610,0,50,19,'m');
		btn14 = new bt(0,20,50,19,'n');
		btn15 = new bt(60,20,50,19,'o');
		btn16 = new bt(110,20,50,19,'p');
		btn17 = new bt(160,20,50,19,'q');
		btn18 = new bt(210,20,50,19,'r');
		btn19 = new bt(260,20,50,19,'s');
		btn20 = new bt(310,20,50,19,'t');
		btn21 = new bt(360,20,50,19,'u');
		btn22 = new bt(410,20,50,19,'v');
		btn23 = new bt(460,20,50,19,'w');
		btn24 = new bt(510,20,50,19,'x');
		btn25 = new bt(560,20,50,19,'y');
		btn26 = new bt(610,20,50,19,'z');
		
		
		panel.add(score2);		
	}
	public synchronized void init(int a, int an){
		for(int q=0;q<a;q++){
			bt[q]=0;
		}
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
					bt[0]++;
					System.out.println(bt[0]);
					if(bt[0]%2==1){
						btn1.setBackground(Color.GREEN);
						char a=btn1.getText().charAt(0);
						word.setanswer(h, an, a);
						an++;
						if(an==4){
							btn1.change(word.getan(),word.gettemp(),an,h);
							btn2.change(word.getan(),word.gettemp(),an,h);
							btn3.change(word.getan(),word.gettemp(),an,h);
							btn4.change(word.getan(),word.gettemp(),an,h);
							btn5.change(word.getan(),word.gettemp(),an,h);
							btn6.change(word.getan(),word.gettemp(),an,h);
							btn7.change(word.getan(),word.gettemp(),an,h);
							btn8.change(word.getan(),word.gettemp(),an,h);
							btn9.change(word.getan(),word.gettemp(),an,h);
							btn10.change(word.getan(),word.gettemp(),an,h);
							btn11.change(word.getan(),word.gettemp(),an,h);
							btn12.change(word.getan(),word.gettemp(),an,h);
							btn13.change(word.getan(),word.gettemp(),an,h);
							btn14.change(word.getan(),word.gettemp(),an,h);
							btn15.change(word.getan(),word.gettemp(),an,h);
							btn16.change(word.getan(),word.gettemp(),an,h);
							btn17.change(word.getan(),word.gettemp(),an,h);
							btn18.change(word.getan(),word.gettemp(),an,h);
							btn19.change(word.getan(),word.gettemp(),an,h);
							btn20.change(word.getan(),word.gettemp(),an,h);
							btn21.change(word.getan(),word.gettemp(),an,h);
							btn22.change(word.getan(),word.gettemp(),an,h);
							btn23.change(word.getan(),word.gettemp(),an,h);
							btn24.change(word.getan(),word.gettemp(),an,h);
							btn25.change(word.getan(),word.gettemp(),an,h);
							btn26.change(word.getan(),word.gettemp(),an,h);
							an=0;
							for(int i=0; i<26;i++){
								bt[i]=0;
							}
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
					bt[1]++;
					System.out.println(bt[1]);
					if(bt[1]%2==1){
						btn2.setBackground(Color.GREEN);
						char a=btn2.getText().charAt(0);
						word.setanswer(h, an, a);
						an++;
						if(an==4){
							btn1.change(word.getan(),word.gettemp(),an,h);
							btn2.change(word.getan(),word.gettemp(),an,h);
							btn3.change(word.getan(),word.gettemp(),an,h);
							btn4.change(word.getan(),word.gettemp(),an,h);
							btn5.change(word.getan(),word.gettemp(),an,h);
							btn6.change(word.getan(),word.gettemp(),an,h);
							btn7.change(word.getan(),word.gettemp(),an,h);
							btn8.change(word.getan(),word.gettemp(),an,h);
							btn9.change(word.getan(),word.gettemp(),an,h);
							btn10.change(word.getan(),word.gettemp(),an,h);
							btn11.change(word.getan(),word.gettemp(),an,h);
							btn12.change(word.getan(),word.gettemp(),an,h);
							btn13.change(word.getan(),word.gettemp(),an,h);
							btn14.change(word.getan(),word.gettemp(),an,h);
							btn15.change(word.getan(),word.gettemp(),an,h);
							btn16.change(word.getan(),word.gettemp(),an,h);
							btn17.change(word.getan(),word.gettemp(),an,h);
							btn18.change(word.getan(),word.gettemp(),an,h);
							btn19.change(word.getan(),word.gettemp(),an,h);
							btn20.change(word.getan(),word.gettemp(),an,h);
							btn21.change(word.getan(),word.gettemp(),an,h);
							btn22.change(word.getan(),word.gettemp(),an,h);
							btn23.change(word.getan(),word.gettemp(),an,h);
							btn24.change(word.getan(),word.gettemp(),an,h);
							btn25.change(word.getan(),word.gettemp(),an,h);
							btn26.change(word.getan(),word.gettemp(),an,h);
							an=0;
							for(int i=0; i<26;i++){
								bt[i]=0;
							}
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
					bt[2]++;
					if(bt[2]%2==1){
						btn3.setBackground(Color.GREEN);
						char a=btn3.getText().charAt(0);
						word.setanswer(h,an, a);
						an++;
						if(an==4){
							btn1.change(word.getan(),word.gettemp(),an,h);
							btn2.change(word.getan(),word.gettemp(),an,h);
							btn3.change(word.getan(),word.gettemp(),an,h);
							btn4.change(word.getan(),word.gettemp(),an,h);
							btn5.change(word.getan(),word.gettemp(),an,h);
							btn6.change(word.getan(),word.gettemp(),an,h);
							btn7.change(word.getan(),word.gettemp(),an,h);
							btn8.change(word.getan(),word.gettemp(),an,h);
							btn9.change(word.getan(),word.gettemp(),an,h);
							btn10.change(word.getan(),word.gettemp(),an,h);
							btn11.change(word.getan(),word.gettemp(),an,h);
							btn12.change(word.getan(),word.gettemp(),an,h);
							btn13.change(word.getan(),word.gettemp(),an,h);
							btn14.change(word.getan(),word.gettemp(),an,h);
							btn15.change(word.getan(),word.gettemp(),an,h);
							btn16.change(word.getan(),word.gettemp(),an,h);
							btn17.change(word.getan(),word.gettemp(),an,h);
							btn18.change(word.getan(),word.gettemp(),an,h);
							btn19.change(word.getan(),word.gettemp(),an,h);
							btn20.change(word.getan(),word.gettemp(),an,h);
							btn21.change(word.getan(),word.gettemp(),an,h);
							btn22.change(word.getan(),word.gettemp(),an,h);
							btn23.change(word.getan(),word.gettemp(),an,h);
							btn24.change(word.getan(),word.gettemp(),an,h);
							btn25.change(word.getan(),word.gettemp(),an,h);
							btn26.change(word.getan(),word.gettemp(),an,h);
							an=0;
							for(int i=0; i<26;i++){
								bt[i]=0;
							}
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
					bt[3]++;
					if(bt[3]%2==1){
						btn4.setBackground(Color.GREEN);
						char a=btn4.getText().charAt(0);
						word.setanswer(h,an, a);
						an++;
						if(an==4){
							btn1.change(word.getan(),word.gettemp(),an,h);
							btn2.change(word.getan(),word.gettemp(),an,h);
							btn3.change(word.getan(),word.gettemp(),an,h);
							btn4.change(word.getan(),word.gettemp(),an,h);
							btn5.change(word.getan(),word.gettemp(),an,h);
							btn6.change(word.getan(),word.gettemp(),an,h);
							btn7.change(word.getan(),word.gettemp(),an,h);
							btn8.change(word.getan(),word.gettemp(),an,h);
							btn9.change(word.getan(),word.gettemp(),an,h);
							btn10.change(word.getan(),word.gettemp(),an,h);
							btn11.change(word.getan(),word.gettemp(),an,h);
							btn12.change(word.getan(),word.gettemp(),an,h);
							btn13.change(word.getan(),word.gettemp(),an,h);
							btn14.change(word.getan(),word.gettemp(),an,h);
							btn15.change(word.getan(),word.gettemp(),an,h);
							btn16.change(word.getan(),word.gettemp(),an,h);
							btn17.change(word.getan(),word.gettemp(),an,h);
							btn18.change(word.getan(),word.gettemp(),an,h);
							btn19.change(word.getan(),word.gettemp(),an,h);
							btn20.change(word.getan(),word.gettemp(),an,h);
							btn21.change(word.getan(),word.gettemp(),an,h);
							btn22.change(word.getan(),word.gettemp(),an,h);
							btn23.change(word.getan(),word.gettemp(),an,h);
							btn24.change(word.getan(),word.gettemp(),an,h);
							btn25.change(word.getan(),word.gettemp(),an,h);
							btn26.change(word.getan(),word.gettemp(),an,h);
							an=0;
							for(int i=0; i<26;i++){
								bt[i]=0;
							}
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
					bt[4]++;
					if(bt[4]%2==1){
						btn5.setBackground(Color.GREEN);
						char a=btn5.getText().charAt(0);
						word.setanswer(h,an, a);
						an++;
						if(an==4){
							btn1.change(word.getan(),word.gettemp(),an,h);
							btn2.change(word.getan(),word.gettemp(),an,h);
							btn3.change(word.getan(),word.gettemp(),an,h);
							btn4.change(word.getan(),word.gettemp(),an,h);
							btn5.change(word.getan(),word.gettemp(),an,h);
							btn6.change(word.getan(),word.gettemp(),an,h);
							btn7.change(word.getan(),word.gettemp(),an,h);
							btn8.change(word.getan(),word.gettemp(),an,h);
							btn9.change(word.getan(),word.gettemp(),an,h);
							btn10.change(word.getan(),word.gettemp(),an,h);
							btn11.change(word.getan(),word.gettemp(),an,h);
							btn12.change(word.getan(),word.gettemp(),an,h);
							btn13.change(word.getan(),word.gettemp(),an,h);
							btn14.change(word.getan(),word.gettemp(),an,h);
							btn15.change(word.getan(),word.gettemp(),an,h);
							btn16.change(word.getan(),word.gettemp(),an,h);
							btn17.change(word.getan(),word.gettemp(),an,h);
							btn18.change(word.getan(),word.gettemp(),an,h);
							btn19.change(word.getan(),word.gettemp(),an,h);
							btn20.change(word.getan(),word.gettemp(),an,h);
							btn21.change(word.getan(),word.gettemp(),an,h);
							btn22.change(word.getan(),word.gettemp(),an,h);
							btn23.change(word.getan(),word.gettemp(),an,h);
							btn24.change(word.getan(),word.gettemp(),an,h);
							btn25.change(word.getan(),word.gettemp(),an,h);
							btn26.change(word.getan(),word.gettemp(),an,h);
							an=0;
							for(int i=0; i<26;i++){
								bt[i]=0;
							}
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
					bt[5]++;
					if(bt[5]%2==1){
						btn6.setBackground(Color.GREEN);
						char a=btn6.getText().charAt(0);
						word.setanswer(h,an, a);
						an++;
						if(an==4){
							btn1.change(word.getan(),word.gettemp(),an,h);
							btn2.change(word.getan(),word.gettemp(),an,h);
							btn3.change(word.getan(),word.gettemp(),an,h);
							btn4.change(word.getan(),word.gettemp(),an,h);
							btn5.change(word.getan(),word.gettemp(),an,h);
							btn6.change(word.getan(),word.gettemp(),an,h);
							btn7.change(word.getan(),word.gettemp(),an,h);
							btn8.change(word.getan(),word.gettemp(),an,h);
							btn9.change(word.getan(),word.gettemp(),an,h);
							btn10.change(word.getan(),word.gettemp(),an,h);
							btn11.change(word.getan(),word.gettemp(),an,h);
							btn12.change(word.getan(),word.gettemp(),an,h);
							btn13.change(word.getan(),word.gettemp(),an,h);
							btn14.change(word.getan(),word.gettemp(),an,h);
							btn15.change(word.getan(),word.gettemp(),an,h);
							btn16.change(word.getan(),word.gettemp(),an,h);
							btn17.change(word.getan(),word.gettemp(),an,h);
							btn18.change(word.getan(),word.gettemp(),an,h);
							btn19.change(word.getan(),word.gettemp(),an,h);
							btn20.change(word.getan(),word.gettemp(),an,h);
							btn21.change(word.getan(),word.gettemp(),an,h);
							btn22.change(word.getan(),word.gettemp(),an,h);
							btn23.change(word.getan(),word.gettemp(),an,h);
							btn24.change(word.getan(),word.gettemp(),an,h);
							btn25.change(word.getan(),word.gettemp(),an,h);
							btn26.change(word.getan(),word.gettemp(),an,h);
							an=0;
							for(int i=0; i<26;i++){
								bt[i]=0;
							}
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
					bt[6]++;
					if(bt[6]%2==1){
						btn7.setBackground(Color.GREEN);
						char a=btn7.getText().charAt(0);
						word.setanswer(h,an, a);
						an++;
						if(an==4){
							btn1.change(word.getan(),word.gettemp(),an,h);
							btn2.change(word.getan(),word.gettemp(),an,h);
							btn3.change(word.getan(),word.gettemp(),an,h);
							btn4.change(word.getan(),word.gettemp(),an,h);
							btn5.change(word.getan(),word.gettemp(),an,h);
							btn6.change(word.getan(),word.gettemp(),an,h);
							btn7.change(word.getan(),word.gettemp(),an,h);
							btn8.change(word.getan(),word.gettemp(),an,h);
							btn9.change(word.getan(),word.gettemp(),an,h);
							btn10.change(word.getan(),word.gettemp(),an,h);
							btn11.change(word.getan(),word.gettemp(),an,h);
							btn12.change(word.getan(),word.gettemp(),an,h);
							btn13.change(word.getan(),word.gettemp(),an,h);
							btn14.change(word.getan(),word.gettemp(),an,h);
							btn15.change(word.getan(),word.gettemp(),an,h);
							btn16.change(word.getan(),word.gettemp(),an,h);
							btn17.change(word.getan(),word.gettemp(),an,h);
							btn18.change(word.getan(),word.gettemp(),an,h);
							btn19.change(word.getan(),word.gettemp(),an,h);
							btn20.change(word.getan(),word.gettemp(),an,h);
							btn21.change(word.getan(),word.gettemp(),an,h);
							btn22.change(word.getan(),word.gettemp(),an,h);
							btn23.change(word.getan(),word.gettemp(),an,h);
							btn24.change(word.getan(),word.gettemp(),an,h);
							btn25.change(word.getan(),word.gettemp(),an,h);
							btn26.change(word.getan(),word.gettemp(),an,h);
							an=0;
							for(int i=0; i<26;i++){
								bt[i]=0;
							}
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
					bt[7]++;
					if(bt[7]%2==1){
						btn8.setBackground(Color.GREEN);
						char a=btn8.getText().charAt(0);
						word.setanswer(h,an, a);
						an++;
						if(an==4){
							btn1.change(word.getan(),word.gettemp(),an,h);
							btn2.change(word.getan(),word.gettemp(),an,h);
							btn3.change(word.getan(),word.gettemp(),an,h);
							btn4.change(word.getan(),word.gettemp(),an,h);
							btn5.change(word.getan(),word.gettemp(),an,h);
							btn6.change(word.getan(),word.gettemp(),an,h);
							btn7.change(word.getan(),word.gettemp(),an,h);
							btn8.change(word.getan(),word.gettemp(),an,h);
							btn9.change(word.getan(),word.gettemp(),an,h);
							btn10.change(word.getan(),word.gettemp(),an,h);
							btn11.change(word.getan(),word.gettemp(),an,h);
							btn12.change(word.getan(),word.gettemp(),an,h);
							btn13.change(word.getan(),word.gettemp(),an,h);
							btn14.change(word.getan(),word.gettemp(),an,h);
							btn15.change(word.getan(),word.gettemp(),an,h);
							btn16.change(word.getan(),word.gettemp(),an,h);
							btn17.change(word.getan(),word.gettemp(),an,h);
							btn18.change(word.getan(),word.gettemp(),an,h);
							btn19.change(word.getan(),word.gettemp(),an,h);
							btn20.change(word.getan(),word.gettemp(),an,h);
							btn21.change(word.getan(),word.gettemp(),an,h);
							btn22.change(word.getan(),word.gettemp(),an,h);
							btn23.change(word.getan(),word.gettemp(),an,h);
							btn24.change(word.getan(),word.gettemp(),an,h);
							btn25.change(word.getan(),word.gettemp(),an,h);
							btn26.change(word.getan(),word.gettemp(),an,h);
							an=0;
							for(int i=0; i<26;i++){
								bt[i]=0;
							}
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
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object obj = arg0.getSource();
				if((JButton)obj == btn9){
					bt[8]++;
					if(bt[8]%2==1){
						btn9.setBackground(Color.GREEN);
						char a=btn9.getText().charAt(0);
						word.setanswer(h,an, a);
						an++;
						if(an==4){
							btn1.change(word.getan(),word.gettemp(),an,h);
							btn2.change(word.getan(),word.gettemp(),an,h);
							btn3.change(word.getan(),word.gettemp(),an,h);
							btn4.change(word.getan(),word.gettemp(),an,h);
							btn5.change(word.getan(),word.gettemp(),an,h);
							btn6.change(word.getan(),word.gettemp(),an,h);
							btn7.change(word.getan(),word.gettemp(),an,h);
							btn8.change(word.getan(),word.gettemp(),an,h);
							btn9.change(word.getan(),word.gettemp(),an,h);
							btn10.change(word.getan(),word.gettemp(),an,h);
							btn11.change(word.getan(),word.gettemp(),an,h);
							btn12.change(word.getan(),word.gettemp(),an,h);
							btn13.change(word.getan(),word.gettemp(),an,h);
							btn14.change(word.getan(),word.gettemp(),an,h);
							btn15.change(word.getan(),word.gettemp(),an,h);
							btn16.change(word.getan(),word.gettemp(),an,h);
							btn17.change(word.getan(),word.gettemp(),an,h);
							btn18.change(word.getan(),word.gettemp(),an,h);
							btn19.change(word.getan(),word.gettemp(),an,h);
							btn20.change(word.getan(),word.gettemp(),an,h);
							btn21.change(word.getan(),word.gettemp(),an,h);
							btn22.change(word.getan(),word.gettemp(),an,h);
							btn23.change(word.getan(),word.gettemp(),an,h);
							btn24.change(word.getan(),word.gettemp(),an,h);
							btn25.change(word.getan(),word.gettemp(),an,h);
							btn26.change(word.getan(),word.gettemp(),an,h);
							an=0;
							for(int i=0; i<26;i++){
								bt[i]=0;
							}
							Score=btn9.getScore();
							score2.retext(Score);
						}
					}
					else{
						char[][] answer= word.getan();
						btn9.setBackground(null);
						char a = btn9.getText().charAt(0);
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
		btn10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object obj = arg0.getSource();
				if((JButton)obj == btn10){
					bt[9]++;
					if(bt[9]%2==1){
						btn10.setBackground(Color.GREEN);
						char a=btn10.getText().charAt(0);
						word.setanswer(h,an, a);
						an++;
						if(an==4){
							btn1.change(word.getan(),word.gettemp(),an,h);
							btn2.change(word.getan(),word.gettemp(),an,h);
							btn3.change(word.getan(),word.gettemp(),an,h);
							btn4.change(word.getan(),word.gettemp(),an,h);
							btn5.change(word.getan(),word.gettemp(),an,h);
							btn6.change(word.getan(),word.gettemp(),an,h);
							btn7.change(word.getan(),word.gettemp(),an,h);
							btn8.change(word.getan(),word.gettemp(),an,h);
							btn9.change(word.getan(),word.gettemp(),an,h);
							btn10.change(word.getan(),word.gettemp(),an,h);
							btn11.change(word.getan(),word.gettemp(),an,h);
							btn12.change(word.getan(),word.gettemp(),an,h);
							btn13.change(word.getan(),word.gettemp(),an,h);
							btn14.change(word.getan(),word.gettemp(),an,h);
							btn15.change(word.getan(),word.gettemp(),an,h);
							btn16.change(word.getan(),word.gettemp(),an,h);
							btn17.change(word.getan(),word.gettemp(),an,h);
							btn18.change(word.getan(),word.gettemp(),an,h);
							btn19.change(word.getan(),word.gettemp(),an,h);
							btn20.change(word.getan(),word.gettemp(),an,h);
							btn21.change(word.getan(),word.gettemp(),an,h);
							btn22.change(word.getan(),word.gettemp(),an,h);
							btn23.change(word.getan(),word.gettemp(),an,h);
							btn24.change(word.getan(),word.gettemp(),an,h);
							btn25.change(word.getan(),word.gettemp(),an,h);
							btn26.change(word.getan(),word.gettemp(),an,h);
							an=0;
							for(int i=0; i<26;i++){
								bt[i]=0;
							}
							Score=btn10.getScore();
							score2.retext(Score);
						}
					}
					else{
						char[][] answer= word.getan();
						btn10.setBackground(null);
						char a = btn10.getText().charAt(0);
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
		btn11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object obj = arg0.getSource();
				if((JButton)obj == btn11){
					bt[10]++;
					if(bt[10]%2==1){
						btn11.setBackground(Color.GREEN);
						char a=btn11.getText().charAt(0);
						word.setanswer(h,an, a);
						an++;
						if(an==4){
							btn1.change(word.getan(),word.gettemp(),an,h);
							btn2.change(word.getan(),word.gettemp(),an,h);
							btn3.change(word.getan(),word.gettemp(),an,h);
							btn4.change(word.getan(),word.gettemp(),an,h);
							btn5.change(word.getan(),word.gettemp(),an,h);
							btn6.change(word.getan(),word.gettemp(),an,h);
							btn7.change(word.getan(),word.gettemp(),an,h);
							btn8.change(word.getan(),word.gettemp(),an,h);
							btn9.change(word.getan(),word.gettemp(),an,h);
							btn10.change(word.getan(),word.gettemp(),an,h);
							btn11.change(word.getan(),word.gettemp(),an,h);
							btn12.change(word.getan(),word.gettemp(),an,h);
							btn13.change(word.getan(),word.gettemp(),an,h);
							btn14.change(word.getan(),word.gettemp(),an,h);
							btn15.change(word.getan(),word.gettemp(),an,h);
							btn16.change(word.getan(),word.gettemp(),an,h);
							btn17.change(word.getan(),word.gettemp(),an,h);
							btn18.change(word.getan(),word.gettemp(),an,h);
							btn19.change(word.getan(),word.gettemp(),an,h);
							btn20.change(word.getan(),word.gettemp(),an,h);
							btn21.change(word.getan(),word.gettemp(),an,h);
							btn22.change(word.getan(),word.gettemp(),an,h);
							btn23.change(word.getan(),word.gettemp(),an,h);
							btn24.change(word.getan(),word.gettemp(),an,h);
							btn25.change(word.getan(),word.gettemp(),an,h);
							btn26.change(word.getan(),word.gettemp(),an,h);
							an=0;
							for(int i=0; i<26;i++){
								bt[i]=0;
							}
							Score=btn11.getScore();
							score2.retext(Score);
						}
					}
					else{
						char[][] answer= word.getan();
						btn11.setBackground(null);
						char a = btn11.getText().charAt(0);
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
		btn12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object obj = arg0.getSource();
				if((JButton)obj == btn12){
					bt[11]++;
					if(bt[11]%2==1){
						btn12.setBackground(Color.GREEN);
						char a=btn12.getText().charAt(0);
						word.setanswer(h,an, a);
						an++;
						if(an==4){
							btn1.change(word.getan(),word.gettemp(),an,h);
							btn2.change(word.getan(),word.gettemp(),an,h);
							btn3.change(word.getan(),word.gettemp(),an,h);
							btn4.change(word.getan(),word.gettemp(),an,h);
							btn5.change(word.getan(),word.gettemp(),an,h);
							btn6.change(word.getan(),word.gettemp(),an,h);
							btn7.change(word.getan(),word.gettemp(),an,h);
							btn8.change(word.getan(),word.gettemp(),an,h);
							btn9.change(word.getan(),word.gettemp(),an,h);
							btn10.change(word.getan(),word.gettemp(),an,h);
							btn11.change(word.getan(),word.gettemp(),an,h);
							btn12.change(word.getan(),word.gettemp(),an,h);
							btn13.change(word.getan(),word.gettemp(),an,h);
							btn14.change(word.getan(),word.gettemp(),an,h);
							btn15.change(word.getan(),word.gettemp(),an,h);
							btn16.change(word.getan(),word.gettemp(),an,h);
							btn17.change(word.getan(),word.gettemp(),an,h);
							btn18.change(word.getan(),word.gettemp(),an,h);
							btn19.change(word.getan(),word.gettemp(),an,h);
							btn20.change(word.getan(),word.gettemp(),an,h);
							btn21.change(word.getan(),word.gettemp(),an,h);
							btn22.change(word.getan(),word.gettemp(),an,h);
							btn23.change(word.getan(),word.gettemp(),an,h);
							btn24.change(word.getan(),word.gettemp(),an,h);
							btn25.change(word.getan(),word.gettemp(),an,h);
							btn26.change(word.getan(),word.gettemp(),an,h);
							an=0;
							for(int i=0; i<26;i++){
								bt[i]=0;
							}
							Score=btn10.getScore();
							score2.retext(Score);
						}
					}
					else{
						char[][] answer= word.getan();
						btn12.setBackground(null);
						char a = btn12.getText().charAt(0);
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
		btn13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object obj = arg0.getSource();
				if((JButton)obj == btn13){
					bt[12]++;
					if(bt[12]%2==1){
						btn13.setBackground(Color.GREEN);
						char a=btn13.getText().charAt(0);
						word.setanswer(h,an, a);
						an++;
						if(an==4){
							btn1.change(word.getan(),word.gettemp(),an,h);
							btn2.change(word.getan(),word.gettemp(),an,h);
							btn3.change(word.getan(),word.gettemp(),an,h);
							btn4.change(word.getan(),word.gettemp(),an,h);
							btn5.change(word.getan(),word.gettemp(),an,h);
							btn6.change(word.getan(),word.gettemp(),an,h);
							btn7.change(word.getan(),word.gettemp(),an,h);
							btn8.change(word.getan(),word.gettemp(),an,h);
							btn9.change(word.getan(),word.gettemp(),an,h);
							btn10.change(word.getan(),word.gettemp(),an,h);
							btn11.change(word.getan(),word.gettemp(),an,h);
							btn12.change(word.getan(),word.gettemp(),an,h);
							btn13.change(word.getan(),word.gettemp(),an,h);
							btn14.change(word.getan(),word.gettemp(),an,h);
							btn15.change(word.getan(),word.gettemp(),an,h);
							btn16.change(word.getan(),word.gettemp(),an,h);
							btn17.change(word.getan(),word.gettemp(),an,h);
							btn18.change(word.getan(),word.gettemp(),an,h);
							btn19.change(word.getan(),word.gettemp(),an,h);
							btn20.change(word.getan(),word.gettemp(),an,h);
							btn21.change(word.getan(),word.gettemp(),an,h);
							btn22.change(word.getan(),word.gettemp(),an,h);
							btn23.change(word.getan(),word.gettemp(),an,h);
							btn24.change(word.getan(),word.gettemp(),an,h);
							btn25.change(word.getan(),word.gettemp(),an,h);
							btn26.change(word.getan(),word.gettemp(),an,h);
							an=0;
							for(int i=0; i<26;i++){
								bt[i]=0;
							}
							Score=btn13.getScore();
							score2.retext(Score);
						}
					}
					else{
						char[][] answer= word.getan();
						btn13.setBackground(null);
						char a = btn13.getText().charAt(0);
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
		btn14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object obj = arg0.getSource();
				if((JButton)obj == btn14){
					bt[13]++;
					if(bt[13]%2==1){
						btn14.setBackground(Color.GREEN);
						char a=btn14.getText().charAt(0);
						word.setanswer(h,an, a);
						an++;
						if(an==4){
							btn1.change(word.getan(),word.gettemp(),an,h);
							btn2.change(word.getan(),word.gettemp(),an,h);
							btn3.change(word.getan(),word.gettemp(),an,h);
							btn4.change(word.getan(),word.gettemp(),an,h);
							btn5.change(word.getan(),word.gettemp(),an,h);
							btn6.change(word.getan(),word.gettemp(),an,h);
							btn7.change(word.getan(),word.gettemp(),an,h);
							btn8.change(word.getan(),word.gettemp(),an,h);
							btn9.change(word.getan(),word.gettemp(),an,h);
							btn10.change(word.getan(),word.gettemp(),an,h);
							btn11.change(word.getan(),word.gettemp(),an,h);
							btn12.change(word.getan(),word.gettemp(),an,h);
							btn13.change(word.getan(),word.gettemp(),an,h);
							btn14.change(word.getan(),word.gettemp(),an,h);
							btn15.change(word.getan(),word.gettemp(),an,h);
							btn16.change(word.getan(),word.gettemp(),an,h);
							btn17.change(word.getan(),word.gettemp(),an,h);
							btn18.change(word.getan(),word.gettemp(),an,h);
							btn19.change(word.getan(),word.gettemp(),an,h);
							btn20.change(word.getan(),word.gettemp(),an,h);
							btn21.change(word.getan(),word.gettemp(),an,h);
							btn22.change(word.getan(),word.gettemp(),an,h);
							btn23.change(word.getan(),word.gettemp(),an,h);
							btn24.change(word.getan(),word.gettemp(),an,h);
							btn25.change(word.getan(),word.gettemp(),an,h);
							btn26.change(word.getan(),word.gettemp(),an,h);
							an=0;
							for(int i=0; i<26;i++){
								bt[i]=0;
							}
							Score=btn14.getScore();
							score2.retext(Score);
						}
					}
					else{
						char[][] answer= word.getan();
						btn14.setBackground(null);
						char a = btn14.getText().charAt(0);
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
		btn15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object obj = arg0.getSource();
				if((JButton)obj == btn15){
					bt[14]++;
					if(bt[14]%2==1){
						btn15.setBackground(Color.GREEN);
						char a=btn15.getText().charAt(0);
						word.setanswer(h,an, a);
						an++;
						if(an==4){
							btn1.change(word.getan(),word.gettemp(),an,h);
							btn2.change(word.getan(),word.gettemp(),an,h);
							btn3.change(word.getan(),word.gettemp(),an,h);
							btn4.change(word.getan(),word.gettemp(),an,h);
							btn5.change(word.getan(),word.gettemp(),an,h);
							btn6.change(word.getan(),word.gettemp(),an,h);
							btn7.change(word.getan(),word.gettemp(),an,h);
							btn8.change(word.getan(),word.gettemp(),an,h);
							btn9.change(word.getan(),word.gettemp(),an,h);
							btn10.change(word.getan(),word.gettemp(),an,h);
							btn11.change(word.getan(),word.gettemp(),an,h);
							btn12.change(word.getan(),word.gettemp(),an,h);
							btn13.change(word.getan(),word.gettemp(),an,h);
							btn14.change(word.getan(),word.gettemp(),an,h);
							btn15.change(word.getan(),word.gettemp(),an,h);
							btn16.change(word.getan(),word.gettemp(),an,h);
							btn17.change(word.getan(),word.gettemp(),an,h);
							btn18.change(word.getan(),word.gettemp(),an,h);
							btn19.change(word.getan(),word.gettemp(),an,h);
							btn20.change(word.getan(),word.gettemp(),an,h);
							btn21.change(word.getan(),word.gettemp(),an,h);
							btn22.change(word.getan(),word.gettemp(),an,h);
							btn23.change(word.getan(),word.gettemp(),an,h);
							btn24.change(word.getan(),word.gettemp(),an,h);
							btn25.change(word.getan(),word.gettemp(),an,h);
							btn26.change(word.getan(),word.gettemp(),an,h);
							an=0;
							for(int i=0; i<26;i++){
								bt[i]=0;
							}
							Score=btn15.getScore();
							score2.retext(Score);
						}
					}
					else{
						char[][] answer= word.getan();
						btn15.setBackground(null);
						char a = btn15.getText().charAt(0);
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
		btn16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object obj = arg0.getSource();
				if((JButton)obj == btn16){
					bt[15]++;
					if(bt[15]%2==1){
						btn16.setBackground(Color.GREEN);
						char a=btn16.getText().charAt(0);
						word.setanswer(h,an, a);
						an++;
						if(an==4){
							btn1.change(word.getan(),word.gettemp(),an,h);
							btn2.change(word.getan(),word.gettemp(),an,h);
							btn3.change(word.getan(),word.gettemp(),an,h);
							btn4.change(word.getan(),word.gettemp(),an,h);
							btn5.change(word.getan(),word.gettemp(),an,h);
							btn6.change(word.getan(),word.gettemp(),an,h);
							btn7.change(word.getan(),word.gettemp(),an,h);
							btn8.change(word.getan(),word.gettemp(),an,h);
							btn9.change(word.getan(),word.gettemp(),an,h);
							btn10.change(word.getan(),word.gettemp(),an,h);
							btn11.change(word.getan(),word.gettemp(),an,h);
							btn12.change(word.getan(),word.gettemp(),an,h);
							btn13.change(word.getan(),word.gettemp(),an,h);
							btn14.change(word.getan(),word.gettemp(),an,h);
							btn15.change(word.getan(),word.gettemp(),an,h);
							btn16.change(word.getan(),word.gettemp(),an,h);
							btn17.change(word.getan(),word.gettemp(),an,h);
							btn18.change(word.getan(),word.gettemp(),an,h);
							btn19.change(word.getan(),word.gettemp(),an,h);
							btn20.change(word.getan(),word.gettemp(),an,h);
							btn21.change(word.getan(),word.gettemp(),an,h);
							btn22.change(word.getan(),word.gettemp(),an,h);
							btn23.change(word.getan(),word.gettemp(),an,h);
							btn24.change(word.getan(),word.gettemp(),an,h);
							btn25.change(word.getan(),word.gettemp(),an,h);
							btn26.change(word.getan(),word.gettemp(),an,h);
							an=0;
							for(int i=0; i<26;i++){
								bt[i]=0;
							}
							Score=btn16.getScore();
							score2.retext(Score);
						}
					}
					else{
						char[][] answer= word.getan();
						btn16.setBackground(null);
						char a = btn16.getText().charAt(0);
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
		btn17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object obj = arg0.getSource();
				if((JButton)obj == btn17){
					bt[16]++;
					if(bt[16]%2==1){
						btn17.setBackground(Color.GREEN);
						char a=btn17.getText().charAt(0);
						word.setanswer(h,an, a);
						an++;
						if(an==4){
							btn1.change(word.getan(),word.gettemp(),an,h);
							btn2.change(word.getan(),word.gettemp(),an,h);
							btn3.change(word.getan(),word.gettemp(),an,h);
							btn4.change(word.getan(),word.gettemp(),an,h);
							btn5.change(word.getan(),word.gettemp(),an,h);
							btn6.change(word.getan(),word.gettemp(),an,h);
							btn7.change(word.getan(),word.gettemp(),an,h);
							btn8.change(word.getan(),word.gettemp(),an,h);
							btn9.change(word.getan(),word.gettemp(),an,h);
							btn10.change(word.getan(),word.gettemp(),an,h);
							btn11.change(word.getan(),word.gettemp(),an,h);
							btn12.change(word.getan(),word.gettemp(),an,h);
							btn13.change(word.getan(),word.gettemp(),an,h);
							btn14.change(word.getan(),word.gettemp(),an,h);
							btn15.change(word.getan(),word.gettemp(),an,h);
							btn16.change(word.getan(),word.gettemp(),an,h);
							btn17.change(word.getan(),word.gettemp(),an,h);
							btn18.change(word.getan(),word.gettemp(),an,h);
							btn19.change(word.getan(),word.gettemp(),an,h);
							btn20.change(word.getan(),word.gettemp(),an,h);
							btn21.change(word.getan(),word.gettemp(),an,h);
							btn22.change(word.getan(),word.gettemp(),an,h);
							btn23.change(word.getan(),word.gettemp(),an,h);
							btn24.change(word.getan(),word.gettemp(),an,h);
							btn25.change(word.getan(),word.gettemp(),an,h);
							btn26.change(word.getan(),word.gettemp(),an,h);
							an=0;
							for(int i=0; i<26;i++){
								bt[i]=0;
							}
							Score=btn17.getScore();
							score2.retext(Score);
						}
					}
					else{
						char[][] answer= word.getan();
						btn17.setBackground(null);
						char a = btn17.getText().charAt(0);
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
		btn18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object obj = arg0.getSource();
				if((JButton)obj == btn18){
					bt[17]++;
					if(bt[17]%2==1){
						btn18.setBackground(Color.GREEN);
						char a=btn18.getText().charAt(0);
						word.setanswer(h,an, a);
						an++;
						if(an==4){
							btn1.change(word.getan(),word.gettemp(),an,h);
							btn2.change(word.getan(),word.gettemp(),an,h);
							btn3.change(word.getan(),word.gettemp(),an,h);
							btn4.change(word.getan(),word.gettemp(),an,h);
							btn5.change(word.getan(),word.gettemp(),an,h);
							btn6.change(word.getan(),word.gettemp(),an,h);
							btn7.change(word.getan(),word.gettemp(),an,h);
							btn8.change(word.getan(),word.gettemp(),an,h);
							btn9.change(word.getan(),word.gettemp(),an,h);
							btn10.change(word.getan(),word.gettemp(),an,h);
							btn11.change(word.getan(),word.gettemp(),an,h);
							btn12.change(word.getan(),word.gettemp(),an,h);
							btn13.change(word.getan(),word.gettemp(),an,h);
							btn14.change(word.getan(),word.gettemp(),an,h);
							btn15.change(word.getan(),word.gettemp(),an,h);
							btn16.change(word.getan(),word.gettemp(),an,h);
							btn17.change(word.getan(),word.gettemp(),an,h);
							btn18.change(word.getan(),word.gettemp(),an,h);
							btn19.change(word.getan(),word.gettemp(),an,h);
							btn20.change(word.getan(),word.gettemp(),an,h);
							btn21.change(word.getan(),word.gettemp(),an,h);
							btn22.change(word.getan(),word.gettemp(),an,h);
							btn23.change(word.getan(),word.gettemp(),an,h);
							btn24.change(word.getan(),word.gettemp(),an,h);
							btn25.change(word.getan(),word.gettemp(),an,h);
							btn26.change(word.getan(),word.gettemp(),an,h);
							an=0;
							for(int i=0; i<26;i++){
								bt[i]=0;
							}
							Score=btn18.getScore();
							score2.retext(Score);
						}
					}
					else{
						char[][] answer= word.getan();
						btn18.setBackground(null);
						char a = btn18.getText().charAt(0);
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
		btn19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object obj = arg0.getSource();
				if((JButton)obj == btn19){
					bt[18]++;
					if(bt[18]%2==1){
						btn19.setBackground(Color.GREEN);
						char a=btn13.getText().charAt(0);
						word.setanswer(h,an, a);
						an++;
						if(an==4){
							btn1.change(word.getan(),word.gettemp(),an,h);
							btn2.change(word.getan(),word.gettemp(),an,h);
							btn3.change(word.getan(),word.gettemp(),an,h);
							btn4.change(word.getan(),word.gettemp(),an,h);
							btn5.change(word.getan(),word.gettemp(),an,h);
							btn6.change(word.getan(),word.gettemp(),an,h);
							btn7.change(word.getan(),word.gettemp(),an,h);
							btn8.change(word.getan(),word.gettemp(),an,h);
							btn9.change(word.getan(),word.gettemp(),an,h);
							btn10.change(word.getan(),word.gettemp(),an,h);
							btn11.change(word.getan(),word.gettemp(),an,h);
							btn12.change(word.getan(),word.gettemp(),an,h);
							btn13.change(word.getan(),word.gettemp(),an,h);
							btn14.change(word.getan(),word.gettemp(),an,h);
							btn15.change(word.getan(),word.gettemp(),an,h);
							btn16.change(word.getan(),word.gettemp(),an,h);
							btn17.change(word.getan(),word.gettemp(),an,h);
							btn18.change(word.getan(),word.gettemp(),an,h);
							btn19.change(word.getan(),word.gettemp(),an,h);
							btn20.change(word.getan(),word.gettemp(),an,h);
							btn21.change(word.getan(),word.gettemp(),an,h);
							btn22.change(word.getan(),word.gettemp(),an,h);
							btn23.change(word.getan(),word.gettemp(),an,h);
							btn24.change(word.getan(),word.gettemp(),an,h);
							btn25.change(word.getan(),word.gettemp(),an,h);
							btn26.change(word.getan(),word.gettemp(),an,h);
							an=0;
							for(int i=0; i<26;i++){
								bt[i]=0;
							}
							Score=btn19.getScore();
							score2.retext(Score);
						}
					}
					else{
						char[][] answer= word.getan();
						btn19.setBackground(null);
						char a = btn19.getText().charAt(0);
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
		btn20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object obj = arg0.getSource();
				if((JButton)obj == btn20){
					bt[19]++;
					if(bt[19]%2==1){
						btn20.setBackground(Color.GREEN);
						char a=btn20.getText().charAt(0);
						word.setanswer(h,an, a);
						an++;
						if(an==4){
							btn1.change(word.getan(),word.gettemp(),an,h);
							btn2.change(word.getan(),word.gettemp(),an,h);
							btn3.change(word.getan(),word.gettemp(),an,h);
							btn4.change(word.getan(),word.gettemp(),an,h);
							btn5.change(word.getan(),word.gettemp(),an,h);
							btn6.change(word.getan(),word.gettemp(),an,h);
							btn7.change(word.getan(),word.gettemp(),an,h);
							btn8.change(word.getan(),word.gettemp(),an,h);
							btn9.change(word.getan(),word.gettemp(),an,h);
							btn10.change(word.getan(),word.gettemp(),an,h);
							btn11.change(word.getan(),word.gettemp(),an,h);
							btn12.change(word.getan(),word.gettemp(),an,h);
							btn13.change(word.getan(),word.gettemp(),an,h);
							btn14.change(word.getan(),word.gettemp(),an,h);
							btn15.change(word.getan(),word.gettemp(),an,h);
							btn16.change(word.getan(),word.gettemp(),an,h);
							btn17.change(word.getan(),word.gettemp(),an,h);
							btn18.change(word.getan(),word.gettemp(),an,h);
							btn19.change(word.getan(),word.gettemp(),an,h);
							btn20.change(word.getan(),word.gettemp(),an,h);
							btn21.change(word.getan(),word.gettemp(),an,h);
							btn22.change(word.getan(),word.gettemp(),an,h);
							btn23.change(word.getan(),word.gettemp(),an,h);
							btn24.change(word.getan(),word.gettemp(),an,h);
							btn25.change(word.getan(),word.gettemp(),an,h);
							btn26.change(word.getan(),word.gettemp(),an,h);
							an=0;
							for(int i=0; i<26;i++){
								bt[i]=0;
							}
							Score=btn20.getScore();
							score2.retext(Score);
						}
					}
					else{
						char[][] answer= word.getan();
						btn20.setBackground(null);
						char a = btn20.getText().charAt(0);
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
		btn21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object obj = arg0.getSource();
				if((JButton)obj == btn21){
					bt[20]++;
					if(bt[20]%2==1){
						btn21.setBackground(Color.GREEN);
						char a=btn21.getText().charAt(0);
						word.setanswer(h,an, a);
						an++;
						if(an==4){
							btn1.change(word.getan(),word.gettemp(),an,h);
							btn2.change(word.getan(),word.gettemp(),an,h);
							btn3.change(word.getan(),word.gettemp(),an,h);
							btn4.change(word.getan(),word.gettemp(),an,h);
							btn5.change(word.getan(),word.gettemp(),an,h);
							btn6.change(word.getan(),word.gettemp(),an,h);
							btn7.change(word.getan(),word.gettemp(),an,h);
							btn8.change(word.getan(),word.gettemp(),an,h);
							btn9.change(word.getan(),word.gettemp(),an,h);
							btn10.change(word.getan(),word.gettemp(),an,h);
							btn11.change(word.getan(),word.gettemp(),an,h);
							btn12.change(word.getan(),word.gettemp(),an,h);
							btn13.change(word.getan(),word.gettemp(),an,h);
							btn14.change(word.getan(),word.gettemp(),an,h);
							btn15.change(word.getan(),word.gettemp(),an,h);
							btn16.change(word.getan(),word.gettemp(),an,h);
							btn17.change(word.getan(),word.gettemp(),an,h);
							btn18.change(word.getan(),word.gettemp(),an,h);
							btn19.change(word.getan(),word.gettemp(),an,h);
							btn20.change(word.getan(),word.gettemp(),an,h);
							btn21.change(word.getan(),word.gettemp(),an,h);
							btn22.change(word.getan(),word.gettemp(),an,h);
							btn23.change(word.getan(),word.gettemp(),an,h);
							btn24.change(word.getan(),word.gettemp(),an,h);
							btn25.change(word.getan(),word.gettemp(),an,h);
							btn26.change(word.getan(),word.gettemp(),an,h);
							an=0;
							for(int i=0; i<26;i++){
								bt[i]=0;
							}
							Score=btn21.getScore();
							score2.retext(Score);
						}
					}
					else{
						char[][] answer= word.getan();
						btn21.setBackground(null);
						char a = btn21.getText().charAt(0);
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
		btn22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object obj = arg0.getSource();
				if((JButton)obj == btn22){
					bt[21]++;
					if(bt[21]%2==1){
						btn22.setBackground(Color.GREEN);
						char a=btn22.getText().charAt(0);
						word.setanswer(h,an, a);
						an++;
						if(an==4){
							btn1.change(word.getan(),word.gettemp(),an,h);
							btn2.change(word.getan(),word.gettemp(),an,h);
							btn3.change(word.getan(),word.gettemp(),an,h);
							btn4.change(word.getan(),word.gettemp(),an,h);
							btn5.change(word.getan(),word.gettemp(),an,h);
							btn6.change(word.getan(),word.gettemp(),an,h);
							btn7.change(word.getan(),word.gettemp(),an,h);
							btn8.change(word.getan(),word.gettemp(),an,h);
							btn9.change(word.getan(),word.gettemp(),an,h);
							btn10.change(word.getan(),word.gettemp(),an,h);
							btn11.change(word.getan(),word.gettemp(),an,h);
							btn12.change(word.getan(),word.gettemp(),an,h);
							btn13.change(word.getan(),word.gettemp(),an,h);
							btn14.change(word.getan(),word.gettemp(),an,h);
							btn15.change(word.getan(),word.gettemp(),an,h);
							btn16.change(word.getan(),word.gettemp(),an,h);
							btn17.change(word.getan(),word.gettemp(),an,h);
							btn18.change(word.getan(),word.gettemp(),an,h);
							btn19.change(word.getan(),word.gettemp(),an,h);
							btn20.change(word.getan(),word.gettemp(),an,h);
							btn21.change(word.getan(),word.gettemp(),an,h);
							btn22.change(word.getan(),word.gettemp(),an,h);
							btn23.change(word.getan(),word.gettemp(),an,h);
							btn24.change(word.getan(),word.gettemp(),an,h);
							btn25.change(word.getan(),word.gettemp(),an,h);
							btn26.change(word.getan(),word.gettemp(),an,h);
							an=0;
							for(int i=0; i<26;i++){
								bt[i]=0;
							}
							Score=btn22.getScore();
							score2.retext(Score);
						}
					}
					else{
						char[][] answer= word.getan();
						btn22.setBackground(null);
						char a = btn22.getText().charAt(0);
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
		btn23.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object obj = arg0.getSource();
				if((JButton)obj == btn23){
					bt[22]++;
					if(bt[22]%2==1){
						btn23.setBackground(Color.GREEN);
						char a=btn23.getText().charAt(0);
						word.setanswer(h,an, a);
						an++;
						if(an==4){
							btn1.change(word.getan(),word.gettemp(),an,h);
							btn2.change(word.getan(),word.gettemp(),an,h);
							btn3.change(word.getan(),word.gettemp(),an,h);
							btn4.change(word.getan(),word.gettemp(),an,h);
							btn5.change(word.getan(),word.gettemp(),an,h);
							btn6.change(word.getan(),word.gettemp(),an,h);
							btn7.change(word.getan(),word.gettemp(),an,h);
							btn8.change(word.getan(),word.gettemp(),an,h);
							btn9.change(word.getan(),word.gettemp(),an,h);
							btn10.change(word.getan(),word.gettemp(),an,h);
							btn11.change(word.getan(),word.gettemp(),an,h);
							btn12.change(word.getan(),word.gettemp(),an,h);
							btn13.change(word.getan(),word.gettemp(),an,h);
							btn14.change(word.getan(),word.gettemp(),an,h);
							btn15.change(word.getan(),word.gettemp(),an,h);
							btn16.change(word.getan(),word.gettemp(),an,h);
							btn17.change(word.getan(),word.gettemp(),an,h);
							btn18.change(word.getan(),word.gettemp(),an,h);
							btn19.change(word.getan(),word.gettemp(),an,h);
							btn20.change(word.getan(),word.gettemp(),an,h);
							btn21.change(word.getan(),word.gettemp(),an,h);
							btn22.change(word.getan(),word.gettemp(),an,h);
							btn23.change(word.getan(),word.gettemp(),an,h);
							btn24.change(word.getan(),word.gettemp(),an,h);
							btn25.change(word.getan(),word.gettemp(),an,h);
							btn26.change(word.getan(),word.gettemp(),an,h);
							an=0;
							for(int i=0; i<26;i++){
								bt[i]=0;
							}
							Score=btn23.getScore();
							score2.retext(Score);
						}
					}
					else{
						char[][] answer= word.getan();
						btn23.setBackground(null);
						char a = btn23.getText().charAt(0);
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
		btn24.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object obj = arg0.getSource();
				if((JButton)obj == btn24){
					bt[23]++;
					if(bt[23]%2==1){
						btn24.setBackground(Color.GREEN);
						char a=btn24.getText().charAt(0);
						word.setanswer(h,an, a);
						an++;
						if(an==4){
							btn1.change(word.getan(),word.gettemp(),an,h);
							btn2.change(word.getan(),word.gettemp(),an,h);
							btn3.change(word.getan(),word.gettemp(),an,h);
							btn4.change(word.getan(),word.gettemp(),an,h);
							btn5.change(word.getan(),word.gettemp(),an,h);
							btn6.change(word.getan(),word.gettemp(),an,h);
							btn7.change(word.getan(),word.gettemp(),an,h);
							btn8.change(word.getan(),word.gettemp(),an,h);
							btn9.change(word.getan(),word.gettemp(),an,h);
							btn10.change(word.getan(),word.gettemp(),an,h);
							btn11.change(word.getan(),word.gettemp(),an,h);
							btn12.change(word.getan(),word.gettemp(),an,h);
							btn13.change(word.getan(),word.gettemp(),an,h);
							btn14.change(word.getan(),word.gettemp(),an,h);
							btn15.change(word.getan(),word.gettemp(),an,h);
							btn16.change(word.getan(),word.gettemp(),an,h);
							btn17.change(word.getan(),word.gettemp(),an,h);
							btn18.change(word.getan(),word.gettemp(),an,h);
							btn19.change(word.getan(),word.gettemp(),an,h);
							btn20.change(word.getan(),word.gettemp(),an,h);
							btn21.change(word.getan(),word.gettemp(),an,h);
							btn22.change(word.getan(),word.gettemp(),an,h);
							btn23.change(word.getan(),word.gettemp(),an,h);
							btn24.change(word.getan(),word.gettemp(),an,h);
							btn25.change(word.getan(),word.gettemp(),an,h);
							btn26.change(word.getan(),word.gettemp(),an,h);
							an=0;
							for(int i=0; i<26;i++){
								bt[i]=0;
							}
							Score=btn24.getScore();
							score2.retext(Score);
						}
					}
					else{
						char[][] answer= word.getan();
						btn24.setBackground(null);
						char a = btn24.getText().charAt(0);
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
		btn25.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object obj = arg0.getSource();
				if((JButton)obj == btn25){
					bt[24]++;
					if(bt[24]%2==1){
						btn25.setBackground(Color.GREEN);
						char a=btn25.getText().charAt(0);
						word.setanswer(h,an, a);
						an++;
						if(an==4){
							btn1.change(word.getan(),word.gettemp(),an,h);
							btn2.change(word.getan(),word.gettemp(),an,h);
							btn3.change(word.getan(),word.gettemp(),an,h);
							btn4.change(word.getan(),word.gettemp(),an,h);
							btn5.change(word.getan(),word.gettemp(),an,h);
							btn6.change(word.getan(),word.gettemp(),an,h);
							btn7.change(word.getan(),word.gettemp(),an,h);
							btn8.change(word.getan(),word.gettemp(),an,h);
							btn9.change(word.getan(),word.gettemp(),an,h);
							btn10.change(word.getan(),word.gettemp(),an,h);
							btn11.change(word.getan(),word.gettemp(),an,h);
							btn12.change(word.getan(),word.gettemp(),an,h);
							btn13.change(word.getan(),word.gettemp(),an,h);
							btn14.change(word.getan(),word.gettemp(),an,h);
							btn15.change(word.getan(),word.gettemp(),an,h);
							btn16.change(word.getan(),word.gettemp(),an,h);
							btn17.change(word.getan(),word.gettemp(),an,h);
							btn18.change(word.getan(),word.gettemp(),an,h);
							btn19.change(word.getan(),word.gettemp(),an,h);
							btn20.change(word.getan(),word.gettemp(),an,h);
							btn21.change(word.getan(),word.gettemp(),an,h);
							btn22.change(word.getan(),word.gettemp(),an,h);
							btn23.change(word.getan(),word.gettemp(),an,h);
							btn24.change(word.getan(),word.gettemp(),an,h);
							btn25.change(word.getan(),word.gettemp(),an,h);
							btn26.change(word.getan(),word.gettemp(),an,h);
							an=0;
							for(int i=0; i<26;i++){
								bt[i]=0;
							}
							Score=btn25.getScore();
							score2.retext(Score);
						}
					}
					else{
						char[][] answer= word.getan();
						btn25.setBackground(null);
						char a = btn25.getText().charAt(0);
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
		btn26.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object obj = arg0.getSource();
				if((JButton)obj == btn26){
					bt[25]++;
					if(bt[25]%2==1){
						btn26.setBackground(Color.GREEN);
						char a=btn26.getText().charAt(0);
						word.setanswer(h,an, a);
						an++;
						if(an==4){
							btn1.change(word.getan(),word.gettemp(),an,h);
							btn2.change(word.getan(),word.gettemp(),an,h);
							btn3.change(word.getan(),word.gettemp(),an,h);
							btn4.change(word.getan(),word.gettemp(),an,h);
							btn5.change(word.getan(),word.gettemp(),an,h);
							btn6.change(word.getan(),word.gettemp(),an,h);
							btn7.change(word.getan(),word.gettemp(),an,h);
							btn8.change(word.getan(),word.gettemp(),an,h);
							btn9.change(word.getan(),word.gettemp(),an,h);
							btn10.change(word.getan(),word.gettemp(),an,h);
							btn11.change(word.getan(),word.gettemp(),an,h);
							btn12.change(word.getan(),word.gettemp(),an,h);
							btn13.change(word.getan(),word.gettemp(),an,h);
							btn14.change(word.getan(),word.gettemp(),an,h);
							btn15.change(word.getan(),word.gettemp(),an,h);
							btn16.change(word.getan(),word.gettemp(),an,h);
							btn17.change(word.getan(),word.gettemp(),an,h);
							btn18.change(word.getan(),word.gettemp(),an,h);
							btn19.change(word.getan(),word.gettemp(),an,h);
							btn20.change(word.getan(),word.gettemp(),an,h);
							btn21.change(word.getan(),word.gettemp(),an,h);
							btn22.change(word.getan(),word.gettemp(),an,h);
							btn23.change(word.getan(),word.gettemp(),an,h);
							btn24.change(word.getan(),word.gettemp(),an,h);
							btn25.change(word.getan(),word.gettemp(),an,h);
							btn26.change(word.getan(),word.gettemp(),an,h);

							an=0;
							for(int i=0; i<26;i++){
								bt[i]=0;
							}
							Score=btn26.getScore();
							score2.retext(Score);
						}
					}
					else{
						char[][] answer= word.getan();
						btn26.setBackground(null);
						char a = btn26.getText().charAt(0);
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
			this.init(26,0);
			btn1.setBackground(null);
			btn2.setBackground(null);
			btn3.setBackground(null);
			btn4.setBackground(null);
			btn5.setBackground(null);
			btn6.setBackground(null);
			btn7.setBackground(null);
			btn8.setBackground(null);
			btn9.setBackground(null);
			btn10.setBackground(null);
			btn11.setBackground(null);
			btn12.setBackground(null);
			btn13.setBackground(null);
			btn14.setBackground(null);
			btn15.setBackground(null);
			btn16.setBackground(null);
			btn17.setBackground(null);
			btn18.setBackground(null);
			btn19.setBackground(null);
			btn20.setBackground(null);
			btn21.setBackground(null);
			btn22.setBackground(null);
			btn23.setBackground(null);
			btn24.setBackground(null);
			btn25.setBackground(null);
			btn26.setBackground(null);
			btn1.set();
			btn2.set();
			btn3.set();
			btn4.set();
			btn5.set();
			btn6.set();
			btn7.set();
			btn8.set();
			btn9.set();
			btn10.set();
			btn11.set();
			btn12.set();
			btn13.set();
			btn14.set();
			btn15.set();
			btn16.set();
			btn17.set();
			btn18.set();
			btn19.set();
			btn20.set();
			btn21.set();
			btn22.set();
			btn23.set();
			btn24.set();
			btn25.set();
			btn26.set();

			word2=word.getword();			
			this.add(btn4);
			this.add(btn3);
			this.add(btn2);
			this.add(btn1);
			this.add(btn5);
			this.add(btn6);
			this.add(btn7);
			this.add(btn8);
			this.add(btn9);
			this.add(btn10);
			this.add(btn11);
			this.add(btn12);
			this.add(btn13);
			this.add(btn14);
			this.add(btn15);
			this.add(btn16);
			this.add(btn17);
			this.add(btn18);
			this.add(btn19);
			this.add(btn20);
			this.add(btn21);
			this.add(btn22);
			this.add(btn23);
			this.add(btn24);
			this.add(btn25);
			this.add(btn26);
		try {
			Thread.sleep(11000);
		} catch (Exception ex) {
		}
			
	}
	}
}
