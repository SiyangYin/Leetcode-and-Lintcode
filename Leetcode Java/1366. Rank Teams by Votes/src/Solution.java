import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String rankTeams(String[] votes) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < votes[0].length(); i++) {
            list.add(votes[0].charAt(i));
        }
    
        int[][] rank = new int[26][votes[0].length()];
    
        for (String vote : votes) {
            for (int i = 0; i < vote.length(); i++) {
                rank[vote.charAt(i) - 'A'][i]++;
            }
        }
    
        list.sort((c1, c2) -> {
            for (int i = 0; i < votes[0].length(); i++) {
                if (rank[c1 - 'A'][i] != rank[c2 - 'A'][i]) {
                    return -Integer.compare(rank[c1 - 'A'][i], rank[c2 - 'A'][i]);
                }
            }
        
            return Character.compare(c1, c2);
        });
    
        StringBuilder sb = new StringBuilder();
        for (char ch : list) {
            sb.append(ch);
        }
        
        return sb.toString();
    }
}
