package fr.quarto;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ListenerCase implements MouseListener {

	private Case case1;
	private Jeu jeu;
	public ListenerCase(Case case1, Jeu jeu) {
		this.case1 = case1;
		this.jeu = jeu;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		if(case1.isSelectionnee()){
			jeu.jouer(case1);
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
