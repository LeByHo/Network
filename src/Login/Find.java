package Login;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Client.Client;
import Client.DTO;

import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Find extends JFrame{
	DTO dto = new DTO();
	public Find(String str) {
		super(str);
		setSize(360, 460);
		setResizable(false);
		setLocation(800, 350);

		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		getContentPane().add(splitPane, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		panel.setLayout(null);	
		splitPane.setLeftComponent(panel);

		JLabel lblNewLabel = new JLabel("Name",JLabel.CENTER);
		lblNewLabel.setBounds(70, 50, 57, 15);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Age",JLabel.CENTER);
		lblNewLabel_1.setBounds(70, 100, 57, 15);
		panel.add(lblNewLabel_1);

		JTextField textField = new JTextField();
		textField.setBounds(140, 50, 116, 21);
		panel.add(textField);
		textField.setColumns(10);

		JTextField textField_1 = new JTextField();
		textField_1.setBounds(140, 100, 116, 21);
		panel.add(textField_1);
		textField_1.setColumns(10);

		JButton btnNewButton = new JButton("ID 찾기");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object obj = arg0.getSource();
				String str;
				if((JButton)obj == btnNewButton){
					if(textField.getText().length()==0 || textField_1.getText().length()==0)
						JOptionPane.showMessageDialog(null, "정보를 입력하세요.", "알림", JOptionPane.INFORMATION_MESSAGE);
					else{
						try {
							dto.setName(textField.getText());
							dto.setAge(Integer.parseInt(textField_1.getText()));
							textField.setText("");
							textField_1.setText("");
							str = Client.FindId(dto);
							if(str.equals("NULL"))
								JOptionPane.showMessageDialog(null, "ID가 없습니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
							else
								JOptionPane.showMessageDialog(null, str, "알림", JOptionPane.INFORMATION_MESSAGE);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		});
		btnNewButton.setBounds(125, 165, 97, 23);
		panel.add(btnNewButton);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);	
		splitPane.setRightComponent(panel_1);

		JLabel lblNewLabel_2 = new JLabel("ID",JLabel.CENTER);
		lblNewLabel_2.setBounds(70, 35, 57, 15);
		panel_1.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Name",JLabel.CENTER);
		lblNewLabel_3.setBounds(70, 90, 57, 15);
		panel_1.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Age",JLabel.CENTER);
		lblNewLabel_4.setBounds(70, 145, 57, 15);
		panel_1.add(lblNewLabel_4);

		JTextField textField_2 = new JTextField();
		textField_2.setBounds(140, 35, 116, 21);
		panel_1.add(textField_2);
		textField_2.setColumns(10);

		JTextField textField_3 = new JTextField();
		textField_3.setBounds(140, 90, 116, 21);
		panel_1.add(textField_3);
		textField_3.setColumns(10);

		JTextField textField_4 = new JTextField();
		textField_4.setBounds(140, 145, 116, 21);
		panel_1.add(textField_4);
		textField_4.setColumns(10);

		JButton btnNewButton_1 = new JButton("PW 찾기");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				String str;
				if((JButton)obj == btnNewButton_1){
					if(textField_2.getText().length()==0 || textField_3.getText().length()==0 || textField_4.getText().length()==0)
						JOptionPane.showMessageDialog(null, "정보를 입력하세요.", "알림", JOptionPane.INFORMATION_MESSAGE);
					else{
						try {
							dto.setId(textField_2.getText());
							dto.setName(textField_3.getText());
							dto.setAge(Integer.parseInt(textField_4.getText()));
							textField_2.setText("");
							textField_3.setText("");
							textField_4.setText("");
							str = Client.FindPw(dto);
							if(str.equals("NULL"))
								JOptionPane.showMessageDialog(null, "Pw가 없습니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
							else
								JOptionPane.showMessageDialog(null, str, "알림", JOptionPane.INFORMATION_MESSAGE);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
		});

		btnNewButton_1.setBounds(125, 190, 97, 23);
		panel_1.add(btnNewButton_1);
		splitPane.setDividerLocation(200);
		setVisible(true);
	}
}
