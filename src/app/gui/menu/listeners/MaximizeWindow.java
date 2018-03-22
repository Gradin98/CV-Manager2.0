package app.gui.menu.listeners;

import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class MaximizeWindow implements EventHandler<MouseEvent> {

	private final MaterialDesignIconView maximize;
	private final AnchorPane pane;
	private final Pane boxPane;

	public MaximizeWindow(MaterialDesignIconView maximize, AnchorPane pane, Pane boxPane) {
		super();
		this.maximize = maximize;
		this.pane = pane;
		this.boxPane = boxPane;
	}

	@SuppressWarnings("static-access")
	@Override
	public void handle(MouseEvent event) {

		Stage stage = (Stage) maximize.getScene().getWindow();
		
		
		
		if (stage.isMaximized()) {
			stage.setMaximized(false);
			double width = (stage.getWidth() - 800 ) / 2;
			

			pane.setLeftAnchor(boxPane, width);
			pane.setRightAnchor(boxPane, width);

		} else {
			stage.setMaximized(true);
			double width = (stage.getWidth() - 800 ) / 2;
			
			Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
			stage.setX(primaryScreenBounds.getMinX());
			stage.setY(primaryScreenBounds.getMinY());
			stage.setWidth(primaryScreenBounds.getWidth());
			stage.setHeight(primaryScreenBounds.getHeight());
			
			pane.setLeftAnchor(boxPane, width );
			pane.setRightAnchor(boxPane, width );

		}

	}

}
