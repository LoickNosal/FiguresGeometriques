package controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;


import modele.DessinModele;
import modele.FigureColoree;
import vue.VueDessin;

public class ManipulateurFormes implements MouseListener, MouseMotionListener {
	
	/*
	 * Abscisse d'un clic de souris.
	 */
	private int last_x;
	/*
	 * ordonnee d'un clic de souris.
	 */
	private int last_y;
	/*
	 * Attribut indiquant si un deplacement est en cours.
	 */
	private boolean trans;
	/*
	 * attribut indiquant l'indice du point proche d'un carre de selection.
	 */
	private int indice;
	/*
	 * Nombre effectif de figures apparaissant dans ce dessin.
	 */
	private int nbf;
	/*
	 * Indice de la figure actuellement 
	 * selectionnee (-1 si aucune figure n'est selectionnee).
	 */
	private int sel;
	/*
	 * Liste de figures du modele
	 */
	private ArrayList<FigureColoree> lfg;
	/*
	 * modele
	 */
	private DessinModele dm;
	
	public ManipulateurFormes(DessinModele d) {
		this.dm = d;
		this.lfg = d.get_fg();
		this.trans = false;
		this.sel = -1;
		this.last_x = 0;
		this.last_y = 0;
	}
	
	public int getSel() {
		return this.sel;
	}

	public int nbFigures() {
		return this.lfg.size();
	}
	
	public FigureColoree figureSelection() {
		for (FigureColoree f : this.lfg) {
			if (f.isSelected() == true) {
				return f;
			}
		}
		return null;
	}
	
	public void selectionProchaineFigure() {
		this.dm.deselectTous();
		this.lfg.get(sel+1).selectionne();
		this.sel = this.sel +1;
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		if (lfg.size()!=0){
			if(lfg.get(indice).isSelected() == true) {	
				
				lfg.get(indice).translation(e.getX()-last_x, e.getY()-last_y);
				
				trans = true;
				last_x = e.getX();
				last_y = e.getY();
			}
		}
		this.dm.update();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {

		if(lfg.size()!=0){
			if(MouseEvent.BUTTON1 == e.getButton()) {
				last_y = e.getY();
				last_x = e.getX();
				
				boolean estselec = false;
				
				for(int i=(lfg.size()-1); i>=0; i--) {
					
					if(lfg.get(i).estDedans(last_x, last_y) && estselec == false) {
						lfg.get(i).selectionne();
						indice = i;
						this.sel = i;
						this.dm.setSel(i);
						estselec=true;

					}
					else {
						lfg.get(i).deSelectionne();
					}
					

				}
				this.dm.update();
			}
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
