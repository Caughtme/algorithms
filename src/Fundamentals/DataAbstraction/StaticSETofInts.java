package Fundamentals.DataAbstraction;

import java.util.Arrays;

public class StaticSETofInts {
    private int[] a;

    public StaticSETofInts(int[] keys) {
        a = new int[keys.length];
        for (int i = 0; i < keys.length; i++) {
            a[i] = keys[i];
        }
        Arrays.sort(a);
    }

    public boolean contains(int key)
    {
        return rank(key) != -1;
    }

    private int rank(int key)
    {
        int lo = 0;
        int hi = a.length - 1;
        while(lo <= hi) {
            int middle = lo + (hi - lo) / 2;
            if (a[middle] > key) hi = middle - 1;
            else if (a[middle] < key) lo = middle + 1;
            else return middle;
        }
        return -1;
    }

    public int recursiveRank(int key, int low, int high)
    {
        int middle = low + (high - low) / 2;
        if(low > high) return -1;
        if(a[middle] > key) return recursiveRank(key, low, middle-1);
        else if(a[middle] < key) return recursiveRank(key, middle+1, high);
        else return middle;
    }

    public int howMany(int key) {
        int indexFromRank = rank(key);
        if (indexFromRank == -1)  return 0;
        int count = 0;
        int previousIndex = indexFromRank;
        int currentPreviousIndex = previousIndex;
        int nextIndex = indexFromRank;
        int currentNextIndex = nextIndex;

        // find the smallest index
        while(currentPreviousIndex != -1)
        {
            currentPreviousIndex = recursiveRank(key, 0, currentPreviousIndex-1);
            if (currentPreviousIndex != -1) {
                previousIndex = currentPreviousIndex;
            }
        }

        // find the largest index
        while (currentNextIndex != -1) {
            currentNextIndex = recursiveRank(key, currentNextIndex+1, a.length-1);

            if (currentNextIndex != -1) {
                nextIndex = currentNextIndex;
            }
        }
        count = nextIndex - previousIndex + 1;
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {8, 8, 8, 8, 8, 8, 8, 8, 8, 8};
        StaticSETofInts staticSETofInts = new StaticSETofInts(arr);
        int count = staticSETofInts.howMany(8);
        System.out.println(count);
    }
}






















