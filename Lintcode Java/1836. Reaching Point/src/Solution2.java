import java.util.Arrays;

public class Solution2 {
    public boolean ReachingPoints(int[] start, int[] target) {
        // write your code here
        if (Arrays.equals(start, target)) {
            return false;
        }
        
        while (!Arrays.equals(start, target)) {
            if (target[0] >= target[1]) {
                target[0] -= target[1];
            } else {
                target[1] -= target[0];
            }
            if (target[0] < start[0] || target[1] < start[1]) {
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution2().ReachingPoints(new int[]{1, 2}, new int[]{3, 4}));
        System.out.println(new Solution2().ReachingPoints(new int[]{1, 2}, new int[]{99840, 40832}));
    }
}
