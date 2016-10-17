/* 
 *	A pikachu chatbot
 *  Later to be extended to all Pokemon
 *	Program by Milk - idea by Tony
 *	Version 4.1
*/ 

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class Pikachat{

	public static File logtxt;
	public static FileWriter fw;
	public static BufferedWriter bw;

	//make the output file
	public static void startUp(){
		try{
			logtxt = new File("log.txt");
			if(!logtxt.exists())
				logtxt.createNewFile();
			fw = new FileWriter(logtxt, true);
	   		bw = new BufferedWriter(fw);
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}
	

	public Pikachat(){}

	public static void main(String[] args){
		//setup the convo
		startUp();
		Scanner in = new Scanner(System.in);
		System.out.println("\u001B[31m" + "Say hi to Pikachu... [type Bye to finish]" + "\u001B[0m");
		exportConvo("------------------------------------");

		//first line
		System.out.print("User >     ");
		String user = in.nextLine();
		exportConvo("User >     " + user);

		//while conversation is still going
		while(!user.toUpperCase().equals("BYE")){
			//get pikachu's response
			int randomTimes = 1 + (int)(Math.random() * 4);
			String pika = "";
			for(int a = 0; a < randomTimes;a++){
				int randomNum = 1 + (int)(Math.random() * 5); 
				pika += Pikachat.chat(randomNum) + " ";
			}
			pika = pika.trim();
			String punc = newPunctuation(user);
			System.out.println("\u001B[33m" + "Pikachu >  " + pika + punc + "\u001B[0m");
			exportConvo("Pikachu >  " + pika);

			//get user's input
			System.out.print("User >     ");
			user = in.nextLine();
			exportConvo("User >     " + user);
		}
		try{bw.close();}catch(IOException e){e.printStackTrace();}
	}

	//decide for pikachu what to say
	public static String chat(int input){
		if(input == 1)
			return "Pika";
		else if(input == 2)
			return "Chu";
		else if(input == 3)
			return "Pikachu";
		else if(input == 4)
			return "Pi";
		else if(input == 5)
			return "PikaCHUUUUUUU";
		else
			return "...";
	}
 
	//randomize the punctation ending
	public static String newPunctuation(String userIn){
		int a = (int)(Math.random() * 4);
		if(a == 0)
			return ".";
		else if(a == 1)
			return "?";
		else if(a == 2)
			return "!";
		else
			return "...";
	}

	//export each line of conversation to a log
	public static void exportConvo(String line){
		try{
			bw.write(line);
			bw.newLine();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}	