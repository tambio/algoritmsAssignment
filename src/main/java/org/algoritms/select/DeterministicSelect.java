package org.algoritms.select;
import java.util.Arrays;

public class DeterministicSelect {
    private long comparisons = 0;

    public int select(int[] arr, int k) {
        if (arr == null || k < 1 || k > arr.length) {
            throw new IllegalArgumentException("Invalid input");
        }
        return selectHelper(arr, 0, arr.length - 1, k - 1);
    }

    private int selectHelper(int[] arr, int left, int right, int k) {
        if (left == right) return arr[left];

        int pivot = medianOfMedians(arr, left, right);
        int pivotIndex = partition(arr, left, right, pivot);

        if (k == pivotIndex) return arr[k];
        else if (k < pivotIndex) return selectHelper(arr, left, pivotIndex - 1, k);
        else return selectHelper(arr, pivotIndex + 1, right, k);
    }

    private int partition(int[] arr, int left, int right, int pivot) {
        int pivotIndex = left;
        for (int i = left; i <= right; i++) {
            if (arr[i] == pivot) {
                pivotIndex = i;
                break;
            }
        }
        swap(arr, pivotIndex, right);

        int storeIndex = left;
        for (int i = left; i < right; i++) {
            comparisons++;
            if (arr[i] < pivot) {
                swap(arr, storeIndex, i);
                storeIndex++;
            }
        }
        swap(arr, storeIndex, right);
        return storeIndex;
    }

    private int medianOfMedians(int[] arr, int left, int right) {
        int n = right - left + 1;
        if (n <= 5) {
            Arrays.sort(arr, left, right + 1);
            return arr[left + n / 2];
        }

        int numMedians = (n + 4) / 5;
        int[] medians = new int[numMedians];

        for (int i = 0; i < numMedians; i++) {
            int subLeft = left + i * 5;
            int subRight = Math.min(subLeft + 4, right);
            Arrays.sort(arr, subLeft, subRight + 1);
            medians[i] = arr[subLeft + (subRight - subLeft) / 2];
        }

        return medianOfMedians(medians, 0, numMedians - 1);
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public long getComparisons() {
        return comparisons;
    }
}