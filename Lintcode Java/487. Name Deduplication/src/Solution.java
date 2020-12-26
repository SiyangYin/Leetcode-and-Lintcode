import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    /**
     * @param names: a string array
     * @return: a string array
     */
    public List<String> nameDeduplication(String[] names) {
        // write your code here
        Set<String> set = new HashSet<>();
        for (String name : names) {
            set.add(name.toLowerCase());
        }
        
        return new ArrayList<>(set);
    }
}
