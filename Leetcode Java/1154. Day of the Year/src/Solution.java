public class Solution {
    public int dayOfYear(String date) {
        String[] ss = date.split("-");
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (isLeap(Integer.parseInt(ss[0]))) {
            days[1] = 29;
        }
        
        int month = Integer.parseInt(ss[1]), day = Integer.parseInt(ss[2]), res = 0;
        for (int i = 0; i < month - 1; i++) {
            res += days[i];
        }
        
        return res + day;
    }
    
    boolean isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }
}
