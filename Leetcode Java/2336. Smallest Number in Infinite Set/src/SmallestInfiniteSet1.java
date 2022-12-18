import java.util.PriorityQueue;
import java.util.TreeSet;

class SmallestInfiniteSet1 {
    private TreeSet<Integer> set;
    private int i;
    public SmallestInfiniteSet1() {
        set = new TreeSet<>();
        i = 1;
    }

    public int popSmallest() {
        if (set.isEmpty()) {
            return i++;
        }
        else {
            int res = set.iterator().next();
            set.remove(res);
            return res;
        }
    }

    public void addBack(int num) {
        if (num < i) {
            set.add(num);
        }
    }

    public static void main(String[] args) {
        SmallestInfiniteSet1 smallestInfiniteSet = new SmallestInfiniteSet1();
        smallestInfiniteSet.addBack(2);
        System.out.println(smallestInfiniteSet.popSmallest());
        System.out.println(smallestInfiniteSet.popSmallest());
        System.out.println(smallestInfiniteSet.popSmallest());
        smallestInfiniteSet.addBack(1);
        System.out.println(smallestInfiniteSet.popSmallest());
        System.out.println(smallestInfiniteSet.popSmallest());
        System.out.println(smallestInfiniteSet.popSmallest());
    }
}