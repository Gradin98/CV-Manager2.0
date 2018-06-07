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

		JFXButton alg1Button = new JFXButton("Phylogenetic Tree".toUpperCase());
		alg1Button.getStyleClass().add("button-raised");
		alg1Button.setLayoutX(100);
		alg1Button.setLayoutY(90);
		alg1Button.setMinWidth(200);
		alg1Button.setMaxWidth(200);
		alg1Button.setMinHeight(50);
		alg1Button.setMaxHeight(50);
		
		alg1Button.setOnMouseClicked(new Algorithm1());

	
		smallpane.getChildren().add(alg1Button);
		
		
		JFXButton alg2Button = new JFXButton("K-means".toUpperCase());
		alg2Button.getStyleClass().add("button-raised");
		alg2Button.setLayoutX(400);
		alg2Button.setLayoutY(90);
		alg2Button.setMinWidth(200);
		alg2Button.setMaxWidth(200);
		alg2Button.setMinHeight(50);
		alg2Button.setMaxHeight(50);
		
		alg2Button.setOnMouseClicked(new Algorithm2());
		

		smallpane.getChildren().add(alg2Button);


		
		smallpane.setPadding(new Insets(0, 0, 50, 0));
		new GuiMenu(scene).generateMenu();
		new WindowButtons(pane).generateButtons();
		new BounceInTransition(smallpane).play();
	}
}
