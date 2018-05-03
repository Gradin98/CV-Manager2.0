package app.gui.generate.listeners;

import com.jfoenix.controls.JFXButton;

import app.gui.dashboard.listeners.WindowDrag;
import app.gui.dashboard.listeners.WindowPressed;
import app.gui.upload.WindowButtons;
import app.utility.animation.BounceInTransition;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Algorithm3pop {
public void initializeWindow() {
		
		AnchorPane pane = new AnchorPane();
		
		final Scene scene = new Scene(pane, 700, 300);

		scene.getStylesheets().add(getClass().getResource("algorithms.css").toExternalForm());

		final Stage primaryStage = new Stage();
		primaryStage.setScene(scene);
		primaryStage.initStyle(StageStyle.UNDECORATED);
		primaryStage.setResizable(true);
		

		primaryStage.show();
		
		primaryStage.setOpacity(1);
		primaryStage.setTitle("Alg3 needs");
		
		
		
		pane.getStyleClass().add("white-color");
		new WindowButtons(pane).generateButtons();

		
		pane.setOnMouseDragged(new WindowDrag(pane));
		pane.setOnMousePressed(new WindowPressed(pane));
		
		
		
		
	}
	
}

