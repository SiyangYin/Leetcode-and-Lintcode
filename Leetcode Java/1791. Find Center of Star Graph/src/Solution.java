import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int findCenter(int[][] edges) {
        Set<Integer> set = new HashSet<>();
        for (int[] edge : edges) {
            if (!set.add(edge[0])) {
                return edge[0];
            }
            if (!set.add(edge[1])) {
                return edge[1];
            }
        }
        
        return -1;
    }
}
