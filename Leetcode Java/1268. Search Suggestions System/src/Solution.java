import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        Arrays.sort(products);
        
        int l = 0, r = products.length - 1;
        for (int i = 0; i < searchWord.length(); i++) {
            String sub = searchWord.substring(0, i + 1);
            r = products.length - 1;
            while (l < r) {
                int m = l + (r - l >> 1);
                if (products[m].compareTo(sub) >= 0) {
                    r = m;
                } else {
                    l = m + 1;
                }
            }
            
            if (products[l].compareTo(sub) < 0) {
                res.add(new ArrayList<>());
            } else {
                List<String> list = new ArrayList<>();
                for (int j = l; j < l + 3 && j < products.length; j++) {
                    if (products[j].startsWith(sub)) {
                        list.add(products[j]);
                    } else {
                        break;
                    }
                }
                res.add(list);
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        String[] ss = {"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        System.out.println(new Solution().suggestedProducts(ss, "mouse"));
    }
}
