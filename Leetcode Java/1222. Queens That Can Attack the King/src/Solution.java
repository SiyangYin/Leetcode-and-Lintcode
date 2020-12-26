import java.util.*;

public class Solution {
    
    class Pair {
        int x, y;
        
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public boolean equals(Object o) {
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
    
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> res = new ArrayList<>();
        
        if (queens == null || queens.length == 0) {
            return res;
        }
        
        Set<Pair> set = new HashSet<>();
        for (int[] coord : queens) {
            set.add(new Pair(coord[0], coord[1]));
        }
        
        int[][] d = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
        for (int i = 0; i < d.length; i++) {
            int x = king[0], y = king[1], curX = x, curY = y;
            while (0 <= curX && curX < 8 && 0 <= curY && curY < 8) {
                curX += d[i][0];
                curY += d[i][1];
                if (set.contains(new Pair(curX, curY))) {
                    res.add(new ArrayList<>(Arrays.asList(curX, curY)));
                    break;
                }
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[][] queens = {{0, 1}, {1, 0}, {4, 0}, {0, 4}, {3, 3}, {2, 4}};
        int[] king = {0, 0};
        System.out.println(new Solution().queensAttacktheKing(queens, king));
    }
}
