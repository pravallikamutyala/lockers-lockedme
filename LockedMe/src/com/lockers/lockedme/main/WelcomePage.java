package com.lockers.lockedme.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeSet;

public class WelcomePage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("            WELCOME TO LOCKERS PVT. LTD.            ");
		System.out.println("****************************************************");
		System.out.println("---------------PROJECT:LOCKED ME--------------------");
		System.out.println("****************************************************");
		System.out.println("--------------DEVELOPER: PRAVALLIKA-----------------");
		File theDir = new File("locker");
		if (!theDir.exists()) {
			theDir.mkdir();
		}
		new WelcomePage().mainMenu();
	}

	public void mainMenu() {
		
		Scanner sc = new Scanner(System.in); // System.in is a standard input stream
		System.out.println("--------------MAIN MENU-----------------");
		System.out.println("Enter User Option");
		System.out.print("1-LIST FILES");
		System.out.print(" 2-BUSINESS OPTIONS");
		System.out.print(" 3-EXIT  \n");
		
		
		try {
			int a = sc.nextInt();
			switch (a) {
			case 1:
				System.out.println("1---LIST DIRECTORY");
				new ListFiles().listFiles();
				mainMenu();
				break;
			case 2:
				System.out.println("Enter Business Option");
				System.out.print(" 1---ADD");
				System.out.print(" 2---DELETE");
				System.out.print(" 3---SEARCH");
				System.out.print(" 4---MAIN MENU  \n");
	
				BusinessOptions bOptions = new BusinessOptions();
				System.out.println("--------------USER MENU-----------------");
				int b_opt = sc.nextInt();
				switch (b_opt) {
				case 1:
					System.out.println("1---ADD FILE");
					System.out.println("Please enter the UserName(foldername to add file):");
					String userNameAdd = sc.next();
					System.out.println("Please give source path to upload file");
					String src = sc.next();
					File sourceLocation = new File(src);
					bOptions.copyFiles(sourceLocation,userNameAdd);
					break;
				case 2:
					System.out.println("DELETE FILE");
					System.out.println("Please enter the UserName[Folder name from whre you want to delete]:");
					String userName = sc.next();
					System.out.println("Please enter the FileName:");
					String fileNameDelete = sc.next();
					bOptions.deleteFile(userName, fileNameDelete);
					break;
				case 3:
					System.out.println("SEARCH FILE");
					File directory = new File("locker");
			        
			        System.out.println("Please enter the FileName:");
					String fileName = sc.next();
					//int counter = 0;
					int flag = bOptions.search_file(directory, fileName);
					//bOptions.searchFile();
					break;
				case 4:
					System.out.println("MAIN MENU");
					mainMenu();
					break;
				default:
					System.out.println("NOT A VALID OPTION");
				}
				System.out.println("***********************************");
				mainMenu();
			case 3:
				System.out.println("EXITED");
				System.exit(0);
				break;
			default:
				System.out.println("NOT A VALID OPTION");
				mainMenu();
				break;
			}
		}catch(Exception e) {
			System.out.println("Enter Valid Input");
			mainMenu();
			//e.printStackTrace();
		}
		finally {
			sc.close();
		}
		
	}
}
