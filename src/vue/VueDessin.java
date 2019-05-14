package vue;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import modele.DessinModele;
import modele.FigureColoree;

/*
 * @author Loïck Nosal
 * Cette classe définit la vue.
 */
public class VueDessin extends JPanel implements Observer{
	
	private DessinModele dessin;
	
	public VueDessin() {
		System.out.println("test2");
	}
	
	public void update(Observable o, Object ob) {
		throw new Error (" code non ecrit ");
	}
	
	public void paintComponent(Graphics g) {
		System.out.println("refresh");
	}
	
	public void construit(FigureColoree f) {
		throw new Error("pas fait");
	}
	
	public DessinModele getDessin() {
		throw new Error("pas fait");
	}

}
