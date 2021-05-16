import java.util.ArrayList;
import java.util.List;

public class Solution {
    
    class TimeStamp implements Comparable<TimeStamp> {
        int time, flag;
        
        public TimeStamp(int time, int flag) {
            this.time = time;
            this.flag = flag;
        }
        
        @Override
        public int compareTo(TimeStamp o) {
            if (time != o.time) {
                return Integer.compare(time, o.time);
            }
            
            return Integer.compare(flag, o.flag);
        }
    }
    
    public int maximumPopulation(int[][] logs) {
        List<TimeStamp> list = new ArrayList<>();
        for (int[] log : logs) {
            list.add(new TimeStamp(log[0], 1));
            list.add(new TimeStamp(log[1], 0));
        }
        
        list.sort((t1, t2) -> t1.compareTo(t2));
        
        int res = Integer.MAX_VALUE, cnt = 0, maxCnt = 0;
        for (TimeStamp timeStamp : list) {
            if (timeStamp.flag == 1) {
                cnt++;
            } else {
                cnt--;
            }
            
            if (cnt > maxCnt) {
                maxCnt = cnt;
                res = timeStamp.time;
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[][] logs = {{1993, 1999}, {2000, 2010}};
        System.out.println(new Solution().maximumPopulation(logs));
    }
}
