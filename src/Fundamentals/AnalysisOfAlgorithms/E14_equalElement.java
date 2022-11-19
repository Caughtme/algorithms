package Fundamentals.AnalysisOfAlgorithms;

import java.util.Arrays;

public class E14_equalElement {
    public static void printElement(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        compare(arr1, arr2);
    }

    public static void compare(int[] arr1, int[] arr2)
    {
        int i = 0;
        Integer previousEle = null;
        while (i < arr1.length) {
            int equal = isEqual(arr1, arr2, i, i);
            if (equal != -1) i = equal + 1;
            if (previousEle == null || (equal >= 0 && previousEle != arr1[equal])) {
                previousEle = arr1[equal];
                System.out.print(previousEle + " ");
            }
        }
    }

    public static int isEqual(int[] arr1, int[] arr2, int index1, int index2)
    {
        if (index1 < arr1.length && index2 < arr2.length) {
            if (arr1[index1] < arr2[index2]) {
                int index = index1 + 1;
                return isEqual(arr1, arr2, index, index2);
            }
            else if ((arr1[index1] > arr2[index2])) {
                int index = index2 + 1;
                return isEqual(arr1, arr2, index1, index);
            }
            else return index1;
        }
        return -1;
    }

    public static void main(String[] args) {
        // int[] arr1 = {2, 32, 43, 3, 12, 23};
        ///int[] arr2 = {3, 4, 2, 3, 43, 12};
        int[] array1 = { 0, 1, 2, 2, 5, 6, 6, 8, 25, 25 };
        int[] array2 = { -2, 0, 1, 2, 2, 2, 3, 4, 5, 10, 20, 25, 25 };
        long l = System.currentTimeMillis();
        printElement(array1, array2);
        long l1 = System.currentTimeMillis();
        System.out.println((l1 - l)*100000000);
    }
}
