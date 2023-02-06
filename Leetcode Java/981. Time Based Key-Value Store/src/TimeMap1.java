import java.util.*;

public class TimeMap1 {
    private Map<String, TreeMap<Integer, String>> map1;
    public TimeMap1() {
        map1 = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> map2 = map1.getOrDefault(key, new TreeMap<>());
        map2.put(timestamp, value);
        map1.putIfAbsent(key, map2);
    }

    public String get(String key, int timestamp) {
        if (map1.containsKey(key)) {
            TreeMap<Integer, String> map2 = map1.get(key);
            if (map2.containsKey(timestamp)) {
                return map2.get(timestamp);
            }
            else {
                if (timestamp < map2.firstKey()) {
                    return "";
                }
                else if (timestamp > map2.lastKey()) {
                    return map2.lastEntry().getValue();
                }
                List<Integer> list = new ArrayList<>(map2.keySet());
                int l = 0, r = list.size() - 1;
                while (l < r) {
                    int m = l + r >> 1;
                    if (list.get(m) < timestamp) {
                        l = m + 1;
                    }
                    else {
                        r = m;
                    }
                }
                return list.get(l) > timestamp ? l == 0 ? "" : map2.get(list.get(l - 1)) : map2.get(list.get(l));
            }
        }
        else {
            return "";
        }
    }

    public static void main(String[] args) {
        TimeMap1 timeMap = new TimeMap1();
        timeMap.set("foo", "bar", 1);  // store the key "foo" and value "bar" along with timestamp = 1.
        System.out.println(timeMap.get("foo", 1));;         // return "bar"
        System.out.println(timeMap.get("foo", 3));         // return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
        timeMap.set("foo", "bar2", 4); // store the key "foo" and value "bar2" along with timestamp = 4.
        System.out.println(timeMap.get("foo", 4));         // return "bar2"
        System.out.println(timeMap.get("foo", 5));         // return "bar2"
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */