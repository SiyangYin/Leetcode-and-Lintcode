import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : arr) {
            int x = a - difference;
            map.put(a, map.getOrDefault(x, 0) + 1);
            res = Math.max(res, map.get(a));
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[] A = {1, 5, 7, 8, 5, 3, 4, 2, 1};
        int d = -2;
        System.out.println(new Solution().longestSubsequence(A, d));
    }
}
