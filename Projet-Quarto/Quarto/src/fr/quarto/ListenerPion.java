package fr.quarto;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ListenerPion implements MouseListener{

	private Pion pion1;
	private Jeu jeu;
	public ListenerPion(Pion pion, Jeu jeu) {
		// TODO Auto-generated constructor stub
		this.jeu = jeu;
		this.pion1 = pion;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(!(pion1.isPlace())){
			jeu.afficherSelection(pion1);
			pion1.setSelectionne(true);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
