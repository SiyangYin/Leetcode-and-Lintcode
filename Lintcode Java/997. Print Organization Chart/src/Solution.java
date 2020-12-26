import java.util.*;

public class Solution {
    
    class Person implements Comparable<Person> {
        String name, pos, year;
        Set<Person> sub;
        
        public Person(String name) {
            this.name = name;
            sub = new TreeSet<>();
        }
    
        @Override
        public int compareTo(Person p) {
            return name.compareTo(p.name);
        }
    }
    
    /**
     * @param relationship: the relationship
     * @return: the organization chart
     */
    public List<String> getOrganization(List<List<String>> relationship) {
        // Write your code here
        List<String> res = new ArrayList<>();
        Person root = buildTree(relationship);
        dfs(root, 0, res);
        return res;
    }
    
    private void dfs(Person cur, int level, List<String> res) {
        StringBuilder sb = new StringBuilder();
    
        sb.append("-".repeat(level)).append(cur.name).append(" (").append(cur.pos).append(") ").append(cur.year);
        res.add(sb.toString());
    
        for (Person sub : cur.sub) {
            dfs(sub, level + 1, res);
        }
    }
    
    private Person buildTree(List<List<String>> relationship) {
        Map<String, Person> map = new HashMap<>();
        Person root = null;
        for (List<String> relation : relationship) {
            String nameSub = relation.get(0), nameSup = relation.get(1);
            if ("NULL".equals(nameSup)) {
                root = map.getOrDefault(nameSub, new Person(relation.get(0)));
                root.pos = relation.get(2);
                root.year = relation.get(3);
                map.put(root.name, root);
                continue;
            }
            
            Person personSub = map.getOrDefault(nameSub, new Person(relation.get(0)));
            map.putIfAbsent(nameSub, personSub);
            personSub.pos = relation.get(2);
            personSub.year = relation.get(3);
            
            Person personSup = map.getOrDefault(nameSup, new Person(relation.get(1)));
            map.putIfAbsent(nameSup, personSup);
            
            personSup.sub.add(personSub);
        }
        
        return root;
    }
    
    public static void main(String[] args) {
        List<List<String>> rel = new ArrayList<>();
        rel.add(Arrays.asList("Karl", "Nancy", "Manager", "2009"));
        rel.add(Arrays.asList("Nancy", "NULL", "CEO", "2007"));
        rel.add(Arrays.asList("Adam", "Karl", "Technician", "2010"));
        rel.add(Arrays.asList("Fred", "Karl", "Worker", "2012"));
        rel.add(Arrays.asList("John", "Fred", "Helper", "2013"));
        System.out.println(new Solution().getOrganization(rel));
    }
}
