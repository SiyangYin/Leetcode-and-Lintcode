import java.util.Iterator;

class PeekingIterator1 implements Iterator<Integer> {
    private Iterator<Integer> cur;
    private int peek;
    public PeekingIterator1(Iterator<Integer> iterator) {
        // initialize any member here.
        peek = 0;
        cur = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (peek == 0) {
            peek = cur.next();
        }
        return peek;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (peek != 0){
            int temp = peek;
            peek = 0;
            return temp;
        }
        return cur.next();
    }

    @Override
    public boolean hasNext() {
        return peek != 0 || cur.hasNext();
    }
}