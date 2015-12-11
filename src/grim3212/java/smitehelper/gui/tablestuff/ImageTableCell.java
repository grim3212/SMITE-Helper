package grim3212.java.smitehelper.gui.tablestuff;

import grim3212.java.smitehelper.gods.BasicGod;
import grim3212.java.smitehelper.gui.PageUtil;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.TextFlow;

public class ImageTableCell extends TableCell<BasicGod, ImageBundle> {

	private HBox hb;
	private ImageView image;
	private TextFlow text;
	private Hyperlink link;

	public ImageTableCell() {
		hb = new HBox();
		image = new ImageView();
		text = new TextFlow();
		link = new Hyperlink();
		text.setPadding(new Insets(0, 0, 0, 5));
		hb.getChildren().addAll(image, text);
		setGraphic(hb);
	}

	@Override
	protected void updateItem(ImageBundle item, boolean empty) {
		if (item != null) {
			if (item.getImageLocation() != null) {
				image.setImage(new Image(item.getImageLocation()));
			}
			link.setText(item.getText());
			link.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					PageUtil.switchPage(item.getText(), true);
					((Hyperlink) event.getTarget()).setVisited(false);
				}
			});
			text.getChildren().clear();
			text.getChildren().add(link);
		}
	}
}