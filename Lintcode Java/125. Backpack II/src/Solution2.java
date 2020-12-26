import java.util.Arrays;

public class Solution2 {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @param V: Given n items with value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int[] V) {
        // write your code here
        int[] f = new int[m + 1];
        
        for (int i = 1; i <= m; i++) {
            f[i] = A[0] <= i ? V[0] : 0;
        }
        
        // f[j] The max value of taking the first i items with total volume <= m
        for (int i = 1; i < A.length; i++) {
            for (int j = m; j >= A[i]; j--) {
                f[j] = Math.max(f[j], f[j - A[i]] + V[i]);
            }
        }
        
        return f[m];
    }
    
    public static void main(String[] args) {
        int[] A = {2, 3, 5, 7};
        int[] V = {1, 5, 2, 4};
        
        System.out.println(new Solution2().backPackII(10, A, V));
        
        A = new int[]{2, 3, 8};
        V = new int[]{2, 5, 8};
        System.out.println(new Solution2().backPackII(10, A, V));
    }
}
