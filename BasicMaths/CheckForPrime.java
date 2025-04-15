package BasicMaths;

import java.util.Scanner;

// Problem Statement: Given an integer N, check whether it is prime or not. A prime number is a number that is only divisible by 1 and itself and the total number of divisors is 2.

// Examples
// Example 1:
// Input:N = 2

// Output:True

// Explanation: 2 is a prime number because it has two divisors: 1 and 2 (the number itself).
                        
// Example 2:
// Input:N =10                

// Output: False

// Explanation: 10 is not prime, it is a composite number because it has 4 divisors: 1, 2, 5 and 10.       

public class CheckForPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = scanner.nextInt();
        scanner.close();

        for(int i=2; i<n; i++){
            // Time Complexity: O(n)
            if(n%i ==0){
                System.out.println("Not a prime number");
                break;
            }
        }
        System.out.println("Prime number");

        // Time Complexity: O(sqrt(n))
        for(int i=2; i<Math.sqrt(n); i++){
            if(n%i ==0){
                System.out.println("Not a prime number");
                break;
            }
        }
        System.out.println("Prime number");
    }
}
