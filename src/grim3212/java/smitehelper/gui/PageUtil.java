package grim3212.java.smitehelper.gui;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Stack;

import grim3212.java.smitehelper.SmiteHelper;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class PageUtil {

	public static HashMap<IPage, Scene> pages = new HashMap<IPage, Scene>();
	public static String currentPage;
	public static Stack<String> previousPage = new Stack<String>();

	public static void registerPage(IPage page, Scene scene) {
		pages.put(page, scene);
	}

	public static void switchPage(String pageName, boolean pushPage) {
		IPage newPage = null;

		Iterator<IPage> itr = pages.keySet().iterator();
		while (itr.hasNext()) {
			IPage nextPage = itr.next();
			if (nextPage.getPageName().equals(pageName)) {
				newPage = nextPage;
				break;
			}
		}

		if (newPage != null) {
			SmiteHelper.stage.setTitle("SMITE Helper | " + newPage.getPageName());
			SmiteHelper.stage.setScene(pages.get(newPage));
			if (pushPage)
				previousPage.push(currentPage);
			currentPage = newPage.getPageName();
		} else {
			System.out.println("Couldn't find page " + pageName);
		}
	}

	public static HBox createTitle(Page page) {
		HBox titleBox = new HBox();
		titleBox.setAlignment(Pos.TOP_CENTER);
		Text statsTitle = new Text(page.getPageName());
		statsTitle.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 40));
		statsTitle.maxWidth(Double.MAX_VALUE);
		statsTitle.maxHeight(Double.MAX_VALUE);
		titleBox.getChildren().add(statsTitle);

		return titleBox;
	}

	public static HBox createTitle(PageDynamic pageName) {
		HBox titleBox = new HBox();
		titleBox.setAlignment(Pos.TOP_CENTER);
		Text statsTitle = new Text(pageName.getPageName());
		statsTitle.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 40));
		statsTitle.maxWidth(Double.MAX_VALUE);
		statsTitle.maxHeight(Double.MAX_VALUE);
		titleBox.getChildren().add(statsTitle);

		return titleBox;
	}

	public static HBox createBackButton() {
		HBox bottomBox = new HBox();
		bottomBox.setAlignment(Pos.CENTER);
		HBox.setHgrow(bottomBox, Priority.ALWAYS);
		bottomBox.setPadding(new Insets(15, 60, 25, 60));

		Button homeBtn = new Button("<-- Back");
		homeBtn.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		homeBtn.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		homeBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				PageUtil.switchPage(previousPage.pop(), false);
			}
		});
		HBox.setHgrow(homeBtn, Priority.ALWAYS);
		bottomBox.getChildren().add(homeBtn);

		return bottomBox;
	}
}
