package model;
public class Mcs{
	//Constant 
	private final int MAX_USERS=20;
	private final int MAX_SONGS=30;
	//Attribute
	private User [] users;
	private Song [] pool;

	//Constructor 
	public Mcs (){
		users = new User [MAX_USERS];
		pool = new Song [MAX_SONGS];
	}

	//Methods
	public Song findSong (String name){
		Song objSearch=null;
		boolean findSo=false;
		for (int i=0;i<MAX_USERS && !findSo;i++){
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
		for (int i=0;i<MAX_SONGS && !findUs;i++){
			if (users[i]!=null && users[i].getName().equalsIgnoreCase(name)){
				objSearch=users[i];
				findUs=true;	
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
			for (int i=0;i<MAX_USERS;i++){
				if (users[i]==null){
					users[i]=new User (pName,pPassword,pAge);
					message="The user has been registered";
				}
			}
			if (addUs==false)
				message="All users are already created";
		}
		return message;
	}

	public String addSong (String pName, String pAuthor, int pDuration ){
		String message="";
		boolean addSo=false;
		Song objSearch=findSong(pName);
		if(objSearch!=null)
			message="Error. the song already exist";
		else{
			for (int i=0;i<MAX_SONGS;i++){
				if (pool[i]==null){
					pool[i]=new Song (pName,pAuthor,pDuration);
					message="The song has been created";
				}
			}
			if (addSo==false)
				message="No more space to add songs";
		}
		return message;
	}

}