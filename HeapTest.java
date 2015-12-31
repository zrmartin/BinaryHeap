/*
 * Zach Martin
 * zrmartin@calpoly.edu 
 * 10/19/15
 * Project 2 
 */

import java.util.Scanner;

/*
 * HeapTest is a tester class for BinHeap;
 * the user is prompted to give the initial heap size, and 
 * then prompted with a menu of heap operations for testing.  
 */

public class HeapTest 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter inital size of heap");
		int size = in.nextInt();
		BinHeap<String> heap = new BinHeap<String>(size + 1);
		String greeting = "Choose one of the following opperations:\n"
					+ "- add an element (enter the letter a)\n" 
					+ "- delete the smallest element (enter the letter d)\n"
					+ "- is the heap empty (enter the letter e)\n"
					+ "- size of the collection (enter the letter s)\n"
					+ "- print the collection (enter the letter p)\n"
					+ "- Quit (enter the letter q)\n";
		System.out.println(greeting);
		System.out.println("2".compareTo("10"));
		mainloop:
		while(in.hasNext())
		{
			String choice = in.next();
			switch(choice)
			{
				case "a":
				{
					in.nextLine();
					System.out.println("enter a value to add");
					String next = in.next();
					heap.insert(next);
					System.out.println(next + " has been added");
					break;
				}
				case "d":
				{
					in.nextLine();
					try
					{
						String minElement = heap.deleteMin();
						System.out.println(minElement + " has been removed");
					}
					catch(BinHeap.MyException e)
					{
						System.out.println(e);
					}
					break;
				}
				case "e":
				{
					if(heap.isEmpty())
					{
						System.out.println("Heap is empty");
					}
					else
					{
						System.out.println("Heap is not empty");
					}
					break;
				}
				case "s":
				{
					System.out.println("The heap has " + heap.size() + " objects");
					break;
				}
				case "p":
				{
					System.out.println(heap.toString());
					break;
				}
				case "q":
				{
					System.out.println("qutting, have a nice day");
					while(!heap.isEmpty())
					{
						System.out.print(heap.deleteMin() + " ");
					}
					break mainloop;
				}
				default:
				{
					System.out.println("not a valid choice");
					break;
				}
			}
		}
		in.close();			
	}

}
