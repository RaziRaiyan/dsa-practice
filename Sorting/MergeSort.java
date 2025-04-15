package Sorting;

import java.util.Scanner;

public class MergeSort {
    // Merge two sorted arrays
    // Time Complexity: O(nlogn)
    // Space Complexity: O(n) - Extra Space for temp array
    // Tagline: Divide and Merge
    // Stable Sorting
    // Not Inplace Sorting
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }
        scanner.close();

        mergeSort(arr, 0, n-1);

        System.out.println("Sorted array is: ");
        for(int i=0; i<n; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void mergeSort(int[] arr, int low, int high){
        if(low < high){
            int mid = low + (high - low) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid+1, high);
            merge(arr, low, mid, high);
        }
    }

    public static void merge(int[] arr, int low, int mid, int high){
        int[] temp = new int[high - low + 1]; // Extra Space for temp array
        int i = low, j = mid+1, k = 0;
        while(i <= mid && j <= high){
            if(arr[i] <= arr[j]){
                temp[k++] = arr[i++];
            }
            else{
                temp[k++] = arr[j++];
            }
        }
        while(i <= mid){
            temp[k++] = arr[i++];
        }
        while(j <= high){
            temp[k++] = arr[j++];
        }
        for(int p=0; p<temp.length; p++){
            arr[low+p] = temp[p];
        }
    }
    
}
