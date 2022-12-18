import java.util.PriorityQueue;

class SmallestInfiniteSet {
    private PriorityQueue<Integer> heap;
    private int i;
    public SmallestInfiniteSet() {
        heap = new PriorityQueue<>();
        i = 1;
    }

    public int popSmallest() {
        if (heap.isEmpty()) {
            return i++;
        }
        else {
            return heap.poll();
        }
    }

    public void addBack(int num) {
        if (num < i && !heap.contains(num)) {
            heap.offer(num);
        }
    }

    public static void main(String[] args) {
        SmallestInfiniteSet smallestInfiniteSet = new SmallestInfiniteSet();
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