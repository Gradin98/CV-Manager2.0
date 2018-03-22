package app.gui.dashboard.listeners;

import app.gui.dashboard.Dashboard;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class WindowPressed implements EventHandler<MouseEvent> {

	private final AnchorPane pane;
	
	public WindowPressed(AnchorPane pane) {
		super();
		this.pane = pane;
	}

	@Override
	public void handle(MouseEvent event) {
		if (event.getButton() == MouseButton.PRIMARY && event.getSceneY() < 30
				&& (event.getSceneX() > 0 && event.getSceneX() < 1100)) {
			Stage stage = (Stage) pane.getScene().getWindow();
			
			if(stage.isMaximized()) {
				
				if(event.getClickCount() == 2) {
					
					stage.setX(80);
					stage.setY(15);
					stage.setWidth(1200);
					stage.setHeight(700);
					
				}
			}
			else {
				if(event.getClickCount() == 2) {
					
					Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
					stage.setX(primaryScreenBounds.getMinX());
					stage.setY(primaryScreenBounds.getMinY());
					stage.setWidth(primaryScreenBounds.getWidth());
					stage.setHeight(primaryScreenBounds.getHeight());
				}
				
			}

			Dashboard.setxOffset(stage.getX() - event.getScreenX());
			Dashboard.setyOffset(stage.getY() - event.getScreenY());

		}

	}

}
