import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class MinimumStack<Item extends Comparable<Item>> implements Iterable<Item> {
    //create two stacks: one for normal operations, one to track minimum
    Stack<Item> mainstack;
    Stack<Item> minTrackingStack;
    int modCount;
    public MinimumStack() {
        mainstack = new Stack<>();
        minTrackingStack = new Stack<>();
        modCount = 0;
    }

    // returns the number of items stored
    public int size() {
        return mainstack.size();
    }

    // returns true if empty
    public boolean isEmpty() {
        return mainstack.isEmpty();
    }

    // push item onto stack
    public void push(Item item) {
        if (item == null ){
            throw new NoSuchElementException();
        }
        mainstack.push(item);

        if (minTrackingStack.isEmpty() || item.compareTo( minTrackingStack.peek()) <= 0 ){
            minTrackingStack.push(item);
        }
        modCount++;
    }

    // pop and return the top item
    public Item pop() {
        if (mainstack.isEmpty()) {
            throw new NoSuchElementException();
        }


        Item popped = mainstack.pop();
        if (popped.compareTo(minTrackingStack.peek()) == 0 ){
            minTrackingStack.pop();
        }
        modCount++;
        return popped;

    }

    // returns the minimum item in constant time
    public Item minimum() {
        if (minTrackingStack.isEmpty()){
            throw new NoSuchElementException();
        }
        return minTrackingStack.peek();
    }

    // returns new Iterator<Item> that iterates over items
    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            private final int expectedModCount = modCount;
            private final Iterator<Item> it = mainstack.iterator();
            @Override
            public boolean hasNext() {
                if (expectedModCount!=modCount){
                    throw new ConcurrentModificationException();
                }
                return it.hasNext();
            }

            @Override
            public Item next() {
                if(expectedModCount!=modCount){
                    throw new ConcurrentModificationException();
                }
                if(!hasNext()){
                    throw new NoSuchElementException();
                }
                return it.next();
            }
        };
    }

    public static void main(String[] args) {
        MinimumStack<Integer> ms = new MinimumStack<>();
        assert ms.isEmpty();

        ms.push(5);
        ms.push(3);
        ms.push(7);

        assert !ms.isEmpty();

        assert ms.minimum() == 3;

        assert ms.pop() == 7;
        assert ms.minimum() == 3;

        assert ms.pop() == 3;

        assert ms.pop() == 5;
        assert ms.isEmpty();

        boolean threw = false;
        try {
            ms.minimum();
        } catch (NoSuchElementException e) {
            threw = true;
        }
        assert threw : "calling minimum() on empty stack";


        System.out.println("All tests passed");

    }
}
