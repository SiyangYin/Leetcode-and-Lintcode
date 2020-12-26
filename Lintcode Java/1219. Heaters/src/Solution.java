import java.util.Arrays;

public class Solution {
    /**
     * @param houses:  positions of houses
     * @param heaters: positions of heaters
     * @return: the minimum radius standard of heaters
     */
    public int findRadius(int[] houses, int[] heaters) {
        // Write your code here
        Arrays.sort(heaters);
        int res = 0;
    
        for (int i = 0; i < houses.length; i++) {
            res = Math.max(res, findClosestRadius(heaters, houses[i]));
        }
        
        return res;
    }
    
    private int findClosestRadius(int[] heaters, int house) {
        int res = Integer.MAX_VALUE;
        int l = 0, r = heaters.length - 1;
        while (l < r) {
            int m = l + (r - l + 1 >> 1);
            if (heaters[m] <= house) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        if (house >= heaters[l]) {
            res = Math.min(res, house - heaters[l]);
        }
        
        l = 0;
        r = heaters.length - 1;
        while (l < r) {
            int m = l + (r - l >> 1);
            if (heaters[m] >= house) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        if (heaters[l] >= house) {
            res = Math.min(res, heaters[l] - house);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[] houses = {1, 2, 3}, heat = {2};
        System.out.println(new Solution().findRadius(houses, heat));
    }
}
