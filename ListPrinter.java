/*
 * Zach Martin
 * zrmartin@calpoly.edu 
 * 10/19/15
 * Project 2 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
 * ListPrinter is the testing class for utilizing BinHeap, and my Student class 
 */

public class ListPrinter 
{
	public static void main(String[] args) throws FileNotFoundException 
	{
		Scanner in = new Scanner(System.in); //For taking user input
		BinHeap<Student> heap = new BinHeap<>(); //New heap of string objects
		System.out.println("Enter file name: ");
		File input = new File(in.next()); 
		Scanner students = new Scanner(input); //To read through the given file

		while(students.hasNextLine())
		{
			long id = 0; //Student's ID
			String name; //Student's Name
			String line = students.nextLine();
			StringTokenizer s = new StringTokenizer(line);
			int entries = s.countTokens();
			while(s.hasMoreTokens())
			{
				if(entries != 2)
				{
					break;
				}
				
				try
				{
					id = Long.parseLong(s.nextToken());
				}
				catch(NumberFormatException e)
				{
					System.out.println(e);
					break;
				}
				if(id < 0)
					break;
				name = s.nextToken();
				heap.insert(new Student(id, name));
			}
		}
		int i = 1;
		System.out.println("Student List:");
		while(!heap.isEmpty())
		{
			System.out.println(i + ". " + heap.deleteMin());
			i++;
		}
		in.close();
		students.close();
	}

}
