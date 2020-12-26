import java.util.*;

public class Solution {
    /**
     * @param org: a permutation of the integers from 1 to n
     * @param seqs: a list of sequences
     * @return: true if it can be reconstructed only one or false
     */
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        // write your code here
        Map<Integer, Set<Integer>> nexts = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();
        
        if (org.length == 0 && (seqs.length == 0 || (seqs.length == 1 && seqs[0].length == 0))) {
            return true;
        }
        
        if (org.length == 0 || seqs.length == 0 || seqs[0].length == 0) {
            return false;
        }
    
        for (int i : org) {
            indegree.put(i, 0);
            nexts.put(i, new HashSet<>());
        }
        
        for (int[] seq : seqs) {
            if (seq[0] <= 0 || seq[0] > org.length) {
                return false;
            }
            
            for (int i = 0; i < seq.length - 1; i++) {
                if (seq[i + 1] <= 0 || seq[i + 1] > org.length) {
                    return false;
                }
                
                if (nexts.get(seq[i]).add(seq[i + 1])) {
                    indegree.put(seq[i + 1], indegree.getOrDefault(seq[i + 1], 0) + 1);
                }
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : indegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.offer(entry.getKey());
            }
        }
        
        int ind = 0;
        while (!queue.isEmpty()) {
            if (queue.size() != 1) {
                return false;
            }
            
            int cur = queue.poll();
            if (ind >= org.length || org[ind] != cur) {
                return false;
            }
            
            for (int next : nexts.get(cur)) {
                indegree.put(next, indegree.get(next) - 1);
                if (indegree.get(next) == 0) {
                    queue.offer(next);
                }
            }
            ind++;
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        // int[] org = {1, 2 ,3 };
        int[] org = {5, 3, 2, 4, 1};
        // int[][] seqs = {{3, 2}, {2, 1}};
        int[][] seqs = {{5, 3, 2, 4}, {4, 1}, {1}, {3}, {2, 4}, {1000000000}};
        System.out.println(new Solution().sequenceReconstruction(org, seqs));
    }
}
