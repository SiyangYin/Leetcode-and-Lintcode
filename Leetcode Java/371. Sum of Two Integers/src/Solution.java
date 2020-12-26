class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            int a1 = a ^ b;
            int b1 = (a & b) << 1;
            a = a1;
            b = b1;
        }
        return a;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().getSum(-2, 3));
    }
}