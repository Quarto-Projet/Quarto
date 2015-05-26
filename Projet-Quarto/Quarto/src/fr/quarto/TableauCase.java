package fr.quarto;

import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JPanel;

public class TableauCase  extends JPanel{
	private Jeu jeu;
	private int dimX;
	private int dimY;
	public TableauCase(int dimY, int dimX,Jeu jeu) {
		GridLayout layout = new GridLayout(dimY,dimX);
		layout.setVgap(2);
		layout.setHgap(2);
		setLayout(layout);	
		this.dimX = dimX;
		this.dimY = dimY;
		this.jeu = jeu;
		for(int i = 0; i<dimX*dimY;i++){
				ajouterCase();
		}
	}
	private void ajouterCase() {
		Case case1 = new Case();
		case1.addMouseListener(new ListenerCase(case1, this.jeu));
		add(case1);
	}
	public int getDimY() {
		return dimY;
	}
	public void setDimY(int dimY) {
		this.dimY = dimY;
	}
	public int getDimX() {
		return dimX;
	}
	public void setDimX(int dimX) {
		this.dimX = dimX;
	}

	public Case getCase(int x, int y){
		return (Case) this.getComponent(y*this.dimX + x);
	}
	public Case getCase(int i) {
		return (Case) this.getComponent(i);
	}
}

