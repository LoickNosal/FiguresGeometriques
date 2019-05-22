package controleur;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import modele.Carre;
import modele.Cercle;
import modele.DessinModele;
import modele.FigureColoree;
import modele.Quadrilatere;
import modele.Rectangle;
import modele.Triangle;
import vue.VueDessin;

/*
 * @author Lo�ck Nosal
 * Cette classe d�finit une partie du controleur.
 */
public class PanneauChoix extends JPanel{
	/*
	 * zone de dessin
	 */
	private VueDessin vdessin;
	/*
	 * modele
	 */
	private DessinModele dmodele;
	/*
	 * figure � construire
	 */
	private FigureColoree fc;
	
	/*
	 * Constructeur de la classe
	 * @param v zone de dessin
	 */
	public PanneauChoix(VueDessin v) {
		this.vdessin = v;
		this.dmodele = v.getDessin();
		this.dmodele.addObserver(this.vdessin);
		
		
		this.setLayout(new BorderLayout());
		JPanel placementHaut  = new JPanel();
		//placementHaut.setBackground(new Color(227,227,227));
		JPanel placementBas  = new JPanel();
		//placementBas.setBackground(new Color(227,227,227));
		ButtonGroup bg = new ButtonGroup();
		
		JRadioButton nf = new JRadioButton ("Nouvelle figure");

		JRadioButton tml = new JRadioButton ("Trac� � main lev�e");
		JRadioButton ma = new JRadioButton ("Manipulation");
		
		
		final JComboBox fig = new JComboBox (new String [] {"quadrilatere","triangle","rectangle","carre", "Cercle"});
		final JComboBox co = new JComboBox (new String [] {"noir","vert","jaune","bleu","rouge","rose","gris"});
		
//		final JButton supp = new JButton("Effacer figure");
//		
//		final JButton suppTout = new JButton("Effacer Tout");

		final JMenuBar menuBar = new JMenuBar();
		final JMenu menuSupp = new JMenu("Effacer");
		
		JMenuItem supp = new JMenuItem("Effacer figure");
		JMenuItem suppTout = new JMenuItem("Effacer Tout");
		
		
		menuSupp.add(supp);
		menuSupp.add(suppTout);
		

		menuBar.add(menuSupp);
		
		bg.add(nf);
		bg.add(tml);
		bg.add(ma);
		
		placementHaut.add(nf);
		placementHaut.add(tml);
		placementHaut.add(ma);
		
		placementBas.add(fig);
		placementBas.add(co);

		
		fig.setEnabled(false);
		supp.setEnabled(false);
		co.setEnabled(true);
		suppTout.setEnabled(false);
		
		this.add(menuBar,BorderLayout.NORTH);
		this.add(placementHaut,BorderLayout.CENTER);
		this.add(placementBas,BorderLayout.SOUTH);
		//definit l'ensemble des actions des jRadioButton
		ActionListener ALboutons = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JRadioButton source = (JRadioButton)e.getSource(); 
				
				if(source.equals(nf)){ 
					fig.setEnabled(true);
					supp.setEnabled(false);
					suppTout.setEnabled(false);
					co.setEnabled(false);
					vdessin.desactiverToutListener();
					dmodele.deselectTous();
					vdessin.repaint();
					
				}else if(source.equals(tml)){
					
					fig.setEnabled(false);
					supp.setEnabled(false);
					suppTout.setEnabled(false);
					co.setEnabled(true);
					//vdessin.desactiverToutListener();
					dmodele.deselectTous();
					vdessin.repaint();
					
				}else if(source.equals(ma)) {
					
					fig.setEnabled(false);
					supp.setEnabled(true);
					suppTout.setEnabled(true);
					co.setEnabled(true);
					dmodele.deselectTous();
					
					vdessin.repaint();
					
				}else {
					fig.setEnabled(false);
					supp.setEnabled(false);
					suppTout.setEnabled(false);
					co.setEnabled(true);
					
					vdessin.desactiverToutListener();
					dmodele.deselectTous();
					vdessin.repaint();
				}
			}
		};
		
		nf.addActionListener(ALboutons);
		tml.addActionListener(ALboutons);
		ma.addActionListener(ALboutons);
		
		
		
		
		//permet de determiner la couleur, pour une nouvelle figure,
		//pour un trait ou quand on modifie une figure.
		co.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Color c = determineCouleur(co.getSelectedIndex());
				if (nf.isSelected() && c!= null && fc != null) {
					fc.changeCouleur(c);
					vdessin.repaint();
					//fc = null;
				}else if (ma.isSelected() && c!= null && fc != null) {
					if (vdessin.getManipulateurFormes().figureSelection() != null) {
						vdessin.getManipulateurFormes().figureSelection().changeCouleur(c);
					}
					vdessin.repaint();
				}else if (tml.isSelected() && c!= null) {
					vdessin.getTraceurForme().setColor(c);
					vdessin.repaint();
				}
			}
		});
		
		//permet de construire une nouvelle figure
		fig.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				co.setEnabled(false);
				fc = creeFigure(fig.getSelectedIndex());
				Color c = determineCouleur(co.getSelectedIndex());
				
				if (fc != null){
					fc.changeCouleur(c);
					vdessin.construit(fc);
					co.setEnabled(true);
				}
				
			}
		});
		
		//permet de manipuler les figures
		ma.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				vdessin.manip();
			}
		});
		
		//permet de tracer des traits
		tml.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Color c = determineCouleur(co.getSelectedIndex());
				vdessin.trace(c);
				
			}
		});
		
		//permet de supprimer une figure g�ometrique
		supp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dmodele.supprimerFigure();
				vdessin.getManipulateurFormes().setSel(-1);
				dmodele.deselectTous();
				vdessin.repaint();
			}
		});
		
		
		//Permet de supprimer l'ensemble du dessin (figures et traits)
		suppTout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dmodele.supprimerTout();
				vdessin.getManipulateurFormes().setSel(-1);
				vdessin.desactiverToutListener();
				dmodele.deselectTous();
				vdessin.repaint();
				
			
			}
		});

	}
	
	/*
	 * Methode determinant la couleur � utiliser
	 * @param index index de couleur dans le jcombobox
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
	 * @param index index de la figure dans le jcombobox
	 */
	public FigureColoree creeFigure(int index) {
		switch(index) {
		case 0:
			return new Quadrilatere();
		case 1:
			return new Triangle();
		case 2:
			return new Rectangle();
		case 3:
			return new Carre();
		case 4:
			return new Cercle();
		default :
			return null;
		}
	}
	
	

}
