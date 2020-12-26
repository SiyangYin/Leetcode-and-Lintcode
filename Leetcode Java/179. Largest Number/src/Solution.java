import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String largestNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int num : nums) {
            list.add(String.valueOf(num));
        }
        
        list.sort((x, y) -> {
            if (x.length() == y.length()) {
                return -x.compareTo(y);
            } else {
                return -(x + y).compareTo(y + x);
            }
        });
        
        StringBuilder sb = new StringBuilder();
        
        for (String s : list) {
            sb.append(s);
        }
    
        int i = 0;
        while (i + 1 < sb.length() && sb.charAt(i) == '0') {
            i++;
        }
    
        return sb.substring(i);
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().largestNumber(new int[]{2, 44, 3, 11}));
    }
}
