package Fundamentals.AnalysisOfAlgorithms;

import edu.princeton.cs.algs4.BinarySearch;
import java.util.Arrays;

public class E10_binarySearch {
    public static int binarySearchForSmallest(int[] arr, int key) {
        int index = BinarySearch.indexOf(arr, key);
        if (index > 0 && arr[index - 1] == key)
            index = binarySearchForSmallest(Arrays.copyOfRange(arr, 0, index), key);
        return index;
    }

    public static int binarySearchForLargest(int[] arr, int key)
    {
        int index = BinarySearch.indexOf(arr, key);
        if (index > 0 && arr[index + 1] == key)
            index = binarySearchForLargest(Arrays.copyOfRange(arr, index+1, arr.length), key);
        return index;
    }

    public static void main(String[] args) {
        int[] arr = {8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8};
        int a = binarySearchForSmallest(arr, 8);
        int b = binarySearchForLargest(arr, 8);
        System.out.println(a);
        System.out.println(b);
    }
}
