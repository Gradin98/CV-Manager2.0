package app.gui.settings;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXColorPicker;
import com.jfoenix.controls.JFXToggleButton;

import app.gui.menu.GuiMenu;
import app.gui.menu.WindowButtons;
import app.utility.GuiLocation;
import app.utility.SettingsUtility;
import app.utility.animation.BounceInTransition;
import javafx.animation.RotateTransition;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Settings {

	private final Scene scene;
	public static boolean DONE = false;

	public Settings(Scene scene) {
		super();

		this.scene = scene;
	}

	@SuppressWarnings("static-access")
	public void setContent() {

		final AnchorPane pane = (AnchorPane) scene.lookup("#principalPane");
		pane.getChildren().clear();

		SettingsUtility.setLoc(GuiLocation.SETTINGS);

		Pane smallpane = new Pane();
		smallpane.setId("settingsPane");
		smallpane.setOpacity(0);
		Pane scrollsmallPane = new Pane();

		ScrollPane sc = new ScrollPane();
		sc.setLayoutX(0);
		sc.setLayoutY(0);
		sc.setContent(scrollsmallPane);
		sc.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
		sc.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

		scrollsmallPane.setMaxWidth(1000);
		scrollsmallPane.setMinWidth(1000);
		sc.setMaxWidth(1000);
		sc.setMinWidth(1000);
		sc.setMinHeight(400);
		sc.setMaxHeight(400);
		sc.getStyleClass().add("smallPane-color");
		scrollsmallPane.getStyleClass().add("smallPane-color");
		smallpane.getChildren().add(sc);

		pane.getChildren().add(smallpane);

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

		new SectionDesign(scrollsmallPane, 0, 10, "CHOOSE LANGUAGE").generateTitle();

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
		scrollsmallPane.getChildren().add(newLanguage);
		scrollsmallPane.getChildren().add(editLanguage);

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

		scrollsmallPane.getChildren().add(chooseLanguage);

		new SectionDesign(scrollsmallPane, 0, 190, "ENABLE ANIMATIONS").generateTitle();

		JFXToggleButton animationActive = new JFXToggleButton();
		animationActive.getStyleClass().add("jfx-toggle-button");
		animationActive.setLayoutX(50);
		animationActive.setLayoutY(250);
		scrollsmallPane.getChildren().add(animationActive);

		new InformationDesign(scrollsmallPane, 170, 277, "ENABLED").generateSection();

		new SectionDesign(scrollsmallPane, 0, 380, "CHANGE COLOR").generateTitle();

		new InformationDesign(scrollsmallPane, 50, 450, "CHOOSE PRIMARY COLOR", 350).generateSection();
		JFXColorPicker colorPickerPrimary = new JFXColorPicker();
		colorPickerPrimary.setLayoutX(450);
		colorPickerPrimary.setLayoutY(453);
		scrollsmallPane.getChildren().add(colorPickerPrimary);

		new InformationDesign(scrollsmallPane, 50, 500, "CHOOSE SECONDARY COLOR", 350).generateSection();
		JFXColorPicker colorPickerSecondary = new JFXColorPicker();
		colorPickerSecondary.setLayoutX(450);
		colorPickerSecondary.setLayoutY(503);
		scrollsmallPane.getChildren().add(colorPickerSecondary);

		new InformationDesign(scrollsmallPane, 50, 550, "CHOOSE BACKGROUND COLOR", 350).generateSection();
		JFXColorPicker colorPickerBackground = new JFXColorPicker();
		colorPickerBackground.setLayoutX(450);
		colorPickerBackground.setLayoutY(553);
		scrollsmallPane.getChildren().add(colorPickerBackground);

		new SectionDesign(scrollsmallPane, 0, 650, "SEARCH SETTINGS").generateTitle();

		new InformationDesign(scrollsmallPane, 50, 717, "DATE MODE", 250).generateSection();

		JFXToggleButton dateModeActive = new JFXToggleButton();
		dateModeActive.getStyleClass().add("jfx-toggle-button");
		dateModeActive.setLayoutX(320);
		dateModeActive.setLayoutY(690);
		scrollsmallPane.getChildren().add(dateModeActive);

		new InformationDesign(scrollsmallPane, 550, 717, "REGEX MODE", 250).generateSection();

		JFXToggleButton regexModeActive = new JFXToggleButton();
		regexModeActive.getStyleClass().add("jfx-toggle-button");
		regexModeActive.setLayoutX(820);
		regexModeActive.setLayoutY(690);
		scrollsmallPane.getChildren().add(regexModeActive);

		new InformationDesign(scrollsmallPane, 50, 767, "VIEW MODE", 250).generateSection();

		JFXToggleButton viewModeActive = new JFXToggleButton();
		viewModeActive.getStyleClass().add("jfx-toggle-button");
		viewModeActive.setLayoutX(320);
		viewModeActive.setLayoutY(740);
		scrollsmallPane.getChildren().add(viewModeActive);

		new SectionDesign(scrollsmallPane, 0, 860, "GENERATE SETTINGS").generateTitle();

		new InformationDesign(scrollsmallPane, 50, 927, "PHILOGENETIC TREE", 300).generateSection();

		JFXToggleButton philogenetic = new JFXToggleButton();
		philogenetic.getStyleClass().add("jfx-toggle-button");
		philogenetic.setLayoutX(370);
		philogenetic.setLayoutY(900);
		scrollsmallPane.getChildren().add(philogenetic);

		new InformationDesign(scrollsmallPane, 550, 927, "K-MEANS ALGORITHM", 300).generateSection();

		JFXToggleButton kmeans = new JFXToggleButton();
		kmeans.getStyleClass().add("jfx-toggle-button");
		kmeans.setLayoutX(870);
		kmeans.setLayoutY(900);
		scrollsmallPane.getChildren().add(kmeans);

		new InformationDesign(scrollsmallPane, 50, 977, "RELEVANCE ALGORITHM", 300).generateSection();

		JFXToggleButton relevance = new JFXToggleButton();
		relevance.getStyleClass().add("jfx-toggle-button");
		relevance.setLayoutX(370);
		relevance.setLayoutY(950);
		scrollsmallPane.getChildren().add(relevance);

		new InformationDesign(scrollsmallPane, 550, 977, "IDENTIFICATION TREE", 300).generateSection();

		JFXToggleButton identification = new JFXToggleButton();
		identification.getStyleClass().add("jfx-toggle-button");
		identification.setLayoutX(870);
		identification.setLayoutY(950);
		scrollsmallPane.getChildren().add(identification);

		new InformationDesign(scrollsmallPane, 50, 1027, "IMAGE GENERATION", 300).generateSection();

		JFXToggleButton image = new JFXToggleButton();
		image.getStyleClass().add("jfx-toggle-button");
		image.setLayoutX(370);
		image.setLayoutY(1000);
		scrollsmallPane.getChildren().add(image);

		scrollsmallPane.setPadding(new Insets(0, 0, 50, 0));
		new GuiMenu(scene).generateMenu();
		new WindowButtons(pane).generateButtons();
		new BounceInTransition(smallpane).play();

	}

}
