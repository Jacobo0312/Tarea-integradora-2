package model;
public class Private extends Playlist{
	
	private String member;


	public Private (String name, String member){
		super(name);
		this.member=member;
	}

	public boolean validateUser(String pName){
		boolean validate=false;
		if (pName.equals(member))
			validate=true;
		else {
			validate=false;
		}
		return validate;
	}




}