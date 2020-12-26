import java.util.*;

public class Solution {
    /**
     * @param init_state:  the initial state of chessboard
     * @param final_state: the final state of chessboard
     * @return: return an integer, denote the number of minimum moving
     */
    public int minMoveStep(int[][] init_state, int[][] final_state) {
        // # write your code here
        String start = stateToString(init_state), end = stateToString(final_state);
        if (start.equals(end)) {
            return 0;
        }
        if ((computeInversePairs(start) ^ computeInversePairs(end) & 1) == 1) {
            return -1;
        }
    
        int m = init_state.length, n = init_state[0].length;
    
        Queue<String> beginQueue = new LinkedList<>(), endQueue = new LinkedList<>();
        Set<String> beginVisited = new HashSet<>(), endVisited = new HashSet<>();
        beginQueue.offer(start);
        beginVisited.add(start);
        endQueue.offer(end);
        endVisited.add(end);
        
        int res = 0;
        while (!beginQueue.isEmpty() && !endQueue.isEmpty()) {
            res++;
            if (oneStep(beginQueue, beginVisited, endVisited, m, n)) {
                return res;
            }
            
            res++;
            if (oneStep(endQueue, endVisited, beginVisited, m, n)) {
                return res;
            }
        }
        
        return -1;
    }
    
    private boolean oneStep(Queue<String> beginQueue, Set<String> beginVisited, Set<String> endVisited, int m, int n) {
        int beginSize = beginQueue.size();
        for (int i = 0; i < beginSize; i++) {
            String cur = beginQueue.poll();
            List<String> nexts = getNexts(cur, beginVisited, endVisited, m, n);
            if (nexts == null) {
                return true;
            }
        
            for (String next : nexts) {
                beginVisited.add(next);
                beginQueue.add(next);
            }
        }
        
        return false;
    }
    
    private List<String> getNexts(String cur, Set<String> beginVisited, Set<String> endVisited, int m, int n) {
        List<String> nexts = new ArrayList<>();
        StringBuilder sb = new StringBuilder(cur);
        
        int idx = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '0') {
                idx = i;
                break;
            }
        }
        
        int x1 = idx / n, y1 = idx % n;
        int[] d = {1, 0, -1, 0, 1};
        for (int i = 0; i < 4; i++) {
            int nextX = x1 + d[i], nextY = y1 + d[i + 1];
            if (0 <= nextX && nextX < m && 0 <= nextY && nextY < n) {
                int swapIdx = nextX * n + nextY;
                swapSb(sb, idx, swapIdx);
                
                String next = sb.toString();
                if (endVisited.contains(next)) {
                    return null;
                }
                if (!beginVisited.contains(next)) {
                    nexts.add(next);
                }
                
                swapSb(sb, idx, swapIdx);
            }
        }
        
        return nexts;
    }
    
    private void swapSb(StringBuilder sb, int i, int j) {
        char tmp = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, tmp);
    }
    
    private String stateToString(int[][] state) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < state.length; i++) {
            for (int j = 0; j < state[0].length; j++) {
                sb.append(state[i][j]);
            }
        }
        
        return sb.toString();
    }
    
    private int computeInversePairs(String state) {
        int count = 0;
        for (int i = 0; i < state.length(); i++) {
            for (int j = i + 1; j < state.length(); j++) {
                if (state.charAt(i) > state.charAt(j)) {
                    count++;
                }
            }
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        int[][] s1 = {{2, 8, 3}, {1, 0, 4}, {7, 6, 5}};
        int[][] s2 = {{1, 2, 3}, {8, 0, 4}, {7, 6, 5}};
        
        System.out.println(new Solution().minMoveStep(s1, s2));
    }
}
