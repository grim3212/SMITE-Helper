package grim3212.java.smitehelper.gui;

import grim3212.java.smitehelper.util.Constants;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class PageHome extends Page {

	public PageHome() {
		super(true);
		PageUtil.currentPage = getPageName();
	}

	@Override
	public void populatePage(BorderPane container, Scene scene) {
		VBox vbox = new VBox(15);
		vbox.setAlignment(Pos.BASELINE_CENTER);

		Text scenetitle = new Text(Constants.APPLICATION_NAME);
		scenetitle.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 40));

		Button statsBtn = new Button(Constants.STATS_NAME);
		statsBtn.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		statsBtn.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		statsBtn.setPadding(new Insets(15, 60, 25, 60));
		statsBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				PageUtil.switchPage(Constants.STATS_NAME, true);
			}
		});
		vbox.getChildren().add(statsBtn);

		Button randomizerBtn = new Button(Constants.RANDOMIZER_NAME);
		randomizerBtn.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		randomizerBtn.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		randomizerBtn.setPadding(new Insets(15, 60, 25, 60));
		randomizerBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				PageUtil.switchPage(Constants.RANDOMIZER_NAME, true);
			}
		});
		vbox.getChildren().add(randomizerBtn);

		Button godInfoBtn = new Button(Constants.GODINFO_NAME);
		godInfoBtn.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		godInfoBtn.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		godInfoBtn.setPadding(new Insets(15, 60, 25, 60));
		godInfoBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				PageUtil.switchPage(Constants.GODINFO_NAME, true);
			}
		});
		vbox.getChildren().add(godInfoBtn);

		Button settingsBtn = new Button(Constants.SETTINGS_NAME);
		settingsBtn.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		settingsBtn.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		settingsBtn.setPadding(new Insets(15, 60, 25, 60));
		settingsBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				PageUtil.switchPage(Constants.SETTINGS_NAME, true);
			}
		});
		vbox.getChildren().add(settingsBtn);

		container.setCenter(vbox);
	}

	@Override
	public String getPageName() {
		return Constants.HOME_NAME;
	}

}
