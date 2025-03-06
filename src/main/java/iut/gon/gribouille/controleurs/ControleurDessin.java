package iut.gon.gribouille.controleurs;

import java.net.URL;
import java.util.ResourceBundle;

import iut.gon.gribouille.modele.Dessin;
import iut.gon.gribouille.modele.Etoile;
import iut.gon.gribouille.modele.Trace;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class ControleurDessin implements Initializable {
	
	@FXML
    private Pane pane;
    
    @FXML
    public Canvas canvasDessin;
    
    
    public Dessin dessin;

	public ControleurGlobal cg;

	public void setControleurGlobal(ControleurGlobal cg) {
		this.cg = cg;
	}
	
	public void setDessin(Dessin dessin) {
		this.dessin = dessin;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		canvasDessin.widthProperty().bind(pane.widthProperty());
		canvasDessin.heightProperty().bind(pane.heightProperty());
		
		canvasDessin.widthProperty().addListener(evt -> {
	    	  cg.redessine();
	      });
		
	      canvasDessin.heightProperty().addListener(evt -> {
	    	  cg.redessine();
	      });
		
	}
	
	public void efface() {
		canvasDessin.getGraphicsContext2D().clearRect(0, 0, canvasDessin.getHeight(), canvasDessin.getWidth());
	}
	
	public void trace(double x1, double y1, double x2, double y2) {
		canvasDessin.getGraphicsContext2D().strokeLine(x1, y1, x2, y2);
	}
	
	public void onMousePressed(MouseEvent evt) {
		cg.onMousePressed(evt);
	}
	
	public void onMouseDragged(MouseEvent evt) {
		cg.onMouseDragged(evt);
	}
	
	public void onMouseMoved(MouseEvent evt) {
		cg.onMouseMoved(evt);
	}
	
	public void setEpaisseur() {
		canvasDessin.getGraphicsContext2D().setLineWidth(cg.epaisseur.get());
	}
	
	public void setCouleur() {
		canvasDessin.getGraphicsContext2D().setStroke(cg.couleur.getValue());
	}

}
