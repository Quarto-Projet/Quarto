package fr.quarto;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class Jeu extends JPanel{
	private boolean tourJ1;
	private TableauCase plateau;
	private TableauCase reserve;
	private boolean ia;
	private Pion pionActif;
	private Case caseActive;
	
	public Jeu(boolean partieIA){
		GridLayout layout = new GridLayout(2,1);
		layout.setVgap(10);
		setLayout(layout);	
		this.setTourJ1(true);
		this.setPlateau(new TableauCase(4,4,this));
		this.setReserve(new TableauCase(2,8,this));
		this.setIa(partieIA);
		add(plateau);
		add(reserve);
		init();
		
		
	}
	
	private void init() {
		for(int i = 0; i<16; i++){
			Pion pion = new Pion();
			if(i < 8){
				pion.setNoir(true);
				if(i < 4){
					pion.setGrand(true);
					if(i < 2){
						pion.setCarre(true);
						if(i == 0)
							pion.setPlein(true);
						else
							pion.setPlein(false);
					}
					else{
						pion.setCarre(false);
						if(i == 2)
							pion.setPlein(true);
						else
							pion.setPlein(false);
					}
				}
				else{
					pion.setGrand(false);
					if(i < 6){
						pion.setCarre(true);
						if(i == 4)
							pion.setPlein(true);
						else
							pion.setPlein(false);
					}
					else{
						pion.setCarre(false);
						if(i == 6)
							pion.setPlein(true);
						else
							pion.setPlein(false);
					}
				}
			}
			else{
				pion.setNoir(false);
				if(i < 12){
					pion.setGrand(true);
					if(i < 10){
						pion.setCarre(true);
						if(i == 8)
							pion.setPlein(true);
						else
							pion.setPlein(false);
					}
					else{
						pion.setCarre(false);
						if(i == 10)
							pion.setPlein(true);
						else
							pion.setPlein(false);
					}
				}
				else{
					pion.setGrand(false);
					if(i < 14){
						pion.setCarre(true);
						if(i == 12)
							pion.setPlein(true);
						else
							pion.setPlein(false);
					}
					else{
						pion.setCarre(false);
						if(i == 14)
							pion.setPlein(true);
						else
							pion.setPlein(false);
					}
				}
			}
			pion.addMouseListener(new ListenerPion(pion, this));
			reserve.getCase(i).add(pion);
			pion.donneImage();
		}
	}

	public void jouer(Case choisi){
		choisi.add(pionActif);
        caseActive.removeAll();
        caseActive.repaint();
        choisi.repaint();
        pionActif.setSelectionne(false);
        pionActif.setPlace(true);
        pionActif.updateUI();
        for(int i = 0; i < 16; i++){
        	plateau.getCase(i).setSelectionnee(false);
        }
        int end = finPartie(); // 0 = ça continu, 1 = grille pleine, 2 = un vainqueur
        if (end == 1){
            //grille pleine et égalité
        } else if (end == 2){
        	for(int i = 0; i < 16; i++){
            	if(reserve.getCase(i).getComponentCount() != 0){
            		((Pion) reserve.getCase(i).getComponent(0)).setPlace(true);
                }
            }
        }
        
	}

	public boolean isTourJ1() {
		return tourJ1;
	}

	public void setTourJ1(boolean tourJ1) {
		this.tourJ1 = tourJ1;
	}

	public TableauCase getPlateau() {
		return plateau;
	}

	public void setPlateau(TableauCase plateau) {
		this.plateau = plateau;
	}

	public TableauCase getReserve() {
		return reserve;
	}

	public void setReserve(TableauCase reserve) {
		this.reserve = reserve;
	}

	public boolean isIa() {
		return ia;
	}

	public void setIa(boolean ia) {
		this.ia = ia;
	}

	public Pion getPionActif() {
		return pionActif;
	}

	public void setPionActif(Pion pionActif) {
		this.pionActif = pionActif;
	}

	public void afficherSelection(Pion p) {
		pionActif = p;
		for(int i = 0; i < 16; i++){
			if(plateau.getCase(i).getComponentCount() == 0){
				plateau.getCase(i).setSelectionnee(true);
			}
			else
				plateau.getCase(i).setSelectionnee(false);
			if(reserve.getCase(i).getComponentCount() == 1){
				if(((Pion) reserve.getCase(i).getComponent(0)) == p){
					((Pion) reserve.getCase(i).getComponent(0)).setSelectionne(true);
					caseActive = reserve.getCase(i); 
				}
				else
					((Pion) reserve.getCase(i).getComponent(0)).setSelectionne(false);
			}
		}
	}
        
        public boolean isLigneGagnante(Pion p1, Pion p2, Pion p3, Pion p4){
            if (p1.isNoir() && p2.isNoir() && p3.isNoir() && p4.isNoir()){
                return true;
            } else if (!p1.isNoir() && !p2.isNoir() && !p3.isNoir() && !p4.isNoir()){
                return true;      
            } else if (p1.isCarre() && p2.isCarre() && p3.isCarre() && p4.isCarre()){
                return true;
            } else if (!p1.isCarre() && !p2.isCarre() && !p3.isCarre() && !p4.isCarre()){
                return true;      
            } else if (p1.isGrand() && p2.isGrand() && p3.isGrand() && p4.isGrand()){
                return true;
            } else if (!p1.isGrand() && !p2.isGrand() && !p3.isGrand() && !p4.isGrand()){
                return true;      
            } else if (p1.isPlein() && p2.isPlein() && p3.isPlein() && p4.isPlein()){
                return true;
            } else if (!p1.isPlein() && !p2.isPlein() && !p3.isPlein() && !p4.isPlein()){
                return true;      
            }
            return false;
        }
        
        public int finPartie() {
            // 0 = pas fini, 1 = pas de vainqueur, 2 = fini et vainqueur
            int plein = 0;
            for(int i = 0; i < 4; i++){ // colonnes
                if (plateau.getCase(i).getComponentCount() != 0 && plateau.getCase(i+4).getComponentCount() != 0 && plateau.getCase(i+8).getComponentCount() != 0 && plateau.getCase(i+12).getComponentCount() != 0){
                    if (isLigneGagnante(((Pion) plateau.getCase(i).getComponent(0)), ((Pion) plateau.getCase(i+4).getComponent(0)), ((Pion) plateau.getCase(i+8).getComponent(0)), ((Pion) plateau.getCase(i+12).getComponent(0)))){
                        plateau.getCase(i).setSelectionnee(true);
                        plateau.getCase(i+4).setSelectionnee(true);
                        plateau.getCase(i+8).setSelectionnee(true);
                        plateau.getCase(i+12).setSelectionnee(true);
                        plein = 2;
                    }
                }
            }
            for(int i = 0; i < 16; i+=4){ // lignes
                if (plateau.getCase(i).getComponentCount() != 0 && plateau.getCase(i+1).getComponentCount() != 0 && plateau.getCase(i+2).getComponentCount() != 0 && plateau.getCase(i+3).getComponentCount() != 0){
                    if (isLigneGagnante(((Pion) plateau.getCase(i).getComponent(0)), ((Pion) plateau.getCase(i+1).getComponent(0)), ((Pion) plateau.getCase(i+2).getComponent(0)), ((Pion) plateau.getCase(i+3).getComponent(0)))){
                        plateau.getCase(i).setSelectionnee(true);
                        plateau.getCase(i+1).setSelectionnee(true);
                        plateau.getCase(i+2).setSelectionnee(true);
                        plateau.getCase(i+3).setSelectionnee(true);
                        plein = 2;
                    }
                }
            }
            //diag1
            if (plateau.getCase(0).getComponentCount() != 0 && plateau.getCase(5).getComponentCount() != 0 && plateau.getCase(10).getComponentCount() != 0 && plateau.getCase(15).getComponentCount() != 0){
                    if (isLigneGagnante(((Pion) plateau.getCase(0).getComponent(0)), ((Pion) plateau.getCase(5).getComponent(0)), ((Pion) plateau.getCase(10).getComponent(0)), ((Pion) plateau.getCase(15).getComponent(0)))){
                        plateau.getCase(0).setSelectionnee(true);
                        plateau.getCase(5).setSelectionnee(true);
                        plateau.getCase(10).setSelectionnee(true);
                        plateau.getCase(15).setSelectionnee(true);
                        plein = 2;
                    }
                }
            //diag2
            if (plateau.getCase(3).getComponentCount() != 0 && plateau.getCase(6).getComponentCount() != 0 && plateau.getCase(9).getComponentCount() != 0 && plateau.getCase(12).getComponentCount() != 0){
                    if (isLigneGagnante(((Pion) plateau.getCase(3).getComponent(0)), ((Pion) plateau.getCase(6).getComponent(0)), ((Pion) plateau.getCase(9).getComponent(0)), ((Pion) plateau.getCase(12).getComponent(0)))){
                        plateau.getCase(3).setSelectionnee(true);
                        plateau.getCase(6).setSelectionnee(true);
                        plateau.getCase(9).setSelectionnee(true);
                        plateau.getCase(12).setSelectionnee(true);
                        plein = 2;
                    }
                }
            
            if (plein == 2){
                return plein;
            }
            else {
                //plateau plein?
                plein = 1;
                for(int i = 0; i < 16; i++){
                    if (plateau.getCase(i).getComponentCount() == 0){
                        plein = 0;
                    }
                }
                return plein;
            }
            
        }
}
