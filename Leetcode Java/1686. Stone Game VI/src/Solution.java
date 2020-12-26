import java.util.Arrays;

public class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int n = aliceValues.length;
        int[][] points = new int[n][2];
        for (int i = 0; i < n; i++) {
            points[i][0] = aliceValues[i];
            points[i][1] = bobValues[i];
        }
        
        Arrays.sort(points, (p1, p2) -> -Integer.compare(p1[0] + p1[1], p2[0] + p2[1]));
        int aScore = 0, bScore = 0;
        for (int i = 0; i < points.length; i++) {
            if (i % 2 == 0) {
                aScore += points[i][0];
            } else {
                bScore += points[i][1];
            }
        }
        
        return Integer.compare(aScore, bScore);
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().stoneGameVI(new int[]{1, 3}, new int[]{2, 1}));
        System.out.println(new Solution().stoneGameVI(
                new int[]{1, 2},
                new int[]{3, 1}));
    }
}
