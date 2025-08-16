package ar.dignitas.controller;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.util.Duration;
import javafx.scene.layout.AnchorPane;

public class Splash
{
    @FXML
    private AnchorPane apBase;
    
    private static double dragOffsetX = 0;
	private static double dragOffsetY = 0;
    
    public void initialize() throws FileNotFoundException {
    	
    	FadeTransition transition = new FadeTransition(Duration.seconds(3.0), apBase);
        transition.setFromValue(1.0);
        transition.setToValue(1.0);
        transition.play();
        transition.setOnFinished(event -> {
            Stage stSplash = (Stage) apBase.getScene().getWindow();
            Stage stPrincipal = new Stage();
            stPrincipal.initStyle(StageStyle.UNDECORATED);
            stPrincipal.setTitle("Área Principal de Prisix");
            try {
            	String fxmlFile = "/fxml/main.fxml";
            	FXMLLoader loader = new FXMLLoader();
				Parent root = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));
                
                Scene scene = new Scene(root);
                scene.getStylesheets().add("/styles/style2.css");
                
                scene.setOnMousePressed(e1 -> {
					dragOffsetX = e1.getSceneX();
					dragOffsetY = e1.getSceneY();
				});
				
				scene.setOnMouseDragged(e1 -> {
					stPrincipal.setX(e1.getScreenX() - dragOffsetX);
					stPrincipal.setY(e1.getScreenY() - dragOffsetY);
				});
                
                stPrincipal.setScene(scene);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            
            stPrincipal.addEventHandler(KeyEvent.KEY_PRESSED, (KeyEvent ev) -> {
				if (KeyCode.ESCAPE == ev.getCode()) {
					stPrincipal.close();
				}
			});
            
            stPrincipal.show();
            stSplash.hide();
        });
    }
}
