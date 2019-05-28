package controleur;

import modele.DessinModele;
import modele.FigureColoree;
import modele.Point;

/**
 * Classe permettant de copier des figures colorees
 * @author Nosal Loïck
 */
public class CopieFigure{

	/**
	 * modele sur lequel copier la figure
	 */
	private DessinModele modele;
	
	/**
	 * constructeur
	 */
	public CopieFigure(DessinModele dm) {
		this.modele = dm;
		
	}

	/**
	 * methode permettant de copier une figure coloree
	 */
	public void Copier() {	
			int sel = this.modele.getSel();
			
			if (sel != -1) {
				if (this.modele.get_fg().get(sel).isSelected()) {
					
					
					FigureColoree cop = this.modele.get_fg().get(sel).clone();

					for (Point p : cop.getListePoint()) {
						p.translation(20, 20);
					}
					cop.modifierPoints(cop.getListePoint());

					this.modele.ajoute(cop);
					this.modele.deselectTous();
					this.modele.setSel(this.modele.get_fg().size()-1);
					
					
					cop.selectionne();
					

   
				}
			}	
	}



}
