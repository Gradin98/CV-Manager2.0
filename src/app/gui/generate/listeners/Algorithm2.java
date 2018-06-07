package app.gui.generate.listeners;


import org.rosuda.REngine.Rserve.RserveException;

import app.alg.PhylogeneticTree.ProccesData;
import app.alg.PhylogeneticTree.ShowData;
import app.database.SQLiteConnection;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class Algorithm2 implements EventHandler<MouseEvent>{


	@Override
	public void handle(MouseEvent arg0) {
		new ProccesData().ProccesWords(new SQLiteConnection().getAllContent());
		
		try {
			
			new ShowData().DrawKMeans();
			
		} catch (RserveException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Algorithm2pop().initializeWindow();
		
	}

}
