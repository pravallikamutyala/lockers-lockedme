package com.lockers.lockedme.main;

import java.io.File;
import java.util.Scanner;

public class WelcomePage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("            WELCOME TO LOCKERS PVT. LTD.            ");
		System.out.println("****************************************************");
		System.out.println("------------DEVELOPER: PRAVALLIKA-------------------");
		File theDir = new File("locker");
		if (!theDir.exists()){
		    theDir.mkdir();
		}
		mainMenu();
	}
	
	public static void mainMenu() {
		Scanner sc= new Scanner(System.in);    //System.in is a standard input stream  
		System.out.println("Enter User Option");  
		System.out.print("1-SEARCH"); 
		System.out.print(" 2-BUSINESS OPTIONS");
		System.out.print(" 3-EXIT"); 
		
		int a= sc.nextInt();  
		
		switch(a) {
		  case 1:
			  System.out.print("1---SEARCH"); 
		    break;
		  case 2:
			  System.out.println("Enter Business Option");
			  System.out.print("1---ADD"); 
			  System.out.print(" 2---DELETE");
			  System.out.print(" 3---SEARCH"); 
			  System.out.print(" 4---MAIN MENU"); 
			  int b_opt = sc.nextInt();
			  switch(b_opt) {
			  case 1:
				  System.out.print("1---ADD FILE"); 
			    break;
			  case 2:
				  System.out.println("DELETE FILE");
				  break;
			  case 3:
				  System.out.print("SEARCH FILE"); 
			    break;
			  case 4:
				  System.out.println("MAIN MENU");
				  mainMenu();
				  break;
			//default:
			    //continue;
			}
		    break;
		  case 3:
			  System.out.print("EXIT"); 
		    break;
		   default:
			   System.out.println("NOT A VALID OPTION");
			   mainMenu();
			   break;
		}
		sc.close();
		
	}
	
	public static void addFile() {
		
		System.out.println("Enter the path where you want to create a folder: ");  
	      Scanner sc = new Scanner(System.in);  
	      String path = sc.next();  
	      //Using Scanner class to get the folder name from the user  
	      System.out.println("Enter the name of the desired a directory: ");  
	      path = path+sc.next();  
	      //Instantiate the File class   
	      File f1 = new File(path);  
	      //Creating a folder using mkdir() method  
	      boolean bool = f1.mkdir();  
	      if(bool){  
	         System.out.println("Folder is created successfully");  
	      }else{  
	         System.out.println("Error Found!");  
	      }   
		
	}
	

}
