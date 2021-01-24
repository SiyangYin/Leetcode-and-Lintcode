import java.util.HashMap;
import java.util.Map;

public class TopVotedCandidate {
    
    private int[] leader, times;
    
    public TopVotedCandidate(int[] persons, int[] times) {
        this.times = times;
        leader = new int[persons.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0, v = 0; i < persons.length; i++) {
            map.put(persons[i], map.getOrDefault(persons[i], 0) + 1);
            if (map.get(persons[i]) >= v) {
                v = map.get(persons[i]);
                leader[i] = persons[i];
            } else {
                leader[i] = leader[i - 1];
            }
        }
    }
    
    public int q(int t) {
        int l = 0, r = times.length - 1;
        while (l < r) {
            int m = l + (r - l + 1 >> 1);
            if (times[m] <= t) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        
        return leader[l];
    }
    
    public static void main(String[] args) {
        TopVotedCandidate topVotedCandidate = new TopVotedCandidate(new int[]{0, 1, 1, 0, 0, 1, 0}, new int[]{0, 5, 10, 15, 20, 25, 30});
        System.out.println(topVotedCandidate.q(3));
        System.out.println(topVotedCandidate.q(12));
        System.out.println(topVotedCandidate.q(25));
        System.out.println(topVotedCandidate.q(15));
    }
}
