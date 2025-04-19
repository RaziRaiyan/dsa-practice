package PracticeArrays.Medium;
import java.util.Arrays;
public class MergeSort {
    public static void main(String[] args){
        int[] nums = {5, 4, 3, 2, 1, 0, 10, 9, 8, 7, 6};
        mergeSort(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    public static void mergeSort(int[] nums, int start, int end){
        if(start < end){
            int mid = start + (end - start)/2;
            mergeSort(nums, start, mid);
            mergeSort(nums, mid+1, end);
            merge(nums, start, mid, end);
        }
    }

    public static void merge(int[] nums, int low, int mid, int high){
        int[] res = new int[high-low+1];
        int curr = 0;
        int i = low, j = mid+1;
        while(i <= mid && j <= high){
            if(nums[i] < nums[j]){
                res[curr++] = nums[i++];
            }else{
                res[curr++] = nums[j++];
            }
        }

        while(i <= mid){
            res[curr++] = nums[i++];
        }

        while(j <= high){
            res[curr++] = nums[j++];
        }

        curr = 0;
        for(int x=low; x<=high; x++){
            nums[x] = res[curr++];
        }
    }



    
}
