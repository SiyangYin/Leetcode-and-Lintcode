class Solution {
    public int mySqrt(int x) {
        int l = 0, r = x;
        while (l < r) {
            int mid = (int) (l + (((long) (r - l) + 1) >> 1));
            if (mid <= x / mid) {
                l = mid;
            } else if (mid > x / mid) {
                r = mid - 1;
            } else {
                return mid;
            }
        }
        
        return l;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().mySqrt(2147483647));
        System.out.println(Long.MAX_VALUE);
    }
}