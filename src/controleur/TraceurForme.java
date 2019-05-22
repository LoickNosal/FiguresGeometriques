package controleur;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import vue.VueDessin;

public class TraceurForme extends JPanel implements MouseListener,MouseMotionListener{
	
	private ArrayList<Trait> liste_traits;
	private int last_x;
	private int lasy_y;
	private Color couleur_trait;
	private Graphics gc;

	
	
	public TraceurForme(Graphics g) {
		this.liste_traits = new ArrayList<Trait>();
		this.couleur_trait = Color.black;
		this.gc = g;
		
		
	}
	

	public void setColor(Color c) {
		this.couleur_trait = c;
	}
	
	public ArrayList<Trait> getListe_traits(){
		return this.liste_traits;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		this.last_x = e.getX();
		this.lasy_y = e.getY();
		
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
	public void mouseDragged(MouseEvent e) {
		
		if (SwingUtilities.isLeftMouseButton(e)) {
			gc.setColor(this.couleur_trait);
			gc.drawLine(this.last_x, this.lasy_y, e.getX(), e.getY());
			this.liste_traits.add(new Trait(this.last_x, this.lasy_y, e.getX(), e.getY(), this.couleur_trait));
			((VueDessin)e.getSource()).ajouterTrait(new Trait(this.last_x, this.lasy_y, e.getX(), e.getY(), this.couleur_trait));
			this.last_x = e.getX();
			this.lasy_y = e.getY();
			
		}
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	

}
