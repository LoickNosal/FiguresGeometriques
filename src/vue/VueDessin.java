package vue;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import modele.DessinModele;

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

}
