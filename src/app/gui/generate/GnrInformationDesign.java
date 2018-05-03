package app.gui.generate;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Polygon;

public class GnrInformationDesign {

	private final Pane pane;
	private final double x;
	private final double y;
	private final String string;
	private final double width;

	public GnrInformationDesign(Pane pane, double x, double y, String string) {
		super();
		this.pane = pane;
		this.x = x;
		this.y = y;
		this.string = string;
		this.width = 150;
	}
	
	public GnrInformationDesign(Pane pane, double x, double y, String string, double width) {
		super();
		this.pane = pane;
		this.x = x;
		this.y = y;
		this.string = string;
		this.width = width;
	}

	public void generateSection() {

		Pane smallPane = new Pane();

		smallPane.setMaxWidth(width);
		smallPane.setMinWidth(width);
		smallPane.setMaxHeight(30);
		smallPane.setMinHeight(30);
		smallPane.setLayoutX(x);
		smallPane.setLayoutY(y);

		Polygon polygon = new Polygon();
		polygon.getPoints().addAll(new Double[] { 0.0, 30.0, width - 30, 30.0, width, 0.0, 30.0, 0.0 });
		polygon.getStyleClass().add("cyan-color");
		smallPane.getChildren().add(polygon);

		Label label = new Label(string);
		label.setAlignment(Pos.CENTER);
		label.getStyleClass().add("label-style");
		label.setMinHeight(30);
		label.setMaxHeight(30);
		label.setMaxWidth(width);
		label.setMinWidth(width);

		smallPane.getChildren().add(label);

		pane.getChildren().add(smallPane);
	}

}
