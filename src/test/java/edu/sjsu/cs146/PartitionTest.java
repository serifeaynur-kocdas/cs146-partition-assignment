package edu.sjsu.cs146;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class PartitionTest {

    @Test
    void lomuto_sortedArray() {
        int[] a = {10,17,19,21,44,55,57,63,65,67};
        int p = Partition.partitionLomuto(a, 0, a.length - 1);

        // pivot is 67, already the largest, so it stays at the end
        assertEquals(9, p);
        assertArrayEquals(new int[]{10,17,19,21,44,55,57,63,65,67}, a);
    }

    @Test
    void lomuto_emptyArray() {
        int[] a = {};
        int p = Partition.partitionLomuto(a, 0, 0);

        assertEquals(-1, p);
        assertArrayEquals(new int[]{}, a);
    }

    @Test
    void lomuto_givenArray() {
        int[] a = {84,3,7,1,9,6,2,5};
        int p = Partition.partitionLomuto(a, 0, a.length - 1);

        // Since 5 is the pivot, the array should end up like this
        assertEquals(3, p);
        assertArrayEquals(new int[]{3,1,2,5,9,6,7,84}, a);
    }
    @Test
    void hoare_sortedArray() {
        int[] a = {10,17,19,21,44,55,57,63,65,67};
        int p = Partition.partitionHoare(a, 0, a.length - 1);

        // pivot is 10 (first element), smallest already
        assertEquals(0, p);
        assertArrayEquals(new int[]{10,17,19,21,44,55,57,63,65,67}, a);
    }

    @Test
    void hoare_emptyArray() {
        int[] a = {};
        int p = Partition.partitionHoare(a, 0, 0);

        assertEquals(-1, p);
        assertArrayEquals(new int[]{}, a);
    }

    @Test
    void hoare_givenArray() {
        int[] a = {84,3,7,1,9,6,2,5};
        int p = Partition.partitionHoare(a, 0, a.length - 1);

        // pivot is 84, so it ends up on the far right after partitioning
        assertEquals(6, p);
        assertArrayEquals(new int[]{5,3,7,1,9,6,2,84}, a);
    }

}
