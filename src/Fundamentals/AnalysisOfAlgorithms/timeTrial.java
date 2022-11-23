package Fundamentals.AnalysisOfAlgorithms;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class timeTrial {
    public static double timeTrial(int N)
    {
        int Max = 10;
        int[] a = new int[N];
        int[] b = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniformInt(-Max, Max);
            b[i] = StdRandom.uniformInt(-Max, Max);
        }
        int i1 = StdRandom.uniformInt(-10, 10);
        double[] d = new double[N];
        for (int i = 0; i < N; i++) {
            d[i] = StdRandom.uniformDouble();
        }
        Stopwatch stopwatch = new Stopwatch();
        int cnt = E15_TwoSumFaster.TwoSumFaster(a);
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
