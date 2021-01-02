public class Solution {
    /**
     * @param ages: The ages
     * @return: The answer
     */
    public int friendRequest(int[] ages) {
        // Write your code here
        int res = 0;
        for (int i = 0; i < ages.length - 1; i++) {
            for (int j = i + 1; j < ages.length; j++) {
                if (check(ages[i], ages[j])) {
                    res++;
                }
                if (check(ages[j], ages[i])) {
                    res++;
                }
            }
        }
        
        return res;
    }
    
    private boolean check(int i, int j) {
        return !(j <= i / 2 + 7 || j > i || (j < 100 && i > 100));
    }
}
