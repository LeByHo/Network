package Main;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.util.Random;

import javax.swing.JLabel;

import Client.Client;

class wword extends JLabel implements Runnable {
	int[] Check = {0,0,0,0,0,0,0,0,0,0};
	char[] alphabet = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
			't', 'u', 'v', 'w', 'x', 'y', 'z' };
	String[] wd = new String[10];
	String[] wd1 = new String[10];
	Random rand1 = new Random();
	char[] temp = new char[4];
	char[][] wd2 = new char[10][4];
	char[][] another = new char[10][22];
	char[][] answer = new char[10][4];
	int[] temp2 = new int[4];
	int[] temp3 = new int[4];
	int check = 0;
	int r;
	int a;
	char t;
    static int catego,wlevel;
	wword(){
		try {
			String str = Client.getword();
			String[] wo = str.split(" ");
			String[] wo1= str.split(" ");
			wd=wo;
			wd1=wo1;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Font f2 = new Font("±Ã¼­", Font.BOLD, 20);
		setFont(f2);
		setBounds(234, 356, 708, 70);
		setBackground(new Color(255,255,255,100));
		setOpaque(true);
	}

	public char[][] getanotehr(){
		return another;

	}
	public String[] get(){
		return wd;
	}

	public char[][] getword() {
		return wd2;
	}

	public void setanswer(int p, int v, char a) {
		this.answer[p][v] = a;
	}

	public char getanswer(int w, int p) {
		return answer[p][w];
	}

	public char[][] getan() {
		return answer;
	}

	public char[] gettemp() {
		return temp;
	}
	public int[] check(){
		return Check;
	}

	public void run() {

		int k = 0;
		int i = 0;
		int j = 0;
		int l = 0;
		int u = 0;
		int y =0;
		int n=0;
		while (k < 10) {
			//    	  setBackground(new Color(255,255,255,100));
			i = 0;
			u=0;
			y=0;
			n=0;
			while (i < 4) {
				r = rand1.nextInt(wd[k].length());
				char t = wd[k].charAt(r);
				j = 0;
				while (j < i) {
					if (temp[j] == t) {
						r = rand1.nextInt(wd[k].length());
						j = 0;
						t = wd[k].charAt(r);
					} else
						j++;
				}
				temp2[i] = r;
				temp[i] = wd[k].charAt(r);
				wd1[k] = wd1[k].substring(0, r) + "_" + wd1[k].substring(r + 1);
				i++;
			}
			for (l = 0; l < 4; l++) {
				wd2[k][l] = temp[l];
			}

			setText(wd1[k]);
			for (i = 0; i < 4; i++) {
				for (j = 0; j < 3; j++) {
					if (temp2[j] > temp2[j + 1]) {
						a = temp2[j];
						temp2[j] = temp2[j + 1];
						temp2[j + 1] = a;
						t = temp[j];
						temp[j] = temp[j + 1];
						temp[j + 1] = t;
					}
				}
			}
			i=0;

			while (i < 22) {
				j = 0;
				u=0;
				r = rand1.nextInt(alphabet.length);
				char t = alphabet[r];
				while(u<i){
					if (another[k][u] == t) {
						r = rand1.nextInt(alphabet.length);
						u = 0;
						t = alphabet[r];
					} else
						u++;
				}
				while (j < 4) {
					if (wd2[k][j] == t) {
						r = rand1.nextInt(alphabet.length);
						j = 0;
						t = alphabet[r];
					} else
						j++;
				}
				another[k][i] = t;
				i++;
			}

			try {
				Thread.sleep(11000);
			} catch (Exception ex) {
			}
			k++;
		}
	}

}