package app.utility;

public enum GuiLocation {
	DASHBOARD("dashboard"),
	SEARCH("search"),
	GENERATE("generate"),
	SETTINGS("settings");
	
	private String type;
	
	GuiLocation(String type){
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
