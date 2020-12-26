import java.util.*;

public class Solution {
    
    class Pair {
        String s1, s2;
    
        public Pair(String s1, String s2) {
            if (s1.compareTo(s2) <= 0) {
                this.s1 = s1;
                this.s2 = s2;
            } else {
                this.s1 = s2;
                this.s2 = s1;
            }
        }
    
        @Override
        public boolean equals(Object p) {
            Pair pair = (Pair) p;
            return s1.equals(pair.s1) && s2.equals(pair.s2);
        }
    
        @Override
        public int hashCode() {
            return Objects.hash(s1, s2);
        }
    }
    
    public boolean areSentencesSimilar(String[] words1, String[] words2, List<List<String>> pairs) {
        if (words1.length != words2.length) {
            return false;
        }
    
        Map<String, Integer> map = new HashMap<>();
        Set<Pair> set = new HashSet<>();
    
        for (List<String> pair : pairs) {
            set.add(new Pair(pair.get(0), pair.get(1)));
        }
    
        for (int i = 0; i < words1.length; i++) {
            if (words1[i].equals(words2[i])) {
                continue;
            }
            if (!set.contains(new Pair(words1[i], words2[i]))) {
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        // String[] words1 = {"good", "acting", "skills"};
        // String[] words2 = {"fine", "drama", "talent"};
        List<List<String>> pairs = new ArrayList<>();
        // pairs.add(Arrays.asList("great", "fine"));
        // pairs.add(Arrays.asList("good", "great"));
        // pairs.add(Arrays.asList("acting", "drama"));
        // pairs.add(Arrays.asList("skills", "talent"));
        
        String[] words1 = {"good"};
        String[] words2 = {"good"};
        
    
        System.out.println(new Solution().areSentencesSimilar(words1, words2, pairs));
    }
}
