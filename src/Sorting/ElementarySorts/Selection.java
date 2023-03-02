package Sorting.ElementarySorts;

import Utility.Sort;

import static Sorting.Example.*;

public class Selection implements Sort {

    private Comparable[] a;

    public void setA(Comparable[] a) {
        this.a = a;
    }

    @Override
    public void sort() {
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
