package app.gui.search.listeners;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

public class CVObject extends RecursiveTreeObject<CVObject>{

	private final String ID,name,content,date;

	public CVObject(String iD, String name, String content, String date) {
		super();
		ID = iD;
		this.name = name;
		this.content = content;
		this.date = date;
	}

	public String getID() {
		return ID;
	}

	public String getName() {
		return name;
	}

	public String getContent() {
		return content;
	}

	public String getDate() {
		return date;
	}
	
	
}
