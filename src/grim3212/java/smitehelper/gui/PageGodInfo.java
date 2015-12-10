package grim3212.java.smitehelper.gui;

import java.io.File;
import java.util.Comparator;

import grim3212.java.smitehelper.gods.BasicGod;
import grim3212.java.smitehelper.util.Constants;
import grim3212.java.smitehelper.util.GodUtil;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

public class PageGodInfo extends Page {

	public PageGodInfo(Stage primaryStage) {
		super(primaryStage);
	}

	@Override
	public void setupPage(Stage primaryStage) {
		BorderPane statsBorderPane = new BorderPane();
		statsBorderPane.setPadding(new Insets(25, 25, 0, 25));
		Scene statsScene = new Scene(statsBorderPane, 80 * Constants.rem, 50 * Constants.rem);
		statsScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		PageUtil.registerPage(this, statsScene);

		HBox titleBox = new HBox();
		titleBox.setAlignment(Pos.TOP_CENTER);
		Text statsTitle = new Text(getPageName());
		statsTitle.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 40));
		statsTitle.maxWidth(Double.MAX_VALUE);
		statsTitle.maxHeight(Double.MAX_VALUE);
		titleBox.getChildren().add(statsTitle);
		statsBorderPane.setTop(titleBox);

		HBox centerBox = new HBox();
		centerBox.setAlignment(Pos.CENTER);
		centerBox.getChildren().add(getGodTable());
		HBox.setHgrow(centerBox, Priority.ALWAYS);
		statsBorderPane.setCenter(centerBox);

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
		statsBorderPane.setBottom(bottomBox);

		// Create a table of basically the spreadsheet that it pulls data from
		// This will then have links and images that end up taking you elsewhere
		// To get more info on things
	}

	@SuppressWarnings("unchecked")
	public TableView<BasicGod> getGodTable() {
		TableColumn<BasicGod, String> roleNameColumn = new TableColumn<>("Name");
		roleNameColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BasicGod, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(TableColumn.CellDataFeatures<BasicGod, String> p) {
				return new SimpleStringProperty(p.getValue().getName());
			}
		});

		TableColumn<BasicGod, String> roleColumn = new TableColumn<>("Role");
		roleColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BasicGod, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(TableColumn.CellDataFeatures<BasicGod, String> p) {
				return new SimpleStringProperty(p.getValue().getRole().name());
			}
		});

		TableColumn<BasicGod, String> powerTypeColumn = new TableColumn<>("Power Type");
		powerTypeColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BasicGod, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(TableColumn.CellDataFeatures<BasicGod, String> p) {
				return new SimpleStringProperty(p.getValue().getPowerType().name());
			}
		});

		TableColumn<BasicGod, ImageBundle> iPowerTypeColumn = new TableColumn<>("Power Type");
		iPowerTypeColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BasicGod, ImageBundle>, ObservableValue<ImageBundle>>() {

			@Override
			public ObservableValue<ImageBundle> call(TableColumn.CellDataFeatures<BasicGod, ImageBundle> p) {
				return new SimpleObjectProperty<ImageBundle>(new ImageBundle(p.getValue().getPowerType().name(), new File("img/" + p.getValue().getPowerType().name().toLowerCase() + "Type.png").toURI().toString()));
			}
		});

		iPowerTypeColumn.setComparator(new Comparator<ImageBundle>() {

			@Override
			public int compare(ImageBundle ib1, ImageBundle ib2) {
				return ib1.getText().compareTo(ib2.getText());
			}

		});

		iPowerTypeColumn.setCellFactory(new Callback<TableColumn<BasicGod, ImageBundle>, TableCell<BasicGod, ImageBundle>>() {

			@Override
			public TableCell<BasicGod, ImageBundle> call(TableColumn<BasicGod, ImageBundle> param) {
				TableCell<BasicGod, ImageBundle> cell = new TableCell<BasicGod, ImageBundle>() {
					@Override
					protected void updateItem(ImageBundle item, boolean empty) {
						if (item != null) {
							HBox hb = new HBox();
							ImageView iv = new ImageView(item.getImageLocation());
							Label powerType = new Label(item.getText());
							hb.getChildren().addAll(iv, powerType);
							setGraphic(hb);
						}
					}
				};
				return cell;
			}
		});

		TableColumn<BasicGod, String> pantheonColumn = new TableColumn<>("Pantheon");
		pantheonColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BasicGod, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(TableColumn.CellDataFeatures<BasicGod, String> p) {
				return new SimpleStringProperty(p.getValue().getPantheon().name());
			}
		});

		TableColumn<BasicGod, String> damageTypeColumn = new TableColumn<>("Damage Type");
		damageTypeColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BasicGod, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(TableColumn.CellDataFeatures<BasicGod, String> p) {
				return new SimpleStringProperty(p.getValue().getDamageType().name());
			}
		});

		ObservableList<BasicGod> items = FXCollections.observableArrayList(GodUtil.gods);
		final TableView<BasicGod> godTable = new TableView<>(items);
		godTable.getColumns().setAll(roleNameColumn, roleColumn, iPowerTypeColumn, pantheonColumn, damageTypeColumn);
		godTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		godTable.getSortOrder().add(roleNameColumn);
		HBox.setHgrow(godTable, Priority.ALWAYS);

		return godTable;
	}

	@Override
	public String getPageName() {
		return Constants.GODINFO_NAME;
	}

}
