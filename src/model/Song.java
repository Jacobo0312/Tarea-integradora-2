package model;
public class Song{

//Constant

//Attributes
private String tittle;
private String author;
private int duration;


//Relations
private Genre genre;

//Constructor
public Song (String tittle, String author, int duration, String genre){
	this.tittle=tittle;
	this.author=author;
	this.duration=duration;
	this.genre=Genre.valueOf(genre);
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

	public Genre getGenre(){
		return genre;
	}

	//methods

	public String convertDuration(){
		    int num=0,hor=0,min=0,seg=0;
        String message="";
        num=duration;
        min=num/60;
        seg=num-(min*60);
    
    message=(": "+min+"m "+seg+"s\n");
    return message;
	}



	public String toString(){
		String message="";
		message=("\n************* Song ************ \n"
				+"** Tittle: "+tittle+"\n"+
				"** Artist: "+author+"\n"
				+ "** Genre: "+genre+"\n"
				+"** Duration: "+ (convertDuration())
				+"*******************************");
		return message;
	}



}