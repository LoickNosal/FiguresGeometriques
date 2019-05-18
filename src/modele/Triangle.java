package modele;

public class Triangle extends Polygone{

	
	public Triangle(){
		super();
	}
	
	
	@Override
	public int nbPoints() {
		return 3;
	}

	public int nbClics() {
		return 3;
	}
}
