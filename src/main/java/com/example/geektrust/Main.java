package com.example.geektrust; 
import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import concrete.LearningManagementSystem;
import exception.InvalidInputException;
import service.CommandHandler;

public class Main {

	public static void main(String[] args) throws InvalidInputException {

		try  
		{  
			File file=new File(args[0]);    //creates a new file instance  
			FileReader fr=new FileReader(file);   //reads the file  
			BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream  
			StringBuffer sb=new StringBuffer();    //constructs a string buffer with no characters  
			String line; 
			
			LearningManagementSystem lms = new LearningManagementSystem();
			CommandHandler commandHandler = new CommandHandler(lms);
			while((line=br.readLine())!=null)  
			{  
				commandHandler.handleCommand(line);
				sb.append(line);      //appends line to string buffer  
				sb.append("\n");     //line feed   
			}  
			fr.close();    //closes the stream and release the resources  

		}  
		catch(IOException e)  
		{  
			e.printStackTrace();  
		}  
	}  
}

	//----------------------------------------------- 	
//
//	try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
//		LearningManagementSystem lms = new LearningManagementSystem();
//		CommandHandler commandHandler = new CommandHandler(lms);
//
//		String input;
//
//		while ((input = br.readLine()) != null) {
//			commandHandler.handleCommand(input);
//		}
//	} catch (IOException e) {
//		e.printStackTrace();
//	}
//}
//}



