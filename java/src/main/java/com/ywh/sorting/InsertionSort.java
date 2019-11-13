package com.ywh.sorting;

/**
 * 插入排序
 * [排序] [稳定排序]
 *
 * @author ywh
 * @since 13/11/2019
 */
public class InsertionSort {

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * i: [1, n)
     * j: [i - 1, 0)
     *
     * Time: O(n^2), Space: O(1)
     *
     * @param arr
     */
    public void sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1, cur = arr[i + 1];
            while (j >= 0 && arr[j] > cur) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = cur;
        }
    }

}
