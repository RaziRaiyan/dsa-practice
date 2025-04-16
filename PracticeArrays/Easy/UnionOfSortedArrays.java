package PracticeArrays.Easy;

import java.util.Arrays;

// Example 1:
// Input:
// n = 5,m = 5.
// arr1[] = {1,2,3,4,5}  
// arr2[] = {2,3,4,4,5}
// Output:
//  {1,2,3,4,5}

public class UnionOfSortedArrays {

    static int k = 0;
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {2, 3, 4, 4, 5};

        int[] union = Arrays.copyOf(uniqueUnion(arr1, arr2), k);
        System.out.println(Arrays.toString(union));
    }

    public static int[] uniqueUnion(int[] arr1, int[] arr2) {
        int[] union = new int[arr1.length + arr2.length];
        int i = 0, j = 0;

        while(i < arr1.length && j < arr2.length){
            while(i < arr1.length-1){
                if(arr1[i] == arr1[i+1]){
                    i++;
                }
                else{
                    break;
                }
            }

            while(j < arr2.length-1){
                if(arr2[j] == arr2[j+1]){
                    j++;
                }
                else{
                    break;
                }
            }

            if(arr1[i] < arr2[j]){
                union[k++] = arr1[i++]; 
            }
            else if(arr1[i] > arr2[j]){
                union[k++] = arr2[j++];
            }
            else{
                union[k++] = arr1[i++];
                j++;
            }
        }

        while(i < arr1.length){
            while(i < arr1.length-1){
                if(arr1[i] == arr1[i+1]){
                    i++;
                }
                else{
                    break;
                }
            }

            union[k++] = arr1[i++];
        }

        while(j < arr2.length){
            while(j < arr2.length-1){
                if(arr2[j] == arr2[j+1]){
                    j++;
                }
                else{
                    break;
                }
            }

            union[k++] = arr2[j++];
        }

        return union;
    }
    
}
