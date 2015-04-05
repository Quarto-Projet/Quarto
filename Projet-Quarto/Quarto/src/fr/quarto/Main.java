package fr.quarto;

import javax.swing.JFrame;
import javax.swing.UIManager;

public class Main {
	public static void main(String[] args) {
		try{
		    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		}
		catch(Exception e){}
		
		JFrame f = new JFrame();
		f.setSize(600, 600);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(new Jeu(false));
		f.setVisible(true);
		}
}
