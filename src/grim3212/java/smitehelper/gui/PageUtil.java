package grim3212.java.smitehelper.gui;

import java.util.HashMap;
import java.util.Iterator;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class PageUtil {

	public static HashMap<Page, Scene> pages = new HashMap<Page, Scene>();

	public static void registerPage(Page page, Scene scene) {
		pages.put(page, scene);
	}

	public static void switchPage(String pageName, Stage primaryStage) {
		Page newPage = null;

		Iterator<Page> itr = pages.keySet().iterator();
		while (itr.hasNext()) {
			Page nextPage = itr.next();
			if (nextPage.getPageName().equals(pageName)) {
				newPage = nextPage;
				break;
			}
		}

		if (newPage != null) {
			primaryStage.setTitle("SMITE Helper | " + newPage.getPageName());
			primaryStage.setScene(pages.get(newPage));
		} else {
			System.out.println("Couldn't find page " + pageName);
		}
	}
}
