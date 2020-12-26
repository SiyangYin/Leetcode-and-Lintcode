import java.util.Timer;

public class Solution2 {
    /**
     * @param pages: an array of integers
     * @param k: An integer
     * @return: an integer
     */
    public int copyBooks(int[] pages, int k) {
        // write your code here
        if (pages == null || pages.length == 0) {
            return 0;
        }
        
        int l = 0, r = 0;
        for (int page : pages) {
            l = Math.max(l, page);
            r += page;
        }
        
        while (l < r) {
            int m = l + (r - l >> 1);
            if (check(pages, m, k)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        
        return l;
    }
    
    private boolean check(int[] pages, int time, int k) {
        int count = 1;
        int sum = 0;
        for (int i = 0; i < pages.length; i++) {
            sum += pages[i];
            if (sum > time) {
                i--;
                count++;
                sum = 0;
            }
        }
        
        return count <= k;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution2().copyBooks(new int[]{3, 2, 4}, 2));
    }
}
