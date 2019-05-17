package vue;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import modele.DessinModele;
import modele.FigureColoree;

/*
 * @author Lo�ck Nosal
 * Cette classe d�finit la vue.
 * La classe VueDessin est une vue et impl�mente donc l�interface Observer. La m�thode
 * update sera d�clench�e � chaque modification du mod�le
 */
public class VueDessin extends JPanel implements Observer{
	
	private DessinModele dessin;
	
	public VueDessin() {
		this.setFocusable(true);
		this.requestFocusInWindow();
	}
	
	public void update(Observable o, Object ob) {
		repaint();
	}
	
	public void paintComponent(Graphics g) {
		System.out.println("refresh");
	}
	
	public void construit(FigureColoree f) {
		throw new Error("pas fait");
	}
	
	public DessinModele getDessin() {
		return this.dessin;
	}

}
