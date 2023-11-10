package sds.insertion_sort;

import java.util.Arrays;

/**
 *  Time complexity - 0(N^2)
 *  Space Complexity - O(1)
 *  Stable sort
 *  Adaptive algorithm
 *
 *   It makes (N^2) comparison and 0(N^2) swaps
 *
 */
public class InsertionSort {
    private static int listToSort[] = new int[] {3, 5, 6, 8, 10, 1, 2, 4, 7, 9};

    public static void main(String[] args) {
        System.out.println(Arrays.toString(listToSort)
                .replace("[", "")
                .replace("]", ""));
        insertionSort(listToSort);
    }



    public static void swap(int[] listToSort, int iIndex, int jIndex) {
        int temp = listToSort[iIndex];
        listToSort[iIndex] = listToSort[jIndex];
        listToSort[jIndex] = temp;
    }

    public static void insertionSort(int[] listToSort) {
        for (int i = 0; i < listToSort.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (listToSort[j] < listToSort[j - 1]) {
                    swap(listToSort, j, j - 1);
                } else {
                    break;
                }
                System.out.println(Arrays.toString(listToSort)
                        .replace("[", "")
                        .replace("]", ""));
            }
        }
    }
}
