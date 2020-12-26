import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * @param lines: the text to compress.
     * @return: return the text after compression.
     */
    public String[] textCompression(String[] lines) {
        // write your code here.
        String[] res = new String[lines.length];
    
        Map<String, Integer> map = new HashMap<>();
        int count = 1;
        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < line.length(); j++) {
                char ch = line.charAt(j);
                if (!Character.isLetter(ch)) {
                    sb.append(ch);
                } else {
                    int k = j;
                    while (k < line.length() && Character.isLetter(line.charAt(k))) {
                        k++;
                    }
                    
                    String next = line.substring(j, k);
                    if (map.containsKey(next)) {
                        sb.append(map.get(next));
                    } else {
                        map.put(next, count++);
                        sb.append(next);
                    }
                    
                    j = k - 1;
                }
            }
            
            res[i] = sb.toString();
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        String[] l = {"Please, please do it--it would please Mary very,", "very much.", "","Thanks"};
        System.out.println(Arrays.toString(new Solution().textCompression(l)));
    }
}
