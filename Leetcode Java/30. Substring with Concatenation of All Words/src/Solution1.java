import java.util.*;

public class Solution1 {
    public List<Integer> findSubstring(String s, String[] words) {
        Set<Integer> res = new HashSet<>();
        Arrays.sort(words);
        List<String> perms = new ArrayList<>();
        boolean[] used = new boolean[words.length];
        dfs(words, new ArrayList<>(), perms, used);
        for (String str : perms) {
            isSubStr(s, str, res);
        }
        return new ArrayList<>(res);
    }

    public void dfs(String[] A, List<String> list, List<String> res, boolean[] used) {
        if (list.size() == A.length) {
            StringBuilder sb = new StringBuilder();
            list.forEach(s -> sb.append(s));
            res.add(sb.toString());
            return;
        }
        for (int i = 0; i < A.length; i++) {
            if (i > 0 && !used[i - 1] && A[i - 1].equals(A[i])) {
                continue;
            }
            if (!used[i]) {
                list.add(A[i]);
                used[i] = true;
                dfs(A, list, res, used);
                list.remove(list.size() - 1);
                used[i] = false;
            }
        }
    }

    public void isSubStr(String s, String p, Set<Integer> res) {
        if (p.length() > s.length()) {
            return;
        }
        int P = 131;
        int pow = 1;
        int hashS = 0, hashP = 0;
        for (int i = 0; i < p.length(); i++) {
            hashS = hashS * P + s.charAt(i);
            hashP = hashP * P + p.charAt(i);
            pow *= P;
        }
        if (hashS == hashP) {
            res.add(0);
        }
        for (int i = p.length(); i < s.length(); i++) {
            hashS = hashS * P - pow * s.charAt(i - p.length()) + s.charAt(i);
            if(hashS == hashP) {
                res.add(i - p.length() + 1);
            }
        }
        return;
    }
}
