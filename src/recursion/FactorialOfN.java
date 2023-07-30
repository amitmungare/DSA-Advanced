package recursion;

public class FactorialOfN {

    public static void main(String[] args) {
        int n=4;
        System.out.println(facOfN(n));
    }

    private static int facOfN(int n) {
        if(n==1)return 1;
        return n * facOfN(n-1);
    }

}
