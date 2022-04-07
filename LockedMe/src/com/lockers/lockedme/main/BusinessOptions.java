package com.lockers.lockedme.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class BusinessOptions {

	public void copyFiles(File sourceLocation, String userName) throws IOException {
		String path = "locker//";
		File targetLocation = new File("locker//" + userName);
		if(sourceLocation.isFile()) {
			if (!targetLocation.exists()) {
				path = path + userName;
				// Instantiate the File class
				targetLocation = new File(path);
				// Creating a folder using mkdir() method
				boolean bool = targetLocation.mkdir();
				if (bool) {
					System.out.println("Folder '"+ userName +"'is created successfully");
				} 
			}
			InputStream inputStream = null;
		    OutputStream outputStream = null;
		    try {
		        inputStream = new FileInputStream(sourceLocation);
		        outputStream = new FileOutputStream(targetLocation+"/"+sourceLocation.getName());
	
		        // the size of the buffer doesn't have to be exactly 1024 bytes, try playing around with this number and see what effect it will have on the performance
		        byte[] buffer = new byte[1024];
		        int length = 0;
		        while ((length = inputStream.read(buffer)) > 0) {
		        	outputStream.write(buffer, 0, length);
		        }
		        System.out.println(sourceLocation.getName() + " created successfully in " + userName + " folder");
		    } finally {
		    	inputStream.close();
		    	outputStream.close();
		    }
		}else {
			System.out.println("Invalid Entry. Please enter existing source path.");
		}
		
	}


	public void deleteFile(String userName, String fileName) {
		String path = "locker//";
		try {
			File f = new File(path + userName + "//" + fileName);
			if (f.delete()) {
				System.out.println(f.getName() + " deleted successfully"); // getting and printing the file name
			} else {
				System.out.println("File is not existing");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public int search_file(File file, String file_to_search) {
		int flag = 0;
		try {
			if (file_to_search != null && !file_to_search.isEmpty()) {
				if (file != null) {
					if (file.isDirectory()) {
						// Linear Search
						for (File sub_directory : file.listFiles()) {
							if (sub_directory.isDirectory()) {
								search_file(sub_directory, file_to_search);
							} else {
								if (file_to_search.equals(sub_directory.getName())) {
									System.out.println("File Found @ : " + sub_directory.getAbsoluteFile().toString());
									flag += 1;
								}
							}
						}
					} else {
						System.out.println(file.getAbsoluteFile() + " is not a directory!");
					}
				} else {
					file = new File("/");
					search_file(file, file_to_search);
				}
			} else {
				System.out.println("The file given to search ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}
