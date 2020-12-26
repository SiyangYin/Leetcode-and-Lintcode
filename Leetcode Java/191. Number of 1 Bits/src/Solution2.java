public class Solution2 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n -= n & (-n);
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        int n = 4;
        System.out.println(Integer.toBinaryString(n));
        System.out.println(new Solution2().hammingWeight(n));
    }
}
