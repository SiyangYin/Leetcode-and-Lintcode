import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * @param stores: The location of each store.
     * @param houses: The location of each house.
     * @return: The location of the nearest store to each house.
     */
    public List<Integer> findNearestStore(List<Integer> stores, List<Integer> houses) {
        stores.sort((s1, s2) -> Integer.compare(s1, s2));
        
        List<Integer> res = new ArrayList<>();
        for (int house : houses) {
            res.add(binarySearch(stores, house));
        }
        
        return res;
    }
    
    private int binarySearch(List<Integer> list, int target) {
        int l = 0, r = list.size() - 1;
        while (l < r) {
            int m = l + (r - l + 1 >> 1);
            if (list.get(m) <= target) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        
        int res = list.get(l);
        if (l + 1 < list.size() && list.get(l + 1) - target < target - res) {
            res = list.get(l + 1);
        }
        
        return res;
    }
}