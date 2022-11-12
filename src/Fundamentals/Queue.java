package Fundamentals;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class Queue<T> implements Iterable<T> {
    private Node<T> first;
    private Node<T> last;
    private int N;

    public boolean isEmpty() { return first == null; }
    public int size() { return N; }

    public void enqueue(T item) {
        Node<T> oldlast = last;
        last = new Node<>();
        last.setNext(null);
        if (isEmpty()) first = last;
        else oldlast.setNext(last);
        N++;
    }

    public T dequeue()
    {
        T item = first.getItem();
        first = first.getNext();
        if (isEmpty()) last = null;
        N--;
        return item;
    }

    @Override
    public Iterator<T> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<T> {
        Node<T> current = first;
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T item = current.getItem();
            current = current.getNext();
            return item;
        }
    }

    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-"))
                queue.enqueue(item);
            else if (!queue.isEmpty())
                StdOut.print(queue.dequeue() + " ");
        }
        StdOut.println("(" + queue.size() + " left on queue)");
    }
}