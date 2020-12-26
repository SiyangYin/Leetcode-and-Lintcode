import java.util.List;

public class Solution {
    /**
     * @param employees:
     * @param id:
     * @return: the total importance value
     */
    public int getImportance(List<Employee> employees, int id) {
        // Write your code here.
        if (employees == null || employees.isEmpty()) {
            return 0;
        }
        
        return dfs(employees.get(id - 1), employees);
    }
    
    private int dfs(Employee employee, List<Employee> employees) {
        int res = employee.importance;
        for (int subordinate : employee.subordinates) {
            res += dfs(employees.get(subordinate - 1), employees);
        }
        
        return res;
    }
}

class Employee {
    int id, importance;
    List<Integer> subordinates;
}