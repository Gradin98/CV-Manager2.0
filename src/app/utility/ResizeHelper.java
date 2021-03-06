package app.utility;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ResizeHelper {

	@SuppressWarnings("unused")
	private static Scene scene;

	public static void addResizeListener(Scene scene) {
		ResizeHelper.scene = scene;
		Stage stage = (Stage) scene.getWindow();
		ResizeListener resizeListener = new ResizeListener(stage);
		stage.getScene().addEventHandler(MouseEvent.MOUSE_MOVED, resizeListener);
		stage.getScene().addEventHandler(MouseEvent.MOUSE_PRESSED, resizeListener);
		stage.getScene().addEventHandler(MouseEvent.MOUSE_DRAGGED, resizeListener);
		stage.getScene().addEventHandler(MouseEvent.MOUSE_EXITED, resizeListener);
		stage.getScene().addEventHandler(MouseEvent.MOUSE_EXITED_TARGET, resizeListener);
		ObservableList<Node> children = stage.getScene().getRoot().getChildrenUnmodifiable();
		for (Node child : children) {
			addListenerDeeply(child, resizeListener);
		}
	}

	public static void addListenerDeeply(Node node, EventHandler<MouseEvent> listener) {
		node.addEventHandler(MouseEvent.MOUSE_MOVED, listener);
		node.addEventHandler(MouseEvent.MOUSE_PRESSED, listener);
		node.addEventHandler(MouseEvent.MOUSE_DRAGGED, listener);
		node.addEventHandler(MouseEvent.MOUSE_EXITED, listener);
		node.addEventHandler(MouseEvent.MOUSE_EXITED_TARGET, listener);
		if (node instanceof Parent) {
			Parent parent = (Parent) node;
			ObservableList<Node> children = parent.getChildrenUnmodifiable();
			for (Node child : children) {
				addListenerDeeply(child, listener);
			}
		}
	}

	static class ResizeListener implements EventHandler<MouseEvent> {
		private Stage stage;
		private Cursor cursorEvent = Cursor.DEFAULT;
		private int border = 4;
		private double startX = 0;
		private double startY = 0;

		public ResizeListener(Stage stage) {
			this.stage = stage;
		}

		@SuppressWarnings("static-access")
		@Override
		public void handle(MouseEvent mouseEvent) {
			EventType<? extends MouseEvent> mouseEventType = mouseEvent.getEventType();
			Scene scene = stage.getScene();

			double mouseEventX = mouseEvent.getSceneX(), mouseEventY = mouseEvent.getSceneY(),
					sceneWidth = scene.getWidth(), sceneHeight = scene.getHeight();

			if (MouseEvent.MOUSE_MOVED.equals(mouseEventType) == true) {
				if (mouseEventX < border && mouseEventY < border) {
					cursorEvent = Cursor.NW_RESIZE;
				} else if (mouseEventX < border && mouseEventY > sceneHeight - border) {
					cursorEvent = Cursor.SW_RESIZE;
				} else if (mouseEventX > sceneWidth - border && mouseEventY < border) {
					cursorEvent = Cursor.NE_RESIZE;
				} else if (mouseEventX > sceneWidth - border && mouseEventY > sceneHeight - border) {
					cursorEvent = Cursor.SE_RESIZE;
				} else if (mouseEventX < border) {
					cursorEvent = Cursor.W_RESIZE;
				} else if (mouseEventX > sceneWidth - border) {
					cursorEvent = Cursor.E_RESIZE;
				} else if (mouseEventY < border) {
					cursorEvent = Cursor.N_RESIZE;
				} else if (mouseEventY > sceneHeight - border) {
					cursorEvent = Cursor.S_RESIZE;
				} else {
					cursorEvent = Cursor.DEFAULT;
				}
				scene.setCursor(cursorEvent);
			} else if (MouseEvent.MOUSE_EXITED.equals(mouseEventType)
					|| MouseEvent.MOUSE_EXITED_TARGET.equals(mouseEventType)) {
				scene.setCursor(Cursor.DEFAULT);
			} else if (MouseEvent.MOUSE_PRESSED.equals(mouseEventType) == true) {
				startX = stage.getWidth() - mouseEventX;
				startY = stage.getHeight() - mouseEventY;
			} else if (MouseEvent.MOUSE_DRAGGED.equals(mouseEventType) == true) {
				if (Cursor.DEFAULT.equals(cursorEvent) == false) {
					if (Cursor.W_RESIZE.equals(cursorEvent) == false && Cursor.E_RESIZE.equals(cursorEvent) == false) {
						double minHeight = stage.getMinHeight() > (border * 2) ? stage.getMinHeight() : (border * 2);
						if (Cursor.NW_RESIZE.equals(cursorEvent) == true || Cursor.N_RESIZE.equals(cursorEvent) == true
								|| Cursor.NE_RESIZE.equals(cursorEvent) == true) {
							if (stage.getHeight() > minHeight || mouseEventY < 0) {
								if (stage.getHeight() < 700) {
									stage.setHeight(700);

									return;
								}

								stage.setHeight(stage.getY() - mouseEvent.getScreenY() + stage.getHeight());
								stage.setY(mouseEvent.getScreenY());
							}
						} else {
							if (stage.getHeight() > minHeight || mouseEventY + startY - stage.getHeight() > 0) {

								if (stage.getHeight() < 700) {
									stage.setHeight(700);
									stage.setMaxHeight(700);
									stage.setMinHeight(700);

									return;
								}

								stage.setHeight(mouseEventY + startY);

							}
						}
					}

					if (Cursor.N_RESIZE.equals(cursorEvent) == false && Cursor.S_RESIZE.equals(cursorEvent) == false) {
						double minWidth = stage.getMinWidth() > (border * 2) ? stage.getMinWidth() : (border * 2);
						if (Cursor.NW_RESIZE.equals(cursorEvent) == true || Cursor.W_RESIZE.equals(cursorEvent) == true
								|| Cursor.SW_RESIZE.equals(cursorEvent) == true) {
							if (stage.getWidth() > minWidth || mouseEventX < 0) {

								AnchorPane pane = (AnchorPane) scene.lookup("#principalPane");
								Pane boxPane;

								if (SettingsUtility.getLoc().getType().equals("dashboard")) {
									boxPane = (Pane) scene.lookup("#boxPane");
								} else if (SettingsUtility.getLoc().getType().equals("settings")) {
									boxPane = (Pane) scene.lookup("#settingsPane");
								} else {
									return;
								}

								if (stage.getWidth() < 1199) {
									stage.setWidth(1200);
									stage.setMinWidth(1200);
									stage.setMaxWidth(1200);

									pane.setLeftAnchor(boxPane, 200.0);
									pane.setRightAnchor(boxPane, 200.0);

									return;
								}

								stage.setWidth(stage.getX() - mouseEvent.getScreenX() + stage.getWidth());
								stage.setX(mouseEvent.getScreenX());

								double width;
								
								if (SettingsUtility.getLoc().getType().equals("dashboard")) {
									width = (stage.getWidth() - 800) / 2;
								} else if (SettingsUtility.getLoc().getType().equals("settings")) {
									width = (stage.getWidth() - 1000) / 2;
								} else {
									return;
								}

								pane.setLeftAnchor(boxPane, width);
								pane.setRightAnchor(boxPane, width);

							}
						} else {
							if (stage.getWidth() > minWidth || mouseEventX + startX - stage.getWidth() > 0) {

								AnchorPane pane = (AnchorPane) scene.lookup("#principalPane");
								Pane boxPane;

								if (SettingsUtility.getLoc().getType().equals("dashboard")) {
									boxPane = (Pane) scene.lookup("#boxPane");
								} else if (SettingsUtility.getLoc().getType().equals("settings")) {
									boxPane = (Pane) scene.lookup("#settingsPane");
								} else {
									return;
								}

								if (stage.getWidth() < 1199) {
									stage.setWidth(1200);
									stage.setMinWidth(1200);
									stage.setMaxWidth(1200);

									pane.setLeftAnchor(boxPane, 200.0);
									pane.setRightAnchor(boxPane, 200.0);

									return;
								}
								stage.setWidth(mouseEventX + startX);

								double width;
								
								if (SettingsUtility.getLoc().getType().equals("dashboard")) {
									width = (stage.getWidth() - 800) / 2;
								} else if (SettingsUtility.getLoc().getType().equals("settings")) {
									width = (stage.getWidth() - 1000) / 2;
								} else {
									return;
								}

								pane.setLeftAnchor(boxPane, width);
								pane.setRightAnchor(boxPane, width);
							}

						}
					}
				}
			}
		}
	}
}