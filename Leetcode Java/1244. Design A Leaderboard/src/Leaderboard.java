import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;

public class Leaderboard {
    
    private TreeSet<Integer> set;
    private Map<Integer, Integer> map;
    
    public Leaderboard() {
        set = new TreeSet<>((x, y) -> {
            int sx = map.get(x), sy = map.get(y);
            return sx != sy ? Integer.compare(sx, sy) : Integer.compare(x, y);
        });
        map = new HashMap<>();
    }
    
    public void addScore(int playerId, int score) {
        if (map.containsKey(playerId)) {
            set.remove(playerId);
        }
        
        map.put(playerId, map.getOrDefault(playerId, 0) + score);
        set.add(playerId);
    }
    
    public int top(int K) {
        int res = 0;
        Iterator<Integer> it = set.descendingIterator();
        while (it.hasNext() && K > 0) {
            res += map.get(it.next());
            K--;
        }
        
        return res;
    }
    
    public void reset(int playerId) {
        set.remove(playerId);
        map.remove(playerId);
    }
    
    public static void main(String[] args) {
        Leaderboard l = new Leaderboard();
        l.addScore(1, 73);
        l.addScore(2, 56);
        l.addScore(3, 39);
        l.addScore(4, 51);
        l.addScore(5, 4);
        System.out.println(l.top(1));
        l.reset(1);
        l.reset(2);
        l.addScore(2, 51);
        System.out.println(l.top(3));
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */