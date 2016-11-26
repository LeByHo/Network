package Main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
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
import javax.swing.JOptionPane;

import Client.Client;
import Client.DTO;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.UIManager;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
public class Chattroom extends JFrame {
	private JPanel contentPane;
	static String name;
	static int age;
	static String id;
	static String password;
	static int come;
	static int roomnum;

	
	public Chattroom(DTO dto) {
	
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new MyListener(this));
		name = dto.getName();
		age = dto.getAge();
		id = dto.getId();
		password = dto.getPassword();
		come = dto.getCome();
		ImageIcon icon = new ImageIcon("background6.png");
		Image originImg = icon.getImage();
		Image changedImg = originImg.getScaledInstance(1100, 870, Image.SCALE_SMOOTH);
		ImageIcon Icon = new ImageIcon(changedImg);
		setTitle("VOCA POP");
		setSize(1100, 900);
		setResizable(false);
		setLocation(0, 0);
		setVisible(false);
		JPanel panel = new JPanel(){	
			public void paintComponent(Graphics g){ 
				g.drawImage(Icon.getImage(),0,0,null);
				setOpaque(false);//배경 띄워주기
				super.paintComponent(g);
			}
		};
		placeLoginPanel(panel);
		// add
		getContentPane().add(panel);
		
		JButton btnNewButton = new JButton("방 나가기");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Client.DeletetRoom("room"+roomnum);
					dispose();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(489, 710, 97, 40);
		panel.add(btnNewButton);
		// visiible
		setVisible(true);
	}
	public void placeLoginPanel(JPanel panel){
		panel.setLayout(null);
		Color color = new Color(255,0,0);
		ImageIcon icon = null;

		switch(come){
		case 1:
			icon = new ImageIcon("a.jpg");
			break;
		case 2:
			icon = new ImageIcon("apech2.jpg");
			break;
		case 3:
			icon = new ImageIcon("frood2.jpg");
			break;
		case 4:
			icon = new ImageIcon("green2.jpg");
			break;
		case 5:
			icon = new ImageIcon("neo2.jpg");
			break;
		}
		Image originImg = icon.getImage();
		Image changedImg= originImg.getScaledInstance(200, 200, Image.SCALE_SMOOTH );
		ImageIcon Icon = new ImageIcon(changedImg);

		JPanel client1= new JPanel();
		client1.setLayout(null);
		JPanel picture = new JPanel(){
			public void paintComponent(Graphics g){ 
				g.drawImage(Icon.getImage(),0,0,null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		picture.setBounds(0, 0, 200, 200);
		JLabel user = new JLabel(name,JLabel.CENTER);
		user.setBounds(0,200,200,50);
		user.setBackground(color);
		user.setOpaque(true);
		client1.add(picture);
		client1.add(user);
		client1.setBounds(20, 50, 200, 250);
		panel.add(client1);

		JPanel client2= new JPanel();
		client2.setLayout(null);
		JPanel picture2 = new JPanel(){
			public void paintComponent(Graphics g){ 
				g.drawImage(Icon.getImage(),0,0,null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		picture2.setBounds(0, 0, 200, 200);
		JLabel user2 = new JLabel("이병호",JLabel.CENTER);
		user2.setBounds(0,200,200,50);
		user2.setOpaque(true);
		user2.setBackground(color);
		client2.add(picture2);
		client2.add(user2);
		client2.setBounds(20, 550, 200, 250);
		panel.add(client2);

		JPanel client3= new JPanel();
		client3.setLayout(null);
		JPanel picture3 = new JPanel(){
			public void paintComponent(Graphics g){ 
				g.drawImage(Icon.getImage(),0,0,null);
				setOpaque(false);//배경 띄워주기
				super.paintComponent(g);
			}
		};
		picture3.setBounds(0, 0, 200, 200);
		JLabel user3 = new JLabel("이병호",JLabel.CENTER);
		user3.setBounds(0,200,200,50);
		user3.setOpaque(true);
		user3.setBackground(color);
		client3.add(picture3);
		client3.add(user3);
		client3.setBounds(850, 50, 200, 250);
		panel.add(client3);

		JPanel client4= new JPanel();
		client4.setLayout(null);
		JPanel picture4 = new JPanel(){
			public void paintComponent(Graphics g){ 
				g.drawImage(Icon.getImage(),0,0,null);
				setOpaque(false);//배경 띄워주기
				super.paintComponent(g);
			}
		};
		picture4.setBounds(0, 0, 200, 200);
		JLabel user4 = new JLabel("이병호",JLabel.CENTER);
		user4.setBounds(0,200,200,50);
		user4.setOpaque(true);
		user4.setBackground(color);
		client4.add(picture4);
		client4.add(user4);
		client4.setBounds(850, 550, 200, 250);
		panel.add(client4);

		JTextArea message = new JTextArea();
		message.setBounds(280,120,530,500);
		message.setEditable(false);
		message.setBackground(Color.WHITE);
		panel.add(message);

		JTextField userText = new JTextField();
		userText.setBounds(280, 650, 530, 50);
		panel.add(userText); 
	}
	public static int getRoomnum() {
		return roomnum;
	}
	public static void setRoomnum(int roomnum) {
		Chattroom.roomnum = roomnum;
	}

}
class MyListener implements WindowListener{
	private Chattroom f;
	MyListener(Chattroom f){
		this.f=f;
	}
	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		int choice = JOptionPane.showConfirmDialog(f,"정말?","Confirmation",JOptionPane.YES_NO_OPTION);
		if(choice==0){
			try {
				Client.DeletetRoom("room"+f.getRoomnum());
				f.dispose();	
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	@Override
	public void windowDeactivated(WindowEvent arg0) {
	
	}
	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}