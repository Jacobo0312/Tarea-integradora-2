package model;
public class Playlist{

//Constans
	public final int MAX_SONGS_PLAYLIST=10;
 //Attributes
	private String name;
	private int duration;

 //Relations
	
	public Song [] songs_playlist;
	
 //Getters and setters
	public String getName(){
		return name;
	}

	public void setName(String pName){
		name=pName;
	}


	
 //Constructor 
	
/**
	 * constructor method <br>
	 * <b> pre: we need the atributes </b> 
	 * @param name playlist name
	 */

	public Playlist (String name){
		this.name=name;
		this.duration=0;
		songs_playlist = new Song[MAX_SONGS_PLAYLIST];
	}

	//Methods
	public String totalDuration(){
		int total=0;
		for (int i=0;i<MAX_SONGS_PLAYLIST;i++){
			if (songs_playlist[i] !=null){
				total+=songs_playlist[i].getDuration();
			}
		}
		int num=0,hor=0,min=0,seg=0;
		String message="";
		num=total;
		min=num/60;
		seg=num-(min*60);
		
		message=(": "+min+"m "+seg+"s\n");
		return message;
	}


	public String showGenre(){
		String genres="";
		for (int i=0;i<MAX_SONGS_PLAYLIST;i++){
			if (songs_playlist[i] !=null){
				genres+=((songs_playlist[i].getGenre())+("; "));
			}
		}
		return genres;
	}


	public boolean validateUser(String nickname){
		boolean validate=true;
		return validate;
	}

    public String toString (){
    		String message=("\n************* Playlist ************ \n"
				+"** Tittle: "+(name)+"\n"
				+ "** Genre: "+(showGenre())+"\n"
				+"** Duration: "+ (totalDuration())
				+"***********************************");
    		return message;
    }


}