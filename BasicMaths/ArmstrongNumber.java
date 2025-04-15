package BasicMaths;

import java.util.Scanner;


// Problem Statement: Given an integer N, return true it is an Armstrong number otherwise return false.

// An Amrstrong number is a number that is equal to the sum of its own digits each raised to the power of the number of digits.

// Examples
// Example 1:
// Input:N = 153

// Output:True

// Explanation: 1^3+5^3+3^3 = 1 + 125 + 27 = 153
                        
// Example 2:
// Input:N = 371                

// Output: True

// Explanation: 3^3+5^3+1^3 = 27 + 343 + 1 = 371


public class ArmstrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = scanner.nextInt();
        scanner.close();

        boolean isArmstrong = isArmstrong(n);
        System.out.println("Is " + n + " an Armstrong number? " + isArmstrong);
    }

    public static boolean isArmstrong(int n){
        // Time Complexity: O(log10(n))
        int digits = 0;
        int temp = n;
        while(temp != 0){
            digits++;
            temp = temp/10;
        }
        temp = n;
        int sum = 0;
        while(temp != 0){
            int lastDigit = temp % 10;
            sum += Math.pow(lastDigit, digits);
            temp = temp/10;
        }
        return sum == n;
    }
}