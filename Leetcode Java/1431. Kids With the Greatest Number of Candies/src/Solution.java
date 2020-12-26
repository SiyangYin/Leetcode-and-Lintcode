import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new ArrayList<>();
        if (candies == null || candies.length == 0) {
            return res;
        }
        
        int max = 0;
        for (int candy : candies) {
            max = Math.max(max, candy);
        }
    
        for (int candy : candies) {
            res.add(candy + extraCandies >= max);
        }
        
        return res;
    }
}
