package app.gui.dashboard;

import app.gui.dashboard.listeners.WindowDrag;
import app.gui.dashboard.listeners.WindowPressed;
import app.gui.menu.WindowButtons;
import app.gui.menu.listeners.DashBoardButton;
import app.gui.menu.listeners.GenerateButton;
import app.gui.menu.listeners.SearchButton;
import app.gui.menu.listeners.SettingsButton;
import app.gui.menu.listeners.UploadButton;
import app.utility.GuiLocation;
import app.utility.SettingsUtility;
import app.utility.animation.BounceInTransition;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Dashboard {

	private static double xOffset = 0;
	private static double yOffset = 0;

	private final Scene scene;

	public Dashboard(Scene scene) {
		super();
		this.scene = scene;

	}

	public static double getxOffset() {
		return xOffset;
	}

	public static void setxOffset(double xOffset) {
		Dashboard.xOffset = xOffset;
	}

	public static double getyOffset() {
		return yOffset;
	}

	public static void setyOffset(double yOffset) {
		Dashboard.yOffset = yOffset;
	}

	@SuppressWarnings("static-access")
	public void setDashBoard() {
		SettingsUtility.setLoc(GuiLocation.DASHBOARD);

		AnchorPane pane = (AnchorPane) scene.lookup("#principalPane");

		BoxElement[] boxElements = new BoxElement[7];

		Pane boxPane = new Pane();
		pane.setOnMouseDragged(new WindowDrag(pane));
		pane.setOnMousePressed(new WindowPressed(pane));

		boxElements[0] = new BoxElement(0, 0, boxPane, true);
		boxElements[0].makeBox(MaterialDesignIcon.UPLOAD, "UPLOAD DATA");
		boxElements[0].getSmallPane().setOnMouseClicked(new UploadButton());

		boxElements[1] = new BoxElement(300, 0, boxPane);
		boxElements[1].makeBox(MaterialDesignIcon.VIEW_DASHBOARD, "DASHBOARD");
		boxElements[1].getSmallPane().setOnMouseClicked(new DashBoardButton(scene));

		boxElements[2] = new BoxElement(600, 0, boxPane);
		boxElements[2].makeBox(MaterialDesignIcon.ACCOUNT_SEARCH, "SEARCH");
		boxElements[2].getSmallPane().setOnMouseClicked(new SearchButton(scene));

		boxElements[3] = new BoxElement(000, 225, boxPane);
		boxElements[3].makeBox(MaterialDesignIcon.AUTO_FIX, "GENERATE");
		boxElements[3].getSmallPane().setOnMouseClicked(new GenerateButton(scene));

		boxElements[4] = new BoxElement(300, 225, boxPane);
		boxElements[4].makeBox(MaterialDesignIcon.SETTINGS, "SETTINGS");
		boxElements[4].getSmallPane().setOnMouseClicked(new SettingsButton(scene));
		

		boxElements[5] = new BoxElement(600, 225, boxPane);
		boxElements[5].makeBox(MaterialDesignIcon.POWER, "CLOSE");
		//boxElements[3].getSmallPane().setOnMouseClicked(new CloseWindow(scene));

		
		
		
		boxPane.setMinWidth(800);
		boxPane.setMinHeight(400);
		boxPane.setMaxWidth(800);
		boxPane.setMaxHeight(400);

		boxPane.setId("boxPane");

		pane.setLeftAnchor(boxPane, 200.0);
		pane.setRightAnchor(boxPane, 200.0);
		pane.setTopAnchor(boxPane, 150.0);
		pane.setBottomAnchor(boxPane, 150.0);
		
		boxPane.setOpacity(0);
		
		pane.getChildren().add(boxPane);
		new WindowButtons(pane).generateButtons();
		
		
		new BounceInTransition(boxPane).play();

	}

	public void initializeScene(Stage primaryStage) {
		scene.getStylesheets().add(getClass().getResource("dashboard.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.initStyle(StageStyle.UNDECORATED);
		primaryStage.setResizable(true);

		primaryStage.show();

		Stage stage = (Stage) scene.getWindow();
		// stage.getIcons().add(new
		// Image("https://is1-ssl.mzstatic.com/image/thumb/Purple118/v4/2d/a0/dc/2da0dc7b-acf5-0fad-0093-0065cd89ff7b/AppIcon-1x_U007emarketing-85-220-0-6.png/246x0w.jpg"));
		stage.setTitle("CV-Manager");
	}

}
