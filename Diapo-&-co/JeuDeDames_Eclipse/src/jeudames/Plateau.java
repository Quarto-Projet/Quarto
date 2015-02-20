/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jeudames;

import java.awt.GridLayout;
import javax.swing.JPanel;
/**
 *
 * @author mhaddad
 */
public class Plateau extends JPanel {

        private static final long serialVersionUID = 6726708245444190460L;

	private static final int TAILLE=9;

	private Case caseActive;

	private boolean tourNoir;
        
        private boolean restreint ;

	public Plateau(int taille){
		tourNoir=false;
                restreint = false ;
		setLayout(new GridLayout(TAILLE, TAILLE));
		for(int i=0; i<TAILLE; i++){
			for(int j=0; j<TAILLE; j++){
				if((j%2==0 && i%2==0) || (j%2!=0 && i%2!=0)){
					ajouterCase(Couleur.NOIR);
				}
				else{
					ajouterCase(Couleur.BLANC);
				}
			}
		}
		init();
	}

	private void ajouterCase(Couleur couleur){
		Case case1 = new Case(couleur);
		case1.addMouseListener(new ListenerCase(case1, this));
		add(case1);
	}

	private Pion creerPion(Couleur couleur, boolean monte){
		Pion pion = new Pion(couleur, monte);
		pion.addMouseListener(new ListenerPion(pion, this));
		return pion;
	}

	private void init(){
		for(int j=0; j<TAILLE*3; j+=2){
			getCase(j).add(creerPion(Couleur.NOIR, false));
			getCase(TAILLE*TAILLE-j-1).add(creerPion(Couleur.BLANC, true));
		}
	}

	public Case getCase(int i, int j){
		return (Case) getComponent(j+i*TAILLE);
	}

	public Case getCase(int i){
		return (Case) getComponent(i);
	}

	public boolean afficherPossibilites(Pion p, boolean manger){
		if((p.getCouleur().equals(Couleur.NOIR) && tourNoir) || (p.getCouleur().equals(Couleur.BLANC) && !tourNoir)){
			int i=0;
			int j=0;
			for(int k=0; k<TAILLE*TAILLE; k++){
				getCase(k).setSelectionnee(false);
				if(getCase(k).getComponentCount()!=0 && getCase(k).getComponent(0).equals(p)){
					caseActive=getCase(k);
					i=k/TAILLE;
					j=k%TAILLE;

				}
			}
			return selectionnerCases(i, j, p.getCouleur(),manger);
		}
                return false;
	}

	public boolean selectionnerCases(int i, int j, Couleur couleur,boolean manger){
                boolean possibilite = false;
		Pion pion = (Pion)(getCase(i, j).getComponent(0));
		if(pion.isMonte() || manger){
			if(i-1>=0 && j-1>=0 && getCase(i-1, j-1).getComponentCount()==0){ // check haut gauche vide et dans la grille
				if(!manger)
					getCase(i-1, j-1).setSelectionnee(true);
			}
			else if(i-2>=0 && j-2>=0 && getCase(i-2, j-2).getComponentCount()==0 && !((Pion)(getCase(i-1, j-1).getComponent(0))).getCouleur().equals(couleur)){ // si il y a 1 pion en HG et si on peut le manger
				getCase(i-2, j-2).setSelectionnee(true);
                                possibilite = true;
                        }
			if(i-1>=0 && j+1<TAILLE && getCase(i-1, j+1).getComponentCount()==0){ // en HD
				if(!manger)
					getCase(i-1, j+1).setSelectionnee(true);
                        }
			else if(i-2>=0 && j+2<TAILLE && getCase(i-2, j+2).getComponentCount()==0 && !((Pion)(getCase(i-1, j+1).getComponent(0))).getCouleur().equals(couleur)){
				getCase(i-2, j+2).setSelectionnee(true);
                                possibilite = true;
                        }
		}
		if(!pion.isMonte() || manger){
			if(i+1<TAILLE && j+1<TAILLE && getCase(i+1, j+1).getComponentCount()==0){
				if(!manger)
					getCase(i+1, j+1).setSelectionnee(true);
                        }
			else if(i+2<TAILLE && j+2<TAILLE && getCase(i+2, j+2).getComponentCount()==0 && !((Pion)(getCase(i+1, j+1).getComponent(0))).getCouleur().equals(couleur)){
				getCase(i+2, j+2).setSelectionnee(true);
                                possibilite = true;
                        }
			if(i+1<TAILLE && j-1>=0 && getCase(i+1, j-1).getComponentCount()==0){
				if(!manger)
					getCase(i+1, j-1).setSelectionnee(true);
                        }
			else if(i+2<TAILLE && j-2>=0 && getCase(i+2, j-2).getComponentCount()==0 && !((Pion)(getCase(i+1, j-1).getComponent(0))).getCouleur().equals(couleur)){
				getCase(i+2, j-2).setSelectionnee(true);
                                possibilite = true;
                        }

		}
                return possibilite;
	}

        
	public void deplacer(Case case1){
		case1.add(caseActive.getComponent(0));
                int i,j;
                restreint = false ;
                boolean manger = false;
		for(int k=0; k<TAILLE*TAILLE; k++){
			getCase(k).setSelectionnee(false);
		}
		if(Math.abs(getLigne(case1)-getLigne(caseActive))==2){
			i = (getLigne(case1)+getLigne(caseActive))/2;
			j = (getColonne(case1)+getColonne(caseActive))/2;
			getCase(i, j).removeAll();
			getCase(i, j).validate();
			getCase(i, j).repaint();
                        
                        manger = true ;
		}
                
                caseActive.removeAll();
                caseActive.repaint();
                caseActive=null;
                case1.repaint();
                i = getLigne(case1);
                j= getColonne(case1);
                if(getLigne(case1)==0){
                    Pion p=(Pion)(case1.getComponent(0));
                    p.setMonte(false);
                }
                if(getLigne(case1)==TAILLE-1){
                    Pion p=(Pion)(case1.getComponent(0));
                    p.setMonte(true);
                }
                if(manger && afficherPossibilites((Pion)case1.getComponent(0), manger))
                {
                    restreint = true ;                    
                }
                else
                {
                    tourNoir=!tourNoir;
                }
                
	}

	private int getLigne(Case case1){
		int res=0;
		for(int i=0; i<TAILLE*TAILLE; i+=2){
			if(getCase(i).equals(case1)){
				res=i/TAILLE;
			}
		}
		return res;
	}

	private int getColonne(Case case1){
		int res=0;
		for(int i=0; i<TAILLE*TAILLE; i+=2){
			if(getCase(i).equals(case1)){
				res=i%TAILLE;
			}
		}
		return res;
	}

        public boolean isRestreint()
        {
            return restreint ;
        }



}
