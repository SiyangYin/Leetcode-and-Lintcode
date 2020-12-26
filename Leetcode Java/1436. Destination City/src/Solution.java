import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public String destCity(List<List<String>> paths) {
        Set<String> set = new HashSet<>();
        for (List<String> path : paths) {
            set.add(path.get(1));
        }
    
        for (List<String> path : paths) {
            set.remove(path.get(0));
        }
        
        return set.iterator().next();
    }
}
