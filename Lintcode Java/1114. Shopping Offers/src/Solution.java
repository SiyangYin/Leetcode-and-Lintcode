import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

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
    
    
    /**
     *
     * @param specialOffer
     * @param needs
     * @return newNeeds if can use special order, null if otherwise
     */
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
    
    public static void main(String[] args) {
        List<Integer> price = Arrays.asList(2, 3, 4);
        List<List<Integer>> special = new ArrayList<>();
        special.add(Arrays.asList(1, 1, 0, 4));
        special.add(Arrays.asList(2, 2, 1, 9));
        List<Integer> needs = Arrays.asList(1, 2, 1);
        System.out.println(new Solution().shoppingOffers(price, special, needs));
        
    }
}