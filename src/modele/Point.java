package modele;

import java.io.Serializable;

/*
 * modelise un point
 * @author Loick Nosal
 */
public class Point implements Serializable{
	/*
	 * abscisse du point
	 */
	private int x;
	/*
	 * ordonnee du point
	 */
	private int y;
	
	/*
	 * constructeur
	 * @posX position x du point
	 * @posY position y du point
	 */
	public Point(int posX, int posY) {
		this.x = posX;
		this.y = posY;
	}
	
	public Point clone() {
		int px = this.x;
		int py = this.y;
		Point p = new Point(x,y);
		return p;
	}
	
	/*
	 * calcule la distance entre deux points
	 * @p2 deuxieme point avec lequel calculé la distance
	 */
	public double distance(Point p2) {
		double d = Math.sqrt((Math.pow((this.rendreX()-p2.rendreX()),2) + 
				(Math.pow((this.rendreY()-p2.rendreY()),2))));
		return d;
	}
	
	public int rendreX() {
		return this.x;
	}
	
	public int rendreY() {
		return this.y;
	}
	
	/*
	 * augmenter la valeur de x
	 * @incx montant de x à augmenter
	 */
	public void incrementerX(int incx) {
		this.x += incx;
	}
	/*
	 * augmenter la valeur de y
	 * @incy montant de y à augmenter
	 */
	public void incrementerY(int incy) {
		this.y += incy;
	}
	/*
	 * permet de modifier la valeur de x
	 * @param newx nouvelle valeur de x
	 */
	public void modifierX(int newx) {
		this.x = newx;
	}
	/*
	 * permet de modifier la valeur de y
	 * @param newy nouvelle valeur de y
	 */
	public void modifierY(int newy) {
		this.y = newy;
	}
	/*
	 * permet de translater un Point
	 * @param dx position x à ajouter
	 * @param dy position y à ajouter
	 */
	public void translation(int dx, int dy) {
		this.x += dx;
		this.y += dy;
	}

}
