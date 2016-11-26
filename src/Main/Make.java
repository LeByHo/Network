package Main;
import java.awt.BorderLayout;
import java.awt.EventQueue;

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
import Login.Find;
import Login.Join;
import Login.Login;
import Main.Room;

import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Make extends JFrame{
	DTO dto = new DTO();
	static String name;
	static int age;
	static String id;
	static String password;
	static int come;
	int room;
	public Make(DTO dto, int room) {
		name = dto.getName();
		age = dto.getAge();
		id = dto.getId();
		password = dto.getPassword();
		come = dto.getCome();
		this.room=room;
		setForeground(Color.WHITE);
		setTitle("\uBC29\uB9CC\uB4E4\uAE30");
		setSize(372, 194);
		setResizable(false);
		setLocation(800, 350);
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		placeLoginPanel(panel);
		getContentPane().add(panel);
		setVisible(true);
	}
	public void placeLoginPanel(JPanel panel){
		dto.setName(name);
		dto.setAge(age);
		dto.setId(id);
		dto.setPassword(password);
		dto.setCome(come);
		panel.setLayout(null);      
		JLabel userLabel = new JLabel("\uBC29 \uC774\uB984",JLabel.CENTER);
		userLabel.setBounds(10, 40, 80, 25);
		panel.add(userLabel);

		JTextField userText = new JTextField(20);
		userText.setBounds(102, 40, 222, 25);
		panel.add(userText);

		JButton join = new JButton("\uB9CC\uB4E4\uAE30");
		join.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if((JButton)obj == join){
						try {
							Chattroom chat = new Chattroom(dto);
							Client.InsertRoom("room"+room);
							chat.setRoomnum(room);
							dispose();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				}
			}
		});
		join.setBounds(128, 86, 121, 38);
		panel.add(join);   


	}
}