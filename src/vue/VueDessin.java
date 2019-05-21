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
 * @author Lo�ck Nosal
 * Cette classe d�finit la vue.
 * La classe VueDessin est une vue et impl�mente donc l�interface Observer. La m�thode
 * update sera d�clench�e � chaque modification du mod�le
 */
public class VueDessin extends JPanel implements Observer{
	
	/*
	 * Mod�le
	 */
	private DessinModele dessin;
	/*
	 * Objet "listener" pour les manipulations et transformations de figures via la souris
	 */
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
	
	/*
	 * Cette m�thode retourne la figure actuellement s�lectionn�e.
	 */
	public FigureColoree figureSelection() {
		for (FigureColoree f : this.dessin.get_fg()) {
			if (f.isSelected()) {
				return f;
			}
		}
		return null;
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
	/*
	 * Cette m�thode permet d'initier le m�canisme �v�nementiel de fabrication des figures � la souris (ajout du listener).
	 */
	public void construit(FigureColoree f) {
		if (f != null) {
			FabricantFigures ff = new FabricantFigures(f);
			this.addMouseListener(ff);
		}
	
	}
	
	/*
	 * Cette m�thode permet d'initier le m�canisme de manipulation des figures � la souris (ajout du listener).
	 */
	public void manip() {
		System.out.println("manip");
		this.mf = new ManipulateurFormes(this.dessin);
		this.desactiverToutListener();
		this.addMouseListener(this.mf);
		this.addMouseMotionListener(this.mf);
	}
	

	public DessinModele getDessin() {
		return this.dessin;
	}
	
	public ManipulateurFormes getManipulateurFormes() {
		return this.mf;
	}
	
	/*
	 * M�thode d�sactivant les listeners
	 */
	public void desactiverToutListener() {
		for (MouseListener m : getMouseListeners()) {
			removeMouseListener(m);
		}
		for (MouseMotionListener mm : getMouseMotionListeners()) {
			removeMouseMotionListener(mm);
		}
	}

}
