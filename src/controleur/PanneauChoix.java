package controleur;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;



import modele.Carre;
import modele.Cercle;
import modele.DessinModele;
import modele.FigureColoree;
import modele.Ligne;
import modele.Quadrilatere;
import modele.Rectangle;
import modele.Triangle;
import vue.VueDessin;

/**
 * @author Loïck Nosal
 * Cette classe définit une partie du controleur.
 */
public class PanneauChoix extends JPanel{
	/**
	 * zone de dessin
	 */
	private VueDessin vdessin;
	/**
	 * modele
	 */
	private DessinModele dmodele;
	/**
	 * figure à construire
	 */
	private FigureColoree fc;
	
	/**
	 * couleur actuellement selectionnee
	 */
	private Color couleurActuelle;
	/**
	 * epaisseur du trait ou de la figure
	 */
	private float epaisseur;
	
	
	/**
	 * Constructeur de la classe
	 * @param v zone de dessin
	 */
	public PanneauChoix(VueDessin v) throws IOException {
		this.vdessin = v;
		this.dmodele = v.getDessin();
		this.dmodele.addObserver(this.vdessin);
		this.couleurActuelle = Color.black;
		this.epaisseur = 1.0f;
	
		
		
		//Icone curseur de souris
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image Gomme = ImageIO.read(new File("..\\FiguresGeometriques\\IconeCurseur\\Gomme.png"));
		Image Pinceau = ImageIO.read(new File("..\\FiguresGeometriques\\IconeCurseur\\Pinceau.png"));
		Image MainOuverte = ImageIO.read(new File("..\\FiguresGeometriques\\IconeCurseur\\MainOuverte.png"));
		Image MainFermee = ImageIO.read(new File("..\\FiguresGeometriques\\IconeCurseur\\MainFermee.png"));
		Image Txt = ImageIO.read(new File("..\\FiguresGeometriques\\IconeCurseur\\txt.png"));
		Cursor CurseurGomme = tk.createCustomCursor(Gomme, new Point(1,1), "Gomme" );
		Cursor CurseurPinceau = tk.createCustomCursor(Pinceau, new Point(1, 1), "Pinceau");
		Cursor CurseurDefaut = Cursor.getDefaultCursor();
		Cursor CurseurMainOuverte = tk.createCustomCursor(MainOuverte, new Point(1,1), "MainOuverte");
		Cursor CurseurTexte = tk.createCustomCursor(Txt, new Point(1,1), "Texte" );
		this.vdessin.setCurseurMainOuverte(tk.createCustomCursor(MainOuverte, new Point(1,1), "MainOuverte"));
		this.vdessin.setCurseurMainFermee(tk.createCustomCursor(MainFermee, new Point(1,1), "MainFermee"));
		this.vdessin.setCurseurTexte(tk.createCustomCursor(Txt, new Point(1,1), "MainOuverte"));
		BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
		this.vdessin.setCurseurVide(tk.createCustomCursor(cursorImg, new Point(0, 0), "blank cursor"));
		
		//Icone JRadioButton et JMenuItem
		ImageIcon iconeNf  = new ImageIcon("..\\FiguresGeometriques\\Icone\\cubes.png");
		ImageIcon iconeNfSelec  = new ImageIcon("..\\FiguresGeometriques\\Icone\\cubesSelec.png");
		ImageIcon iconeTml  = new ImageIcon("..\\FiguresGeometriques\\Icone\\brush.png");
		ImageIcon iconeTmlSelec  = new ImageIcon("..\\FiguresGeometriques\\Icone\\brushSelec.png");
		ImageIcon iconeMa  = new ImageIcon("..\\FiguresGeometriques\\Icone\\manip.png");
		ImageIcon iconeMaSelec  = new ImageIcon("..\\FiguresGeometriques\\Icone\\manipSelec.png");
		ImageIcon iconeGomme  = new ImageIcon("..\\FiguresGeometriques\\Icone\\gomme.png");
		ImageIcon iconeGommeSelec  = new ImageIcon("..\\FiguresGeometriques\\Icone\\gommeSelec.png");
		ImageIcon copy  = new ImageIcon("..\\FiguresGeometriques\\Icone\\copy.png");
		ImageIcon iconeTexte  = new ImageIcon("..\\FiguresGeometriques\\Icone\\texte.png");
		ImageIcon iconeTexteSelec  = new ImageIcon("..\\FiguresGeometriques\\Icone\\texteSelec.png");
		
		ImageIcon save  = new ImageIcon("..\\FiguresGeometriques\\Icone\\save.png");
		ImageIcon open  = new ImageIcon("..\\FiguresGeometriques\\Icone\\open.png");
		ImageIcon export  = new ImageIcon("..\\FiguresGeometriques\\Icone\\export.png");
		ImageIcon close  = new ImageIcon("..\\FiguresGeometriques\\Icone\\close.png");
		
		ImageIcon eff  = new ImageIcon("..\\FiguresGeometriques\\Icone\\supp.png");
		ImageIcon effTout  = new ImageIcon("..\\FiguresGeometriques\\Icone\\delete.png");
		
		ImageIcon help  = new ImageIcon("..\\FiguresGeometriques\\Icone\\help.png");
		
		//deux Jpanel de la fenetre
		this.setLayout(new BorderLayout());
		JPanel placementHaut  = new JPanel();
		JPanel placementBas  = new JPanel();
		
		ButtonGroup bg = new ButtonGroup();
		
		JRadioButton nf = new JRadioButton ("Nouvelle figure",iconeNf);
		JRadioButton tml = new JRadioButton ("Tracé à main levée",iconeTml);
		JRadioButton ma = new JRadioButton ("Manipulation",iconeMa);
		JRadioButton gom = new JRadioButton ("Gomme",iconeGomme);
		JRadioButton texte = new JRadioButton ("Texte",iconeTexte);
		
		JButton copie = new JButton("Copier Figure",copy);
		JButton couleur = new JButton(); //affiche la couleur en cours
		
		JCheckBox FigureCreuse = new JCheckBox("Figure Creuse");
		

		JTextArea textBar = new JTextArea("Largeur du Pinceau (" + this.epaisseur + ")");
		textBar.setEditable(false); //empeche d'ecrire dedans
		textBar.setBackground(this.getBackground());
		JScrollBar bar = new JScrollBar(0,1,1,1,21); //de 1 a 20
		bar.setPreferredSize(new Dimension(100,20));
	
		
		final JComboBox fig = new JComboBox (new String [] {"quadrilatere","triangle","rectangle","carre", "Cercle","Ligne"});
		final JComboBox co = new JComboBox (new String [] {"noir","vert","jaune","bleu","rouge","rose","gris","personnalisée"});
		

		final JMenuBar menuBar = new JMenuBar();
		
		final JMenu menuSupp = new JMenu("Effacer");
		JMenuItem supp = new JMenuItem("Effacer figure");
		JMenuItem suppTout = new JMenuItem("Effacer Tout");
		menuSupp.add(supp);
		menuSupp.add(suppTout);
		supp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE,0)); //raccourcis
		suppTout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE,InputEvent.CTRL_DOWN_MASK));
		supp.setIcon(eff);
		suppTout.setIcon(effTout);
	

		final JMenu menuFichier = new JMenu("Fichier");
		JMenuItem sauver = new JMenuItem("Enregistrer");
		JMenuItem charger = new JMenuItem("Ouvrir");
		JMenuItem exporter = new JMenuItem("Exporter");
		JMenuItem quitter = new JMenuItem("Quitter");
		menuFichier.add(sauver);
		menuFichier.add(charger);
		menuFichier.add(exporter);
		menuFichier.add(quitter);
		sauver.setIcon(save);
		charger.setIcon(open);
		exporter.setIcon(export);
		quitter.setIcon(close);
		
		sauver.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_DOWN_MASK));
		charger.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,InputEvent.CTRL_DOWN_MASK));
		exporter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,InputEvent.CTRL_DOWN_MASK));
		
		final JMenu aide = new JMenu("Aide");
		JMenuItem modeEmploi = new JMenuItem("mode d'Emploi");
		aide.add(modeEmploi);
		modeEmploi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H,InputEvent.CTRL_DOWN_MASK));
		modeEmploi.setIcon(help);
	
		menuBar.add(menuFichier);
		menuBar.add(menuSupp);
		menuBar.add(aide);
		
		//boutons radio regroupés dans un bouton group
		bg.add(nf);
		bg.add(tml);
		bg.add(ma);
		bg.add(gom);
		bg.add(texte);
		
		
		//Jpanel du Haut
		placementHaut.add(nf);
		placementHaut.add(tml);
		placementHaut.add(ma);
		placementHaut.add(copie);
		placementHaut.add(gom);
		placementHaut.add(texte);
		
		//Jpanel du bas
		placementBas.add(textBar);
		placementBas.add(bar);
		placementBas.add(FigureCreuse);
		placementBas.add(fig);
		placementBas.add(co);
		placementBas.add(couleur);
		
		
		//parametres de base
		couleur.setEnabled(false);
		couleur.setBackground(Color.black);
		textBar.setEnabled(false);
		bar.setEnabled(false);
		FigureCreuse.setEnabled(false);
		fig.setEnabled(false);
		supp.setEnabled(false);
		co.setEnabled(true);
		suppTout.setEnabled(false);
		copie.setEnabled(false);
		
		//Panneau de choix divisé en 3
		this.add(menuBar,BorderLayout.NORTH);
		this.add(placementHaut,BorderLayout.CENTER);
		this.add(placementBas,BorderLayout.SOUTH);
		
		
		
		
		//definit l'ensemble des actions des jRadioButton
		ActionListener ALboutons = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JRadioButton source = (JRadioButton)e.getSource(); 
				
				if(source.equals(nf)){ //Nouvelle figure
					texte.setIcon(iconeTexte);
					bar.setEnabled(true);
					textBar.setEnabled(true);
					gom.setIcon(iconeGomme);
					ma.setIcon(iconeMa);
					tml.setIcon(iconeTml);
					nf.setIcon(iconeNfSelec);
					FigureCreuse.setEnabled(true);
					fig.setEnabled(true);
					supp.setEnabled(false);
					suppTout.setEnabled(false);
					co.setEnabled(false);
					copie.setEnabled(false);
					vdessin.desactiverToutListener();
					dmodele.deselectTous();
					vdessin.repaint();
					vdessin.setCursor(CurseurDefaut);
					
				}else if(source.equals(tml)){ //Trace à main levée
					texte.setIcon(iconeTexte);
					bar.setEnabled(true);
					textBar.setEnabled(true);
					gom.setIcon(iconeGomme);
					ma.setIcon(iconeMa);
					tml.setIcon(iconeTmlSelec);
					nf.setIcon(iconeNf);
					FigureCreuse.setEnabled(false);
					fig.setEnabled(false);
					supp.setEnabled(false);
					suppTout.setEnabled(false);
					co.setEnabled(true);
					copie.setEnabled(false);
					dmodele.deselectTous();
					vdessin.repaint();
					vdessin.setCursor(CurseurPinceau);
					
				}else if(source.equals(ma)) { //Manipulation
					texte.setIcon(iconeTexte);
					bar.setEnabled(false);
					textBar.setEnabled(false);
					gom.setIcon(iconeGomme);
					ma.setIcon(iconeMaSelec);
					tml.setIcon(iconeTml);
					nf.setIcon(iconeNf);
					FigureCreuse.setEnabled(true);
					fig.setEnabled(false);
					supp.setEnabled(true);
					suppTout.setEnabled(true);
					co.setEnabled(true);
					dmodele.deselectTous();
					copie.setEnabled(true);
					vdessin.repaint();
					vdessin.setCursor(CurseurMainOuverte);
					
				}else if(source.equals(gom)) { //Gomme
					texte.setIcon(iconeTexte);
					bar.setEnabled(false);
					textBar.setEnabled(false);
					gom.setIcon(iconeGommeSelec);
					ma.setIcon(iconeMa);
					tml.setIcon(iconeTml);
					nf.setIcon(iconeNf);
					FigureCreuse.setEnabled(false);
					fig.setEnabled(false);
					supp.setEnabled(false);
					suppTout.setEnabled(false);
					co.setEnabled(false);
					copie.setEnabled(false);
					dmodele.deselectTous();
					vdessin.repaint();
					vdessin.setCursor(CurseurGomme);
					
				}else if(source.equals(texte)) { //texte
					System.out.println("test");
					texte.setIcon(iconeTexteSelec);
					bar.setEnabled(false);
					textBar.setEnabled(false);
					gom.setIcon(iconeGomme);
					ma.setIcon(iconeMa);
					tml.setIcon(iconeTml);
					nf.setIcon(iconeNf);
					FigureCreuse.setEnabled(false);
					fig.setEnabled(false);
					supp.setEnabled(false);
					suppTout.setEnabled(false);
					co.setEnabled(false);
					copie.setEnabled(false);
					dmodele.deselectTous();
					vdessin.repaint();
					vdessin.setCursor(CurseurTexte);
				
				}else { //si aucun n'est coché
					texte.setIcon(iconeTexte);
					bar.setEnabled(false);
					textBar.setEnabled(false);
					gom.setIcon(iconeGomme);
					ma.setIcon(iconeMa);
					tml.setIcon(iconeTml);
					nf.setIcon(iconeNf);
					FigureCreuse.setEnabled(false);
					fig.setEnabled(false);
					supp.setEnabled(false);
					suppTout.setEnabled(false);
					co.setEnabled(true);
					copie.setEnabled(false);
					vdessin.desactiverToutListener();
					dmodele.deselectTous();
					vdessin.repaint();
					vdessin.setCursor(CurseurDefaut);
					
				}
			}
		};
		
		//ajout des ActionListener aux JRadioButton
		nf.addActionListener(ALboutons);
		tml.addActionListener(ALboutons);
		ma.addActionListener(ALboutons);
		gom.addActionListener(ALboutons);
		texte.addActionListener(ALboutons);
		
		
		//Barre permettant de changer l'epaisseur du pinceau (traits et figures)
		bar.addAdjustmentListener(new AdjustmentListener() {
			
			@Override
			public void adjustmentValueChanged(AdjustmentEvent e) {
				epaisseur = bar.getValue();
				textBar.setText("Largeur du Pinceau (" + epaisseur + ")");
				if (vdessin.getTraceurForme() != null) {
					vdessin.getTraceurForme().setEpaisseur(epaisseur);
				}
				vdessin.repaint();
				
				
			}
		});
	
		
		
		//permet de fermer la fenetre quand on clique sur quitter
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

				}else if (ma.isSelected() && couleurActuelle!= null) {
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
				if (FigureCreuse.isSelected()) {
					fc.setFigureCreuse(true);
				}else{
					fc.setFigureCreuse(false);
				}
				if (fc != null){
					fc.changeCouleur(couleurActuelle);
					vdessin.construit(fc);
					co.setEnabled(true);
					
				}

			}
		});
		
		//permet de changer une figure plein en creuse ou inversement dans manipulation
		FigureCreuse.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean c = FigureCreuse.isSelected();
				if (ma.isSelected()) {
					if (dmodele.getSel() != -1) {
						if (dmodele.get_fg().get(dmodele.getSel()) != null) {
							if (dmodele.get_fg().get(dmodele.getSel()).isSelected()) {
								dmodele.get_fg().get(dmodele.getSel()).setFigureCreuse(c);
								dmodele.majAffichage();
							}
						
						}
					}	
				}
			}
		});
		
		//permet d'ecrire dans le dessin
		texte.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				vdessin.ecrire();
				
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
		
				System.out.println(epaisseur);
				vdessin.trace(couleurActuelle,epaisseur);
				
				
			}
		});
		
		//permet de gommer des traits ou des figures
		gom.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				vdessin.gommer();
				
			}
		});
		
		//permet de supprimer une figure
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
		
		//permet de sauvegarder notre dessin dans un fichier
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
		
		//permet d'exporter notre dessin en image (.png)
		exporter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				BufferedImage image = new BufferedImage(vdessin.getWidth(),vdessin.getHeight(), BufferedImage.TYPE_INT_RGB);
				Graphics2D img = image.createGraphics();
				vdessin.paint(img);

				
				JFileChooser fc = new JFileChooser();
				fc.setDialogTitle("exporter le fichier");
				fc.setCurrentDirectory(new java.io.File("Images"));
				fc.setFileFilter(new FileNameExtensionFilter("png", "png"));
				File result;
				
				if (fc.showOpenDialog(null)== JFileChooser.APPROVE_OPTION) {
						result = fc.getSelectedFile();
						System.out.println(result.getAbsolutePath());
						String chemin = result.getAbsolutePath() + ".png";
						try {
							ImageIO.write(image, "png", new File(chemin));

						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,"L'exportation du dessin est impossible","Exportation impossible",JOptionPane.WARNING_MESSAGE);
							ex.printStackTrace();
						}
					}	
				
				
				
			}
		});
		
		//permet de charger un dessin depuis un fichier
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
								dmodele.majAffichage();
								
								vdessin.setDessin(dmodele);
								ManipulateurFormes mf = new ManipulateurFormes(dmodele);
								vdessin.setMF(mf);
								dmodele.deselectTous();
								
							
								ma.setSelected(false);
								nf.setSelected(true);
								
								vdessin.repaint();
								
							} catch (Exception ex) {
								JOptionPane.showMessageDialog(null,"Le fichier chargé n'est pas un dessin, la fenetre va se fermer","Chargement impossible",JOptionPane.WARNING_MESSAGE);
								System.exit(1);
							}
						}
					
				
			}
		});
		
		//permet d'ouvrir un pdf contenant le mode d'emploi
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
	
	/**
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
			if (c != null) {
				this.couleurActuelle = c;
			}
			break;
		default:
			this.couleurActuelle = Color.black;
			break;

			
		}
	}
	/**
	 * Méthode implémentant la création d'une forme géométrique.
	 * @param index index de la figure dans le jcombobox
	 */
	public FigureColoree creeFigure(int index) {
		switch(index) {
		case 0:
			return new Quadrilatere(this.epaisseur);
		case 1:
			return new Triangle(this.epaisseur);
		case 2:
			return new Rectangle(this.epaisseur);
		case 3:
			return new Carre(this.epaisseur);
		case 4:
			return new Cercle(this.epaisseur);
		case 5:
			return new Ligne(this.epaisseur);
		default :
			return null;
		}
	}
	
	/**
	 * permet d'utiliser une couleur personnalisée grace au JColorChooser
	 */
	public Color couleurPerso() {
		Color couleur = JColorChooser.showDialog(null, "couleur du fond", Color.WHITE);
		return couleur;
	}
	
	

}
