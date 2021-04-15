package application;

import static java.nio.file.StandardOpenOption.CREATE;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class WriteOutput {

	public static void main(String[] args) {
		
		String delimiter=",";
		final int EXIT=-1;
//To open a file to put data
		Path fp=Paths.get("C:\\Users\\donjo\\eclipse-workspace\\AnewProject\\f1.txt");
		try
		{
		//To open output stream
			FileWriter fr=new FileWriter("C:\\Users\\donjo\\eclipse-workspace\\AnewProject\\f1.txt");
			BufferedWriter br=new BufferedWriter(fr);
		
			Scanner sc=new Scanner(System.in);
			int choice,age,id=0;
			String name,s,g;
			char grade;
			do {
			
			System.out.println("Enter student name");
			name=sc.nextLine();
			System.out.println("Enter student age");
			age=sc.nextInt();
			System.out.println("Enter student grade");
			g=sc.next();
			grade=g.charAt(0);
			
			s=(id+1)+delimiter+name+delimiter+age+delimiter+grade;
			//To increment id for next record
			id++;
			//To append a string in buffer reader
			br.append(s);
			br.newLine();
			System.out.println("Want to enter more data?");
			choice=sc.nextInt();
			sc.nextLine();
			}while(choice!=EXIT);
			br.close();		
		}
		catch(IOException e)
		{
			System.out.print("File is not there "+e);
		}
		

	}

}

