package fr.quarto;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Paint;

import javax.swing.JPanel;

public class Case extends JPanel{
	private boolean selectionnee;
	public Case(){
		setLayout(new GridLayout(1,0));
		setBackground(Color.LIGHT_GRAY);
		setForeground(Color.LIGHT_GRAY);
	}
	
	public void setSelectionnee(boolean selectionnee) {
		this.selectionnee = selectionnee;
		if(selectionnee){
			setBackground(Color.BLUE);
			setForeground(Color.LIGHT_GRAY);
		}
		else {
			initCouleur();
		}
	}

	private void initCouleur(){
			setBackground(Color.LIGHT_GRAY);
			setForeground(Color.LIGHT_GRAY);
		}

	@Override
	public void paintComponent(Graphics g){
		Paint paint;
		Graphics2D g2d;
		if (g instanceof Graphics2D) {
			g2d = (Graphics2D) g;
		}
		else {
			System.out.println("Error");
			return;
		}
		paint = new GradientPaint(0,0, getBackground(), getWidth(), getHeight(), getForeground());
		g2d.setPaint(paint);
		g.fillRect(0, 0, getWidth(), getHeight());
	}

	public boolean isSelectionnee() {
		// TODO Auto-generated method stub
		return selectionnee;
	}
	}
	

