package grim3212.java.smitehelper.gui;

public class ImageBundle {

	private String text;
	private String imageLocation;

	public ImageBundle(String text, String imageLocation) {
		this.text = text;
		this.imageLocation = imageLocation;
	}

	public String getText() {
		return text;
	}

	public String getImageLocation() {
		return imageLocation;
	}
}
