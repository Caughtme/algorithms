package Fundamentals;

public class Node<T> {
        private T item;
        private Node<T> next;

        public T getItem() { return item; }

        public Node<T> getNext() { return next; }

        public void setItem(T item) {
                this.item = item;
        }

        public void setNext(Node<T> next) {
                this.next = next;
        }
}
