public class Solution {
    /**
     * @param s: string
     * @return: sort string in lexicographical order
     */
    public String sorting(String s) {
        // write your code here
        String[] ss = s.split(",");
        quickSort(ss, 0, ss.length - 1);
        return String.join(",", ss);
    }
    
    private void quickSort(String[] ss, int l, int r) {
        if (l >= r) {
            return;
        }
        
        swap(ss, l, l + (r - l >> 1));
        String piv = ss[l];
        
        int i = l, j = r;
        while (i < j) {
            while (i < j && ss[j].compareTo(piv) >= 0) {
                j--;
            }
            ss[i] = ss[j];
            while (i < j && ss[i].compareTo(piv) <= 0) {
                i++;
            }
            ss[j] = ss[i];
        }
        
        ss[i] = piv;
        
        quickSort(ss, l, i - 1);
        quickSort(ss, i + 1, r);
    }
    
    private void swap(String[] ss, int i, int j) {
        String tmp = ss[i];
        ss[i] = ss[j];
        ss[j] = tmp;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().sorting("bb,aa,lintcode,c"));
    }
}
