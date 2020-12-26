import java.util.*;

public class Solution2 {
    
    class Pair implements Comparable<Pair> {
        
        private String state;
        private int evaluation;
        
        public Pair(String state, int evaluation) {
            this.state = state;
            this.evaluation = evaluation;
        }
        
        @Override
        public int compareTo(Pair o) {
            return Integer.compare(evaluation, o.evaluation);
        }
    }
    
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
        
        List<int[]> pos = position(final_state);
        
        Map<String, Integer> disFromStart = new HashMap<>();
        disFromStart.put(start, 0);
        PriorityQueue<Pair> minHeap = new PriorityQueue<>();
        minHeap.offer(new Pair(start, manhattanDis(start, pos)));
        
        while (!minHeap.isEmpty()) {
            Pair cur = minHeap.poll();
            if (cur.state.equals(end)) {
                return disFromStart.get(cur.state);
            }
            
            for (String next : getNexts(cur.state, 3, 3)) {
                int newDis = disFromStart.get(cur.state) + 1;
                if (!disFromStart.containsKey(next) || disFromStart.get(next) > newDis) {
                    disFromStart.put(next, newDis);
                    minHeap.offer(new Pair(next, disFromStart.get(next) + manhattanDis(next, pos)));
                }
            }
        }
        
        return -1;
    }
    
    private List<String> getNexts(String cur, int m, int n) {
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
                nexts.add(next);
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
    
    private int manhattanDis(String cur, List<int[]> pos) {
        int res = 0;
        for (int i = 0; i < cur.length(); i++) {
            int x = i / 3, y = i % 3;
            int[] chPos = pos.get(cur.charAt(i) - '0');
            res += Math.abs(x - chPos[0]) + Math.abs(y - chPos[1]);
        }
        
        return res;
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
    
    private List<int[]> position(int[][] state) {
        List<int[]> res = new ArrayList<>();
        int m = state.length, n = state[0].length;
        for (int i = 0; i < m * n; i++) {
            res.add(new int[2]);
        }
        
        for (int i = 0; i < state.length; i++) {
            for (int j = 0; j < state[0].length; j++) {
                res.get(state[i][j])[0] = i;
                res.get(state[i][j])[1] = j;
                
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[][] s1 = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};
        int[][] s2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
    
        System.out.println("Correct : " + new Solution().minMoveStep(s1, s2));
        System.out.println("This one : " + new Solution2().minMoveStep(s1, s2));
    
        System.out.println(new Solution2().stateToString(s1));
        System.out.println(new Solution2().getNexts(new Solution2().stateToString(s1), 3, 3));
    }
}
