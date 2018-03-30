package app.utility;

import com.jfoenix.controls.JFXSpinner;

import javafx.animation.RotateTransition;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class LoadingScreen {

	private final Scene scene;
	private final Rectangle rect = new Rectangle(100, 40, 100, 100);

	public LoadingScreen(Scene scene) {
		this.scene = scene;
	}

	public void enableLoadingScreen() {
		AnchorPane pane = (AnchorPane) scene.lookup("#principalPane");
		pane.getChildren().clear();

		rect.setVisible(true);

		
		rect.setArcHeight(50);
		rect.setArcWidth(50);
		rect.getStyleClass().add("blue-color");

		pane.getChildren().add(rect);

		double width = (scene.getWidth() - rect.getWidth()) / 2;
		double height = (scene.getHeight() - rect.getHeight()) / 2;
		
		pane.setLeftAnchor(rect, width);
		pane.setRightAnchor(rect, width);
		pane.setTopAnchor(rect, height);
		pane.setBottomAnchor(rect, height);

		RotateTransition rt = new RotateTransition(Duration.millis(1000), rect);
		rt.setByAngle(270);
		rt.setCycleCount((int)Double.POSITIVE_INFINITY);
		rt.setAutoReverse(true);

		rt.play();

	}

	public void clearSpinenr() {
		rect.setVisible(false);
	}
}
