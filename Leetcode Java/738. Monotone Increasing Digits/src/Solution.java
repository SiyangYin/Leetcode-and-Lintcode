import java.util.Arrays;

public class Solution {
    public int monotoneIncreasingDigits(int n) {
        char[] s = String.valueOf(n).toCharArray();
        int i = 0;
        while (i + 1 < s.length && s[i] <= s[i + 1]) {
            i++;
        }
        
        if (i == s.length - 1) {
            return n;
        }
        
        int j = i;
        while (j >= 0 && s[j] == s[i]) {
            j--;
        }
        s[j + 1]--;
        Arrays.fill(s, j + 2, s.length, '9');
        
        return Integer.parseInt(new String(s));
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().monotoneIncreasingDigits(10));
        System.out.println(new Solution().monotoneIncreasingDigits(1234));
        System.out.println(new Solution().monotoneIncreasingDigits(332));
        System.out.println(new Solution().monotoneIncreasingDigits(110));
        System.out.println(new Solution().monotoneIncreasingDigits(11));
        System.out.println(new Solution().monotoneIncreasingDigits(121));
    }
}
