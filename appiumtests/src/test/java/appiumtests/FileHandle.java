package appiumtests;

import java.io.InputStream;

public class FileHandle {
	public static InputStream inputStreamFromFile(String path) {
		try {
			InputStream inputstream = FileHandle.class.getResourceAsStream(path);
			return inputstream;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
