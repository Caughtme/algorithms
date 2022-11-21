package Fundamentals.AnalysisOfAlgorithms;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;
import java.util.Random;

public class E14_equalElement {
    public static void printElement(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        compare(arr1, arr2);
    }

    public static void compare(int[] arr1, int[] arr2)
    {
        int i = 0;
        int equal;
        Integer previousEle = null;
        while (i < arr1.length) {
            equal = isEqual(arr1, arr2, i, i);
            if (equal != -1) i = equal + 1;
            else {System.out.println("none equal value exists."); break;}
            if (previousEle == null || (previousEle != arr1[equal])) {
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

    public static double timeTrial(int N)
    {
        int Max = 1000;
        Random rand = new Random(47);
        int[] a = new int[N];
        int[] b = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = rand.nextInt(Max);
            b[i] = rand.nextInt(Max);
        }
        Stopwatch stopwatch = new Stopwatch();
        printElement(a, b);
        return stopwatch.elapsedTime();
    }
    public static void main(String[] args) {
        // int[] arr1 = {2, 32, 43, 3, 12, 23};
        ///int[] arr2 = {3, 4, 2, 3, 43, 12};
        double prev = timeTrial(125);
        for (int N = 250; N <= 100000; N += N) {
            double time = timeTrial(N);
            StdOut.printf("%6d %7.1f", N, time);
            StdOut.printf("%5.1f\n", time / prev);
            prev = time;
        }
    }
}
