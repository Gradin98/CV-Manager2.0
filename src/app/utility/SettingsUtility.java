package app.utility;


public class SettingsUtility {
	private static GuiLocation loc;

	public static GuiLocation getLoc() {
		return loc;
	}

	public static void setLoc(GuiLocation loc) {
		SettingsUtility.loc = loc;
	}
	
	
	
}
