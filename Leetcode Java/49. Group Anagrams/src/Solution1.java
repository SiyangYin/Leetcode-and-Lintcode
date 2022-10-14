import java.util.*;

public class Solution1 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            String s1 = sortString(s);
            if (map.containsKey(s1)) {
                map.get(s1).add(s);
            }
            else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(s1, list);
            }
        }
        return new ArrayList<>(map.values());
    }

    public String sortString(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}
