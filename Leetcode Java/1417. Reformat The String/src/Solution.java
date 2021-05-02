import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String reformat(String s) {
        List<Character>[] list = (List<Character>[]) new List[2];
        list[0] = new ArrayList<>();
        list[1] = new ArrayList<>();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetter(ch)) {
                list[0].add(ch);
            } else if (Character.isDigit(ch)) {
                list[1].add(ch);
            }
        }
        
        if (Math.abs(list[0].size() - list[1].size()) >= 2) {
            return "";
        }
        
        if (list[0].size() < list[1].size()) {
            List<Character> tmp = list[0];
            list[0] = list[1];
            list[1] = tmp;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0, j = 0; i < list[0].size() || j < list[1].size(); i++, j++) {
            sb.append(list[0].get(i));
            if (j < list[1].size()) {
                sb.append(list[1].get(j));
            }
        }
        
        return sb.toString();
    }
}
