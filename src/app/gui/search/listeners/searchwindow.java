package app.gui.search.listeners;


import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class searchwindow implements EventHandler<MouseEvent>{
		
		@Override
		public void handle(MouseEvent arg0) {
			new Searchresults().initializeWindow();
		}
	}

