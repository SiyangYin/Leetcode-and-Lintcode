public class Solution2 {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int left = 0, right = x;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (mid < x / mid) {
                left = mid;
            } else if (mid > x / mid) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        
        if (right <= x / right) {
            return right;
        } else {
            return left;
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().mySqrt(2147395599));
        System.out.println(new Solution().mySqrt(2));
    }
}
