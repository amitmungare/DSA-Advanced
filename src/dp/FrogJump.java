package dp;

import java.util.Arrays;

public class FrogJump {
    public static void main(String[] args) {

        int arr[] = {30,10,60,10,60,50};
        int n= arr.length;
        System.out.println(fjRec(n-1, arr));

        int[] dp = new int[n+1];  // step 1 create dp
        Arrays.fill(dp,-1);
        System.out.println(fjRecMemo(n-1, arr, dp));


        System.out.println(fjDP(n, arr));

        System.out.println(fjSpaceOpt(n, arr));

    }

    private static int fjSpaceOpt(int n, int[] arr) {
        int prev1=0;
        int prev2=0;

        for(int i=1; i<n; i++){
            int l= prev1+Math.abs(arr[i]- arr[i-1]);
            int r=Integer.MAX_VALUE;
            if(i>1) r= prev2+Math.abs(arr[i]- arr[i-2]);
            int curr = Math.min(l,r);
            prev2=prev1;
            prev1=curr;
        }
        return prev1;
    }

    private static int fjDP(int n, int[] arr) {
        int[] dp = new int[n];
        dp[0]=0;

        for(int i=1; i<n; i++){
            int l= dp[i-1]+Math.abs(arr[i]- arr[i-1]);
            int r=Integer.MAX_VALUE;
            if(i>1) r= dp[i-2]+Math.abs(arr[i]- arr[i-2]);
            dp[i] = Math.min(l,r);
        }
        return dp[n-1];

    }

    private static int fjRecMemo(int n, int[] arr, int dp[]) {

        if(n==0)return 0;

        if(dp[n]!=-1)return dp[n]; // step 3 check if it already computed   
        int l = fjRec(n-1, arr)+Math.abs(arr[n]-arr[n-1]);
        int r=Integer.MAX_VALUE;
        if(n>1) r = fjRec(n - 2, arr) + Math.abs(arr[n] - arr[n - 2]);

        return dp[n] = Math.min(l,r); // step 2 store it at index
    }

    private static int fjRec(int n, int[] arr) {

        if(n==0 || n==1)return 0;

        int l=fjRec(n-1, arr)+Math.abs(arr[n]-arr[n-1]);
        int r= fjRec(n - 2, arr) + Math.abs(arr[n] - arr[n - 2]);

        return Math.min(l,r);
    }
}
