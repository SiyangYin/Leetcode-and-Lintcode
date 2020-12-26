import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ValidWordAbbr {
    
    private Map<String, Integer> dict, abbr;
    
    public ValidWordAbbr(String[] dictionary) {
        dict = new HashMap<>();
        abbr = new HashMap<>();
        for (String s : dictionary) {
            dict.put(s, dict.getOrDefault(s, 0) + 1);
            String ab = abbreviate(s);
            abbr.put(ab, abbr.getOrDefault(ab, 0) + 1);
        }
    }
    
    public boolean isUnique(String word) {
        return Objects.equals(dict.get(word), abbr.get(abbreviate(word)));
    }
    
    private String abbreviate(String s) {
        if (s.length() <= 2) {
            return s;
        }
        
        return "" + s.charAt(0) + (s.length() - 2) + s.charAt(s.length() - 1);
    }
}
