import java.util.*;

public class Solution {
    public int minMutation(String start, String end, String[] bank) {
        char[] genes = "ACGT".toCharArray();
        Set<String> set = new HashSet<>(Arrays.asList(bank));
        
        if (!set.contains(end)) {
            return -1;
        }
        
        if (start.equals(end)) {
            return 0;
        }
        
        Queue<String> bq = new LinkedList<>(), eq = new LinkedList<>();
        Set<String> bvis = new HashSet<>(), evis = new HashSet<>();
        bq.offer(start);
        eq.offer(end);
        bvis.add(start);
        evis.add(end);
        
        int res = 0;
        while (!bq.isEmpty() && !eq.isEmpty()) {
            res++;
            if (bq.size() <= eq.size()) {
                if (oneStep(bq, bvis, evis, set, genes)) {
                    return res;
                }
            } else {
                if (oneStep(eq, evis, bvis, set, genes)) {
                    return res;
                }
            }
        }
        
        return -1;
    }
    
    boolean oneStep(Queue<String> bq, Set<String> bvis, Set<String> evis, Set<String> set, char[] genes) {
        for (int i = bq.size(); i > 0; i--) {
            char[] s = bq.poll().toCharArray();
            for (int j = 0; j < s.length; j++) {
                char old = s[j];
                for (char gene : genes) {
                    if (old != gene) {
                        s[j] = gene;
                        String t = new String(s);
                        if (set.contains(t) && !bvis.contains(t)) {
                            if (evis.contains(t)) {
                                return true;
                            }
                            
                            bvis.add(t);
                            bq.offer(t);
                        }
                    }
                }
                s[j] = old;
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        String start = "AACCGGTT", end = "AACCGGTA";
        String[] bank = {"AACCGGTA"};
        System.out.println(new Solution().minMutation(start, end, bank));
    }
}
