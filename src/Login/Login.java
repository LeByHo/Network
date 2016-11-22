package Login;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Client.Client;
import Client.DTO;
import Main.Room;

import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	DTO dto = new DTO();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Login() {
		setTitle("login");
		setSize(1100, 900);
		setResizable(false);
		setLocation(0, 0);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		ImageIcon icon = new ImageIcon("background.png");
		Image originImg = icon.getImage();
		Image changedImg = originImg.getScaledInstance(1100, 870, Image.SCALE_SMOOTH);
		ImageIcon Icon = new ImageIcon(changedImg);
		// panel
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
	public void placeLoginPanel(JPanel panel){
		  Font f2 = new Font("궁서", Font.BOLD, 20);
		panel.setLayout(null);	
		JPanel total = new JPanel();
		total.setBounds(370, 500, 500, 500);
		total.setOpaque(false);
		total.setLayout(null);
		panel.add(total);
		
		JLabel userLabel = new JLabel("ID",JLabel.CENTER);
		userLabel.setFont(f2);
		userLabel.setBounds(0, 0, 100,50);
		total.add(userLabel);

		JLabel passLabel = new JLabel("Password",JLabel.CENTER);
		passLabel.setBounds(0,60, 100, 50);
		passLabel.setFont(f2);
		total.add(passLabel);

		JTextField userText = new JTextField(20);
		userText.setBounds(110, 13, 160, 25);
		total.add(userText);

		JPasswordField passText = new JPasswordField(20);
		passText.setBounds(110, 73, 160, 25);
		total.add(passText);


		JButton btnInit = new JButton("ID/Pw \uCC3E\uAE30");
		btnInit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object obj = arg0.getSource();
				if((JButton)obj == btnInit){
					new Find("ID/Pw 찾기");
				}
			}
		});
		btnInit.setBounds(15, 120, 100, 25);
		total.add(btnInit);


		JButton join = new JButton("\uD68C\uC6D0\uAC00\uC785");
		join.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if((JButton)obj == join){
					Join jo = new Join();
				}

			}
		});
		join.setBounds(150, 120, 100, 25);

		total.add(join);	

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object obj = arg0.getSource();
				if((JButton)obj == btnLogin){
					dto.setId(userText.getText());
					dto.setPassword(passText.getText());
					userText.setText("");
					passText.setText("");
					if(dto.getId().length()==0)
						JOptionPane.showMessageDialog(null, "ID를 입력하세요.", "알림", JOptionPane.INFORMATION_MESSAGE);
					else{
						try {
							String str = Client.Checkid(dto);
							if(str.equals("NULL"))
								JOptionPane.showMessageDialog(null, "ID가 존재하지 않습니다.", "경고", JOptionPane.WARNING_MESSAGE);
							else if(str.equals("Npass"))
								JOptionPane.showMessageDialog(null, "Password가 틀립니다.", "경고", JOptionPane.WARNING_MESSAGE);
							else{
								String[] arr = str.split(" ");		
								dto.setName(arr[0]);
								dto.setAge(Integer.parseInt(arr[1]));
								dto.setCome(Integer.parseInt(arr[2]));
								if(dto.getCome()==0){
									new Choice(dto);
									dispose();
								}
								else{
									new Room(dto);
									dispose();
								}
							}
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}});
		btnLogin.setBounds(280, 13, 70, 80);
		
		total.add( btnLogin);	
	}
}

