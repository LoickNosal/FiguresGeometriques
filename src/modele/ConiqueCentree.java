package modele;

import java.awt.Graphics;
import java.util.ArrayList;

/*
 * @author Nosal Lo�ck
 * Cette classe abstraite est la super classe de Cercle et de toute conique centr�e en g�n�ral.
 */
public abstract class ConiqueCentree extends FigureColoree{
	
	/*
	 * centre de la coniqueCentree
	 */
	protected Point centre;
	
	/*
	 * Constructeur
	 */
	public ConiqueCentree() {
		super();
		this.centre = new Point(0, 0);
		
	}
	
	public Point rendreCentre() {
		return this.centre;
	}

	@Override
	public abstract int nbPoints();

	@Override
	public abstract int nbClics();

	@Override
	public abstract boolean estDedans(int x, int y);

}
