package app.gui.dashboard.listeners;

import java.awt.MouseInfo;

import app.gui.dashboard.Dashboard;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class WindowDrag implements EventHandler<MouseEvent> {

	private final AnchorPane pane;
	//private double tempWidth, tempHeight, tempX, tempY;

	public WindowDrag(AnchorPane pane) {
		super();
		this.pane = pane;
	}

	@Override
	public void handle(MouseEvent event) {
		
		
		if (event.getButton() == MouseButton.PRIMARY && event.getSceneY() < 30
				&& (event.getSceneX() > 0 && event.getSceneX() < 1100)) {

			
			
			Stage stage = (Stage) pane.getScene().getWindow();

			if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {
				stage.setMaximized(true);
				Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
				stage.setX(primaryScreenBounds.getMinX());
				stage.setY(primaryScreenBounds.getMinY());
				stage.setWidth(primaryScreenBounds.getWidth());
				stage.setHeight(primaryScreenBounds.getHeight());

				stage.setY(0);
				stage.setX(0);
			}

			if (MouseInfo.getPointerInfo().getLocation().getY() < 5) {
				
				stage.setMaximized(true);
				Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
				stage.setX(primaryScreenBounds.getMinX());
				stage.setY(primaryScreenBounds.getMinY());
				stage.setWidth(primaryScreenBounds.getWidth());
				stage.setHeight(primaryScreenBounds.getHeight());

				stage.setY(0);
				stage.setX(0);
				
				
			} else {
				stage.setMaximized(false);
				stage.setX(event.getScreenX() + Dashboard.getxOffset());
				stage.setY(event.getScreenY() + Dashboard.getyOffset());
				
			}
		}

	}

}
