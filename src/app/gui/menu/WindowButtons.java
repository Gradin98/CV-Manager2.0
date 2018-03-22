package app.gui.menu;

import app.gui.menu.listeners.CloseWindow;
import app.gui.menu.listeners.MaximizeWindow;
import app.gui.menu.listeners.MinimizeWindow;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class WindowButtons {

	private final AnchorPane pane;
	


	public WindowButtons(AnchorPane pane) {
		super();
		this.pane = pane;
	}
	
	@SuppressWarnings("static-access")
	public void generateButtons() {
		
		final Pane boxPane = (Pane) pane.getScene().lookup("#boxPane");
		Rectangle rec3 = new Rectangle(1000, -20, 100, 40);
		rec3.getStyleClass().add("blue-color");
		rec3.setRotate(45);

		Rectangle rec4 = new Rectangle(1100, 0, 128, 50);
		rec4.getStyleClass().add("blue-color");
		pane.getChildren().add(rec4);

		pane.setRightAnchor(rec4, 0.0);
		pane.setRightAnchor(rec3, 100.0);

		pane.getChildren().add(rec3);

		MaterialDesignIconView close = new MaterialDesignIconView(MaterialDesignIcon.WINDOW_CLOSE, "30px");
		pane.setRightAnchor(close, 10.0);
		pane.setTopAnchor(close, 10.0);
		close.getStyleClass().add("white-color");
		close.setOnMousePressed(new CloseWindow(close));
		pane.getChildren().add(close);

		MaterialDesignIconView maximize = new MaterialDesignIconView(MaterialDesignIcon.WINDOW_MAXIMIZE, "30px");
		pane.setRightAnchor(maximize, 45.0);
		pane.setTopAnchor(maximize, 10.0);
		maximize.getStyleClass().add("white-color");
		maximize.setOnMouseClicked(new MaximizeWindow(maximize, pane, boxPane));
		pane.getChildren().add(maximize);

		MaterialDesignIconView minimize = new MaterialDesignIconView(MaterialDesignIcon.WINDOW_MINIMIZE, "30px");
		pane.setRightAnchor(minimize, 85.0);
		pane.setTopAnchor(minimize, 17.0);
		minimize.getStyleClass().add("white-color");
		minimize.setOnMouseClicked(new MinimizeWindow(minimize));
		pane.getChildren().add(minimize);
	}
	
}
