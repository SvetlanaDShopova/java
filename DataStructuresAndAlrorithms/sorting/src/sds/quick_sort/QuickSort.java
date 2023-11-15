package sds.quick_sort;

import java.util.Arrays;

/**
 * This is a divide and conquer algorithm which partition a list on every step.
 * The partition is not based on the length or an artificial index - it is based o a pivot
 * The pivot is an element from the list
 *
 *  Average time complexity - O(NLOGN)
 *
 *  Not adaptive sort
 *
 *  Space complexity - O(N)
 *
 *  It is not stable
 */
public class QuickSort {
    private static int listToSort[] = new int[] {6, 5, 11, 4, 2, 5, 10, 3, 7, 8, 9};

    public static void main(String[] args) {
        System.out.println(Arrays.toString(listToSort)
                .replace("[", "")
                .replace("]", ""));
        quickSort(listToSort, 0, listToSort.length - 1);
        System.out.println(Arrays.toString(listToSort)
                .replace("[", "")
                .replace("]", ""));
    }


    public static void swap(int[] listToSort, int iIndex, int jIndex) {
        int temp = listToSort[iIndex];
        listToSort[iIndex] = listToSort[jIndex];
        listToSort[jIndex] = temp;
    }

    public static void quickSort(int[] listToSort, int low, int high) {
        if (low >= high) {
            return;
        }
        int pivotIndex = partition(listToSort, low, high);
        quickSort(listToSort, low, pivotIndex - 1);
        quickSort(listToSort, pivotIndex + 1, high);
    }

    public static int partition(int[] listToSort, int low, int high) {
        int pivot = listToSort[low];
        int l = low;
        int h = high;
        while (l < h) {
            while (listToSort[l] <= pivot && l < h) {
                l++;
            }
            while (listToSort[h] > pivot) {
                h--;
            }
            if (l < h) {
                swap(listToSort, l, h);
            }
        }
        swap(listToSort, low, h);

        System.out.println("Pivot: " + pivot);
        System.out.println(Arrays.toString(listToSort)
                .replace("[", "")
                .replace("]", ""));
        return h;
    }
}
