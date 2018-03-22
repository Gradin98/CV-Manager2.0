package app.gui.search;

import app.gui.menu.GuiMenu;
import app.gui.menu.WindowButtons;
import app.utility.GuiLocation;
import app.utility.SettingsUtility;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class Search {
	
	private final Scene scene;

	public Search(Scene scene) {
		super();

		this.scene = scene;
	}
	
	public void setContent() {
		SettingsUtility.setLoc(GuiLocation.SEARCH);
		AnchorPane pane = (AnchorPane) scene.lookup("#principalPane");
		
		
		pane.getChildren().clear();
		
		new GuiMenu(scene).generateMenu();
		new WindowButtons(pane).generateButtons();
	}
	
}
