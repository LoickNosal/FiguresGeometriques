package controleur;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import modele.DessinModele;
import modele.FigureColoree;
import modele.Quadrilatere;
import vue.VueDessin;

/*
 * @author Loïck Nosal
 * Cette classe définit une partie du controleur.
 * La classe PanneauChoix est un contrôleur, le modèle est passé en paramètre de son
 * constructeur et, suite à une action de l’utilisateur, il fournit au modèle les informations pour se
 * modifier en appelant une de ses méthodes.
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
		//seletionné par defaut avec le true
		JRadioButton tml = new JRadioButton ("Tracé à main levée",true);
		JRadioButton ma = new JRadioButton ("Manipulation");
		
		
		final JComboBox fig = new JComboBox (new String [] {"triangle","rectangle"});
		final JComboBox c = new JComboBox (new String [] {"rouge","vert","jaune","bleu"});
		
		fig.setEnabled(false);
		
	
		
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
		
		
		ActionListener auditeurBoutons = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JRadioButton source = (JRadioButton)e.getSource();
				if(source.equals(nf)){ //Nouvelle figure
					fig.setEnabled(true);
				
//					for (int i=0; i<dmodele.get_fg().size(); i++){
//						dmodele.get_fg().get(i).deSelectionne();
//					}
				}else if(source.equals(tml)){
					fig.setEnabled(false);
				}else if(source.equals(ma)) {
					fig.setEnabled(false);
				}
				else {
					fig.setEnabled(false);
				}
			}
		};
		
		nf.addActionListener(auditeurBoutons);
		tml.addActionListener(auditeurBoutons);
		ma.addActionListener(auditeurBoutons);
	}
	
	/*
	 * Methode determinant la couleur à utiliser
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
		case 4:
			return Color.black;
		case 5:
			return Color.pink;
		case 6:
			return Color.gray;
		default:
			return Color.black;
			
		}
	}
	/*
	 * Méthode implémentant la création d'une forme géométrique.
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
