package fr.quarto;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class TableauCase  extends JPanel{
	private Jeu jeu;
	public TableauCase(int dimY, int dimX,Jeu jeu) {
		setLayout(new GridLayout(dimY,dimX));
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

}
