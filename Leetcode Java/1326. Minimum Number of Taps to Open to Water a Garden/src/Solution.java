public class Solution {
    public int minTaps(int n, int[] ranges) {
        int[] end = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int st = Math.max(0, i - ranges[i]), ed = Math.min(n, i + ranges[i]);
            end[st] = Math.max(end[st], ed - st);
        }
        
        int res = 0, curEnd = 0, curFar = 0;
        for (int i = 0; i < n; i++) {
            if (i > curEnd) {
                return -1;
            }
            
            curFar = Math.max(curFar, i + end[i]);
            if (i == curEnd) {
                res++;
                curEnd = curFar;
            }
        }
        
        return curEnd >= n ? res : -1;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().minTaps(3, new int[]{2, 0, 0, 0}));
        System.out.println(new Solution().minTaps(3, new int[]{0, 0, 0, 0}));
        System.out.println(new Solution().minTaps(5, new int[]{3, 4, 1, 1, 0, 0}));
    }
}
