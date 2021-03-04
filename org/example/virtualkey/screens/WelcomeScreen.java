package org.example.virtualkey.screens;

import java.util.Scanner;
import org.example.virtualkey.services.DirectoryService;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class WelcomeScreen implements Screen {
	
	private String welcomeText = "Welcome to the VirtualKey by Lockers Pvt. Ltd";
	public String getWelcomeText() {
		return welcomeText;
	}

	
	private String developerName = "Developer: Josh Dorethy";
	public String getDeveloperName() {
		return developerName;
	}
	
	private String instructions = "\nPlease enter either the number 1, 2, or 3 based on your need: ";
	public String getInstructions() {
		return instructions;
	}
	
	public WelcomeScreen() {
		options.add("1. Show Files. ");
		options.add("2. Show File Options Menu. ");
		options.add("3. Quit. ");
	}

	private String selectOption = "\nChoose your option: \n=================================";
	
	private ArrayList<String> options = new ArrayList<>();
	
	@Override
	public void Show() {
		System.out.println(selectOption);
		System.out.println (" ");

		for (String s : options) {
			System.out.println(s);
		}

	}

	public void GetUserInput() {
		int selectedOption = this.getOption();
		
		this.NavigateOption(selectedOption);
	}

	@Override
	public void NavigateOption(int option) {
		switch (option) {
		case 1:
			this.ShowFiles();
			break;
		case 2: //Show Submenu 
			FileOptionsScreen fo = new FileOptionsScreen();
			fo.Show();
			fo.GetUserInput();
			break;
		case 3:
			appClose();
			break;
		default:
			System.out.println("You selected an invalid Option.");
			break;
		}
	}

	public void ShowFiles() {
		System.out.println("Current files in the folder.\n");
		DirectoryService.ViewFolder();
		 
	}

	public String getInputString() {
		Scanner input = new Scanner(System.in);
		return (input.nextLine());

	}

	private int getOption() {
		int returnOption = 0;
		Scanner in = new Scanner(System.in);
		try {
			returnOption = in.nextInt();
		} catch (InputMismatchException ime) {
		}
		return returnOption;
	}

	public static void appClose() {
		System.err.println("The Virtualkey application is closing.");
		System.exit(0);
	}

}