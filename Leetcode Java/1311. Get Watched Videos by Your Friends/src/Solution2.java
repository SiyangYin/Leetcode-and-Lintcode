import java.util.*;

public class Solution2 {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        int[] dis = new int[friends.length];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[id] = 0;
        int[] plen = new int[friends.length];
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(id);
        
        Set<Integer> fids = new HashSet<>();
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : friends[cur]) {
                if (dis[cur] != Integer.MAX_VALUE && plen[cur] < level && dis[next] > dis[cur] + 1) {
                    dis[next] = dis[cur] + 1;
                    plen[next] = plen[cur] + 1;
                    if (plen[next] == level) {
                        fids.add(next);
                    }
                    queue.offer(next);
                }
            }
        }
        
        Map<String, Integer> count = new HashMap<>();
        for (int fid : fids) {
            for (String vid : watchedVideos.get(fid)) {
                count.put(vid, count.getOrDefault(vid, 0) + 1);
            }
        }
    
        List<String> res = new ArrayList<>(count.keySet());
        res.sort((m1, m2) -> !count.get(m1).equals(count.get(m2)) ? Integer.compare(count.get(m1), count.get(m2)) : m1.compareTo(m2));
    
        return res;
    }
}
