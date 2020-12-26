import java.util.Arrays;

public class Solution {
    
    class Log implements Comparable<Log> {
        String id, content;
        
        public Log(String id, String content) {
            this.id = id;
            this.content = content;
        }
        
        @Override
        public int compareTo(Log o) {
            boolean letter1 = Character.isLetter(content.charAt(0)), letter2 = Character.isLetter(o.content.charAt(0));
            
            if (letter1 && letter2) {
                int comp = content.compareTo(o.content);
                return comp != 0 ? comp : id.compareTo(o.id);
            }
            
            if (!letter1 && letter2) {
                return 1;
            }
            
            if (!letter2 && letter1) {
                return -1;
            }
            
            return 0;
        }
    }
    
    /**
     * @param logs: the logs
     * @return: the log after sorting
     */
    public String[] logSort(String[] logs) {
        // Write your code here
        Log[] logsTmp = new Log[logs.length];
        for (int i = 0; i < logs.length; i++) {
            String log = logs[i];
            int j = 0;
            for (; j < log.length() && log.charAt(j) != ' '; j++) {
            
            }
            
            logsTmp[i] = new Log(log.substring(0, j), log.substring(j + 1));
        }
        
        Arrays.sort(logsTmp);
        
        String[] res = new String[logs.length];
        for (int i = 0; i < res.length; i++) {
            Log log = logsTmp[i];
            res[i] = log.id + " " + log.content;
        }
        
        return res;
    }
}
