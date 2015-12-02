package grim3212.java.smitehelper.gui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import grim3212.java.smitehelper.gods.BasicGod;
import grim3212.java.smitehelper.gods.EnumDamageType;
import grim3212.java.smitehelper.gods.EnumPantheon;
import grim3212.java.smitehelper.gods.EnumPowerType;
import grim3212.java.smitehelper.gods.EnumRole;
import grim3212.java.smitehelper.util.Constants;
import grim3212.java.smitehelper.util.EnumGamemodes;
import grim3212.java.smitehelper.util.GodUtil;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

public class PageStats extends Page {

	public PageStats(Stage primaryStage) {
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

		HBox centerBox = new HBox(2);
		centerBox.setAlignment(Pos.CENTER);
		centerBox.getChildren().addAll(getRoleTable(), getPantheonTable(), getGamemodeTable(), getTypeTable(), getStatisticsTable());
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
	}

	@SuppressWarnings("unchecked")
	public TableView<Map.Entry<EnumRole, ArrayList<BasicGod>>> getRoleTable() {
		TableColumn<Map.Entry<EnumRole, ArrayList<BasicGod>>, String> roleNameColumn = new TableColumn<>("Role");
		roleNameColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<EnumRole, ArrayList<BasicGod>>, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(TableColumn.CellDataFeatures<Map.Entry<EnumRole, ArrayList<BasicGod>>, String> p) {
				return new SimpleStringProperty(p.getValue().getKey().name());
			}
		});

		TableColumn<Map.Entry<EnumRole, ArrayList<BasicGod>>, String> numGodsColumn = new TableColumn<>("# of Gods");
		numGodsColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<EnumRole, ArrayList<BasicGod>>, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(TableColumn.CellDataFeatures<Map.Entry<EnumRole, ArrayList<BasicGod>>, String> p) {
				return new SimpleStringProperty(((Integer) p.getValue().getValue().size()).toString());
			}
		});

		ObservableList<Map.Entry<EnumRole, ArrayList<BasicGod>>> items = FXCollections.observableArrayList(GodUtil.roles.entrySet());
		final TableView<Map.Entry<EnumRole, ArrayList<BasicGod>>> rolesTable = new TableView<>(items);
		rolesTable.getColumns().setAll(roleNameColumn, numGodsColumn);
		rolesTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		rolesTable.getSortOrder().add(roleNameColumn);
		HBox.setHgrow(rolesTable, Priority.ALWAYS);

		return rolesTable;
	}

	@SuppressWarnings("unchecked")
	public TableView<Map.Entry<EnumPantheon, ArrayList<BasicGod>>> getPantheonTable() {
		TableColumn<Map.Entry<EnumPantheon, ArrayList<BasicGod>>, String> pantheonNameColumn = new TableColumn<>("Pantheon");
		pantheonNameColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<EnumPantheon, ArrayList<BasicGod>>, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(TableColumn.CellDataFeatures<Map.Entry<EnumPantheon, ArrayList<BasicGod>>, String> p) {
				return new SimpleStringProperty(p.getValue().getKey().name());
			}
		});

		TableColumn<Map.Entry<EnumPantheon, ArrayList<BasicGod>>, String> numGodsColumn = new TableColumn<>("# of Gods");
		numGodsColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<EnumPantheon, ArrayList<BasicGod>>, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(TableColumn.CellDataFeatures<Map.Entry<EnumPantheon, ArrayList<BasicGod>>, String> p) {
				return new SimpleStringProperty(((Integer) p.getValue().getValue().size()).toString());
			}
		});

		ObservableList<Map.Entry<EnumPantheon, ArrayList<BasicGod>>> items = FXCollections.observableArrayList(GodUtil.pantheons.entrySet());
		final TableView<Map.Entry<EnumPantheon, ArrayList<BasicGod>>> pantheonTable = new TableView<>(items);
		pantheonTable.getColumns().setAll(pantheonNameColumn, numGodsColumn);
		pantheonTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		pantheonTable.getSortOrder().add(pantheonNameColumn);
		HBox.setHgrow(pantheonTable, Priority.ALWAYS);

		return pantheonTable;
	}

	@SuppressWarnings("unchecked")
	public TableView<EnumGamemodes> getGamemodeTable() {
		TableColumn<EnumGamemodes, String> gamemodeColumn = new TableColumn<>("Gamemodes");
		gamemodeColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<EnumGamemodes, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(TableColumn.CellDataFeatures<EnumGamemodes, String> p) {
				return new SimpleStringProperty(p.getValue().name());
			}
		});

		ObservableList<EnumGamemodes> items = FXCollections.observableArrayList(EnumGamemodes.values());
		final TableView<EnumGamemodes> gamemodeTable = new TableView<>(items);
		gamemodeTable.getColumns().setAll(gamemodeColumn);
		gamemodeTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		gamemodeTable.getSortOrder().add(gamemodeColumn);
		HBox.setHgrow(gamemodeTable, Priority.ALWAYS);

		return gamemodeTable;
	}

	@SuppressWarnings("unchecked")
	public TableView<Entry<? extends Enum<?>, ArrayList<BasicGod>>> getTypeTable() {
		TableColumn<Entry<? extends Enum<?>, ArrayList<BasicGod>>, String> damageColumn = new TableColumn<>("Damage Type");
		TableColumn<Entry<? extends Enum<?>, ArrayList<BasicGod>>, String> powerColumn = new TableColumn<>("Power Type");

		TableColumn<Entry<? extends Enum<?>, ArrayList<BasicGod>>, String> damageTypeColumn = new TableColumn<>("Type");
		damageTypeColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Entry<? extends Enum<?>, ArrayList<BasicGod>>, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(TableColumn.CellDataFeatures<Entry<? extends Enum<?>, ArrayList<BasicGod>>, String> p) {
				if (p.getValue().getKey() instanceof EnumDamageType) {
					return new SimpleStringProperty(p.getValue().getKey().name());
				} else {
					return new SimpleStringProperty("");
				}
			}
		});

		TableColumn<Entry<? extends Enum<?>, ArrayList<BasicGod>>, String> amountColumn = new TableColumn<>("Amount");
		amountColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Entry<? extends Enum<?>, ArrayList<BasicGod>>, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(TableColumn.CellDataFeatures<Entry<? extends Enum<?>, ArrayList<BasicGod>>, String> p) {
				if (p.getValue().getKey() instanceof EnumDamageType) {
					return new SimpleStringProperty(((Integer) p.getValue().getValue().size()).toString());
				} else {
					return new SimpleStringProperty("");
				}
			}
		});

		damageColumn.getColumns().addAll(damageTypeColumn, amountColumn);

		TableColumn<Entry<? extends Enum<?>, ArrayList<BasicGod>>, String> powerTypeColumn = new TableColumn<>("Type");
		powerTypeColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Entry<? extends Enum<?>, ArrayList<BasicGod>>, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(TableColumn.CellDataFeatures<Entry<? extends Enum<?>, ArrayList<BasicGod>>, String> p) {
				if (p.getValue().getKey() instanceof EnumPowerType) {
					return new SimpleStringProperty(p.getValue().getKey().name());
				} else {
					return new SimpleStringProperty("");
				}
			}
		});

		TableColumn<Entry<? extends Enum<?>, ArrayList<BasicGod>>, String> powerTypeAmountColumn = new TableColumn<>("Amount");
		powerTypeAmountColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Entry<? extends Enum<?>, ArrayList<BasicGod>>, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(TableColumn.CellDataFeatures<Entry<? extends Enum<?>, ArrayList<BasicGod>>, String> p) {
				if (p.getValue().getKey() instanceof EnumPowerType) {
					return new SimpleStringProperty(((Integer) p.getValue().getValue().size()).toString());
				} else {
					return null;
				}
			}
		});

		powerColumn.getColumns().addAll(powerTypeColumn, powerTypeAmountColumn);

		ArrayList<Map.Entry<? extends Enum<?>, ArrayList<BasicGod>>> list = new ArrayList<>();
		list.addAll(GodUtil.damageTypes.entrySet());
		list.addAll(GodUtil.powerTypes.entrySet());

		ObservableList<Map.Entry<? extends Enum<?>, ArrayList<BasicGod>>> data = FXCollections.observableArrayList(list);

		final TableView<Entry<? extends Enum<?>, ArrayList<BasicGod>>> statisticTable = new TableView<>();
		statisticTable.getColumns().setAll(damageColumn, powerColumn);
		statisticTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		HBox.setHgrow(statisticTable, Priority.ALWAYS);

		return statisticTable;
	}

	@SuppressWarnings("unchecked")
	public TableView<Map.Entry<String, Integer>> getStatisticsTable() {
		TableColumn<Map.Entry<String, Integer>, String> statisticColumn = new TableColumn<>("Statistic");
		statisticColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<String, Integer>, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(TableColumn.CellDataFeatures<Map.Entry<String, Integer>, String> p) {
				return new SimpleStringProperty(p.getValue().getKey());
			}
		});

		TableColumn<Map.Entry<String, Integer>, String> amountColumn = new TableColumn<>("Amount");
		amountColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<String, Integer>, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(TableColumn.CellDataFeatures<Map.Entry<String, Integer>, String> p) {
				return new SimpleStringProperty(((Integer) p.getValue().getValue()).toString());
			}
		});

		ObservableList<Map.Entry<String, Integer>> items = FXCollections.observableArrayList(GodUtil.statistics.entrySet());
		final TableView<Map.Entry<String, Integer>> statisticTable = new TableView<>(items);
		statisticTable.getColumns().setAll(statisticColumn, amountColumn);
		statisticTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		statisticTable.getSortOrder().add(amountColumn);
		HBox.setHgrow(statisticTable, Priority.ALWAYS);

		return statisticTable;
	}

	@Override
	public String getPageName() {
		return Constants.STATS_NAME;
	}

}
