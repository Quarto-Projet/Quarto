/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jeudames;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author mhaddad
 */
public class ListenerCase implements MouseListener {

    private Case case1;
	private Plateau plateau;


	public ListenerCase(Case case1, Plateau plateau) {
		super();
		this.case1 = case1;
		this.plateau = plateau;
	}


	public void mouseClicked(MouseEvent arg0) {

	}


	public void mouseEntered(MouseEvent arg0) {

	}


	public void mouseExited(MouseEvent arg0) {

	}


	public void mousePressed(MouseEvent arg0) {
		if(case1.isSelectionnee()){
			plateau.deplacer(case1);
		}
	}


	public void mouseReleased(MouseEvent arg0) {

	}
	

}
