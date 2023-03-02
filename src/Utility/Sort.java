package Utility;

public interface Sort extends Algorithm{
    public void sort();

    @Override
    default void run() {
        this.sort();
    }
}
