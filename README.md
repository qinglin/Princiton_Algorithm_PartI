Princiton_Algorithm_PartI
=========================

By Qinglin,Xia


Write API for data structure of Deque and Randomized Queue.
1) Deque:  A double-ended queue or deque (pronounced "deck") is a generalization of a stack and a 
queue that supports inserting and removing items from either the front or the back of the data structure
API:
public class Deque<Item> implements Iterable<Item> {
   public Deque()                           // construct an empty deque
   public boolean isEmpty()                 // is the deque empty?
   public int size()                        // return the number of items on the deque
   public void addFirst(Item item)          // insert the item at the front
   public void addLast(Item item)           // insert the item at the end
   public Item removeFirst()                // delete and return the item at the front
   public Item removeLast()                 // delete and return the item at the end
   public Iterator<Item> iterator()         // return an iterator over items in order from front to end
   public static void main(String[] args)   // unit testing
}

2) Randomized Queue:  A randomized queue is similar to a stack or queue, 
except that the item removed is chosen uniformly at random from items in the data structure. 
API:
public class RandomizedQueue<Item> implements Iterable<Item> {
   public RandomizedQueue()                 // construct an empty randomized queue
   public boolean isEmpty()                 // is the queue empty?
   public int size()                        // return the number of items on the queue
   public void enqueue(Item item)           // add the item
   public Item dequeue()                    // delete and return a random item
   public Item sample()                     // return (but do not delete) a random item
   public Iterator<Item> iterator()         // return an independent iterator over items in random order
   public static void main(String[] args)   // unit testing
}

Programming Assignments
