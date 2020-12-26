public class Solution {
    /**
     * @param L: Given n pieces of wood with length L[i]
     * @param k: An integer
     * @return: The maximum length of the small pieces
     */
    public int woodCut(int[] L, int k) {
        // write your code here
        if (L == null || L.length == 0) {
            return 0;
        }
        
        int l = 1;
        int r = 0;
        for (int len : L) {
            r = Math.max(r, len);
        }
        
        while (l < r) {
            int m = l + (r - l + 1 >> 1);
            if (count(L, m) < k) {
                r = m - 1;
            } else {
                l = m;
            }
        }
        
        
        return count(L, l) >= k ? l : 0;
    }
    
    private int count(int[] L, int len) {
        int count = 0;
        for (int l : L) {
            count += l / len;
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        int[] L = {232, 124, 456};
        int k = 7;
        System.out.println(new Solution().woodCut(L, k));
    
    }
}