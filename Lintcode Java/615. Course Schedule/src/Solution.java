import java.util.*;

public class Solution {
    /*
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: true if can finish all courses or false
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // write your code here
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            indegree.put(i, 0);
            graph.put(i, new HashSet<>());
        }
    
        for (int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
    
        for (int key : graph.keySet()) {
            for (int val : graph.get(key)) {
                indegree.put(val, indegree.get(val) + 1);
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree.get(i) == 0) {
                queue.offer(i);
            }
        }
        
        Set<Integer> visited = new HashSet<>();
        visited.addAll(queue);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : graph.get(cur)) {
                indegree.put(next, indegree.get(next) - 1);
                if (indegree.get(next) == 0) {
                    visited.add(next);
                    queue.offer(next);
                }
            }
        }
        
        return visited.size() == numCourses;
    }
    
    public static void main(String[] args) {
        int numOfCourses = 10;
        int[][] pre = {{5, 8}, {3, 5}, {1, 9}, {4, 5}, {0, 2}, {1, 9}, {7, 8}, {4, 9}};
        System.out.println(new Solution().canFinish(numOfCourses, pre));
    }
}
