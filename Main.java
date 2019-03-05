import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        DoubleImplementation<Integer> list = new DoubleImplementation<Integer>();
        list.addFirst(5);
        list.removeFirst();
        list.addFirst(10);
        list.removeLast();
        list.removeLast();
        list.removeFirst();
    }
}
