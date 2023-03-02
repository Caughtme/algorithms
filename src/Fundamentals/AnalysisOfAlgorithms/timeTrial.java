package Fundamentals.AnalysisOfAlgorithms;

import Sorting.ElementarySorts.Selection;
import Utility.Algorithm;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class timeTrial {
    private Algorithm algorithm;

    public timeTrial(Algorithm algorithm) {
        this.algorithm = algorithm;
    }

    public double timeTrial(int N)
    {
    /*
        int Max = 10;
        int[] a = new int[N];
        int[] b = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniformInt(-Max, Max);
            b[i] = StdRandom.uniformInt(-Max, Max);
        }
        int i1 = StdRandom.uniformInt(-10, 10);
    */
        Double[] d = new Double[N];
        for (int i = 0; i < N; i++) {
            d[i] = StdRandom.uniformDouble();
        }
        Stopwatch stopwatch = new Stopwatch();
        this.algorithm.run(d);
        return stopwatch.elapsedTime();
    }

    public void runTrial(int initialTimes, long MaxTimes)
    {
        double prev = timeTrial(initialTimes);
        for (int i = 2 * initialTimes; i < MaxTimes; i += i) {
            double time = timeTrial(i);
            StdOut.printf("%6d %7.1f", i, time);
            StdOut.printf("%5.1f\n", time / prev);
            prev = time;
        }
    }

    public static void main(String[] args) {
        Selection selection = new Selection();
        timeTrial timeTrial = new timeTrial(selection);
        timeTrial.runTrial(1000, 100000);
    }
}
