package Main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

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

import Client.DTO;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.UIManager;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.ActionEvent;

public class Category extends JFrame {
	private JPanel contentPane;
	DTO dto = new DTO();
	private JPanel panel_1;

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Category frame = new Category();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Category() {

		ImageIcon icon = new ImageIcon("background3.png");
		Image originImg = icon.getImage();
		Image changedImg = originImg.getScaledInstance(1100, 870, Image.SCALE_SMOOTH);
		ImageIcon Icon = new ImageIcon(changedImg);
		setTitle("VOCA POP");
		setSize(1100, 900);
		setResizable(false);
		setLocation(0, 0);
		panel_1 = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(Icon.getImage(), 0, 0, null);
				setOpaque(false);// 배경 띄워주기
				super.paintComponent(g);
			}
		};

		placeLoginPanel(panel_1);
		// add
		getContentPane().add(panel_1);
		// visiible
		setVisible(true);
	}

	public void placeLoginPanel(JPanel panel) {

		ImageIcon icon = new ImageIcon("eco.png");
		Image originImg = icon.getImage();
		Image changedImg = originImg.getScaledInstance(220, 240, Image.SCALE_SMOOTH);
		ImageIcon Icon = new ImageIcon(changedImg);
		ImageIcon icon2 = new ImageIcon("tra.png");
		Image originImg2 = icon2.getImage();
		Image changedImg2 = originImg2.getScaledInstance(220, 240, Image.SCALE_SMOOTH);
		ImageIcon Icon2 = new ImageIcon(changedImg2);
		ImageIcon icon3 = new ImageIcon("bussines.png");
		Image originImg3 = icon3.getImage();
		Image changedImg3 = originImg3.getScaledInstance(220, 240, Image.SCALE_SMOOTH);
		ImageIcon Icon3 = new ImageIcon(changedImg3);
		ImageIcon icon4 = new ImageIcon("shop.png");
		Image originImg4 = icon4.getImage();
		Image changedImg4 = originImg4.getScaledInstance(220, 240, Image.SCALE_SMOOTH);
		ImageIcon Icon4 = new ImageIcon(changedImg4);
		ImageIcon icon5 = new ImageIcon("travel.png");
		Image originImg5 = icon5.getImage();
		Image changedImg5 = originImg5.getScaledInstance(220, 240, Image.SCALE_SMOOTH);
		ImageIcon Icon5 = new ImageIcon(changedImg5);
		ImageIcon icon6 = new ImageIcon("interview.png");
		Image originImg6 = icon6.getImage();
		Image changedImg6 = originImg6.getScaledInstance(220, 240, Image.SCALE_SMOOTH);
		ImageIcon Icon6 = new ImageIcon(changedImg6);



		panel_1.setLayout(null);
		// panel

		Level s1= new Level(0,0,"레벨 1",1,0);
		Level s2= new Level(0,80,"레벨2",2,0);
		Level s3= new Level(0,160,"레벨 3",3,0);
		Test f1= new Test(0,40,"Test");
		Test f2= new Test(0,120,"Test");
		Test f3= new Test(0,200,"Test");      
		JPanel c1 = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(Icon.getImage(), 0, 0, null);
				setOpaque(false);// 배경 띄워주기
				super.paintComponent(g);
			}
		};
		c1.setBounds(100, 195, 220, 240);
		c1.setLayout(null);
		c1.add(s1);
		c1.add(s2);
		c1.add(s3);
		c1.add(f1);
		c1.add(f2);
		c1.add(f3);
		panel.add(c1);


		Level s4= new Level(0,0,"레벨 1",1,1);
		Level s5= new Level(0,80,"레벨2",2,1);
		Level s6= new Level(0,160,"레벨 3",3,1);
		Test f4= new Test(0,40,"Test");
		Test f5= new Test(0,120,"Test");
		Test f6= new Test(0,200,"Test");      

		JPanel c2 = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(Icon2.getImage(), 0, 0, null);
				setOpaque(false);// 배경 띄워주기
				super.paintComponent(g);
			}
		};
		c2.setBounds(430, 195, 220, 240);
		c2.setLayout(null);
		c2.add(s4);
		c2.add(s5);
		c2.add(s6);
		c2.add(f4);
		c2.add(f5);
		c2.add(f6);
		panel.add(c2);

		Level s7= new Level(0,0,"레벨 1",1,2);
		Level s8= new Level(0,80,"레벨2",2,2);
		Level s9= new Level(0,160,"레벨 3",3,2);
		Test f7= new Test(0,40,"Test");
		Test f8= new Test(0,120,"Test");
		Test f9= new Test(0,200,"Test");

		JPanel c3 = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(Icon3.getImage(), 0, 0, null);
				setOpaque(false);// 배경 띄워주기
				super.paintComponent(g);
			}
		};
		c3.setBounds(758, 200, 222, 240);
		c3.setLayout(null);
		c3.add(s7);
		c3.add(s8);
		c3.add(s9);
		c3.add(f7);
		c3.add(f8);
		c3.add(f9);
		panel.add(c3);
		Level s10= new Level(0,0,"레벨 1",1,3);
		Level s11= new Level(0,80,"레벨2",2,3);
		Level s12= new Level(0,160,"레벨 3",3,3);
		Test f10= new Test(0,40,"Test");
		Test f11= new Test(0,120,"Test");
		Test f12= new Test(0,200,"Test");      

		JPanel c4 = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(Icon4.getImage(), 0, 0, null);
				setOpaque(false);// 배경 띄워주기
				super.paintComponent(g);
			}
		};
		c4.setBounds(100, 500, 222, 240);
		c4.setLayout(null);
		c4.add(s10);
		c4.add(s11);
		c4.add(s12);
		c4.add(f10);
		c4.add(f11);
		c4.add(f12);
		panel.add(c4);

		Level s13= new Level(0,0,"레벨 1",1,4);
		Level s14= new Level(0,80,"레벨2",2,4);
		Level s15= new Level(0,160,"레벨 3",3,4);
		Test f13= new Test(0,40,"Test");
		Test f14= new Test(0,120,"Test");
		Test f15= new Test(0,200,"Test");      

		JPanel c5 = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(Icon5.getImage(), 0, 0, null);
				setOpaque(false);// 배경 띄워주기
				super.paintComponent(g);
			}
		};
		c5.setBounds(430, 500, 222, 240);
		c5.setLayout(null);
		c5.add(s13);
		c5.add(s14);
		c5.add(s15);
		c5.add(f13);
		c5.add(f14);
		c5.add(f15);
		panel.add(c5);

		Level s16= new Level(0,0,"레벨 1",1,5);
		Level s17= new Level(0,80,"레벨2",2,5);
		Level s18= new Level(0,160,"레벨 3",3,5);
		Test f16= new Test(0,40,"Test");
		Test f17= new Test(0,120,"Test");
		Test f18= new Test(0,200,"Test");      


		JPanel c6 = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(Icon6.getImage(), 0, 0, null);
				setOpaque(false);// 배경 띄워주기
				super.paintComponent(g);
			}
		};
		c6.setBounds(758, 500, 222, 240);
		c6.setLayout(null);
		c6.add(s16);
		c6.add(s17);
		c6.add(s18);
		c6.add(f16);
		c6.add(f17);
		c6.add(f18);
		panel.add(c6);
	}
}

class Level extends JButton{
	int i;
	int j;
	Font f2 = new Font("궁서", Font.BOLD, 20);
	Level(int x, int y,String s,int i,int j){
		setFont(f2);

		setBorderPainted(false);
		setBounds(x, y, 222, 40);
		setBackground(Color.WHITE);
		setOpaque(false);
		setVisible(true);
		this.j=j;
		this.i=i;
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(i==1){
					wword.catego=j;
					wword.wlevel=i;
					new voca(j);
				}
				else if(i==2){
					wword.catego=j;
					wword.wlevel=i;
					new voca2(j);	
				}
				else{
					wword.catego=j;
					wword.wlevel=i;
					new voca3(j);
				}
			}
		});
		this.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				setText(s);    
				setOpaque(true);
			}
			public void mouseExited(MouseEvent e) {
				setText("");
				setOpaque(false);

			}
		});
	}
}
class Test extends JButton{
	Font f2 = new Font("궁서", Font.BOLD, 20);
	Test(int x, int y,String s){
		setFont(f2);
		setBorderPainted(false);
		setBounds(x, y, 222, 40);
		setBackground(Color.white);
		setOpaque(false);
		setVisible(true);
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Final();
			}
		});
		this.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				setText(s);
				setOpaque(true);
			}
			public void mouseExited(MouseEvent e) {
				setText("");
				setOpaque(false);
			}
		});
	}
}