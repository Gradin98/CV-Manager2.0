package app.gui.search.listeners;

import java.time.format.DateTimeFormatter;
import java.util.TreeMap;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXToggleButton;

import app.database.SQLiteConnection;
import app.utility.TransformRegex;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class SearchWindow implements EventHandler<MouseEvent> {

	private Scene scene;

	public SearchWindow(Scene scene) {
		this.scene = scene;
	}

	@Override
	public void handle(MouseEvent arg0) {
		JFXToggleButton datemode = (JFXToggleButton) scene.lookup("#DateMode");
		JFXToggleButton regexmode = (JFXToggleButton) scene.lookup("#RegexMode");
		ComboBox<String> choose = (ComboBox) scene.lookup("#ChooseMode");

		generateMode(choose, datemode, regexmode);

	}

	private void generateMode(ComboBox<String> choose, JFXToggleButton datemode, JFXToggleButton regexmode) {

		TreeMap<String, CVObject> content = null;
		TextField search = (TextField) scene.lookup("#SearchField");
		JFXDatePicker startDate = (JFXDatePicker) scene.lookup("#StartDatePicker");
		JFXDatePicker endDate = (JFXDatePicker) scene.lookup("#EndDatePicker");
		DateTimeFormatter formatters = DateTimeFormatter.ofPattern("uuuu-MM-d");

		if (datemode.isSelected() && regexmode.isSelected()) {

			content = new SQLiteConnection().contentByDate(search.getText(), startDate.getValue().format(formatters),
					endDate.getValue().format(formatters));

		} else if (!regexmode.isSelected() && datemode.isSelected()) {

			content = new SQLiteConnection().contentByDate(search.getText(), startDate.getValue().format(formatters),
					endDate.getValue().format(formatters));

		} else if (regexmode.isSelected() && !datemode.isSelected()) {
			content = new SQLiteConnection().contentList(search.getText());

		} else {
			content = new SQLiteConnection().contentList(new TransformRegex().transform(search.getText()));
		}

		if (choose.getValue().equals("Normal Mode")) {
			new SearchResults().initializeWindow(content, search);
		} else if (choose.getValue().equals("Table Mode")) {

			new TableMode().setTable(content);
		}

	}

}
