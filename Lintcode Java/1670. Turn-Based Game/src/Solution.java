import java.util.Arrays;

public class Solution {
    /**
     * @param atk: the atk of monsters
     * @return: Output the minimal damage QW will suffer
     */
    public long getAns(int[] atk) {
        // Write your code here
        Arrays.sort(atk);
        long suffer = 0;
        for (int i = 0; i < atk.length; i++) {
            suffer += (long) atk[i] * (atk.length - 1 - i);
        }
        return suffer;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().getAns(new int[]{3, 1, 2, 5}));
    }
}