import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    /**
     * @param a: The Descriptions
     * @return: Every functions' runtime
     */
    public String[] getRuntime(String[] a) {
        // Write your code here
        Map<String, Integer> time = new TreeMap<>();
        Map<String, Integer> startTime = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            String s = a[i];
            if (s.contains("Enter")) {
                String[] pair = s.split(" Enter ");
                startTime.put(pair[0], Integer.parseInt(pair[1]));
            } else {
                String[] pair = s.split(" Exit ");
                String name = pair[0];
                time.put(name, time.getOrDefault(name, 0) + (Integer.parseInt(pair[1]) - startTime.get(name)));
            }
        }
        
        String[] res = new String[time.size()];
        int idx = 0;
        for (Map.Entry<String, Integer> entry : time.entrySet()) {
            res[idx++] = entry.getKey() + "|" + entry.getValue();
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        String[] a = {"F1 Enter 10", "F2 Enter 18", "F2 Exit 19", "F1 Exit 20"};
        System.out.println(Arrays.toString(new Solution().getRuntime(a)));
    }
}
