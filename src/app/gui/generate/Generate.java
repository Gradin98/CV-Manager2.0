package app.gui.generate;

import app.gui.menu.GuiMenu;
import app.gui.menu.WindowButtons;
import app.utility.GuiLocation;
import app.utility.SettingsUtility;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class Generate {
	
	private final Scene scene;

	public Generate(Scene scene) {
		super();

		this.scene = scene;
	}
	
	public void setContent() {
		SettingsUtility.setLoc(GuiLocation.GENERATE);
		AnchorPane pane = (AnchorPane) scene.lookup("#principalPane");
		
		
		pane.getChildren().clear();
		
		new GuiMenu(scene).generateMenu();
		new WindowButtons(pane).generateButtons();
	}
	
}
