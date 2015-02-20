/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jeudames;

import javax.swing.JFrame;
import javax.swing.UIManager;
/**
 *
 * @author mhaddad
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
                try{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		}
		catch(Exception e){}

		JFrame f = new JFrame();
		f.setSize(600, 600);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(new Plateau(9));
		f.setVisible(true);
    }

}
