package app.gui.generate;

import com.jfoenix.controls.JFXButton;

import app.gui.menu.GuiMenu;
import app.gui.menu.WindowButtons;
import app.gui.generate.GnrInformationDesign;
import app.gui.generate.GnrSectionDesign;
import app.gui.generate.listeners.Algorithm1;
import app.gui.generate.listeners.Algorithm2;
import app.gui.generate.listeners.Algorithm3;
import app.gui.generate.listeners.Algorithm4;
import app.gui.generate.listeners.Algorithm5;
import app.utility.GuiLocation;
import app.utility.GenerateUtility;
import app.utility.animation.BounceInTransition;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Generate {
	
	private final Scene scene;

	public Generate(Scene scene) {
		super();

		this.scene = scene;
	}
	public void setContent() {

		final AnchorPane pane = (AnchorPane) scene.lookup("#principalPane");
		pane.getChildren().clear();

		GenerateUtility.setLoc(GuiLocation.GENERATE);

		Pane smallpane = new Pane();
		smallpane.setId("generatePane");
		smallpane.setOpacity(0);

		

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

		new GnrSectionDesign(smallpane, 0, 10, "Generate cevauri").generateTitle();

		JFXButton alg1Button = new JFXButton("Ceva1".toUpperCase());
		alg1Button.getStyleClass().add("button-raised");
		alg1Button.setLayoutX(100);
		alg1Button.setLayoutY(90);
		alg1Button.setMinWidth(200);
		alg1Button.setMaxWidth(200);
		alg1Button.setMinHeight(50);
		alg1Button.setMaxHeight(50);
		
		alg1Button.setOnMouseClicked(new Algorithm1());

	
		smallpane.getChildren().add(alg1Button);
		
		
		JFXButton alg2Button = new JFXButton("Ceva2".toUpperCase());
		alg2Button.getStyleClass().add("button-raised");
		alg2Button.setLayoutX(400);
		alg2Button.setLayoutY(90);
		alg2Button.setMinWidth(200);
		alg2Button.setMaxWidth(200);
		alg2Button.setMinHeight(50);
		alg2Button.setMaxHeight(50);
		
		alg2Button.setOnMouseClicked(new Algorithm2());
		

		smallpane.getChildren().add(alg2Button);
		
		
		JFXButton alg3Button = new JFXButton("Ceva3".toUpperCase());
		alg3Button.getStyleClass().add("button-raised");
		alg3Button.setLayoutX(700);
		alg3Button.setLayoutY(90);
		alg3Button.setMinWidth(200);
		alg3Button.setMaxWidth(200);
		alg3Button.setMinHeight(50);
		alg3Button.setMaxHeight(50);
		
		alg3Button.setOnMouseClicked(new Algorithm3());
		

		smallpane.getChildren().add(alg3Button);
		
		
		JFXButton alg4Button = new JFXButton("Ceva4".toUpperCase());
		alg4Button.getStyleClass().add("button-raised");
		alg4Button.setLayoutX(250);
		alg4Button.setLayoutY(180);
		alg4Button.setMinWidth(200);
		alg4Button.setMaxWidth(200);
		alg4Button.setMinHeight(50);
		alg4Button.setMaxHeight(50);
		
		alg4Button.setOnMouseClicked(new Algorithm4());

		smallpane.getChildren().add(alg4Button);
		
		
		JFXButton alg5Button = new JFXButton("Ceva5".toUpperCase());
		alg5Button.getStyleClass().add("button-raised");
		alg5Button.setLayoutX(550);
		alg5Button.setLayoutY(180);
		alg5Button.setMinWidth(200);
		alg5Button.setMaxWidth(200);
		alg5Button.setMinHeight(50);
		alg5Button.setMaxHeight(50);
		
		alg5Button.setOnMouseClicked(new Algorithm5());

		smallpane.getChildren().add(alg5Button);


		
		smallpane.setPadding(new Insets(0, 0, 50, 0));
		new GuiMenu(scene).generateMenu();
		new WindowButtons(pane).generateButtons();
		new BounceInTransition(smallpane).play();
	}
}
