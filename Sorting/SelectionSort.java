package Sorting;

import java.util.Scanner;

public class SelectionSort {
    //  Step 1: Find the minimum element in the array
    //  Step 2: Swap the minimum element with the first element
    //  Step 3: Repeat the process for the remaining elements
    //  Time Complexity: O(n^2)
    //  Space Complexity: O(1)
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

        for(int i=0; i<n; i++){
            int minIndex = i;
            for(int j=i+1; j<n; j++){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }

        System.out.println("Sorted array is: ");
        for(int i=0; i<n; i++){
            System.out.print(arr[i] + " ");
        }
    }
}