package dp;

import java.util.Arrays;

public class HouseRobber2 {

    public static void main(String[] args) {
//        int[] arr={1, 2, 2, 3, 4, 8, 1};
//        int[] arr={1, 2, 4, 9};
//        int n=arr.length;
//        System.out.println("rec      "+rec(n-1, arr));
//
//        int[] dp = new int[n+1];
//        Arrays.fill(dp,-1);
//        System.out.println("rec memo "+recMemo(n-1, arr, dp));
//
//        System.out.println("DP       "+dp(n, arr));
//
//        System.out.println("Spc opt  "+spOpt(n, arr));


        int arr[]={2, 3, 2};
        System.out.println(rob(arr));

    }

    public static int rob(int[] arr) {
        int n=arr.length;
        int[] arr1=new int[n-1];
        int[] arr2=new int[n-1];

        for(int i=0; i<n; i++){
            if(i!=0)arr1[i-1]=arr[i];
            if(i!=n-1)arr2[i]=arr[i];
        }

        int ans1 = spOpt(arr1);
        int ans2 = spOpt(arr2);

        return Math.max(ans1, ans2);

    }

    private static int spOpt(int[] arr) {

        int prev1=arr[0];
        int prev2=0;

        for(int i=1; i< arr.length; i++) {
            int curr=Math.max(prev1,arr[i]+prev2);
            prev2=prev1;
            prev1=curr;
        }
        return prev1;
    }
}
