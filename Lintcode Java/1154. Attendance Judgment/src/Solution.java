public class Solution {
    /**
     * @param record: Attendance record.
     * @return: If the student should be punished return true, else return false.
     */
    public boolean judge(String record) {
        // Write your code here.
        if (record.contains("LLL")) {
            return true;
        }
        
        int D = 0;
        for (int i = 0; i < record.length(); i++) {
            D += record.charAt(i) == 'D' ? 1 : 0;
        }
        
        return D >= 2;
    }
}
