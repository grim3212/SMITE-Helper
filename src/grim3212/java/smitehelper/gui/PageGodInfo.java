package grim3212.java.smitehelper.gui;

import grim3212.java.smitehelper.gods.BasicGod;
import grim3212.java.smitehelper.gui.tablestuff.ImageBundle;
import grim3212.java.smitehelper.gui.tablestuff.ImageTableColumnDamageType;
import grim3212.java.smitehelper.gui.tablestuff.ImageTableColumnName;
import grim3212.java.smitehelper.gui.tablestuff.ImageTableColumnPantheon;
import grim3212.java.smitehelper.gui.tablestuff.ImageTableColumnPowerType;
import grim3212.java.smitehelper.gui.tablestuff.ImageTableColumnRole;
import grim3212.java.smitehelper.util.Constants;
import grim3212.java.smitehelper.util.FileUtil;
import grim3212.java.smitehelper.util.GodUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PageGodInfo extends Page {

	public PageGodInfo(Stage primaryStage) {
		super(primaryStage);
	}

	@Override
	public void setupPage(Stage primaryStage) {
		BorderPane statsBorderPane = new BorderPane();
		statsBorderPane.setPadding(new Insets(25, 25, 0, 25));
		Scene statsScene = new Scene(statsBorderPane, 80 * Constants.rem, 50 * Constants.rem);
		statsScene.getStylesheets().add(FileUtil.getResource("resources/stylesheets/godInfo.css"));

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
		TableColumn<BasicGod, ImageBundle> iGodColumn = new ImageTableColumnName();
		TableColumn<BasicGod, ImageBundle> iRoleColumn = new ImageTableColumnRole();
		TableColumn<BasicGod, ImageBundle> iPantheonColumn = new ImageTableColumnPantheon();
		TableColumn<BasicGod, ImageBundle> iPowerTypeColumn = new ImageTableColumnPowerType();
		TableColumn<BasicGod, ImageBundle> damageTypeColumn = new ImageTableColumnDamageType();

		ObservableList<BasicGod> items = FXCollections.observableArrayList(GodUtil.gods);
		final TableView<BasicGod> godTable = new TableView<>(items);
		godTable.getColumns().setAll(iGodColumn, iRoleColumn, iPantheonColumn, iPowerTypeColumn, damageTypeColumn);
		godTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		godTable.getSortOrder().add(iGodColumn);
		// So you can select cells not rows
		godTable.getSelectionModel().setCellSelectionEnabled(true);
		HBox.setHgrow(godTable, Priority.ALWAYS);

		return godTable;
	}

	@Override
	public String getPageName() {
		return Constants.GODINFO_NAME;
	}

}
