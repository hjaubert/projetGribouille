package iut.gon.gribouille.modele;

import iut.gon.gribouille.controleurs.ControleurGlobal;
import javafx.scene.input.MouseEvent;

public class OutilEtoile extends Outil {

	public OutilEtoile(ControleurGlobal cg) {
		super(cg);
	}

	@Override
	public void onMousePress(MouseEvent evt) {
		cg.dessinController.setEpaisseur();
	    cg.f = new Etoile(cg.epaisseur.get(), cg.couleur.get().toString(), cg.precX, cg.precY);
	    cg.d.addFigure(cg.f);
		
	}

	@Override
	public void onMouseDrag(MouseEvent evt) {
		cg.dessinController.setEpaisseur();
		cg.dessinController.setCouleur();
		cg.dessinController.trace(((Etoile) cg.f).getCentre().getX(), ((Etoile) cg.f).getCentre().getY() ,evt.getX(), evt.getY());
		
    	cg.precXProperty.set(cg.precX);
		cg.precYProperty.set(cg.precY);
		
    	Point point = new Point(cg.precX, cg.precY);
    	cg.f.addPoint(point);
		
	}

}
