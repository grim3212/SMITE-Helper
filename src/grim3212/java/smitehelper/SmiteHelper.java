package grim3212.java.smitehelper;

import grim3212.java.smitehelper.gui.PageGodInfo;
import grim3212.java.smitehelper.gui.PageHome;
import grim3212.java.smitehelper.gui.PageRandomizer;
import grim3212.java.smitehelper.gui.PageSettings;
import grim3212.java.smitehelper.gui.PageStats;
import grim3212.java.smitehelper.gui.PageUtil;
import grim3212.java.smitehelper.util.Constants;
import grim3212.java.smitehelper.util.GodUtil;
import javafx.application.Application;
import javafx.stage.Stage;

public class SmiteHelper extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			// Create and load the god data
			GodUtil.createGodData();
			// Update statistic HashMap
			GodUtil.createStatistics();

			// Setup all pages
			new PageHome(primaryStage);
			new PageStats(primaryStage);
			new PageRandomizer(primaryStage);
			new PageGodInfo(primaryStage);
			new PageSettings(primaryStage);
			// TODO: Add page for item and gamemode info

			// Then start on the Home page
			PageUtil.switchPage(Constants.HOME_NAME, primaryStage);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
