public class Solution {
    /**
     * @param h: hours
     * @param m: minutes
     * @return: angle between hour hand and minute hand at X:Y in a clock
     */
    public float timeAngle(int h, int m) {
        // write your code here
        float res = 0;
        
        float hour = h * 30 + m / 60F * 30F;
        float min = m * 6;
        
        res = hour - min;
        if (res < 0) {
            res = - res;
        }
        
        if (res > 180) {
            res = 360 - res;
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().timeAngle(12, 1));
    }
}
