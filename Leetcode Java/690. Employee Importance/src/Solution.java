import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        
        return dfs(map.get(id), map);
    }
    
    private int dfs(Employee emp, Map<Integer, Employee> map) {
        int sum = emp.importance;
        for (int subId : emp.subordinates) {
            sum += dfs(map.get(subId), map);
        }
        
        return sum;
    }
}

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
}