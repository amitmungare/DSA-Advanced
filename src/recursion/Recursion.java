package recursion;

public class Recursion {
    public static void main(String[] args) {
        int n=1;
        recursionCall(n);
    }

    private static void recursionCall(int n) {
        if(n>4)return;
        System.out.print(n +" ");
        n++;
        recursionCall(n);
    }
}
