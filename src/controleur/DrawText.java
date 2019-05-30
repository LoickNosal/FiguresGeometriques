package controleur;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javafx.scene.input.KeyCode;
import modele.Texte;
import vue.VueDessin;

public class DrawText implements MouseListener, KeyListener{
	
	private Graphics g;
	private int x;
	private int y;
	private String s;
	private ArrayList<Texte> listeTexte;
	private boolean ecrit;
	
	public DrawText(Graphics gr) {
		this.g = gr;
		this.x = -1;
		this.y = -1;
		this.s = "";
		this.listeTexte = new ArrayList<Texte>();
		this.ecrit = false;
	}
	
	public void changeEcrit() {
		if (this.ecrit == true) {
			this.ecrit = false;
			
		}else {
			this.ecrit = true;
			
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
//		if (e.getKeyCode() == KeyEvent.VK_ENTER) { //space
//			System.out.println("teazfazfazst");
//		}
//		System.out.println(e.getKeyChar());
////		if (e.getKeyChar() == 'r') {
////			Texte t = new Texte(1f,"test",Color.red,this.x,this.y);
////			this.g.drawString("test", this.x, this.y);
//			((VueDessin)e.getSource()).ajouterTexte(t);
//		}
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if (this.s.equals("")) {
			this.listeTexte.add(new Texte(-1, this.s, this.g.getColor(), this.x, this.y));
			((VueDessin)e.getSource()).ajouterTexte(this.listeTexte.get(this.listeTexte.size()-1));
			ecrit = true;
		}
		
		if (ecrit == true) {
			if(e.getKeyCode() != KeyEvent.VK_ENTER) { //space
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
				
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {}
 
	@Override
	public void mouseClicked(MouseEvent e) {
		this.changeEcrit();
		((VueDessin)e.getSource()).setCursor(((VueDessin)e.getSource()).getCurseurVide());
		this.s = "";
		this.x = -1;
		this.y = -1;
		this.x = e.getX();
		this.y = e.getY();
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		this.changeEcrit();
		((VueDessin)e.getSource()).setCursor(((VueDessin)e.getSource()).getCurseurVide());
		this.s = "";
		this.x = -1;
		this.y = -1;
		this.x = e.getX();
		this.y = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

}
