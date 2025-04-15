package Sorting;

import java.util.Scanner;

public class QuickSort {
    // Tagline: Partition and Conquer
    // Time Complexity: O(nlogn) - Best and Average Case
    // Time Complexity: O(n^2) - Worst Case
    // Space Complexity: O(1) - Inplace Sorting
    // Worst Case: When the pivot is the smallest or largest element
    // Best Case: When the pivot is the middle element
    // Average Case: When the pivot is the median element
    // Notes
    //  1. There is no rule to picking the pivot, we can pick any element as pivot
    //  2. Pivot can be the first element, last element, middle element, random element, etc.
    //  3. Pivot can be picked in different ways, but the time complexity will be different
    //  4. Pivot can be picked in different ways, but the space complexity will be the same
    //  5. Put the smaller elements to the left of the pivot and the larger elements to the right of the pivot
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }
        scanner.close();

        quickSort(arr, 0, n-1);

        System.out.println("Sorted array is: ");
        for(int i=0; i<n; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void quickSort(int[] arr, int low, int high){
        if(low < high){
            int pivot = partition(arr, low, high);
            // Pivot is now at its correct position
            quickSort(arr, low, pivot-1); // Sort the left half
            quickSort(arr, pivot+1, high); // Sort the right half
        }
    }

    public static int partition(int[] arr, int low, int high){

        // Step 1: Pick a random pivot
        int pivotIndex = low + (int)(Math.random() * (high - low + 1)); // Random pivot, could - low, high or any index
        int pivotElement = arr[pivotIndex];

        // Step 2: Place all the elements smaller than the pivot to the left of the pivot 
        //          and all the elements larger than the pivot to the right of the pivot
        int i = low;

        // for(int j=low; j<high; j++){
        //     if(arr[j] < pivotElement){
        //         int temp = arr[i];
        //         arr[i] = arr[j];
        //         arr[j] = temp;
        //         i++;
        //     }
        // }

        for(int j=low; j<high; j++){
            if(arr[j] < pivotElement){
                int tmp = arr[i];
                arr[i] = arr[j];
            }
        }

        // Step 3: Place the pivot in the correct position
        int temp = arr[i];
        arr[i] = arr[pivotIndex];
        arr[pivotIndex] = temp;

        // Pivot is now at its correct position
        return i;
    }
}
