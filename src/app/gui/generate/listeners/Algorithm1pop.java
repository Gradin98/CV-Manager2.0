package app.gui.generate.listeners;

import com.jfoenix.controls.JFXButton;

import app.gui.dashboard.listeners.WindowDrag;
import app.gui.dashboard.listeners.WindowPressed;
import app.gui.upload.WindowButtons;
import app.utility.animation.BounceInTransition;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Algorithm1pop {
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
		primaryStage.setTitle("Alg1 needs");

		Image image = new Image("file:" + System.getenv("APPDATA") + "\\CV-Reader\\PhylogeneticTree.png");
		Label label1 = new Label("", new ImageView(image));
		label1.setLayoutX(scene.getWidth() / 2 - image.getWidth() / 2);
		label1.setLayoutY(0);
		
		
		final ScrollPane sc = new ScrollPane();
		sc.setLayoutX(0);
		sc.setLayoutY(50);
		sc.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
		sc.getStyleClass().add("scrollerPane-style");
		
		Pane pane10 = new Pane();
		
		pane10.getChildren().add(label1);
		sc.setContent(pane10);
		pane.getChildren().add(sc);
		
		

		pane.getStyleClass().add("white-color");
		new WindowButtons(pane).generateButtons();

		pane.setOnMouseDragged(new WindowDrag(pane));
		pane.setOnMousePressed(new WindowPressed(pane));

	}

}
