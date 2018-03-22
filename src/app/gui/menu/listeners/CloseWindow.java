package app.gui.menu.listeners;

import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class CloseWindow implements EventHandler<MouseEvent> {

	private final MaterialDesignIconView close;

	public CloseWindow(MaterialDesignIconView close) {
		super();
		this.close = close;
	}

	@Override
	public void handle(MouseEvent event) {

		Stage stage = (Stage) close.getScene().getWindow();
		stage.close();

	}

}
