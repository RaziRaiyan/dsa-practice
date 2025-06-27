package BinarySearch.Medium;

public class NthRoot {
    public static void main(String[] args) {
        int n = 3;
        int m = 27;
        System.out.println(nthRoot(n, m));
    }

    public static int nthRoot(int n, int m){
        if(m == 0 || m ==  1){
            return m;
        }

        int lo = 1;
        int hi = m/2;
        int ans = 1;

        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            long nthPow = power(mid, n);

            if(nthPow == m){
                return mid;
            }else if(nthPow > m){
                hi = mid - 1;
            }else{
                ans = mid;
                lo = mid + 1;
            }
        }

        return ans;
    }

    private static long power(int base, int exponent) {
        long result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= base;
            if (result > Integer.MAX_VALUE) break; // early break to avoid overflow
        }
        return result;
    }    
}
