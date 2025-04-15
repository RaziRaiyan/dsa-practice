package Sorting;

import java.util.Scanner;

public class InsertionSort {
    // Insert the current element in the correct position in the sorted part of the array
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    // Example:
    // Input: 5 2 4 6 1 3
    // Output: 1 2 3 4 5 6
    // Explanation:
    // 1. Start with the second element (2) and compare it with the first element (5). Since 2 is smaller, swap them.
    // 2. Move to the third element (4) and compare it with the elements before it. 4 is smaller than 5, so swap them.
    // 3. Continue this process for each element in the array.
    // 4. The array is sorted in ascending order.
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

        for(int i=1; i<n; i++){
            for(int j=i-1; j>=0; j--){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        System.out.println("Sorted array is: ");
        for(int i=0; i<n; i++){
            System.out.print(arr[i] + " ");
        }
    }

    // Recursive Insertion Sort
    public static void insertionSort(int[] arr, int n){
        if(n <= 1){
            return;
        }
        
        insertionSort(arr, n-1);
        for(int i=n-1; i>0; i--){
            if(arr[i] < arr[i-1]){
                int temp = arr[i];
                arr[i] = arr[i-1];
                arr[i-1] = temp;
            }
        }
    }
}