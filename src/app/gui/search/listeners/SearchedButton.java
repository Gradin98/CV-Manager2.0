package app.gui.search.listeners;

import java.util.Map.Entry;

import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class SearchedButton implements EventHandler<MouseEvent>{

	private final Entry<String, CVObject> entry;
	private final TextField searchfield;
	
	public SearchedButton(Entry<String, CVObject> entry, TextField searchfield) {
		super();
		this.entry = entry;
		this.searchfield = searchfield;
	}

	@Override
	public void handle(MouseEvent event) {
		// TODO Auto-generated method stub
		new SearchedContent().createInterface(entry, searchfield);
	}

}
