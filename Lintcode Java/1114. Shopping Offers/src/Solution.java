import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * @param price: List[int]
     * @param special: List[List[int]]
     * @param needs: List[int]
     * @return: return an integer
     */
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        // write your code here
        int result = 0;
        for (int i = 0; i < price.size(); i++) {
            result += price.get(i) * needs.get(i);
        }
        
        for (int i = 0; i < special.size(); i++) {
            List<Integer> newNeeds = canUseSpecial(special.get(i), needs);
            if (newNeeds != null) {
                result =  Math.min(result, special.get(i).get(needs.size()) + shoppingOffers(price, special, newNeeds));
            }
        }
        
        return result;
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