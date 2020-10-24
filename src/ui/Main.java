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

  		Main ppal= new Main();

  		int option=0;

  		do{
  			option= ppal.showMenu();
  			ppal.executeOperation(option);

  		}while (option!=0);

  	}

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
  			"(0) Para salir"
  			);
  		option= lector.nextInt();
  		lector.nextLine();
  		return option;
  	}

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
          for (int i=0; i<app.MAX_USERS;i++){
         System.out.println(app.showPool(i)); 
        }
  			break;
        case 5:
        createPlaylist();
        break;
        case 6:
        createSongtoPlaylist();
        break;
        case 7:
        for (int i=0; i<app.MAX_PLAYLIST;i++){
         System.out.println(app.showPlaylist(i)); 
        }
        break;
  			default:
  			System.out.println("Error...");
  		}
  	}


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


  public void createPlaylist(){
    System.out.println("Enter tittle of the playlist");
    String tittle=lector.nextLine();
    app.addPlaylist(tittle);
  }

  public void createSongtoPlaylist(){
    System.out.println("Enter name of the playlist");
    String playlist=lector.nextLine();
    System.out.println("Enter name of the song");
    String song=lector.nextLine();
    String message=app.addSongtoPlaylist(playlist,song);
    System.out.println(message);
   
  }



  }