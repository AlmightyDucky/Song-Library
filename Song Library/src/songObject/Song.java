package songObject;

public class Song implements Comparable<Song>{
	
	private String name;  // holds the name of song
	private String artist; // holds the artist's name
	private String album;  // holds the album's name
	private String year;  // holds the year album was created
	
	public Song(String name, String artist) { // constructor for Song
		
		this(name, artist, "", "");
	}
	
	public Song(String name, String artist,  String album) { // 2nd constructor for Song
		
		this(name, artist, album, "");
	}
	
	public Song(String name, String artist, String album, String year) { // 3rd constructor for Song
		
		this.name = name;
		this.artist = artist;
		this.album = album;
		this.year = year;
	}
	
	public String getName() {  // gets the name of song
		
		return name;
	}
	
	public String getArtist() { // gets the artist's name
		
		return artist;
	}
	
	public String getAlbum() {  // gets the name of album
		
		return album;
	}
	
	public String getYear() {  // gets the year album was created
		
		return year;
	}
	
	public void setName(String songName) {  // sets the name of song
		
		name = songName;
	}
	
	public void setArtist(String artistName) {  // sets the name of artist
		
		artist = artistName;
	}
	
	public void setAlbum(String albumName) {  // sets the name of album
		
		album = albumName;
	}
	
	public void setYear(String year) {  // sets the year album was created 
		
		this.year = year;
	}
	
	// format to store a song inside of a text file
	// name,artist,album,year (ex: Hi,Joe Schmo,The Best Album,2017)
	public String writeToFile()
	{
		if (album == null && year == null)
			return name + "," + artist;
		
		if (year == null)
			return name + "," + artist + "," + album;
		
		if (album == null)
			return name + "," + artist + "," + " " + "," + year;
		
		return name + "," + artist + "," + album + "," + year;
	}
	
	public String toString()
	{
		return name + "," + artist;
	}

	@Override
	public int compareTo(Song other)
	{
		if (name.compareTo(other.name) == 0)
		{
			return artist.compareTo(other.artist);
		}
		
		return name.compareTo(other.name);
	}
	

}
