package controleur;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;


import modele.Texte;
import vue.VueDessin;

/**
 * @author Loïck
 * permet d'ecrire sur le dessin
 */
public class DrawText implements MouseListener, KeyListener{
	
	/**
	 * Graphics sur lequel ecrire
	 */
	private Graphics g;
	/**
	 * position x afin d'ecrire à l'endroit souhaité (souris)
	 */
	private int x;
	/**
	 * position y afin d'ecrire à l'endroit souhaité (souris)
	 */
	private int y;
	/**
	 * Texte à écrire
	 */
	private String s;
	/**
	 * liste des textes
	 */
	private ArrayList<Texte> listeTexte;
	/**
	 * vrai si est en train d'écrire un texte
	 */
	private boolean ecrit;
	/**
	 * vrai si on peut écrire un texte
	 */
	private boolean peutEcrire;
	/**
	 * couleur du texte à écrire
	 */
	private Color couleurTexte;
	/**
	 * taille du texte à écrire
	 */
	private int tailleTexte;
	
	/**
	 * constructeur
	 * @param gr graphics sur lequel écrire
	 * @param taille taille de la police
	 */
	public DrawText(Graphics gr,int taille) {
		this.g = gr;
		this.x = -1;
		this.y = -1;
		this.s = "";
		this.listeTexte = new ArrayList<Texte>();
		this.ecrit = false;
		this.peutEcrire = false;
		this.couleurTexte = Color.black;
		this.tailleTexte = taille;
	}
	
	public void setCouleurTexte(Color c) {
		this.couleurTexte = c;
	}
	
	public void setTailleTexte(int t) {
		this.tailleTexte = t;
	}
	
	/**
	 * permet de passer de l'état "est en train d'écrire" 
	 * à "n'est pas en train d'écrire"
	 * @return indique si on est en train d'écrire ou non
	 */
	public boolean changeEcrit() {
		if (this.ecrit == true) {
			this.ecrit = false;
			return false;
			
		}else {
			this.ecrit = true;
			return true;
			
		}
	}


	@Override
	/**
	 * permet de récupérer les lettres écrites
	 */
	public void keyPressed(KeyEvent e) {
		if (ecrit == true) {
			if (this.s.equals("")) {
				this.listeTexte.add(new Texte(-1, this.s, this.couleurTexte, this.x, this.y,this.tailleTexte));
				((VueDessin)e.getSource()).ajouterTexte(this.listeTexte.get(this.listeTexte.size()-1));
				this.peutEcrire = true;
			}
			
			if (this.peutEcrire == true) {
				if(e.getKeyCode() != KeyEvent.VK_ENTER) { //entrer
					if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) { //supprimer dernier caractère
						if (this.s.length()>0) {
							this.s = this.s.substring(0, this.s.length()-1);
							this.listeTexte.get(this.listeTexte.size()-1).setTexte(this.s);
							((VueDessin)e.getSource()).repaint();
						}
						
					}else {
						this.s = s + e.getKeyChar();
						this.listeTexte.get(this.listeTexte.size()-1).setTexte(this.s);
						((VueDessin)e.getSource()).repaint();

					}
					
				}else {
					if (!this.s.equals("") && this.x != -1 && this.y != -1) {
						this.listeTexte.get(this.listeTexte.size()-1).setTexte(this.s);
						this.listeTexte.get(this.listeTexte.size()-1).afficher(this.g);
						this.s = "";
						this.x = -1;
						this.y = -1;
					}
					((VueDessin)e.getSource()).setCursor(((VueDessin)e.getSource()).getCurseurTexte());
					this.peutEcrire = false;
					this.ecrit = false;
				}
			}
		}	
		
	}
	
	@Override
	/**
	 * permet de changer la position x et y pour écrire où on veut
	 */
	public void mouseClicked(MouseEvent e) {
		this.changeEcrit();
		if (ecrit) {
			((VueDessin)e.getSource()).setCursor(((VueDessin)e.getSource()).getCurseurVide());
			this.s = "";
			this.x = e.getX();
			this.y = e.getY();
		}else {
			((VueDessin)e.getSource()).setCursor(((VueDessin)e.getSource()).getCurseurTexte());
			this.s = "";
			this.x = -1;
			this.y = -1;
		}
		
		
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

}
