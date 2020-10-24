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

	public String addSong (String pName, String pAuthor, int pDuration, String pGenre,String pUser ){
		User objUser=findUser(pUser);
		objUser.addCounter();
		String message="";
		boolean addSo=false;
		Song objSearch=findSong(pName);
		if(objSearch!=null)
			message="Error. the song already exist";
		else{
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
		return message;
	}

    public String addPlaylist (String pName){
		String message="";
		boolean addPl=false;
		Playlist objSearch=findPlaylist(pName);
		if(objSearch!=null)
			message="Error. the playlist already exist";
		else{
			for (int i=0;i<MAX_PLAYLIST && !addPl;i++){
				if (playlist[i]==null){
					playlist[i]=new Playlist (pName);
					addPl=true;
					message="The playlist has been created";
				}
			}
			if (addPl==false)
				message="No more space to add playlist";
		}
		return message;
	}

	public String addSongtoPlaylist(String playlist, String namesong){
		String message="";
		boolean addSP=false;
		Playlist objSearch=findPlaylist(playlist);
		for (int i=0;i<objSearch.songs_playlist.length && !addSP;i++){
			if (objSearch.songs_playlist[i]==null){
				Song song=findSong(namesong);
				objSearch.songs_playlist[i]=song;
				addSP=true;
				message="Song added successfully";
			}
		}
		if (addSP==false)
			message="No more space in playlist";
		
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

    public String showPool(int i){
     String message="";
              if(pool[i] !=null){
      message=("************* Song ************ \n"
      +"** Tittle: "+(pool[i].getTittle())+"\n"+
      "** Artist: "+(pool[i].getAuthor())+"\n"
      + "** Genre: "+(pool[i].getGenre())+"\n"
      +"** Duration: "+ (pool[i].convertDuration())
      +"*******************************");
     }
     return message; 
  }

    public String showPlaylist(int i){
     String message="";
              if(playlist[i] !=null){
      message=("************* Playlist ************ \n"
      +"** Tittle: "+(playlist[i].getName())+"\n"
      + "** Genre: "+("falta")+"\n"
      +"** Duration: "+ (playlist[i].totalDuration())
      +"***********************************");
     }
     return message; 
  }



}