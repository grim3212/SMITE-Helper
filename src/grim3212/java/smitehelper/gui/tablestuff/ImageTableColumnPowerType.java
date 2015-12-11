package grim3212.java.smitehelper.gui.tablestuff;

import grim3212.java.smitehelper.gods.BasicGod;
import grim3212.java.smitehelper.util.Constants;
import grim3212.java.smitehelper.util.FileUtil;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

public class ImageTableColumnPowerType extends ImageTableColumn {

	public ImageTableColumnPowerType() {
		super("Power Type");
		setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BasicGod, ImageBundle>, ObservableValue<ImageBundle>>() {
			@Override
			public ObservableValue<ImageBundle> call(TableColumn.CellDataFeatures<BasicGod, ImageBundle> p) {
				return new SimpleObjectProperty<ImageBundle>(new ImageBundle(p.getValue().getPowerType(), FileUtil.getResource(Constants.POWERTYPE_ICON_SMALL_LOCATION + p.getValue().getPowerType().toLowerCase() + ".png")));
			}
		});

		setCellFactory(new Callback<TableColumn<BasicGod, ImageBundle>, TableCell<BasicGod, ImageBundle>>() {
			@Override
			public TableCell<BasicGod, ImageBundle> call(TableColumn<BasicGod, ImageBundle> param) {
				TableCell<BasicGod, ImageBundle> cell = new ImageTableCell();

				cell.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						if (event.getClickCount() > 1)
							System.out.println("power type clicked!" + event.getSource());
					}
				});

				return cell;
			}
		});
	}
}
