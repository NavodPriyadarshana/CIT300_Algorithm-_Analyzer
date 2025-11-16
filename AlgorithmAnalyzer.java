// AlgorithmAnalyzer.java
// CIT300 - Graded Practical Assignment 3
// Algorithm Analyzer – Time & Complexity Measurement
// Team: Navod, Malisha, Yasiru, Pulindu

import java.util.*;

public class AlgorithmAnalyzer {

    static int[] arr100, arr500, arr1000; // Global arrays accessible to all methods

    // Generate random array
    static int[] generateArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) arr[i] = rand.nextInt(1000);
        return arr;
    }

    // Result class for storing results
    static class Result {
        String algorithm;
        int size;
        double time;
        boolean found;

        Result(String algorithm, int size, double time, boolean found) {
            this.algorithm = algorithm;
            this.size = size;
            this.time = time;
            this.found = found;
        }
    }

    // -------------------------------- Member 1: Linear Search --------------------------------
    static class LinearSearch {
       
    }

    // -------------------------------- Member 2: Binary Search --------------------------------
    static class BinarySearch {

        static int binarySearch(int[] arr, int target) {
            int left = 0, right = arr.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (arr[mid] == target) return mid;
                if (arr[mid] < target) left = mid + 1;
                else right = mid - 1;
            }
            return -1;
        }

        static Result test(int[] arr, int target, int size) {
            int[] sorted = Arrays.copyOf(arr, arr.length);
            Arrays.sort(sorted);
            long start = System.nanoTime();
            boolean found = binarySearch(sorted, target) != -1;
            long end = System.nanoTime();
            return new Result("Binary Search", size, (end - start) / 1e6, found);
        }
    }

    // -------------------------------- Member 3: Bubble Sort --------------------------------
    static class BubbleSort {
       
    }

    // -------------------------------- Member 4: Quick Sort --------------------------------
    static class QuickSort {
    static void quick(int[] a, int l, int r) {
        if (l < r) {
            int p = a[r], i = l - 1;
            for (int j = l; j < r; j++) if (a[j] <= p) {
                i++; int t = a[i]; a[i] = a[j]; a[j] = t;
            }
            int t = a[i + 1]; a[i + 1] = a[r]; a[r] = t;
            int pivot = i + 1;
            quick(a, l, pivot - 1); quick(a, pivot + 1, r);
        }
    }

    static Result test(int[] arr, int size) {
        int[] a = Arrays.copyOf(arr, arr.length);
        long start = System.nanoTime();
        quick(a, 0, a.length - 1);
        long end = System.nanoTime();
        return new Result("Quick Sort", size, (end - start) / 1e6, true);
    }
}

    // -------------------------------- Integration Menu --------------------------------
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.println("\n=== Algorithm Analyzer Menu ===");
                System.out.println("1. Generate arrays (100, 500, 1000)");
                System.out.println("2. Perform Linear Search");
                System.out.println("3. Perform Binary Search");
                System.out.println("4. Perform Bubble Sort");
                System.out.println("5. Perform Quick Sort");
                System.out.println("0. Exit");
                System.out.print("Enter choice: ");
                String choice = sc.nextLine();

                switch (choice) {

                    case "1":
                        arr100 = generateArray(100);
                        arr500 = generateArray(500);
                        arr1000 = generateArray(1000);
                        System.out.println("Arrays generated successfully!");
                        break;


                case "2":
                    // TODO: Member 1 call Linear Search for all 3 sizes
                    break;

                case "3":
                    if (arr100 == null) {
                            System.out.println("Please generate arrays first.");
                            break;
                        }
                        System.out.print("Enter target to search: ");
                        int t2 = Integer.parseInt(sc.nextLine());
                        System.out.println("--- Binary Search Results ---");
                        print(BinarySearch.test(arr100, t2, 100));
                        print(BinarySearch.test(arr500, t2, 500));
                        print(BinarySearch.test(arr1000, t2, 1000));
                        break;




                case "4":
                    // TODO: Member 3 call Bubble Sort for all 3 sizes
                    break;

                case "5":
                    System.out.println("--- Quick Sort Results ---");
                        print(QuickSort.test(arr100, 100));
                        print(QuickSort.test(arr500, 500));
                        print(QuickSort.test(arr1000, 1000));
                        break;

                case "0":
                        System.out.println("Exiting Program...");
                        return;

                    default:
                        System.out.println("Invalid option. Try again.");
                }
            }
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    static void print(Result r) {
        System.out.printf(
            "%-15s Size: %-5d Time: %-10.6f ms  Result: %s%n",
            r.algorithm, r.size, r.time, r.found ? "FOUND" : "NOT FOUND"
        );
    }
}
