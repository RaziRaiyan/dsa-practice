package Monotonics;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/*
    Given an array of integers heights representing the histogram's bar height where the width of each bar is 1
    return the area of the largest rectangle in the histogram.

    Example
    Input: heights = [2,1,5,6,2,3]
    Output: 10
    Explanation: The above is a histogram where width of each bar is 1.
    The largest rectangle is shown in the red area, which has an area = 10 units.
*/

public class LargestRectangleHistorgran {
    public static void main(String[] args) {
        int[] heights = {1,1};
        System.out.println(largestRectangleArea(heights));
    }

    public static int largestRectangleArea(int[] heights) { // [2,1,5,6,2,3]
        int maxRectangle = 0;

        Deque<Integer> maxDeque = new LinkedList<>();
        int n = heights.length;

        int[] nsr = new int[n];
        int[] nsl = new int[n];


        for(int i=n-1; i>=0; i--){
            while(!maxDeque.isEmpty() && heights[maxDeque.peekLast()] >= heights[i]){
                maxDeque.pollLast();
            }
            nsr[i] = maxDeque.isEmpty() ? n : maxDeque.peekLast();
            maxDeque.offerLast(i);
        }

        while(!maxDeque.isEmpty()) {
            maxDeque.pollLast();
        }

        for(int i=0; i<n; i++){
            while(!maxDeque.isEmpty() && heights[maxDeque.peekLast()] >= heights[i]){
                maxDeque.pollLast();
            }
            nsl[i] = maxDeque.isEmpty() ? -1 : maxDeque.peekLast();
            maxDeque.offerLast(i);
        }


        for(int i=0; i<n; i++){
            int currHeightArea = (nsr[i]-nsl[i]-1)*heights[i];
            maxRectangle = Math.max(maxRectangle, currHeightArea);
        }

        return maxRectangle;
    }
}
