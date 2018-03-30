package app.gui.menu.listeners;

import app.gui.upload.Upload;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class UploadButton implements EventHandler<MouseEvent>{
	
	@Override
	public void handle(MouseEvent arg0) {
		new Upload().initializeWindow();
	}
}
