package grim3212.java.smitehelper.gui;

import grim3212.java.smitehelper.util.Constants;
import javafx.stage.Stage;

public class PageGodInfo extends Page {

	public PageGodInfo(Stage primaryStage) {
		super(primaryStage);
	}

	@Override
	public void setupPage(Stage primaryStage) {
		//Create a table of basically the spreadsheet that it pulls data from
		//This will then have links and images that end up taking you elsewhere
		//To get more info on things
	}

	@Override
	public String getPageName() {
		return Constants.GODINFO_NAME;
	}

}
