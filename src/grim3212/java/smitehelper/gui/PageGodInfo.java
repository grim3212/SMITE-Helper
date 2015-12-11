package grim3212.java.smitehelper.gui;

import grim3212.java.smitehelper.gods.BasicGod;
import grim3212.java.smitehelper.gui.tablestuff.ImageBundle;
import grim3212.java.smitehelper.gui.tablestuff.ImageTableColumnDamageType;
import grim3212.java.smitehelper.gui.tablestuff.ImageTableColumnName;
import grim3212.java.smitehelper.gui.tablestuff.ImageTableColumnPantheon;
import grim3212.java.smitehelper.gui.tablestuff.ImageTableColumnPowerType;
import grim3212.java.smitehelper.gui.tablestuff.ImageTableColumnRole;
import grim3212.java.smitehelper.util.Constants;
import grim3212.java.smitehelper.util.GodUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class PageGodInfo extends Page {

	@Override
	public void populatePage(BorderPane container, Scene scene) {
		HBox centerBox = new HBox();
		centerBox.setAlignment(Pos.CENTER);
		centerBox.getChildren().add(getGodTable());
		HBox.setHgrow(centerBox, Priority.ALWAYS);
		container.setCenter(centerBox);
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
