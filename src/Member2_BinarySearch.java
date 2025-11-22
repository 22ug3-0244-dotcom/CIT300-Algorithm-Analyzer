import java.util.Random;
import java.text.DecimalFormat;
import java.util.Arrays;

public class Member2_BinarySearch {

    public static int binarySearch(int[] arr, int key) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == key) return mid;
            if (arr[mid] < key) left = mid + 1;
            else right = mid - 1;
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

        System.out.println("=== Member 2: Binary Search ===");
        System.out.println("Input Size | Time (ms)");
        System.out.println("------------------------");

        for (int size : sizes) {
            int[] arr = generateArray(size);
            Arrays.sort(arr);

            int key = arr[size / 2];

            long start = System.nanoTime();
            binarySearch(arr, key);
            long end = System.nanoTime();

            double t = (end - start) / 1_000_000.0;
            System.out.printf("%-10d | %s ms%n", size, df.format(t));
        }
    }
}