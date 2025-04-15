package Sorting;

import java.util.Scanner;

public class BubbleSort {
    // Push the largest element to the end of the array by swapping adjacent elements
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array: ");
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }
        scanner.close();

        // for(int i=0; i<n; i++){
        //     for(int j=0; j<n-i-1; j++){
        //         if(arr[j] > arr[j+1]){
        //             int temp = arr[j];
        //             arr[j] = arr[j+1];
        //             arr[j+1] = temp;
        //         }
        //     }
        // }
        bubbleSort(arr, n);

        System.out.println("Sorted array is: ");
        for(int i=0; i<n; i++){
            System.out.print(arr[i] + " ");
        }
    }

    // Recursive Bubble Sort
    public static void bubbleSort(int[] arr, int n){
        if(n == 1){
            return;
        }

        bubbleSort(arr, n-1);
        for(int i=0; i<n-1; i++){
            if(arr[i] > arr[i+1]){
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
    }
    
}