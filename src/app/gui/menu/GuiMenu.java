package app.gui.menu;

import app.gui.menu.listeners.DashBoardButton;
import app.gui.menu.listeners.GenerateButton;
import app.gui.menu.listeners.SearchButton;
import app.gui.menu.listeners.SettingsButton;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

public class GuiMenu {

	private final AnchorPane pane;
	private final Scene scene;

	public GuiMenu(Scene scene) {
		super();
		this.pane = (AnchorPane) scene.lookup("#principalPane");
		this.scene = scene;
	}

	@SuppressWarnings("static-access")
	public void generateMenu() {
		Rectangle rec1 = new Rectangle(0, 0, 700, 50);
		rec1.getStyleClass().add("blue-color");
		pane.getChildren().add(rec1);

		Rectangle rec2 = new Rectangle(672, -20, 100, 40);
		rec2.getStyleClass().add("blue-color");
		rec2.setRotate(135);
		pane.getChildren().add(rec2);

		Label dashboard = new Label("DASHBOARD");
		dashboard.getStyleClass().add("menu-element");
		dashboard.setLayoutX(30);
		dashboard.setLayoutY(15);
		pane.getChildren().add(dashboard);
		dashboard.setOnMouseClicked(new DashBoardButton(scene));

		Label search = new Label("SEARCH");
		search.getStyleClass().add("menu-element");
		search.setLayoutX(200);
		search.setLayoutY(15);
		pane.getChildren().add(search);
		search.setOnMouseClicked(new SearchButton(scene));

		Label settings = new Label("SETTINGS");
		settings.getStyleClass().add("menu-element");
		settings.setLayoutX(340);
		settings.setLayoutY(15);
		pane.getChildren().add(settings);
		settings.setOnMouseClicked(new SettingsButton(scene));

		Label generate = new Label("GENERATE");
		generate.getStyleClass().add("menu-element");
		generate.setLayoutX(500);
		generate.setLayoutY(15);
		pane.getChildren().add(generate);
		generate.setOnMouseClicked(new GenerateButton(scene));

	}
}
