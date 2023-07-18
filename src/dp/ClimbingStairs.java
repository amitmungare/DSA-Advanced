package dp;

import java.util.Arrays;

public class ClimbingStairs {

    public static void main(String[] args) {
        int n=6;
        System.out.println(csRec(n));

        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(csRecWithMemo(n, dp));

        System.out.println(csTab(n));

        System.out.println(csSpaceOpt(n));
    }

    private static int csSpaceOpt(int n) {
        int prev1=1, prev2=1;

        for(int i=2; i<=n; i++){
            int curr=prev1+prev2;
            prev2=prev1;
            prev1=curr;
        }
        return prev1;
    }

    private static int csTab(int n) {
        int dp[] = new int[n+1];
        dp[0]=1;
        dp[1]=1;

        for(int i=2; i<=n; i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }


    private static int csRecWithMemo(int n, int[] dp) {
        if(n==0||n==1)return 1;
        if(dp[n]!=-1)return dp[n];
        return dp[n] = csRecWithMemo(n-1, dp)+csRecWithMemo(n-2, dp);
    }

    private static int csRec(int n) {
        if(n==0 || n==1)return 1;
        return csRec(n-1) + csRec(n-2);
    }
}
