import java.util.HashSet;
import java.util.Set;

public class Solution {
    /**
     * @param candies: a list of integers
     * @return: return a integer
     */
    public int distributeCandies(int[] candies) {
        // write your code here
        Set<Integer> set = new HashSet<>();
        for (int candy : candies) {
            set.add(candy);
        }
        
        return Math.min(set.size(), candies.length / 2);
    }
}
