package nerdle;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TestEq {
	
	private JFrame frame;
	
	public JFrame getFrame() {
		return frame;
	}

	public TestEq() {
		
		Functions function = new Functions();
		String y = function.generateEquation();
		
		frame = new JFrame("Nerdle"); // Ana frame

		JPanel panel = new JPanel(); // İlk panel
		
		JLabel l1 = new JLabel(); // İlk label
		l1.setText("18 - 17011071 Hatice Demir - 17011057 Tarık Aytek");
		l1.setBounds(160, 0, 300, 30);
		//l1.setText("Butona tıkladın");
		
		/*JLabel l2 = new JLabel(); // İlk label
		l2.setText("17011071 - 17011057");
		l2.setBounds(240, 20, 300, 30);*/
		
		JLabel l3 = new JLabel(); // İlk label
		l3.setText(y);
		l3.setFont(new Font("Serif", Font.BOLD, 30));
		l3.setBounds(225, 200, 500, 80);
		
		JButton buton1 = new JButton();
		buton1.setText("Yeniden Üret");
		buton1.setBounds(200, 370, 190, 50);
		
		/*JButton buton2 = new JButton();
		buton2.setText("Geri");
		buton2.setBounds(10, 10, 60, 30);*/
		
		buton1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String str = function.generateEquation();
				l3.setText(str);
			}
		});
		
		/*buton2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Home
				frame.setVisible(false);
				home.getFrame().setVisible(true);
			}
		});*/
		
		frame.add(buton1);
		//frame.add(buton2);
		frame.add(l1);
		//frame.add(l2);
		frame.add(l3);

		frame.add(panel);
		frame.setSize(600, 600);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(false);
		
	}

}
