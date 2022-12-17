import java.util.*;

class TweetCounts {
    Map<String, TreeMap<Integer, Integer>> map1;
    public TweetCounts() {
        map1 = new HashMap<>();
    }

    public void recordTweet(String tweetName, int time) {
        TreeMap<Integer, Integer> map2 = map1.getOrDefault(tweetName, new TreeMap<>());
        map2.put(time, map2.getOrDefault(time, 0) + 1);
        map1.putIfAbsent(tweetName, map2);
    }

    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        List<Integer> res = new ArrayList<>();
        if (map1.containsKey(tweetName)) {
            int chunk = 86400;
            switch (freq) {
                case "minute":
                    chunk = 60;
                    break;
                case "hour":
                    chunk = 3600;
                    break;
                case "day":
                    chunk = 86400;
                    break;
            }
            List<Integer> list = new ArrayList<>();
            TreeMap<Integer, Integer> map2 = map1.get(tweetName);
            for (Map.Entry<Integer, Integer> entry : map2.entrySet()) {
                for (int i = 0; i < entry.getValue(); i++) {
                    list.add(entry.getKey());
                }
            }
            for (int i = 0; i <= (endTime - startTime) / chunk; i++) {
                int start = startTime + i * chunk;
                int end = Math.min(startTime + (i + 1) * chunk - 1, endTime);
                int l1 = 0, r1 = list.size() - 1;
                while (l1 < r1) {
                    int m = l1 + r1 >> 1;
                    if (list.get(m) < start) {
                        l1 = m + 1;
                    }
                    else {
                        r1 = m;
                    }
                }
                if (list.get(l1) < start) {
                    l1++;
                }
                int l2 = 0, r2 = list.size() - 1;
                while (l2 < r2) {
                    int m = l2 + r2 >> 1;
                    if (list.get(m) < end) {
                        l2 = m + 1;
                    }
                    else {
                        r2 = m;
                    }
                }
                if (list.get(l2) > end) {
                    l2--;
                }
                res.add(l2 - l1 + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TweetCounts tweetCounts = new TweetCounts();
        tweetCounts.recordTweet("tweet3",0);
        tweetCounts.recordTweet("tweet3",60);
        tweetCounts.recordTweet("tweet3",10);
        System.out.println(tweetCounts.getTweetCountsPerFrequency("minute","tweet3",0,59));
        System.out.println(tweetCounts.getTweetCountsPerFrequency("minute","tweet3",0,60));
        tweetCounts.recordTweet("tweet3",120);
        System.out.println(tweetCounts.getTweetCountsPerFrequency("hour","tweet3",0,210));
    }
}
