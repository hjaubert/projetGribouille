package iut.gon.gribouille.controleurs;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class ControleurStatut implements Initializable {
	
	@FXML
	public Label valeurCouleur = new Label();
	
	@FXML
    public Label valeurEpaisseur = new Label();
    
    @FXML
    public Label valeurX = new Label();

    @FXML
    public Label valeurY = new Label();
    
    @FXML
    public Label valeurOutil = new Label();

	public ControleurGlobal cg;

	public void setControleurGlobal(ControleurGlobal cg) {
		this.cg = cg;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

}
