package recursion;

public class PrintNameNTimes {

    public static void main(String[] args) {
        int n=4;
        printName(n);
    }

    private static void printName(int n) {
        if(n<1)return;
        System.out.print("Amit ");
        printName(n-1);
    }
}
