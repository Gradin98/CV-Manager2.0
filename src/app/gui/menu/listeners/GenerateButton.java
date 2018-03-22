package app.gui.menu.listeners;

import app.gui.generate.Generate;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class GenerateButton implements EventHandler<MouseEvent>{

	private final Scene scene;
	
	public GenerateButton(Scene scene) {
		this.scene = scene;
	}
	
	@Override
	public void handle(MouseEvent arg0) {
		AnchorPane pane = (AnchorPane) scene.lookup("#principalPane");
		pane.getChildren().clear();
		
		new Generate(pane.getScene()).setContent();
	}

}