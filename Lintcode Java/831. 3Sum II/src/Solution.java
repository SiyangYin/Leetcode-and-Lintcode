public class Solution {
    
    
    /**
     * @param n: an integer
     * @return: the number of solutions
     */
    public int threeSum2(int n) {
        // Write your code here
        int res = 0;
        if (n < 0) {
            return 0;
        }
        
        for (int x = 0; x <= Math.sqrt(n / 3); x++) {
            int l = x, r = (int) Math.sqrt(n - x * x);
            int remain = n - x * x;
            while (l <= r) {
                int sum = l * l + r * r;
                if (sum < remain) {
                    l++;
                } else if (sum > remain) {
                    r--;
                } else {
                    res++;
                    l++;
                    r--;
                }
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().threeSum2(1));
        System.out.println(new Solution().threeSum2(0));
    }
}
