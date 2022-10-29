import java.util.*;

public class AllOne1 {
    Map<String, Integer> map;
    PriorityQueue<List> minHeap;
    PriorityQueue<List> maxHeap;
    public AllOne1() {
        map = new HashMap<>();
        minHeap = new PriorityQueue<>((i1, i2) -> (int)i1.get(1) - (int)i2.get(1));
        maxHeap = new PriorityQueue<>((i1, i2) -> (int)i2.get(1) - (int)i1.get(1));
    }

    public void inc(String key) {
        map.put(key, map.getOrDefault(key, 0) + 1);
        maxHeap.offer(Arrays.asList(key, map.get(key)));
        minHeap.offer(Arrays.asList(key, map.get(key)));
    }

    public void dec(String key) {
        map.put(key, map.getOrDefault(key, 0) - 1);
        if (map.get(key) <= 0) {
            map.remove(key);
            return;
        }
        maxHeap.offer(Arrays.asList(key, map.get(key)));
        minHeap.offer(Arrays.asList(key, map.get(key)));
    }

    public String getMaxKey() {
        while (!maxHeap.isEmpty() && (!map.containsKey(maxHeap.peek().get(0)) || !map.get(maxHeap.peek().get(0)).equals(maxHeap.peek().get(1)))) {
            while (!maxHeap.isEmpty() && !map.containsKey(maxHeap.peek().get(0))) {
                maxHeap.poll();
            }

            while (!maxHeap.isEmpty() && map.containsKey(maxHeap.peek().get(0)) && !map.get(maxHeap.peek().get(0)).equals(maxHeap.peek().get(1))) {
                maxHeap.offer(Arrays.asList(maxHeap.peek().get(0), map.get(maxHeap.poll().get(0))));
            }
        }
        if (!maxHeap.isEmpty()) {
            return (String)maxHeap.peek().get(0);
        }
        else {
            return "";
        }
    }

    public String getMinKey() {
        while (!minHeap.isEmpty() && (!map.containsKey(minHeap.peek().get(0)) || !map.get(minHeap.peek().get(0)).equals(minHeap.peek().get(1)))) {
            while (!minHeap.isEmpty() && !map.containsKey(minHeap.peek().get(0))) {
                minHeap.poll();
            }

            while (!minHeap.isEmpty() && map.containsKey(minHeap.peek().get(0)) && !map.get(minHeap.peek().get(0)).equals(minHeap.peek().get(1))) {
                minHeap.offer(Arrays.asList(minHeap.peek().get(0), map.get(minHeap.poll().get(0))));
            }
        }
        if (!minHeap.isEmpty()) {
            return (String)minHeap.peek().get(0);
        }
        else {
            return "";
        }
    }
    
    public static void main(String[] args) {
        AllOne1 cache = new AllOne1();
        cache.inc("a");
        cache.inc("b");
        cache.inc("b");
        cache.inc("c");
        cache.inc("c");
        cache.inc("c");
        cache.dec("b");
        cache.dec("b");
        System.out.println("cache.getMinKey() = " + cache.getMinKey());
        cache.dec("a");
        System.out.println("cache.getMaxKey() = " + cache.getMaxKey());
        System.out.println("cache.getMinKey() = " + cache.getMinKey());
    }
}
