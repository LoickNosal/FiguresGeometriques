package controleur;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import modele.DessinModele;
import modele.FigureColoree;
import vue.VueDessin;

/*
 * @author Lo�ck Nosal
 * Cette classe d�finit une partie du controleur.
 */
public class PanneauChoix extends JPanel{
	
	private VueDessin vdessin;
	private DessinModele dmodele;
	private FigureColoree fc;
	
	/*
	 * Constructeur de la classe
	 */
	public PanneauChoix(VueDessin v) {
		this.vdessin = v;
		this.setLayout(new BorderLayout());
		JPanel placementHaut  = new JPanel();
		JPanel placementBas  = new JPanel();
		ButtonGroup bg = new ButtonGroup();
		
		JRadioButton nf = new JRadioButton ("Nouvelle figure");
		JRadioButton tml = new JRadioButton ("Trac� � main lev�e");
		JRadioButton ma = new JRadioButton ("Manipulation");
		final JComboBox fig = new JComboBox (new String [] {"triangle","rectangle"});
		final JComboBox c = new JComboBox (new String [] {"rouge","vert","jaune","bleu"});
		
		bg.add(nf);
		bg.add(tml);
		bg.add(ma);
		
		placementHaut.add(nf);
		placementHaut.add(tml);
		placementHaut.add(ma);
		
		placementBas.add(fig);
		placementBas.add(c);
		
		this.add(placementHaut,BorderLayout.NORTH);
		this.add(placementBas,BorderLayout.SOUTH);
	}
	
	/*
	 * Methode determinant la couleur � utiliser
	 */
	public Color determineCouleur(int index) {
		Color c = new Color(index);
		return c;
	}
	
	public FigureColoree creeFigure(int i) {
		throw new Error("pas fait");
	}

}
