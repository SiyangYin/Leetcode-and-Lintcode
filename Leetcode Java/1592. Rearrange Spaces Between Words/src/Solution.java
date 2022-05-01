import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String reorderSpaces(String text) {
        List<String> list = new ArrayList<>();
        int cntW = 0, cntS = 0;
        for (int i = 0; i < text.length(); i++) {
            int j = i;
            if (text.charAt(j) != ' ') {
                while (j < text.length() && text.charAt(j) != ' ') {
                    j++;
                }
                list.add(text.substring(i, j));
                cntW++;
            } else {
                while (j < text.length() && text.charAt(j) == ' ') {
                    j++;
                    cntS++;
                }
            }
            
            i = j - 1;
        }
        
        StringBuilder sb = new StringBuilder();
        if (cntW == 1) {
            sb.append(list.get(0)).append(" ".repeat(cntS));
            return sb.toString();
        }
        
        int len = cntS / (cntW - 1);
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i != list.size() - 1) {
                sb.append(" ".repeat(len));
            }
        }
        
        sb.append(" ".repeat(cntS % (cntW - 1)));
        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().reorderSpaces("this    is a  "));
    }
}
