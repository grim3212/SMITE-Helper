package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {

			final double rem = javafx.scene.text.Font.getDefault().getSize();

			GridPane grid = new GridPane();
			grid.setAlignment(Pos.TOP_CENTER);
			grid.setHgap(50);
			grid.setVgap(50);
			grid.setPadding(new Insets(25, 25, 25, 25));

			Scene homeScene = new Scene(grid, 40 * rem, 33.33 * rem);
			homeScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			primaryStage.setTitle("SMITE Helper | Home");
			primaryStage.setScene(homeScene);
			primaryStage.show();

			BorderPane settingsPane = new BorderPane();
			settingsPane.setPadding(new Insets(25, 25, 25, 25));
			Scene settingsScene = new Scene(settingsPane, 40 * rem, 33.33 * rem);
			settingsScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			HBox settingsBox = new HBox();
			settingsBox.setAlignment(Pos.TOP_CENTER);
			Text settingstitle = new Text("Settings");
			settingstitle.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 40));
			settingstitle.maxWidth(Double.MAX_VALUE);
			settingstitle.maxHeight(Double.MAX_VALUE);
			settingsBox.getChildren().add(settingstitle);
			settingsPane.setTop(settingsBox);

			VBox settings = new VBox(15);
			settings.setPadding(new Insets(40, 50, 50, 50));
			settings.setAlignment(Pos.TOP_LEFT);
			CheckBox sound = new CheckBox("Use sound");
			sound.setSelected(true);
			CheckBox images = new CheckBox("Use images");
			images.setSelected(true);
			settings.getChildren().addAll(sound, images);
			settingsPane.setCenter(settings);

			HBox bottomBox = new HBox(150);
			bottomBox.setAlignment(Pos.CENTER);

			Button homeBtn = new Button("<-- Back");
			homeBtn.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
			homeBtn.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
			homeBtn.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					primaryStage.setTitle("SMITE Helper | Home");
					primaryStage.setScene(homeScene);
				}
			});
			Text credits = new Text("By: Grim3212");
			credits.setFont(Font.font("Tahoma", FontWeight.THIN, 15));
			credits.setTextAlignment(TextAlignment.CENTER);

			bottomBox.getChildren().addAll(homeBtn, credits);
			settingsPane.setBottom(bottomBox);

			VBox vbBtn = new VBox(15);
			vbBtn.setAlignment(Pos.BASELINE_CENTER);

			Text scenetitle = new Text("SMITE Helper");
			scenetitle.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 40));
			grid.add(scenetitle, 0, 0);

			Button statsBtn = new Button("Stats");
			statsBtn.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
			statsBtn.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
			vbBtn.getChildren().add(statsBtn);

			Button randomizerBtn = new Button("Randomizer");
			randomizerBtn.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
			randomizerBtn.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
			vbBtn.getChildren().add(randomizerBtn);

			Button godInfoBtn = new Button("God Info");
			godInfoBtn.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
			godInfoBtn.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
			vbBtn.getChildren().add(godInfoBtn);

			Button settingsBtn = new Button("Settings");
			settingsBtn.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
			settingsBtn.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
			settingsBtn.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					primaryStage.setTitle("SMITE Helper | Settings");
					primaryStage.setScene(settingsScene);
				}
			});
			vbBtn.getChildren().add(settingsBtn);
			grid.add(vbBtn, 0, 1);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
