import java.util.*;

public class Twitter1 {
    private Map<Integer, Set<Integer>> postMap;
    private Map<Integer, Set<Integer>> followMap;
    private Map<Integer, Integer> timeMap;
    private int time;
    public Twitter1() {
        postMap = new HashMap<>();
        followMap = new HashMap<>();
        timeMap = new HashMap<>();
        time = 0;
    }

    public void postTweet(int userId, int tweetId) {
        Set<Integer> set = postMap.getOrDefault(userId, new HashSet<>());
        set.add(tweetId);
        postMap.putIfAbsent(userId, set);
        timeMap.put(tweetId, time++);
    }

    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> postSet = postMap.getOrDefault(userId, new HashSet<>());
        Set<Integer> followSet = followMap.getOrDefault(userId, new HashSet<>());
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((i1, i2) -> i2[1] - i1[1]);
        for (int i : postSet) {
            maxHeap.offer(new int[]{i, timeMap.get(i)});
        }
        for (int i : followSet) {
            Set<Integer> set = postMap.getOrDefault(i, new HashSet<>());
            for (int j : set) {
                maxHeap.offer(new int[]{j, timeMap.get(j)});
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!maxHeap.isEmpty() && res.size() < 10) {
            res.add(maxHeap.poll()[0]);
        }
        return res;
    }

    public void follow(int followerId, int followeeId) {
        Set<Integer> set = followMap.getOrDefault(followerId, new HashSet<>());
        set.add(followeeId);
        followMap.putIfAbsent(followerId, set);
    }

    public void unfollow(int followerId, int followeeId) {
        followMap.getOrDefault(followerId, new HashSet<>()).remove((Integer)followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */