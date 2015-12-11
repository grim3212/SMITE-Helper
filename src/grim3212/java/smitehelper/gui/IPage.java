package grim3212.java.smitehelper.gui;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public interface IPage {

	public void populatePage(BorderPane container, Scene scene);

	public String getPageName();

}
