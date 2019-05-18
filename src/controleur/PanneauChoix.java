package controleur;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import modele.DessinModele;
import modele.FigureColoree;
import modele.Quadrilatere;
import modele.Triangle;
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
		//seletionn� par defaut avec le true
		JRadioButton tml = new JRadioButton ("Trac� � main lev�e",true);
		JRadioButton ma = new JRadioButton ("Manipulation");
		
		
		final JComboBox fig = new JComboBox (new String [] {"rectangle","triangle"});

		final JComboBox co = new JComboBox (new String [] {"noir","vert","jaune","bleu","rouge","rose","gris"});
		

		

		bg.add(nf);
		bg.add(tml);
		bg.add(ma);
		
		placementHaut.add(nf);
		placementHaut.add(tml);
		placementHaut.add(ma);
		
		placementBas.add(fig);
		placementBas.add(co);
		
		fig.setEnabled(false);
		
		this.add(placementHaut,BorderLayout.NORTH);
		this.add(placementBas,BorderLayout.SOUTH);
		
		
		ActionListener ALboutons = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JRadioButton source = (JRadioButton)e.getSource();
				if(source.equals(nf)){ 
					fig.setEnabled(true);
					co.setEnabled(true);
				}else if(source.equals(tml)){
					fig.setEnabled(false);
					co.setEnabled(true);
				}else if(source.equals(ma)) {
					fig.setEnabled(false);
					co.setEnabled(false);
				}else {
					fig.setEnabled(false);
				}
			}
		};
		
		nf.addActionListener(ALboutons);
		tml.addActionListener(ALboutons);
		ma.addActionListener(ALboutons);
		
		
		
		
		co.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Color c = determineCouleur(co.getSelectedIndex());
				if (nf.isSelected() && c!= null) {
					fc.changeCouleur(c);
					vdessin.repaint();
				}
				
			}
		});
		
		
		
		fig.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){

				fc = creeFigure(fig.getSelectedIndex());
				Color c = determineCouleur(co.getSelectedIndex());
				
				if (fc != null){
					fc.changeCouleur(c);
					vdessin.construit(fc);
	
				}
			}
		});

	}
	
	/*
	 * Methode determinant la couleur � utiliser
	 */
	public Color determineCouleur(int index) {
		switch(index) {
		case 0 : 
			return Color.black;
		case 1 :
			return Color.green;
		case 2:
			return Color.yellow;
		case 3:
			return Color.blue;
		case 4:
			return Color.red;
		case 5:
			return Color.pink;
		case 6:
			return Color.gray;
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
		case 1:
			return new Triangle();
		default :
			return null;
		}
	}

}
