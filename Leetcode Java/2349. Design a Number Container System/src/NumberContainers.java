import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class NumberContainers {
    private Map<Integer, Integer> map1;
    private Map<Integer, PriorityQueue<Integer>> map2;
    public NumberContainers() {
        map1 = new HashMap<>();
        map2 = new HashMap<>();
    }

    public void change(int index, int number) {
        if (map1.containsKey(index) && map2.containsKey(map1.get(index))) {
            map2.get(map1.get(index)).remove(index);
        }
        map1.put(index, number);
        PriorityQueue<Integer> heap = map2.getOrDefault(number, new PriorityQueue<>());
        if (heap.isEmpty() || index < heap.peek() || heap.size() < 20) {
            heap.offer(index);
        }
        map2.putIfAbsent(number, heap);
    }

    public int find(int number) {
        return !map2.containsKey(number) ? -1 : map2.get(number).isEmpty() ? -1 : map2.get(number).peek();
    }

    public static void main(String[] args) {
        NumberContainers numberContainers = new NumberContainers();
        System.out.println(numberContainers.find(10));
        numberContainers.change(2, 10);
        numberContainers.change(1, 10);
        numberContainers.change(3, 10);
        numberContainers.change(5, 10);
        System.out.println(numberContainers.find(10));
        numberContainers.change(1, 20);
        System.out.println(numberContainers.find(10));
    }
}