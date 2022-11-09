package Fundamentals;

public class Queue<T> {
    private Node first;
    private Node last;
    private int N;
    private class Node {
        T item;
        Node next;
    }
    public boolean isEmpty() { return first == null; }
    public int size() { return N; }

    public void enqueue(T item) {
        Node oldlast = last;
        last = new Node();
        last.next = null;
        if (isEmpty()) first = last;
        else oldlast.next = last;
        N++;
    }

    public T dequeue()
    {
        T item = first.item;
        first = first.next;
        if (isEmpty()) last = null;
        N--;
        return item;
    }

    public static void main(String[] args) {
        System.out.println("Hello!");
    }
}