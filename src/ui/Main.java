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
        "(6) Show playlist \n" +
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
    System.out.println("Enter song tittle");
    String name=lector.nextLine();
    System.out.println("Enter song author");
    String author=lector.nextLine();
    System.out.println("Enter song duration");
    int duration=lector.nextInt();lector.nextLine();
    app.addSong(name,author,duration);
  }


  

 

  }