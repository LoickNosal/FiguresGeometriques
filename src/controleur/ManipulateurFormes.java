package controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;


import modele.DessinModele;
import modele.FigureColoree;
import vue.VueDessin;
/**
 * @author Nosal Loïck
 * Classe gérant le déplacement et la transformation des figures géométriques.
 */
public class ManipulateurFormes implements MouseListener, MouseMotionListener{
	
	/**
	 * savoir si la figure est en train d'etre deforme
	 */
	private boolean deformer;
	/**
	 * Abscisse d'un clic de souris.
	 */
	private int last_x;
	/**
	 * ordonnee d'un clic de souris.
	 */
	private int last_y;
	/**
	 * Attribut indiquant si un deplacement est en cours.
	 */
	private boolean trans;
	/**
	 * attribut indiquant l'indice du point proche d'un carre de selection.
	 */
	private int indice;
	/**
	 * Nombre effectif de figures apparaissant dans ce dessin.
	 */
	private int nbf;
	/**
	 * Indice de la figure actuellement 
	 * selectionnee (-1 si aucune figure n'est selectionnee).
	 */
	private int sel;
	/**
	 * Liste de figures du modele
	 */
	private ArrayList<FigureColoree> lfg;
	/**
	 * modele
	 */
	private DessinModele dm;
	
	/**
	 * constructeur à partir d'un DessinModele
	 * @param d dessin 
	 */
	public ManipulateurFormes(DessinModele d) {
		this.dm = d;
		this.lfg = d.get_fg();
		this.trans = false;
		this.sel = -1;
		this.last_x = 0;
		this.last_y = 0;
		this.deformer = false;
		this.indice = -1;
	}
	
	public int getSel() {
		return this.sel;
	}
	
	public void setSel(int s) {
		this.sel = s;
	}

	/**
	 * Cette méthode retourne le nombre de figures apparaissant dans ce dessin.
	 */
	public int nbFigures() {
		return this.lfg.size();
	}
	
	/**
	 * Cette méthode retourne la figure actuellement sélectionnée.
	 */
	public FigureColoree figureSelection() {
		for (FigureColoree f : this.lfg) {
			if (f.isSelected() == true) {
				return f;
			}
		}
		return null;
	}
	/**
	 * Cette méthode sélectionne la prochaine figure dans le tableau des figures.
	 */
	public void selectionProchaineFigure() {
		this.dm.deselectTous();
		this.lfg.get(sel+1).selectionne();
		this.sel = this.sel +1;
	}
	
	@Override
	/**
	 * Méthode déplaçant ou transformant la figure géométrique sélectionnée.
	 */
	public void mouseDragged(MouseEvent e) {

		if (this.trans == true) {
			if (lfg.size()!=0){
				if(lfg.get(this.sel).isSelected() == true) {	
					
					lfg.get(this.sel).translation(e.getX()-last_x, e.getY()-last_y);
					last_x = e.getX();
					last_y = e.getY();
				}
			}
		}else {
			if (deformer == false) {
				if (this.sel != -1) {
					if (lfg.get(this.sel).isSelected()) {
						this.indice = lfg.get(this.sel).carreDeSelection(last_x, last_y);
							if (indice != -1) {
								lfg.get(this.sel).transformation(last_x, last_y, this.indice);
								last_x = e.getX();
								last_y = e.getY();
								deformer = true;
							}
					}

				}
			}else {
				if (this.sel != -1) {
					if (lfg.get(this.sel).isSelected()) {
								lfg.get(this.sel).transformation(last_x, last_y, this.indice);
								last_x = e.getX();
								last_y = e.getY();
								deformer = true;
								
					}
				}

			}
				
		}
		this.dm.majAffichage();
	}


	@Override
	/**
	 * Méthode permettant de sélectionner la figure géométrique à manipuler.
	 */
	public void mousePressed(MouseEvent e) {
		((VueDessin)e.getSource()).setCursor(((VueDessin)e.getSource()).getCurseurMainFermee());
		if(lfg.size()!=0){
			if(MouseEvent.BUTTON1 == e.getButton()) {
				last_y = e.getY();
				last_x = e.getX();
				
				boolean estselec = false;
				
				for(int i=(lfg.size()-1); i>=0; i--) {
					if(lfg.get(i).estDedans(last_x, last_y) && estselec == false) {
						
						lfg.get(i).selectionne();
						this.sel = i;
						this.dm.setSel(i);
						
						estselec=true;
						
						this.trans = true;	
						
//						if (this.lfg.size() > 1) {
//							FigureColoree f = this.lfg.get(this.sel);
//							FigureColoree f2= this.lfg.get(this.lfg.size()-1);
//							lfg.remove(this.lfg.size()-1);
//							this.dm.get_fg().remove(this.dm.get_fg().size()-1);
//							lfg.set(this.sel, f2);
//							this.dm.get_fg().set(this.sel, f2);
//							lfg.add(f);
//							this.dm.get_fg().add(f);
//						}
						

						
					}else {
						lfg.get(i).deSelectionne();
						//this.dm.setSel(-1);
					}
					

				}
				this.dm.majAffichage();
			}
			if (MouseEvent.BUTTON3 == e.getButton()) {
				
				last_y = e.getY();
				last_x = e.getX();
				this.trans = false;
				
			}
		}
	}

	@Override
	/**
	 * permet de gerer le lacher de clique 
	 */
	public void mouseReleased(MouseEvent e) {
		this.deformer = false;
		this.trans = false; 
		this.indice = -1;
		((VueDessin)e.getSource()).setCursor(((VueDessin)e.getSource()).getCurseurMainOuverte());
	}

	
	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}
	
	@Override
	public void mouseMoved(MouseEvent e) {}

	@Override
	public void mouseClicked(MouseEvent e) {}

	

	
}
