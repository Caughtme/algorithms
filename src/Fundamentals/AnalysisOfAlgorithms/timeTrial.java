package Fundamentals.AnalysisOfAlgorithms;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Random;

import static Fundamentals.AnalysisOfAlgorithms.E16_ClosestPair.closestPair;

public class timeTrial {
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
        double[] d = new double[N];
        for (int i = 0; i < N; i++) {
            d[i] = rand.nextDouble();
        }
        Stopwatch stopwatch = new Stopwatch();
        double[] closestPair1 = closestPair(d);
        return stopwatch.elapsedTime();
    }

    public static void main(String[] args) {
        double prev = timeTrial(125);
        for (int N = 250; N <= 10000000; N += N) {
            double time = timeTrial(N);
            StdOut.printf("%6d %7.1f", N, time);
            StdOut.printf("%5.1f\n", time / prev);
            prev = time;
        }
    }
}
