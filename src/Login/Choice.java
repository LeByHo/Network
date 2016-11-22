package Login;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Client.Client;
import Client.DTO;
import Main.Room;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Choice extends JFrame {
	DTO dto = new DTO();
	static String name;
	static int age;
	static String id;
	static String password;
	static int come;
	public Choice(DTO dto) {
		name = dto.getName();
		age = dto.getAge();
		id = dto.getId();
		password = dto.getPassword();
		come = dto.getCome();
		setTitle("Choice Avator");
		setSize(800, 400);
		setResizable(false);
		setLocation(800, 350);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(null);	

		ImageIcon icon1= new ImageIcon("Ryan.gif");
		JButton btnNewButton = new JButton(icon1);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if((JButton)obj == btnNewButton){
					dto.setCome(1);
					try {
						Client.Insertcome(dto);
						new Room(dto);
						dispose();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}		
				}

			}
		});
		btnNewButton.setBounds(30, 40, 130, 255);
		panel.add(btnNewButton);

		ImageIcon icon2= new ImageIcon("apech.gif");
		JButton btnNewButton_1 = new JButton(icon2);
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if((JButton)obj == btnNewButton_1){
					dto.setCome(2);
					try {
						Client.Insertcome(dto);
						new Room(dto);
						dispose();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}		
				}
			}
		});
		btnNewButton_1.setBounds(184, 40, 130, 255);
		panel.add(btnNewButton_1);

		ImageIcon icon3= new ImageIcon("frood.gif");
		JButton btnNewButton_2 = new JButton(icon3);
		btnNewButton_2.setBackground(Color.WHITE);
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if((JButton)obj == btnNewButton_2){
					dto.setCome(3);
					try {
						Client.Insertcome(dto);
						new Room(dto);
						dispose();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}		
				}
			}
		});
		btnNewButton_2.setBounds(340, 40, 130, 255);
		panel.add(btnNewButton_2);

		ImageIcon icon4= new ImageIcon("green.gif");
		JButton btnNewButton_3 = new JButton(icon4);
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if((JButton)obj == btnNewButton_3){
					dto.setCome(4);
					try {
						Client.Insertcome(dto);
						new Room(dto);
						dispose();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton_3.setBounds(490, 40, 130, 255);
		panel.add(btnNewButton_3);	

		ImageIcon icon5= new ImageIcon("neo.gif");
		JButton button = new JButton(icon5);
		button.setBackground(Color.WHITE);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if((JButton)obj == button){
					dto.setCome(5);
					try {
						Client.Insertcome(dto);
						new Room(dto);
						dispose();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}			
				}
			}
		});
		button.setBounds(640, 40, 130, 255);
		panel.add(button);
		setVisible(true);
	}
}
