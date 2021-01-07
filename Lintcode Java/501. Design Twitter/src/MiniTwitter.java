import java.util.*;

public class MiniTwitter {
    
    private static int time;
    
    class Account {
        int size;
        Node head, tail;
        
        public void add(int time, Tweet tweet) {
            if (size == 0) {
                head = tail = new Node(time, tweet);
                size++;
                return;
            }
            
            head.prev = new Node(time, tweet);
            head.prev.next = head;
            head = head.prev;
            size++;
            if (size > 10) {
                tail = tail.prev;
                tail.next = null;
                size--;
            }
        }
    }
    
    class Node {
        int time;
        Tweet tweet;
        Node prev, next;
        
        public Node(int time, Tweet tweet) {
            this.time = time;
            this.tweet = tweet;
        }
    }
    
    private Map<Integer, Set<Integer>> followMap;
    private Map<Integer, Account> accountMap;
    
    public MiniTwitter() {
        // do intialization if necessary
        followMap = new HashMap<>();
        accountMap = new HashMap<>();
    }
    
    /*
     * @param user_id: An integer
     * @param tweet_text: a string
     * @return: a tweet
     */
    public Tweet postTweet(int user_id, String tweet_text) {
        // write your code here
        accountMap.putIfAbsent(user_id, new Account());
        Tweet tweet = Tweet.create(user_id, tweet_text);
        accountMap.get(user_id).add(time++, tweet);
        
        return tweet;
    }
    
    /*
     * @param user_id: An integer
     * @return: a list of 10 new feeds recently and sort by timeline
     */
    public List<Tweet> getNewsFeed(int user_id) {
        // write your code here
        PriorityQueue<Node> maxHeap = new PriorityQueue<>((n1, n2) -> -Integer.compare(n1.time, n2.time));
        if (accountMap.containsKey(user_id)) {
            Node head = accountMap.get(user_id).head;
            if (head != null) {
                maxHeap.offer(head);
            }
        }
        
        if (followMap.containsKey(user_id)) {
            for (int friend : followMap.get(user_id)) {
                if (accountMap.containsKey(friend)) {
                    Node head = accountMap.get(friend).head;
                    if (head != null) {
                        maxHeap.offer(head);
                    }
                }
            }
        }
        
        List<Tweet> res = new ArrayList<>();
        while (!maxHeap.isEmpty() && res.size() < 10) {
            Node cur = maxHeap.poll();
            res.add(cur.tweet);
            if (cur.next != null) {
                maxHeap.offer(cur.next);
            }
        }
        
        return res;
    }
    
    /*
     * @param user_id: An integer
     * @return: a list of 10 new posts recently and sort by timeline
     */
    public List<Tweet> getTimeline(int user_id) {
        // write your code here
        List<Tweet> res = new ArrayList<>();
        if (!accountMap.containsKey(user_id)) {
            return res;
        }
        
        Node head = accountMap.get(user_id).head;
        while (head != null) {
            res.add(head.tweet);
            head = head.next;
        }
        
        return res;
    }
    
    /*
     * @param from_user_id: An integer
     * @param to_user_id: An integer
     * @return: nothing
     */
    public void follow(int from_user_id, int to_user_id) {
        // write your code here
        followMap.putIfAbsent(from_user_id, new HashSet<>());
        followMap.get(from_user_id).add(to_user_id);
    }
    
    /*
     * @param from_user_id: An integer
     * @param to_user_id: An integer
     * @return: nothing
     */
    public void unfollow(int from_user_id, int to_user_id) {
        // write your code here
        if (followMap.containsKey(from_user_id)) {
            followMap.get(from_user_id).remove(to_user_id);
        }
    }
    
    public static void main(String[] args) {
        MiniTwitter twitter = new MiniTwitter();
        twitter.postTweet(1, "Lintcode is good");
        System.out.println(twitter.getNewsFeed(1));
        System.out.println(twitter.getTimeline(1));
        twitter.follow(2, 1);
        System.out.println(twitter.getNewsFeed(2));
        twitter.unfollow(2, 1);
        System.out.println(twitter.getNewsFeed(2));
    }
}

class Tweet {
    public int id;
    public int user_id;
    public String text;
    
    public static Tweet create(int user_id, String tweet_text) {
        // This will create a new tweet object,
        // and auto fill id
        Tweet tweet = new Tweet();
        tweet.user_id = user_id;
        tweet.text = tweet_text;
        return tweet;
    }
    
    @Override
    public String toString() {
        return "Tweet{" +
                "user_id=" + user_id +
                ", text='" + text + '\'' +
                '}';
    }
}