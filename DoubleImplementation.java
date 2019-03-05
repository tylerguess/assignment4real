import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleImplementation<T> implements DoubleEndedList<T> {

    private Node front, rear;
    private int size;

    @Override
    public void addFirst(T element) {
        if (element == null) {
            throw new IllegalArgumentException("Can't be null");
        }
        Node n = new Node(element, null, null);
        if (isEmpty()) {
            front = n;
            rear = n;
            size++;
        }
        else {
            n.next = front;
            n.next.prev = n;
            front = n;
            size++;
        }

    }

    @Override
    public void addLast(T element) {
        if (element == null) {
            throw new IllegalArgumentException("Can't be null");
        }
        Node n = new Node(element, null, null);
        if (isEmpty()) {
            front = n;
            rear = n;
            size++;
        }
        else {
            n.prev = rear;
            n.prev.next = n;
            rear = n;
            size++;
        }
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        else if (size() == 1) {
            T toRemove = front.element;
            front.element = null;
            rear.element = null;
            front.next = null;
            front.prev = null;
            rear.next = null;
            rear.prev = null;
            size--;
            return toRemove;
        }
        else {
            Node toReturn = front;
            Node second = front.next;
            second.prev = null;
            front.next = null;
            front = second;
            size--;
            return toReturn.element;
        }
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        else if (size() == 1) {
            T toRemove = rear.element;
            front.element = null;
            rear.element = null;
            front.next = null;
            front.prev = null;
            rear.next = null;
            rear.prev = null;
            size--;
            return toRemove;
        }
        else {
            Node toReturn = rear;
            Node second = rear.prev;
            second.next = null;
            rear.prev = null;
            rear = second;
            size--;
            return toReturn.element;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedIterator();
    }

    private class LinkedIterator implements Iterator<T> {
        private Node current = front;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException("Can't remove");
        }

        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No next element");
            }
            T result = current.element;
            current = current.next;
            return result;
        }
    }

    /**
     * Defines a node.
     */
    private class Node {
        private T element;
        private Node next;
        private Node prev;


        public Node(T e, Node n, Node p) {
            element = e;
            next = n;
            prev = p;
        }
    }







}
