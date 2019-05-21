package main;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controleur.PanneauChoix;
import vue.VueDessin;

/*
 * @author Loïck Nosal
 * Cette classe définit l'interface utilisateur et la méthode main.
 */
public class Fenetre extends JFrame{
	
	/*
	 * Panneau principal
	 */
	private JPanel principal;
	/*
	 * Panneau des choix
	 */
	private JPanel choix;
	/*
	 * Vue (MVC)
	 */
	private VueDessin vdessin;
	
	/*
	 * Constructeur de la classe
	 * @param s nom de la fenetre
	 * @param w largeur de la fenetre
	 * @param h longueur de la fenetre
	 */
	public Fenetre(String s, int w, int h) {
		JFrame fenetre = new JFrame(s);
		fenetre.setSize(w,h);
		
		this.vdessin = new VueDessin();
		this.choix = new PanneauChoix(this.vdessin);
		this.principal = new JPanel();
		
		this.principal.setLayout(new BorderLayout());
		this.principal.setPreferredSize(new Dimension(w,h));
		this.principal.add(this.choix,BorderLayout.NORTH);
		this.principal.add(this.vdessin,BorderLayout.CENTER);
		
		
		fenetre.setContentPane(this.principal);
		fenetre.pack();
		fenetre.setPreferredSize(new Dimension(800,800));
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
		fenetre.requestFocusInWindow();
		fenetre.setVisible(true);
		
		this.vdessin.setBackground(Color.white);

		
		

		
	}
	
	/*
	 * Programme principale
	 */
	public static void main(String[] args) {
		JFrame fenetre = new Fenetre("Figures Géométriques",800,600);
	}
}
