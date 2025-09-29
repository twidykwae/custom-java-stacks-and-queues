import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Steque<Item> implements Iterable<Item> {
    class Node{
        Item item;
        Node next;
    }

    private Node first;
    private Node last;
    int n;
    int modCount;

    public Steque() { }

    // returns the number of items stored
    public int size() {
        return n;
    }

    // returns true if steque is empty
    public boolean isEmpty() {
        return n == 0;
    }

    // enqueues item to bottom of steque
    public void enqueue(Item item) {
        Node newNode = new Node();
        newNode.item = item;
        newNode.next = null;

        if(isEmpty()){
            first = newNode;
            last = newNode;
        }else{
            last.next = newNode;
            last = newNode;
        }
        n++;
        modCount++;
    }

    // pushes item to top of steque
    public void push(Item item) {
        //first store old first in a temp variable, so:
        Node oldFirst = first;         // save old first
        Node newNode = new Node();     // create new node
        newNode.item = item;
        newNode.next = oldFirst;       // link to old first
        first = newNode;               // update first

        if (isEmpty()) {
            last = newNode;            // if empty before, last also points to new node
        }

        n++;
        modCount++;
    }

    // pops and returns top item
    public Item pop() throws NoSuchElementException {
        if(isEmpty()){
            throw new NoSuchElementException("Empty");
        }
        Item item = first.item;
        Node oldFirst = first;

        first = first.next;
        oldFirst.next = null;
        if (first == null){
            last = null;
        }
        n--;
        modCount++;
        return item;
    }

    // returns new Iterator<Item> that iterates over items in steque
    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            Node current = first;
            final int expectedModCount = modCount;
            @Override
            public boolean hasNext() {
                if (expectedModCount!=modCount){
                    throw new ConcurrentModificationException();
                }
                return current != null;
            }

            @Override
            public Item next() {
                if (expectedModCount!=modCount){
                  throw new ConcurrentModificationException();
                }
                if(current == null){
                    throw new NoSuchElementException();
                }
                Item item = current.item;
                current = current.next;
                return item;
            }
            @Override
            public void remove() {
            }
        };
    }

    // perform unit testing here
    public static void main(String[] args) throws NoSuchElementException {
        Steque<Integer> s = new Steque<>();

        // 1. Fresh steque should be empty
        assert s.isEmpty();
        assert s.size() == 0;

        // 2. Push works
        s.push(10);
        s.push(20);
        assert s.size() == 2;
        assert s.pop() == 20;  // LIFO
        assert s.pop() == 10;  // next one
        assert s.isEmpty();

        // 3. Enqueue works
        s.enqueue(5);
        s.enqueue(6);
        assert s.size() == 2;
        assert s.pop() == 5;   // top is still first
        assert s.pop() == 6;
        assert s.isEmpty();

        // 4. Mix push + enqueue
        s.push(1);   // top = 1
        s.enqueue(2); // bottom = 2
        s.push(3);   // top = 3
        assert s.pop() == 3;
        assert s.pop() == 1;
        assert s.pop() == 2;
        assert s.isEmpty();

        // 5. Pop on empty should throw
        try {
            s.pop();
            assert false; // should not reach here
        } catch (NoSuchElementException e) {
            // correct
        }

        // 6. Iterator works
        s.push(7);
        s.push(8);
        s.enqueue(9);
        int[] expected = {8, 7, 9};
        int idx = 0;
        for (int x : s) {
            assert x == expected[idx++];
        }

        System.out.println("All Steque tests passed!");
    }
}