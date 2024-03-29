package vue;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.Observable;
import java.util.Observer;


import javax.swing.JPanel;

import controleur.CopieFigure;
import controleur.DrawText;
import controleur.FabricantFigures;
import controleur.Gomme;
import controleur.ManipulateurFormes;
import controleur.TraceurForme;
import controleur.Trait;
import modele.DessinModele;
import modele.FigureColoree;
import modele.Texte;

/**
 * @author Lo�ck Nosal
 * Cette classe d�finit la vue.
 * La classe VueDessin est une vue et impl�mente donc l�interface Observer. La m�thode
 * update sera d�clench�e � chaque modification du mod�le
 */
public class VueDessin extends JPanel implements Observer{
	
	/**
	 * Mod�le
	 */
	private DessinModele dessin;
	/**
	 * Objet "listener" pour les manipulations et transformations de figures via la souris
	 */
	private ManipulateurFormes mf;
	/**
	 * jpanel traceurforme pour les traits
	 */
	private TraceurForme tf;
	/**
	 * permet de g�rer les copies de figures
	 */
	private CopieFigure cf;
	/**
	 * gomme du dessin
	 */
	private Gomme go;
	/**
	 * curseur de base de la vuedessin
	 */
	private Cursor CurseurMainOuverte;
	/**
	 * curseur mainfermee, lorsque le clique est active sur le dessin
	 */
	private Cursor CurseurMainFermee;
	/**
	 * permet d'ecrire du texte dans le JPanel
	 */
	private DrawText dt;
	/**
	 * curseur de base du texte
	 */
	private Cursor CurseurTexte;
	/**
	 * curseur vide (blanc) lorsque l'on clique dans texte
	 */
	private Cursor CurseurVide;
	
	
	public Cursor getCurseurMainOuverte() {
		return this.CurseurMainOuverte;
	}
	
	public Cursor getCurseurMainFermee() {
		return this.CurseurMainFermee;
	}
	
	public Cursor getCurseurTexte() {
		return this.CurseurTexte;
	}
	
	public Cursor getCurseurVide() {
		return this.CurseurVide;
	}
	
	
	public void setCurseurMainOuverte(Cursor c) {
		this.CurseurMainOuverte = c;
	}
	
	public void setCurseurMainFermee(Cursor c) {
		this.CurseurMainFermee = c;
	}
	
	public void setCurseurTexte(Cursor c) {
		this.CurseurTexte = c;
	}
	
	public void setCurseurVide(Cursor c) {
		this.CurseurVide = c;
	}
	
	/**
	 * permet de changer le curseur du dessin
	 */
	public void changeCurseurTexte() {
		if (this.getCursor() == this.CurseurTexte) {
			this.setCursor(this.CurseurVide);
		}else if (this.getCursor() == this.CurseurVide) {
			this.setCursor(this.CurseurTexte);
		}
	}

	/**
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
	
	/**
	 * mise � jour de la vue
	 */
	public void update(Observable o, Object ob) {
		this.dessin = (DessinModele)o;
		repaint();
	}
	
	/**
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
	
	/**
	 * PaintComponent du Jpanel
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if (this.dessin.get_fg() != null) {
			for (FigureColoree fg : this.dessin.get_fg()) {
				g.setColor(fg.getColor());
				fg.afficher(g);
				
			}
		}

		
		
	}
	/**
	 * Cette m�thode permet d'initier le m�canisme �v�nementiel de fabrication des figures � la souris (ajout du listener).
	 * @param f figure � construire
	 */
	public void construit(FigureColoree f) {
		if (f != null) {
			FabricantFigures ff = new FabricantFigures(f);
			this.addMouseListener(ff);
		}
	
	}
	
	/**
	 * permet d'ajouter un trait en tant que figureColoree
	 * @param t trait � ajouter
	 */
	public void ajouterTrait(Trait t) {	
		if(this.tf != null) {
			this.dessin.ajoute(t);
		}
	}
	
	/**
	 * permet d'ajouter un texte en tant que figureColoree
	 * @param t texte � ajouter
	 */
	public void ajouterTexte(Texte t) {
		if (this.dt != null) {
			this.dessin.ajoute(t);
		}
	}
	
	/**
	 *  Cette m�thode permet de tracer des traits � la souris (ajout du listener).
	 *  @param c couleur du trait
	 *  @param e epaisseur du trait
	 */
	public void trace(Color c,float e) {
		this.desactiverToutListener();
		this.tf = new TraceurForme(this.getGraphics(),e);
		this.tf.setColor(c);
		this.addMouseListener(this.tf);
		this.addMouseMotionListener(this.tf);
		
	}
	
	/**
	 * Cette m�thode permet d'initier le m�canisme de manipulation des figures � la souris (ajout du listener).
	 */
	public void manip() {
		this.mf = new ManipulateurFormes(this.dessin);
		this.desactiverToutListener();	
		this.addMouseListener(this.mf);
		this.addMouseMotionListener(this.mf);		
		
	}
	
	/**
	 * permet de gommer des figures ou des traits
	 */
	public void gommer() {

		this.go = new Gomme(this.dessin);
		this.desactiverToutListener();
		this.addMouseListener(this.go);
		this.addMouseMotionListener(this.go);
	}
	
	/*
	 * permet d'ecrire du texte
	 */
	public void ecrire(Color c,int taille) {

		this.dt = new DrawText(this.getGraphics(),taille);
		this.dt.setCouleurTexte(c);
		this.desactiverToutListener();
		this.addMouseListener(this.dt);
		this.addKeyListener(this.dt);
		this.setFocusable(true);
		this.requestFocusInWindow();
	}
	
	/**
	 * permet de copier une figure (clone)
	 */
	public void copieFigure() {

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
	
	public DrawText getDrawText() {
		return this.dt;
	}
	
	/**
	 * M�thode d�sactivant les listeners
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
	
	/**
	 * permet de sauvegarder le dessin en image pour ensuite l'exporter en .png
	 */
	public Graphics2D saveImage() {
		BufferedImage image = new BufferedImage(getWidth(),getHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = image.createGraphics();
		return g2;
	}
	


}
