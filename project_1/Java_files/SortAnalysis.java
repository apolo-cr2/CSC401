import java.util.Random;

public class SortAnalysis {

    public static void main(String[] args) {
        System.out.println("Sort Analysis Algorithm");
        int size = 7000; // size. Change to find runtime.
        int finalCount;
        int[] array = new int[size];

        //Randomly filling array:
        fillArrayRand(array, size);
        //Count for sortAnalysis - with time measurement
        long startTime = System.nanoTime(); 
        finalCount = sortAnalysis(array, size);
        long endTime = System.nanoTime();
        double duration = (endTime - startTime);    //nanoseconds duration

        //Print
        System.out.printf("Array size: %d \n- Count: \t\t%d\n", size, finalCount);
        System.out.printf("- Duration(ns): \t%.0f\n", duration);
    }

    // sortAnalysis Method
    // Input: array[0...n-1] of n orderable elements
    // Output: Total # of key comparisons made
    public static int sortAnalysis(int[] A, int n) {
        int count = 0;
        for (int i = 1; i <= n - 1; i++) {
            int v = A[i];
            int j = i - 1;
            while (j >= 0 && A[j] > v) {
                // wrong count++ location
                A[j + 1] = A[j];
                j = j - 1;
                count++; // correct location
            }
            A[j + 1] = v;
        }
        // Print test
        // for (int i = 0; i < n; i++) {
        //     System.out.printf("A[%d]:\t%d%n", i, A[i]);
        // }
        return count;
    }

    public static void fillArrayRand(int[] array, int size) {
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt();
        }
    }
}