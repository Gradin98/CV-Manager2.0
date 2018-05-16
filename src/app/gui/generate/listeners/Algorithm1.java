package app.gui.generate.listeners;


import org.rosuda.REngine.Rserve.RserveException;

import app.alg.PhylogeneticTree.ProccesData;
import app.alg.PhylogeneticTree.ShowData;
import app.database.SQLiteConnection;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Algorithm1 implements EventHandler<MouseEvent>{


	@Override
	public void handle(MouseEvent arg0) {
		
		System.out.println(new SQLiteConnection().getAllContent());
		new ProccesData().ProccesWords(new SQLiteConnection().getAllContent());
		try {
			new ShowData().DrawPhTree();
		} catch (RserveException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		new Algorithm1pop().initializeWindow();
		
	}

}
