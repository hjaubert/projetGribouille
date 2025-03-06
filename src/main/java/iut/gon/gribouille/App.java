package iut.gon.gribouille;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

import iut.gon.gribouille.controleurs.ControleurGlobal;
import iut.gon.gribouille.modele.Dessin;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static ControleurGlobal c = new ControleurGlobal();

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("CadreGribouille"), 640, 480);
        //Canvas dessin = (Canvas) scene.lookup("Canvas");
        Dessin d  = new Dessin();
        //FXMLLoader loader = new FXMLLoader();
        c.dessinController.setDessin(d);
        
        stage.setScene(scene);
        stage.show();
        
        stage.setOnCloseRequest(event -> {
        	if(c.onQuitter() == false) {
            	event.consume();
        	}
        });
        
        stage.addEventHandler(KeyEvent.KEY_PRESSED, evt -> {
        	c.onKeyPressed(evt);
        });
        
        d.setNomDuFichier("Gribouille");
        stage.setTitle(d.getNomDuFichier());
        
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        fxmlLoader.getController();
        fxmlLoader.setController(c);
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}