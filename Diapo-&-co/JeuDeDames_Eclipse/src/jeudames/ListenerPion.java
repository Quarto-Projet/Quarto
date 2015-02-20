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
public class ListenerPion implements MouseListener {

        private Plateau plateau;
	private Pion pion;

	public ListenerPion(Pion pion, Plateau plateau){
		this.plateau=plateau;
		this.pion=pion;
	}

	public void mouseClicked(MouseEvent arg0) {

	}

	public void mouseEntered(MouseEvent arg0) {
	}

	public void mouseExited(MouseEvent arg0) {

	}

	public void mousePressed(MouseEvent arg0) {
		 if(!plateau.isRestreint())
         {
             plateau.afficherPossibilites(pion,false);
         }
	}

	public void mouseReleased(MouseEvent arg0) {

	}

}
