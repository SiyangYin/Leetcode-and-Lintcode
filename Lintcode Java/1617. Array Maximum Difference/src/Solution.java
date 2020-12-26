public class Solution {
    /**
     * @param a: the array a
     * @return: return the maximum value
     */
    public int getAnswer(int[] a) {
        // Write your code here
        int ans = 0, n = a.length;
        for (int i = 0; i < n; i++) {
            if (a[i] % 2 == 0) {
                for (int j = i - 1; j >= 0; j--) {
                    if (a[j] % 2 == 1) {
                        ans = Math.max(ans, a[i] - a[j]);
                    }
                }
            }
        }
        return ans;
    }
}
