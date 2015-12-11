package grim3212.java.smitehelper.util;

import java.io.File;

public class FileUtil {

	public static String getResource(String toConvert) {
		return new File(toConvert).toURI().toString();
	}

}
