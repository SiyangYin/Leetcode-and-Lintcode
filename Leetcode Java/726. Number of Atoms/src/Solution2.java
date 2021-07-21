import java.util.*;

public class Solution2 {
    public String countOfAtoms(String s) {
        Deque<Map<String, Integer>> stk = new LinkedList<>();
        stk.push(new HashMap<>());
        for (int i = 0; i < s.length(); ) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stk.push(new HashMap<>());
                i++;
            } else if (ch == ')') {
                i++;
                int j = i;
                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                    j++;
                }
    
                int cnt = j > i ? Integer.parseInt(s.substring(i, j)) : 1;
                Map<String, Integer> pop = stk.pop(), top = stk.peek();
                for (Map.Entry<String, Integer> entry : pop.entrySet()) {
                    String e = entry.getKey();
                    int val = entry.getValue();
                    top.put(e, top.getOrDefault(e, 0) + cnt * val);
                }
                
                i = j;
            } else {
                int j = i + 1;
                while (j < s.length() && Character.isLowerCase(s.charAt(j))) {
                    j++;
                }
    
                String e = s.substring(i, j);
                i = j;
                while (j < s.length() && Character.isDigit(s.charAt(j))){
                    j++;
                }
                
                int cnt = j > i ? Integer.parseInt(s.substring(i, j)) : 1;
                Map<String, Integer> top = stk.peek();
                top.put(e, top.getOrDefault(e, 0) + cnt);
    
                i = j;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : new TreeMap<>(stk.peek()).entrySet()) {
            sb.append(entry.getKey());
            if (entry.getValue() > 1) {
                sb.append(entry.getValue());
            }
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution2().countOfAtoms("H2O"));
        System.out.println(new Solution2().countOfAtoms("H(OH)2"));
        System.out.println(new Solution2().countOfAtoms("K4(ON(SO3)2)2"));
    }
}
