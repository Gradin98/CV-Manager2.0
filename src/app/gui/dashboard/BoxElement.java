package app.gui.dashboard;

import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class BoxElement {

	private final double x;
	private final double y;
	private final Pane pane;
	private final AnchorPane smallPane = new AnchorPane();
	private final boolean important;

	public BoxElement(double x, double y, Pane pane) {
		super();
		this.x = x;
		this.y = y;
		this.pane = pane;
		this.important = false;
	}

	public BoxElement(double x, double y, Pane pane, boolean important) {
		super();
		this.x = x;
		this.y = y;
		this.pane = pane;
		this.important = important;
	}
	
	public AnchorPane getSmallPane() {
		return smallPane;
	}

	@SuppressWarnings("static-access")
	private void generateBox(MaterialDesignIcon icon) {
		MaterialDesignIconView iconView = new MaterialDesignIconView(icon, "100px");

		if (important) {
			iconView.getStyleClass().add("box-element-icon-important");
		} else {
			iconView.getStyleClass().add("box-element-icon");
		}

		smallPane.setLeftAnchor(iconView, 50.0);
		smallPane.setRightAnchor(iconView, 50.0);
		smallPane.setTopAnchor(iconView, 25.0);
		smallPane.getChildren().add(iconView);

	}

	@SuppressWarnings("static-access")
	private void generateText(String text) {
		Label lb = new Label(text);
		lb.getStyleClass().add("box-element-label");

		if (important) {
			lb.getStyleClass().add("box-element-label-important");
		}

		lb.setMaxWidth(160);
		lb.setMinWidth(160);
		lb.setAlignment(Pos.CENTER);
		smallPane.setLeftAnchor(lb, 20.0);
		smallPane.setRightAnchor(lb, 20.0);
		smallPane.setTopAnchor(lb, 130.0);

		smallPane.getChildren().add(lb);
	}

	public void makeBox(MaterialDesignIcon icon, String text) {
		smallPane.setMinWidth(200);
		smallPane.setMinHeight(200);
		smallPane.setMaxWidth(200);
		smallPane.setMaxHeight(200);
		smallPane.getStyleClass().add("box-element-border");

		if (important) {
			smallPane.getStyleClass().add("box-element-pane-important");
		} else {
			smallPane.getStyleClass().add("box-element-pane");
		}

		smallPane.setCenterShape(true);
		


		generateBox(icon);
		generateText(text);
		smallPane.setLayoutX(x);
		smallPane.setLayoutY(y);
		pane.getChildren().add(smallPane);
	}

}
