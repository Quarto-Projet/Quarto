package fr.quarto;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;

import javax.swing.JPanel;

public class Pion extends JPanel{
	private boolean noir;
	private boolean grand;
	private boolean carre;
	private boolean plein;
	private int taille;
	private boolean place;
	private boolean selectionne;
	public Pion(){
		setOpaque(false);
		setPlace(false);
	}
	public boolean isNoir() {
		return noir;
	}
	public void setNoir(boolean noir) {
		this.noir = noir;
		if(noir){
			setBackground(Color.BLACK);
			setForeground(Color.BLACK);
		}
		else{
			setBackground(Color.WHITE);
			setForeground(Color.WHITE);
		}
	}
	public boolean isGrand() {
		return grand;
	}
	public void setGrand(boolean grand) {
		this.grand = grand;
		if(grand)
			this.setTaille(50);
		else
			this.setTaille(30);
	}
	public boolean isCarre() {
		return carre;
	}
	public void setCarre(boolean carre) {
		this.carre = carre;
	}
	public boolean isPlein() {
		return plein;
	}
	public void setPlein(boolean plein) {
		this.plein = plein;
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
		if(carre)
			g.fillRect((getWidth()-this.taille)/2, (getHeight()-this.taille)/2,this.taille, this.taille);
		else
			g.fillOval((getWidth()-this.taille)/2, (getHeight()-this.taille)/2, this.taille, this.taille);
		if(!plein){
			paint = new GradientPaint(0,0, Color.LIGHT_GRAY, getWidth(), getHeight(), Color.LIGHT_GRAY);
			g2d.setPaint(paint);
			g.fillOval((getWidth()-this.taille/2)/2, (getHeight()-this.taille/2)/2, this.taille/2, this.taille/2);
			
		}
	}
	public int getTaille() {
		return taille;
	}
	public void setTaille(int taille) {
		this.taille = taille;
	}
	public boolean isPlace() {
		return place;
	}
	public void setPlace(boolean place) {
		this.place = place;
	}
	public boolean isSelectionne() {
		return selectionne;
	}
	public void setSelectionne(boolean selectionnee) {
		this.selectionne = selectionne;
		if(selectionnee){
			setBackground(Color.BLUE);
		}
		else{
			if(noir)
				setBackground(Color.BLACK);
			else
				setBackground(Color.WHITE);
		}
	}
}
