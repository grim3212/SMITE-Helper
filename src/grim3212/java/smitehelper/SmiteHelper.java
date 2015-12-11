package grim3212.java.smitehelper;

import java.util.Iterator;

import grim3212.java.smitehelper.gods.BasicGod;
import grim3212.java.smitehelper.gui.PageDynamic;
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

	public static Stage stage;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			stage = primaryStage;

			// Create and load the god data
			GodUtil.createGodData();
			// Update statistic HashMap
			GodUtil.createStatistics();

			// Setup all pages
			new PageHome();
			new PageStats();
			new PageRandomizer();
			new PageGodInfo();
			new PageSettings();
			// TODO: Add page for item and gamemode info

			Iterator<BasicGod> gitr = GodUtil.gods.iterator();
			while (gitr.hasNext())
				new PageDynamic(((BasicGod) gitr.next()).getName());

			Iterator<String> ritr = GodUtil.roles.keySet().iterator();
			while (ritr.hasNext())
				new PageDynamic((String) ritr.next());

			Iterator<String> pitr = GodUtil.pantheons.keySet().iterator();
			while (pitr.hasNext())
				new PageDynamic((String) pitr.next());

			Iterator<String> ptitr = GodUtil.powerTypes.keySet().iterator();
			while (ptitr.hasNext())
				new PageDynamic((String) ptitr.next());

			Iterator<String> dtitr = GodUtil.damageTypes.keySet().iterator();
			while (dtitr.hasNext())
				new PageDynamic((String) dtitr.next());

			// Then start on the Home page
			PageUtil.switchPage(Constants.HOME_NAME, false);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
