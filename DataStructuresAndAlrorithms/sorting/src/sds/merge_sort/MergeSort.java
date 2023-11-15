package sds.merge_sort;

import java.util.Arrays;

/**
 * This follows the divide and conquer approach to create smaller sub-problems. *
 * A list is broken down into smaller and smaller parts recursively.
 * At some point there will be a list of length one, considered a sorted list
 * then merge the sorted lists together to get the fully sorted list
 *
 * time complexity - O(NLogN)
 * space complexity - O(N)
 *
 * It is not adaptive
 *
 * Stable sort
 */
public class MergeSort {
    private static int listToSort[] = new int[] {5, 4, 6, 2, 1, 10, 7, 3, 8, 9};

    public static void main(String[] args) {
        System.out.println(Arrays.toString(listToSort)
                .replace("[", "")
                .replace("]", ""));
        mergeSort(listToSort);
    }

    public static void mergeSort(int[] listToSort) {
        if (listToSort.length == 1) {
            return;
        }

        int midIndex = listToSort.length / 2 + listToSort.length % 2;
        int[] listFirstHalf = new int[midIndex];
        int[] listSecondHalf = new int[listToSort.length - midIndex];
        split(listToSort, listFirstHalf, listSecondHalf);

        mergeSort(listFirstHalf);
        mergeSort(listSecondHalf);

        merge(listToSort, listFirstHalf, listSecondHalf);
        System.out.println(Arrays.toString(listToSort)
                .replace("[", "")
                .replace("]", ""));
    }

    public static void split(int[] listToSort, int[] listFirstHalf, int[] listSecondHalf) {
        int index = 0;
        int secondHalfStartIndex = listFirstHalf.length;
        for (int elements : listToSort) {
            if (index < secondHalfStartIndex) {
                listFirstHalf[index] = listToSort[index];
            } else {
                listSecondHalf[index - secondHalfStartIndex] = listToSort[index];
            }
            index++;
        }
    }

    public static void merge(int[] listToSort, int[] listFirstHalf, int[] listSecondHalf) {
        int mergeIndex = 0;
        int firstHalfIndex = 0;
        int secondHalfIndex = 0;

        while (firstHalfIndex < listFirstHalf.length && secondHalfIndex < listSecondHalf.length) {
            if (listFirstHalf[firstHalfIndex] < listSecondHalf[secondHalfIndex]) {
                listToSort[mergeIndex] = listFirstHalf[firstHalfIndex];
                firstHalfIndex++;
            } else if (secondHalfIndex < listSecondHalf.length) {
                listToSort[mergeIndex] = listSecondHalf[secondHalfIndex];
                secondHalfIndex++;
            }
            mergeIndex++;
        }

        if (firstHalfIndex < listFirstHalf.length) {
            while (mergeIndex < listToSort.length) {
                listToSort[mergeIndex++] = listFirstHalf[firstHalfIndex++];
            }
        }
        if (secondHalfIndex < listSecondHalf.length) {
            while (mergeIndex < listToSort.length) {
                listToSort[mergeIndex++] = listSecondHalf[secondHalfIndex++];
            }
        }
    }
}
