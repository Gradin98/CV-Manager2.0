package app.gui.search;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Polygon;

public class SrcSectionDesign {



		private final Pane pane;
		private final double x;
		private final double y;
		private final String string;

		public SrcSectionDesign(Pane pane, double x, double y, String string) {
			super();
			this.pane = pane;
			this.x = x;
			this.y = y;
			this.string = string;
		}

		public void generateTitle() {
			
			Pane smallPane = new Pane();

			smallPane.setMaxWidth(300);
			smallPane.setMinWidth(300);
			smallPane.setMaxHeight(50);
			smallPane.setMinHeight(50);
			smallPane.setLayoutX(x);
			smallPane.setLayoutY(y);

			Polygon polygon = new Polygon();
			polygon.getPoints().addAll(new Double[] { 0.0, 0.0, 300.0, 0.0, 250.0, 50.0, 0.0, 50.0 });
			polygon.getStyleClass().add("blue-color");
			smallPane.getChildren().add(polygon);

			Label label = new Label(string);
			label.setAlignment(Pos.CENTER);
			label.getStyleClass().add("label-style");
			label.setMinHeight(50);
			label.setMaxHeight(50);
			label.setMaxWidth(250);
			label.setMinWidth(250);

			smallPane.getChildren().add(label);

			pane.getChildren().add(smallPane);
		}

	}

