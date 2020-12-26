import java.util.List;

public class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        
        return dfs(0, rooms, visited) == rooms.size();
    }
    
    private int dfs(int cur, List<List<Integer>> rooms, boolean[] visited) {
        visited[cur] = true;
        int count = 1;
        for (int next : rooms.get(cur)) {
            if (!visited[next]) {
                count += dfs(next, rooms, visited);
            }
        }
        
        return count;
    }
}
