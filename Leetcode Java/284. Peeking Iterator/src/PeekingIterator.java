import java.util.Iterator;

public class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> it;
    private Integer cache = null;
    
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        it = iterator;
    }
    
    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (cache == null) {
            cache = it.next();
        }
        return cache;
    }
    
    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (cache == null) {
            return it.next();
        }
        
        Integer res = cache;
        cache = null;
        return res;
    }
    
    @Override
    public boolean hasNext() {
        return cache != null || it.hasNext();
    }
}
