package org.example.virtualkey.screens;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FileOptionsScreen implements Screen {

	private ArrayList<String> options = new ArrayList<>();
	private String path = Screen.path;
	public FileOptionsScreen() {
		options.add("1. Add a File.");
		options.add("2. Delete a File.");
		options.add("3. Search a FIle.");
	}

	@Override
	public void Show() {
		System.out.println("==========Please select an option by inputting a number (1,2, or 3)=========");
		System.out.println("\n");

        for (String s : options)  {
            System.out.println(s);
	}
	}

	public void GetUserInput() {
		int selectedOption = this.getOption();
		this.NavigateOption(selectedOption);
	}
	
	private String getInputString() {
		Scanner in = new Scanner(System.in);
		return (in.nextLine());
	}


	@Override
	public void NavigateOption(int option) {
		switch (option) {
		case 1: 
			this.AddFile();
			this.ReturningToMenu();
			break;
		case 2:
			this.DeleteFile();
			this.ReturningToMenu();

			break;
		case 3:
			this.SearchFile();
			this.ReturningToMenu();

			break;
		default:
			System.out.println("Invalid Option,");
			break;
		}
	}
	private int getOption() {
		Scanner in = new Scanner(System.in);
		int returnOption = 0;

		try {
			returnOption = in.nextInt();
		} catch (InputMismatchException ex) {

		}
		return returnOption;
	}
	

	public void AddFile() {
		System.out.println("With the file extenstion, enter the name of the file to add.");
		String fileName = this.getInputString();
		
		
		 try {
		      File addObj = new File("C:\\Users\\Josh\\FILES\\ " + fileName);
		      if (addObj.createNewFile()) {
		    	  
		      }
		        System.out.println("File created: " + addObj.getName() + "/n");
		      }
		
		 catch (IOException e) {
		      System.out.println("An error has occurred.");
		 
	}
	}
	public void DeleteFile() {
		System.out.println("With the file extenssion, enter the name of the file to delete.");
			
			
		String fileName = this.getInputString();
		File delObj = new File("C:\\Users\\Josh\\FILES\\ " + fileName);
		boolean exist;
        exist = delObj.exists();
        if(exist) { 
        	delObj.delete(); 
        	 System.out.println("File " + fileName + " was successfully deleted\n"); 
        } else 
        	System.out.println ("File " + fileName + " was not deleted\n");
        }
       
	public void SearchFile() {
		System.out.println("With the file extenstion, enter the name of the file you would like to search for.");
			
		boolean found = false;
		String fileName = this.getInputString();
		File searchFile = new File("C:\\Users\\Josh\\FILES\\ ");
		String[] fileArray = searchFile.list();
		for (String i : fileArray) {
			if (i.equals(fileName)) {
				found = true;
			    if (found == true) {
				System.out.println ("File " + fileName + " was found in directory");
			}
			} else {		
		
	} System.out.println( "The file " + fileName + ", is not in the directory.\n");
		}
	}
	
		
		
		private void ReturningToMenu() {
			System.out.println("Returning to the main menu...");
		}

}