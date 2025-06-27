package BinarySearch.Hard;

import java.util.Arrays;

public class AggresiveCows {
    public static void main(String[] args) {
        int[] stalls = {1, 2, 4, 8, 9};
        int cowsToPlace = 3;
        System.out.println(aggressiveCows(stalls, cowsToPlace));
    }

    public static int aggressiveCows(int[] stalls, int cowsToPlace){
        Arrays.sort(stalls);

        int n = stalls.length;
        int lo = 1;
        int hi = stalls[n-1] - stalls[0];
        int ans = 1;


        while(lo <= hi){
            int mid = lo + (hi-lo)/2;

            if(isPossible(stalls, mid, cowsToPlace)){
                lo = mid+1;
                ans = mid;
            }else{
                hi = mid-1;
            }
        }

        return ans;
    }

    public static boolean isPossible(int[] stalls, int distance, int cowsToPlace){
        int totalPlaced = 1;
        int lastPosition = stalls[0];

        for(int i=1; i<stalls.length; i++){
            if(stalls[i]-lastPosition >= distance){
                totalPlaced++;
                lastPosition = stalls[i];
            }
        }

        return totalPlaced >= cowsToPlace;
    }
}
