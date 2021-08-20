import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * @param a: The A array
     * @param b: The B array
     * @param s: The S string
     * @return: The answer
     */
    public String stringReplace(String[] a, String[] b, String s) {
        // Write your code here
        char[] chs = s.toCharArray();
        long P = 131;
        List<Integer> id = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            id.add(i);
        }
        id.sort((x, y) -> -Integer.compare(a[x].length(), a[y].length()));
        List<Long> hashList = new ArrayList<>();
        for (int idx : id) {
            String t = a[idx];
            long hashT = 0;
            for (int j = 0; j < t.length(); j++) {
                hashT = hashT * P + t.charAt(j);
            }
        
            hashList.add(hashT);
        }
        
        int n = chs.length;
        long[] hash = new long[n + 1], pow = new long[n + 1];
        pow[0] = 1;
        for (int i = 0; i < n; i++) {
            hash[i + 1] = hash[i] * P + chs[i];
            pow[i + 1] = pow[i] * P;
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < id.size(); j++) {
                String old = a[id.get(j)], repl = b[id.get(j)];
                long hashOld = hashList.get(j);
                if (i + old.length() - 1 < n && getHash(hash, i, i + old.length() - 1, pow) == hashOld) {
                    for (int k = 0; k < old.length(); k++) {
                        chs[i + k] = repl.charAt(k);
                    }
                    
                    i += old.length() - 1;
                    break;
                }
            }
        }
        
        return new String(chs);
    }
    
    long getHash(long[] hash, int l, int r, long[] pow) {
        return hash[r + 1] - hash[l] * pow[r - l + 1];
    }
    
    public static void main(String[] args) {
        String[] a = {"ab", "aba"}, b = {"cc", "ccc"};
        System.out.println(new Solution().stringReplace(a, b, "ababa"));
    }
}
