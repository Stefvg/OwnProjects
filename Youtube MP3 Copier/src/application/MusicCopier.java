package application;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MusicCopier implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent event) {
		List<File> files = getMP3FileNames();
		copyFiles(files);
	}

	
	
	private List<File> getMP3FileNames(){
		String homePath = System.getProperty("user.home");
		File folder = new File(homePath + "/Downloads/");
		File[] listOfFiles = folder.listFiles();
		ArrayList<File> files = new ArrayList<>();
		
		for(File file: listOfFiles) {
			if(file.getName().endsWith(".mp3")) {
				files.add(file);
			}
		}
		return files;
	}
	
	private void copyFiles(List<File> files) {
		String homePath = System.getProperty("user.home");
		String musicPath = homePath + "/Music/iTunes/iTunes Media/Automatisch toevoegen aan iTunes/";
		
		for(File file: files) {
			String endPath = musicPath + file.getName();
			try {
				Files.copy(file.toPath(), new File(endPath).toPath(), StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					Files.delete(file.toPath());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}
	
}
