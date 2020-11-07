/**
 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * A00368502
 * Universidad Icesi (Cali-Colombia)
 * @Author: Jacobo Garcia
 * @Date: 20 octube 2020
 *
  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  */

  package ui;
  import java.util.Scanner;
  import model.Mcs;
  public class Main{

  //Relations 
  	private Mcs app;
  	private Scanner lector;



  	public Main(){
  		lector=new Scanner(System.in);
      app= new Mcs();
    }
    public static void main(String [] args) {

      System.out.println("Starting...");
      System.out.println("\n(((((((((((((((((((((((((((((((((((((((((((((((((\n"+
"((((((((((((((((/((((((((((((((((((((((((((((((((\n"+
"(((/  .(((((((*  .((((((*        (((((/      /(((\n"+
"(((/   .((((((.  .(((((   ,((((((((((*  .((((((((\n"+
"(((/    /((((/   .((((/  ,(((((((((((.  /((((((((\n"+
"(((/     ((((*   .((((*  ,(((((((((((/   ((((((((\n"+
"(((/  *  *(((     ((((*  ,((((((((((((,  .(((((((\n"+
"(((/  /.  ((*     ((((*  *(((((((((((((,   ((((((\n"+
"(((/  //  ,(  .   ((((*  *((((((((((((((/   /((((\n"+
"(((/  *(*  ,  (   ((((*  *((((((((((((((((   /(((\n"+
"(((/  ,(/    ,(   /(((*  ,(((((((((((((((((   (((\n"+
"(((/  .((    ((   /((((  .(((((((((((((((((.  /((\n"+
"(((/  .((.  .((.  *((((,  *((((((((((((((((   /((\n"+
"(((/  .((((((((.  *(((((   *((((/,/(((((((/   (((\n"+
"(((/  .((((((((.  *((((((.        *((   .   .((((\n"+
"(((((((((((((((/*/((((((((((///(((((((////(((((((\n"+
"(((((((((((((((((((((((((((((((((((((((((((((((((\n"+              
     
"*************************************************");

      Main ppal= new Main();

      int option=0;

      do{
       option= ppal.showMenu();
       ppal.executeOperation(option);

     }while (option!=0);

   }

   /**
   * prints on screen the options to use the application <br>
   * <b> pre: we need the user to choose what action to perform </b> 
   * @param option menu option
   * @return the number chosen by the user
   */


    

   public int showMenu() {
    int option=0;

    System.out.println(
     "Select an option\n" +
     "(1) Sign up\n" +
     "(2) Show users \n"+
     "(3) Add song to pool  \n"+
     "(4) Show pool songs \n"+ 
     "(5) Create playlist \n"+
     "(6) add songs to playlist \n"+
     "(7) Show playlist \n" +
     "(8) Rate playlist \n" +
     "(0) Para salir"
     );
    option= lector.nextInt();
    lector.nextLine();
    return option;
  }

 
/**
   * depending on the option chosen, the program performs an option <br>
   * <b> pre: we need the value of the option variable </b> 
   * @param operation menu option
   * 
   */





  public void executeOperation(int operation) {
    
    switch(operation) {
     case 0:
     System.out.println("Bye!");
     break;
     case 1:
     createUser() ;
     break;
     case 2:
     for (int i=0; i<app.MAX_USERS;i++){
       System.out.println(app.showUsers(i)); 
     }
     break;
     case 3:
     createSong();
     break;
     case 4:
   System.out.println(app.showPool()); 
     break;
     case 5:
     createPlaylist();
     break;
     case 6:
     createSongtoPlaylist();
     break;
     case 7:
     System.out.println(app.showPlaylist()); 
     break;
      case 8:
     ratePlaylist();
     break;
     default:
     System.out.println("Error...");
   }
 }


  /**
   * asks the user for the information of the user to be registered <br>
   * <b> pre: we need the value of the option variable </b> 
   * @param name user nickname
   * @param password user password
   * @param age user age
   */




 public void createUser(){

   System.out.println("Enter your nickname");
   String name=lector.nextLine();
   System.out.println("Enter your password");
   String password=lector.nextLine();
   System.out.println("Enter you age");
   int age=lector.nextInt();
   String message=app.addUser(name,password,age);
   System.out.println(message);


 }



/**
   * asks the user for the information of the song to be registered <br>
   * <b> pre: we need the value of the option variable </b> 
   * @param name song name
   * @param author song artist
   * @param genre song gnre 
   * @param duration song duration
   * @param user name user
   */
 public void createSong(){
  System.out.println("Enter your nickname");
  String user=lector.nextLine();
  System.out.println("Enter song tittle");
  String name=lector.nextLine();
  System.out.println("Enter song author");
  String author=lector.nextLine();
  System.out.println("Enter song duration in seconds");
  int duration=lector.nextInt();lector.nextLine();
  System.out.println("Enter song genre: ROCK, HIPHOP, CLASSIC, REGGAE, SALSA, METAL");
  String genre=lector.nextLine().toUpperCase();
  String message=app.addSong(name,author,duration,genre,user);
  System.out.println(message);
}


  /**
   * asks the user for the information of the user to be registered <br>
   * <b> pre: we need the value of the option variable </b> 
   * @param member playlist private users
   * @param tittle playlist name
   * @param members playlist restricted user
   * 
   */
public void createPlaylist(){
  System.out.println("Enter tittle of the playlist");
  String tittle=lector.nextLine();
  System.out.println("enter 1 to create private, 2 for public and 3 for restricted");
  int option=lector.nextInt();lector.nextLine();
  switch(option) {
    case 1:
    System.out.println("Enter your nickname");
    String member=lector.nextLine();
    String message=app.addPlaylist(tittle,member);
    System.out.println(message);
    break;
    case 2:
    message=app.addPlaylist(tittle);
    System.out.println(message);
    break;
    case 3:
    System.out.println("Enter members nicknames");
    String [] members=new String [5];
    for(int i=0;i<5;i++){
      System.out.println((i+1)+": Member");
      members[i]=lector.nextLine();
    }
    message=app.addPlaylist(tittle,members);
    System.out.println(message);
    break;
    default:
    System.out.println("Error");
    break;
  }

}


/**
   * ask for the song information and add it to a playlist <br>
   * <b> pre: we need the value of the option variable </b> 
   * @param playlist playlist name
   * @param nickname user nickname(private and restricted)
   * @param song song name
   * @param message right or wrong message
   */


public void createSongtoPlaylist(){
  System.out.println("Enter name of the playlist");
  String playlist=lector.nextLine();
  System.out.println("Enter your nickname");
  String nickname=lector.nextLine();
  System.out.println("Enter name of the song");
  String song=lector.nextLine();
  String message=app.addSongtoPlaylist(playlist,song,nickname);
  System.out.println(message);

}


/**
   * request the rating of any public playlist and add it <br>
   * <b> pre: existence of the public playlist </b>
   * @param playlist playlist name
   * @param calification playlist rating
   */

public void ratePlaylist(){
  System.out.println("Enter name of the playlist");
  String playlist=lector.nextLine();
  System.out.println("Enter the rate");
 double calification=lector.nextInt();lector.nextLine();
 while (calification>5){
  System.out.println("enter a rate less than or equal to 5");
  calification=lector.nextInt();lector.nextLine();
 } 
  String message=app.addRate(playlist,calification);
  System.out.println(message);
}



}