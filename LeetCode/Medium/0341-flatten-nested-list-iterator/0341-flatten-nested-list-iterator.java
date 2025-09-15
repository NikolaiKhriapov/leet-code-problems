/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    private Deque<NestedInteger> deque;

    public NestedIterator(List<NestedInteger> nestedList) {
        deque = new ArrayDeque<>();
        for (NestedInteger el : nestedList) {
            deque.offerLast(el);
        }
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new RuntimeException("No more elements");
        }
        return deque.pollFirst().getInteger();
    }

    @Override
    public boolean hasNext() {
        flatten();
        return !deque.isEmpty();
    }

    private void flatten() {
        while (!deque.isEmpty() && !deque.peekFirst().isInteger()) {
            List<NestedInteger> sublist = deque.pollFirst().getList();
            for (int i = sublist.size() - 1; i >= 0; i--) {
                deque.offerFirst(sublist.get(i));
            }
        }
    }
}

// time  - O(1)
// space - O(n)