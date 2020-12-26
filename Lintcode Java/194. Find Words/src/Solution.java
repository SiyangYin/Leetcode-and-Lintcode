import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /**
     * @param str:  the string
     * @param dict: the dictionary
     * @return: return words which  are subsequences of the string
     */
    public List<String> findWords(String str, List<String> dict) {
        // Write your code here.
        int n = dict.size();
        int[] index = new int[n];
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < n; j++) {
                // 若已经匹配则跳过
                if (index[j] == -1) {
                    continue;
                } else if (dict.get(j).charAt(index[j]) == str.charAt(i)) {
                    //如果主串字符与子串[i]中某个目前需判断字符相同，则index[i]加一后移。
                    index[j]++;
                }
                
                // 若index[j] == words[j].size()说明已经完成匹配
                if (index[j] == dict.get(j).length()) {
                    index[j] = -1;
                }
            }
        }
        
        //遍历答案
        List<String> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (index[i] == -1) {
                res.add(dict.get(i));
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().findWords("nmownhiterer", Arrays.asList("nowhere", "monitor", "moniter")));
    }
}
