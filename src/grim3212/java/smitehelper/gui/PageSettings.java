package grim3212.java.smitehelper.gui;

import grim3212.java.smitehelper.util.Constants;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class PageSettings extends Page {

	@Override
	public void populatePage(BorderPane container, Scene scene) {
		HBox center = new HBox(100);
		center.setAlignment(Pos.TOP_CENTER);

		VBox settings = new VBox(15);
		settings.setPadding(new Insets(50, 50, 50, 50));
		settings.setAlignment(Pos.TOP_LEFT);
		CheckBox sound = new CheckBox("Use sound");
		sound.setSelected(true);
		CheckBox images = new CheckBox("Use images");
		images.setSelected(true);
		settings.getChildren().addAll(sound, images);
		center.getChildren().add(settings);

		VBox credits = new VBox(15);
		credits.setPadding(new Insets(50, 50, 50, 50));
		credits.setAlignment(Pos.TOP_LEFT);

		Text version = new Text("Version: " + Constants.VERSION);
		version.setFont(Font.font("Tahoma", FontWeight.THIN, 18));
		version.setTextAlignment(TextAlignment.JUSTIFY);
		credits.getChildren().add(version);

		Text author = new Text("By: Grim3212");
		author.setFont(Font.font("Tahoma", FontWeight.THIN, 18));
		author.setTextAlignment(TextAlignment.JUSTIFY);
		credits.getChildren().add(author);
		center.getChildren().add(credits);
		container.setCenter(center);
	}

	@Override
	public String getPageName() {
		return Constants.SETTINGS_NAME;
	}
}