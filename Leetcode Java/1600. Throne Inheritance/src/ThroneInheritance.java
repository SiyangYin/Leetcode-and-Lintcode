import java.util.*;

class ThroneInheritance {
    private Map<String, List<String>> map;
    private Set<String> set;
    private String kingName;
    public ThroneInheritance(String kingName) {
        map = new HashMap<>();
        set = new HashSet<>();
        this.kingName = kingName;
    }

    public void birth(String parentName, String childName) {
        List<String> list = map.getOrDefault(parentName, new ArrayList<>());
        list.add(childName);
        map.putIfAbsent(parentName, list);
    }

    public void death(String name) {
        set.add(name);
    }

    public List<String> getInheritanceOrder() {
        return dfs(kingName, new ArrayList<>());
    }

    public List<String> dfs(String name, List<String> res) {
        if (!set.contains(name)) {
            res.add(name);
        }
        if (map.containsKey(name)) {
            List<String> list = map.get(name);
            for (String s : list) {
                dfs(s, res);
            }
        }
        return res;
    }
}