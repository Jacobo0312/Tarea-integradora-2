package model;
public class Song{

//Constant

//Attributes
private String tittle;
private String author;
private int duration;

//Relations

//Constructor
public Song (String tittle, String author, int duration){
	this.tittle=tittle;
	this.author=author;
	this.duration=duration;
}

//Getters and setters

 public String getTittle (){
		return tittle;
	}	
 public String getAuthor (){
		return author;
	}
	 public int getDuration (){
		return duration;
	}

}