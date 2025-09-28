package org.algoritms.sorting;

public class MergeSort {
    private long compar = 0;

    public void sort(int[] array) {
        if (array == null || array.length <= 1) return;
        mergeSort(array, 0, array.length - 1, new int[array.length]);
    }

    private void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left >= right) return;

        int mid = (left + right) / 2;
        mergeSort(arr, left, mid, temp);
        mergeSort(arr, mid + 1, right, temp);
        merge(arr, left, mid, right, temp);
    }

    private void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left, j = mid + 1, k = left;

        while (i <= mid && j <= right) {
            compar++;
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (i = left; i <= right; i++) {
            arr[i] = temp[i];
        }
    }

    public long getComparisons() {
        return compar;
    }
}