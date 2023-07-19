package dp;

import java.util.Arrays;

public class MaximumSumofNonAdjacentElements {


    public static void main(String[] args) {
//        int[] arr={1, 2, 2, 3, 4, 8, 1};
        int[] arr={1, 2, 4, 9};
        int n=arr.length;
        System.out.println("rec      "+rec(n-1, arr));

        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println("rec memo "+recMemo(n-1, arr, dp));

        System.out.println("DP       "+dp(n, arr));

        System.out.println("Spc opt  "+spOpt(n, arr));

    }

    private static int spOpt(int n, int[] arr) {

        int prev1=arr[0];
        int prev2=0;

        for(int i=1; i<n; i++) {
            int curr=Math.max(prev1,arr[i]+prev2);
            prev2=prev1;
            prev1=curr;
        }
        return prev1;

//        int prev1=arr[0];
//        int prev2=0;
//
//        for(int i=1; i<n; i++) {
//            int r=prev1;
//            int l=arr[i];
//            if(i>1) l+=prev2;
//            int curr=Math.max(r, l);
//            prev2=prev1;
//            prev1=curr;
//        }
//        return prev1;

    }


    private static int dp( int n, int[] arr) {
        int[] dp = new int[n+1];
        dp[0]=arr[0];

        for(int i=1; i<n; i++) {
            int r=dp[i - 1];
            int l=arr[i];
            if(i>1) l+=dp[i - 2];
            dp[i]=Math.max(r, l);
        }
        return dp[n-1];
    }

    private static int recMemo( int n, int[] arr, int[] dp) {

        dp[0]=arr[0];
        if(n<0)return 0;

        if(dp[n]!=-1)return dp[n];

        int r= recMemo(n-1, arr, dp);
        int l= arr[n] + recMemo(n-2, arr, dp);

        return dp[n] = Math.max(r, l);

    }

    private static int rec( int n, int[] arr) {

        if(n==0)return arr[n];
        if(n<0)return 0;

        int r= rec(n-1, arr);
        int l= arr[n]+rec(n-2, arr);

        return Math.max(r, l);

    }
}
