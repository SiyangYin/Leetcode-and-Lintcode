import java.util.*;

public class Solution {
    /*
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: the course order
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // write your code here
        int[] res = new int[numCourses];
        Map<Integer, Set<Integer>> nexts = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            nexts.put(i, new HashSet<>());
            indegree.put(i, 0);
        }
        
        for (int[] courses : prerequisites) {
            nexts.get(courses[1]).add(courses[0]);
        }
    
        for (int pre : nexts.keySet()) {
            for (int post : nexts.get(pre)) {
                indegree.put(post, indegree.get(post) + 1);
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        int ind = 0;
        for (int i = 0; i < numCourses; i++) {
            if (indegree.get(i) == 0) {
                queue.offer(i);
                res[ind++] = i;
            }
        }
        
        Set<Integer> visited = new HashSet<>(queue);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : nexts.get(cur)) {
                indegree.put(next, indegree.get(next) - 1);
                if (indegree.get(next) == 0) {
                    visited.add(next);
                    queue.offer(next);
                    res[ind++] = next;
                }
            }
        }
        
        return visited.size() == numCourses ? res : new int[0];
    }
}
