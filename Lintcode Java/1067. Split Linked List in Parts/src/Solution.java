import java.util.Arrays;

public class Solution {
    /**
     * @param root: the list
     * @param k:    the split sum
     * @return: the answer
     */
    public int[][] splitLinkedListinParts(int[] root, int k) {
        // Write your code here.
        int[][] res = new int[k][];
        
        int n = root.length, len = n % k, idx = 0;
        for (int i = 0; i < len; i++) {
            res[i] = new int[n / k + 1];
            for (int j = 0; j < res[i].length; j++) {
                res[i][j] = root[idx++];
            }
        }
        
        for (int i = len; i < res.length; i++) {
            res[i] = new int[n / k];
            for (int j = 0; j < res[i].length; j++) {
                res[i][j] = root[idx++];
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution().splitLinkedListinParts(new int[]{1,2,3}, 5)));
    }
}
