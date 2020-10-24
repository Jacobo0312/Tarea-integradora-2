package model;
public class User{

 //Attributes
	private String name;
	private String password;
	private int age;
	private int counter;

 //Relations
	private Category category;

 //Constructor
	public User (String name, String password, int age){
		this.name=name;
		this.password=password;
		this.age=age;
		this.category=Category.NEWBIE;
		this.counter=0;
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

	public Category getCategory (){
		return category;
	}

	public int getCounter(){
     return counter;
	}

	public void setCounter(int pCounter){
     counter=pCounter;
	}

	
   //methods

	public void addCounter(){
		counter++;
	}
     

   public void updateCategory(){
    
    if (counter <= 3){}
    else if (counter > 3 && counter <=10){
    	category=Category.LITTLE_CONTRIBUTOR;
    } else {
    	if (counter > 10 && counter <=30)
    	category=Category.MILD_CONTRIBUTOR;
    else
    	category=Category.STAR_CONTRIBUTOR;

   }
}

}