package grim3212.java.smitehelper.gui;

import grim3212.java.smitehelper.util.Constants;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HomePage extends Page {

	public HomePage(Stage primaryStage) {
		super(primaryStage);
	}

	@Override
	public void setupPage(Stage primaryStage) {
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.TOP_CENTER);
		grid.setHgap(50);
		grid.setVgap(50);
		grid.setPadding(new Insets(25, 25, 25, 25));

		Scene homeScene = new Scene(grid, 80 * Constants.rem, 50 * Constants.rem);
		homeScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		PageUtil.registerPage(this, homeScene);

		VBox vbBtn = new VBox(15);
		vbBtn.setAlignment(Pos.BASELINE_CENTER);

		Text scenetitle = new Text(Constants.APPLICATION_NAME);
		scenetitle.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 40));
		grid.add(scenetitle, 0, 0);

		Button statsBtn = new Button(Constants.STATS_NAME);
		statsBtn.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		statsBtn.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		statsBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				PageUtil.switchPage(Constants.STATS_NAME, primaryStage);
			}
		});
		vbBtn.getChildren().add(statsBtn);

		Button randomizerBtn = new Button(Constants.RANDOMIZER_NAME);
		randomizerBtn.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		randomizerBtn.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		randomizerBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				PageUtil.switchPage(Constants.RANDOMIZER_NAME, primaryStage);
			}
		});
		vbBtn.getChildren().add(randomizerBtn);

		Button godInfoBtn = new Button(Constants.GODINFO_NAME);
		godInfoBtn.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		godInfoBtn.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		godInfoBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				PageUtil.switchPage(Constants.GODINFO_NAME, primaryStage);
			}
		});
		vbBtn.getChildren().add(godInfoBtn);

		Button settingsBtn = new Button(Constants.SETTINGS_NAME);
		settingsBtn.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		settingsBtn.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		settingsBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				PageUtil.switchPage(Constants.SETTINGS_NAME, primaryStage);
			}
		});
		vbBtn.getChildren().add(settingsBtn);
		grid.add(vbBtn, 0, 1);
	}

	@Override
	public String getPageName() {
		return Constants.HOME_NAME;
	}

}
