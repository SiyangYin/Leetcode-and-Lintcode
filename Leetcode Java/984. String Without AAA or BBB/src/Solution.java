import java.util.Arrays;

public class Solution {
    public String strWithout3a3b(int A, int B) {
        char[] str = new char[A + B];
        char c1 = 'a', c2 = 'b';
        if (A < B) {
            c1 = 'b';
            c2 = 'a';
            
            int in = A;
            A = B;
            B = in;
        }
        
        Arrays.fill(str, c1);
        for (int i = 2; i < str.length; i += 3) {
            if (B > 0) {
                str[i] = c2;
                B--;
            }
        }
        
        if (B == 0) {
            return new String(str);
        }
        
        for (int i = 1; i < str.length; i += 3) {
            if (B > 0) {
                str[i] = c2;
                B--;
            }
        }
        
        return new String(str);
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().strWithout3a3b(5, 3));
        System.out.println(new Solution().strWithout3a3b(1, 2));
    }
}
