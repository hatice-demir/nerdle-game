package nerdle;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.*; //Dosya işlemleri için

public class Cell {

	private int size; // Number of columns
	private JButton[][] matrix; // Matrix for cells
	
	public int getSize() {
		return size;
	}

	public JButton[][] getMatrix() {
		return matrix;
	}

	public Cell(int size, JFrame frame) {
		matrix = new JButton[6][size]; // Initialize the matrix
		this.size = size;
		int x = 80, y = 80;
				
		for(int i=0; i<6; i++) { // 6 rows
			for(int j=0; j<size; j++) { // Equation length columns 
				JButton buton1 = new JButton();
				// buton.setBounds(x, y, width, height)
				buton1.setBounds(x, y, 45, 35);
				buton1.setText(" ");
				buton1.setBackground(Color.gray);
				buton1.setForeground(Color.white);
				x = x+50;
				frame.add(buton1);
				matrix[i][j] = buton1; // Each cell is held in a matrix chamber
			}
			y = y+40;
			x = 80;
		}
	}
}
