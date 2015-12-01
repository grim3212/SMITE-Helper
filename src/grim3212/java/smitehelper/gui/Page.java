package grim3212.java.smitehelper.gui;

import javafx.stage.Stage;

public abstract class Page {

	public Page(Stage primaryStage) {
		setupPage(primaryStage);
	}

	public abstract void setupPage(Stage primaryStage);

	public abstract String getPageName();

}
