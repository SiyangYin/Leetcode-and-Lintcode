public class Solution {
    public int bitwiseComplement(int N) {
        if (N == 0) {
            return 1;
        }
        
        int res = 0;
        for (int i = 0; N != 0 ; i++) {
            if ((N & 1) == 0) {
                res += 1 << i;
            }
            N >>= 1;
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().bitwiseComplement(5));
    }
}
