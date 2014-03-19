import java.util.Iterator;
import java.util.NoSuchElementException;

//  A randomized queue is similar to a stack or queue, except that the item removed is chosen 
// uniformly at random from items in the data structure. 
// Create a generic data type RandomizedQueue that implements the following API:
public class RandomizedQueue<Item> implements Iterable<Item> {
	// construct an empty randomized queue
    private Item[] items; 
	private int size;
	public RandomizedQueue() {
		items = (Item[]) new Object[1];
		size = 0;
   }           
    // is the queue empty?
   public boolean isEmpty() 
   {
	   return size == 0;
   }
   
  // return the number of items on the queue
   public int size() {
	   return size;
   }         
   // add the item
   public void enqueue(Item item) {
	   if (item == null)
	   {
		   throw new NullPointerException();
	   }
	   else {
		   if (size == 0) {
			   items[size++] = item;
		   }
		   else if (size == items.length) {
			   Item[] copy = (Item[]) new Object[items.length *2];
			   for (int i = 0; i < items.length; i++) {
				   copy[i] = items[i];
			   }
			   items = copy;
			   items[size++] = item;
			}
		   else if (size < items.length) {
			   items[size++] = item;
		   }
	   		
	   }
   }     
   // delete and return a random item
   public Item dequeue() {
	   if (size == 0)
	   {
		   throw new NoSuchElementException();
	   }
	   else {
		   int indexToReturn = StdRandom.uniform(size);
		   Item item = items[indexToReturn];
		   if (indexToReturn == size-1) items[size - 1] = null;
		   else {
			   items[indexToReturn]=items[size -1];
	           items[size -1]=null;
		   }
		   size--;
		   return item;
	   }
   }   
   // return (but do not delete) a random item
   public Item sample()  {
	   if (size == 0)
	   {
		   throw new NoSuchElementException();
	   }
	   else {
		   return items[StdRandom.uniform(size)];
	   }
   }    
   // return an independent iterator over items in random order
   public Iterator<Item> iterator() {
	   if(size > 0) StdRandom.shuffle(items, 0, size-1);
	   Iterator<Item> it = new Iterator<Item>() {
		 private int currentIndex = 0;
		@Override
		public boolean hasNext() {
			boolean hasNext = true;
			if (size == 0 || currentIndex >= size) {
				hasNext = false; }
			return hasNext; }

		@Override
		public Item next() {
			if (currentIndex >= size) throw new NoSuchElementException(); 
			return items[currentIndex++]; }

		@Override
		public void remove() {
			throw new UnsupportedOperationException(); }
 	   };
	   return it;
   	}

   // unit testing
   public static void main(String[] args) {
	   // test constructor
	   RandomizedQueue<String> rq = new RandomizedQueue<String>();
//	   StdOut.println(rq.size());
//	   StdOut.println(rq.isEmpty());
	   
//	   1 enqueue followed by 1 dequeue
//	   4 enqueue followed by 4 dequeue
//	   2 enqueue followed by 2 dequeue in alternate steps (enqueue followed by dequeue, then again enqueue)
//	   3 enqueue
//	   4 enqueue followed by 1 dequeue
	   // test Enqueue
	   rq.enqueue("1");
	   rq.dequeue();
	   Iterator<String> it = rq.iterator();
	   while (it.hasNext()) {
		   StdOut.println(it.next());
	   }
	   rq.enqueue("2");
	   rq.enqueue("3");
	   rq.enqueue("4");
	   rq.enqueue("5");
	   rq.enqueue("6");
	   rq.enqueue("7");
	   rq.enqueue("8");
	   rq.enqueue("9");
	   rq.enqueue("10");
//	   System.out.println(rq.size());
//	   StdOut.print(rq.isEmpty());
//	   
//	   // test Dequeue
//	   String s1 = rq.dequeue();
//	   System.out.println(s1);
//	   System.out.println(rq.size());
//	   String s2 = rq.dequeue();
//	   
//	   System.out.println(s2);
//	   System.out.println(rq.size());
//	   String s3 = rq.dequeue();
//	   System.out.println(s3);
//	   String s4 = rq.dequeue();
//	   System.out.println(s4);
//	   String s5 = rq.dequeue();
//	   System.out.println(s5);
//	   
//	   System.out.println(rq.size());
//	   rq.enqueue("hello");
//	   rq.enqueue("this");
//	   rq.enqueue("is");
//	   rq.enqueue("unit");
//	   rq.enqueue("test");
//	   System.out.println(rq.size());
//	   System.out.println(rq.isEmpty());
	  
	   // test iterator
	   Iterator<String> it3 = rq.iterator();
	   while (it3.hasNext()) {
		   StdOut.println(it3.next());
	   }
	   StdOut.println("Test2");
	   Iterator<String> it2 = rq.iterator();
	   while (it2.hasNext()) {
		   StdOut.println(it2.next());
	   }

   }
}
