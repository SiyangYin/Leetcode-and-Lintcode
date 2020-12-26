public class Solution {
    public int findComplement(int num) {
        int res = 0, pos = 0;
        while (num != 0) {
            res += (num & 1 ^ 1) << pos;
            num >>>= 1;
            pos++;
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().findComplement(5));
    }
}
