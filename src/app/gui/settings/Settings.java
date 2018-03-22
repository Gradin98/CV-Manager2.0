package app.gui.settings;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRippler;

import app.gui.menu.GuiMenu;
import app.gui.menu.WindowButtons;
import app.utility.GuiLocation;
import app.utility.SettingsUtility;
import app.utility.animation.BounceInTransition;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class Settings {

	private final Scene scene;

	public Settings(Scene scene) {
		super();

		this.scene = scene;
	}

	@SuppressWarnings("static-access")
	public void setContent() {
		SettingsUtility.setLoc(GuiLocation.SETTINGS);
		AnchorPane pane = (AnchorPane) scene.lookup("#principalPane");

		pane.getChildren().clear();

		Pane smallpane = new Pane();
		
		smallpane.setId("settingsPane");
		
		smallpane.setMinWidth(1000);
		smallpane.setMinHeight(500);
		smallpane.setMaxWidth(1000);
		smallpane.setMaxHeight(500);

		pane.setLeftAnchor(smallpane, 100.0);
		pane.setRightAnchor(smallpane, 100.0);
		pane.setTopAnchor(smallpane, 100.0);
		pane.setBottomAnchor(smallpane, 100.0);

		smallpane.setOpacity(0);
		smallpane.getStyleClass().add("smallPane-color");
		new BounceInTransition(smallpane).play();

		JFXButton submitButton = new JFXButton("Submit".toUpperCase());
		submitButton.getStyleClass().add("button-raised");
		submitButton.setLayoutX(400);
		submitButton.setLayoutY(430);
		submitButton.setMinWidth(200);
		submitButton.setMaxWidth(200);
		submitButton.setMinHeight(50);
		submitButton.setMaxHeight(50);

		JFXButton newLanguage = new JFXButton("New Language".toUpperCase());
		newLanguage.getStyleClass().add("button-raised");
		newLanguage.setLayoutX(500);
		newLanguage.setLayoutY(70);
		newLanguage.setMinWidth(200);
		newLanguage.setMaxWidth(200);
		newLanguage.setMinHeight(50);
		newLanguage.setMaxHeight(50);

		JFXButton editLanguage = new JFXButton("Edit Language".toUpperCase());
		editLanguage.getStyleClass().add("button-raised");
		editLanguage.setLayoutX(750);
		editLanguage.setLayoutY(70);
		editLanguage.setMinWidth(200);
		editLanguage.setMaxWidth(200);
		editLanguage.setMinHeight(50);
		editLanguage.setMaxHeight(50);

		smallpane.getChildren().add(submitButton);
		smallpane.getChildren().add(newLanguage);
		smallpane.getChildren().add(editLanguage);

		ComboBox<String> chooseLanguage = new ComboBox<String>();

		chooseLanguage.getItems().add(new Label("en_default").getText());
		chooseLanguage.getItems().add(new Label("romana").getText());
		chooseLanguage.getItems().add(new Label("ceva1").getText());
		chooseLanguage.getItems().add(new Label("ceva2").getText());
		chooseLanguage.setPromptText(chooseLanguage.getItems().get(0));
		chooseLanguage.setLayoutX(50);
		chooseLanguage.setLayoutY(70);
		chooseLanguage.setMaxWidth(400);
		chooseLanguage.setMinWidth(400);
		chooseLanguage.setMaxHeight(50);
		chooseLanguage.setMinHeight(50);

		chooseLanguage.getStyleClass().add("jfx-combo-box");

		smallpane.getChildren().add(chooseLanguage);

		pane.getChildren().add(smallpane);
		
		SectionDesign des = new SectionDesign(scene, 0, 10, "CHOOSE LANGUAGE");
		des.generateTitle();
		
		new GuiMenu(scene).generateMenu();
		new WindowButtons(pane).generateButtons();

		
	}

}
