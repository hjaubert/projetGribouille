package iut.gon.gribouille.controleurs;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import iut.gon.gribouille.Dialogues;
import iut.gon.gribouille.modele.Dessin;
import iut.gon.gribouille.modele.Etoile;
import iut.gon.gribouille.modele.Figure;
import iut.gon.gribouille.modele.Outil;
import iut.gon.gribouille.modele.OutilCrayon;
import iut.gon.gribouille.modele.OutilEtoile;
import iut.gon.gribouille.modele.Point;
import iut.gon.gribouille.modele.Trace;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ControleurGlobal implements Initializable {
	
	public final Dessin d =  new Dessin();
	public Figure f;
	public double precX;
	public double precY;
    public SimpleDoubleProperty precXProperty = new SimpleDoubleProperty(0);
    public SimpleDoubleProperty precYProperty = new SimpleDoubleProperty(0);
	public final SimpleObjectProperty<Color> couleur = new SimpleObjectProperty<Color>(Color.BLACK);
	public final SimpleIntegerProperty epaisseur = new SimpleIntegerProperty(1);
	
	@FXML
	public ControleurCouleurs couleursController;
	
	@FXML
	public ControleurDessin dessinController;
	
	@FXML
	public ControleurMenus menusController;
	
	@FXML
	public ControleurStatut statutController;
	
	private Outil outil = new OutilCrayon(this);
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		couleursController.setControleurGlobal(this);
		dessinController.setControleurGlobal(this);
		menusController.setControleurGlobal(this);
		statutController.setControleurGlobal(this);
		
		precXProperty = new SimpleDoubleProperty(precX);
		precYProperty = new SimpleDoubleProperty(precY);
		
		this.statutController.valeurX.textProperty().bind(precXProperty.asString("%.2f"));
	    this.statutController.valeurY.textProperty().bind(precYProperty.asString("%.2f"));
	    this.statutController.valeurEpaisseur.textProperty().bind(epaisseur.asString());
	    this.statutController.valeurCouleur.textProperty().bind(couleur.asString());
	    this.statutController.valeurOutil.setText("Crayon");
	}
	
	public boolean onQuitter() {
		if(Dialogues.confirmation()) {
			return true;
		} else {
			return false;
		}
	}
	
	public void onMousePressed(MouseEvent evt) {
		precX = evt.getX();
	    precY = evt.getY();
	    
	    outil.onMousePress(evt);
	}
	
	public void onMouseDragged(MouseEvent evt) {
		outil.onMouseDrag(evt);
    	precX = evt.getX();
    	precY = evt.getY();
    	
	}
	
	public void onMouseMoved(MouseEvent evt) {
		precXProperty.set(evt.getX());
		precYProperty.set(evt.getY());
	}
	
	public void redessine() {	
		dessinController.efface();
		dessinController.setEpaisseur();
		
		for(int i = 0; i < d.getFigures().size(); i++) {
			
			if(d.getFigures().get(i) instanceof Trace) {
				for(int j = 1; j < d.getFigures().get(i).getPoints().size(); j++) {
					this.dessinController.setCouleur();
					dessinController.trace(d.getFigures().get(i).getPoints().get(j - 1).getX(), 
							d.getFigures().get(i).getPoints().get(j - 1).getY(), 
							d.getFigures().get(i).getPoints().get(j).getX(), 
							d.getFigures().get(i).getPoints().get(j).getY());
				}
			}
			
			if(d.getFigures().get(i) instanceof Etoile) {
				for(int j = 1; j < d.getFigures().get(i).getPoints().size(); j++) {
					this.dessinController.setCouleur();
					Etoile etoile = (Etoile) d.getFigures().get(i);
					this.dessinController.trace(etoile.getCentre().getX(), etoile.getCentre().getY(), d.getFigures().get(i).getPoints().get(j).getX(), 
							d.getFigures().get(i).getPoints().get(j).getY());
				}
			}
		}
	}
	
	public void onCrayon() {
		outil = new OutilCrayon(this);
		statutController.valeurOutil.setText("Crayon");
	}
	
	public void onEtoile() {
		outil = new OutilEtoile(this);
		statutController.valeurOutil.setText("Etoile");
	}
	
	public void setEpaisseur(int epaisseur) {
		this.epaisseur.set(epaisseur);
	}
		
	public void setCouleur(Color c) {
		this.couleur.set(c);
	}
	
	public void onKeyPressed(KeyEvent evt) {
		switch(evt.getText()) {
			case("1"):
				this.setEpaisseur(1);
				break;
			case("2"):
				this.setEpaisseur(2);
				break;
			case("3"):
				this.setEpaisseur(3);
				break;
			case("4"):
				this.setEpaisseur(4);
				break;
			case("5"):
				this.setEpaisseur(5);
				break;
			case("6"):
				this.setEpaisseur(6);
				break;
			case("7"):
				this.setEpaisseur(7);
				break;
			case("8"):
				this.setEpaisseur(8);
				break;
			case("9"):
				this.setEpaisseur(9);
				break;
		}
	}
	
	public void sauvegarder() {
		FileChooser fc = new FileChooser();
		fc.setTitle("Sauvegarder le dessin");
		File file = fc.showSaveDialog(new Stage());
		if(file != null){
			d.sauveSous(file.getAbsolutePath());
		}
	}

}
