import java.util.*;

public class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> deadset = new HashSet<>(Arrays.asList(deadends));
        
        if (deadset.contains(target) || deadset.contains("0000")) {
            return -1;
        }
        if ("0000".equals(target)) {
            return 0;
        }
        
        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> visited = new HashMap<>();
        queue.add("0000");
        visited.put("0000", 0);
        
        while (!queue.isEmpty()) {
            String curs = queue.poll();
            char[] curarray = curs.toCharArray();
            List<String> nexts = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                char o = curarray[i];
                curarray[i] = Character.forDigit((curarray[i] - '0' + 1) % 10, 10);
                nexts.add(new String(curarray));
                curarray[i] = o;
                
                curarray[i] = Character.forDigit((curarray[i] - '0' - 1 + 10) % 10, 10);
                nexts.add(new String(curarray));
                curarray[i] = o;
            }
    
            for (String next : nexts) {
                if (!deadset.contains(next) && !visited.containsKey(next)) {
                    queue.offer(next);
                    visited.put(next, visited.get(curs) + 1);
                    if (next.equals(target)) {
                        return visited.get(next);
                    }
                }
            }
        }
        
        return -1;
    }
}
