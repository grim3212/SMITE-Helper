package grim3212.java.smitehelper.gui.tablestuff;

import grim3212.java.smitehelper.gods.BasicGod;
import grim3212.java.smitehelper.util.FileUtil;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;

public class ImageTableColumnName extends ImageTableColumn {

	public ImageTableColumnName() {
		super("Name");
		setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BasicGod, ImageBundle>, ObservableValue<ImageBundle>>() {
			@Override
			public ObservableValue<ImageBundle> call(TableColumn.CellDataFeatures<BasicGod, ImageBundle> p) {
				return new SimpleObjectProperty<ImageBundle>(new ImageBundle(p.getValue().getName(), FileUtil.getResource(p.getValue().getResources().getString("smallIcon"))));
			}
		});
	}
}
