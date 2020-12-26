import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ValidWordAbbr {
    
    Map<String, Integer> dict = new HashMap<>(), abbr = new HashMap<>();
    
    /*
     * @param dictionary: a list of words
     */
    public ValidWordAbbr(String[] dictionary) {
        // do intialization if necessary
        for (String s : dictionary) {
            dict.put(s, dict.getOrDefault(s, 0) + 1);
            String ab = getAbbr(s);
            abbr.put(ab, abbr.getOrDefault(ab, 0) + 1);
        }
    }
    
    /*
     * @param word: a string
     * @return: true if its abbreviation is unique or false
     */
    public boolean isUnique(String word) {
        // write your code here
        return Objects.equals(dict.get(word), abbr.get(getAbbr(word)));
    }
    
    private String getAbbr(String s) {
        if (s.length() <= 2) {
            return s;
        }
        
        return "" + s.charAt(0) + (s.length() - 2) + s.charAt(s.length() - 1);
    }
    
    public static void main(String[] args) {
        ValidWordAbbr v = new ValidWordAbbr(new String[]{"deer", "door", "cake", "card"});
        System.out.println(v.isUnique("dear"));
        System.out.println(v.isUnique("cart"));
        System.out.println(v.isUnique("cane"));
        System.out.println(v.isUnique("make"));
    }
}