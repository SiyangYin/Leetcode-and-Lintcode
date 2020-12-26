import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {
    /**
     * @param start:
     * @param end:
     * @param bank:
     * @return: the minimum number of mutations needed to mutate from "start" to "end"
     */
    public int minMutation(String start, String end, String[] bank) {
        // Write your code here
        if (start.equals(end)) {
            return 0;
        }
        
        Set<String> setBank = new HashSet<>();
        for (String s : bank) {
            setBank.add(s);
        }
        
        if (!setBank.contains(end)) {
            return -1;
        }
    
        char[] genes = {'A', 'C', 'G', 'T'};
        
        Queue<String> beginQueue = new LinkedList<>(), endQueue = new LinkedList<>();
        Set<String> beginVisited = new HashSet<>(), endVisited = new HashSet<>();
        beginQueue.offer(start);
        beginVisited.add(start);
        endQueue.offer(end);
        endVisited.add(end);
        
        int res = 0;
        while (!beginQueue.isEmpty() && !endQueue.isEmpty()) {
            int beginSize = beginQueue.size(), endSize = endQueue.size();
            for (int i = 0; i < beginSize; i++) {
                String cur = beginQueue.poll();
                if (endVisited.contains(cur)) {
                    return res;
                }
                for (String neighbor : getNeighbors(cur, setBank, beginVisited, genes)) {
                    beginQueue.offer(neighbor);
                    beginVisited.add(neighbor);
                }
            }
            res++;
    
            for (int i = 0; i < endSize; i++) {
                String cur = endQueue.poll();
                if (beginVisited.contains(cur)) {
                    return res;
                }
                for (String neighbor : getNeighbors(cur, setBank, endVisited, genes)) {
                    endQueue.offer(neighbor);
                    endVisited.add(neighbor);
                }
            }
            res++;
        }
        
        return -1;
    }
    
    private Set<String> getNeighbors(String start, Set<String> bank, Set<String> visited, char[] genes) {
        Set<String> neighbors = new HashSet<>();
        for (int i = 0; i < start.length(); i++) {
            for (char gene : genes) {
                if (start.charAt(i) != gene) {
                    String neighbor = start.substring(0, i) + gene + start.substring(i + 1);
                    if (bank.contains(neighbor) && !visited.contains(neighbor)) {
                        neighbors.add(neighbor);
                    }
                }
            }
        }
        
        return neighbors;
    }
    
    
}
