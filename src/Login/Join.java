package Login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Client.Client;
import Client.DTO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Join extends JFrame {
	int check=0;
	DTO dto = new DTO();

	public Join() {
		setTitle("회원가입");
		setSize(360, 320);
		setResizable(false);
		setLocation(800, 350);

		JPanel panel = new JPanel();
		getContentPane().add(panel);
		setVisible(true);
		panel.setLayout(null);	


		JLabel lblNewLabel = new JLabel("Name",JLabel.CENTER);
		lblNewLabel.setBounds(22, 45, 68, 15);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("age",JLabel.CENTER);
		lblNewLabel_1.setBounds(22, 96, 68, 15);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("ID",JLabel.CENTER);
		lblNewLabel_2.setBounds(22, 148, 68, 15);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Password",JLabel.CENTER);
		lblNewLabel_3.setBounds(22, 199, 68, 15);
		panel.add(lblNewLabel_3);

		JTextField textField = new JTextField();
		textField.setBounds(121, 42, 116, 21);
		panel.add(textField);
		textField.setColumns(10);

		JTextField textField_1 = new JTextField();
		textField_1.setBounds(121, 145, 116, 21);
		panel.add(textField_1);
		textField_1.setColumns(10);

		JTextField textField_2 = new JTextField();
		textField_2.setBounds(121, 93, 116, 21);
		panel.add(textField_2);
		textField_2.setColumns(10);

		JPasswordField passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(121, 196, 116, 21);
		panel.add(passwordField_1);

		JButton btnNewButton = new JButton("Join");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str;
				Object obj = e.getSource();
				if((JButton)obj == btnNewButton){
					if(check==0)
						JOptionPane.showMessageDialog(null, "내용을 입력하세요.", "알림", JOptionPane.INFORMATION_MESSAGE);
					else if(check==1){
						try {
							dto.setName(textField.getText());
							dto.setAge(Integer.parseInt(textField_2.getText()));
							dto.setId(textField_1.getText());
							dto.setPassword(passwordField_1.getText());
							if(dto.getName().length()==0||dto.getAge()==0||dto.getId().length()==0||dto.getPassword().length()==0)
								JOptionPane.showMessageDialog(null, "내용을 입력하세요.", "알림", JOptionPane.INFORMATION_MESSAGE);
							else{
								str = Client.Insertinfo(dto);
								if(str.equals("com")){
									JOptionPane.showMessageDialog(null, "가입에 성공했습니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
									dispose();
								}
							}
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
					else
						JOptionPane.showMessageDialog(null, "ID가 이미존재합니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(121, 249, 97, 23);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Check");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if((JButton)obj == btnNewButton_1){
					dto.setId(textField_1.getText());
					if(dto.getId().length()<5)
						JOptionPane.showMessageDialog(null, "ID는 5자 이상입니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
					else{
						try {
							String str = Client.repuId(dto);
							if(str.equals("NULL")){
								JOptionPane.showMessageDialog(null, "ID가 이미존재합니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
								check=2;
							}
							else{
								JOptionPane.showMessageDialog(null, "사용가능한 ID입니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
								check=1;
							}
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
		});
		btnNewButton_1.setBounds(242, 144, 97, 23);
		panel.add(btnNewButton_1);


	}
}
