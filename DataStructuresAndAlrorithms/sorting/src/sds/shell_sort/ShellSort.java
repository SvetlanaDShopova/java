package sds.shell_sort;

import java.util.Arrays;

/**
 * Shell sort partitions the original list into sub-lists
 * where a sub-list is made of elements separated by an "increment".
 * Each sub-list is sorted using insertion sort.
 * The increment is slowly reduced till it's 1
 *
 * Hard to say complexity since it depends on the increment value chosen.
 *
 * It is not clear what the best increment value is
 *
 * Time complexity is somewhere between O(N) and O(N^2)
 * Space complexity O(1)
 *
 * It is adaptive
 *
 *
 */

public class ShellSort {
    private static int listToSort[] = new int[]{3, 5, 6, 8, 10, 1, 2, 4, 7, 9};

    public static void main(String[] args) {
        System.out.println(Arrays.toString(listToSort)
                .replace("[","")
                .replace("]", ""));
        shellSort(listToSort);
    }

    public static void swap(int[] listToSort, int iIndex, int jIndex) {
        int temp = listToSort[iIndex];
        listToSort[iIndex] = listToSort[jIndex];
        listToSort[jIndex] = temp;
    }

    public static void insertionSort(int[] listToSort, int startIndex, int increment) {
        for (int i = startIndex; i < listToSort.length; i = i + increment) {
            for (int j = Math.min(i + increment, listToSort.length - 1);
                 j - increment >= 0;
                 j = j - increment) {
                if (listToSort[j] < listToSort[j - increment]) {
                    swap(listToSort, j, j - increment);
                } else {
                    break;
                }
                System.out.println(Arrays.toString(listToSort)
                        .replace("[","")
                        .replace("]", ""));
            }
        }
    }

    public static void shellSort(int[] listToSort) {
        int increment = listToSort.length / 2;
        while (increment >= 1) {
            for (int startIndex = 0; startIndex < increment; startIndex++) {
                insertionSort(listToSort, startIndex, increment);
            }

            increment = increment / 2;
        }
    }
}
