package app.gui.search.listeners;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

public class CVObject extends RecursiveTreeObject<CVObject>{

	private final String ID,name,content,date,image;

	public CVObject(String iD, String name, String content, String date,String image) {
		super();
		ID = iD;
		this.name = name;
		this.content = content;
		this.date = date;
		this.image = image;
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
	
	public String getImage() {
		return image;
	}
	
}
