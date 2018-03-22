package app;

import app.gui.dashboard.Dashboard;
import app.utility.ResizeHelper;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			AnchorPane root = new AnchorPane();
			Scene scene = new Scene(root, 1200, 700);

			root.setId("principalPane");
			
			Dashboard dash = new Dashboard(scene);
			dash.setDashBoard();
			dash.initializeScene(primaryStage);
			
			ResizeHelper.addResizeListener(scene);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
	

	
}
