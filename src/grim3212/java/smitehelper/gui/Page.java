package grim3212.java.smitehelper.gui;

import grim3212.java.smitehelper.util.Constants;
import grim3212.java.smitehelper.util.FileUtil;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public abstract class Page implements IPage {

	public Page() {
		setupPage(false);
	}

	public Page(boolean isHome) {
		setupPage(isHome);
	}

	private void setupPage(boolean isHome) {
		BorderPane dynamicContainer = new BorderPane();
		dynamicContainer.setPadding(new Insets(25, 25, 0, 25));
		Scene dynamicPage = new Scene(dynamicContainer, 80 * Constants.rem, 50 * Constants.rem);
		dynamicPage.getStylesheets().add(FileUtil.getResource("resources/stylesheets/application.css"));

		PageUtil.registerPage(this, dynamicPage);

		dynamicContainer.setTop(PageUtil.createTitle(this));

		populatePage(dynamicContainer, dynamicPage);

		if (!isHome)
			dynamicContainer.setBottom(PageUtil.createBackButton());
	}

	@Override
	public abstract void populatePage(BorderPane container, Scene scene);

	@Override
	public abstract String getPageName();

}
