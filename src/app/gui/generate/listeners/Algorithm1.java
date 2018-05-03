package app.gui.generate.listeners;


import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Algorithm1 implements EventHandler<MouseEvent>{


	@Override
	public void handle(MouseEvent arg0) {
		new Algorithm1pop().initializeWindow();
		
	}

}
