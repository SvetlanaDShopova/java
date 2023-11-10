package sds.selection_sort;

import java.util.Arrays;

/**
 *  At each iteration 1 element is selected
 *  and compared with every other element in the
 *  list to find the smallest one
 *
 *  It is not a stable sort entities that are equal might be re-arranged
 *
 *  Time Complexity O(N^2)
 *  Space complexity - O(1)
 *
 *  It makes O(N^2) comparisons and O(N) swaps
 *
 *  The sort is not adaptive - cannot confirm that list is sorted until the last element
 */
public class SelectionSort {

    private static int listToSort[] = new int[] {4, 5, 6, 2, 1, 7, 10, 3, 8, 9};

    public static void main(String[] args) {
        System.out.println(Arrays.toString(listToSort).replace("[","")
                .replace("]", ""));
        sort(listToSort);
    }

    public static void swap(int[] listToSort, int iIndex, int jIndex) {
        int temp = listToSort[iIndex];
        listToSort[iIndex] = listToSort[jIndex];
        listToSort[jIndex] = temp;
    }

    public static void sort(int[] listToSort) {
        for (int i = 0; i < listToSort.length; i++) {
            for (int j = i + 1; j < listToSort.length; j++) {
                if (listToSort[i] > listToSort[j]) {
                    swap(listToSort, i, j);
                }
            }
            System.out.println(Arrays.toString(listToSort)
                    .replace("[","")
                    .replace("]", ""));
        }
    }
}
