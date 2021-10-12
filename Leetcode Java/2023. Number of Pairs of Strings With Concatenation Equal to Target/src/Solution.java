import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int numOfPairs(String[] nums, String s) {
        int n = s.length();
        long[] hashList = new long[nums.length], hashS = new long[n + 1], pow = new long[n + 1];
        long P = 131L;
        pow[0] = 1L;
        for (int i = 0; i < n; i++) {
            hashS[i + 1] = hashS[i] * P + s.charAt(i);
            pow[i + 1] = pow[i] * P;
        }
        
        for (int i = 0; i < nums.length; i++) {
            long hash = 0;
            String num = nums[i];
            for (int j = 0; j < num.length(); j++) {
                hash = hash * P + num.charAt(j);
            }
            
            hashList[i] = hash;
        }
        
        int res = 0;
        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int len = nums[i].length();
            if (len > n) {
                continue;
            }
            
            if (hashList[i] == getHash(hashS, 0, len - 1, pow)) {
                res += map.getOrDefault(getHash(hashS, len, n - 1, pow), 0);
            }
            if (hashList[i] == getHash(hashS, n - len, n - 1, pow)) {
                res += map.getOrDefault(getHash(hashS, 0, n - len - 1, pow), 0);
            }
            
            map.put(hashList[i], map.getOrDefault(hashList[i], 0) + 1);
        }
        
        return res;
    }
    
    long getHash(long[] hashS, int l, int r, long[] pow) {
        return hashS[r + 1] - hashS[l] * pow[r - l + 1];
    }
    
    public static void main(String[] args) {
        String[] ss = {"1", "111"};
        String t = "11";
        System.out.println(new Solution().numOfPairs(ss, t));
    }
}
