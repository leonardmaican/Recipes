public class Fibonacci {
    public static void main(String[] args) {
        int a=fib(4);
        System.out.println(a);
    }

    public static int fib(int n) {
        System.out.println(n);
        if (n == 0 || n == 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }
}
