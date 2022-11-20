package nerdle;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.*; //File operation


public class Gui {

	//private int size;
	public int i =0, j=0;
	private JButton basildi;
	private Timer swingtimer;
	private char[] input;
	private JFrame frame;
	private String[] savedInput;
	private int rowNumber;
	private Cell cell;
	private Functions function;
	private int count;
	private String oldEq;
	private int sure=0;
	
	
	public String getOldEq() {
		return oldEq;
	}



	public void setOldEq(String oldEq) {
		this.oldEq = oldEq;
	}



	public int getCount() {
		return count;
	}



	public void setCount(int count) {
		this.count = count;
	}



	public Functions getFunction() {
		return function;
	}



	public void setFunction(Functions function) {
		this.function = function;
	}



	public Cell getCell() {
		return cell;
	}



	public void setCell(Cell cell) {
		this.cell = cell;
	}



	public JFrame getFrame() {
		return frame;
	}

	
	
	public JButton getBasildi() {
		return basildi;
	}



	public void setBasildi(JButton basildi) {
		this.basildi = basildi;
	}



	public int getI() {
		return i;
	}



	public void setI(int i) {
		this.i = i;
	}



	public int getJ() {
		return j;
	}



	public void setJ(int j) {
		this.j = j;
	}

	

	public Gui() {
		
			
			
	/*File file = new File("istatistik.txt"); 

	if(!file.exists()) {
		try {
			file.createNewFile();
		} 
		catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
	}*/
		
		
	frame = new JFrame("Nerdle");

	JPanel panel = new JPanel();

	JLabel l1 = new JLabel();
	l1.setText("18 - 17011071 Hatice Demir - 17011057 Tarık Aytek");
	l1.setBounds(160, 0, 300, 30);
	//l1.setText("Butona tıkladın");
	
	function = new Functions();
	
	String x = function.generateEquation();
	oldEq = x;
	function.setChosenEq(x);
	System.out.println(x);
	
	input = new char[x.length()];
	savedInput = new String[5];

	for(int i=0; i<x.length(); i++) {
		input[i] = ' ';
	}

	for(int a=0; a<5; a++) {
		savedInput[a] = "0";
	}
	
	
	cell = new Cell(x.length(), frame);
	StopWatch stopWatch = new StopWatch();
	Statistics statistic = new Statistics();
	/*try {
		statistic.createFile();
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}*/
	
	basildi = new JButton();	
	basildi = cell.getMatrix()[i][j];

	// buton.setBounds(x, y, width, height)
	JButton buton1 = new JButton();
	buton1.setText("0");
	buton1.setBounds(50, 400, 40, 30);
		
	JButton buton2 = new JButton();
	buton2.setText("1");
	buton2.setBounds(95, 400, 40, 30);
		
	JButton buton3 = new JButton();
	buton3.setText("2");
	buton3.setBounds(140, 400, 40, 30);
		
	JButton buton4 = new JButton();
	buton4.setText("3");
	buton4.setBounds(185, 400, 40, 30);
		
	JButton buton5 = new JButton();
	buton5.setText("4");
	buton5.setBounds(230, 400, 40, 30);
	
	JButton buton6 = new JButton();
	buton6.setText("5");
	buton6.setBounds(275, 400, 40, 30);
		
	JButton buton7 = new JButton();
	buton7.setText("6");
	buton7.setBounds(320, 400, 40, 30);
		
	JButton buton8 = new JButton();
	buton8.setText("7");
	buton8.setBounds(365, 400, 40, 30);
		
	JButton buton9 = new JButton();
	buton9.setText("8");
	buton9.setBounds(410, 400, 40, 30);
		
	JButton buton10 = new JButton();
	buton10.setText("9");
	buton10.setBounds(455, 400, 40, 30);
	
	JButton buton11 = new JButton();
	buton11.setText("+");
	buton11.setBounds(50, 440, 50, 30);
	
	JButton buton12 = new JButton();
	buton12.setText("-");
	buton12.setBounds(105, 440, 50, 30);
	
	JButton buton13 = new JButton();
	buton13.setText("*");
	buton13.setBounds(160, 440, 50, 30);
	
	JButton buton14 = new JButton();
	buton14.setText("/");
	buton14.setBounds(215, 440, 50, 30);
	
	JButton buton15 = new JButton();
	buton15.setText("=");
	buton15.setBounds(270, 440, 50, 30);
	
	JButton buton16 = new JButton();
	buton16.setText("Enter");
	buton16.setBounds(325, 440, 84, 30);
	
	JButton buton17 = new JButton();
	buton17.setText("Delete");
	buton17.setBounds(414, 440, 84, 30);
	
	JButton buton18 = new JButton();
	buton18.setText("After");
	buton18.setBounds(414, 480, 84, 30);
	
	/*JButton buton19 = new JButton();
	buton19.setText("Home");
	buton19.setBounds(10, 10, 70, 30);*/
	
	buton1.addActionListener(new ActionListener() { // 0
		@Override
		public void actionPerformed(ActionEvent e) {
			if(basildi!=null) {
				basildi.setText(buton1.getText());
				if(j<x.length()-1) {
					j++;
				}
				basildi = cell.getMatrix()[i][j];
			}
			
		}
	});
	
	buton2.addActionListener(new ActionListener() { // 1
		@Override
		public void actionPerformed(ActionEvent e) {
			if(basildi!=null) {
				basildi.setText(buton2.getText());
				if(j<x.length()-1) {
					j++;
				}
				basildi = cell.getMatrix()[i][j];
			}
		}
	});
	
	buton3.addActionListener(new ActionListener() { // 2
		@Override
		public void actionPerformed(ActionEvent e) {
			if(basildi!=null) {
				basildi.setText(buton3.getText());
				if(j<x.length()-1) {
					j++;
				}
				basildi = cell.getMatrix()[i][j];
			}
		}

	});
	
	buton4.addActionListener(new ActionListener() { // 3
		@Override
		public void actionPerformed(ActionEvent e) {
			if(basildi!=null) {
				basildi.setText(buton4.getText());
				if(j<x.length()-1) {
					j++;
				}
				basildi = cell.getMatrix()[i][j];
			}
		}
	});
	
	buton5.addActionListener(new ActionListener() { // 4
		@Override
		public void actionPerformed(ActionEvent e) {
			if(basildi!=null) {
				basildi.setText(buton5.getText());
				if(j<x.length()-1) {
					j++;
				}
				basildi = cell.getMatrix()[i][j];
			}
		}
	});
	
	buton6.addActionListener(new ActionListener() { // 5
		@Override
		public void actionPerformed(ActionEvent e) {
			if(basildi!=null) {
				basildi.setText(buton6.getText());
				if(j<x.length()-1) {
					j++;
				}
				basildi = cell.getMatrix()[i][j];
			}
		}
	});
	
	buton7.addActionListener(new ActionListener() { // 6
		@Override
		public void actionPerformed(ActionEvent e) {
			if(basildi!=null) {
				basildi.setText(buton7.getText());
				if(j<x.length()-1) {
					j++;
				}
				basildi = cell.getMatrix()[i][j];
			}
		}
	});
	
	buton8.addActionListener(new ActionListener() { // 7
		@Override
		public void actionPerformed(ActionEvent e) {
			if(basildi!=null) {
				basildi.setText(buton8.getText());
				if(j<x.length()-1) {
					j++;
				}
				basildi = cell.getMatrix()[i][j];
			}
		}
	});
	
	buton9.addActionListener(new ActionListener() { // 8
		@Override
		public void actionPerformed(ActionEvent e) {
			if(basildi!=null) {
				basildi.setText(buton9.getText());
				if(j<x.length()-1) {
					j++;
				}
				basildi = cell.getMatrix()[i][j];
			}
		}
	});
	
	buton10.addActionListener(new ActionListener() { // 9
		@Override
		public void actionPerformed(ActionEvent e) {
			if(basildi!=null) {
				basildi.setText(buton10.getText());
				if(j<x.length()-1) {
					j++;
				}
				basildi = cell.getMatrix()[i][j];
			}
		}
	});
	
	buton11.addActionListener(new ActionListener() { // +
		@Override
		public void actionPerformed(ActionEvent e) {
			if(basildi!=null) {
				basildi.setText(buton11.getText());
				if(j<x.length()-1) {
					j++;
				}
				basildi = cell.getMatrix()[i][j];
			}
		}
	});
	
	buton12.addActionListener(new ActionListener() { // -
		@Override
		public void actionPerformed(ActionEvent e) {
			if(basildi!=null) {
				basildi.setText(buton12.getText());
				if(j<x.length()-1) {
					j++;
				}
				basildi = cell.getMatrix()[i][j];
			}
		}
	});
	
	buton13.addActionListener(new ActionListener() { // *
		@Override
		public void actionPerformed(ActionEvent e) {
			if(basildi!=null) {
				basildi.setText(buton13.getText());
				if(j<x.length()-1) {
					j++;
				}
				basildi = cell.getMatrix()[i][j];
			}
		}
	});
	
	buton14.addActionListener(new ActionListener() { // /
		@Override
		public void actionPerformed(ActionEvent e) {
			if(basildi!=null) {
				basildi.setText(buton14.getText());
				if(j<x.length()-1) {
					j++;
				}
				basildi = cell.getMatrix()[i][j];
			}
		}
	});
	
	buton15.addActionListener(new ActionListener() { // =
		@Override
		public void actionPerformed(ActionEvent e) {
			if(basildi!=null) {
				basildi.setText(buton15.getText());
				if(j<x.length()-1) {
					j++;
				}
				basildi = cell.getMatrix()[i][j];
			}
		}
	});
	
	buton16.addActionListener(new ActionListener() { //Enter
		@Override
		public void actionPerformed(ActionEvent e) {
			for(int k=0; k<x.length(); k++) { //values entered by the gamer is put in input[] char by char
				if(cell.getMatrix()[i][k].getText() != " ") {
					input[k] = cell.getMatrix()[i][k].getText().charAt(0);
				}
				else { //if the gamer has not entered a value in that cell, that cell is assigned a space character 
					input[k] = ' ';
				}
			}
			boolean isValid = function.isValidEq(String.valueOf(input)); //Check if the input string is a valid string
			//l2.setText(String.valueOf(input) + isValid);
			if(isValid) {
				rowNumber++;
				count=0; //Incremented for each character whose locations are known correctly
				//chosenEq and input are compared
				//return is an int array
				int[] check = function.check(String.valueOf(input), function.getChosenEq());
				for(int k=0; k<check.length; k++) {
					if(check[k] == 0) { // not in the chosenEq
						cell.getMatrix()[i][k].setBackground(Color.red);
					}
					else if(check[k] == 1) { //chosenEq'te bulunuyor, yeri yanlış
						cell.getMatrix()[i][k].setBackground(Color.yellow);
					}
					else if(check[k] == 2) { //in the chosenEq but in the wrong place
						cell.getMatrix()[i][k].setBackground(Color.green);
						count++;
					}
					cell.getMatrix()[i][k].setEnabled(false); //No further operations can be performed on the row.
					//basildi = cell.getMatrix()[i][j];
				}
				if(count == x.length()) { //if count equals size then guess is correct
					buton18.setEnabled(false);
					//Tebrikler, kazandınız
					//File işlemleri
					//File file = new File("istatistik.txt"); if(!file.exists()) {
					//file.createNewFile(); }
					basildi = null;
					try {
						statistic.setLine(2);
						statistic.setLine(3, rowNumber);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					System.out.println("kazandınız");
					//statistic.setLine(2, );
				}
				else {
					if(i<5) { //If the line index is less than 5 
						int b=0;
						for(String savedInput: savedInput) {
							if(savedInput != "0") {
								b++;
							}
						}
						savedInput[b] = String.valueOf(input);
						i++; //the next line is passed
						j=0; //go to first column
						basildi = cell.getMatrix()[i][j];
						for(int i=0; i<x.length(); i++) { //input resets
							input[i] = ' ';
						}
					}
					else { //the last line has been reached but the correct guess could not be made
						//kaybettiniz
						//Denklem gösterilir
						basildi = null;
						//System.out.println();
						System.out.println("kaybettiniz");
						try {
							statistic.setLine(1);
							
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			
			}			
			else { //throw a pop-up
				JLabel l = new JLabel("That guess doesn't compute!");
				PopupFactory pf = new PopupFactory();
				JPanel p2 = new JPanel();
				p2.setBackground(Color.pink);
				p2.add(l);
				Popup p = pf.getPopup(frame, p2, 400, 450);
				p.show();
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				p.hide();
				
			}
			for(String savedInput: savedInput) {
				System.out.println(savedInput);
			}
		}
	});
	
	buton17.addActionListener(new ActionListener() { //Delete
		@Override
		public void actionPerformed(ActionEvent e) {
			if(cell.getMatrix()[i][j].isEnabled()) {
				if(j>0 && (cell.getMatrix()[i][j].getText() == " ")) {
					j--;
					basildi = cell.getMatrix()[i][j];
				}
				cell.getMatrix()[i][j].setText(" ");
			}
			
		}
	});
	
	buton18.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			//cell.getMatrix()[0][0].setText("A");
			try {
				statistic.saveGame(savedInput, oldEq);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	});
	
	/*buton19.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			//cell.getMatrix()[0][0].setText("H");
			frame.setVisible(false);
			home.getFrame().setVisible(true);
			
		}
	});	*/
	
	cell.getMatrix()[i][0].addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			//cell.getMatrix()[0][0].setOpaque(false);
			//cell.getMatrix()[0][0].setOpaque(true);
			//cell.getMatrix()[0][0].setText(x);
			basildi = cell.getMatrix()[i][0];
			j = 0;
		}
	});
	
	cell.getMatrix()[i][1].addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			basildi = cell.getMatrix()[i][1];
			j = 1;
		}
	});
	
	cell.getMatrix()[i][2].addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			basildi = cell.getMatrix()[i][2];
			j=2;
		}
	});	
	
	cell.getMatrix()[i][3].addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			basildi = cell.getMatrix()[i][3];
			 j=3;
		}
	});
	
	cell.getMatrix()[i][4].addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			basildi = cell.getMatrix()[i][4];
			j=4;
		}
	});
	
	cell.getMatrix()[i][5].addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			basildi = cell.getMatrix()[i][5];
			j=5;
		}
	});
	
	cell.getMatrix()[i][6].addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			basildi = cell.getMatrix()[i][6];
			j=6;
		}
	});
	
	if(x.length()==8) {
		cell.getMatrix()[i][7].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				basildi = cell.getMatrix()[i][7];
				j=7;
			}
		});
	}
	
	if(x.length()==9) {
		cell.getMatrix()[i][8].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				basildi = cell.getMatrix()[i][8];
				j=8;
			}
		});
	}
	
	
		
	frame.add(buton1);
	frame.add(buton2);
	frame.add(buton3);
	frame.add(buton4);
	frame.add(buton5);
	frame.add(buton6);
	frame.add(buton7);
	frame.add(buton8);
	frame.add(buton9);
	frame.add(buton10);
	frame.add(buton11);
	frame.add(buton12);
	frame.add(buton13);
	frame.add(buton14);
	frame.add(buton15);
	frame.add(buton16);
	frame.add(buton17);
	frame.add(buton18);
	//frame.add(buton19);
	//frame.add(label);
	
	frame.add(stopWatch.timeLabel);
	
	frame.add(l1);
	
	frame.add(panel);
	frame.setSize(600, 600);
	frame.setLayout(null);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(false);
	}
	
	public void continue_(String array[]) {
		int i = j = 0;
		for(String arrayy: array) {
			for(int a=0; i<arrayy.length(); i++) {
				arrayy.charAt(a);
				
			}
			
		}
	}

	public char[] getInput() {
		return input;
	}

	

	
}