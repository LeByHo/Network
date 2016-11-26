package Main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.charset.Charset;
import java.util.Random;
import java.util.Timer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Client.DTO;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;

public class Last extends JFrame {
	private JPanel contentPane;
	DTO dto = new DTO();
	String[] wd;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					wword word = new wword();
					Last frame = new Last(word);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Last(wword word) {
		setTitle("VOCA POP");
		setSize(1100, 900);
		setResizable(false);
		setLocation(0, 0);

		wd=word.get();
		int Check[]=word.check();
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
		placeLoginPanel(panel,Check);
		setVisible(true);
	}
	public void placeLoginPanel(JPanel panel,int[] Check) {
		panel.setLayout(null);;
		JPanel sq = new JPanel();
		sq.setBounds(200, 100, 700, 700);
		sq.setLayout(null);
		sq.setOpaque(true);
		panel.add(sq);
		check c1= new check(0,0,wd[0]);
		check c2= new check(0,70,wd[1]);
		check c3= new check(0,140,wd[2]);
		check c4= new check(0,210,wd[3]);
		check c5= new check(0,280,wd[4]);
		check c6= new check(0,350,wd[5]);
		check c7= new check(0,420,wd[6]);
		check c8= new check(0,490,wd[7]);
		check c9= new check(0,560,wd[8]);
		check c10= new check(0,630,wd[9]);
		sq.add(c1);
		sq.add(c2);
		sq.add(c3);
		sq.add(c4);
		sq.add(c5);
		sq.add(c6);
		sq.add(c7);
		sq.add(c8);
		sq.add(c9);
		sq.add(c10);
		mean m1 = new mean(300,0);
		mean m2 = new mean(300,70);
		mean m3 = new mean(300,140);
		mean m4 = new mean(300,210);
		mean m5 = new mean(300,280);
		mean m6 = new mean(300,350);
		mean m7 = new mean(300,420);
		mean m8 = new mean(300,490);
		mean m9 = new mean(300,560);
		mean m10 = new mean(300,630);
		sq.add(m1);
		sq.add(m2);
		sq.add(m3);
		sq.add(m4);
		sq.add(m5);
		sq.add(m6);
		sq.add(m7);
		sq.add(m8);
		sq.add(m9);
		sq.add(m10);
		box b1 = new box(600,0,Check[0]);
		box b2 = new box(600,70,Check[1]);
		box b3 = new box(600,140,Check[2]);
		box b4 = new box(600,210,Check[3]);
		box b5 = new box(600,280,Check[4]);
		box b6 = new box(600,350,Check[5]);
		box b7 = new box(600,420,Check[6]);
		box b8 = new box(600,490,Check[7]);
		box b9 = new box(600,560,Check[8]);
		box b10 = new box(600,630,Check[9]);
		sq.add(b1);
		sq.add(b2);
		sq.add(b3);
		sq.add(b4);
		sq.add(b5);
		sq.add(b6);
		sq.add(b7);
		sq.add(b8);
		sq.add(b9);
		sq.add(b10);  
	}
}
class check extends JLabel{
	Font f2 = new Font("±Ã¼­", Font.BOLD, 20);
	check(int x, int y,String a){
		setText(a);
		setBounds(x,y,300,70);
		setHorizontalAlignment(CENTER);
		setFont(f2);
	}
}
class mean extends JLabel{
	Font f2 = new Font("±Ã¼­", Font.BOLD, 20);
	mean(int x, int y){
		setText("hello");
		setBounds(x,y,300,70);
		setHorizontalAlignment(CENTER);
		setFont(f2);
	}
}
class box extends JCheckBox{
	box(int x,int y,int a){
		setBounds(x,y,100,70);
		if(a==0){
			doClick();
		}

	}
}