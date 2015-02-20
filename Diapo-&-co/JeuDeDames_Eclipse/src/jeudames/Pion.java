/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jeudames;

//import java.awt.Color;
//import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
//import java.awt.Paint;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author mhaddad
 */

public class Pion extends JPanel {
    
        private static final long serialVersionUID = 1436178861615738480L;

    private Couleur couleur;
	private boolean monte;
	private Image image;


	public Pion(Couleur couleur, boolean monte) {
		ImageIcon ii;
        this.monte=monte;
		this.couleur = couleur;
		setOpaque(false);
		switch (couleur) {
		case BLANC :
			ii = new ImageIcon("./src/jeudames/pionB.png");
			this.image = ii.getImage();
			break;
		case NOIR :
			ii = new ImageIcon("./src/jeudames/pionN.png");
			this.image = ii.getImage();
			break;
		}
	}

	@Override
	public void paintComponent(Graphics g){
		//Paint paint;
		Graphics2D g2d;
		if (g instanceof Graphics2D) {
			g2d = (Graphics2D) g;
		}
		else {
			System.out.println("Error");
			return;
		}
		/*paint = new GradientPaint(0,0, getBackground(), getWidth(), getHeight(), getForeground());
		g2d.setPaint(paint);
		g.fillOval(5, 5, getWidth()-10, getHeight()-10); 
		*/
		g2d.drawImage(this.getImage(),5,5, this);

	}

	public Couleur getCouleur() {
		return couleur;
	}

	public boolean isMonte() {
		return monte;
	}

	public void setMonte(boolean monte) {
		this.monte = monte;
	}
	public Image getImage(){
		return image;
	}
}
