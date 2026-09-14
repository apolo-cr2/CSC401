import java.util.Random;

public class SortAnalysis {

    public static void main(String[] args) {
        System.out.println("Sort Analysis Algorithm");
        int size = 2000; // size. Change to find runtime.
        int[] array = new int[size];
        
        fillArrayRand(array, size);
        System.out.printf("Array size: %d - Count: %d%n", size, sortAnalysis(array, size));
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