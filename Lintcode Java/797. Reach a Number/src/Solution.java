import java.util.Map;

public class Solution {
    /**
     * @param target: the destination
     * @return: the minimum number of steps
     */
    public int reachNumber(int target) {
        // Write your code here
        int i = 0;
        int sum = 0;
        target = Math.abs(target);
        while (sum < target) {
            sum += ++i;
        }
    
        if ((sum - target) % 2 == 0) {
            return i;
        } else {
            if ((sum + i + 1 - target) % 2 == 0) {
                return i + 1;
            } else {
                return i + 2;
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().reachNumber(3));
        System.out.println(new Solution().reachNumber(2));
        System.out.println(new Solution().reachNumber(-2));
        System.out.println(new Solution().reachNumber(0));
    }
}
