import java.util.*;

public class Solution {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        if (seqs == null || seqs.isEmpty()) {
            return false;
        }
        
        Map<Integer, Integer> indegrees = new HashMap<>();
        Map<Integer, List<Integer>> graph = buildGraph(seqs, indegrees);
        Queue<Integer> queue = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : indegrees.entrySet()) {
            if (entry.getValue() == 0) {
                queue.offer(entry.getKey());
            }
        }
        
        if (org.length != indegrees.size()) {
            return false;
        }
        
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            if (queue.size() != 1) {
                return false;
            }
            
            int cur = queue.poll();
            res.add(cur);
            if (graph.containsKey(cur)) {
                for (int next : graph.get(cur)) {
                    indegrees.put(next, indegrees.get(next) - 1);
                    if (indegrees.get(next) == 0) {
                        queue.offer(next);
                    }
                }
            }
        }
    
        if (org.length != res.size()) {
            return false;
        }
        
        for (int i = 0; i < org.length; i++) {
            if (org[i] != res.get(i)) {
                return false;
            }
        }
        
        return true;
    }
    
    private Map<Integer, List<Integer>> buildGraph(List<List<Integer>> seqs, Map<Integer, Integer> indegrees) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (List<Integer> seq : seqs) {
            if (seq.size() == 1) {
                indegrees.putIfAbsent(seq.get(0), 0);
            }
            
            for (int i = 0; i < seq.size() - 1; i++) {
                graph.putIfAbsent(seq.get(i), new ArrayList<>());
                graph.get(seq.get(i)).add(seq.get(i + 1));
                indegrees.put(seq.get(i + 1), indegrees.getOrDefault(seq.get(i + 1), 0) + 1);
            }
        }
        
        return graph;
    }
    
    public static void main(String[] args) {
        int[] org = {1};
        List<List<Integer>> seqs = new ArrayList<>();
        seqs.add(Arrays.asList(1));
        seqs.add(Arrays.asList(2, 3));
        seqs.add(Arrays.asList(3, 2));
        System.out.println(new Solution().sequenceReconstruction(org, seqs));
    }
}
