package app.gui.upload;

import java.io.File;
import java.util.List;

import com.jfoenix.controls.JFXButton;

import app.gui.dashboard.listeners.WindowDrag;
import app.gui.dashboard.listeners.WindowPressed;
import app.utility.animation.BounceInTransition;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Upload {

	private List<File> lista;
	
	public void initializeWindow() {
		
		AnchorPane pane = new AnchorPane();
		
		final Scene scene = new Scene(pane, 700, 300);

		scene.getStylesheets().add(getClass().getResource("upload.css").toExternalForm());

		final Stage primaryStage = new Stage();
		primaryStage.setScene(scene);
		primaryStage.initStyle(StageStyle.UNDECORATED);
		primaryStage.setResizable(true);
		

		primaryStage.show();
		
		primaryStage.setOpacity(1);
		primaryStage.setTitle("Upload Files");
		
		JFXButton submitButton = new JFXButton("Submit".toUpperCase());
		submitButton.getStyleClass().add("button-raised");
		submitButton.setLayoutX(250);
		submitButton.setLayoutY(230);
		submitButton.setMinWidth(200);
		submitButton.setMaxWidth(200);
		submitButton.setMinHeight(50);
		submitButton.setMaxHeight(50);
		
		JFXButton chooseButton = new JFXButton("Choose".toUpperCase());
		chooseButton.getStyleClass().add("button-raised");
		chooseButton.setLayoutX(120);
		chooseButton.setLayoutY(100);
		chooseButton.setMinWidth(200);
		chooseButton.setMaxWidth(200);
		chooseButton.setMinHeight(50);
		chooseButton.setMaxHeight(50);
		
		Label message = new Label("Loaded Files".toUpperCase());
		message.setLayoutX(330);
		message.setLayoutY(100);
		message.setMinWidth(300);
		message.setMaxWidth(300);
		message.setAlignment(Pos.CENTER);
		message.getStyleClass().add("message");
		
		Label number = new Label("0".toUpperCase());
		number.setLayoutX(330);
		number.setLayoutY(130);
		number.setMinWidth(300);
		number.setMaxWidth(300);
		number.setAlignment(Pos.CENTER);
		number.getStyleClass().add("message");
		
		FileChooserEvent chooseEvent = new FileChooserEvent(lista, number, submitButton);
		chooseButton.setOnAction(chooseEvent);
		
		System.out.println(FileChooserEvent.getLista());
		
		
		
		

		
		pane.getStyleClass().add("blue-color");
		new WindowButtons(pane).generateButtons();
//		
//		Polygon polygon = new Polygon();
//		polygon.getPoints().addAll(new Double[] { 100.0, 90.0,  650.0, 90.0, 600.0, 160.0, 50.0, 160.0 });
//		polygon.getStyleClass().add("cyan-color");
//		
//		pane.getChildren().add(polygon);
		pane.getChildren().add(submitButton);
		pane.getChildren().add(chooseButton);
		
        pane.getChildren().add(message);
        pane.getChildren().add(number);
		
		pane.setOnMouseDragged(new WindowDrag(pane));
		pane.setOnMousePressed(new WindowPressed(pane));
		
		//new BounceInTransition(pane).play();
		
		
		
	}
	
}
