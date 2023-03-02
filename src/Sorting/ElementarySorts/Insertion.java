package Sorting.ElementarySorts;

import Utility.Sort;

import static Sorting.Example.exch;
import static Sorting.Example.less;

public class Insertion implements Sort
{
    private Comparable[] a;

    @Override
    public void sort()
    {
        int N = a.length;
        for (int i = 1; i < a.length; i++)
        {
            for(int j = i; j > 0 && less(a[j], a[j-1]); j--)
                exch(a, j,j-1);
        }
    }
}
