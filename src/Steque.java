import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Steque<Item> implements Iterable<Item> {

    public Steque() { }

    // returns the number of items stored
    public int size() {
        return -1;
    }

    // returns true iff steque is empty
    public boolean isEmpty() {
        return false;
    }

    // enqueues item to bottom of steque
    public void enqueue(Item item) {
    }

    // pushes item to top of steque
    public void push(Item item) {
    }

    // pops and returns top item
    public Item pop() throws NoSuchElementException {
        return null;
    }

    // returns new Iterator<Item> that iterates over items in steque
    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    // perform unit testing here
    public static void main(String[] args) throws NoSuchElementException {
    }
}