import java.util.Arrays;

public class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (p1, p2) -> Integer.compare(p1[1], p2[1]));
    
        int res = 0, curEnd = Integer.MIN_VALUE;
        for (int i = 0; i < pairs.length; i++) {
            int[] cur = pairs[i];
            if (curEnd < cur[0]) {
                curEnd = cur[1];
                res++;
            }
        }
    
        return res;
    }
    
    public static void main(String[] args) {
        int[][] ps = {{1, 2}, {2,3}, {3,4}};
        System.out.println(new Solution().findLongestChain(ps));
    }
}
