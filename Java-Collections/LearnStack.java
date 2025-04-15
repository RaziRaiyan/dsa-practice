import java.util.Stack;

public class LearnStack {
    public static void main(String[] args) {
        Stack<String> animals = new Stack<>();
        animals.push("Dog");
        animals.push("Horse");
        animals.push("Cat");
        System.out.println("Stack: " + animals);

        System.out.println(animals.peek());
        animals.pop();
        System.out.println("Stack: " + animals);

        System.out.println(animals.search("Dog"));
        System.out.println(animals.search("Cat"));
        System.out.println(animals.search("Horse"));
        System.out.println(animals.search("Bird"));

        System.out.println("Is the stack empty? " + animals.isEmpty());
        System.out.println("Size of the stack: " + animals.size());
        System.out.println("Capacity of the stack: " + animals.capacity());
        System.out.println("Cloned stack: " + animals.clone());
        System.out.println("Contains Dog? " + animals.contains("Dog"));
        System.out.println("Peek: " + animals.peek());

        while(!animals.isEmpty()) {
            System.out.println("Popping: " + animals.pop());
        }

        // Time Complexity of Stack
        // push()       - ✅ O(1) → amortized, unless resize happens
        // pop()        - ✅ O(1)
        // peek()       - ✅ O(1)
        // isEmpty()    - ✅ O(1)
        // size()       - ✅ O(1)
        // capacity()   - ⚠️ No direct method in Stack; Vector's capacity() → O(1)
        // clone()      - ✅ O(n)
        // contains()   - ✅ O(n)
        // search()     - ✅ O(n)
        // clear()      - ⚠️ O(n) → not O(1), as each reference is nulled
        // sort()       - ✅ O(n log n) → if using `Collections.sort(stack)`
        // reverse()    - ✅ O(n)
        // toArray()    - ✅ O(n)
        
    }
}