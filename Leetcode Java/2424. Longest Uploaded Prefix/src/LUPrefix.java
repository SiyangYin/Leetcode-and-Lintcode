import java.util.PriorityQueue;

class LUPrefix {
    private PriorityQueue<Integer> heap;
    private int i;
    public LUPrefix(int n) {
        heap = new PriorityQueue<>();
        i = 0;
    }

    public void upload(int video) {
        heap.offer(video);
    }

    public int longest() {
        while (!heap.isEmpty() && i + 1 == heap.peek()) {
            i = heap.poll();
        }
        return i;
    }

    public static void main(String[] args) {
        LUPrefix luPrefix = new LUPrefix(4);
        luPrefix.upload(3);
        System.out.println(luPrefix.longest());
        luPrefix.upload(1);
        System.out.println(luPrefix.longest());
        luPrefix.upload(2);
        System.out.println(luPrefix.longest());
    }
}