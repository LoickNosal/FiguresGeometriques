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

public class DrawText implements MouseListener, KeyListener{
	
	private Graphics g;
	private int x;
	private int y;
	private String s;
	private ArrayList<Texte> listeTexte;
	private boolean ecrit;
	private boolean peutEcrire;
	private Color couleurTexte;
	
	public DrawText(Graphics gr) {
		this.g = gr;
		this.x = -1;
		this.y = -1;
		this.s = "";
		this.listeTexte = new ArrayList<Texte>();
		this.ecrit = false;
		this.peutEcrire = false;
		this.couleurTexte = Color.black;
	}
	
	public void setCouleurTexte(Color c) {
		this.couleurTexte = c;
		System.out.println(c);
	}
	
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
	public void keyPressed(KeyEvent e) {
		System.out.println(ecrit);
		if (ecrit == true) {
			if (this.s.equals("")) {
				this.listeTexte.add(new Texte(-1, this.s, this.couleurTexte, this.x, this.y));
				((VueDessin)e.getSource()).ajouterTexte(this.listeTexte.get(this.listeTexte.size()-1));
				this.peutEcrire = true;
			}
			
			if (this.peutEcrire == true) {
				if(e.getKeyCode() != KeyEvent.VK_ENTER) { //entrer
					if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) { //supprimer dernier caractère
						if (this.s.length()>0) {
							this.s = this.s.substring(0, this.s.length()-1);
							System.out.println(s);
							this.listeTexte.get(this.listeTexte.size()-1).setTexte(this.s);
							((VueDessin)e.getSource()).repaint();
						}
						
					}else {
						this.s = s + e.getKeyChar();
						System.out.println(s);
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
