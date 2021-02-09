import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    /**
     * @param price: List[int]
     * @param special: List[List[int]]
     * @param needs: List[int]
     * @return: return an integer
     */
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        // write your code here
        return dfs(price, special, needs, new HashMap<>());
    }
    
    private int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs, Map<List<Integer>, Integer> map) {
        if (map.containsKey(needs)) {
            return map.get(needs);
        }
    
        int res = 0;
        for (int i = 0; i < price.size(); i++) {
            res += price.get(i) * needs.get(i);
        }
    
        for (int i = 0; i < special.size(); i++) {
            List<Integer> newNeeds = canUseSpecial(special.get(i), needs);
            if (newNeeds != null) {
                res =  Math.min(res, special.get(i).get(needs.size()) + shoppingOffers(price, special, newNeeds));
            }
        }
    
        map.put(needs, res);
        return res;
    }
    
    private List<Integer> canUseSpecial(List<Integer> specialOffer, List<Integer> needs) {
        List<Integer> newNeeds = new ArrayList<>();
        for (int i = 0; i < needs.size(); i++) {
            if (needs.get(i) < specialOffer.get(i)) {
                return null;
            } else {
                newNeeds.add(needs.get(i) - specialOffer.get(i));
            }
        }
        
        return newNeeds;
    }
}