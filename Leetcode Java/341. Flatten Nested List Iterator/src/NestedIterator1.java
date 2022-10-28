import java.util.*;

public class NestedIterator1 implements Iterator<Integer> {
    private List<Integer> list;
    private Iterator<Integer> iterator;
    public NestedIterator1(List<NestedInteger> nestedList) {
        list = new ArrayList<>();
        dfs(list, nestedList);
        iterator = list.iterator();
    }

    @Override
    public Integer next() {
        return iterator.next();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    public void dfs(List<Integer> list, List<NestedInteger> nestedList) {
        for (NestedInteger i : nestedList) {
            if (i.isInteger()) {
                list.add(i.getInteger());
            }
            else {
                dfs(list, i.getList());
            }
        }
    }
}

