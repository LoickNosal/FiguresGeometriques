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
import controleur.TraceurForme;
import controleur.Trait;
import modele.DessinModele;
import modele.FigureColoree;

/*
 * @author Loïck Nosal
 * Cette classe définit la vue.
 * La classe VueDessin est une vue et implémente donc l’interface Observer. La méthode
 * update sera déclenchée à chaque modification du modèle
 */
public class VueDessin extends JPanel implements Observer{
	
	/*
	 * Modèle
	 */
	private DessinModele dessin;
	/*
	 * Objet "listener" pour les manipulations et transformations de figures via la souris
	 */
	private ManipulateurFormes mf;
	/*
	 * jpanel traceurforme pour les traits
	 */
	private TraceurForme tf;
	/*
	 * liste des traits du dessin
	 */
	private ArrayList<Trait> liste_traits;
	
	public VueDessin() {
		this.liste_traits = new ArrayList<Trait>();
		this.dessin = new DessinModele();
		this.setFocusable(true);
		this.requestFocusInWindow();
		
	}
	
	public void update(Observable o, Object ob) {
		this.dessin = (DessinModele)o;
		repaint();
	}
	
	/*
	 * Cette méthode retourne la figure actuellement sélectionnée.
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
		ajouterTrait();
		if (this.liste_traits != null) {
			for (Trait t : this.liste_traits) {
				g.setColor(t.getCouleur());
				g.drawLine(t.getDebx(), t.getDeby(), t.getFinx(), t.getFiny());
			}
		}
		
		
		
	}
	/*
	 * Cette méthode permet d'initier le mécanisme événementiel de fabrication des figures à la souris (ajout du listener).
	 */
	public void construit(FigureColoree f) {
		this.ajouterTrait();
		if (f != null) {
			FabricantFigures ff = new FabricantFigures(f);
			this.addMouseListener(ff);
		}
	
	}
	
	public void ajouterTrait() {
		System.out.println("appelee");
		if (this.tf != null) {
			if(this.tf.getListe_traits() != null) {

				for (Trait t :this.tf.getListe_traits()) {
					this.liste_traits.add(t);
				}
				
			}
		}
	}
	
	public void supprimerTrait() {
		this.liste_traits.clear();
		if (this.tf != null) {
			if(this.tf.getListe_traits() != null) {
				this.tf.getListe_traits().clear();
			}
		}
	}
	
	public void trace(Color c) {
		System.out.println("tracer");
		this.ajouterTrait();
		this.desactiverToutListener();
		this.tf = new TraceurForme(this.getGraphics());
		this.tf.setColor(c);
		this.addMouseListener(this.tf);
		this.addMouseMotionListener(this.tf);
		
	}
	
	/*
	 * Cette méthode permet d'initier le mécanisme de manipulation des figures à la souris (ajout du listener).
	 */
	public void manip() {
		System.out.println("manip");
		this.ajouterTrait();
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
	
	public TraceurForme getTraceurForme() {
		return this.tf;
	}
	
	/*
	 * Méthode désactivant les listeners
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
