package app.gui.search.listeners;

import java.util.Map.Entry;
import java.util.TreeMap;

import com.jfoenix.controls.*;
import com.jfoenix.controls.cells.editors.TextFieldEditorBuilder;
import com.jfoenix.controls.cells.editors.base.GenericEditableTreeTableCell;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableColumn.CellDataFeatures;
import javafx.util.Callback;

public class TableMode {

	public void setTable(TreeMap<String, CVObject> searchedContent) {
		JFXTreeTableColumn<CVObject, String> id = new JFXTreeTableColumn<>("ID");
		id.setPrefWidth(30);
		id.setCellValueFactory(new Callback<CellDataFeatures<CVObject, String>, ObservableValue<String>>() {

			@Override
			public ObservableValue<String> call(CellDataFeatures<CVObject, String> param) {
				ObservableValue<String> val = new SimpleStringProperty(param.getValue().getValue().getID());
				return val;
			}
		});

		JFXTreeTableColumn<CVObject, String> name = new JFXTreeTableColumn<>("name");
		name.setPrefWidth(200);
		name.setCellValueFactory(new Callback<CellDataFeatures<CVObject, String>, ObservableValue<String>>() {

			@Override
			public ObservableValue<String> call(CellDataFeatures<CVObject, String> param) {
				ObservableValue<String> val = new SimpleStringProperty(param.getValue().getValue().getName());
				return val;
			}
		});

		JFXTreeTableColumn<CVObject, String> content = new JFXTreeTableColumn<>("content");
		content.setPrefWidth(370);
		content.setCellValueFactory(new Callback<CellDataFeatures<CVObject, String>, ObservableValue<String>>() {

			@Override
			public ObservableValue<String> call(CellDataFeatures<CVObject, String> param) {
				ObservableValue<String> val = new SimpleStringProperty(param.getValue().getValue().getContent());
				return val;
			}
		});

		JFXTreeTableColumn<CVObject, String> date = new JFXTreeTableColumn<>("date");
		date.setPrefWidth(185);
		date.setCellValueFactory(new Callback<CellDataFeatures<CVObject, String>, ObservableValue<String>>() {

			@Override
			public ObservableValue<String> call(CellDataFeatures<CVObject, String> param) {
				ObservableValue<String> val = new SimpleStringProperty(param.getValue().getValue().getDate());
				return val;
			}
		});

		id.setCellFactory((TreeTableColumn<CVObject, String> param) -> new GenericEditableTreeTableCell<>(
				new TextFieldEditorBuilder()));

		name.setCellFactory((TreeTableColumn<CVObject, String> param) -> new GenericEditableTreeTableCell<>(
				new TextFieldEditorBuilder()));

		content.setCellFactory((TreeTableColumn<CVObject, String> param) -> new GenericEditableTreeTableCell<>(
				new TextFieldEditorBuilder()));

		date.setCellFactory((TreeTableColumn<CVObject, String> param) -> new GenericEditableTreeTableCell<>(
				new TextFieldEditorBuilder()));

		ObservableList<CVObject> cvs = FXCollections.observableArrayList();
		for(Entry<String, CVObject> entry : searchedContent.entrySet()) {
			cvs.add(entry.getValue());
		}
		
		final TreeItem<CVObject> root = new RecursiveTreeItem<>(cvs, RecursiveTreeObject::getChildren);
		root.setExpanded(false);
		JFXTreeTableView<CVObject> treeView = new JFXTreeTableView<>(root);
		treeView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        treeView.setShowRoot(false);
        treeView.setEditable(false);
        treeView.autosize();
        
        treeView.setMaxSize(800, 450);
        treeView.setMinSize(800, 450);
        treeView.getColumns().setAll(id, name, content, date);
     
        
        new TableModeWindow().initializeWindow(treeView);
		

	}
}
