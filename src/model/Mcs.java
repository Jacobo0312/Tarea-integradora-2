package model;
public class Mcs{
	//Constant 
	public final int MAX_USERS=10;
	public final int MAX_SONGS=30;
	public final int MAX_PLAYLIST=20;
	//Attribute
	private User [] users;
	private Song [] pool;
	private Playlist [] playlist;

	//Constructor 
	public Mcs (){
		users = new User [MAX_USERS];
		pool = new Song [MAX_SONGS];
		playlist = new Playlist [MAX_PLAYLIST];
	}

	//Methods
	

/**
	 * find the song we write <br>
	 * <b> pre: we need the songs to have already been created </b> 
	 * @param name song title
	 * @return the song the user is looking for
	 */



public Song findSong (String name){
	Song objSearch=null;
	boolean findSo=false;
	for (int i=0;i<MAX_SONGS && !findSo;i++){
		if (pool[i]!=null && pool[i].getTittle().equalsIgnoreCase(name)){
			objSearch=pool[i];
			findSo=true;	
		}
	}
	return objSearch;
}

		/**
	 * find the user we write <br>
	 * <b> pre: we need users to have already been created </b> 
	 * @param name user nickname
	 * @return the user that user is looking for
	 */




		public User findUser (String name){
			User objSearch=null;
			boolean findUs=false;
			for (int i=0;i<MAX_USERS && !findUs;i++){
				if (users[i]!=null && users[i].getName().equalsIgnoreCase(name)){
					objSearch=users[i];
					findUs=true;	
				}
			}
			return objSearch;
		}


/**
	 * find the playlist we write <br>
	 * <b> pre: we need the playlist to have already been created, (can be; private, public, restricted) </b> 
	 * @param name playlist name
	 * @return the playlist taht user is looking for
	 */


public Playlist findPlaylist(String name){
	Playlist objSearch=null;
	boolean findPl=false;
	for (int i=0;i<MAX_PLAYLIST && !findPl;i++){
		if (playlist[i]!=null && playlist[i].getName().equalsIgnoreCase(name)){
			objSearch=playlist[i];
			findPl=true;
		}
	}
	return objSearch;
}


	/**
	 * add a new user <br>
	 * <b> pre: we need to know the nickname, age, and password of the user </b> 
	 * @param pName user nickname
	 * @param pAge user age
	 * @param pPassword user password
	 * @return a message, if the user could be created or could not be created
	 */

	public String addUser (String pName, String pPassword, int pAge ){
		String message="";
		boolean addUs=false;
		User objSearch=findUser(pName);
		if(objSearch!=null)
			message="Error. the user already exist";
		else{
			for (int i=0;i<MAX_USERS && !addUs;i++){
				if (users[i]==null){
					users[i]=new User (pName,pPassword,pAge);
					addUs=true;
					message="The user has been registered";
				}
			}
			if (addUs==false)
				message="All users are already created";
		}
		return message;
	}

/**
	 * add a new song <br>
	 * <b> pre: we need the information of the song (name, artist, duration, release date and genre)  </b> 
	 * @param pDuration duration of the song
	 * @param pName tittle of the song
	 * @param pAuthor artist song
	 * @param pGenre genre of the song
	 * @param pUser user name

	 * @return a messag, if the song could be created or could not be created
	 */


public String addSong (String pName, String pAuthor, int pDuration, String pGenre,String pUser ){
	User objUser=findUser(pUser);
	
	String message="";
	boolean addSo=false;
	Song objSearch=findSong(pName);
	
	if (objUser == null){
		message="this user does not exist";
	}
	else{
		if(objSearch!=null)
			message="Error. the song already exist";
		else{
			objUser.addCounter();
			for (int i=0;i<MAX_SONGS && !addSo;i++){
				if (pool[i]==null){
					pool[i]=new Song (pName,pAuthor,pDuration,pGenre);
					addSo=true;
					message="The song has been created";
				}
			}
			if (addSo==false)
				message="No more space to add songs";
		}

	}



	
	return message;
}

	/**
	 * add a new public playlist <br>
	 * <b> pre: we need the name of the playlist </b> 
	 * @param tittle playlist name
	 * @return a messag, if the public playlis could be created or could not be created
	 */


	public String addPlaylist (String tittle){
		String message="";
		boolean addPl=false;
		Playlist objSearch=findPlaylist(tittle);
		if(objSearch!=null)
			message="Error. the playlist already exist";
		else{
			for (int i=0;i<MAX_PLAYLIST && !addPl;i++){
				if (playlist[i]==null){
					playlist[i]=new Public (tittle);
					addPl=true;
					message="The playlist has been created";
				}
			}
			if (addPl==false)
				message="No more space to add playlist";
		}
		return message;
	}
	
	/**
	 * add a new private playlist <br>
	 * <b> pre: we need the user nickname and the name of the playlist  </b> 
	 * @param pName user name
	 * @param tittle private playlist name
	 * @return a messag, if the private playlis could be created or could not be created
	 */

	public String addPlaylist (String tittle, String pName){
		String message="";
		boolean addPl=false;
		Playlist objSearch=findPlaylist(tittle);
		if(objSearch!=null)
			message="Error. the playlist already exist";
		else{
			for (int i=0;i<MAX_PLAYLIST && !addPl;i++){
				if (playlist[i]==null){
					playlist[i]=new Private (tittle, pName);
					addPl=true;
					message="The playlist has been created";
				}
			}
			if (addPl==false)
				message="No more space to add playlist";
		}
		return message;
	}

	/**
	 * add a new restricted playlist <br>
	 * <b> pre: we need the playlist name and the name of up to 5 people  </b> 
	 * @param members playlist members
	 * @param tittle restricted playlist name 
	 * @return a messag, if the restricted playlis could be created or could not be created
	 */

	public String addPlaylist (String tittle, String [] members){
		String message="";
		boolean addPl=false;
		Playlist objSearch=findPlaylist(tittle);
		if(objSearch!=null)
			message="Error. the playlist already exist";
		else{
			for (int i=0;i<MAX_PLAYLIST && !addPl;i++){
				if (playlist[i]==null){
					playlist[i]=new Restricted (tittle, members);
					addPl=true;
					message="The playlist has been created";
				}
			}
			if (addPl==false)
				message="No more space to add playlist";
		}
		return message;
	}

	/**
	 * add a song already created to a playlist already created<br>
	 * <b> pre: we need the name of the song already created, the username alredy created and the name of the playlist alredy created </b> 
	 * @param plsylist playlist name
	 * @param nickname user nickname
	 * @param namesong song name
	 * @return a messag, if the song, the playlist or the user has not been created
	 */

	public String addSongtoPlaylist(String playlist, String namesong, String nickname){
		String message="";
		Playlist objSearch=findPlaylist(playlist);
		boolean addSP=false;


		boolean validate= objSearch.validateUser(nickname);
		if (validate==true){
			for (int i=0;i<objSearch.songs_playlist.length && !addSP;i++){
				if (objSearch.songs_playlist[i]==null){
					Song song=findSong(namesong);
					if (song !=null){
						objSearch.songs_playlist[i]=song;
						addSP=true;
						message="Song added successfully";
					}
					else {
						message="the song does not exist";
					}
				}
				if (addSP==false){
					message="No more space in playlist";
				}
			}

		}
		else {
			message=("you don't have access");
		}

		
		return message;

	}



	public String showUsers(int i){
		String message="";
		if(users[i] !=null){
			users[i].updateCategory();
			message=("************* User ************ \n"
				+"** UserName: "+(users[i].getName())+"\n"+
				"** Age: "+(users[i].getAge())+"\n"
				+ "** Category: "+(users[i].getCategory())+"\n"
				+"*******************************");
		}
		return message; 
	}

	public String showPool(){
		String message="";
		for (int i=0;i<MAX_SONGS;i++){
			if(pool[i] !=null){
				message+=pool[i].toString();
			}
		}
		return message; 
	}

	public String showPlaylist(){
		String message="";
		for (int i=0;i<MAX_PLAYLIST;i++){
			if(playlist[i] !=null){
				message+=playlist[i].toString();
			}
		}
		return message; 
	}

	public String addRate(String name, double calification){
		String message="";
		Playlist playlist=findPlaylist(name);
		if (playlist==null){
			message="Don't exist playlist";
		}
		else{
			if (playlist instanceof Public){
				Public public_play =(Public)playlist;
				message=public_play.ratePlaylist(calification);
				
			}
			else
			{
				message="The playlist is not public";
			}
		}
		return message;
	}

}