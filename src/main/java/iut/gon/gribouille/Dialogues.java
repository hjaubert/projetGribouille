package iut.gon.gribouille;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

public class Dialogues {
	
	public static boolean confirmation() {
		
		Alert confirm = new Alert(AlertType.CONFIRMATION, "Voulez-vous fermer cette fenêtre ?", ButtonType.YES, ButtonType.NO);
    	confirm.setTitle("Fermeture");
    	ButtonType reponse = confirm.showAndWait().get();
    	if(!(reponse == ButtonType.NO)) {
    		return true;
    	} else {
    		return false;
    	}
		
	}
	
	
	

}
