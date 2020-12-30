import java.util.*;

public class Solution {
    
    class Visit {
        String username, website;
        int timestamp;
        
        public Visit(String username, String website, int timestamp) {
            this.username = username;
            this.website = website;
            this.timestamp = timestamp;
        }
    }
    
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        int n = username.length;
        List<Visit> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Visit(username[i], website[i], timestamp[i]));
        }
        list.sort((v1, v2) -> Integer.compare(v1.timestamp, v2.timestamp));
        
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Visit visit = list.get(i);
            map.putIfAbsent(visit.username, new ArrayList<>());
            map.get(visit.username).add(visit.website);
        }
        
        Map<List<String>, Integer> count = new HashMap<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            List<String> webList = entry.getValue();
            if (webList.size() >= 3) {
                Set<List<String>> set = new HashSet<>();
                for (int i = 0; i < webList.size() - 2; i++) {
                    for (int j = i + 1; j < webList.size() - 1; j++) {
                        for (int k = j + 1; k < webList.size(); k++) {
                            List<String> tuple = Arrays.asList(webList.get(i), webList.get(j), webList.get(k));
                            set.add(tuple);
                        }
                    }
                }
                for (List<String> tuple : set) {
                    count.put(tuple, count.getOrDefault(tuple, 0) + 1);
                }
            }
        }
        
        List<String> res = new ArrayList<>();
        int maxCount = 0;
        for (Map.Entry<List<String>, Integer> entry : count.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                res = entry.getKey();
            } else if (entry.getValue() == maxCount && compare(entry.getKey(), res) < 0) {
                res = entry.getKey();
            }
        }
        
        return res;
    }
    
    private int compare(List<String> l1, List<String> l2) {
        for (int i = 0; i < 3; i++) {
            int comp = l1.get(i).compareTo(l2.get(i));
            if (comp != 0) {
                return comp;
            }
        }
        
        return 0;
    }
}
