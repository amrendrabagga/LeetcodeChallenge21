package february.week2;

import java.util.Iterator;

public class Day1_PeekingIterator implements Iterator<Integer> {

    Integer peekedElement = null;
    boolean hasPeeked = false;
    final Iterator<Integer> iterator;
    public Day1_PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (!hasPeeked) {
            peekedElement = iterator.next();
            hasPeeked = true;
        }
        return peekedElement;
    }

    @Override
    public boolean hasNext() {
        return hasPeeked || iterator.hasNext();
    }

    @Override
    public Integer next() {
        if (!hasPeeked) {
            return iterator.next();
        }
        Integer elem = peekedElement;
        hasPeeked = false;
        peekedElement = null;
        return elem;
    }
}
