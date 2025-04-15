package BasicMaths;

import java.util.Scanner;

// Problem Statement: Given an integer N, return true if it is a palindrome else return false.

// A palindrome is a number that reads the same backward as forward. For example, 121, 1331, and 4554 are palindromes because they remain the same when their digits are reversed.

// Example 1:
// Input:N = 4554

// Output:Palindrome Number

// Explanation: The reverse of 4554 is 4554 and therefore it is palindrome number
                        
// Example 2:
// Input:N = 7789                

// Output: Not Palindrome

// Explanation: The reverse of number 7789 is 9877 and therefore it is not palindrome

public class CheckPalindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = scanner.nextInt();
        int original_number = n;
        int rev = 0;

        while(n !=0 ){
            // Time Complexity: O(log10(n))
            rev = rev*10 + n%10;
            n = n/10;
        }

        if(rev == original_number){
            System.out.println("Palindrome Number");
        }else{
            System.out.println("Not Palindrome");
        }

        scanner.close();
        
    }
}
