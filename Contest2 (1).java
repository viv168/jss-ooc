import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.File;
import java.util.ArrayList;

public class Contest2 {

	public static void removeSpam(String folder) {

		// Your logic goes here

		ArrayList<String> spam = new ArrayList<>();
		spam.add("Null");
		spam.add("Spam");
		spam.add("Block");

		String content = "";
		File files[] = (new File(folder)).listFiles();

		for(File file: files) {
			try {
				content = Files.readString(Paths.get(file.getAbsolutePath()));
			
				for(String temp: spam)
					content = content.replace(temp, "");
				
				FileWriter fW = new FileWriter(file);
				fW.write(content);
				fW.close();
			} catch(IOException ie) {
				ie.printStackTrace();
			}
		}

	}

	public static void main(String[] args) throws Exception {
		String folder = "C:/notes";

		removeSpam(folder);
	}

}
