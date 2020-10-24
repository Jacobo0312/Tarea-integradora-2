package model;
public class Mcs{
	//Constant 
	public final int MAX_USERS=10;
	public final int MAX_SONGS=30;
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

}