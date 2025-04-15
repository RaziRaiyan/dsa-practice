import java.util.Comparator;
import java.util.PriorityQueue;

public class LearnPriorityQueue {
    public static void main(String[] args) {
        // 
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(40);
        pq.add(10);
        pq.add(30);
        pq.add(20);
        System.out.println(pq);

        pq.remove();
        System.out.println(pq);

        pq.poll();
        System.out.println(pq);

        System.out.println(pq.peek());

        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Comparator.reverseOrder());
        pq2.add(40);
        pq2.add(10);
        pq2.add(30);
        pq2.add(20);
        System.out.println(pq2);

    }
}