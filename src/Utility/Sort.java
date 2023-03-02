package Utility;

public interface Sort extends Algorithm{
    void sort(Comparable[] a);

    @Override
    default void run(Comparable[] a) {
        this.sort(a);
    }
}
