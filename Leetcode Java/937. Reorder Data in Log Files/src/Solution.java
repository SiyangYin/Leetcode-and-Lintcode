import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String[]> letterList = new ArrayList<>();
        List<String> digitList = new ArrayList<>();
    
        for (String log : logs) {
            for (int i = 0; i < log.length(); i++) {
                if (log.charAt(i) == ' ') {
                    if (Character.isLetter(log.charAt(i + 1))) {
                        letterList.add(new String[]{log.substring(0, i), log.substring(i + 1)});
                    } else {
                        digitList.add(log);
                    }
                    
                    break;
                }
            }
        }
        
        letterList.sort((l1, l2) -> {
            int comp = l1[1].compareTo(l2[1]);
            if (comp != 0) {
                return comp;
            } else {
                return l1[0].compareTo(l2[0]);
            }
        });
        
        String[] res = new String[logs.length];
        for (int i = 0; i < res.length; i++) {
            if (i < letterList.size()) {
                String[] strs = letterList.get(i);
                res[i] = strs[0] + " " + strs[1];
            } else {
                res[i] = digitList.get(i - letterList.size());
            }
        }
        
        return res;
    }
}
