public class Solution {
    /**
     * @param arr:   string array
     * @param query: query array
     * @return: return  LCP ans array
     */
    public int[] queryLCP(String[] arr, int[][] query) {
        // write your code here
        long[][] hash = new long[arr.length][];
        for (int i = 0; i < arr.length; i++) {
            String s = arr[i];
            hash[i] = new long[s.length() + 1];
            long p = 131;
            for (int j = 0; j < s.length(); j++) {
                hash[i][j + 1] = hash[i][j] * p + s.charAt(j);
            }
        }
        
        int[] res = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            res[i] = lcp(hash, query[i][0], query[i][1]);
        }
        
        return res;
    }
    
    private int lcp(long[][] hash, int i, int j) {
        int l = 0, r = Math.min(hash[i].length, hash[j].length) - 1;
        while (l < r) {
            int m = l + (r - l + 1 >> 1);
            if (hash[i][m] == hash[j][m]) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        
        return l;
    }
}
