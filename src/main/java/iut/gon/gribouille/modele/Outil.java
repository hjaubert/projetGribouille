package iut.gon.gribouille.modele;

import iut.gon.gribouille.controleurs.ControleurGlobal;
import javafx.scene.input.MouseEvent;

public abstract class Outil {
	
	protected ControleurGlobal cg;
	
	public Outil(ControleurGlobal cg) {
		super();
		this.cg = cg;
	}

	public abstract void onMousePress(MouseEvent evt);
	
	public abstract void onMouseDrag(MouseEvent evt);

}
