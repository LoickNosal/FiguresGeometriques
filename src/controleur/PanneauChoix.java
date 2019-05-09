package controleur;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import javafx.scene.layout.Border;
import modele.DessinModele;
import vue.VueDessin;
/*
 * Cette classe définit une partie du controleur.
 */
public class PanneauChoix extends JPanel{
	
	private VueDessin vdessin;
	private DessinModele dmodele;
	
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
		JRadioButton tml = new JRadioButton ("Tracé à main levée");
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
	 * Methode determinant la couleur à utiliser
	 */
	public Color determineCouleur(int index) {
		Color c = new Color(index);
		return c;
	}

}
