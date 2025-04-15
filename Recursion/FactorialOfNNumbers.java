package Recursion;

import java.util.Scanner;

public class FactorialOfNNumbers {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println("Factorial of " + n + " is " + factorialOfNNumbers(n));
        scanner.close();
    }

    public static int factorialOfNNumbers(int n){
        if(n == 0){
            return 1;
        }
        return n * factorialOfNNumbers(n-1);
    }
    
}
