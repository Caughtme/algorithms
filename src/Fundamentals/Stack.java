package Fundamentals;

import java.util.Iterator;

public class Stack<T> implements Iterable<T> {
    private Node<T> first;
    private int N;
    public boolean isEmpty() { return first == null; }
    public int size() { return N; }

    public void push(T item) {
        Node<T> oldfirst = first;
        first = new Node<>();
        first.setItem(item);
        first.setNext(oldfirst);
        N++;
    }

    public T pop() {
        T item = first.getItem();
        first = first.getNext();
        N--;
        return item;
    }
    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<T> {
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
        String[] s = "This is a stack".split(" ");
        Stack<String> stack = new Stack<>();
        for(String w : s) {
            System.out.println(stack.isEmpty());
            stack.push(w);
        }
        for (String s1 : stack) {
            System.out.print(s1 + " ");
            System.out.println(stack.pop());
        }
    }
}
