package nerdle;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Home {
	private JFrame frame;

	public JFrame getFrame() {
		return frame;
	}
	public Home() throws IOException {
		
		TestEq testEq = new TestEq();
		//Functions function = new Functions();
		//String x = function.generateEquation();
		//function.setChosenEq(x);
		//System.out.println(x);
		//StopWatch stopWatch = new StopWatch();
		Gui gui = new Gui();
		Statistics statistic = new Statistics(); 
		
		frame = new JFrame("Nerdle");

		JPanel panel = new JPanel();
		
		JLabel l1 = new JLabel();
		l1.setText("18 - 17011071 Hatice Demir - 17011057 Tarık Aytek");
		l1.setBounds(160, 0, 300, 30);
				
		JLabel l3 = new JLabel();
		l3.setText("Oyun İstatistikleri");
		l3.setFont(new Font("Serif", Font.BOLD, 20));
		l3.setForeground(Color.darkGray);
		l3.setBounds(215, 250, 300, 30);
		
		JLabel l4 = new JLabel();
		l4.setText("Ortalama süre: ");
		l4.setBounds(180, 300, 300, 30);
		
		JLabel l5 = new JLabel();
		l5.setText("Ortalama satır sayısı: ");
		l5.setBounds(180, 330, 300, 30);
		
		JLabel l6 = new JLabel();
		l6.setText("Yarıda bırakılan oyunlar: ");
		l6.setBounds(180, 360, 300, 30);
		
		JLabel l7 = new JLabel();
		l7.setText("Başarıyla sonuçlanan oyunlar: ");
		l7.setBounds(180, 390, 300, 30);
		
		JLabel l8 = new JLabel();
		l8.setText("Başarısızlıkla sonuçlanan oyunlar: ");
		l8.setBounds(180, 420, 300, 30);
		
		JLabel l9 = new JLabel();
		//l9.setText(statistic.getLine(0));
		l9.setBounds(390, 300, 50, 30);
		
		JLabel l10 = new JLabel();
		l10.setText(statistic.getLine(3));
		l10.setBounds(390, 330, 50, 30);
		
		JLabel l11 = new JLabel();
		l11.setText(statistic.getLine(0));
		l11.setBounds(390, 360, 50, 30);
		
		JLabel l12 = new JLabel();
		l12.setText(statistic.getLine(2));
		l12.setBounds(390, 390, 50, 30);
		
		JLabel l13 = new JLabel();
		l13.setText(statistic.getLine(1));
		l13.setBounds(390, 420, 50, 30);
		
		JButton buton1 = new JButton();
		buton1.setText("Yeni Oyun");
		buton1.setBounds(220, 80, 150, 40);
		
		JButton buton2 = new JButton();
		buton2.setText("Devam Et");
		buton2.setBounds(220, 130, 150, 40);
		
		JButton buton3 = new JButton();
		buton3.setText("Test");
		buton3.setBounds(220, 180, 150, 40);
		
		buton1.addActionListener(new ActionListener() { //switches to yeni oyun screen
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false); //turns off the home screen
				//function.generateEquation();
				try {
					if(statistic.isThereSavedGame()) {
						statistic.setLine(0);
						statistic.deleteSavedGame();
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				gui.getFrame().setVisible(true); //opens the yeni oyun screen
				StopWatch stopWatch = new StopWatch();
				stopWatch.start(); //starts the clock
				
			}
		});
		
		buton2.addActionListener(new ActionListener() { //starts the game if there is an interrupted game
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if(statistic.isThereSavedGame()) {
						frame.setVisible(false); //turns off the home screen
						//frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
						//Eski saati devam ettir kaldığı yerden
						//filedan eski oyunun bilgilerini oku oyunu devam ettir
						try {
							 String[] array = statistic.continueSavedGame(); //String[] döndü
							 gui.getFrame().setVisible(true);
							 gui.getFunction().setChosenEq(statistic.getSavedEquation());
							 for(String arrayy: array) {
								 if(!arrayy.equals("0")) {
									 for(int a=0; a<arrayy.length(); a++) {
										// gui.getFunction().setChosenEq(statistic.getSavedEquation());
										 gui.getCell().getMatrix()[gui.getI()][gui.getJ()].setText(Character.toString(arrayy.charAt(a)));
										// gui.getFunction().setChosenEq(statistic.getSavedEquation());
										 int[] check = gui.getFunction().check(String.valueOf(arrayy), gui.getFunction().getChosenEq());
										 for(int k=0; k<check.length; k++) {
											 if(check[k] == 0) { // not in the chosenEq
													gui.getCell().getMatrix()[gui.getI()][gui.getJ()].setBackground(Color.red);
												}
											else if(check[k] == 1) { //chosenEq'te bulunuyor, yeri yanlış
												gui.getCell().getMatrix()[gui.getI()][gui.getJ()].setBackground(Color.yellow);
											}
											else if(check[k] == 2) { //in the chosenEq but in the wrong place
												gui.getCell().getMatrix()[gui.getI()][gui.getJ()].setBackground(Color.green);
												gui.setCount(gui.getCount()+1);
											}
										 }
										 gui.setJ(gui.getJ()+1);
									 }
									 gui.setI(gui.getI()+1);
									 gui.setJ(0);
								 }
							 }
							// gui.setI(gui.getI()+1);
							 gui.setJ(0);
							 gui.setBasildi(gui.getCell().getMatrix()[gui.getI()][gui.getJ()]); 
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
						
				
			}
		});
		
		buton3.addActionListener(new ActionListener() { //new equation generation screen
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false); ////turns off the home screen
				//rame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
				testEq.getFrame().setVisible(true); ////opens the testEq screen
			}
		});
		
		frame.add(buton1);
		frame.add(buton2);
		frame.add(buton3);
		
		frame.add(l1);
		//frame.add(l2);
		frame.add(l3);
		frame.add(l4);
		frame.add(l5);
		frame.add(l6);
		frame.add(l7);
		frame.add(l8);
		frame.add(l9);
		frame.add(l10);
		frame.add(l11);
		frame.add(l12);
		frame.add(l13);

		frame.add(panel);
		frame.setSize(600, 600);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
