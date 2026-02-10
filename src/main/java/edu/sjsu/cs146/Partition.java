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
    /*
     * Hoare partition:
     * - Pivot is the first element.
     * - Two pointers move inward and we swap out of place values.
     * - Returns a split index (pivot is not guaranteed to end in final position).
     */
    public static int partitionHoare(int[] a, int low, int high) {

        if (a == null)
            throw new IllegalArgumentException("Array is null");

        if (a.length == 0)
            return -1;

        int pivot = a[low];
        int i = low - 1;
        int j = high + 1;

        while (true) {

            // Move i right until a[i] >= pivot
            do { i++; } while (a[i] < pivot);

            // Move j left until a[j] <= pivot
            do { j--; } while (a[j] > pivot);

            // If pointers crossed, j is the split point
            if (i >= j)
                return j;

            swap(a, i, j);
        }
    }

}
