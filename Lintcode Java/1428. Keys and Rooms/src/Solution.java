import java.util.List;

public class Solution {
    /**
     * @param rooms: a list of keys rooms[i]
     * @return: can you enter every room
     */
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // Write your code here
        boolean[] reachable = new boolean[rooms.size()];
        dfs(0, rooms, reachable);
        for (int i = 0; i < reachable.length; i++) {
            if (!reachable[i]) {
                return false;
            }
        }
        
        return true;
    }
    
    private void dfs(int cur, List<List<Integer>> rooms, boolean[] reachable) {
        reachable[cur] = true;
        for (int next : rooms.get(cur)) {
            if (!reachable[next]) {
                dfs(next, rooms, reachable);
            }
        }
    }
}
