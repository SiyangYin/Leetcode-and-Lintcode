public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int start = 1, end = n;
        while (start + 1 < end) {
            int mid = start + ((end - start) >> 1);
            if (isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        if (isBadVersion(start)) {
            return start;
        } else {
            return end;
        }
    }
}

class VersionControl {
    boolean isBadVersion(int version) {
        return false;
    }
}

