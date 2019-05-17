package controleur;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import modele.DessinModele;
import modele.FigureColoree;
import modele.Quadrilatere;
import vue.VueDessin;

/*
 * @author Lo�ck Nosal
 * Cette classe d�finit une partie du controleur.
 * La classe PanneauChoix est un contr�leur, le mod�le est pass� en param�tre de son
 * constructeur et, suite � une action de l�utilisateur, il fournit au mod�le les informations pour se
 * modifier en appelant une de ses m�thodes.
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
		
		if (nf.isSelected()) {
			System.out.println("ah");
		}else if(tml.isSelected()) {
			
		}else if(ma.isSelected()) {
			
		}
		
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
		switch(index) {
		case 0 : 
			return Color.red;
		case 1 :
			return Color.green;
		case 2:
			return Color.blue;
		case 3:
			return Color.yellow;
		default:
			return Color.black;
			
		}
	}
	/*
	 * M�thode impl�mentant la cr�ation d'une forme g�om�trique.
	 */
	public FigureColoree creeFigure(int index) {
		switch(index) {
		case 0:
			return new Quadrilatere();
		default :
			return null;
		}
	}

}
