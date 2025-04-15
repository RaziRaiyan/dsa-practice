package BasicMaths;

import java.util.ArrayList;
import java.util.Scanner;


// Problem Statement: Given an integer N, return all divisors of N.

// A divisor of an integer N is a positive integer that divides N without leaving a remainder. In other words, if N is divisible by another integer without any remainder, then that integer is considered a divisor of N.

// Examples
// Example 1:
// Input:N = 36

// Output:[1, 2, 3, 4, 6, 9, 12, 18, 36]

// Explanation: The divisors of 36 are 1, 2, 3, 4, 6, 9, 12, 18, 36.
                        
// Example 2:
// Input:N =12                

// Output: [1, 2, 3, 4, 6, 12]

// Explanation: The divisors of 12 are 1, 2, 3, 4, 6, 12.                            


public class PrintAllDivisors {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = scanner.nextInt();
        scanner.close();

        ArrayList<Integer> divisors = new ArrayList<>();

        for(int i=1; i<=n; i++){
            // Time Complexity: O(n)
            if(n%i == 0){
                divisors.add(i);
            }
        }

        System.out.println("Divisors of " + n + " are: " + divisors);

        divisors.clear();

        for(int i=1; i<Math.sqrt(n); i++){
            // Time Complexity: O(sqrt(n))
            if(n%i == 0){
                divisors.add(i);
                if(n/i != i){
                    divisors.add(n/i);
                }
            }
        }

        System.out.println("Divisors of " + n + " are: " + divisors);
    }
    
}