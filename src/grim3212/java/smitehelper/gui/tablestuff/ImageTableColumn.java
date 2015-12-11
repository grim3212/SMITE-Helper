package grim3212.java.smitehelper.gui.tablestuff;

import java.util.Comparator;

import grim3212.java.smitehelper.gods.BasicGod;
import javafx.scene.control.TableColumn;

public class ImageTableColumn extends TableColumn<BasicGod, ImageBundle> {

	public ImageTableColumn(String name) {
		super(name);
		setComparator(new Comparator<ImageBundle>() {
			@Override
			public int compare(ImageBundle ib1, ImageBundle ib2) {
				return ib1.getText().compareTo(ib2.getText());
			}
		});
	}
}
