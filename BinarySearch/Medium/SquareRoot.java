package BinarySearch.Medium;

public class SquareRoot {
    public static void main(String[] args) {
        int n = 42;
        System.out.println(squareRoot(n));
    }

    public static int squareRoot(int n){
        int lo = 1;
        int hi = n/2;
        int ans = 1;

        if(n == 0 || n == 1){
            return n;
        }

        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            int square = mid * mid;

            if(square == n){
                return mid;
            }else if(square > n){
                hi = mid - 1;
            }else{
                ans = mid;
                lo = mid+1;
            }
        }

        return ans;
    }
}
