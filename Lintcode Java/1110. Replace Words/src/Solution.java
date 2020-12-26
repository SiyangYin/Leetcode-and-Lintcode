import java.util.*;

public class Solution {
    /**
     * @param dict: List[str]
     * @param sentence: a string
     * @return: return a string
     */
    public String replaceWords(List<String> dict, String sentence) {
        // write your code here
        dict.sort(Comparator.comparingInt(String::length));
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < dict.size(); j++) {
                if (words[i].startsWith(dict.get(j))) {
                    words[i] = dict.get(j);
                }
            }
        }
        return String.join(" ", words);
    }
    
    public static void main(String[] args) {
        List<String> dict = new ArrayList<>(){{
            add("cat");
            add("bat");
            add("rat");
        }};
        System.out.println(new Solution().replaceWords(dict, "the cattle was rattled by the battery"));
    }
}