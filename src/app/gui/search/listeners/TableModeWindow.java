package app.gui.search.listeners;

import java.util.TreeMap;

import com.jfoenix.controls.JFXTreeTableView;

import app.gui.dashboard.listeners.WindowDrag;
import app.gui.dashboard.listeners.WindowPressed;
import app.gui.upload.WindowButtons;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class TableModeWindow {

	public void initializeWindow(JFXTreeTableView<CVObject> treeView) {

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

		treeView.setLayoutX(0);
		treeView.setLayoutY(50);
		pane.getChildren().add(treeView);

	}
}
