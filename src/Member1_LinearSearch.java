import java.util.Random;
import java.text.DecimalFormat;

public class Member1_LinearSearch {

    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) return i;
        }
        return -1;
    }

    public static int[] generateArray(int size) {
        Random r = new Random(100);
        int[] a = new int[size];
        for (int i = 0; i < size; i++) a[i] = r.nextInt(10000);
        return a;
    }

    public static void main(String[] args) {

        int[] sizes = {100, 500, 1000};
        DecimalFormat df = new DecimalFormat("#0.000");

        System.out.println("=== Member 1: Linear Search ===");
        System.out.println("Input Size | Time (ms)");
        System.out.println("------------------------");

        for (int size : sizes) {
            int[] arr = generateArray(size);
            int key = arr[size / 2];

            long start = System.nanoTime();
            linearSearch(arr, key);
            long end = System.nanoTime();

            double t = (end - start) / 1_000_000.0;
            System.out.printf("%-10d | %s ms%n", size, df.format(t));
        }
    }
}
