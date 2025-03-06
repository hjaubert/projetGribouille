package iut.gon.gribouille.controleurs;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ControleurMenus implements Initializable {
	
	@FXML
    public ToggleGroup epaisseur;
    
    @FXML
    public ToggleGroup outils;
    
    @FXML
    public MenuItem quitter;
    
    @FXML
    public RadioMenuItem crayon;
    
    @FXML
    public RadioMenuItem etoile;
    
    @FXML
    public MenuItem charger;
    
    @FXML
    public MenuItem sauvegarder;
    
    @FXML
    public MenuItem exporter;
    

	public ControleurGlobal cg;

	public void setControleurGlobal(ControleurGlobal cg) {
		this.cg = cg;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		outils.selectedToggleProperty().addListener((obs, old, new_) -> {
			if(new_.equals(crayon)) {
				cg.onCrayon();
			}
			if(new_.equals(etoile)) {
				cg.onEtoile();
			}
		});
		
		epaisseur.selectedToggleProperty().addListener((obs, old, new_) -> {
			RadioMenuItem toggleSelectionne = (RadioMenuItem) epaisseur.getSelectedToggle();
			cg.setEpaisseur(Integer.parseInt(toggleSelectionne.getText()));
		});
		
	}
	
	public void onQuitte() {
		if(cg.onQuitter()) {
			Platform.exit();
		}
	}
	
	public void onSauve() {
		cg.sauvegarder();
	}

}
