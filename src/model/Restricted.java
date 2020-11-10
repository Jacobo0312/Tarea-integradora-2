package model;
public class Restricted extends Playlist{

	private String [] members;
	
	public Restricted (String name,String[] members){
		super(name);
		this.members=members;
	}

	public boolean validateUser(String pName){
		boolean validate=false;
		
		for (int i=0;i<5 && !validate;i++){
			if (pName.equals(members[i])){
				validate=true;
			}
			else 
				validate=false;
		}
		return validate;
	}
}