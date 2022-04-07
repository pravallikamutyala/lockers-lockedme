package com.lockers.lockedme.main;

import java.io.File;

public class ListFiles {

	public void RecursivePrint(File[] arr, int index, int level) {
		// terminate condition
		if (index == arr.length)
			return;

		// tabs for internal levels
		for (int i = 0; i < level; i++)
			System.out.print("\t");

		// for files
		if (arr[index].isFile())
			System.out.println(arr[index].getName());

		// for sub-directories
		else if (arr[index].isDirectory()) {
			System.out.println("[" + arr[index].getName() + "]");

			// recursion for sub-directories
			RecursivePrint(arr[index].listFiles(), 0, level + 1);
		}
		
		// recursion for main directory
		RecursivePrint(arr, ++index, level);
	}

	public void listFiles() {
		String maindirpath = "locker";
		// File object
		File maindir = new File(maindirpath);

		if (maindir.exists() && maindir.isDirectory()) {

			// array for files and sub-directories
			// of directory pointed by maindir
			File arr[] = maindir.listFiles();

			System.out.println("**************************************");
			System.out.println("Files from main directory : " + maindir);
			System.out.println("***************************************");

			// Calling recursive method
			RecursivePrint(arr, 0, 0);
		}
		
		System.out.println("***********************************");
	}
}
