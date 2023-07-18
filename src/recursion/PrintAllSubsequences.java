package recursion;

import java.util.ArrayList;

public class PrintAllSubsequences {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        sub(0, new ArrayList<Integer>(), arr);
    }

    private static void sub(int i, ArrayList<Integer> ds, int[] arr) {

        if(i==arr.length){
            for(int k:ds) System.out.print(k+" ");
            System.out.println();
            return;
        }

        ds.add(arr[i]);
        sub(i+1, ds, arr);
        ds.remove(ds.size()-1);
        sub(i+1, ds, arr);
    }


}
