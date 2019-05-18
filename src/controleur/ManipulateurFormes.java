package controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import modele.DessinModele;
import modele.FigureColoree;

public class ManipulateurFormes implements MouseListener, MouseMotionListener {
	
	private int last_x;
	private int last_y;
	private boolean trans;
	private int indice;
	private int nbf;
	private int sel;
	private ArrayList<FigureColoree> lfg;
	private DessinModele dm;
	
	public ManipulateurFormes(DessinModele d) {
		throw new Error("pas fait");
	}

	public int nbFigures() {
		throw new Error("pas fait");
	}
	
	public FigureColoree figureSelection() {
		throw new Error("pas fait");
	}
	
	public void selectionProchaineFigure() {
		throw new Error("pas fait");
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

}
