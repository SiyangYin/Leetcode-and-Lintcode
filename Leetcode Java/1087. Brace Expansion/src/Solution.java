import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public String[] expand(String S) {
        List<String> ans = new ArrayList<>();
        List<List<Character>> lists = new ArrayList<>();
        
        for (int i = 0, j = 0; i < S.length(); i++) {
            if (S.charAt(i) != '{') {
                lists.add(new ArrayList<>(Arrays.asList(S.charAt(i))));
            } else {
                j = i;
                while (j < S.length() && S.charAt(j) != '}') {
                    j++;
                }
                
                String sub = S.substring(i + 1, j);
                String[] ss = sub.split(",");
                List<Character> list = new ArrayList<>();
                for (String s : ss) {
                    list.add(s.charAt(0));
                }
                list.sort((c1, c2) -> Character.compare(c1, c2));
                lists.add(list);
                
                i = j;
            }
        }
        
        dfs(0, new StringBuilder(), lists, ans);
        
        String[] res = new String[ans.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = ans.get(i);
        }
        
        return res;
    }
    
    private void dfs(int idx, StringBuilder sb, List<List<Character>> lists, List<String> res) {
        if (idx == lists.size()) {
            res.add(sb.toString());
            return;
        }
        
        for (int i = 0; i < lists.get(idx).size(); i++) {
            sb.append(lists.get(idx).get(i));
            dfs(idx + 1, sb, lists, res);
            sb.setLength(sb.length() - 1);
        }
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().expand("{a,b}c{d,e}f")));
    }
}
