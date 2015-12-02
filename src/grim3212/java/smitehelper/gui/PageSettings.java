package grim3212.java.smitehelper.gui;

import grim3212.java.smitehelper.util.Constants;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class PageSettings extends Page {

	public PageSettings(Stage primaryStage) {
		super(primaryStage);
	}

	@Override
	public void setupPage(Stage primaryStage) {
		BorderPane settingsPane = new BorderPane();
		settingsPane.setPadding(new Insets(25, 25, 25, 25));
		Scene settingsScene = new Scene(settingsPane, 80 * Constants.rem, 50 * Constants.rem);
		settingsScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		PageUtil.registerPage(this, settingsScene);

		HBox settingsBox = new HBox();
		settingsBox.setAlignment(Pos.TOP_CENTER);
		Text settingstitle = new Text(getPageName());
		settingstitle.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 40));
		settingstitle.maxWidth(Double.MAX_VALUE);
		settingstitle.maxHeight(Double.MAX_VALUE);
		settingsBox.getChildren().add(settingstitle);
		settingsPane.setTop(settingsBox);

		HBox center = new HBox(100);
		center.setAlignment(Pos.TOP_CENTER);

		VBox settings = new VBox(15);
		//settings.setStyle("-fx-background-color: red");
		settings.setPadding(new Insets(50, 50, 50, 50));
		settings.setAlignment(Pos.TOP_LEFT);
		CheckBox sound = new CheckBox("Use sound");
		sound.setSelected(true);
		CheckBox images = new CheckBox("Use images");
		images.setSelected(true);
		settings.getChildren().addAll(sound, images);
		center.getChildren().add(settings);

		VBox credits = new VBox(15);
		//credits.setStyle("-fx-background-color: red");
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

		settingsPane.setCenter(center);

		HBox bottomBox = new HBox(150);
		bottomBox.setAlignment(Pos.CENTER);
		bottomBox.setPadding(new Insets(0, 60, 0, 60));
		HBox.setHgrow(bottomBox, Priority.ALWAYS);

		Button homeBtn = new Button("<-- Back");
		homeBtn.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		homeBtn.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		homeBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				PageUtil.switchPage(Constants.HOME_NAME, primaryStage);
			}
		});
		HBox.setHgrow(homeBtn, Priority.ALWAYS);

		bottomBox.getChildren().addAll(homeBtn);
		settingsPane.setBottom(bottomBox);
	}

	@Override
	public String getPageName() {
		return Constants.SETTINGS_NAME;
	}

}
