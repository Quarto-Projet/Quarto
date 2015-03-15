package fr.quarto;

import javax.swing.JPanel;

public class Jeu extends JPanel{
	private boolean tourJ1;
	private TableauCase plateau;
	private TableauCase reserve;
	private boolean ia;
	private Pion pionActif;
	
	public Jeu(boolean partieIA){
		this.setTourJ1(true);
		this.setPlateau(new TableauCase(4,4,this));
		this.setReserve(new TableauCase(2,8,this));
		this.setIa(partieIA);
		
		
	}
	
	public void jouer(Pion choisi){
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
	
}
