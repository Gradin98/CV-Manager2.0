package app.gui.settings;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

public class SectionDesign {
	
	private final Scene scene;
	private final double x;
	private final double y;
	private final String string;

	public SectionDesign(Scene scene, double x, double y, String string) {
		super();
		this.scene = scene;
		this.x = x;
		this.y = y;
		this.string = string;
	}
	
	public void generateTitle() {
		Pane pane = (Pane) scene.lookup("#settingsPane");
		
		Pane smallPane = new Pane();
		Rectangle rec = new Rectangle(200,50);
		rec.getStyleClass().add("blue-color");
		
		smallPane.getChildren().add(rec);
		
		smallPane.setMaxWidth(250);
		smallPane.setMinWidth(250);
		smallPane.setMaxHeight(50);
		smallPane.setMinHeight(50);
		smallPane.setLayoutX(x);
		smallPane.setLayoutY(y);
		
		Polygon polygon = new Polygon();
        polygon.getPoints().addAll(new Double[]{
            200.0, 50.0,
            200.0, 0.0,
            250.0, 0.0 });
        polygon.getStyleClass().add("blue-color");
        smallPane.getChildren().add(polygon);
        
        Label label = new Label(string);
        label.setAlignment(Pos.CENTER);
		label.getStyleClass().add("label-style");
		label.setMinHeight(50);
		label.setMaxHeight(50);
		label.setMaxWidth(200);
		label.setMinWidth(200);
		
		smallPane.getChildren().add(label);
		
		pane.getChildren().add(smallPane);
	}

}
