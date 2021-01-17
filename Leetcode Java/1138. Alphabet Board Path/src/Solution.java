import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String alphabetBoardPath(String target) {
        Map<Character, int[]> map = new HashMap<>();
        for (char ch = 'a', i = 0; ch <= 'z'; ch++, i++) {
            map.put(ch, new int[]{i / 5, i % 5});
        }
        
        int[] cur = {0, 0};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < target.length(); i++) {
            char ch = target.charAt(i);
            int[] next = map.get(ch);
            sb.append(buildPath(cur, next, map)).append('!');
            cur = next;
        }
        
        return sb.toString();
    }
    
    private String buildPath(int[] cur, int[] next, Map<Character, int[]> map) {
        if (Arrays.equals(cur, next)) {
            return "";
        }
        
        char x = 0, y = 0;
        x = cur[0] < next[0] ? 'D' : 'U';
        y = cur[1] < next[1] ? 'R' : 'L';
        StringBuilder sb = new StringBuilder();
        if (Arrays.equals(map.get('z'), cur)) {
            move(sb, Math.abs(cur[0] - next[0]), x);
            move(sb, Math.abs(cur[1] - next[1]), y);
        } else {
            move(sb, Math.abs(cur[1] - next[1]), y);
            move(sb, Math.abs(cur[0] - next[0]), x);
        }
        
        return sb.toString();
    }
    
    private void move(StringBuilder sb, int step, char l) {
        for (int i = 0; i < step; i++) {
            sb.append(l);
        }
    }
}
