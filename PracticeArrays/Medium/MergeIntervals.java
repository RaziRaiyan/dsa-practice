package PracticeArrays.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
    Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, 
    and return an array of the non-overlapping intervals that cover all the intervals in the input.

    Example 1:
    Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
    Output: [[1,6],[8,10],[15,18]]
    Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
    Example 2:

    Input: intervals = [[1,4],[4,5]]
    Output: [[1,5]]
    Explanation: Intervals [1,4] and [4,5] are considered overlapping.

    Constraints:
    1 <= intervals.length <= 104
    intervals[i].length == 2
    0 <= starti <= endi <= 104
*/ 


public class MergeIntervals {
    public static void main(String[] args){
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        System.out.println(Arrays.deepToString(merge(intervals)));
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> ans = new ArrayList<>();
        ans.add(intervals[0]);

        for(int i=1; i<intervals.length; i++){
            int[] A = ans.remove(ans.size() - 1);
            int[] B = intervals[i];

            if(A[1] >= B[0]){ // merge is possible
                int[] merged = new int[]{A[0], Math.max(A[1], B[1])};
                ans.add(merged);
            }else{
                ans.add(A);
                ans.add(B);
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
        
}
