package app.gui.menu.listeners;

import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MinimizeWindow implements EventHandler<MouseEvent> {

	private final MaterialDesignIconView minimize;

	public MinimizeWindow(MaterialDesignIconView minimize) {
		super();
		this.minimize = minimize;
	}

	@Override
	public void handle(MouseEvent event) {

		Stage stage = (Stage) minimize.getScene().getWindow();
		stage.setIconified(true);

	}
}
