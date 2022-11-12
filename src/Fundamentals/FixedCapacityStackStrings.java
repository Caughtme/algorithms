package Fundamentals;

public class FixedCapacityStackStrings {
    private String[] a;
    private int N;

    public FixedCapacityStackStrings(int cap) {
        a = new String[cap];
    }

    public boolean isEmpty() { return N == 0; }
    public int size() { return N; }

    public void push(String item) { a[N++] = item; }

    public String pop() { return a[N--]; }

    public boolean isFull() { return N == a.length; }

    public static void main(String[] args) {
        FixedCapacityStackStrings fixedCapacityStackStrings = new FixedCapacityStackStrings(5);
        System.out.println(fixedCapacityStackStrings.isEmpty());
        System.out.println(fixedCapacityStackStrings.isFull());
        for (int i = 0; i < 5; i++) {
            fixedCapacityStackStrings.push(String.valueOf(i));
        }
        System.out.println(fixedCapacityStackStrings.isEmpty());
        System.out.println(fixedCapacityStackStrings.isFull());
    }
}
