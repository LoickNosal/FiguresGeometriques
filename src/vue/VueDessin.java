package vue;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import controleur.FabricantFigures;
import controleur.ManipulateurFormes;
import modele.DessinModele;
import modele.FigureColoree;

/*
 * @author Loïck Nosal
 * Cette classe définit la vue.
 * La classe VueDessin est une vue et implémente donc l’interface Observer. La méthode
 * update sera déclenchée à chaque modification du modèle
 */
public class VueDessin extends JPanel implements Observer{
	
	private DessinModele dessin;
	private ManipulateurFormes mf;
	
	public VueDessin() {
		this.dessin = new DessinModele();
		this.setFocusable(true);
		this.requestFocusInWindow();
	}
	
	public void update(Observable o, Object ob) {
		this.dessin = (DessinModele)o;
		repaint();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (this.dessin.get_fg() != null) {
			for (FigureColoree fg : this.dessin.get_fg()) {
				g.setColor(fg.getColor());
				fg.afficher(g);

			}
		}
		
	}
	
	public void construit(FigureColoree f) {
		if (f != null) {
			FabricantFigures ff = new FabricantFigures(f);
			this.addMouseListener(ff);
		}
	
	}
	
	public void manip() {
		System.out.println("manip");
		this.mf = new ManipulateurFormes(this.dessin);
		this.desactiverToutListener();
		this.addMouseListener(this.mf);
		this.addMouseMotionListener(this.mf);
	}
	
	public void effacer() {
		this.removeAll();
		this.repaint();
	}

	public DessinModele getDessin() {
		return this.dessin;
	}
	
	public ManipulateurFormes getManipulateurFormes() {
		return this.mf;
	}
	
	public void desactiverToutListener() {
		for (MouseListener m : getMouseListeners()) {
			removeMouseListener(m);
		}
		for (MouseMotionListener mm : getMouseMotionListeners()) {
			removeMouseMotionListener(mm);
		}
	}

}
