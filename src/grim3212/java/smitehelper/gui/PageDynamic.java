package grim3212.java.smitehelper.gui;

import grim3212.java.smitehelper.util.Constants;
import grim3212.java.smitehelper.util.FileUtil;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class PageDynamic implements IPage {

	private String pageName;

	public PageDynamic(String pageName) {
		this.pageName = pageName;
		setupPage();
	}

	private void setupPage() {
		BorderPane dynamicContainer = new BorderPane();
		dynamicContainer.setPadding(new Insets(25, 25, 0, 25));
		Scene dynamicPage = new Scene(dynamicContainer, 80 * Constants.rem, 50 * Constants.rem);
		dynamicPage.getStylesheets().add(FileUtil.getResource("resources/stylesheets/application.css"));

		PageUtil.registerPage(this, dynamicPage);

		dynamicContainer.setTop(PageUtil.createTitle(this));

		populatePage(dynamicContainer, dynamicPage);

		dynamicContainer.setBottom(PageUtil.createBackButton());
	}

	@Override
	public void populatePage(BorderPane container, Scene scene) {

		Button btn = new Button("click");
		btn.setOnAction(event -> {
			System.out.print(getPageName());
		});

	}

	@Override
	public String getPageName() {
		return this.pageName;
	}

}
