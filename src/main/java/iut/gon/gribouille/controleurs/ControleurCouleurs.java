package iut.gon.gribouille.controleurs;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ColorPicker;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ControleurCouleurs implements Initializable {
	
	@FXML
	public TilePane tilePane;
	
	@FXML
    public Rectangle blanc;

    @FXML
    public Rectangle bleuClair;

    @FXML
    public Rectangle bleuFonce;
    
    @FXML
    public Rectangle jaune;
    
    @FXML
    public Rectangle rouge;
    
    @FXML
    public Rectangle vert;

    @FXML
    public Rectangle rose;
    
    @FXML
    public Rectangle noir;

    @FXML
    public ColorPicker colorPicker;
    
    @FXML
    public VBox vbox;
    
    private Rectangle rectanglePrecedent;
	
	ControleurGlobal cg;
	
	public void setControleurGlobal(ControleurGlobal cg) {
		this.cg = cg;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		vbox.addEventHandler(MouseEvent.MOUSE_CLICKED, evt -> {
			if (evt.getTarget() instanceof Rectangle) {
	            Rectangle clickedRectangle = (Rectangle) evt.getTarget();
	            Color couleur = (Color) clickedRectangle.getFill();
	            System.out.println(couleur);
	            cg.setCouleur(couleur);

	            if (rectanglePrecedent != null) {
	            	rectanglePrecedent.setArcWidth(5);
	            	rectanglePrecedent.setArcHeight(5);
	            	rectanglePrecedent.setStrokeWidth(1);
	            }

	            clickedRectangle.setArcWidth(10);
	            clickedRectangle.setArcHeight(10);
	            clickedRectangle.setStrokeWidth(5);

	            rectanglePrecedent = clickedRectangle;
	        }
		});
	}
	
}
