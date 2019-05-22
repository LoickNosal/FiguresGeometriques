package modele;

import java.awt.Graphics;
import java.util.ArrayList;

public abstract class ConiqueCentree extends FigureColoree{
	
	protected Point centre;
	
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
