import java.util.Iterator;
import java.util.Random;
import java.util.NoSuchElementException;


public class Listy<T> implements RandomizedList<T> {

    private int size;
    private T[] array;

    /**
     *  Returns size of array.
     *
     */
    public Listy() {
        array = (T[]) new Object[5];
        size = 0;
    }
    public int size() {
        return size;
    }

    /**
     * Returns if array is empty or not.
     * @return
     */
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    /**
     * Returns an iterator over the elements.
     *
     */
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    /**
     * Adds an element to the list.
     *
     */
    public void add(T element) {
        if (element == null) {
            throw new IllegalArgumentException("Can't have null argument");
        }
        if (isFull()) {
            resize(array.length * 2);
        }
        array[size] = element;
        size++;
    }

    /**
     * Removes a random element from the list.
     *
     */
    public T remove() {
        if (isEmpty()) {
            return null;
        }
        Random randomGenerator = new Random();
        int randomIndex = randomGenerator.nextInt(size);
        T toReturn = array[randomIndex];
        array[randomIndex] = array[size - 1];
        array[size - 1] = null;
        size--;
        return toReturn;
    }

    /**
     * Returns if array is full or not.
     *
     */
    public boolean isFull() {
        if (array == null) {
            return false;
        }
        if (size == array.length) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Resizes array.
     *
     */
    public void resize(int n) {
        T[] temp = (T[]) new Object[n];
        for (int i = 0; i < size; i++) {
            temp[i] = array[i];
        }
        array = temp;
    }

    /**
     * Removes an element at random. Not Done.
     */
    public T sample() {
        if (isEmpty()) {
            return null;
        }
        Random randomGenerator = new Random();
        int randomIndex = randomGenerator.nextInt(size);
        return array[randomIndex];
    }

    /**
     * Defines a ListIterator of type T.
     *
     */
    private class ListIterator<T> implements Iterator<T> {

        public T[] items;
        private int count;
        private int current;

        public ListIterator() {
            items = (T[]) new Object[size];
            T[] tempArr = (T[]) array;
            for (int i = 0; i < size; i++) {
                items[i] = tempArr[i];
            }

            count = size;
            current = 0;
            randomizeArray();
        }

        public void randomizeArray() {
            Random randomGenerator = new Random();
            for (int i = 0; i < count; i++) {
                int randomIndex = randomGenerator.nextInt(count);
                T temp = items[randomIndex];
                items[randomIndex] = items[i];
                items[i] = temp;
            }
        }

        public boolean hasNext() {
            return (current < count);
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return items[current++];
        }



    }

}