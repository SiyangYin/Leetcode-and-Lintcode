import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        
        if (digits == null || digits.isEmpty()) {
            return res;
        }
        
        String[] letterMap = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        res.add("");
        
        for (int i = 0; i < digits.length(); i++) {
            String button = letterMap[digits.charAt(i) - '2'];
            List<String> cur = new ArrayList<>();
            for (int j = 0; j < button.length(); j++) {
                for (int k = 0; k < res.size(); k++) {
                    cur.add(res.get(k) + button.charAt(j));
                }
            }
            
            res = cur;
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution2().letterCombinations("23"));
    }
}
