package Fundamentals.AnalysisOfAlgorithms;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;


public class E08_equalpairs {
    private static int countNumberOfPairs(int[] values) {
        Arrays.sort(values);

        int count = 0;
        int currentFrequency = 1;

        for (int i = 1; i < values.length; i++) {
            if (values[i] == values[i - 1]) {
                currentFrequency++;
            } else {
                if (currentFrequency > 1) {
                    count += (currentFrequency - 1) * currentFrequency / 2;
                    currentFrequency = 1;
                }
            }
        }

        if (currentFrequency > 1) {
            count += (currentFrequency - 1) * currentFrequency / 2;
        }
        return count;
    }
    public static void main(String[] args) throws IOException {
        int cmt = 0;
        int[] ints = Files.readAllLines(Paths.get("pairs.txt")).stream()
                .mapToInt(Integer::parseInt).sorted().toArray();
        for (int anInt : ints) {
            if (BinarySearch.indexOf(ints, -anInt) > -1)
                cmt++;
        }
        System.out.println(cmt);
        System.out.println(countNumberOfPairs(ints));
        int index = E10_binarySearch.binarySearchForSmallest(ints, 234);
        System.out.println(index);
//        int num;
//        PrintWriter out = new PrintWriter("pairs.txt");
//        for (int i = 0; i < 1000; i++) {
//            num = StdRandom.uniformInt(-1000, 1000);
//            out.println(num);
//        }
//        out.close();
//    }
    }
}
