import java.util.Arrays;

public class Solution {
    /**
     * @param S: A list of integers
     * @return: An integer
     */
    public int triangleCount(int[] S) {
        // write your code here
        if (S == null || S.length < 3) {
            return 0;
        }
        
        Arrays.sort(S);
        
        int res = 0;
        for (int i = 2; i < S.length; i++) {
            res += findLarger(S, i);
        }
        
        return res;
    }
    
    public int findLarger(int[] S, int k) {
        int i = 0, j = k - 1;
        
        int count = 0;
        while (i < j) {
            if (S[i] + S[j] > S[k]) {
                count += j - i;
                j--;
            } else {
                i++;
            }
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().triangleCount(new int[]{3, 4, 6, 7}));
    }
}
