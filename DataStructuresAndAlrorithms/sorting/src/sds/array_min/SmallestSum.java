package sds.array_min;

public class SmallestSum {

    public static void main(String[] args) {
        int[] arr = new int[] {1, 4, 8, 12, 45, 46, 1, 2, 16};

        System.out.println(getSmallestSum(arr));
    }

    private static int getSmallestSum(int[] arr){
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] <= min){
                secondMin = min;
                min = arr[i];
            } else if (arr[i] < secondMin && arr[i] != min){
                secondMin = arr[i];
            }
        }

        return min + secondMin;
    }
}
