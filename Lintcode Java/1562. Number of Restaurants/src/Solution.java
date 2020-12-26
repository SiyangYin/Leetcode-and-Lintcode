import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * @param restaurant:
     * @param n:
     * @return: nothing
     */
    public List<List<Integer>> nearestRestaurant(List<List<Integer>> restaurant, int n) {
        // Write your code here
        if (restaurant.size() == n) {
            return restaurant;
        }
        
        if (restaurant.size() < n) {
            return new ArrayList<>();
        }
        
        List<List<Integer>> res = new ArrayList<>(restaurant);
        res.sort((r1, r2) -> Integer.compare(disSqr(r1), disSqr(r2)));
        
        List<Integer> farthest = res.get(n - 1);
        int farDisSqr = disSqr(farthest);
        List<List<Integer>> list = new ArrayList<>();
        for (List<Integer> rest : restaurant) {
            if (disSqr(rest) <= farDisSqr) {
                list.add(rest);
            }
            
            if (list.size() == n) {
                break;
            }
        }
        
        return list;
    }
    
    private int disSqr(List<Integer> rest) {
        int x = rest.get(0), y = rest.get(1);
        return x * x + y * y;
    }
}
