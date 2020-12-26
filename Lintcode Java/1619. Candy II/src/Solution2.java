import java.util.Arrays;

public class Solution2 {
    /**
     * @param ratings: rating value of each child
     * @return: Return the minimum candies you must give.
     */
    public int candyII(int[] ratings) {
        // Write your code here
        int len = ratings.length;
        int[] dpLeft = new int[len], dpRight = new int[len];
    
        Arrays.fill(dpLeft, 1);
        Arrays.fill(dpRight, 1);
    
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] == ratings[i - 1]) {
                dpLeft[i] = dpLeft[i - 1];
            } else if (ratings[i] > ratings[i - 1]) {
                dpLeft[i] = 1 + dpLeft[i - 1];
            }
        }
    
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] == ratings[i + 1]) {
                dpRight[i] = dpRight[i + 1];
            } else if (ratings[i] > ratings[i + 1]) {
                dpRight[i] = 1 + dpRight[i + 1];
            }
        }
        
        int res = 0;
        for (int i = 0; i < len; i++) {
            res += Math.max(dpLeft[i], dpRight[i]);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution2().candyII(new int[]{4, 7, 8, 1, 6, 6, 2}));
        System.out.println(new Solution2().candyII(new int[]{1, 2, 3, 4, 5, 5, 4, 3, 2}));
        System.out.println(new Solution2().candyII(new int[]{10, 10, 10, 10, 2, 1}));
    }
}
