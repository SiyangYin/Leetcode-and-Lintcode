import java.util.*;

public class Solution {
    /**
     * @param deadends: the list of deadends
     * @param target:   the value of the wheels that will unlock the lock
     * @return: the minimum total number of turns
     */
    public int openLock(String[] deadends, String target) {
        // Write your code here
        Set<Integer> dead = new HashSet<>();
        for (String deadend : deadends) {
            dead.add(Integer.parseInt(deadend));
        }
        
        int t = Integer.parseInt(target);
        if (dead.contains(0) || dead.contains(t)) {
            return -1;
        }
        
        if (t == 0) {
            return 0;
        }
        
        Queue<Integer> beginQueue = new LinkedList<>(), endQueue = new LinkedList<>();
        Set<Integer> beginSet = new HashSet<>(), endSet = new HashSet<>();
        beginQueue.offer(0);
        beginSet.add(0);
        endQueue.offer(t);
        endSet.add(t);
        
        int step = 0;
        while (!beginQueue.isEmpty() && !endQueue.isEmpty()) {
            step++;
            if (oneStep(beginQueue, beginSet, endSet, dead)) {
                return step;
            }
            
            step++;
            if (oneStep(endQueue, endSet, beginSet, dead)) {
                return step;
            }
        }
        
        return -1;
    }
    
    private boolean oneStep(Queue<Integer> queue, Set<Integer> beginSet, Set<Integer> endSet, Set<Integer> deadends) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            int cur = queue.poll();
            for (int next : getNexts(cur, beginSet, deadends)) {
                if (endSet.contains(next)) {
                    return true;
                }
                
                beginSet.add(next);
                queue.offer(next);
            }
        }
        
        return false;
    }
    
    private List<Integer> getNexts(int cur, Set<Integer> visited, Set<Integer> deadends) {
        List<Integer> nexts = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        while (cur > 0) {
            sb.append(cur % 10);
            cur /= 10;
        }
        
        while (sb.length() < 4) {
            sb.append(0);
        }
        
        sb.reverse();
        
        for (int i = 0; i < 4; i++) {
            int old = sb.charAt(i) - '0';
            for (int j = -1; j <= 1; j += 2) {
                int incr = (old + j + 10) % 10;
                sb.setCharAt(i, (char) ('0' + incr));
                int next = Integer.parseInt(sb.toString());
                if (!visited.contains(next) && !deadends.contains(next)) {
                    nexts.add(next);
                }
            }
            
            sb.setCharAt(i, (char) ('0' + old));
        }
        
        return nexts;
    }
    
    public static void main(String[] args) {
        // System.out.println(Integer.parseInt("0000"));
        // System.out.println(-1 % 10);
        // System.out.println((char) (9 + '0'));
        
        String[] deads = {"2110","2000","0000","2111","1110"};
        String tar = "0012";
        System.out.println(new Solution().openLock(deads, tar));
        
    }
}
