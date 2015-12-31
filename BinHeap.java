/*
 * Zach Martin
 * zrmartin@calpoly.edu 
 * 10/19/15
 * Project 2 
 */

/*
 * BinHeap is a binary heap implementation of an ADT priority queue 
 */

public class BinHeap<T extends Comparable<? super T>> 
{
	/*
	 * MyException is a personal class that handles throwing exceptions
	 * it has 2 constructors; one with a message, one without
	 */
	public static class MyException extends RuntimeException
	{
		public MyException()
		{
			super();
		}
		
		public MyException(String message)
		{
			super(message);
		}
	}
	
	private T[] arr; //The array that holds each element of the heap
	private int sizeOfHeap; //How many elements currently are in the heap
	
	/*
	 * Creates a new, empty binary heap and allocates 
	 * space for a collection of 100 elements
	 */
	public BinHeap()
	{
		sizeOfHeap = 0;
		arr = (T[]) new Comparable[101];
	}
	
	/*
	 * Creates a new binary heap with a custom size
	 * @param size: is the number of spaces that will be allocated in memory for the collection
	 */
	
	public BinHeap(int size)
	{
		sizeOfHeap = 0;
		arr = (T[]) new Comparable[size]; 
	}
	
	/*
	 * Inserts an element into the heap while maintaining heap order 
	 * @param element: the anyType element to add to the heap
	 */
	
	public void insert(T element)
	{
		if(sizeOfHeap + 1 == arr.length)
		{
			T[] temp = (T[]) new Comparable[arr.length * 2]; 
			for(int i = 1; i < arr.length; i ++)
			{
				temp[i] = arr[i];
			}
			arr = temp;
		}
		// Percolate up
		int hole = ++sizeOfHeap; //Hole is placed at next available index of array
		arr[0] = element;
		System.out.println(element.compareTo(arr[hole/2]));
		for(; element.compareTo(arr[hole / 2]) < 0; hole /= 2) 
		{
			arr[hole] = arr[hole / 2];
		}
		arr[hole] = element;
	}
	
	/*
	 * DeleteMin removes the minimum element from the heap(at index 1)
	 * whilst remaining heap order
	 * @return the element on the top of the heap
	 */
	
	public T deleteMin() throws MyException
	{
		if(sizeOfHeap == 0)
		{
			throw new MyException("Cannot delete minnimum element; Stack is already empty");
		}
		T minItem = arr[1]; //Min item on the heap, saved to return at end
		arr[1] = arr[sizeOfHeap--];
		int child; //Used to determine the child of a specific node
		int hole = 1; //Removing the smallest element will always create a hole at arr[1]
		T tmp = arr[hole];
		
		for(; hole * 2 <= sizeOfHeap; hole = child)
		{
			child = hole * 2;
			if(child != sizeOfHeap && (arr[child + 1].compareTo(arr[child])) < 0)
			{
				child++;
			}	
			if(arr[child].compareTo(tmp) < 0)
			{
				arr[hole] = arr[child];
			}
			else
			{
				break;
			}
		}
		arr[hole] = tmp;
		return minItem;
	}
	
	/*
	 * Returns whether or not the heap is empty
	 * @return true if empty, false otherwise
	 */
	
	public boolean isEmpty()
	{
		boolean result = false;
		if(sizeOfHeap == 0)
		{
			result =  true;
		}
		return result;
	}
	
	/*
	 * size returns how many elements are currently in the heap
	 * @return current elements in heap
	 */
	
	public int size()
	{
		return sizeOfHeap;
	}
	
	/*
	 * print out elements that are currently in the heap (for testing purposes)
	 * @return the elements in the order they appear in the heap
	 */
	
	public String toString()
	{
		String result = "";
		for(int i = 1; i <= sizeOfHeap; i++)
		{
			result += arr[i];
			result += " ";
		}
		return result;
	}
	
}
