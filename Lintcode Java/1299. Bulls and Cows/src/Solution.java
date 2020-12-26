import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String getHint(String secret, String guess) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < secret.length(); i++) {
            map.put(secret.charAt(i), map.getOrDefault(secret.charAt(i), 0) + 1);
        }
    
        int A = 0, B = 0;
        for (int i = 0; i < guess.length(); i++) {
            char g = guess.charAt(i);
            if (g == secret.charAt(i)) {
                A++;
                map.put(g, map.get(g) - 1);
            } else {
                if (map.containsKey(g)) {
                    B++;
                    map.put(g, map.get(g) - 1);
                    if (map.get(g) == 0) {
                        map.remove(g);
                    }
                }
            }
        }
        
        return A + "A" + B + "B";
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().getHint("7810", "1807"));
    }
}
