package vue;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import controleur.FabricantFigures;
import controleur.ManipulateurFormes;
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
	private ManipulateurFormes mf;
	
	public VueDessin() {
		this.dessin = new DessinModele();
		this.setFocusable(true);
		this.requestFocusInWindow();
	}
	
	public void update(Observable o, Object ob) {
		this.dessin = (DessinModele) o;
		repaint();
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		if (this.dessin.get_fg() != null) {
			for (FigureColoree fg : this.dessin.get_fg()) {
				fg.afficher(g);
			}
		}		
		
	}
	
	public void construit(FigureColoree f) {
		if (f != null) {
			FabricantFigures ff = new FabricantFigures(f);
			this.addMouseListener(ff);
		}
	
	}
	
	public void manip() {
		ArrayList<FigureColoree> f = this.dessin.get_fg();
		ManipulateurFormes mf = new ManipulateurFormes(this.dessin, f);
		this.addMouseListener(mf);
		this.addMouseMotionListener(mf);
	}
	
	public DessinModele getDessin() {
		return this.dessin;
	}

}
