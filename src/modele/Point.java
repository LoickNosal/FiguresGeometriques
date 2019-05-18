package modele;

/*
 * modelise un point
 * @author Loick Nosal
 */
public class Point {
	
	private int x;
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
	/*
	 * calcule la distance entre deux points
	 * @p2 deuxieme point avec lequel calculé la distance
	 */
	public double distance(Point p2) {
		double d = Math.sqrt((Math.pow(2,(this.rendreX()-p2.rendreX())) + 
				(Math.pow(2, (this.rendreY()-p2.rendreY())))));
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
