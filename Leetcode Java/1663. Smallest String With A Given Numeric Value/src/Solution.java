import java.util.Arrays;

public class Solution {
    public String getSmallestString(int n, int k) {
        char[] chs = new char[n];
        Arrays.fill(chs, 'a');
        k -= n;
        
        for (int i = chs.length - 1; i >= 0; i--) {
            if (k <= 0) {
                break;
            }
            
            if (k >= 'z' - chs[i]) {
                k -= 'z' - chs[i];
                chs[i] = 'z';
            } else {
                chs[i] += k;
                k = 0;
            }
        }
        
        return new String(chs);
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().getSmallestString(3, 27));
    }
}

