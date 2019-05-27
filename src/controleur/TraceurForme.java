package controleur;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import vue.VueDessin;

/*
 * @author Nosal Lo�ck
 * Class permettant de tracer des traits
 */
public class TraceurForme implements MouseListener,MouseMotionListener{
	
	/*
	 * Liste des traits.
	 */
	private ArrayList<Trait> liste_traits;
	/*
	 * Abscisse d'un clic de souris.
	 */
	private int last_x;
	/*
	 * Ordonn�e d'un clic de souris.
	 */
	private int last_y;
	/*
	 * Couleur du trait � dessiner.
	 */
	private Color couleur_trait;
	/*
	 * Contexte graphique.
	 */
	private Graphics gc;
	
	private float epaisseur;
	
	/*
	 * Constructeur de la classe.
	 */
	public TraceurForme(Graphics g,float e) {
		this.liste_traits = new ArrayList<Trait>();
		this.couleur_trait = Color.black;
		this.gc = g;
		this.epaisseur = e;
		
		
	}
	
	public void setEpaisseur(float f) {
		this.epaisseur = f;
	}
	
	/*
	 * M�thode pour changer la couleur du trait.
	 */
	public void setColor(Color c) {
		this.couleur_trait = c;
	}
	
	/*
	 * M�thode pour r�cup�rer les traits
	 */
	public ArrayList<Trait> getListe_traits(){
		return this.liste_traits;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	/*
	 * M�thode d�butant le trace � main lev�e.
	 */
	public void mousePressed(MouseEvent e) {
		this.last_x = e.getX();
		this.last_y = e.getY();
		
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
	@Override
	/*
	 * M�thode effectuant le trace � main lev�e.
	 */
	public void mouseDragged(MouseEvent e) {
		
		if (SwingUtilities.isLeftMouseButton(e)) {
			gc.setColor(this.couleur_trait);
			gc.drawLine(this.last_x, this.last_y, e.getX(), e.getY());
			this.liste_traits.add(new Trait(this.last_x, this.last_y, e.getX(), e.getY(), this.couleur_trait,this.epaisseur));
			((VueDessin)e.getSource()).ajouterTrait(new Trait(this.last_x, this.last_y, e.getX(), e.getY(), this.couleur_trait,this.epaisseur));
			this.last_x = e.getX();
			this.last_y = e.getY();
			
		}
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	

}
