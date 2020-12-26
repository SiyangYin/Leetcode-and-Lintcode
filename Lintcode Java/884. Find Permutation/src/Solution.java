import java.util.Arrays;

public class Solution {
    /**
     * @param s: a string
     * @return: return a list of integers
     */
    public int[] findPermutation(String s) {
        // write your code here
        int[] res = new int[s.length() + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = i + 1;
        }
    
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'D') {
                int j = i;
                while (j < s.length() && s.charAt(j) == 'D') {
                    j++;
                }
                
                reverse(res, i, j);
                
                i = j;
            }
        }
        
        return res;
    }
    
    private void reverse(int[] A, int i, int j) {
        for (; i < j; i++, j--) {
            int tmp = A[i];
            A[i] = A[j];
            A[j] = tmp;
        }
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().findPermutation("DI")));
    }
}
