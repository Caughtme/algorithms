package Sorting.ElementarySorts;

import Utility.Sort;
import static Utility.SortUtility.exch;
import static Utility.SortUtility.less;

public class Selection implements Sort {

    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i+1; j < N; j++) {
                if(less(a[j], a[min])) min = j;
            }
            exch(a, i , min);
        }
    }
}
