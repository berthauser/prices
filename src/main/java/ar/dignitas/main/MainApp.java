package ar.dignitas.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class MainApp extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
    	String fxmlFile = "/fxml/splash.fxml";
		FXMLLoader loader = new FXMLLoader();
		Parent root = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));
    	
    	Scene scene = new Scene(root,630,225);
    	scene.getStylesheets().add("/styles/style2.css");

    	stage.setResizable(false);
    	stage.setAlwaysOnTop(true);
    	final Rectangle2D bounds = Screen.getPrimary().getBounds();
    	stage.setX(bounds.getMinX() + bounds.getWidth() / 2 - 630 / 2);
    	stage.setY(bounds.getMinY() + bounds.getHeight() / 2 - 270 / 2);
    	stage.setScene(scene);
    	stage.initStyle(StageStyle.UNDECORATED);
    	stage.show();
	}
}
