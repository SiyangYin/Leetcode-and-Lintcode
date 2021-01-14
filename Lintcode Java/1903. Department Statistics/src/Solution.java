import java.util.*;

public class Solution {
    /**
     * @param employees:   information of the employees
     * @param friendships: the friendships of employees
     * @return: return the statistics
     */
    public List<String> departmentStatistics(List<String> employees, List<String> friendships) {
        // write your code here.
        Map<String, Set<Integer>> deptEmps = new HashMap<>();
        Map<Integer, String> idToDept = new HashMap<>();
        for (String employee : employees) {
            String[] split = employee.split(", ");
            String dept = split[2];
            int id = Integer.parseInt(split[0]);
            deptEmps.putIfAbsent(dept, new HashSet<>());
            deptEmps.get(dept).add(id);
            idToDept.put(id, dept);
        }
        
        Map<String, Set<Integer>> count = new HashMap<>();
        for (String friendship : friendships) {
            String[] split = friendship.split(", ");
            int id1 = Integer.parseInt(split[0]), id2 = Integer.parseInt(split[1]);
            String dept1 = idToDept.get(id1), dept2 = idToDept.get(id2);
            if (dept1.equals(dept2)) {
                continue;
            }
            
            count.putIfAbsent(dept1, new HashSet<>());
            count.get(dept1).add(id1);
            count.putIfAbsent(dept2, new HashSet<>());
            count.get(dept2).add(id2);
        }
        
        List<String> res = new ArrayList<>();
        for (Map.Entry<String, Set<Integer>> entry : deptEmps.entrySet()) {
            String dept = entry.getKey();
            int total = entry.getValue().size(), num = count.getOrDefault(dept, new HashSet<>()).size();
            res.add(dept + ": " + num + " of " + total);
        }
        
        return res;
    }
}
