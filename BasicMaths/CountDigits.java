package BasicMaths;

import java.util.Scanner;


// Problem Statement: Given an integer N, return the number of digits in N.

public class CountDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = scanner.nextInt();
        scanner.close();
        int original_number = n;
        int digits = 0;
        while(n !=  0){
            // Time Complexity: O(log10(n))
            digits++;
            n = n/10;
        }

        System.out.println("Digits in " + original_number + " are " + digits);
    }
}
