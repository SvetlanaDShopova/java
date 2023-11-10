package sds.bubble_sort;

import java.util.Arrays;

/**
 *  For each iteration, every element
 *  is compared with its neighbor and swapped if they are not in order.
 *  This results in smaller elements bubbling to
 *  the beginning ot the list
 *
 *  Time complexity - o(N^2)
 *
 *  Space complexity - O(1)
 *
 *  It is adaptive  - could break earlier when
 *                  nothing for swapping left
 *  It is stable sort
 *
 *  It makes O(N^2) comparison and O(N^2) swaps
 *
 *
 *
 */
public class BubbleSort {

    private static int listToSort[] = new int[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

    public static void main(String[] args) {
        System.out.println(Arrays.toString(listToSort)
                .replace("[", "")
                .replace("]", ""));
        bubbleSort(listToSort);
    }



    public static void swap(int[] listToSort, int iIndex, int jIndex) {
        int temp = listToSort[iIndex];
        listToSort[iIndex] = listToSort[jIndex];
        listToSort[jIndex] = temp;
    }

    public static void bubbleSort(int[] listToSort) {
        for (int i = 0; i < listToSort.length; i++) {
            //flag to show if loop could be broken early
            boolean swapped = false;
            for (int j = 0; j < listToSort.length -1 - i; j++) {
                if (listToSort[j] > listToSort[j + 1]) {
                    swap(listToSort, j +1 , j);
                    swapped = true;
                }
            }
            System.out.println(Arrays.toString(listToSort)
                    .replace("[", "")
                    .replace("]", ""));
            if (!swapped) {
                break;
            }
        }
    }
}
