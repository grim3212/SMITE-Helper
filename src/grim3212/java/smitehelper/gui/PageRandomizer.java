package grim3212.java.smitehelper.gui;

import java.util.Iterator;
import java.util.Random;

import grim3212.java.smitehelper.util.Constants;
import grim3212.java.smitehelper.util.EnumGamemodes;
import grim3212.java.smitehelper.util.GodUtil;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PageRandomizer extends Page {

	private Random rand;

	public PageRandomizer(Stage primaryStage) {
		super(primaryStage);
		rand = new Random();
	}

	@Override
	public void setupPage(Stage primaryStage) {
		BorderPane randBorderPane = new BorderPane();
		randBorderPane.setPadding(new Insets(25, 25, 0, 25));
		Scene randScene = new Scene(randBorderPane, 80 * Constants.rem, 50 * Constants.rem);
		randScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		PageUtil.registerPage(this, randScene);

		HBox titleBox = new HBox();
		titleBox.setAlignment(Pos.TOP_CENTER);
		Text randomizerTitle = new Text(getPageName());
		randomizerTitle.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 40));
		randomizerTitle.maxWidth(Double.MAX_VALUE);
		randomizerTitle.maxHeight(Double.MAX_VALUE);
		titleBox.getChildren().add(randomizerTitle);
		randBorderPane.setTop(titleBox);

		BorderPane randCenter = new BorderPane();
		randCenter.setPadding(new Insets(45, 25, 25, 25));

		Text currentSelection = new Text("No current selection");
		currentSelection.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 40));
		currentSelection.maxWidth(Double.MAX_VALUE);
		currentSelection.maxHeight(Double.MAX_VALUE);
		randCenter.setTop(currentSelection);

		TabPane tabs = new TabPane();
		setupAllGodsPane(tabs, currentSelection);
		setupRolePane(tabs, currentSelection);
		setupPantheonPane(tabs, currentSelection);
		setupDamageTypePane(tabs, currentSelection);
		setupPowerTypePane(tabs, currentSelection);
		setupGamemodePane(tabs, currentSelection);

		randCenter.setCenter(tabs);

		randBorderPane.setCenter(randCenter);

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
				PageUtil.switchPage(Constants.HOME_NAME, primaryStage);
			}
		});
		HBox.setHgrow(homeBtn, Priority.ALWAYS);

		bottomBox.getChildren().addAll(homeBtn);
		randBorderPane.setBottom(bottomBox);
	}

	@Override
	public String getPageName() {
		return Constants.RANDOMIZER_NAME;
	}

	public void setupAllGodsPane(TabPane tabPane, Text currentSelection) {
		Tab allGods = new Tab();
		allGods.setText("Randomize (All Gods)");

		VBox container = new VBox();
		container.setAlignment(Pos.CENTER);

		Button randomizeBtn = new Button("Randomize");
		randomizeBtn.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		randomizeBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				int godNum = rand.nextInt(GodUtil.gods.size());
				currentSelection.setText("God Selected: " + GodUtil.gods.get(godNum).getName());
			}
		});

		container.getChildren().addAll(randomizeBtn);

		allGods.setContent(container);
		tabPane.getTabs().add(allGods);
	}

	public void setupRolePane(TabPane tabPane, Text currentSelection) {
		Tab roleTab = new Tab();
		roleTab.setText("Randomize (Role)");

		HBox container = new HBox(150);
		container.setAlignment(Pos.CENTER);

		VBox roles = new VBox(10);
		roles.setAlignment(Pos.CENTER_LEFT);
		ToggleGroup roleGroup = new ToggleGroup();

		Iterator<String> itr = GodUtil.roles.keySet().iterator();
		while (itr.hasNext()) {
			String key = itr.next();

			RadioButton radioBtn = new RadioButton(key);
			radioBtn.setToggleGroup(roleGroup);
			radioBtn.setUserData(key);
			roles.getChildren().add(radioBtn);
		}

		Button randomizeBtn = new Button("Randomize");
		randomizeBtn.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		randomizeBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				if (roleGroup.getSelectedToggle() != null) {
					int godNum = rand.nextInt(GodUtil.roles.get(roleGroup.getSelectedToggle().getUserData()).size());
					currentSelection.setText("God Selected: " + GodUtil.roles.get(roleGroup.getSelectedToggle().getUserData()).get(godNum).getName());
				} else {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("God Randomizer | By Role");
					alert.setHeaderText("No role selected!");
					alert.setContentText("Please select a role from the left side and then click randomize");

					alert.showAndWait();
				}
			}
		});

		container.getChildren().addAll(roles, randomizeBtn);

		roleTab.setContent(container);
		tabPane.getTabs().add(roleTab);
	}

	public void setupPantheonPane(TabPane tabPane, Text currentSelection) {
		Tab pantheonTab = new Tab();
		pantheonTab.setText("Randomize (Pantheon)");

		HBox container = new HBox(150);
		container.setAlignment(Pos.CENTER);

		VBox pantheons = new VBox(10);
		pantheons.setAlignment(Pos.CENTER_LEFT);
		ToggleGroup pantheonGroup = new ToggleGroup();

		Iterator<String> itr = GodUtil.pantheons.keySet().iterator();
		while (itr.hasNext()) {
			String key = itr.next();

			RadioButton radioBtn = new RadioButton(key);
			radioBtn.setToggleGroup(pantheonGroup);
			radioBtn.setUserData(key);
			pantheons.getChildren().add(radioBtn);
		}

		Button randomizeBtn = new Button("Randomize");
		randomizeBtn.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		randomizeBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				if (pantheonGroup.getSelectedToggle() != null) {
					int godNum = rand.nextInt(GodUtil.pantheons.get(pantheonGroup.getSelectedToggle().getUserData()).size());
					currentSelection.setText("God Selected: " + GodUtil.pantheons.get(pantheonGroup.getSelectedToggle().getUserData()).get(godNum).getName());
				} else {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("God Randomizer | By Pantheon");
					alert.setHeaderText("No pantheon selected!");
					alert.setContentText("Please select a pantheon from the left side and then click randomize");

					alert.showAndWait();
				}
			}
		});

		container.getChildren().addAll(pantheons, randomizeBtn);

		pantheonTab.setContent(container);
		tabPane.getTabs().add(pantheonTab);
	}

	public void setupDamageTypePane(TabPane tabPane, Text currentSelection) {
		Tab damageTypeTab = new Tab();
		damageTypeTab.setText("Randomize (Damage Type)");

		HBox container = new HBox(150);
		container.setAlignment(Pos.CENTER);

		VBox damageTypes = new VBox(10);
		damageTypes.setAlignment(Pos.CENTER_LEFT);
		ToggleGroup damageGroup = new ToggleGroup();

		Iterator<String> itr = GodUtil.damageTypes.keySet().iterator();
		while (itr.hasNext()) {
			String key = itr.next();

			RadioButton radioBtn = new RadioButton(key);
			radioBtn.setToggleGroup(damageGroup);
			radioBtn.setUserData(key);
			damageTypes.getChildren().add(radioBtn);
		}

		Button randomizeBtn = new Button("Randomize");
		randomizeBtn.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		randomizeBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				if (damageGroup.getSelectedToggle() != null) {
					int godNum = rand.nextInt(GodUtil.damageTypes.get(damageGroup.getSelectedToggle().getUserData()).size());
					currentSelection.setText("God Selected: " + GodUtil.damageTypes.get(damageGroup.getSelectedToggle().getUserData()).get(godNum).getName());
				} else {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("God Randomizer | By Damage Type");
					alert.setHeaderText("No damage type selected!");
					alert.setContentText("Please select a damage type from the left side and then click randomize");

					alert.showAndWait();
				}
			}
		});

		container.getChildren().addAll(damageTypes, randomizeBtn);

		damageTypeTab.setContent(container);
		tabPane.getTabs().add(damageTypeTab);
	}

	public void setupPowerTypePane(TabPane tabPane, Text currentSelection) {
		Tab powerTypeTab = new Tab();
		powerTypeTab.setText("Randomize (Power Type)");

		HBox container = new HBox(150);
		container.setAlignment(Pos.CENTER);

		VBox powerTypes = new VBox(10);
		powerTypes.setAlignment(Pos.CENTER_LEFT);
		ToggleGroup powerGroup = new ToggleGroup();

		Iterator<String> itr = GodUtil.powerTypes.keySet().iterator();
		while (itr.hasNext()) {
			String key = itr.next();

			RadioButton radioBtn = new RadioButton(key);
			radioBtn.setToggleGroup(powerGroup);
			radioBtn.setUserData(key);
			powerTypes.getChildren().add(radioBtn);
		}

		Button randomizeBtn = new Button("Randomize");
		randomizeBtn.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		randomizeBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				if (powerGroup.getSelectedToggle() != null) {
					int godNum = rand.nextInt(GodUtil.powerTypes.get(powerGroup.getSelectedToggle().getUserData()).size());
					currentSelection.setText("God Selected: " + GodUtil.powerTypes.get(powerGroup.getSelectedToggle().getUserData()).get(godNum).getName());
				} else {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("God Randomizer | By Power Type");
					alert.setHeaderText("No power type selected!");
					alert.setContentText("Please select a power type from the left side and then click randomize");

					alert.showAndWait();
				}
			}
		});

		container.getChildren().addAll(powerTypes, randomizeBtn);

		powerTypeTab.setContent(container);
		tabPane.getTabs().add(powerTypeTab);
	}

	public void setupGamemodePane(TabPane tabPane, Text currentSelection) {
		Tab gamemodeTab = new Tab();
		gamemodeTab.setText("Randomize (Gamemode)");

		HBox container = new HBox(150);
		container.setAlignment(Pos.CENTER);

		Button randomizeBtn = new Button("Randomize");
		randomizeBtn.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		randomizeBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				int gamemode = rand.nextInt(EnumGamemodes.values().length);
				currentSelection.setText("Gamemode Selected: " + EnumGamemodes.values()[gamemode]);
			}
		});

		container.getChildren().addAll(randomizeBtn);

		gamemodeTab.setContent(container);
		tabPane.getTabs().add(gamemodeTab);
	}
}
