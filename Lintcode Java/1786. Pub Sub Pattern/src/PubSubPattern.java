import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PubSubPattern {
    
    private Map<String, Set<Integer>> map;
    
    public PubSubPattern() {
        // Write your code here
        map = new HashMap<>();
    }
    
    /**
     * @param channel: the channel's name
     * @param user_id: the user who subscribes the channel
     * @return: nothing
     */
    public void subscribe(String channel, int user_id) {
        // Write your code here
        map.putIfAbsent(channel, new HashSet<>());
        map.get(channel).add(user_id);
    }
    
    /**
     * @param channel: the channel's name
     * @param user_id: the user who unsubscribes the channel
     * @return: nothing
     */
    public void unsubscribe(String channel, int user_id) {
        // Write your code here
        Set<Integer> set = map.get(channel);
        if (set != null && !set.isEmpty()) {
            set.remove(user_id);
        }
    }
    
    /**
     * @param channel: the channel's name
     * @param message: the message need to be delivered to the channel's subscribers
     * @return: nothing
     */
    public void publish(String channel, String message) {
        // Write your code here
        Set<Integer> set = map.get(channel);
        if (set != null && !set.isEmpty()) {
            for (int user_id : set) {
                PushNotification.notify(user_id, message);
            }
        }
    }
}

class PushNotification {
    public static void notify(int user_id, String the_message) {}
}