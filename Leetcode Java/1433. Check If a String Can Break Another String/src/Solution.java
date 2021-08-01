public class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        int[] cnt1 = new int[26], cnt2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            cnt1[s1.charAt(i) - 'a']++;
            cnt2[s2.charAt(i) - 'a']++;
        }
        
        boolean smaller = false, greater = false;
        for (int i = 0, j = 0; ; ) {
            while (i < 26 && cnt1[i] == 0) {
                i++;
            }
            while (j < 26 && cnt2[j] == 0) {
                j++;
            }
            if (i == 26 || j == 26) {
                break;
            }
            
            int min = Math.min(cnt1[i], cnt2[j]);
            cnt1[i] -= min;
            cnt2[j] -= min;
            
            if (i < j) {
                smaller = true;
            } else if (i > j) {
                greater = true;
            }
        }
        
        return !(smaller && greater);
    }
}
