package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import java.io.*;
import java.util.*;

import songObject.Song;

public class Controller
{
	@FXML
	ListView<String> songLibrary;
	
	private ObservableList<String> songList = FXCollections.observableArrayList();
	
	String file = "songfile.txt";
	List<Song> songsFromTextFile = new ArrayList<Song>();
	
	public void start()
	{
		int index = 0;
		
		String line = null;
		Song song = null;
		
		//read from file to populate song list
		try {
			FileReader fileReader = new FileReader(file);
			
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			while((line = bufferedReader.readLine()) != null)
			{
				//break line into name, artist, album and year
				String[] songArgs = line.split(",");
				
				//decide how to initialize song object based on args in the line
				switch (songArgs.length)
				{
				case 2:
					song = new Song(
							songArgs[0], songArgs[1]);
					songsFromTextFile.add(song);
					break;
				case 3:
					song = new Song(
							songArgs[0], songArgs[1], songArgs[2]);
					songsFromTextFile.add(song);
					break;
				case 4:
					song = new Song(
							songArgs[0], songArgs[1], songArgs[2], songArgs[3]);
					songsFromTextFile.add(song);
					break;
				default:
					System.out.println("ERROR");
				}
			}	
			bufferedReader.close();
		}
		catch(FileNotFoundException ex)
		{
			System.out.println("Cannot find '" + file + "'");
		}
		catch(IOException ex)
		{
			System.out.println("Error reading '" + file + "'");
		}
		
		// sort list 
		Collections.sort(songsFromTextFile);
		
		// adding the library of songs to the observable list	
		for (index = 0; index < songsFromTextFile.size(); index++)
		{
			songList.add(songsFromTextFile.get(index).toString());
		}
		
		// display the list in the listView
		songLibrary.setItems(songList);
	}
	
}
