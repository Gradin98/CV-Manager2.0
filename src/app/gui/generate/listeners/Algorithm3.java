package app.gui.generate.listeners;


import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Algorithm3 implements EventHandler<MouseEvent>{


	@Override
	public void handle(MouseEvent arg0) {
		new Algorithm3pop().initializeWindow();
		
	}

}
