package Main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

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
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import javax.swing.JSplitPane;
import javax.swing.border.LineBorder;

public class Room extends JFrame {
	private JPanel contentPane;
	DTO dto = new DTO();
	static String name;
	static int age;
	static String id;
	static String password;
	static int come;
	private JPanel panel_1;
	String str;

	public Room(DTO dto) throws IOException {
		name = dto.getName();
		age = dto.getAge();
		id = dto.getId();
		password = dto.getPassword();
		come = dto.getCome();
		setTitle("VOCA POP");
		setSize(1100, 900);
		setResizable(false);
		setLocation(0, 0);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new MyListene(this));
		ImageIcon icon = new ImageIcon("background.png");
		Image originImg = icon.getImage();
		Image changedImg = originImg.getScaledInstance(1100, 870, Image.SCALE_SMOOTH);
		ImageIcon Icon = new ImageIcon(changedImg);
		// panel
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

	public void placeLoginPanel(JPanel panel) throws IOException {
		dto.setName(name);
		dto.setAge(age);
		dto.setId(id);
		dto.setPassword(password);
		dto.setCome(come);
		panel.setLayout(null);
		// Dimension dim = new Dimension(700,700);
		Color color = new Color(255, 0, 0);

		ImageIcon icon = new ImageIcon("a.jpg");
		number a = new number(dto);
		new Thread(a).start();
		panel.add(a);

		JPanel info = new JPanel();
		info.setLayout(null);
		info.setLayout(null);
		info.setBounds(780, 230, 250, 300);
		switch (come) {
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
		Image changedImg = originImg.getScaledInstance(250, 250, Image.SCALE_SMOOTH);
		ImageIcon Icon = new ImageIcon(changedImg);
		JPanel picture = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(Icon.getImage(), 0, 0, null);
				setOpaque(false);// 배경 띄워주기
				super.paintComponent(g);
			}
		};
		picture.setBorder(new LineBorder(new Color(0, 0, 0), 3));

		JSplitPane splitPane = new JSplitPane();
		splitPane.setBounds(0, 251, 250, 49);
		picture.setBounds(0, 0, 250, 250);
		info.add(picture);
		info.add(splitPane);
		splitPane.setDividerLocation(100);
		JLabel lblNewLabel = new JLabel("이름", JLabel.CENTER);
		splitPane.setLeftComponent(lblNewLabel);
		JLabel lblNewLabel_1 = new JLabel(name, JLabel.CENTER);
		splitPane.setRightComponent(lblNewLabel_1);

		panel.add(info);

		JButton btn = new JButton("MY ROOM");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object obj = arg0.getSource();
				if ((JButton) obj == btn) {
					new Myroom();
				}
			}
		});
		btn.setBounds(780, 630, 250, 95);
		panel.add(btn);

		JButton btn2 = new JButton("MY BOOK");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object obj = arg0.getSource();
				if ((JButton) obj == btn2) {
					Mybook frame = new Mybook();
				}
			}
		});
		btn2.setBounds(780, 725, 250, 95);
		panel.add(btn2);

		JButton left = new JButton(new ImageIcon("d.jpg"));
		left.setBounds(380, 570, 50, 50);
		panel.add(left);
		JButton right = new JButton(new ImageIcon("e.jpg"));
		right.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		right.setBounds(280, 570, 50, 50);
		panel.add(right);

		JScrollPane scrollPane = new JScrollPane(); // 스크롤 구현
		scrollPane.setBounds(20, 630, 700, 140);
		panel_1.add(scrollPane);

		JTextArea message = new JTextArea();
		scrollPane.setViewportView(message);
		message.setBackground(Color.CYAN);

		JTextField userText = new JTextField();
		userText.setBounds(20, 770, 702, 50);
		panel.add(userText);
	}

	void action(JButton btn) {
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object obj = arg0.getSource();
				if ((JButton) obj == btn) {
					new Chattroom(dto);
				}
			}
		});
	}
}

class number extends JPanel implements Runnable {
	DTO dto;
	String[] arr = { "0", "0", "0", "0", "0", "0", "0", "0", "0" };
	String str;
	JButton btnInit1;
	JButton btnInit2;
	JButton btnInit3;
	JButton btnInit4;
	JButton btnInit5;
	JButton btnInit6;
	JButton btnInit7;
	JButton btnInit8;
	JButton btnInit9;
	Split split1;
	Split split2;
	Split split3;
	Split split4;
	Split split5;
	Split split6;
	Split split7;
	Split split8;
	Split split9;
	int count = 0;
	Object obj;

	number(DTO dto) {
		setLayout(null);
		setBounds(20, 20, 700, 500);
		setOpaque(false);
		btnInit1 = new JButton();
		btnInit1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				obj = arg0.getSource();
				if ((JButton) obj == btnInit1) {

					try {
						Client.InsertRoom("room1");
						new Make(dto, 1);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});
		btnInit1.setBounds(0, 0, 200, 150);
		this.add(btnInit1);
		btnInit2 = new JButton();
		btnInit2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				obj = arg0.getSource();
				if ((JButton) obj == btnInit2) {

					try {
						Client.InsertRoom("room2");
						new Make(dto, 2);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});
		btnInit2.setBounds(210, 0, 200, 150);
		this.add(btnInit2);
		btnInit3 = new JButton();
		btnInit3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				obj = arg0.getSource();
				if ((JButton) obj == btnInit3) {

					try {
						Client.InsertRoom("room3");
						new Make(dto, 3);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});
		btnInit3.setBounds(420, 0, 200, 150);
		this.add(btnInit3);
		btnInit4 = new JButton();
		btnInit4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				obj = arg0.getSource();
				if ((JButton) obj == btnInit4) {

					try {
						Client.InsertRoom("room4");
						new Make(dto, 4);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});
		btnInit4.setBounds(0, 160, 200, 150);
		this.add(btnInit4);
		btnInit5 = new JButton("");
		btnInit5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				obj = arg0.getSource();
				if ((JButton) obj == btnInit5) {

					try {
						Client.InsertRoom("room5");
						new Make(dto, 5);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});
		btnInit5.setBounds(210, 160, 200, 150);
		this.add(btnInit5);
		btnInit6 = new JButton();
		btnInit6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				obj = arg0.getSource();
				if ((JButton) obj == btnInit6) {

					try {
						Client.InsertRoom("room6");
						new Make(dto, 6);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});
		btnInit6.setBounds(420, 160, 200, 150);
		this.add(btnInit6);
		btnInit7 = new JButton();
		btnInit7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				obj = arg0.getSource();
				if ((JButton) obj == btnInit7) {

					try {
						Client.InsertRoom("room7");
						new Make(dto, 7);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});
		btnInit7.setBounds(0, 320, 200, 150);
		this.add(btnInit7);
		btnInit8 = new JButton();
		btnInit8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				obj = arg0.getSource();
				if ((JButton) obj == btnInit8) {

					try {
						Client.InsertRoom("room8");
						new Make(dto, 8);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});
		btnInit8.setBounds(210, 320, 200, 150);
		this.add(btnInit8);
		btnInit9 = new JButton();
		btnInit9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				obj = arg0.getSource();
				if ((JButton) obj == btnInit9) {

					try {
						Client.InsertRoom("room9");
						new Make(dto, 9);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});
		btnInit9.setBounds(420, 320, 200, 150);
		this.add(btnInit9);
		this.dto = dto;
		split1 = new Split(dto, 1, 0, 0);
		split2 = new Split(dto, 2, 210, 0);
		split3 = new Split(dto, 3, 420, 0);
		split4 = new Split(dto, 4, 0, 160);
		split5 = new Split(dto, 5, 210, 160);
		split6 = new Split(dto, 6, 420, 160);
		split7 = new Split(dto, 7, 0, 320);
		split8 = new Split(dto, 8, 210, 320);
		split9 = new Split(dto, 9, 420, 320);
	}

	public void setroom1(int b) {
		if (b == 0) {
			btnInit1.setVisible(true);
			btnInit1.setText("생성하기");
			split1.setVisible(false);
			btnInit1.setEnabled(true);
		} else if (b == 4) {
			btnInit1.setVisible(true);
			split1.setVisible(false);
			btnInit1.setText(" ");
			btnInit1.setEnabled(false);
		} else {
			split1.setVisible(true);
			btnInit1.setVisible(false);
			this.add(split1);
		}
	}

	public void setroom2(int b) {
		if (b == 0) {
			btnInit2.setVisible(true);
			btnInit2.setText("생성하기");
			split2.setVisible(false);
			btnInit2.setEnabled(true);
		} else if (b == 4) {
			btnInit2.setVisible(true);
			split2.setVisible(false);
			btnInit2.setText(" ");
			btnInit2.setEnabled(false);
		} else {
			split2.setVisible(true);
			btnInit2.setVisible(false);
			this.add(split2);
		}
	}
	
	public void setroom3(int b) {
		if (b == 0) {
			btnInit3.setVisible(true);
			btnInit3.setText("생성하기");
			split3.setVisible(false);
			btnInit3.setEnabled(true);
		} else if (b == 4) {
			btnInit3.setVisible(true);
			split3.setVisible(false);
			btnInit3.setText(" ");
			btnInit3.setEnabled(false);
		} else {
			split3.setVisible(true);
			btnInit3.setVisible(false);
			this.add(split3);
		}
	}
	public void setroom4(int b) {
		if (b == 0) {
			btnInit4.setVisible(true);
			btnInit4.setText("생성하기");
			btnInit4.setEnabled(true);
			split4.setVisible(false);
		} else if (b == 4) {
			btnInit4.setVisible(true);
			split4.setVisible(false);
			btnInit4.setText(" ");
			btnInit4.setEnabled(false);
		} else {
			split4.setVisible(true);
			btnInit4.setVisible(false);
			this.add(split4);
		}
	}
	public void setroom5(int b) {
		if (b == 0) {
			btnInit5.setVisible(true);
			btnInit5.setText("생성하기");
			split5.setVisible(false);
			btnInit5.setEnabled(true);
		} else if (b == 4) {
			btnInit5.setVisible(true);
			split5.setVisible(false);
			btnInit5.setText(" ");
			btnInit5.setEnabled(false);
		} else {
			split5.setVisible(true);
			btnInit5.setVisible(false);
			this.add(split5);
		}
	}
	public void setroom6(int b) {
		if (b == 0) {
			btnInit6.setVisible(true);
			btnInit6.setText("생성하기");
			split6.setVisible(false);
			btnInit6.setEnabled(true);
		} else if (b == 4) {
			btnInit6.setVisible(true);
			split6.setVisible(false);
			btnInit6.setText(" ");
			btnInit6.setEnabled(false);
		} else {
			split6.setVisible(true);
			btnInit6.setVisible(false);
			this.add(split6);
		}
	}
	public void setroom7(int b) {
		if (b == 0) {
			btnInit7.setVisible(true);
			btnInit7.setText("생성하기");
			split7.setVisible(false);
			btnInit7.setEnabled(true);
		} else if (b == 4) {
			btnInit7.setVisible(true);
			split7.setVisible(false);
			btnInit7.setText(" ");
			btnInit7.setEnabled(false);
		} else {
			split7.setVisible(true);
			btnInit7.setVisible(false);
			this.add(split7);
		}
	}
	public void setroom8(int b) {
		if (b == 0) {
			btnInit8.setVisible(true);
			btnInit8.setText("생성하기");
			split8.setVisible(false);
			btnInit8.setEnabled(true);
		} else if (b == 4) {
			btnInit8.setVisible(true);
			split8.setVisible(false);
			btnInit8.setText(" ");
			btnInit8.setEnabled(false);
		} else {
			split8.setVisible(true);
			btnInit8.setVisible(false);
			this.add(split8);
		}
	}
	public void setroom9(int b) {
		if (b == 0) {
			btnInit9.setVisible(true);
			btnInit9.setText("생성하기");
			split9.setVisible(false);
			btnInit9.setEnabled(true);
		} else if (b == 4) {
			btnInit9.setVisible(true);
			split9.setVisible(false);
			btnInit9.setText(" ");
			btnInit9.setEnabled(false);
		} else {
			split9.setVisible(true);
			btnInit9.setVisible(false);
			this.add(split9);
		}
	}

	public void run() {
		while (true) {
			try {
				str = Client.GetRoomCount();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			arr = str.split(" ");
			setroom1(Integer.parseInt(arr[0]));
			setroom2(Integer.parseInt(arr[1]));
			setroom3(Integer.parseInt(arr[2]));
			setroom4(Integer.parseInt(arr[3]));
			setroom5(Integer.parseInt(arr[4]));
			setroom6(Integer.parseInt(arr[5]));
			setroom7(Integer.parseInt(arr[6]));
			setroom8(Integer.parseInt(arr[7]));
			setroom9(Integer.parseInt(arr[8]));
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}
		}
	}
}

class Split extends JSplitPane {
	Split(DTO dto, int i, int x, int y) {
		setBounds(x, y, 200, 150);
		setOrientation(JSplitPane.VERTICAL_SPLIT);
		setDividerLocation(80);
		JLabel lblNewLabel = new JLabel("방이름", JLabel.CENTER);
		setLeftComponent(lblNewLabel);
		JButton btn = new JButton("입장하기");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object obj = arg0.getSource();
				if ((JButton) obj == btn) {
					try {
						if (i == 1) {
							Client.InsertRoom("room1");
						} else if (i == 2) {
							Client.InsertRoom("room2");
						} else if (i == 3) {
							Client.InsertRoom("room3");
						} else if (i == 4) {
							Client.InsertRoom("room4");
						} else if (i == 5) {
							Client.InsertRoom("room5");
						} else if (i == 6) {
							Client.InsertRoom("room6");
						} else if (i == 7) {
							Client.InsertRoom("room7");
						} else if (i == 8) {
							Client.InsertRoom("room8");
						} else if (i == 9) {
							Client.InsertRoom("room9");
						}
						Chattroom chat = new Chattroom(dto);
						chat.setRoomnum(i);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		setRightComponent(btn);
	}

}

class MyListene implements WindowListener {
	private Room f;

	MyListene(Room f) {
		this.f = f;
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
		int choice = JOptionPane.showConfirmDialog(f, "종료?", "Confirmation", JOptionPane.YES_NO_OPTION);
		if (choice == 0) {
			try {
				Client.Socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.exit(0);
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