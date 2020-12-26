import java.util.Arrays;

public class Solution {
    /**
     * @param citations: a list of integers
     * @return: return a integer
     */
    public int hIndex(int[] citations) {
        // write your code here
        Arrays.sort(citations);
        
        int l = 0, r = citations.length - 1;
        while (l < r) {
            int tmp = citations[l];
            citations[l] = citations[r];
            citations[r] = tmp;
            l++;
            r--;
        }
        
        l = 0;
        r = citations.length;
        while (l < r) {
            int m = l + (r - l + 1 >> 1);
            if (citations[m - 1] >= m) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        
        return l;
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution().hIndex(new int[]{3, 0, 6, 1, 5}));
        // System.out.println(new Solution().hIndex(new int[]{5, 5, 5, 5, 5}));
        System.out.println(new Solution().hIndex(new int[]{0,0}));
    }
}
