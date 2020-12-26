import java.util.*;

public class TopK {
    
    private int k;
    private Map<String, Integer> map;
    private TreeSet<String> set;
    
    /*
     * @param k: An integer
     */
    public TopK(int k) {
        // do intialization if necessary
        this.k = k;
        map = new HashMap<>();
        set = new TreeSet<>((s1, s2) -> {
            if (!map.get(s1).equals(map.get(s2))) {
                return -Integer.compare(map.get(s1), map.get(s2));
            }
            
            return s1.compareTo(s2);
        });
    }
    
    /*
     * @param word: A string
     * @return: nothing
     */
    public void add(String word) {
        // write your code here
        if (map.containsKey(word)) {
            if (set.contains(word)) {
                set.remove(word);
            }
            
            map.put(word, map.get(word) + 1);
        } else {
            map.put(word, 1);
        }
    
        set.add(word);
        if (set.size() > k) {
            set.pollLast();
        }
    }
    
    /*
     * @return: the current top k frequent words.
     */
    public List<String> topk() {
        // write your code here
        return new ArrayList<>(set);
    }
    
    public static void main(String[] args) {
        TopK topK = new TopK(2);
        topK.add("lint");
        topK.add("code");
        topK.add("code");
        topK.add("coding");
        topK.add("coding");
        topK.add("coding");
        topK.add("lint");
        topK.add("lint");
        System.out.println(topK.topk());
    }
}
