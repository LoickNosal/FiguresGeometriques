package controleur;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import modele.DessinModele;
import modele.FigureColoree;
import modele.Point;

public class CopieFigure implements Serializable{

	
	private DessinModele modele;
	
	public CopieFigure(DessinModele dm) {
		this.modele = dm;
		
	}

	public void Copier() {	
			int sel = this.modele.getSel();
			
			if (sel != -1) {
				if (this.modele.get_fg().get(sel).isSelected()) {
					
					
					FigureColoree cop = this.modele.get_fg().get(sel).clone();
					
					System.out.println(this.modele.get_fg().get(sel));
					System.out.println(cop.toString());
					

					for (Point p : cop.getListePoint()) {
						p.translation(20, 20);
					}
					cop.modifierPoints(cop.getListePoint());

					this.modele.ajoute(cop);
					this.modele.setNbf(this.modele.getNbf()+1);
					this.modele.deselectTous();
					this.modele.setSel(this.modele.get_fg().size()-1);
					cop.selectionne();
   
				}
			}	
	}



}
