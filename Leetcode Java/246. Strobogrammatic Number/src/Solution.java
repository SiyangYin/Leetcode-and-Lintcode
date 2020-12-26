import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Solution {
    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');
        for (int i = 0, j = num.length() - 1; i <= j; i++, j--) {
            char left = num.charAt(i), right = num.charAt(j);
            if (i != j && !Objects.equals(map.get(left), right)) {
                return false;
            }
            if (i == j) {
                return map.containsKey(left) && map.get(left) == left;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().isStrobogrammatic("25"));
    }
}
