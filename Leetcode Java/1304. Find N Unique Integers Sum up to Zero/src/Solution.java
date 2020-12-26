import java.util.Arrays;

public class Solution {
    public int[] sumZero(int n) {
        int[] res = new int[n];
        int start = 0;
        if (n % 2 != 0) {
            start++;
        }
        
        for (int i = start, j = 1; i < n; i += 2, j++) {
            res[i] = j;
            res[i + 1] = -j;
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().sumZero(5)));
    }
}
