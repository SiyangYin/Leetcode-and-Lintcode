import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class FirstUnique {
    
    private Queue<Integer> queue;
    private Map<Integer, Boolean> map;
    
    public FirstUnique(int[] nums) {
        queue = new ArrayDeque<>();
        map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], !map.containsKey(nums[i]));
        }
    
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i])) {
                queue.offer(nums[i]);
            }
        }
    }
    
    public int showFirstUnique() {
        while (!queue.isEmpty() && !map.get(queue.peek())) {
            queue.poll();
        }
        
        return queue.isEmpty() ? -1 : queue.peek();
    }
    
    public void add(int value) {
        map.put(value, !map.containsKey(value));
        if (map.get(value)) {
            queue.offer(value);
        }
    }
    
    public static void main(String[] args) {
        FirstUnique unique = new FirstUnique(new int[]{2, 3, 5});
        System.out.println(unique.showFirstUnique());
        unique.add(5);
        unique.add(2);
    
        System.out.println(unique.showFirstUnique());
    }
}