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

        
    }

    // -------------------------------- Member 3: Bubble Sort --------------------------------
    static class BubbleSort {
       
    }

    // -------------------------------- Member 4: Quick Sort --------------------------------
    static class QuickSort {

        
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
                    
                    break;


                case "4":
                    // TODO: Member 3 call Bubble Sort for all 3 sizes
                    break;

                case "5":
                    // TODO: Member 4 call Quick Sort for all 3 sizes
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
