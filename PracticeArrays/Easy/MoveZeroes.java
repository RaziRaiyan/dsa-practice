package PracticeArrays.Easy;

import java.util.Arrays;

// Move Zeroes
// Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

// Note that you must do this in-place without making a copy of the array.
// Example 1:

// Input: nums = [0,1,0,3,12]
// Output: [1,3,12,0,0]
// Example 2:

// Input: nums = [0]
// Output: [0]

// # Intuition
// 1. Just think that you need to put all the non zero elements in front of the array
// 2. And then fill the remaining elements with zeros
// 3. Move through the array and if you find a non zero element move it to first pointer's position and increment the first pointer's position. 
// 4. Once you reach the end of the array, your first pointer will be pointing to the element after the last non zero element.
// 5. Fill the remaining elements with zeros.

public class MoveZeroes {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void moveZeroes(int[] arr) {
        int i = 0;
        for(int j=0; j<arr.length; j++){
            if(arr[j] != 0){
                arr[i] = arr[j];
                i++;
            }
        }
        for(int j=i; j<arr.length; j++){
            arr[j] = 0;
        }
    }
}
