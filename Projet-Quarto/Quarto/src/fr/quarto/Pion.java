package fr.quarto;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Paint;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Pion extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean noir;
	private boolean grand;
	private boolean carre;
	private boolean plein;
	private int taille;
	private boolean place;
	private boolean selectionne;
	private Image image;
	private ImageIcon ii;
	
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
	public Image getImage() {
        return image;
    }
	public ImageIcon getIi(){
		return ii;
    }
	@Override
	public void paintComponent(Graphics g){
		Graphics2D g2d;
		int tailleX = 100;
		int tailleY;
		if(!this.isGrand()){
			tailleX *= (float) 4/6;
		}
		if (g instanceof Graphics2D) {
			g2d = (Graphics2D) g;
		}
		else {
			System.out.println("Error");
			return;
		}
		tailleY = (int) (tailleX * ((float) this.getIi().getIconHeight()/this.getIi().getIconWidth()));
		g2d.drawImage(this.getImage(), 10, 10, tailleX,tailleY, this);   
			
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
	public void donneImage()
	{
		String string = "";
		
		int myInt = (this.isNoir()) ? 1 : 0;
		string += myInt;
		
		myInt = (this.isGrand()) ? 1 : 0;
		string += myInt;
		
		myInt = (this.isCarre()) ? 1 : 0;
		string += myInt;
		
		myInt = (this.isPlein()) ? 1 : 0;
		string += myInt;
		
		this.ii = new ImageIcon("./data/"+ string +".png");
		
        this.image = this.ii.getImage();
	}
}
