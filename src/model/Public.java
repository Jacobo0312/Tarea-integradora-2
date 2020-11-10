package model;
public class Public extends Playlist{
	//Attributes
	private double [] ratings;

	public Public (String name){
		super(name);
		ratings = new double[20];
	}

	public String ratePlaylist(double calification){
		String message="";
		boolean add=false;
		for (int i=0;i<ratings.length && !add;i++){
			if (ratings[i] ==0.0d){
				ratings[i]=calification;
				message="added rating";
				add=true;
			}
			
		}
		return message;
	}

	public double promRate(){
		double sum=0,prom=0,cont=0;
		for (int i=0;i<ratings.length;i++){
			if (ratings[i] !=0.0d){
				sum+=ratings[i];
				cont++;
			}
			
		}
		prom=sum/cont;
		return prom;

	}


	public String toString(){
		String message="";
		message=("************* Playlist ************ \n"
			+"** Tittle: "+(super.getName())+"\n"
			+ "** Genre: "+(super.showGenre())+"\n"
			+"** Duration: "+ (super.totalDuration())+"\n"
			+"** Rate: "+ (promRate())+"\n"
			+"***********************************");
		
		return message; 
	}

	


}