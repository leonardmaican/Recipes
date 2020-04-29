package ro.gr5;

public class ForLoop {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i<10; ++i) {
            System.out.println(sum);
            sum += i;

        }
        System.out.println(sum);
    }
}
