package controleur;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.KeyStroke;



import modele.Carre;
import modele.Cercle;
import modele.DessinModele;
import modele.FigureColoree;
import modele.Quadrilatere;
import modele.Rectangle;
import modele.Triangle;
import vue.VueDessin;

/*
 * @author Loïck Nosal
 * Cette classe définit une partie du controleur.
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
	 * figure à construire
	 */
	private FigureColoree fc;
	
	/*
	 * couleur actuellement selectionnee
	 */
	private Color couleurActuelle;
	
	/*
	 * Constructeur de la classe
	 * @param v zone de dessin
	 */
	public PanneauChoix(VueDessin v) {
		this.vdessin = v;
		this.dmodele = v.getDessin();
		this.dmodele.addObserver(this.vdessin);
		this.couleurActuelle = Color.black;
		
		
		this.setLayout(new BorderLayout());
		JPanel placementHaut  = new JPanel();
		//placementHaut.setBackground(new Color(227,227,227));
		JPanel placementBas  = new JPanel();
		//placementBas.setBackground(new Color(227,227,227));
		ButtonGroup bg = new ButtonGroup();
		
		JRadioButton nf = new JRadioButton ("Nouvelle figure");

		JRadioButton tml = new JRadioButton ("Tracé à main levée");
		
		JRadioButton ma = new JRadioButton ("Manipulation");
		
		JButton copie = new JButton("Copier Figure");
		
		JRadioButton gom = new JRadioButton ("Gomme");
		
		JButton couleur = new JButton();

		
		final JComboBox fig = new JComboBox (new String [] {"quadrilatere","triangle","rectangle","carre", "Cercle"});
		final JComboBox co = new JComboBox (new String [] {"noir","vert","jaune","bleu","rouge","rose","gris","personnalisée"});
		

		final JMenuBar menuBar = new JMenuBar();
		
		final JMenu menuSupp = new JMenu("Effacer");
		JMenuItem supp = new JMenuItem("Effacer figure");
		JMenuItem suppTout = new JMenuItem("Effacer Tout");
		menuSupp.add(supp);
		menuSupp.add(suppTout);
		supp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE,0));
		suppTout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE,InputEvent.CTRL_DOWN_MASK));
		
		
		final JMenu menuFichier = new JMenu("Fichier");
		JMenuItem sauver = new JMenuItem("Enregistrer");
		JMenuItem charger = new JMenuItem("Ouvrir");
		JMenuItem quitter = new JMenuItem("Quitter");
		menuFichier.add(sauver);
		menuFichier.add(charger);
		menuFichier.add(quitter);
		
		sauver.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_DOWN_MASK));
		charger.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,InputEvent.CTRL_DOWN_MASK));
		
		final JMenu aide = new JMenu("Aide");
		JMenuItem modeEmploi = new JMenuItem("mode d'Emploi");
		//JMenuItem Description = new JMenuItem("Description des fonctionnalitées");
		aide.add(modeEmploi);
		//aide.add(Description);
		modeEmploi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H,0));
		
		menuBar.add(menuFichier);
		menuBar.add(menuSupp);
		menuBar.add(aide);
		
		
		bg.add(nf);
		bg.add(tml);
		bg.add(ma);
		bg.add(gom);
		
		placementHaut.add(nf);
		placementHaut.add(tml);
		placementHaut.add(ma);
		placementHaut.add(copie);
		placementHaut.add(gom);
		
		placementBas.add(fig);
		placementBas.add(co);
		placementBas.add(couleur);
		
		couleur.setEnabled(false);
		couleur.setBackground(Color.black);
		
		fig.setEnabled(false);
		supp.setEnabled(false);
		co.setEnabled(true);
		suppTout.setEnabled(false);
		copie.setEnabled(false);
		
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
					copie.setEnabled(false);
					vdessin.desactiverToutListener();
					dmodele.deselectTous();
					vdessin.repaint();
					
				}else if(source.equals(tml)){
					
					fig.setEnabled(false);
					supp.setEnabled(false);
					suppTout.setEnabled(false);
					co.setEnabled(true);
					copie.setEnabled(false);
					//vdessin.desactiverToutListener();
					dmodele.deselectTous();
					vdessin.repaint();
					
				}else if(source.equals(ma)) {
					fig.setEnabled(false);
					supp.setEnabled(true);
					suppTout.setEnabled(true);
					co.setEnabled(true);
					dmodele.deselectTous();
					copie.setEnabled(true);
					vdessin.repaint();
				
					vdessin.repaint();
				}else if(source.equals(gom)) {
					
					fig.setEnabled(false);
					supp.setEnabled(false);
					suppTout.setEnabled(false);
					co.setEnabled(false);
					copie.setEnabled(false);

					dmodele.deselectTous();
					vdessin.repaint();
				}else {
					fig.setEnabled(false);
					supp.setEnabled(false);
					suppTout.setEnabled(false);
					co.setEnabled(true);
					copie.setEnabled(false);
					
					vdessin.desactiverToutListener();
					dmodele.deselectTous();
					vdessin.repaint();
				}
			}
		};
		
		nf.addActionListener(ALboutons);
		tml.addActionListener(ALboutons);
		ma.addActionListener(ALboutons);
		gom.addActionListener(ALboutons);
		
		quitter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int q = JOptionPane.showConfirmDialog(getParent(), "Quitter l'application ?");
				if (q == JOptionPane.YES_OPTION) {
					System.exit(1);
				}
				
				
			}
		});
		
		
		//permet de determiner la couleur, pour une nouvelle figure,
		//pour un trait ou quand on modifie une figure.
		co.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				determineCouleur(co.getSelectedIndex());
				
				couleur.setBackground(couleurActuelle);
				
				if (nf.isSelected() && couleurActuelle!= null && fc != null) {
					fc.changeCouleur(couleurActuelle);
				
					vdessin.repaint();
					//fc = null;
				}else if (ma.isSelected() && couleurActuelle!= null && fc != null) {
					if (vdessin.getManipulateurFormes().figureSelection() != null) {
						System.out.println("test");
						vdessin.getManipulateurFormes().figureSelection().changeCouleur(couleurActuelle);
					}
					vdessin.repaint();
				}else if (tml.isSelected() && couleurActuelle!= null) {
				
					vdessin.getTraceurForme().setColor(couleurActuelle);
					vdessin.repaint();
				}
			}
		});
		
		//permet de construire une nouvelle figure
		fig.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				co.setEnabled(false);
				fc = creeFigure(fig.getSelectedIndex());				
				if (fc != null){
					fc.changeCouleur(couleurActuelle);
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
		
		//permet de copier les figures
		copie.addActionListener(new ActionListener() {
					
			@Override
			public void actionPerformed(ActionEvent e) {
				vdessin.copieFigure();
			}
		});
		
		
		
		
		//permet de tracer des traits
		tml.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				vdessin.trace(couleurActuelle);
				
			}
		});
		
		gom.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				vdessin.gommer();
				
			}
		});
		
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
		
		sauver.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				fc.setDialogTitle("Sauvegarder le fichier");
				fc.setCurrentDirectory(new java.io.File("Sauvegardes"));
				File result;
				if (fc.showOpenDialog(null)== JFileChooser.APPROVE_OPTION) {
						result = fc.getSelectedFile();;
						System.out.println(result.getAbsolutePath());
						try {
							dmodele.sauvegarder(result);
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,"La sauvegarde du dessin est impossible","Sauvegarde impossible",JOptionPane.WARNING_MESSAGE);
						}
					}
				
			}
		});
		
		charger.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					JFileChooser fc = new JFileChooser();
					fc.setDialogTitle("Charger un fichier");
					fc.setCurrentDirectory(new java.io.File("Sauvegardes"));
					File result;
					if (fc.showOpenDialog(null)== JFileChooser.APPROVE_OPTION) {
							result = fc.getSelectedFile();;
							System.out.println(result.getAbsolutePath());
							try {
							
								dmodele.deleteObservers();
								dmodele = dmodele.charger(result);
								dmodele.addObserver(vdessin);
								
								
								vdessin.setDessin(dmodele);
								ManipulateurFormes mf = new ManipulateurFormes(dmodele);
								vdessin.setMF(mf);
								dmodele.deselectTous();
								
							
								ma.setSelected(false);
								nf.setSelected(true);
								
								vdessin.repaint();
								
							} catch (Exception ex) {
								JOptionPane.showMessageDialog(null,"Le fichier chargé n'est pas un dessin","Chargement impossible",JOptionPane.WARNING_MESSAGE);
							}
						}
					

				
			}
		});
		
		modeEmploi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if ((new File("..\\FiguresGeometriques\\ModeEmploi.pdf")).exists()) {

						Process p = Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler ..\\FiguresGeometriques\\ModeEmploi.pdf");
						p.waitFor();
						System.out.println("charge");
							
					} else {
						JOptionPane.showMessageDialog(null,"Mode d'emploi introuvable","Chargement impossible",JOptionPane.WARNING_MESSAGE);
						System.out.println("File is not exists");

					}


			  	  } catch (Exception ex) {
					ex.printStackTrace();
				  }
				
			}
		});

	}
	
	/*
	 * Methode determinant la couleur à utiliser
	 * @param index index de couleur dans le jcombobox
	 */
	public void determineCouleur(int index) {
		switch(index) {
		case 0 : 
			this.couleurActuelle = Color.black;
			break;
		case 1 :
			this.couleurActuelle = Color.green;
			break;
		case 2:
			this.couleurActuelle = Color.yellow;
			break;
		case 3:
			this.couleurActuelle = Color.blue;
			break;
		case 4:
			this.couleurActuelle = Color.red;
			break;
		case 5:
			this.couleurActuelle = Color.pink;
			break;
		case 6:
			this.couleurActuelle = Color.gray;
			break;
		case 7:
			Color c = couleurPerso();
			this.couleurActuelle = c;
			break;
		default:
			this.couleurActuelle = Color.black;
			break;

			
		}
	}
	/*
	 * Méthode implémentant la création d'une forme géométrique.
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
	
	public Color couleurPerso() {
		Color couleur = JColorChooser.showDialog(null, "couleur du fond", Color.WHITE);
		return couleur;
	}
	
	

}
