package recursion;

import java.util.ArrayList;

public class countTheNumberOfSubsequenceEqualToSum {

    public static void main(String[] args) {
        int[] arr = {1,2,1};
        int sum=2;
        System.out.println(sub(0, 0, sum, arr));
    }

    private static int sub(int i, int sumCount, int sum, int[] arr) {

        if(i==arr.length){
            if(sum==sumCount)return 1;
            else return 0;
        }

        sumCount+=arr[i];
        int l = sub(i+1, sumCount, sum, arr);

        sumCount-=arr[i];
        int r = sub(i+1, sumCount, sum, arr);

        return l+r;
    }
}
