package Recursion;

import java.util.Scanner;

public class RevereseArray {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt(); 
        }
        reverseArray(arr, 0, n-1);
        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
        scanner.close();
    }

    public static void reverseArray(int[] arr, int start, int end){
        if(start >= end){
            return;
        }

        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        reverseArray(arr, start+1, end-1);
    }
}
