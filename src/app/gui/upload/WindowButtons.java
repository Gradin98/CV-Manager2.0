package app.gui.upload;

import app.gui.menu.listeners.CloseWindow;
import app.utility.animation.BounceInTransition;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

public class WindowButtons {

	private final AnchorPane pane;
	


	public WindowButtons(AnchorPane pane) {
		super();
		this.pane = pane;
	}
	
	@SuppressWarnings("static-access")
	public void generateButtons() {
		
		Polygon polygon = new Polygon();
		polygon.getPoints().addAll(new Double[] { 0.0, 0.0,  pane.getWidth(), 0.0, pane.getWidth(),50.0, pane.getWidth() - 40, 50.0 , pane.getWidth() - 60, 30.0, 0.0, 30.0});
		polygon.getStyleClass().add("white-color");

		pane.getChildren().add(polygon);

		MaterialDesignIconView close = new MaterialDesignIconView(MaterialDesignIcon.WINDOW_CLOSE, "30px");
		pane.setRightAnchor(close, 10.0);
		pane.setTopAnchor(close, 10.0);
		close.getStyleClass().add("blue-color");
		close.setOnMousePressed(new CloseWindow(close));
		pane.getChildren().add(close);
		
		
		
		
	}
	
}
