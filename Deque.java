package algorithms1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
	private Node first;
	private Node last;
	private int currentSize;
	
	/**
	 * Class constructor to create empty first Node 
	 */
	public Deque() {	
		first = null;
		last = null;
		currentSize = 0;
		}
	
	/**
	 * Check if LinkedList is empty, i.e first Node equals "null". returns boolean
	 */
	public boolean isEmpty() {
		return first == null;
		}
	
	/**
	 * Return the size of the LinkedList, returns integer type
	 */
	public int size() {
		return currentSize;
	}
	
	/**
	 * Add item to the beginning of the Deque
	 */
	public void addFirst(Item item) throws IllegalArgumentException {
		if (currentSize == 0) {				//If the deque is empty, the first Node to be added is both first and last
			first = new Node();
			first.item = (item);
			last = new Node();
			last.item = (item);
			++currentSize;
		}
		else if (currentSize == 1) {				//If the deque is empty, the first Node to be added is both first and last
			first = new Node();		
			first.item = (item);
			first.next = last;
			last.previous=first;
			++currentSize;
		}
		else {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		oldfirst.previous = first;
		++currentSize;
		}
	}
	
	/**
	 * Add item to the end of the Deque
	 */
	public void addLast (Item item) throws IllegalArgumentException {
		if (currentSize == 0) {				//If the deque is empty, the last Node to be added is both first and last
			first = new Node();
			first.item = item;
			last = new Node();
			last.item = item;
			++currentSize;
		}
		else {
		Node oldLast = last;
		last = new Node();
		last.item = item;
		oldLast.next = last;
		last.previous = oldLast;			
		currentSize++;
		}
	}
	
	public Item removeFirst() throws NoSuchElementException{
		if (currentSize == 1) {
			Item removedItem = first.item;
			currentSize = 0;
			first = null;
			last = null;
			return removedItem;
		}
		else {
			Item removedItem = first.item;
			first = first.next;
			first.previous = null;
			currentSize--;
			return removedItem;	
		}
	}
	
	public Item removeLast() throws NoSuchElementException{
		if (currentSize == 1) {
			Item removedItem = last.item;
			currentSize = 0;
			first = null;
			last = null;
			return removedItem;
		}
		else {			
			Item removedItem = last.item;
			last = last.previous;
			last.next = null;
			currentSize--;
			return removedItem;
		}
	}
	
	public Iterator<Item> iterator() {
		return new ListIterator();		
	}
	
	private class Node	{
		Item item;
		Node next;
		Node previous;
	}
	
	private class ListIterator implements Iterator<Item> {
		private Node current = first;
		
		public boolean hasNext() {	return current !=null;}
		public Item next() throws NoSuchElementException {
			Item item = current.item;
			current = current.next;
			return item;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Deque<String> testDeque = new Deque<>();
		testDeque.addFirst("String_1");
		testDeque.forEach(System.out::println); 
		System.out.println(testDeque.size());
		System.out.println("first = "+ testDeque.first.item + " and last = "+ testDeque.last.item);
		System.out.println("-------------------------------------------------------------------");

		testDeque.addFirst("String_0");
		testDeque.forEach(System.out::println); 
		System.out.println(testDeque.size());
		System.out.println("first = "+ testDeque.first.item + " and last = "+ testDeque.last.item);
		System.out.println(testDeque.last.previous.item);
		System.out.println("-------------------------------------------------------------------");

		testDeque.addLast("String_Last1");
		testDeque.forEach(System.out::println); 
		System.out.println(testDeque.size());
		System.out.println("first = "+ testDeque.first.item + " and last = "+ testDeque.last.item);
		System.out.println(testDeque.last.previous.item);
		System.out.println("-------------------------------------------------------------------");

		testDeque.addLast("String_Last2");
		testDeque.forEach(System.out::println); 
		System.out.println(testDeque.size());
		System.out.println("first = "+ testDeque.first.item + " and last = "+ testDeque.last.item);
		System.out.println(testDeque.last.previous.item);
		System.out.println("-------------------------------------------------------------------");

		/**
		 * Look into using the line below for optimization using parallelism
		 * testDeque.stream().forEach(System.out::println); 
		 */
		
		System.out.println("Removing " + testDeque.removeLast());
		testDeque.forEach(System.out::println); 
		System.out.println(testDeque.size());
		System.out.println("first = "+ testDeque.first.item + " and last = "+ testDeque.last.item);
		System.out.println("-------------------------------------------------------------------");

		
		System.out.println("Removing " + testDeque.removeLast());
		testDeque.forEach(System.out::println); 
		System.out.println(testDeque.size());
		System.out.println("first = "+ testDeque.first.item + " and last = "+ testDeque.last.item);
		System.out.println("-------------------------------------------------------------------");
		
		System.out.println("Removing " + testDeque.removeFirst());
		testDeque.forEach(System.out::println); 
		System.out.println(testDeque.size());
		System.out.println("first = "+ testDeque.first.item + " and last = "+ testDeque.last.item);
		System.out.println("-------------------------------------------------------------------");
		
		System.out.println("Removing " + testDeque.removeFirst());
		testDeque.forEach(System.out::println); 
		System.out.println(testDeque.size());
		System.out.println("first = "+ testDeque.first.item + " and last = "+ testDeque.last.item);
		System.out.println("-------------------------------------------------------------------");
		testDeque.removeFirst();
		

		//System.out.println(testDeque.size());
		//System.out.println(testDeque.first.item);
		//System.out.println(testDeque.last.item);
	}

}
