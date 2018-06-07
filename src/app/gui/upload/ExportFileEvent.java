package app.gui.upload;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.jfoenix.controls.JFXButton;

import app.database.Databases;
import app.database.SQLiteConnection;
import app.fileconverters.ParserFactory;
import app.fileconverters.ParserINTF;
import app.utility.image.ImageConverter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class ExportFileEvent implements EventHandler<ActionEvent>{

	private List<File> lista;
	private JFXButton submitButton;
	
	public ExportFileEvent(JFXButton submitButton) {
		this.lista = FileChooserEvent.getLista();
		this.submitButton = submitButton;
	}

	@Override
	public void handle(ActionEvent arg0) {
		Databases database = new SQLiteConnection();

		System.out.println("INTRU AICI");
		System.out.println(lista);
		if (lista != null) {
			
			System.out.println("INTRU AICI 2");
			final ParserFactory parserFactory = new ParserFactory();

			for (final File file : lista) {
				
				final ParserINTF parser = parserFactory.GetParser(file.getName());
				if (parser != null) {
					parser.setContent(file.getPath());
					try {
						database.setContent(parser.getContent(), file.getName(),new ImageConverter().convert(file));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
			
			Stage stage = (Stage) submitButton.getScene().getWindow();
			stage.close();
		}
		
	}
	
}
