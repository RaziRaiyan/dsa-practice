import java.util.LinkedList;
import java.util.Queue;

public class LearnLinkedListQueue {
    public static void main(String[] args) {

        // Queue is an interface, so we need to use a concrete class to implement it
        // LinkedList is a concrete class that implements the Queue interface
        
        // Queue can be implemented using LinkedList or PriorityQueue or ArrayDeque or ArrayList
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue);

        queue.offer(4);
        queue.offer(5);
        queue.offer(60);
        //  When discussing the difference between offer() and add() methods in a Java Queue, I should explain the key distinctions:
        // Return Value:
        // add() returns a boolean indicating whether the element was successfully added
        // offer() also returns a boolean indicating whether the element was successfully added
        // Behavior with Capacity Restrictions:
        // add(): Throws an IllegalStateException if the queue has a capacity restriction and is full
        // offer(): Returns false if the queue has a capacity restriction and is full (doesn't throw an exception)
        // Origin:
        // add() comes from the Collection interface which Queue inherits
        // offer() is specific to the Queue interface
        // 4. Usage Preference:
        // add() is preferred when working with unbounded queues or when you want failure to be exceptional
        // offer() is preferred when working with bounded queues where failure to add is an expected possibility
        System.out.println(queue);

        queue.remove();
        System.out.println(queue);

        queue.poll();
        System.out.println(queue);

        System.out.println("Queue peek: " + queue.peek());
        System.out.println("Queue element: " + queue.element());
        // peek():
        // Returns the head of the queue without removing it
        // Returns null if the queue is empty
        // Does not throw an exception for empty queues
        // element():
        // Also returns the head of the queue without removing it
        // Throws a NoSuchElementException if the queue is empty

        System.out.println("Queue poll: " + queue.poll());

        // remove() - removes the head of the queue
        // poll() - removes the head of the queue
        // peek() - returns the head of the queue
        // element() - returns the head of the queue
        // offer() - adds an element to the queue
        // size() - returns the size of the queue
        // isEmpty() - returns true if the queue is empty
        // contains() - returns true if the queue contains the element
        // toArray() - returns an array of the elements in the queue
        // clear() - removes all the elements from the queue
        // iterator() - returns an iterator of the elements in the queue
        // spliterator() - returns a spliterator of the elements in the queue

        // Time Complexity of Queue
        // add() - O(1)
        // remove() - O(1)
        // peek() - O(1)
        // size() - O(1)
        // isEmpty() - O(1)
        // contains() - O(n)
        // toArray() - O(n)
        // clear() - O(n)
        // iterator() - O(n)
        // spliterator() - O(n)

        // In General, use offer() and poll() instead of add() and remove()
        // offer() and poll() are preferred when working with bounded queues where failure to add is an expected possibility

        // And use peek() and element() instead of poll() and remove()
        // peek() and element() are preferred when working with unbounded queues where failure to add is an expected possibility
        
    }
}
