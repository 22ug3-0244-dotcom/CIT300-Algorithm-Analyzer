import java.util.Random;
import java.text.DecimalFormat;

public class Member3_BubbleSort {

    // Bubble Sort Algorithm
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) break;
        }
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

        System.out.println("=== Member 3: Bubble Sort ===");
        System.out.println("Input Size | Time (ms)");
        System.out.println("------------------------");

        for (int size : sizes) {
            int[] arr = generateArray(size);

            long start = System.nanoTime();
            bubbleSort(arr);
            long end = System.nanoTime();

            double timeMs = (end - start) / 1_000_000.0;
            System.out.printf("%-10d | %s ms%n", size, df.format(timeMs));
        }
    }
}