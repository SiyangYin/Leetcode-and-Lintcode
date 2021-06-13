import java.util.List;

public class Solution {
    /**
     * @param coordinates: a series of coordinates (x, y)
     * @return: Given a series of coordinates (x, y),return the shortest sum of distance
     */
    public int Fetchsupplies(List<List<Integer>> coordinates) {
        // write your code here
        int res = 0;
        coordinates.sort((p1, p2) -> Integer.compare(p1.get(0), p2.get(0)));
        for (List<Integer> co : coordinates) {
            res += Math.abs(co.get(0) - coordinates.get(coordinates.size() - 1 >> 1).get(0));
        }
        
        return res;
    }
}
