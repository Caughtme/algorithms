package Fundamentals;

@SuppressWarnings("all")
public class Queue<T> {
    private Node<T> first;
    private Node<T> last;
    private int N;

    public boolean isEmpty() { return first == null; }
    public int size() { return N; }

    public void enqueue(T item) {
        Node<T> oldlast = last;
        last = new Node<T>();
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

    public static void main(String[] args) {
        System.out.println("Hello!");
    }
}