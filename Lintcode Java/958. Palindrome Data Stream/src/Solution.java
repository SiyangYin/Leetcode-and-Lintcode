import java.util.Arrays;

public class Solution {
    /**
     * @param s: The data stream
     * @return: Return the judgement stream
     */
    public int[] getStream(String s) {
        // Write your code here
        int[] res = new int[s.length()], count = new int[26];
        int odd = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            count[ch - 'a']++;

            if (count[ch - 'a'] % 2 != 0) {
                odd++;
            } else {
                odd--;
            }

            res[i] = odd <= 1 ? 1 : 0;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().getStream("aaaaa")));
    }

}
