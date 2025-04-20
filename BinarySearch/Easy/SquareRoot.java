package BinarySearch.Easy;

public class SquareRoot {
    public static void main(String[] args){
        int num = 121;
        System.out.println(squareRoot(num));
    }

    public static int squareRoot(int num){
        int low = 1;
        int high = num/2;

        int res = low;

        while(low <= high){
            int mid = low + (high - low)/2;
            int midSquare = mid*mid;

            res = mid;

            if(midSquare == num){
                return mid;
            }else if(midSquare > num){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }



        return res;
    }
}
