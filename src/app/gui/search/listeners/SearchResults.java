package app.gui.search.listeners;

import java.util.TreeMap;
import java.util.Map.Entry;

import com.jfoenix.controls.JFXButton;

import app.gui.dashboard.listeners.WindowDrag;
import app.gui.dashboard.listeners.WindowPressed;
import app.gui.upload.WindowButtons;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SearchResults {

	public void initializeWindow(TreeMap<String, CVObject> content, TextField searchfield) {

		AnchorPane pane = new AnchorPane();

		final Scene scene = new Scene(pane, 800, 500);

		scene.getStylesheets().add(getClass().getResource("search.css").toExternalForm());

		final Stage primaryStage = new Stage();
		primaryStage.setScene(scene);
		primaryStage.initStyle(StageStyle.UNDECORATED);
		primaryStage.setResizable(true);

		primaryStage.show();

		primaryStage.setOpacity(1);
		primaryStage.setTitle("Search results");

		pane.getStyleClass().add("white-color");
		new WindowButtons(pane).generateButtons();

		pane.setOnMouseDragged(new WindowDrag(pane));
		pane.setOnMousePressed(new WindowPressed(pane));

		addContentToPane(pane, content, searchfield);

	}

	private void addContentToPane(AnchorPane pane, TreeMap<String, CVObject> content, TextField searchfield) {

		int valueX = 45;
		int contor_posturi = 0;
		int valueY = 10;

		final ScrollPane sc = new ScrollPane();
		sc.setLayoutX(0);
		sc.setLayoutY(50);
		pane.getChildren().add(sc);
		sc.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
		sc.getStyleClass().add("scrollerPane-style");

		final Pane panel2 = new Pane();
		panel2.setPadding(new Insets(0, 0, 20, 0));

		for (Entry<String, CVObject> entry : content.entrySet()) {
			JFXButton button = new JFXButton(entry.getKey());

			button.setLayoutX(valueX);
			button.setLayoutY(valueY);

			button.getStyleClass().add("button-raised");
			button.setMinWidth(200);
			button.setMaxWidth(200);
			button.setMinHeight(50);
			button.setMaxHeight(50);
			button.setOnMouseClicked(new SearchedButton(entry, searchfield));

			panel2.getChildren().add(button);

			valueX += 250;
			contor_posturi++;
			if (contor_posturi % 3 == 0) {
				valueX = 45;
				valueY += 80;
			}
		}

		sc.setContent(panel2);

	}

}
