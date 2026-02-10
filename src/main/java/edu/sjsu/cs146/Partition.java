package edu.sjsu.cs146;

public class Partition {

    // Simple helper method to swap two numbers in the array
    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /*
     * Lomuto partition:
     * - Choose the last element as the pivot.
     * - Move all elements <= pivot to the left side.
     * - At the end, put the pivot in its correct position.
     * - Return the pivot index.
     */
    public static int partitionLomuto(int[] a, int low, int high) {

        if (a == null)
            throw new IllegalArgumentException("Array is null");

        // If array is empty, nothing to do
        if (a.length == 0)
            return -1;

        int pivot = a[high];   // last element is pivot
        int i = low - 1;       // keeps track of smaller elements

        for (int j = low; j < high; j++) {
            if (a[j] <= pivot) {
                i++;
                swap(a, i, j);
            }
        }

        // Place pivot after the smaller elements
        swap(a, i + 1, high);

        return i + 1;
    }
}
