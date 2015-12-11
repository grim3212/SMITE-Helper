package grim3212.java.smitehelper.gui.tablestuff;

import grim3212.java.smitehelper.gods.BasicGod;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class ImageTableCell extends TableCell<BasicGod, ImageBundle> {

	private HBox hb;
	private ImageView image;
	private Label godName;

	public ImageTableCell() {
		hb = new HBox();
		image = new ImageView();
		godName = new Label();
		godName.setPadding(new Insets(0, 0, 0, 5));
		hb.getChildren().addAll(image, godName);
		setGraphic(hb);
	}

	@Override
	protected void updateItem(ImageBundle item, boolean empty) {
		if (item != null) {
			if (item.getImageLocation() != null) {
				image.setImage(new Image(item.getImageLocation()));
				godName.setText(item.getText());
			} else {
				godName.setText(item.getText());
			}
		}
	}
}