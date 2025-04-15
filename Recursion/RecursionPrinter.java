package Recursion;

import java.util.Scanner;

public class RecursionPrinter {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println("Printing name " + n + " times");
        printNameRecursively("Raiyan Razi", n);
        System.out.println("Printing number from 1 to " + n);
        printNumberRecursively(n);
        System.out.println("Printing number from " + n + " to 1");
        printNumberRecursivelyReverse(n);
        scanner.close();
    }

    public static void printNameRecursively(String name, int n){
        if(n == 0){
            return;
        }
        System.out.println(name);
        printNameRecursively(name, n-1);
    }

    public static void printNumberRecursively(int n){
        if(n == 0){
            return;
        }
        printNumberRecursively(n-1);
        System.out.println(n);
    }

    public static void printNumberRecursivelyReverse(int n){
        if(n == 0){
            return;
        }
        System.out.println(n);
        printNumberRecursivelyReverse(n-1);
    }
}
