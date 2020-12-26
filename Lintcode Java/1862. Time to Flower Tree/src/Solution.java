import java.util.*;

public class Solution {
    
    class Pair {
        int idx, time;
        
        public Pair(int idx, int time) {
            this.idx = idx;
            this.time = time;
        }
    }
    
    /**
     * @param father: the father of every node
     * @param time:   the time from father[i] to node i
     * @return: time to flower tree
     */
    public int timeToFlowerTree(int[] father, int[] time) {
        // write your code here
        Map<Integer, List<Integer>> tree = buildTree(father);
        Deque<Pair> stack = new ArrayDeque<>();
        stack.push(new Pair(0, 0));
        
        int res = 0;
        while (!stack.isEmpty()) {
            Pair cur = stack.pop();
            if (!tree.containsKey(cur.idx)) {
                res = Math.max(res, cur.time);
            } else {
                for (int next : tree.get(cur.idx)) {
                    stack.push(new Pair(next, cur.time + time[next]));
                }
            }
        }
        
        return res;
    }
    
    private Map<Integer, List<Integer>> buildTree(int[] father) {
        Map<Integer, List<Integer>> tree = new HashMap<>();
        tree.put(0, new ArrayList<>());
        for (int i = 1; i < father.length; i++) {
            tree.putIfAbsent(father[i], new ArrayList<>());
            tree.get(father[i]).add(i);
        }
        
        return tree;
    }
}
