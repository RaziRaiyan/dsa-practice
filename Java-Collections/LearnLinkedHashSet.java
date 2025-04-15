import java.util.LinkedHashSet;

public class LearnLinkedHashSet {
    public static void main(String[] args) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        set.add(32);
        set.add(2);
        set.add(56);
        set.add(78);
        System.out.println(set);

        set.remove(56);
        System.out.println(set);
        
    }
}