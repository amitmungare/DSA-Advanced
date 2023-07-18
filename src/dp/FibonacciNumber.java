package dp;

public class FibonacciNumber {

//    https://takeuforward.org/data-structure/dynamic-programming-introduction/
    public static void main(String[] args) {
        int n=1;
        System.out.println(fibRecursion( n));
        System.out.println(fibDP(n));
        System.out.println(fibDPWithSpaceOpt(n));
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

    private static int fibDP(int n) {
        int[] dp = new int[n+1];
        dp[0]=0;
        dp[1]=1;

        for(int i=2; i<=n; i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    private static int fibRecursion(int n) {
        if(n==0)return 0;
        if(n==1)return 1;
        return fibRecursion(n-1)+fibRecursion(n-2);
    }



}
