public class Solution {
    public int reachNumber(int target) {
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
}
