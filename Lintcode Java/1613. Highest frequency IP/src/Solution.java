import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * @param ipLines: ip  address
     * @return: return highestFrequency ip address
     */
    public String highestFrequency(String[] ipLines) {
        // Write your code here
        int maxFrequency = 0;
        Map<String, Integer> frequencies = new HashMap<>();
        for (String ipLine : ipLines) {
            frequencies.put(ipLine, frequencies.getOrDefault(ipLine, 0) + 1);
            maxFrequency = Math.max(frequencies.get(ipLine), maxFrequency);
        }
        
        for (Map.Entry<String, Integer> entry : frequencies.entrySet()) {
            if (entry.getValue() == maxFrequency) {
                return entry.getKey();
            }
        }
        
        return "";
    }
}
