import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class OnePointerQueue<Item> implements Iterable<Item> {

    public OnePointerQueue() { }

    // returns the number of items stored
    public int size() {
        return -1;
    }

    // returns true iff empty
    public boolean isEmpty() {
        return false;
    }

    // enqueue item to "back"
    public void enqueue(Item item) {
    }

    // dequeue item from "front"
    public Item dequeue() {
        return null;
    }

    // returns new Iterator<Item> that iterates over items
    @Override
    public Iterator<Item> iterator() {
        return null;
    }


    // perform unit testing here
    public static void main(String[] args) {
    }
}
