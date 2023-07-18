package dp;

import java.util.Arrays;

public class FibonacciNumber {

//    https://takeuforward.org/data-structure/dynamic-programming-introduction/
    public static void main(String[] args) {
        int n=8;
        System.out.println(fibRecursion( n));
        System.out.println(fibDPTabulation(n));
        System.out.println(fibDPWithSpaceOpt(n));

        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(fibRecursionWithMemo(n, dp));
    }

    private static int fibDPWithSpaceOpt(int n) {
        int prev2=0;
        int prev1=1;

        for(int i=2; i<=n; i++){
            int curr=prev2+prev1;
            prev2=prev1;
            prev1=curr;
        }
        return prev1;
    }

    private static int fibDPTabulation(int n) {
        int[] dp = new int[n+1];
        dp[0]=0;
        dp[1]=1;

        for(int i=2; i<=n; i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    private static int fibRecursionWithMemo(int n, int[] dp) {
        if(n<=1)return n;
        if(dp[n]!=-1)return dp[n];
        return dp[n] = fibRecursionWithMemo(n-1, dp)+fibRecursionWithMemo(n-2, dp);
    }

    private static int fibRecursion(int n) {
        if(n<=1)return n;
        return fibRecursion(n-1)+fibRecursion(n-2);
    }



}
