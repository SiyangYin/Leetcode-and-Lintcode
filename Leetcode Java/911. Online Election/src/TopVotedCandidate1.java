import java.util.HashMap;
import java.util.Map;

public class TopVotedCandidate1 {
    private Map<Integer, Integer> map1;
    private Map<Integer, Integer> map2;
    private int[] persons;
    private int[] times;
    public TopVotedCandidate1(int[] persons, int[] times) {
        map1 = new HashMap<>();
        map2 = new HashMap<>();
        this.persons = persons;
        this.times = times;
        int max = 0;
        int person = 0;
        for (int i = 0; i < times.length; i++) {
            map1.put(persons[i], map1.getOrDefault(persons[i], 0) + 1);
            if (map1.get(persons[i]) >= max) {
                max = map1.get(persons[i]);
                person = persons[i];
            }
            map2.put(i, person);
        }
    }

    public int q(int t) {
        int l = 0, r = times.length - 1;
        while (l < r) {
            int m = l + r >> 1;
            if (times[m] < t) {
                l = m + 1;
            }
            else {
                r = m;
            }
        }
        if (times[l] > t) {
            l--;
        }
        return map2.get(l);
    }
    
    public static void main(String[] args) {
        TopVotedCandidate1 topVotedCandidate = new TopVotedCandidate1(new int[]{0, 1, 1, 0, 0, 1, 0}, new int[]{0, 5, 10, 15, 20, 25, 30});
        System.out.println(topVotedCandidate.q(3));
        System.out.println(topVotedCandidate.q(12));
        System.out.println(topVotedCandidate.q(25));
        System.out.println(topVotedCandidate.q(15));
    }
}
