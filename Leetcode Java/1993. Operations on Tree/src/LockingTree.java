import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class LockingTree {
    private Map<Integer, List<Integer>> map;
    private Map<Integer, Integer> lockMap;
    private int[] parent;
    public LockingTree(int[] parent) {
        this.parent = parent;
        map = new HashMap<>();
        lockMap = new HashMap<>();
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] != -1) {
                List<Integer> list = map.getOrDefault(parent[i], new ArrayList<>());
                list.add(i);
                map.putIfAbsent(parent[i], list);
            }
        }
    }

    public boolean lock(int num, int user) {
        if (!lockMap.containsKey(num)) {
            lockMap.put(num, user);
            return true;
        }
        else {
            return false;
        }
    }

    public boolean unlock(int num, int user) {
        if (lockMap.containsKey(num) && lockMap.get(num) == user) {
            lockMap.remove(num);
            return true;
        }
        else {
            return false;
        }
    }

    public boolean upgrade(int num, int user) {
        if (lockMap.containsKey(num)) {
            return false;
        }
        int i = parent[num];
        while (i != -1) {
            if (lockMap.containsKey(i)) {
                return false;
            }
            i = parent[i];
        }
        if (findAndUnlockDescendant(num)) {
            lockMap.put(num, user);
            return true;
        }
        else {
            return false;
        }
    }

    public boolean findAndUnlockDescendant(int i) {
        boolean res = false;
        if (map.containsKey(i)) {
            List<Integer> list = map.get(i);
            for (int j : list) {
                if (lockMap.containsKey(j)) {
                    lockMap.remove(j);
                    res = true;
                }
                if (findAndUnlockDescendant(j)) {
                    res = true;
                }
            }
        }
        return res;
    }
} 