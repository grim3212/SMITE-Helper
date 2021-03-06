package grim3212.java.smitehelper.gui;

import java.util.ArrayList;
import java.util.Map;

import grim3212.java.smitehelper.gods.BasicGod;
import grim3212.java.smitehelper.util.Constants;
import grim3212.java.smitehelper.util.EnumGamemodes;
import grim3212.java.smitehelper.util.GodUtil;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.util.Callback;

public class PageStats extends Page {

	@Override
	public void populatePage(BorderPane container, Scene scene) {
		HBox centerBox = new HBox();
		centerBox.setAlignment(Pos.CENTER);
		centerBox.getChildren().addAll(getRoleTable(), getPantheonTable(), getGamemodeTable(), getStatisticsTable());
		HBox.setHgrow(centerBox, Priority.ALWAYS);
		container.setCenter(centerBox);
	}

	@SuppressWarnings("unchecked")
	public TableView<Map.Entry<String, ArrayList<BasicGod>>> getRoleTable() {
		TableColumn<Map.Entry<String, ArrayList<BasicGod>>, String> roleNameColumn = new TableColumn<>("Role");
		roleNameColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<String, ArrayList<BasicGod>>, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(TableColumn.CellDataFeatures<Map.Entry<String, ArrayList<BasicGod>>, String> p) {
				return new SimpleStringProperty(p.getValue().getKey());
			}
		});

		TableColumn<Map.Entry<String, ArrayList<BasicGod>>, String> numGodsColumn = new TableColumn<>("# of Gods");
		numGodsColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<String, ArrayList<BasicGod>>, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(TableColumn.CellDataFeatures<Map.Entry<String, ArrayList<BasicGod>>, String> p) {
				return new SimpleStringProperty(((Integer) p.getValue().getValue().size()).toString());
			}
		});

		ObservableList<Map.Entry<String, ArrayList<BasicGod>>> items = FXCollections.observableArrayList(GodUtil.roles.entrySet());
		final TableView<Map.Entry<String, ArrayList<BasicGod>>> rolesTable = new TableView<>(items);
		rolesTable.getColumns().setAll(roleNameColumn, numGodsColumn);
		rolesTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		rolesTable.getSortOrder().add(roleNameColumn);
		HBox.setHgrow(rolesTable, Priority.ALWAYS);

		return rolesTable;
	}

	@SuppressWarnings("unchecked")
	public TableView<Map.Entry<String, ArrayList<BasicGod>>> getPantheonTable() {
		TableColumn<Map.Entry<String, ArrayList<BasicGod>>, String> pantheonNameColumn = new TableColumn<>("Pantheon");
		pantheonNameColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<String, ArrayList<BasicGod>>, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(TableColumn.CellDataFeatures<Map.Entry<String, ArrayList<BasicGod>>, String> p) {
				return new SimpleStringProperty(p.getValue().getKey());
			}
		});

		TableColumn<Map.Entry<String, ArrayList<BasicGod>>, String> numGodsColumn = new TableColumn<>("# of Gods");
		numGodsColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<String, ArrayList<BasicGod>>, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(TableColumn.CellDataFeatures<Map.Entry<String, ArrayList<BasicGod>>, String> p) {
				return new SimpleStringProperty(((Integer) p.getValue().getValue().size()).toString());
			}
		});

		ObservableList<Map.Entry<String, ArrayList<BasicGod>>> items = FXCollections.observableArrayList(GodUtil.pantheons.entrySet());
		final TableView<Map.Entry<String, ArrayList<BasicGod>>> pantheonTable = new TableView<>(items);
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
		statisticTable.getSortOrder().add(statisticColumn);
		HBox.setHgrow(statisticTable, Priority.ALWAYS);

		return statisticTable;
	}

	@Override
	public String getPageName() {
		return Constants.STATS_NAME;
	}

}
