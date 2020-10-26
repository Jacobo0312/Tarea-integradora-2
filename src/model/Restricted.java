package model;
public class Restricted extends Playlist{

    private String [] members;
    
	public Restricted (String name,String[] members){
		super(name);
		this.members=members;
	}
}