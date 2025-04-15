package BasicMaths;

import java.util.Scanner;

// You are given two integers n1 and n2. You need find the Greatest Common Divisor (GCD) of the two given numbers. Return the GCD of the two numbers.

// The Greatest Common Divisor (GCD) of two integers is the largest positive integer that divides both of the integers.
// Examples:
// Input: n1 = 4, n2 = 6

// Output: 2

// Explanation: Divisors of n1 = 1, 2, 4, Divisors of n2 = 1, 2, 3, 6

// Greatest Common divisor = 2.

// Input: n1 = 9, n2 = 8

// Output: 1

// Explanation: Divisors of n1 = 1, 3, 9 Divisors of n2 = 1, 2, 4, 8.

// Greatest Common divisor = 1.

public class GCD {
    public static int gcdRecursive(int n1, int n2){
        //  Using Euclidean algorithm
        // gcd(n1, n2) = gcd(n2, n1%n2)
        // gcd(n1, 0) = n1
        // Time Complexity: O(log(min(n1, n2)))
        System.out.println("n1: " + n1 + " n2: " + n2);
        if(n2 == 0){
            return n1;
        }
        return gcdRecursive(n2, n1%n2);
    }

    public static int gcdIterative(int n1, int n2){
        for(int i = Math.min(n1, n2); i >= 1; i--){
            // Time Complexity: O(min(n1, n2))
            if(n1 % i == 0 && n2 % i == 0){
                return i;
            }
        }
        return 1;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first number: ");
        int n1 = scanner.nextInt();
        System.out.println("Enter the second number: ");
        int n2 = scanner.nextInt();
        scanner.close();
        int gcd = gcdRecursive(n1, n2);
        System.out.println("GCD of " + n1 + " and " + n2 + " is " + gcd);

        gcd = gcdIterative(n1, n2);
        System.out.println("GCD of " + n1 + " and " + n2 + " is " + gcd);
        
        
    }
    
}
