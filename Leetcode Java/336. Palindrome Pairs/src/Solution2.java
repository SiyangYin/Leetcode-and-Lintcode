import java.util.*;

public class Solution2 {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(new StringBuilder(words[i]).reverse().toString(), i);
        }
        
        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            for (int k = 0; k <= s.length(); k++) {
                String left = s.substring(0, k), right = s.substring(k);
                if (isPalin(right) && map.containsKey(left) && map.get(left) != i) {
                    res.add(Arrays.asList(i, map.get(left)));
                }
                if (isPalin(left) && map.containsKey(right) && map.get(right) != i && words[map.get(right)].length() != s.length()) {
                    res.add(Arrays.asList(map.get(right), i));
                }
            }
        }
        
        return res;
    }
    
    private boolean isPalin(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        String[] ss = {"abcd", "dcba", "lls", "s", "sssll"};
        System.out.println(new Solution2().palindromePairs(ss));
        
        System.out.println("abcd".substring(3));
        System.out.println("abcd".substring(4));
        // System.out.println("abcd".substring(5));
        System.out.println("abcd".substring(0, 1));
        System.out.println("abcd".substring(0, 0));
        System.out.println("abcd".substring(0, 3));
        System.out.println("abcd".substring(0, 4));
        // System.out.println("abcd".substring(0, 5));
    }
}
