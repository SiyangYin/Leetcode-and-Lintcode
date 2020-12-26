import java.util.*;

public class Solution2 {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        
        int res = 0;
        Queue<Employee> queue = new ArrayDeque<>();
        queue.offer(map.get(id));
        while (!queue.isEmpty()) {
            Employee cur = queue.poll();
            res += cur.importance;
            for (int subId : cur.subordinates) {
                queue.offer(map.get(subId));
            }
        }
        
        return res;
    }
}
