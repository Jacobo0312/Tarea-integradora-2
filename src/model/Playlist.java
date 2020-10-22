package model;
public class Playlist{

 //Attributes
	private String name;
	private int duration;

 //Relations

 //Getters and setters
	public setName(String pname){
		name=pname;
	}

 //Constructor 
	public Playlist (String name, int duration){
		this.name=name;
		this.duration=duration;
	}


}