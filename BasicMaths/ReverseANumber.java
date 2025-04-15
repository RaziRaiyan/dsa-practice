package BasicMaths;

import java.util.Scanner;

// Problem Statement: Given an integer N return the reverse of the given number.

// Note: If a number has trailing zeros, then its reverse will not include them. For e.g., reverse of 10400 will be 401 instead of 00401.

// Example 1:
// Input:N = 12345

// Output:54321

// Explanation: The reverse of 12345 is 54321.
                        
// Example 2:
// Input:N = 7789                

// Output: 9877

// Explanation: The reverse of number 7789 is 9877.

public class ReverseANumber {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = scanner.nextInt();
        scanner.close();
        int rev = 0;
        int original_number = n;
        while(n != 0){
            // Time Complexity: O(log10(n))
            rev = rev * 10 +  n%10;
            n = n/10;
        }

        System.out.println("Reverse of " + original_number + " is " + rev);
    }
}
