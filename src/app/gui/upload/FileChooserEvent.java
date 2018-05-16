package app.gui.upload;

import java.io.File;
import java.util.List;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FileChooserEvent implements EventHandler<ActionEvent>{

	private static List<File> lista;
	private FileChooser fileC = new FileChooser();
	private Label number;
	private JFXButton submitButton;
	
	public FileChooserEvent(List<File> lista,Label number, JFXButton submitButton) {
		FileChooserEvent.lista = lista;
		this.number = number;
		this.submitButton = submitButton;
	}

	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		
		Stage stage = new Stage();
		lista = fileC.showOpenMultipleDialog(stage);
		if (lista != null) {
			number.setText(String.valueOf(lista.size()));
		}
		
		System.out.println(lista);
		
		submitButton.setOnAction(new ExportFileEvent(submitButton));
		
	}
	
	public static List<File> getLista(){
		return lista;
	}
}
