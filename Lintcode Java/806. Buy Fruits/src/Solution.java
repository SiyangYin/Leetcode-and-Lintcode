import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /**
     * @param codeList:     The codeList
     * @param shoppingCart: The shoppingCart
     * @return: The answer
     */
    public int buyFruits(List<List<String>> codeList, List<String> shoppingCart) {
        // Write your code here
        List<String> list = new ArrayList<>();
        for (List<String> strs : codeList) {
            list.addAll(strs);
        }
        
        for (int i = 0; i + list.size() - 1 < shoppingCart.size(); i++) {
            int j = 0;
            while (j < list.size() && (shoppingCart.get(i + j).equals(list.get(j)) || "anything".equals(list.get(j)))) {
                j++;
            }
            
            if (j == list.size()) {
                return 1;
            }
        }
        
        return 0;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().buyFruits(
                Arrays.asList(
                        Arrays.asList("apple", "apple"),
                        Arrays.asList("orange", "banana", "orange")),
                Arrays.asList("orange", "apple", "apple", "orange", "banana", "orange")));
    }
}
