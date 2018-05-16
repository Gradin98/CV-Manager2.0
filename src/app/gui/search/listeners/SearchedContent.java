package app.gui.search.listeners;

import java.util.Collection;
import java.util.Collections;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.fxmisc.flowless.VirtualizedScrollPane;
import org.fxmisc.richtext.CodeArea;
import org.fxmisc.richtext.model.StyleSpans;
import org.fxmisc.richtext.model.StyleSpansBuilder;

import app.gui.dashboard.listeners.WindowDrag;
import app.gui.dashboard.listeners.WindowPressed;
import app.gui.upload.WindowButtons;
import app.utility.TransformRegex;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Functie care afiseaza diferit textu cautat.
 * 
 * <ol>
 * Contine functiile:
 * <li>{@link #createInterface(Entry, TextField)}</li>
 * <li>{@link #computeHighlighting(String, Pattern)}</li>
 * </ol>
 * 
 * @author Kocsis Lorand
 *
 */
public class SearchedContent {

	/**
	 * Functie care seteaza style-u pe cuvintele cautate.
	 * @param entry
	 * @param searchfield
	 */
	public void createInterface(Entry<String, CVObject> entry, TextField searchfield) {
		try {
			
			AnchorPane pane = new AnchorPane();
			final String content = entry.getValue().getContent();
			final TransformRegex transform = new TransformRegex();
			final String regex = transform.transform(searchfield.getText());
			final String sampleCode = String.join("\n", new String[] { content });
			final String KEYWORD_PATTERN = regex;
			final CodeArea codeArea = new CodeArea();
			final ScrollPane sc = new ScrollPane();
			final Pattern PATTERN = Pattern.compile("(?<KEYWORD>" + KEYWORD_PATTERN + ")");
			
			pane.getStyleClass().add("blue-color");
			
			sc.setLayoutX(0);
			sc.setLayoutY(50);
			pane.getChildren().add(sc);
			sc.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
			sc.getStyleClass().add("scrollerPaneBlue-style");
			

			codeArea.richChanges().filter(ch -> !ch.getInserted().equals(ch.getRemoved())) // XXX
					.subscribe(change -> {
						codeArea.setStyleSpans(0, computeHighlighting(codeArea.getText(), PATTERN));
					});
			codeArea.replaceText(0, 0, sampleCode);
			codeArea.getStyleClass().add("codeArea-style");
			codeArea.setEditable(false);
			sc.setContent(codeArea);
			final Scene scene = new Scene(pane, 800, 500);

			scene.getStylesheets().add(getClass().getResource("search.css").toExternalForm());

			final Stage primaryStage = new Stage();
			primaryStage.setScene(scene);
			primaryStage.setTitle(entry.getKey());
			primaryStage.initStyle(StageStyle.UNDECORATED);
			primaryStage.show();
			
			new WindowButtons(pane).generateButtons();

			pane.setOnMouseDragged(new WindowDrag(pane));
			pane.setOnMousePressed(new WindowPressed(pane));
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Functie care returneaza style-ul necesar pentru setare in functie de pozitii
	 * @param text Stringul care trebuie dat in alt design
	 * @param PATTERN  
	 * @return Style-ul modificat
	 */
	private static StyleSpans<Collection<String>> computeHighlighting(String text, Pattern PATTERN) {
		final Matcher matcher = PATTERN.matcher(text);
		int lastKwEnd = 0;
		final StyleSpansBuilder<Collection<String>> spansBuilder = new StyleSpansBuilder<>();
		while (matcher.find()) {
			String styleClass = matcher.group("KEYWORD") != null ? "keyword" : null;
			/* never happens */ assert styleClass != null;
			spansBuilder.add(Collections.singleton("white"), matcher.start() - lastKwEnd);
			spansBuilder.add(Collections.singleton(styleClass), matcher.end() - matcher.start());
			lastKwEnd = matcher.end();
		}
		spansBuilder.add(Collections.singleton("white"), text.length() - lastKwEnd);
		return spansBuilder.create();
	}

}
