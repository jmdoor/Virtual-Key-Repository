package org.example.virtualkey.services;
import org.example.virtualkey.screens.WelcomeScreen;
public class VirtualKeyApplication {


	public static void main(String[] args) {
		WelcomeScreen ws = new WelcomeScreen();
		System.out.println(ws.getWelcomeText());
		System.out.println(ws.getDeveloperName());
		System.out.println(ws.getInstructions());
	
	while(true) {
			ws.Show();
			ws.GetUserInput();
		}
		
		
	} 
}