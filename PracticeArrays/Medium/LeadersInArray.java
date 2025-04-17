package PracticeArrays.Medium;

import java.util.ArrayList;
import java.util.HashSet;

// Problem Statement: Given an array, print all the elements which are leaders. A Leader is an element that is greater than all of the elements on its right side in the array.

// Example 1:
// Input:
//  arr = [4, 7, 1, 0]
// Output:
//  7 1 0
// Explanation:
//  Rightmost element is always a leader. 7 and 1 are greater than the elements in their right side.

// Example 2:
// Input:
//  arr = [10, 22, 12, 3, 0, 6]
// Output:
//  22 12 6
// Explanation:
//  6 is a leader. In addition to that, 12 is greater than all the elements in its right side (3, 0, 6), also 22 is greater than 12, 3, 0, 6.

public class LeadersInArray {
    public static void main(String[] args) {
        int[] arr = {10, 22, 12, 3, 0, 6};
        ArrayList<Integer> leaders = leadersInArray(arr);
        System.out.println(leaders);

        HashSet<Integer[]> zero_cordinates = new HashSet<>();

        zero_cordinates.add(new Integer[]{0, 0});

        for(Integer[] cordinate : zero_cordinates){
            System.out.println(cordinate[0] + " " + cordinate[1]);
        }
    }

    public static ArrayList<Integer> leadersInArray(int[] arr){
        ArrayList<Integer> list = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for(int i=arr.length-1; i>=0; i--){
            if(max < arr[i]){
                list.add(arr[i]);
                max = arr[i];
            }
        }

        return list;
    }
        
}
