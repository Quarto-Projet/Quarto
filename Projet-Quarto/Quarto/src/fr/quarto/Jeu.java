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
		}
	}

	public void jouer(Case choisi){
		choisi.add(pionActif);
        caseActive.removeAll();
        caseActive.repaint();
        choisi.repaint();
        pionActif.setSelectionne(false);
        pionActif.setPlace(true);
        for(int i = 0; i < 16; i++){
        	plateau.getCase(i).setSelectionnee(false);
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
	
}
