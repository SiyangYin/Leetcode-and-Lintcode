import java.util.*;

public class Solution {
    /**
     * @param start: a point [x, y]
     * @param target: a point [x, y]
     * @return: return True or False
     */
    public boolean ReachingPoints(int[] start, int[] target) {
        // write your code here
        if (Arrays.equals(start, target)) {
            return true;
        }
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        Set<String> visited = new HashSet<>();
        visited.add(arrayToString(start));
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int[] neighbor1 = {cur[0], cur[0] + cur[1]};
            int[] neighbor2 = {cur[0] + cur[1], cur[1]};
            if (Arrays.equals(target, neighbor1) || Arrays.equals(target, neighbor2)) {
                return true;
            }
            if (!(neighbor1[0] > target[0] || neighbor1[1] > target[1])) {
                if (!visited.contains(arrayToString(neighbor1))) {
                    queue.offer(neighbor1);
                }
            }
            
            if (!(neighbor2[0] > target[0] || neighbor2[1] > target[1])) {
                if (!visited.contains(arrayToString(neighbor2))) {
                    queue.offer(neighbor2);
                }
            }
        }
        
        return false;
    }
    
    private String arrayToString(int[] cur) {
        return String.valueOf(cur[0]) + ',' + cur[1];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().ReachingPoints(new int[]{1, 2}, new int[]{3, 4}));
    }
}
