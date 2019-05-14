package controleur;

import java.awt.event.MouseListener;

import javafx.scene.input.MouseEvent;
import modele.FigureColoree;
import modele.Point;

/*
 * Classe implemantant la creation de figures geometriques via des clics de souris.
 * La classe FabricantFigures est un contr�leur, le mod�le est pass� en param�tre de son
 * constructeur. Cette classe permet la construction d�une figure g�om�trique � l�aide de la souris.
 * Cette classe impl�mente l�interface MouseListener.
 * @author Loick Nosal
 */
public class FabricantFigures implements MouseListener {
	
	/*
	 * Accumule le nombre de clics de souris.
	 */
	private int nb_points_cliques;
	/*
	 * figure en train d'etre dessinnee
	 */
	private FigureColoree figure_en_cours_de_fabrication;
	/*
	 * Tableau contenant des points crees a  partir de clics de souris.
	 */
	private Point[] points_cliques;
	
	
	public FabricantFigures() {
		throw new Error("pas fait");
	}


	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
