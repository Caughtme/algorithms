package Sorting.ElementarySorts;

import Utility.Sort;
import static Utility.SortUtility.exch;
import static Utility.SortUtility.less;

public class Insertion implements Sort
{
    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < a.length; i++)
        {
            for(int j = i; j > 0 && less(a[j], a[j-1]); j--)
                exch(a, j,j-1);
        }
    }

}
