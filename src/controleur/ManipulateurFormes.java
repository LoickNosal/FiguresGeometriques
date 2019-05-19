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
	
	public ManipulateurFormes(DessinModele d, ArrayList<FigureColoree> f) {
		this.dm = d;
		this.trans = false;
		this.sel = -1;
		this.last_x = 0;
		this.last_y = 0;
		this.lfg = f;
		
	}
	

	public int nbFigures() {
		throw new Error("pas fait");
	}
	
	public FigureColoree figureSelection() {
		throw new Error("pas fait");
	}
	
	public void selectionProchaineFigure() {
		throw new Error("pas fait");
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
		System.out.println("a");
		if(lfg.size()!=0){
			if(MouseEvent.BUTTON1 == e.getButton()) {
				last_y = e.getY();
				last_x = e.getX();
				
				boolean select = false;
				for(int i=(lfg.size()-1); i>=0; i--) {
					if(lfg.get(i).estDans(last_x, last_y)&&!select) {
						lfg.get(i).selectionne();
						indice = i;
						select=true;
					}
					else {
						lfg.get(i).deSelectionne();
					}
				}
			}
		}
		((VueDessin)e.getSource()).repaint();
		
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
