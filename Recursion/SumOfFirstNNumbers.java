package Recursion;

import java.util.Scanner;

public class SumOfFirstNNumbers {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println("Sum of first " + n + " numbers is " + sumOfFirstNNumbers(n));
        scanner.close();
    }

    public static int sumOfFirstNNumbers(int n){
        if(n == 0){
            return 0;
        }
        return n + sumOfFirstNNumbers(n-1);
    }
}
