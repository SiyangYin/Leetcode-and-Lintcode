import java.util.*;

public class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        List<String> res = new ArrayList<>();
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(id);
        Set<Integer> visited = new HashSet<>();
        visited.add(id);
        
        int curLevel = 0;
        Set<Integer> friendsIds = new HashSet<>();
        while (!queue.isEmpty()) {
            curLevel++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                for (int next : friends[cur]) {
                    if (visited.contains(next)) {
                        continue;
                    }
                    
                    if (curLevel == level) {
                        friendsIds.add(next);
                    }
                    
                    if (curLevel < level) {
                        visited.add(next);
                        queue.offer(next);
                    }
                }
            }
            
            if (curLevel == level) {
                break;
            }
        }
        
        Map<String, Integer> count = new HashMap<>();
        for (int i = 0; i < watchedVideos.size(); i++) {
            if (friendsIds.contains(i)) {
                for (String video : watchedVideos.get(i)) {
                    count.put(video, count.getOrDefault(video, 0) + 1);
                }
            }
        }
        
        res.addAll(count.keySet());
        res.sort((m1, m2) -> !count.get(m1).equals(count.get(m2)) ? Integer.compare(count.get(m1), count.get(m2)) : m1.compareTo(m2));
        
        return res;
    }
}
