package vue;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import controleur.CopieFigure;
import controleur.FabricantFigures;
import controleur.Gomme;
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
	 * permet de gérer les copies de figures
	 */
	private CopieFigure cf;
	
	private Gomme go;
	
	private Cursor CurseurMainOuverte;
	
	private Cursor CurseurMainFermee;
	
	public Cursor getCurseurMainOuverte() {
		return this.CurseurMainOuverte;
	}
	
	public Cursor getCurseurMainFermee() {
		return this.CurseurMainFermee;
	}
	
	public void setCurseurMainOuverte(Cursor c) {
		this.CurseurMainOuverte = c;
	}
	
	public void setCurseurMainFermee(Cursor c) {
		this.CurseurMainFermee = c;
	}

	/*
	 * Constructeur
	 */
	public VueDessin() {

		this.dessin = new DessinModele();
		this.setFocusable(true);
		this.requestFocusInWindow();
		
	}
	
	public void setDessin(DessinModele dm) {
		this.dessin = dm;
	}
	
	public void setMF(ManipulateurFormes manip) {
		this.mf = manip;
	}
	
	/*
	 * mise à jour de la vue
	 */
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

		
		
	}
	/*
	 * Cette méthode permet d'initier le mécanisme événementiel de fabrication des figures à la souris (ajout du listener).
	 */
	public void construit(FigureColoree f) {
		if (f != null) {
			FabricantFigures ff = new FabricantFigures(f);
			this.addMouseListener(ff);
		}
	
	}
	
	/*
	 * permet d'ajouter un trait en tant que figureColoree
	 */
	public void ajouterTrait(Trait t) {	
		if(this.tf != null) {
			this.dessin.ajoute(t);
		}
	}
	
	/*
	 *  Cette méthode permet de tracer des traits à la souris (ajout du listener).
	 */
	public void trace(Color c) {
		System.out.println("tracer");
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
		this.mf = new ManipulateurFormes(this.dessin);
		this.desactiverToutListener();	
		this.addMouseListener(this.mf);
		this.addMouseMotionListener(this.mf);		
		
	}
	
	public void gommer() {
		System.out.println("gommer");
		this.go = new Gomme(this.getGraphics(),this.dessin);
		this.desactiverToutListener();
		this.addMouseListener(this.go);
		this.addMouseMotionListener(this.go);
	}
	
	public void copieFigure() {
		System.out.println("copie");
		this.cf = new CopieFigure(this.dessin);
		cf.Copier();
		this.requestFocusInWindow();
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
		for (KeyListener kl : getKeyListeners()) {
			removeKeyListener(kl);
		}
	}
	


}
