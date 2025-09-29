import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class OnePointerQueue<Item> implements Iterable<Item> {
    class Node{
        Item item;
        Node next;
    }

    Node last;
    int n; //size of the thing
    int modCount;
    public OnePointerQueue() {
        last = null;
        n = 0;
        modCount = 0;
    }

    // returns the number of items stored
    public int size() {
        return n;
    }

    // returns true iff empty
    public boolean isEmpty() {
        return n == 0;
    }

    // enqueue item to "back"
    public void enqueue(Item item) {
        Node new_node = new Node();
        new_node.item = item;
        if(isEmpty()){
            last = new_node;
            last.next = last;
        }else{
            new_node.next = last.next;
            last.next = new_node;
            last = new_node;
        }
        n++;
        modCount++;
    }

    // dequeue item from "front"
    public Item dequeue() {
        if(isEmpty()){
            throw new NoSuchElementException();
        }

        Node front = last.next;
        Item item = front.item;

        if (n == 1){
            last = null;
        }else{
            last.next = front.next;
        }
        n--;
        modCount++;
        return item;
    }

    // returns new Iterator<Item> that iterates over items
    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            private int count = 0;
            Node current = (last == null ? null : last.next);
            private final int expectedModCount = modCount;
            @Override
            public boolean hasNext() {
                if(expectedModCount!=modCount){
                    throw new ConcurrentModificationException();
                }
                return count < n;
            }

            @Override
            public Item next() {
                if (!hasNext()){
                    throw new NoSuchElementException();
                }
                Item item = current.item;
                current = current.next;
                count++;
                return item;
            }

        };
    }


    // perform unit testing here
    public static void main(String[] args) {
        OnePointerQueue<Integer> q = new OnePointerQueue<>();
        assert q.isEmpty();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        assert q.dequeue() == 10;
        assert q.dequeue() == 20;
        assert q.dequeue() == 30;
        assert q.isEmpty();

        System.out.println("All tests passed");
    }
}
