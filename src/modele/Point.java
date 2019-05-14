package modele;

/*
 * modelise un point
 * @author Loick Nosal
 */
public class Point {
	
	private int x;
	private int y;
	
	
	public Point(int posX, int posY) {
		this.x = posX;
		this.y = posY;
	}
	
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
	
	public void incrementerX(int incx) {
		this.x += incx;
	}
	
	public void incrementerY(int incy) {
		this.y += incy;
	}
	
	public void modifierX(int newx) {
		this.x = newx;
	}
	
	public void modifierY(int newy) {
		this.y = newy;
	}
	
	public void translation(int dx, int dy) {
		this.x += dx;
		this.y += dy;
	}

}
