package recursion;

import java.util.ArrayList;

public class PrintOneSubsequenceEqualToSum {
    public static void main(String[] args) {
        int[] arr = {1,2,1};
        int sum=2;
        sub(0, 0, sum, new ArrayList<Integer>(), arr);
    }

    private static boolean sub(int i, int sumCount, int sum, ArrayList<Integer> list, int[] arr) {

        if(i==arr.length){
            if(sum==sumCount){
                for(int k:list) System.out.print(k+" ");
                System.out.println();
                return true;
            }
            else return false;
        }

        sumCount+=arr[i];
        list.add(arr[i]);
        if(sub(i+1, sumCount, sum, list, arr))return true;

        sumCount-=arr[i];
        list.remove(list.size()-1);
        if(sub(i+1, sumCount, sum, list, arr))return true;

        return false;
    }

}
