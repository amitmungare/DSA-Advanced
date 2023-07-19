package dp;

import java.util.Arrays;

public class FrogJumpWithK {

    public static void main(String[] args) {

        int arr[] = {30,10,60,10,60,50};
        int n= arr.length;
        int k=4;
        System.out.println(fjWithKRec(n-1, k, arr));

        int[] dp = new int[n+1];  // step 1 create dp
        Arrays.fill(dp,-1);
        System.out.println(fjWithKRecMemo(n-1, k, arr, dp));

        System.out.println(fjWithKDP(n, k, arr));

    }

    private static int fjWithKDP(int n,int k, int[] arr) {
        int dp[] =new int[n+1];
        dp[0]=0;
        for(int i=1; i<n; i++){
            int min=Integer.MAX_VALUE;
            for(int j=1; j<=k; j++){
                if(i-j>=0) {
                    int s = dp[i-j] + Math.abs(arr[i] - arr[i - j]);
                    min = Math.min(min, s);
                }
            }
            dp[i]=min;
        }
        return dp[n-1];
    }

    private static int fjWithKRecMemo(int n, int k, int[] arr, int[] dp) {
        if(n==0)return 0;

        if(dp[n]!=-1)return dp[n];
        int min=Integer.MAX_VALUE;
        for(int i=1; i<=k; i++){
            if(n-i>=0) {
                int s = fjWithKRec(n - i, k, arr) + Math.abs(arr[n] - arr[n - i]);
                dp[i] = min = Math.min(min, s);
            }
        }
        return min;
    }


    private static int fjWithKRec(int n, int k, int[] arr) {
        if(n==0)return 0;

        int min=Integer.MAX_VALUE;
        for(int i=1; i<=k; i++){
            if(n-i>=0) {
                int s = fjWithKRec(n - i, k, arr) + Math.abs(arr[n] - arr[n - i]);
                min = Math.min(min, s);
            }
        }
        return min;
    }
}
