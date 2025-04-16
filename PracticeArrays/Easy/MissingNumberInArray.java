package PracticeArrays.Easy;

public class MissingNumberInArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 10};
        int missingNumber = missingNumber(arr);
        System.out.println(missingNumber);
    }

    public static int missingNumber(int[] arr) {
        int n = arr.length;
        int sum = n * (n + 1) / 2;
        int arrSum = 0;
        for(int i = 0; i < n; i++){
            arrSum += arr[i];
        }
        return sum - arrSum;
    }
    
}
