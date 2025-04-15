package Recursion;

import java.util.Scanner;

public class CheckPalindrome {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string to check if it is a palindrome");
        String str = scanner.nextLine();
        System.out.println("Is " + str + " a palindrome? " + isPalindrome(str));
        scanner.close();
    }

    public static boolean isPalindrome(String str){
        if(str.length() == 0 || str.length() == 1){
            return true;
        }

        if(str.charAt(0) != str.charAt(str.length() - 1)){
            return false;
        }

        return isPalindrome(str.substring(1, str.length() - 1));
    }
    
}
