import java.util.*;

public class Twitter {
    
    class Account {
        class ListNode {
            int tweet, time;
            ListNode prev, next;
            
            public ListNode(int tweet, int time) {
                this.tweet = tweet;
                this.time = time;
            }
        }
        
        private int size;
        private ListNode head, tail;
        
        public void post(int tweet) {
            if (size == 0) {
                head = tail = new ListNode(tweet, time++);
                size++;
            } else {
                head.prev = new ListNode(tweet, time++);
                head.prev.next = head;
                head = head.prev;
                size++;
                
                if (size > 10) {
                    tail = tail.prev;
                    tail.next = null;
                }
            }
        }
        
        public ListNode getHead() {
            return head;
        }
    }
    
    private static int time;
    private Map<Integer, Set<Integer>> followMap;
    private Map<Integer, Account> accountMap;
    
    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        followMap = new HashMap<>();
        accountMap = new HashMap<>();
    }
    
    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        accountMap.putIfAbsent(userId, new Account());
        accountMap.get(userId).post(tweetId);
    }
    
    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<Account.ListNode> maxHeap = new PriorityQueue<>((t1, t2) -> -Integer.compare(t1.time, t2.time));
        if (accountMap.containsKey(userId)) {
            maxHeap.offer(accountMap.get(userId).getHead());
        }
        
        if (followMap.containsKey(userId)) {
            for (int followee : followMap.get(userId)) {
                if (accountMap.containsKey(followee)) {
                    maxHeap.offer(accountMap.get(followee).getHead());
                }
            }
        }
        
        while (res.size() < 10 && !maxHeap.isEmpty()) {
            Account.ListNode cur = maxHeap.poll();
            res.add(cur.tweet);
            if (cur.next != null) {
                maxHeap.offer(cur.next);
            }
        }
        
        return res;
    }
    
    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }
    
    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
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