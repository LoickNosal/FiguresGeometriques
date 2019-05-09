package main;
import java.awt.BorderLayout;
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
	
	private JPanel principal;
	private JPanel choix;
	private VueDessin vdessin;
	
	/*
	 * Constructeur de la classe
	 */
	public Fenetre(String s, int w, int h) {
		JFrame fenetre = new JFrame(s);
		fenetre.setSize(w,h);
		VueDessin vd = new VueDessin();
		PanneauChoix ch = new PanneauChoix(vd);
		this.principal = vd;
		this.choix = ch;
		fenetre.setLayout(new BorderLayout());
		fenetre.add(this.choix,BorderLayout.NORTH);
		fenetre.add(this.principal,BorderLayout.SOUTH);
		fenetre.setPreferredSize(new Dimension(800,600));
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
		fenetre.pack();
		fenetre.setVisible(true);

		
	}
	
	/*
	 * Programme principale
	 */
	public static void main(String[] args) {
		System.out.println("test");
		JFrame fenetre = new Fenetre("FG",800,600);
	}
}
