package org.algoritms.sorting;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MergeSortTest {

    @Test
    void testMergeSortBasic() {
        int[] arr = {5, 2, 9, 1, 5, 6};
        MergeSort sorter = new MergeSort();
        sorter.sort(arr);
        assertArrayEquals(new int[]{1, 2, 5, 5, 6, 9}, arr);
        System.out.println("Comparisons: " + sorter.getComparisons());
    }
}