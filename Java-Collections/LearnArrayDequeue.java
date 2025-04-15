import java.util.ArrayDeque;

public class LearnArrayDequeue {
    public static void main(String[] args) {
        ArrayDeque<Integer> adq = new ArrayDeque<>();
        adq.offer(1);
        adq.offer(2);
        adq.offer(3);
        System.out.println(adq);

        adq.offerFirst(0);
        adq.offerLast(4);
        System.out.println(adq);

        System.out.println("Peek: " + adq.peek());
        System.out.println("Peek First: " + adq.peekFirst());
        System.out.println("Peek Last: " + adq.peekLast());

        System.out.println("Poll: " + adq.poll());
        System.out.println("Poll First: " + adq.pollFirst());
        System.out.println("Poll Last: " + adq.pollLast());

        
    }
}
