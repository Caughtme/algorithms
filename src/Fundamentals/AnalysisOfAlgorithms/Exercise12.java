package Fundamentals.AnalysisOfAlgorithms;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;
import java.util.Random;

public class Exercise12 {

    public static void main(String[] args) {
        int[] array1 = {0, 1, 2, 2, 5, 6, 6, 8, 25, 25};
        int[] array2 = {-2, 0, 1, 2, 2, 2, 3, 4, 5, 10, 20, 25, 25};
        StdOut.print("Elements: ");
        printElementsThatAppearInBothArrays(array1, array2);
        StdOut.println("\nExpected: 0 1 2 5 25");
        double prev = timeTrial(125);
        for (int N = 250; N <= 100000; N += N) {
            double time = timeTrial(N);
            StdOut.printf("%6d %7.1f", N, time);
            StdOut.printf("%5.1f\n", time / prev);
            prev = time;
        }
    }

        private static void printElementsThatAppearInBothArrays ( int[] array1, int[] array2){
            int array1Index = 0;
            int array2Index = 0;
            Integer recentMatchedValue = null;

            while (array1Index < array1.length && array2Index < array2.length) {
                if (array1[array1Index] < array2[array2Index]) {
                    array1Index++;
                } else if (array2[array2Index] < array1[array1Index]) {
                    array2Index++;
                } else {
                    if (recentMatchedValue == null || recentMatchedValue != array1[array1Index]) {
                        // StdOut.print(array1[array1Index] + " ");
                        recentMatchedValue = array1[array1Index];
                    }
                    array1Index++;
                    array2Index++;
                }
            }
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
            Arrays.sort(a);
            Arrays.sort(b);
            printElementsThatAppearInBothArrays(a, b);
            return stopwatch.elapsedTime();
        }
}