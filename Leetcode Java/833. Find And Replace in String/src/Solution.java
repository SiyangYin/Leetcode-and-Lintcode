import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        Map<Integer, String> smap = new HashMap<>(), tmap = new HashMap<>();
        for (int i = 0; i < indices.length; i++) {
            smap.put(indices[i], sources[i]);
            tmap.put(indices[i], targets[i]);
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0, j = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (smap.containsKey(i)) {
                int k = i;
                String source = smap.get(i);
                for (; k < s.length() && k < i + source.length(); k++) {
                    if (s.charAt(k) != source.charAt(k - i)) {
                        break;
                    }
                }
                
                if (k == source.length() + i) {
                    sb.setLength(sb.length() - 1);
                    sb.append(tmap.get(i));
                    i += source.length() - 1;
                }
                
                j++;
            }
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        String s = "vmokgggqzp";
        int[] ind = {3, 5, 1};
        String[] so = {"kg", "ggq", "mo"};
        String[] t = {"s", "so", "bfr"};
        
        System.out.println(new Solution().findReplaceString(s, ind, so, t));
    }
}
