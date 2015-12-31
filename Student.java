/*
 * Zach Martin
 * zrmartin@calpoly.edu 
 * 10/19/15
 * Project 2 
 */

/*
 * Student is a simple class that contains two private instance variables:
 * their lastName, and their studentID
 */

public class Student implements Comparable<Student> 
{
	private long studID; //Student's ID, cannot be negative 
	private String lastName; //Student's lastName
	
	/*
	 * This constructor creates a new Student object, with the given
	 * StudentID and lastName 
	 */
	
	public Student(long studID, String lastName)
	{
		this.studID = studID;
		this.lastName = lastName;
	}

	/*
	 * compareTo is a Override method of the Comparable interface;
	 * compareTo compares 2 Student ID's, returns 1 if larger, -1 if smaller
	 * 0 if the same
	 */
	
	@Override
	public int compareTo(Student other) 
	{
		int result = 0;
		if(this.studID > other.studID)
		{
			result = 1;
		}
		else if(this.studID < other.studID)
		{
			result = -1;
		}
		return result;
	}
	
	/*
	 * toString prints out the ID and lastName of the student in a nice formatted way
	 */
	
	public String toString()
	{
		String result = "{ id: " + studID + ", name: " + lastName + " }";
		return result;
	}
}
