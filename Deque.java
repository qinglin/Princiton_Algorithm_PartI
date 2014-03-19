import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
   private class Node {
        private Item item;
		private Node next;
		private Node previous;
		public Node(Item item) {
			this.item = item;
			next = null;
			previous = null;
		}
	
	}
    // construct an empty deque
	private Node head;
	private Node last;
	private int size;
    public Deque() {
	   head = null;
	   last = null;
	   head = last;
	   size = 0;
	 }                        
 // is the deque empty?
   public boolean isEmpty() {
	   return size == 0;
   }       
// return the number of items on the deque
   public int size() {
	   return size;
   }    
// Throw a NullPointerException if the client attempts to add a null item; 

   public void addFirst(Item item) {
	   if (item == null) throw new NullPointerException();
	   else {
		   if (head == null || size == 0) {
			   head = new Node(item);
			   last = head;
		   }
		   else if (last == head) {
			   Node newNode = new Node(item);
			   last = head;
			   newNode.next = head;
			   head = newNode;
			   last.previous = head;
			   }
		   else {
			   Node newNode = new Node(item);
			   newNode.next = head;
			   head.previous = newNode;
			   head = newNode;
			   }
		   size++;
	   }
	   
   }    
// insert the item at the end
   public void addLast(Item item) {
	   if (item == null) throw new NullPointerException();
	   else {
		   Node newNode = new Node(item);
		   if (last == null || size == 0) {
			   head = newNode;
			   last = head;
			   }
		   else {
			   Node n = last;
			   last.next = newNode;
			   last = newNode;
			   last.previous = n;
			  }
		   size++;
	   }
   }           
// delete and return the item at the front
// throw a java.util.NoSuchElementException if the client attempts to remove 
// an item from an empty deque; 
   public Item removeFirst() {
	   if (isEmpty()) {
		   throw new java.util.NoSuchElementException();
	   }
	   else {
		   Item item = head.item;
		   if (head.next == null && size == 1) head = null;
		   else {
		   if (head.next != null) {
			   head = head.next; 
			   head.previous = null;
		   }
		   }
		   size--;
		   return item;
	   }
  }       
   // delete and return the item at the end
   public Item removeLast() {
	   if (isEmpty()) {
		   throw new java.util.NoSuchElementException();
	   }
	   else {
		   Item item = last.item;
		   if (last.previous == null && size == 1) last = null;
		   else {
		   last = last.previous;
		   if (last != null) last.next = null; 
		   }
		   size--;
		   return item;
	   }
	   
   }              
// return an iterator over items in order from front to end
// throw an UnsupportedOperationException if the client calls the remove() method in the 
// iterator; throw a java.util.NoSuchElementException if the client calls the next() method 
// in the iterator and there are no more items to return.
// your iterator implementation must support the operations next() and hasNext() 
// (plus construction) in constant worst-case time and use a constant amount of extra space per iterator.  
  
   public Iterator<Item> iterator() {
        Iterator<Item> it = new Iterator<Item>() {
		private int currentIndex = 0;
		private Node currentNode = head;
		@Override
		public boolean hasNext() {
		  if (currentNode == null || currentIndex >= size || size == 0) return false; 
		  return true; }
		@Override
		public Item next() {
			if (currentIndex >= size) throw new NoSuchElementException(); 
			if (currentIndex == 0) {
				currentNode = head;
				currentIndex++; }
			else {
				currentIndex++;
				currentNode = currentNode.next; }
				Item next = currentNode.item;
			    return next; }
		@Override
		public void remove() { throw new UnsupportedOperationException(); } }; 
			return it; }
	   
	// unit testing
   public static void main(String[] args) {
//	   Check iterator() after intermixed calls to addFirst(), addLast(),
//       removeFirst(), and removeLast()
	   Deque<String> deque = new Deque<String>();
	   deque.addFirst("the");
	   deque.addLast("first");
	   Iterator<String> it = deque.iterator();
	   while (it.hasNext())
	   {
		   String s =  it.next();
		   StdOut.println(s);
	   }
	   deque.removeFirst();
	   Iterator<String> it1 = deque.iterator();
	   while (it1.hasNext())
	   {
		   String s =  it1.next();
		   StdOut.println(s);
	   }
	   deque.removeLast();
	   Iterator<String> it2 = deque.iterator();
	   while (it2.hasNext())
	   {
		   String s =  it2.next();
		   StdOut.println(s);
	   }
	   
	   deque.addLast("first");
	   deque.addLast("item");
	   StdOut.print("Size: " + deque.size());
	   
	   
	   deque.removeLast();
	   StdOut.print("Size: " + deque.size());
	   Iterator<String> it3 = deque.iterator();
	   while (it3.hasNext())
	   {
		   String s =  it3.next();
		   StdOut.print(s);
	   }
   //  Check iterator() after intermixed calls to addFirst(), addLast(),
   //    removeFirst(), and removeLast()
   }   
   
}
