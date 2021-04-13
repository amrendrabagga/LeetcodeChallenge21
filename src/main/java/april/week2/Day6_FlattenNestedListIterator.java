package april.week2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Day6_FlattenNestedListIterator implements Iterator<Integer> {
    Iterator<Integer> itr;
    public Day6_FlattenNestedListIterator(List<NestedInteger> nestedList) {
        List<Integer> list = new ArrayList();
        flattenList(nestedList, list);
        itr = list.iterator();
    }

    private void flattenList(List<NestedInteger> nestedList, List<Integer> list) {

        for (NestedInteger i : nestedList) {
            if (i.isInteger()) {
                list.add(i.getInteger());
            }
            else {
                flattenList(i.getList(), list);
            }
        }
    }

    @Override
    public Integer next() {
        return itr.next();
    }

    @Override
    public boolean hasNext() {
        return itr.hasNext();
    }

    private interface NestedInteger {
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        List<NestedInteger> getList();
    }
}
