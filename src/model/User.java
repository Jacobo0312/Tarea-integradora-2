package model;
public class User{

 //Attributes
	private String name;
	private String password;
	private int age;

 //Relations	
 //Constructor
	public User (String name, String password, int age){
		this.name=name;
		this.password=password;
		this.age=age;
	}

 //Getters and setters

	public String getName (){
		return name;
	}	

	public void setName (String pName){
		name=pName;
	}

	public String getPassword (){
		return password;
	}	

	public void setPassword (String pPassword){
		password=pPassword;
	}

		public int getAge (){
		return age;
	}	

	public void setAge (int pAge){
		age=pAge;
	}


}