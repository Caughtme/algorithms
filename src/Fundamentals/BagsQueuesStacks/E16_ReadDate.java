package Fundamentals.BagsQueuesStacks;

import edu.princeton.cs.algs4.Date;
import edu.princeton.cs.algs4.StdIn;

import java.util.ArrayList;
import java.util.List;

public class E16_ReadDate {
    public static List<Date> readDate() {
        List<Date> dates = new ArrayList<>();
        while(!StdIn.isEmpty())
        {
            String date = StdIn.readString();
            String[] fields = date.split("/");
            int m = Integer.parseInt(fields[0]);
            int d = Integer.parseInt(fields[1]);
            int y = Integer.parseInt(fields[2]);
            dates.add(new Date(m, d, y));
        }
        return dates;
    }
    public static void main(String[] args) {
        System.out.println(readDate());
    }
}
